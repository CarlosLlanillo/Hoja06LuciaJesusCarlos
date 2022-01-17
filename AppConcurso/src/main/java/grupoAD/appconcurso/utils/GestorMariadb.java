package grupoAD.appconcurso.utils;

import grupoAD.appconcurso.modelos.Pregunta;
import grupoAD.appconcurso.modelos.Respuesta;
import grupoAD.appconcurso.modelos.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class GestorMariadb
{
    private Connection bd = Conexion.getInstance().getConnection();

    public void insertarPreguntas(List<Pregunta> listpreguntas)
    {
        try
        {
            listpreguntas = comprobarQueNoExisteLaPregunta(listpreguntas);
            if (listpreguntas.isEmpty())
                return;

            String textSQLPregunta = "select id,enunciado,categoria,nivel "
                                     + "from preguntas limit 0";
            PreparedStatement ps = bd.prepareStatement(textSQLPregunta,
                                                       ResultSet.TYPE_SCROLL_SENSITIVE,
                                                       ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ps.executeQuery();
            for (Pregunta pregunta : listpreguntas)
            {
                rs.moveToInsertRow();
                rs.updateString("enunciado", pregunta.getEnunciado());
                rs.updateString("categoria", pregunta.getCategoria());
                rs.updateInt("nivel", pregunta.getNivel());
                rs.insertRow();

                insertarRespuestas(pregunta.getRespuestas(), rs.getInt("id"));
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(GestorFicheros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private List<Pregunta> comprobarQueNoExisteLaPregunta(List<Pregunta> listPreguntas) throws SQLException
    {
        String textSQL = "select enunciado "
                         + "from preguntas "
                         + "where enunciado = ?";
        PreparedStatement ps = bd.prepareStatement(textSQL);
        Iterator<Pregunta> it = listPreguntas.iterator();
        while (it.hasNext())
        {
            Pregunta pregunta = it.next();
            ps.setString(1, pregunta.getEnunciado());
            if (ps.executeQuery().next())
                it.remove();
        }
        return listPreguntas;
    }

    private void insertarRespuestas(List<Respuesta> listRespuestas, int preguntaId) throws SQLException
    {
        String textSQL = "insert into respuestas(pregunta_id,texto,correcta) "
                         + "values (?,?,?)";
        PreparedStatement ps = bd.prepareStatement(textSQL);
        for (Respuesta respuesta : listRespuestas)
        {
            ps.setInt(1, preguntaId);
            ps.setString(2, respuesta.getTexto());
            ps.setInt(3, (respuesta.isCorrecta() ? 1 : 0));
            ps.executeUpdate();
        }
    }

    public Usuario logInUsuario(String usuario, String password)
    {
        try
        {
            String textSQLPregunta = "select u.id,u.usuario,u.password,u.nombre,u.apellidos,u.fecha_nacimiento,u.num_accesos,u.test_realizados,u.puntuacion_media "
                                     + "from usuarios u "
                                     + "where usuario = ? and password = md5(?)";
            PreparedStatement ps = bd.prepareStatement(textSQLPregunta,
                                                       ResultSet.TYPE_SCROLL_SENSITIVE,
                                                       ResultSet.CONCUR_UPDATABLE);
            ps.setString(1, usuario);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                int usuarioId = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                LocalDate nacimiento = rs.getDate("fecha_nacimiento").toLocalDate();
                int accesos = rs.getInt("num_accesos") + 1;
                int testRealizados = rs.getInt("test_realizados");
                int puntuacionMedia = rs.getInt("puntuacion_media");
                rs.updateInt("num_accesos", accesos);
                rs.updateRow();
                return new Usuario(usuarioId, usuario, password, nombre, apellidos,
                                   nacimiento, accesos, testRealizados, puntuacionMedia);
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(GestorFicheros.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Pregunta> obtenerPreguntas(int cantidad)
    {
        LinkedList<Pregunta> listPreguntas = new LinkedList();
        try
        {
            String textSQLPregunta = "select id,enunciado,categoria,nivel,veces_formulada,veces_acertada "
                                     + "from preguntas "
                                     + "order by rand() "
                                     + "limit ?";
            PreparedStatement ps = bd.prepareStatement(textSQLPregunta);
            ps.setInt(1, cantidad);
            ResultSet rsPreguntas = ps.executeQuery();
            while (rsPreguntas.next())
            {
                int preguntaId = rsPreguntas.getInt("id");
                String enunciado = rsPreguntas.getString("enunciado");
                String categoria = rsPreguntas.getString("categoria");
                int nivel = rsPreguntas.getInt("nivel");
                int vecesFormulada = rsPreguntas.getInt("veces_formulada");
                int vecesAcertada = rsPreguntas.getInt("veces_acertada");
                Pregunta pregunta = new Pregunta(preguntaId, enunciado, categoria, nivel, "",
                                                 vecesFormulada, vecesAcertada);
                obtenerRespuestas(pregunta);
                listPreguntas.add(pregunta);
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(GestorFicheros.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listPreguntas;
    }

    private void obtenerRespuestas(Pregunta pregunta) throws SQLException
    {
        String textSQL = "select id,texto,correcta,veces_respondida "
                         + "from respuestas "
                         + "where pregunta_id = ?";
        PreparedStatement ps = bd.prepareStatement(textSQL);
        ps.setInt(1, pregunta.getPreguntaId());
        ResultSet rsRespuestas = ps.executeQuery();
        while (rsRespuestas.next())
        {
            int respuestaId = rsRespuestas.getInt("id");
            String texto = rsRespuestas.getString("texto");
            boolean correcta = rsRespuestas.getInt("correcta") != 0;
            int vecesRespondida = rsRespuestas.getInt("veces_respondida");
            pregunta.getRespuestas().add(new Respuesta(respuestaId, texto, correcta, "",
                                                       vecesRespondida));
        }
    }

    private List<Pregunta> cargarPreguntasCategoria(String categoria)
    {
        List<Pregunta> preguntas = new ArrayList();
        try
        {
            String textSQLPregunta = "select id,enunciado,categoria,nivel from preguntas where categoria=? order by rand() limit 5";
            PreparedStatement ps = bd.prepareStatement(textSQLPregunta);
            ps.setString(1, categoria);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                Pregunta pregunta = new Pregunta();
                pregunta.setPreguntaId(rs.getInt("id"));
                pregunta.setEnunciado(rs.getString("enunciado"));
                pregunta.setCategoria(rs.getString("categoria"));
                pregunta.setNivel(rs.getInt("nivel"));

                List<Respuesta> respuestas = new ArrayList();
                String textSQLRespuesta = "select id,texto,correcta from respuestas where pregunta_id=" + rs.getInt(
                        "id");
                PreparedStatement psr = bd.prepareStatement(textSQLRespuesta);
                ResultSet rsr = psr.executeQuery();
                while (rsr.next())
                {
                    Respuesta respuesta = new Respuesta();
                    respuesta.setRespuestaId(rsr.getInt("id"));
                    respuesta.setTexto(rsr.getString("texto"));
                    respuesta.setCorrecta(rsr.getBoolean("correcta"));
                    respuestas.add(respuesta);
                }
                pregunta.setRespuestas(respuestas);
                preguntas.add(pregunta);
            }

        } catch (SQLException ex)
        {
            Logger.getLogger(GestorFicheros.class.getName()).log(Level.SEVERE, null, ex);
        }

        return preguntas;
    }

    public void VisualizarPreguntasDeUnaCategoria(String categoria)
    {
        Scanner teclado = new Scanner(System.in);
        List<Pregunta> preguntas = cargarPreguntasCategoria(categoria);

        for (Pregunta pregunta : preguntas)
        {
            System.out.println(pregunta.getEnunciado());
            List<Respuesta> respuestas = pregunta.getRespuestas();
            for (Respuesta respuesta : respuestas)
            {
                System.out.println(respuesta.getTexto());
            }
            teclado.nextLine();

        }
    }
}

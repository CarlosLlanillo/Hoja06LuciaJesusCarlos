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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class GestorMariadb
{
    private Connection bd = Conexion.getInstance().getConnection();

    public void insertarPreguntasConRespuesta(List<Pregunta> preguntas)
    {
        try
        {
            String textSQLPregunta = "select id,enunciado,categoria,nivel from preguntas limit 0";
            PreparedStatement ps = bd.prepareStatement(textSQLPregunta,
                                                       ResultSet.TYPE_SCROLL_SENSITIVE,
                                                       ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ps.executeQuery();
            for (Pregunta pregunta : preguntas)
            {
                rs.moveToInsertRow();
                rs.updateString("enunciado", pregunta.getEnunciado());
                rs.updateString("categoria", pregunta.getCategoria());
                rs.updateInt("nivel", pregunta.getNivel());
                rs.insertRow();
                pregunta.setPreguntaId(rs.getInt("id"));

                String textSQLRespuesta = "insert into respuestas(pregunta_id,texto,correcta) values (?,?,?)";
                ps = bd.prepareStatement(textSQLRespuesta);
                for (Respuesta respuesta : pregunta.getRespuestas())
                {
                    ps.setInt(1, pregunta.getPreguntaId());
                    ps.setString(2, respuesta.getTexto());
                    ps.setInt(3, (respuesta.isCorrecta() ? 1 : 0));
                    ps.executeUpdate();
                }
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(GestorFicheros.class.getName()).log(Level.SEVERE, null, ex);
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

    public void obtenerPreguntas(int cantidad)
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
    }

    private void obtenerRespuestas(Pregunta pregunta) throws SQLException
    {
        String textSQL = "select id,texto,correcta,veces_respondida from respuestas where pregunta_id = ?";
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
}

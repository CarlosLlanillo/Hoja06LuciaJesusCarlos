package grupoAD.appconcurso.utils;

import grupoAD.appconcurso.modelos.Pregunta;
import grupoAD.appconcurso.modelos.Respuesta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

    public void insertarPreguntasConRespuesta(List<Pregunta> preguntas)
    {
        try
        {
            Connection bd = Conexion.getInstance().getConnection();
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
            Logger.getLogger(gestorFicheros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private List<Pregunta> cargarPreguntasCategoria(String categoria){
        List<Pregunta> preguntas=new ArrayList();
        try
        {
            Connection bd = Conexion.getInstance().getConnection();
            String textSQLPregunta = "select id,enunciado,categoria,nivel from preguntas where categoria=? order by rand() limit 5";
            PreparedStatement ps = bd.prepareStatement(textSQLPregunta);
            ps.setString(1, categoria);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Pregunta pregunta=new Pregunta();
                pregunta.setPreguntaId(rs.getInt("id"));
                pregunta.setEnunciado(rs.getString("enunciado"));
                pregunta.setCategoria(rs.getString("categoria"));
                pregunta.setNivel(rs.getInt("nivel"));
                
                List<Respuesta> respuestas=new ArrayList();
                String textSQLRespuesta = "select id,pregunta_id,texto,correcta from respuestas where pregunta_id="+rs.getInt("id");
                PreparedStatement psr = bd.prepareStatement(textSQLRespuesta);
                ResultSet rsr=psr.executeQuery();
                while(rsr.next()){
                    Respuesta respuesta=new Respuesta();
                    respuesta.setRespuestaId(rsr.getInt("id"));
                    respuesta.setPreguntaId(rsr.getInt("pregunta_id"));
                    respuesta.setTexto(rsr.getString("texto"));
                    respuesta.setCorrecta(rsr.getBoolean("correcta"));
                    respuestas.add(respuesta);
                }
                pregunta.setRespuestas(respuestas);
                preguntas.add(pregunta);
            }
            
        } catch (SQLException ex)
        {
            Logger.getLogger(gestorFicheros.class.getName()).log(Level.SEVERE, null, ex);
        }   
       
        return preguntas;
    }
    
    public void VisualizarPreguntasDeUnaCategoria(String categoria){
        Scanner teclado=new Scanner(System.in);
        List<Pregunta> preguntas=cargarPreguntasCategoria(categoria);
        
        for(Pregunta pregunta:preguntas){
            System.out.println(pregunta.getEnunciado());
            List<Respuesta> respuestas=pregunta.getRespuestas();
            for(Respuesta respuesta:respuestas){
                System.out.println(respuesta.getTexto());
            }
            teclado.nextLine();
            
        }
    }
}

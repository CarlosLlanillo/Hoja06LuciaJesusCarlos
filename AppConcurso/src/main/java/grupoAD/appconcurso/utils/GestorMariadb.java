package grupoAD.appconcurso.utils;

import grupoAD.appconcurso.modelos.Pregunta;
import grupoAD.appconcurso.modelos.Respuesta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
}

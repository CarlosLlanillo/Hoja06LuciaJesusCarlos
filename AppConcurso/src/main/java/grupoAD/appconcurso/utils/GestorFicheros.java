package grupoAD.appconcurso.utils;

import grupoAD.appconcurso.modelos.Pregunta;
import grupoAD.appconcurso.modelos.Respuesta;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author usuario
 */
public class GestorFicheros
{
    public static List<Pregunta> leerPreguntasCSV()
    {
        LinkedList<Pregunta> preguntas = new LinkedList();

        try ( BufferedReader lector = Files.newBufferedReader(Path.of("../csv/preguntas.csv"));)
        {
            while (lector.ready())
            {
                String[] linea = lector.readLine().split(";");
                if (linea[0].equals("P"))
                {
                    Pregunta pregunta = new Pregunta();
                    pregunta.setEnunciado(linea[1]);
                    pregunta.setCategoria(linea[2]);
                    pregunta.setNivel(Integer.parseInt(linea[3]));
                    preguntas.add(pregunta);
                } else
                {
                    Respuesta respuesta = new Respuesta();
                    respuesta.setTexto(linea[1]);
                    respuesta.setCorrecta(linea[2].equals("1"));
                    preguntas.getLast().getRespuestas().add(respuesta);
                }
            }
        } catch (IOException ex)
        {
            System.out.println("Error al leer el csv");
        }
        return preguntas;
    }
}

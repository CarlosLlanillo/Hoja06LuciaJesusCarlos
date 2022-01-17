package grupoAD.appconcurso;

import grupoAD.appconcurso.utils.GestorMariadb;
import java.util.List;

/**
 *
 * @author jesus
 */
public class main {
    public static void main(String[] args){
        GestorMariadb ges=new GestorMariadb();
        
        ges.VisualizarPreguntasDeUnaCategoria("HIS");
        
        
    }
}

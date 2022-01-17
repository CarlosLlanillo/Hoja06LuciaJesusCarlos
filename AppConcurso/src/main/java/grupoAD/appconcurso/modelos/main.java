package grupoAD.appconcurso.modelos;

import grupoAD.appconcurso.utils.GestorMariadb;
import java.util.List;

/**
 *
 * @author usuario
 */
public class main {
    public static void main(String[] args){
        GestorMariadb ges=new GestorMariadb();
        
        ges.VisualizarPreguntasDeUnaCategoria("HIS");
        
        
    }
}

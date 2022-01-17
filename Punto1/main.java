package grupoAD.appconcurso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class main
{
    public static void main(String[] args)
    {
        Connection con = Conexion.getConnection();

        if (con != null) {

            GestorConexion gc = new GestorConexion((java.sql.Connection) con);
            Scanner tec = new Scanner(System.in);
            int n = 0;
            boolean acceso;
            
            System.out.println("Usuario: ");
            String usu = tec.nextLine();
            System.out.println("Contraseña: ");
            String pwd = tec.nextLine();
            acceso = gc.validarUsuario(usu, pwd);
            if (acceso) {
                System.out.println("Iniciada sesion para " + usu);
            } else {
                System.out.println("Error en credenciales");
            }
        }
    }


}
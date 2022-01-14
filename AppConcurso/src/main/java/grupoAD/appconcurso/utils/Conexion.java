package grupoAD.appconcurso.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ivan
 */
public class Conexion
{

    private static Conexion instance;
    private Connection db;
    private final String urlMariadb = "jdbc:mariadb://localhost:3310/preguntastest";
    private final String usernameMariadb = "root";
    private final String passwordMariadb = "root";

    private Conexion()
    {
        try
        {
            //Class.forName("org.mariadb.jdbc");
            db = DriverManager.getConnection(urlMariadb, usernameMariadb, passwordMariadb);
            return;
        } catch (SQLException /*| ClassNotFoundException*/ ex)
        {

        }
        System.err.println("Error al cargar el driver");
    }

    public Connection getConnection()
    {
        return db;
    }

    public static Conexion getInstance()
    {
        try
        {
            if (instance == null)
            {
                instance = new Conexion();
            } else if (instance.getConnection().isClosed())
            {
                instance = new Conexion();
            }
        } catch (SQLException ex)
        {
            System.err.println("Error al obtener la conexion con la base de datos");
        }
        return instance;
    }
}

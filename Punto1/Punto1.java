/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupoAD.appconcurso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ningu
 */
public class Punto1 {
    Connection con;

    Punto1(Connection con) {
        this.con = con;
    }
    
    public boolean validarUsuario(String u, String p) {
        boolean accesoOk = false;
        PreparedStatement prst = null;
        ResultSet r = null;
        String sql = "SELECT count(*) FROM usuarios WHERE usuario=? AND passwd=md5(?)";
        try {
            prst = con.prepareStatement(sql);
            prst.setString(1, u);
            prst.setString(2, p);
            r = prst.executeQuery();
            r.next();
            if (r.getInt(1) == 1) {
                accesoOk = true;
            }
            r.close();
            prst.close();

        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getErrorCode() + " - " + e.getMessage());
        }
        return accesoOk;
    }
}

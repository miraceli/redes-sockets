/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Mira
 */
public class Conector {

    private static Connection con;

    public static Connection getConnection() {
        try {

            String url = "jdbc:mysql://localhost:3306/";
            String banco = "pontos";
            String usuario = "root";
            String senha = "mysql";

            con = DriverManager.getConnection(url + banco, usuario, senha);
            return con;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }

    }
}

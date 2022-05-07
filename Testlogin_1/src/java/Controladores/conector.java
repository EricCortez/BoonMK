/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oswal
 */
public class conector {


    public static Connection conectar() {

        Connection cn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inicio", "root","Some3010.*");

        } catch (SQLException e) {

            System.out.print("Error en la conexion " + e);

        } catch (ClassNotFoundException ex) {

            Logger.getLogger(conector.class.getName()).log(Level.SEVERE, null, ex);

        }

        return cn;
    }
}

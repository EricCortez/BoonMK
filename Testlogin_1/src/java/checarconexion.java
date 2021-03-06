
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author oswal
 */
public class checarconexion {
    
    public static void main(String[] args) {
    String url = "jdbc:mysql://localhost:3306"; //pointing to no database.
    String username = "root";
    String password = "Some3010.*";

    System.out.println("Connecting to server...");

    try (Connection connection = DriverManager.getConnection(url, username, password)) {
        System.out.println("Server connected!");
        Statement stmt = null;
        ResultSet resultset = null;

        try {
            stmt = connection.createStatement();
            resultset = stmt.executeQuery("SHOW DATABASES;");

            if (stmt.execute("SHOW DATABASES;")) {
                resultset = stmt.getResultSet();
            }

            while (resultset.next()) {
                System.out.println(resultset.getString("Database"));
            }
        }
        catch (SQLException ex){
            // handle any errors
            ex.printStackTrace();
        }
        finally {
            // release resources
            if (resultset != null) {
                try {
                    resultset.close();
                } catch (SQLException sqlEx) { }
                resultset = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) { }
                stmt = null;
            }

            if (connection != null) {
                connection.close();
            }
        }
    } catch (SQLException e) {
        throw new IllegalStateException("Cannot connect the server!", e);
    }
}
    
}

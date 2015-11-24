/*
This class manages the database access.
If the database does not exist then it is created
There are a series of getters and setters to set and retrieve data
from the database.
 */
package millerpintgame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author David Crosbie
 */
public class Database {
    
    // databaseName = "jdbc.mysql://localhost/MillerLiteGame";
    // databaseUser = "admin";
    // databasePassword = "password";
    
    public static int dCreate(String databaseName, String databaseUser, String databasePassword )  
        throws SQLException, ClassNotFoundException {
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Database loaded");

            // Connect to an existing database 
            Connection connection = DriverManager.getConnection
                  (databaseName,databaseUser,databasePassword );
            System.out.println("Database connected");

            // Create a statement
            Statement statement = connection.createStatement();
    
            // Now we have a database connected and we can use connection to ferry commands
            
            String sqlCommand;
            sqlCommand = " CREATE SCHEMA IF NOT EXISTS + 'game' " +
                  "DEFAULT CHARACTER SET utf8 ;\n" +
                  "USE `mydb` ;";
            
            statement.executeUpdate(sqlCommand);
            System.out.println("Database created successfully...");
            return 0;

            
        }   // end of try
        catch (SQLException ex) {
            int databaseError = ex.getErrorCode();
            return (databaseError);
                }
        finally {
            // do nothing
        }   // end of finally

   }       // end of throw
    
}   // end of class

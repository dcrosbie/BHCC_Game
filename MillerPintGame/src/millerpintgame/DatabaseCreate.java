/*
This class manages the database access.
If the database does not exist then it is created
Need to pass the database location, username, and password
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
public class DatabaseCreate {
    
    
    // Pre - Must supply:
    // databaseName = "jdbc.mysql://localhost/MillerLiteGame";
    // databaseUser = "admin";
    // databasePassword = "password
    
    // Function returns 0 if it creates successfully
    // It returns an error code if there is an SQL failure
    
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
            
            // Now create the schema called 'games'
            
            String sqlCommand;
            sqlCommand = " CREATE SCHEMA IF NOT EXISTS 'games' " +
                  "DEFAULT CHARACTER SET utf8 ;\n" +
                  "USE `game` ;";
            
            statement.executeUpdate(sqlCommand);
            System.out.println("Database schema created successfully...");
            
            // Now create the GAMES table in the 'games' schema
            // Each game has a state. GAME_STATE
            // State 0 is created but not started
            // State 10 is playing
            // State 20 is ended
            
               
            sqlCommand = " CREATE TABLE IF NOT EXISTS 'games', 'GAMES' {" +
            "`idGAME` INT UNSIGNED NOT NULL AUTO_INCREMENT," +
            "`GAME_NAME` VARCHAR(45) NULL DEFAULT '\\\"Standard\\\"'," +
            "`GAME_STATE` INT UNSIGNED NOT NULL," +
            "PRIMARY KEY ('idGAME'), ENGINE = InnoDB ";
            
            statement.executeUpdate(sqlCommand);
            System.out.println("Database table GAMES created");
            
            // Create the PLAYERS table
            // Each player has a Name that must be unique
            
            sqlCommand = " CREATE TABLE IF NOT EXISTS 'games', 'PLAYERS' {" +
            "`idPLAYER` INT UNSIGNED NOT NULL AUTO_INCREMENT," +
            "`PLAYER_NAME` VARCHAR(45) NULL DEFAULT '\\\"John Doe\\\"'," +
            "`idRULES` INT UNSIGNED NOT NULL ," +
            "PRIMARY KEY ('idPLAYER')," +
            "ENGINE = InnoDB ";
                        
            statement.executeUpdate(sqlCommand);
            System.out.println("Database table GAMES created");
            
            // Now create a ROUNDS table
            // This table stores the round and the associated scores
            // There is a unique ID for each round
            // The Foreign Keys are the idGAME and the idPLAYER
            
            sqlCommand = " CREATE TABLE IF NOT EXISTS 'games', 'ROUNDS' {" +
            "`idROUND` INT UNSIGNED NOT NULL AUTO_INCREMENT," +
            " INT UNSIGNED NOT NULL," +
            "`idPLAYER` INT UNSIGNED NOT NULL," +
            "`SCORE` INT UNSIGNED NOT NULL," +
            "FOREIGN KEY {`idGAME`) REFERENCES   " +
            "PRIMARY KEY ('idROUND'), ENGINE = InnoDB ";       
                  
            statement.executeUpdate(sqlCommand);
            System.out.println("Database table ROUNDS created");
            
            // The RULES table specifies the rules for that particular game
            sqlCommand = " CREATE TABLE IF NOT EXISTS 'games', 'RULES' {" + 
            "`idRULES` INT UNSIGNED NOT NULL AUTO_INCREMENT," +                    
            "PRIMARY KEY ('idRULES'), ENGINE = InnoDB ";        
                               
            statement.executeUpdate(sqlCommand);
            System.out.println("Database table RULES created");  
            
            // The LABELS database stores text for the application
            // in various languages
            // I think the primary key is idLABEL plus LANGUAGE
            
            
            sqlCommand = " CREATE TABLE IF NOT EXISTS 'games', 'LABELS' {" +
            "`idLABEL` INT UNSIGNED NOT NULL," +
            "`LANGUAGE` VARCHAR(45) NULL DEFAULT '\\\"English\\\"'," +
            "`LABEL` VARCHAR(128) NULL DEFAULT '\\\"Empty\\\"'," +
            "PRIMARY KEY ('idLABEL'), ENGINE = InnoDB ";
            
            statement.executeUpdate(sqlCommand);
            System.out.println("Database table LABELS created");  
            
            /*
            FOREIGN KEY (`idROUNDS`)
            REFERENCES `mydb`.`Games` (`Game_ID`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION)

            */
                    
            statement.close();
            connection.close();
            return 0;
            
        }   // end of try
        catch (SQLException ex) {
            int databaseError = ex.getErrorCode();
            return (databaseError);
                }
        finally {
            // nothing
        }   // end of finally

   }       // end of throw
    
}   // end of class


/*
 *Connect to the game database..
 *This class will be used as generale class to connect to Database.
 */
package ConnectToDB;
import java.sql.*;

/**
 *
 * @author Soukaina
 */
public class ConnecToDB {
    
    private Connection connect;
    private Statement stm;
    
    
    //Create a constructor
    public ConnecToDB()
    {
        //Database url, database location in the host. Use localhost if the database in your computer. 
        String url="jdbc:mysql://localhost:3306/BHCCgame"; 
        String username="root";
        String password="password";// password in your computer
        
        try {
            // connect to the Driver Manager using personal username and password for the localhost
            Class.forName("com.mysql.jdbc.Driver");
            connect=DriverManager.getConnection(url,username,password);
            stm=connect.createStatement();
           
        }catch (SQLException | ClassNotFoundException  ex)
        {
            // Error message if connection is failed 
            System.out.println(ex.getMessage());
        }
    }

// getters and setters to get the software transactional memory (STM) and connection
    public Connection getConnect() {
        return connect;
    }

    public void setConnect(Connection connect) {
        this.connect = connect;
    }

    public Statement getStm() {
        return stm;
    }

    public void setStm(Statement stm) {
        this.stm = stm;
    }

   
    
}

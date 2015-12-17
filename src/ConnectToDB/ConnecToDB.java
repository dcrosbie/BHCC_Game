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
        //Database url, database location in the host. use localhost if the database in your computer. 
        String url="jdbc:mysql://173.194.235.163:3306/BHCCgame"; 
        String username="scott";
        String password="tiger";// or password in your computer
        
        try {
            // connect to the driver manager
            Class.forName("com.mysql.jdbc.Driver");
            connect=DriverManager.getConnection(url,username,password);
            stm=connect.createStatement();
        }
        // Catch execetion and print an error message
        catch (SQLException | ClassNotFoundException  ex)
        {
            System.out.println(ex.getMessage());
        }
    }
// get connection
    public Connection getConnect() {
        return connect;
    }
// set connection
    public void setConnect(Connection connect) {
        this.connect = connect;
    }
// get stm (software transactional memory)
    public Statement getStm() {
        return stm;
    }
// set stem (software transactional memory)
    public void setStm(Statement stm) {
        this.stm = stm;
    }

  
    
}

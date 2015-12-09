/*
 *Connect to the game database..
 *This class will be used as generale class to connect to Database.
 */
package ConnectToDB;
import java.sql.*;

/**
 *
 * @author rachid
 */
public class ConnecToDB {
    
    private Connection connect;
    private Statement stm;
    
    
    //Create a constructor
    public ConnecToDB()
    {
        String url="jdbc:mysql://173.194.235.163:3306/BHCCgame"; //Database url, database location in the host. use localhost if the database in your computer. 
        String username="scott";
        String password="tiger";
        
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            connect=DriverManager.getConnection(url,username,password);
            stm=connect.createStatement();
           
        }catch (SQLException | ClassNotFoundException  ex)
        {
            System.out.println(ex.getMessage());
        }
    }

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

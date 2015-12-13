package sample;

//this is to connect to the DB with standard error catches
//written by Blake DeLee
//just use DBConnect.connect() to create an instance of a connection in your code


import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class DBConnect {
    private static Connection conn;
    private static String url = "jdbc:mysql://173.194.235.163:3306/BHCCgame";
    private static String user = "scott";
    private static String pass = "tiger";

    public static Connection connect() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch(ClassNotFoundException cnfe){
            System.err.println("Error: " + cnfe.getMessage());
        } catch(InstantiationException ie){
            System.err.println("Error :" + ie.getMessage());
        }catch(IllegalAccessException iae){
            System.err.println("Error: "+iae.getMessage());
        }

        conn = DriverManager.getConnection(url,user,pass);
        return conn;
    }
    public static Connection getConnection() throws SQLException, ClassNotFoundException{
        if(conn !=null && !conn.isClosed())
        return conn;
        connect();
        return conn;

    }
}




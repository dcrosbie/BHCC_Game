
 
package userIO;
import java.util.*;
import ConnectToDB.ConnecToDB; // Import my ConnectToDB pakage
import java.sql.*;
/**
 *
 * @author Soukaina
 */
 
 // UserIO  conains methods that manipulates the data 
 //in the user table in the game database
public class UserIO {
  
    private ResultSet res;
    private User user=new User();
    private ArrayList<User> users=new ArrayList<>();  
    
   //Create a default constructor 
    public UserIO()
    {
      
    }
          
    // This method read all users records from user table in BHCCgame datebase 
    // and save all the records inside an arraylist
    
    public void readUsers(ConnecToDB conn)
    {
        // Create a query 
        String query="SELECT * FROM PLAYER";
        
        try
        {
            res=conn.getStm().executeQuery(query);
            while(res!=null)
            {
                user=new User(res.getInt(1), res.getString(2));
                users.add(user);
            }
        }catch (SQLException exception)
        {
            System.out.println(exception.getMessage());
        }
    }
    
    
    //This method accept a username as a paramter to go look in the array list return
    //by readusers() methods above and see if the username existe or not. 
   
   public int checkTheUserOut(String username)
   {
       int userId=0;
      for (int i=0; i<users.size(); i++)
      {
          if(username.equals(users.get(i).getUsername()))
          {
              userId=users.get(i).getUserId();
          }
      }
      return userId;
   }
}

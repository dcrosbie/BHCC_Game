
package userIO; // import userIO package
import java.util.*;
import ConnectToDB.ConnecToDB; // import connection class (ConnecToDB) in the ConnectToDB package
import java.sql.*;
/**
 *
 * @author Soukaina
 */
public class UserIO {
  
    private ResultSet res;
    private User user=new User(); // create an object of type user
    private ArrayList<User> users=new ArrayList<>();  // create arraylist to hold data from user table
    
   //Create a default constructor 
    public UserIO()
    {
        
    }
          
    //This method read all users records from user table in BHCCgame datebase and save all the records in an arraylist
    public void readUsers(ConnecToDB conn)
    {
         
        //Create a query 
        String query="SELECT * FROM PLAYER";
        
        try
        {
          // get all the users' names and IDs into an array
            res=conn.getStm().executeQuery(query);
            while(res.next())
            {
                user=new User(res.getInt(1), res.getString(2));
                users.add(user);
            }
        }catch (SQLException exception)
        {
            System.out.println(exception.getMessage());
        }
    }
    
    //This method accept a username as a paramter to check if it exist in 
    //the array list returned by readusers() methods above.
    
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
      return userId; // returns the ID if found
   }
}

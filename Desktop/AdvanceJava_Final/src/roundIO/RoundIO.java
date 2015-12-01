/*
  *RoundIO class conains methods that manipulates the data in round table in BHCCgame database .... 
 */
package roundIO;
import java.sql.*;
import ConnectToDB.ConnecToDB;
import java.util.ArrayList;

public class RoundIO {
   
    private ResultSet res;
    
    
    //Default constructor
    public RoundIO()
    {
        
    }
   
    //Create a method to read round recods from Database....
    public ArrayList<Round> readRounds (ConnecToDB connect)
    {
        //Create a Round object 
        Round round =new Round();
        
        ArrayList<Round> roundRecords=new ArrayList<>();
        
       //Create a query to select all records from round table
       String query="SELECT * FROM PLAYER";
       
       try{
           //Save result to res
            res=connect.getStm().executeQuery(query);
            
            while(res!=null)
            {
                round=new Round(res.getInt(1), res.getString(2));
                roundRecords.add(round);
            }
       
       }catch(SQLException exception)
       {
          System.out.println(exception.getMessage());
       }
       
      return roundRecords;
      
    }
    
}

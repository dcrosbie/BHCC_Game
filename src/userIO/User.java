/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userIO;
import java.sql.*;
import ConnectToDB.ConnecToDB;
import java.util.ArrayList;

/**
 *
 * @author Soukaina
 */
public class User {
 
    private int userId;
    private String username;
  
    
    public User()
    {
        
    }
    
    public User (int userId, String username)
    {
        this.userId=userId;
        this.username=username;
        
    }
    
  //getters and setters 
   void setUserId(int id)
   {
       userId=id;
   }
  void setUserName(String username)
  {
      this.username=username;
  }
  
  int getUserId()
  {
      return userId;
  }
  String getUsername()
  {
      return username;
  }
}

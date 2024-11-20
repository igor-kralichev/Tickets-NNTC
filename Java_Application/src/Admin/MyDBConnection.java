/*
 * MyDBConnection.java
 *
 * Created on 2005/01/16, 10:50
 */

package Admin;

import java.sql.*;

/**
 *
 * @author noniko
 */
public class MyDBConnection {
   
    private Connection myConnection;
    
    /** Creates a new instance of MyDBConnection */
    public MyDBConnection() {

    }
    
    public void init(){
    
       try{
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        myConnection=DriverManager.getConnection(
                "jdbc:mysql://web161:3306/emsh_isip_22?zeroDateTimeBehavior=convertToNull&serverTimezone=UTC","emsh_isip_22", "123456"
                );
        }
        catch(ClassNotFoundException | SQLException e){
            System.out.println("Failed to get connection");
        }
    }
    
    
    public Connection getMyConnection(){
        return myConnection;
    }
    
    
    public void close(ResultSet rs){
        
        if(rs !=null){
            try{
               rs.close();
            }
            catch(SQLException e){}
        
        }
    }
    
     public void close(java.sql.Statement stmt){
        
        if(stmt !=null){
            try{
               stmt.close();
            }
            catch(SQLException e){}
        
        }
    }
     
  public void destroy(){
  
    if(myConnection !=null){
    
         try{
               myConnection.close();
            }
            catch(SQLException e){}
        
        
    }
  }
    
}
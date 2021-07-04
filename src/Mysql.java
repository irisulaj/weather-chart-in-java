import java.sql.Connection;
import java.sql.DriverManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author iri_s
 */
public class Mysql {
    public static Connection getConnection(){
    
    Connection conn = null;
    try{ Class.forName("com.mysql.cj.jdbc.Driver");
        conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/weather", "root","");
     
        } 
        
        catch(Exception except){
            except.printStackTrace();
        }
    return conn;
  
    } 
    
}

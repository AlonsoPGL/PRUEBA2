/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package lothel.soft.manager;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author efeproceres
 */
public class DBManager {
    private Connection con;
    private String url = "jdbc:mysql://db-lothel.cjgycpwdcgx4.us-east-1.rds.amazonaws.com:3306/lothel";
    private String user = "admin";
    private String password = "lothel321";
    private static DBManager dbManager;
    
    public static DBManager getInstance(){
        if(dbManager == null){
            createInstance();
        }
        return dbManager;
    }
    
    public Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.
                getConnection(url,user,password);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return con;
    }
    
    private static void createInstance(){
        if(dbManager == null){
            dbManager = new DBManager();    
        }
    }
}

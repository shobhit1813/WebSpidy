/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author shobhit
 */
public class CrawlerDB {
    
    public Connection conn = null;
    
    public CrawlerDB(){
           try{
               Class.forName("com.mysql.jdbc.Driver");
               String url = "jdbc:mysql://localhost:3306/webSpider";
               conn = DriverManager.getConnection(url,"root","1810");
               System.out.println("Connection Built");
               
           } 
           catch(Exception e){
               e.printStackTrace();
           }
    }
    
    public ResultSet runSql(String sql) throws SQLException{
        Statement sta = conn.createStatement();
        return sta.executeQuery(sql);
    }
    
    public boolean runSql2(String sql) throws SQLException{
        Statement sta = conn.createStatement();
        return sta.execute(sql);
    }
    
    protected void finalize() throws Throwable{
        if(conn != null || !conn.isClosed())
            conn.close();
    }
}

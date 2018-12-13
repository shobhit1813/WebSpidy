/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Modal.CrawlerDB;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
/**
 *
 * @author shobhit
 */
public class Crawler {
    
    public static CrawlerDB db = new CrawlerDB();
    
    public static void main(String args[])throws IOException,SQLException{
        
        db.runSql2("Truncate Record");
        processPage("index.html");
    }
    public static void processPage(String url)throws SQLException,IOException{
       
        String sql = "select * from spidy where URL ='"+url+"'";
        ResultSet rs = db.runSql(sql);
        if(rs.next()){
            
        }
        else{
            
        }
        
    }
    
}

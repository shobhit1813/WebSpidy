import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Doc{

    public String parseHtml(String url)throws IOException{
        String str = new String();
        try{

        }
        catch(Exception e){
            Document d = Jsoup.connect(url).get();
            str = d.html();
        }
        return str;
    }
}
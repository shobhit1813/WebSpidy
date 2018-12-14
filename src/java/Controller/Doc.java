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
            Document d = Jsoup.connect(url).get();
            str = d.html();
        }
        catch(IOException e){
            System.out.println(e.toString());
        }
        return str;
    }

    public int writeIntoFile(String str, String dir, int file_no){
        try{
            FileWriter fw = new FileWriter(dir+"/"+file_no+".txt");
            fw.write(str);
            fw.close();
        }
        catch(IOException e){
            System.out.println(e.toString());
        }
        return file_no + 1;
    }

    public String[] addInternalURLToArray(String str, String base_url){
        ArrayList<String> br = new ArrayList<>();
        br.add(base_url);
        Validate v = new Validate();
        int i;
        Document doc = Jsoup.parse(str);
        Elements links = doc.select("a[href]");
        for(Element link:links){
            String url = new String(link.attr("abs:href"));
            if(url.length() > base_url.length()){
                String uptoBaseUrl = url.substring(0,base_url.length());
                if(uptoBaseUrl.contains(base_url) && !br.contains(url))
                    br.add(url);
            }
        }
        return br.toArray(new String[0]);
    }
}
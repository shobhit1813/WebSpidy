import java.net.*;
import java.io.*;

class ValidateDetails{

    //function to check whether url is valid(eg. )
    public int checkURL(String url){
        try{
            URL objurl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection)objurl.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            String url_type = new String(getContentType());
            System.out.prinltn("Content Type of "+url+": "+url_type);
            if(url_type == "text/html")
                return 1;
            
        }
        catch(MalformedURLException e){
            System.out.prinltn(e.toString());
        }
        catch(ProtocolException e){
            System.out.println(e.toString());
        }
        catch(IOException e){
            System.out.println(e.toString());
        }
        return 0;
    }
    public int checkDepth(int depth){

        if(depth >= 0)
            return 1;
        return 0;
    }

    public int checkDirectory(String dir){
        File file = new File(dir);
        if(file.exists() && file.canRead() && file.canWrite() && file.canExecute())
            return 1;
        return 0;
    }
}
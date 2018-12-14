import java.io.IOException;
import java.util.Scanner;


public class Crawler{

    int file_no = 0;
    ValidateDetails valid_check;
    Doc my_doc;
    Hashable h;
    Hash[] my_hash;

    public Crawler(){
        valid_check = new ValidateDetails();
        my_doc = new Doc();
        h = new Hashable();
        my_hash = new Hash[100];

        for(int i = 0; i < my_hash.length; i++){
            my_hash[i] = new Hash();
        }
    }
    public void executeCrawler(String url,String dir, int depth) throws IOException{
        int flag = 0;
        flag = valid_check.checkURL(url) + valid_check.checkDirectory(dir) + valid_check.checkDepth(depth);

        if(flag == 3){
           do{ 
                String html = new String();
                html = my_doc.parseHtml(url);
                file_no = my_doc.writeIntoFile(html, dir,file_no);
                my_hash = h.setLinkInArray(my_hash, my_doc.addInternalURLToArray(html, url));
                my_hash[0].print();

                while(flag != 1){
                    url = new String(h.getNextURL(my_hash,depth));
                    System.out.println(url);
                    if(url.equals("-1"))
                        return;
                    flag = valid_check.checkURL(url);
                }
                flag = 0;
            }while(file_no <1000);
        }
    }
    public static void main(String args[]) throws IOException{
        
        Crawler cw = new Crawler();
        Scanner sc = new Scanner(System.in);
        cw.executeCrawler("https://www.chitkarauniversity.edu.in","home/Desktop/shobhit",2);
    }
}
import java.util.Scanner;

public class Crawler{

    int file_no = 0;
    ValidateDetails valid_check;
    Doc my_doc;
    Hashable h;
    hash[] my_hash;

    public Crawler(){
        valid_check = new Validate();
        my_doc = new Doc();
        h = new Hashable();
        my_hash = new hash[100];

        for(int i = 0; i < my_hash.length; i++){
            my_hash[i] = new hash();
        }
    }
    public void executeCrawler(String url,String dir, int depth){
        int flag = 0;
        flag = valid_check.checkURL(url) + valid_check.checkDirectory(dir) + valid_check.checkDepth(depth);

        if(flag == 3){
           do{ 
                String html = new String();
                html = my_doc.parseHtml(url);
                file_no = my_doc.writeIntoFile(html, dir,file_no);
                my_hash = h.set(my_hash, my_doc.addInternalURLToArray(html, url));
                my_hash[0].print();

                while(flag != 1){
                    url = new String(hash.getNextURL(my_hash,depth));
                    System.out.println(url);
                    if(url.equals("-1"))
                        return;
                    flag = valid_check.checkURL(url);
                }
                flag = 0;
            }while(file_no <1000);
        }
    }
    public static void main(String args[]){
        
        Crawler cw = new Crawler();
        Scanner sc = new Scanner(System.in);
        cw.executeCrawler("https://www.chitkarauniversity.edu.in","home/Desktop/shobhit",2);
    }
}
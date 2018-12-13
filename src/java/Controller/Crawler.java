import java.util.Scanner;

public class Crawler{

    int file_no = 0;
    ValidateDetails valid_check;
    Doc my_doc;
    Hashable hash;
    hash[] my_hash;

    public Crawler(){
        valid_check = new Validate();
        my_doc = new Doc();
        hash = new Hashable();
        my_hash = new hash[100];

        for(int i = 0; i < my_hash.length; i++){
            my_hash[i] = new hash();
        }
    }
    public void executeCrawler(String url,String dir, int depth){
        int flag = 0;
        flag = valid_check.checkURL(url) + valid_check.checkDirectory(dir) + valid_check.checkDepth(depth);

        if(flag == 3){
            String html = new String();
            html = my_doc.getIn(url);
        }
    }
    public static void main(String args[]){
        
        Crawler cw = new Crawler();
        Scanner sc = new Scanner(System.in);
        cw.executeCrawler("index.html/","home/Desktop/NetBeansProjects/WebSpider/web",2);
    }
}
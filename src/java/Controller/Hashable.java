
class Node{
    String url;
    int depth;
    int isvisited;
    Node next;

    Node(String url, int depth, int visit_status){
        this.url = url;
        this.depth = depth;
        this.isvisited = visit_status;
    }
}

class Hash{
    Node start,tail;
    Hash(){
        start = null;
        tail = null;
    }

    public void insert(String url, int depth, int visit_status){
        Node n = new Node(url, depth, visit_status);
        if(start == null){
            start = n;
            tail = n;
        }
        else{
            n.next = start;
            start = n;
        }

    }

    public void print(){
        Node ptr = start;
        int i = 0;
        while(ptr != null){
            System.out.println("Link no:"+i+" depth = "+ptr.depth+" visited = "+ptr.isvisited+" url:"+ptr.url);
            ptr = ptr.next;
            i++;
        }
    }

    public int check(String str){
        if(start == null)
            return 0;
        Node ptr = start;
        while(ptr != tail){
            if(ptr.url.equals(str)){
                return 1;
            }
            ptr = ptr.next;
        }
        if(tail.url.equals(str))
            return 1;
        return 0; 
    }
}
public class Hashable{
    
    int depth = 0;
    int i = 0, j = 0;
    Hash[] link(Hash[] arr){
        for(int i = 0; i < arr.length; i++){
            if(arr[i].tail != null){
                for( j = i + 1; j < arr.length; j++){
                    if(arr[j].start != null)
                        break;  
                }
                arr[i].tail.next = arr[j].start;
            }
        }
        return arr;
    }

    public String getNextURL(Hash []arr,int depth){
        Node ptr = arr[0].start;
        while(ptr != null){
            if(ptr.isvisited == 0 && ptr.depth <= depth){
                ptr.isvisited = 1;
                return ptr.url;
            }
            ptr = ptr.next;
        }
        return "-1";
    }
    public Hash[] setLinkInArray(Hash[] arr, String[] list){
        int index = list[0].length() % 100;
        if(arr[index].check(list[0]) == 0){
            arr[index].insert(list[0], depth, 1);
        }
        for(int i = 0; i < list.length; i++){
            index = list[i].length() % 100;
            if(arr[index].check(list[i]) == 0)
                arr[index].insert(list[i], depth + 1, 0);
        }
        arr = link(arr);
        return arr;
    }
} 





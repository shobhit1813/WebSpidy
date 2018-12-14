
class Node{
    String url;
    int depth;
    int isvisited;
    Node next;
}

class Hash{
    Node start,tail;
    Hash(){
        start = null;
        tail = null;
    }

    public void insert()
}
public class Hashable{
    
    int depth = 0;

    public Hash[] setLinkInArray(Hash[] arr, String[] list){
        int index = list[0].length % 100;
        if(arr[index].check(list[0]) == 0){
            arr[index].insert(list[0], d, 1);
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
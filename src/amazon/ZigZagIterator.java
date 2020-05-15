package amazon;

import java.util.*;

public class ZigZagIterator {
    private Iterator<Integer> i;
    private Iterator<Integer> j;
    private Iterator<Integer> temp;

    public ZigZagIterator(List<Integer> v1, List<Integer> v2){
        i = v1.iterator();
        j = v2.iterator();
    }

    public boolean hasNext(){
        return i.hasNext() || j.hasNext(); 
    }
    
    public int next(){
        if(i.hasNext()){
            temp = i;
            i = j;
            j = temp;
        }

        return j.next();
    }
}
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.LinkedList;

public class tryyy
{
        /** Initialize your data structure here. */
        
        Queue<Integer> q;
        public tryyy() {
            q=new LinkedList<>();
        }
        
        /** Record a hit.
            @param timestamp - The current timestamp (in seconds granularity). */
        public void hit(int timestamp) {
            q.offer(timestamp);
        }
        
        /** Return the number of hits in the past 5 minutes.
            @param timestamp - The current timestamp (in seconds granularity). */
        public int getHits(int timestamp) {
            while(q.size()!=0 && timestamp-q.peek()>=300)
                q.poll();
            return q.size();
        }




    public static void main(String[] args) 
    {
       tryyy tr=new tryyy(); 
       // hit at timestamp 1.
       tr.hit(1);

       // hit at timestamp 2.
       tr.hit(2);

       // hit at timestamp 3.
       tr.hit(3);

       // get hits at timestamp 4, should return 3.
       System.out.println(tr.getHits(4));

       // hit at timestamp 300.
       tr.hit(300);

       // get hits at timestamp 300, should return 4.
       System.out.println(tr.getHits(300));

       // get hits at timestamp 301, should return 3.
       System.out.println(tr.getHits(301));         
    }

}



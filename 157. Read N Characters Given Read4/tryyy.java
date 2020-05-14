import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Stack;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.LinkedList;

public class tryyy extends Reader4 {
{
//////////////////////Others//////////////////////
    /**
     * The read4 API is defined in the parent class Reader4.
     *     int read4(char[] buf);
     */

    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */    
    public int read(char[] buf, int n){
        char[] tmp = new char[4];
        int index=0;
        boolean end=false;
        // two condition for ending this function
        // n is smaller than file's length
        // it meet the end of the file
        while(!end && index<n){
            int count=read4(tmp);
            if(count<4)
                end=true;
            
            count=Math.min(count,n-index);           
            for(int i=0;i<count;i++)
                buf[index++]=tmp[i];     
        }
        return index;
    }

}



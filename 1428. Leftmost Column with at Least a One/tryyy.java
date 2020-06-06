import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;
import java.util.Stack;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Queue;
import java.util.PriorityQueue; 
import java.util.LinkedList;
import java.util.Random;


public class tryyy
{
///////////////////////Mine////////////////////////
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> list = binaryMatrix.dimensions();
        int row=list.get(0);
        int col=list.get(1);
        int x=0;
        int y=col-1;
        int ans=col;
        while(x<row && y>=0){
            if(binaryMatrix.get(x,y)==0)
                x++;
            else{
                ans=y;
                y--;
            }
        }
        return ans==col?-1:ans;
    }
}
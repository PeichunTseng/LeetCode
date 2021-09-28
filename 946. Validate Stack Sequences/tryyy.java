import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class tryyy {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> s = new Stack<>();
        int ind = 0;
        for(int i=0;i<pushed.length;i++){
            s.push(pushed[i]);
            while(!s.isEmpty() && s.peek() == popped[ind]){
                s.pop();
                ind++;
            }
        }
        return s.isEmpty() && ind == popped.length;
        
    }

    public static void main(String[] args) {
       tryyy tr=new tryyy();
       int[] pushed={1,2,3,4,5};
       //int[] popped={4,5,3,2,1};
       int[] popped={4,3,5,1,2};
       boolean ans=tr.validateStackSequences(pushed,popped);
       System.out.println(ans);             
    }
}  

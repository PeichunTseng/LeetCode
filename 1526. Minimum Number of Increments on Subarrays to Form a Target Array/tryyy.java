import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.Stack;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Queue;
import java.util.LinkedList;

public class tryyy {

//////////////////////Others/////////////////////
  public int minNumberOperations(int[] target) {
    int totalOperations = target[0];
    int operationsWeCanReuse = target[0];
    
    for (int i = 1; i < target.length; ++i) {
        if (target[i] <= operationsWeCanReuse) { // Case #1
            operationsWeCanReuse = target[i];
        } else { // Case #2
            totalOperations += target[i] - operationsWeCanReuse; 
            operationsWeCanReuse = target[i];
        }
    }
    return totalOperations;
  }

  public static void main(String[] args) {
    tryyy tr = new tryyy(); 
    int[] target = {3,1,5,1,2};
    int ans = tr.minNumberOperations(target);
    System.out.println(ans);            
  }
}
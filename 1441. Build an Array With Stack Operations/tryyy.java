import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.lang.Math; 
import java.util.Vector;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;
import java.util.PriorityQueue; 
import java.util.Queue; 
import java.util.LinkedList; 

public class tryyy
{
////////////////////Mine///////////////////////
  public List<String> buildArray(int[] target, int n) {
      int index=0;
      List<String> res= new ArrayList<>();
      for(int i=1;i<=n;i++){
          if(index==target.length)
              break;
          if(i==target[index]){
              res.add("Push");
              index++;
          }
          else if(i!=target[index]){
              res.add("Push");
              res.add("Pop");
          }
      }
      return res;     
  }


  public static void main(String[] args){
    tryyy tr=new tryyy();
    int n=4;
    int[] target={2,3,4};
    List<String> ans=tr.buildArray(target,n);
    System.out.println(ans);
  }
}



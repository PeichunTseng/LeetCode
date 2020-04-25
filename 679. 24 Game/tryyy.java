import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Stack;
import java.util.Map;
import java.util.HashMap;

public class tryyy
{

///////////////////others////////////////////////
  public boolean judgePoint24(int[] nums){
    List<Double> list= new ArrayList<>();
    for(int a:nums)
      list.add((double) a);
    return dfs(list);
  }

  public boolean dfs(List<Double> list){
    if(list.size()==1){
      //< 1e-6 Because precision issues when dealing with floating pointer values
      if(Math.abs(list.get(0)- 24.0) < 1e-6)//cannot use (int)list.get(0)==24
        return true;
      return false;
    }

    //pick two card everytime
    for(int i=0;i<list.size();i++){
      for(int j=i+1;j<list.size();j++){
        //each result of these two card will be added to next round
        for(double d:calculate(list.get(i),list.get(j))){
          List<Double> next = new ArrayList<>();
          next.add(d);
          //add remaining card to next round
          for(int k=0;k<list.size();k++){
            if(k==i || k==j)
              continue;
            next.add(list.get(k));
          }
          if(dfs(next))
              return true;
        }
      }
    }
    return false;
  }

  //the result of two card operation
  public List<Double> calculate(double a, double b){
    List<Double> res = Arrays.asList(a+b, a-b, b-a, a*b, a/b, b/a);
    return res;
  }


  public static void main(String[] args) 
  {
    tryyy tr=new tryyy();
    int[] nums = {4, 1, 8, 7};
    //int[] nums = {1, 1, 7, 7};  //if use (int)list.get(0)==24  will return true  ->  not correct
    boolean ans=tr.judgePoint24(nums);
    System.out.println(ans);
  }

}
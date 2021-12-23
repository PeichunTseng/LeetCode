import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Comparator;
import java.util.Collections;

public class tryyy {
//////////////////Others////////////////
  public List<String> generateParenthesis(int n) {
      List<String> res = new ArrayList<>();
      dfs(res, new StringBuilder(), n, n);
      return res;
  }
    
  public void dfs (List<String> res, StringBuilder sb, int left, int right){
      if(left == 0 && right == 0){
          res.add(sb.toString());
          return;
      }
      
      if(left > 0){
          sb.append('(');
          dfs(res, sb, left-1, right);
          sb.setLength(sb.length()-1);
      }
      
      if(left < right){
          sb.append(')');
          dfs(res, sb, left, right-1);
          sb.setLength(sb.length()-1);
      }
  }


  public static void main(String[] args) {
    tryyy tr = new tryyy();
    int n = 3;
    List<String> ans = tr.generateParenthesis(n);
    System.out.println(ans);
  }
}



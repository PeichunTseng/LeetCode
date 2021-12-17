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
  public int minFlipsMonoIncr(String S) {
    int f0 = 0, f1 = 0;
    for (int i = 0; i < S.length(); ++i) {
      int cur = S.charAt(i) - '0';
      f0 += cur;
      f1 = Math.min(f0, f1 + 1 - cur);
    }
    return f1;
  }


  public static void main(String[] args) {
    tryyy tr = new tryyy();
    String s = "0001100";
    int ans = tr.minFlipsMonoIncr(s);
    System.out.println(ans);
  }
}



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
  
  public List<List<String>> suggestedProducts(String[] products, String searchWord) {
    List<List<String>> res = new ArrayList<>();
    List<String> list = new ArrayList<>(Arrays.asList(products));

    for(int i = 0; i < searchWord.length(); i++){
      List<String> temp = new ArrayList<>();
      for(String s : list){
        if(i < s.length() && searchWord.charAt(i) == s.charAt(i))
          temp.add(s);
      }
      Collections.sort(temp);
      res.add(temp.size() > 3 ? temp.subList(0,3) : temp);
      list=temp;
    }
    return res;
          
  }


  public static void main(String[] args) {
     tryyy tr=new tryyy();
     String[] products={"mobile","mouse","moneypot","monitor","mousepad"};
     String searchWord="mouse";
     System.out.println(tr.suggestedProducts(products,searchWord));
  }
}



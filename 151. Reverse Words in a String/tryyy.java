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
import java.util.Stack;

public class tryyy
{
  public String reverseWords(String s) {
      s=s.trim();
      String[] temp=s.split("\\s+");
      StringBuilder sb = new StringBuilder();
      for(int i=temp.length-1;i>=0;i--){
          sb.append(temp[i]+" ");
      }
      return sb.toString().trim();
  }

  public static void main(String[] args){
     tryyy tr=new tryyy(); 
     String s=" a good   example! ";
     System.out.println(tr.reverseWords(s)); 
  }
}



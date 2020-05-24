import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;
import java.util.Stack;
import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.PriorityQueue; 
import java.util.LinkedList;

public class tryyy
{
////////////////////////////Mine////////////////////////////
    public int isPrefixOfWord(String sentence, String searchWord) {
        int len=searchWord.length();
        String[] arr=sentence.split(" ");
        for(int i=0;i<arr.length;i++){
            if(arr[i].length()>=len && arr[i].substring(0,len).equals(searchWord))
                return i+1;
        }
        return -1;
    }

    public static void main(String[] args){
      tryyy tr=new tryyy();
      String sentence="i love eating burger";
      String searchWord="burg";
      int ans=tr.isPrefixOfWord(sentence,searchWord);
      System.out.println(ans);        
    }
}
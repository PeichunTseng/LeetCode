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

class Node{
    Node pre;
    Node next;
    int index;
    char ch;
    public Node(){}
    public Node(char ch, int index){
        this.ch=ch;
        this.index=index;
    }
  }

public class tryyy
{
////////////////////Mine///////////////////////
  Node first;
  Node end;
  public tryyy(){
      first=new Node();
      end=new Node();
      first.next=end;
      end.pre=first;
  }
  public int lengthOfLongestSubstringKDistinct(String s, int k) {
      int res=0;
      Map<Character,Node> map = new HashMap<>();
      //Set<Character> set = new HashSet<>();
      int start=0;
      for(int i=0;i<s.length();i++){
          char ch=s.charAt(i);
          if(map.containsKey(ch)){
            Node temp=map.get(ch);
            temp.index=i;
            remove(temp);
            map.put(ch,addTail(temp));
          }
          else{
            //set.add(ch);
            Node temp=addTail(new Node(ch,i));
            map.put(ch,temp);
          }
          if(map.size()>k){
            res=Math.max(res,i-start);
            Node temp=first.next;
            remove(temp);
            start=temp.index+1;
            //set.remove(temp.ch);
            map.remove(temp.ch);
          }

          
      }
      return Math.max(res,s.length()-start);
  }

  public void remove(Node n){
      Node nPre=n.pre;
      Node nNext=n.next;
      nPre.next=nNext;
      nNext.pre=nPre;
      n.next=null;
      n.pre=null;
  }

  public Node addTail(Node n){
      Node endPre=end.pre;
      endPre.next=n;
      n.pre=endPre;
      n.next=end;
      end.pre=n;
      return n;
  }
////////////////////Others no better///////////////////////
  // public int lengthOfLongestSubstringKDistinct(String str, int k) {
  //     if (str == null || str.isEmpty() || k == 0) {
  //         return 0;
  //     }
  //     TreeMap<Integer, Character> lastOccurrence = new TreeMap<>();
  //     Map<Character, Integer> inWindow = new HashMap<>();
  //     int j = 0;
  //     int max = 1;
  //     for (int i = 0; i < str.length(); i++) {
  //         char in = str.charAt(i);
  //         if(inWindow.size() == k && !inWindow.containsKey(in)) {
  //             int first = lastOccurrence.firstKey();
  //             char out = lastOccurrence.get(first);
  //             inWindow.remove(out);
  //             lastOccurrence.remove(first);
  //             j = first + 1;
  //         }
  //         //update or add in's position in both maps
  //         if (inWindow.containsKey(in)) {
  //             lastOccurrence.remove(inWindow.get(in));
  //         }
  //         inWindow.put(in, i);
  //         lastOccurrence.put(i, in);
  //         max = Math.max(max, i - j + 1);
  //     }
  //     return max;
  // }

  public static void main(String[] args){
    tryyy tr=new tryyy();
    String s="abaccc";
    int k=2;
    int ans=tr.lengthOfLongestSubstringKDistinct(s,k);// 4
    System.out.println(ans);
  }
}



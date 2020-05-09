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
// ////////////////////////////mine////////////////////////
//   public int ladderLength(String beginWord, String endWord, List<String> wordList){
//     // wordList may have many duplicate string
//     Set<String> set = new HashSet<>(wordList);
//     int res=1;
//     Queue<String> q= new LinkedList<>();
//     q.offer(beginWord);
//     while(!q.isEmpty()){
//       int count=q.size();
//       res++;

//       for(int i=0;i<count;i++){
//         char[] temp=q.poll().toCharArray();
//         for(int j=0;j<temp.length;j++){
//           char ch=temp[j];
//           for(char c='a';c<='z';c++){
//             temp[j]=c;
//             if(set.contains(new String(temp)) && endWord.equals(new String(temp)))
//               return res;
//             else if(set.contains(new String(temp))){
//               set.remove(new String(temp));
//               q.offer(new String(temp));
//             }
//           }
//           temp[j]=ch;
//         }
//       }

//     }
//     return 0;
//   }

  ////////////////////////////My other method:use node////////////////////////
  class Node{
    String word;
    int level;
    public Node(String word,int level){
      this.word=word;
      this.level=level;
    }
  }

  public int ladderLength(String beginWord, String endWord, List<String> wordList){
    Set<String> set = new HashSet<>(wordList);
    Queue<Node> q = new LinkedList<>();
    Node root = new Node(beginWord,1);
    q.add(root);

    while(!q.isEmpty()){
      Node temp = q.poll();
      String s = temp.word;
      if(s.equals(endWord))
        return temp.level;
      char[] arr = s.toCharArray();
      for(int j=0;j<arr.length;j++){
        char record = arr[j];
        for(char c='a'; c<='z'; c++){
          arr[j]=c;
          if(set.contains(String.valueOf(arr))){
            q.add(new Node(String.valueOf(arr),temp.level+1));
            set.remove(String.valueOf(arr));
          }
        }
        arr[j]=record;
      }
    }
    return 0;
  }

  public static void main(String[] args){
    tryyy tr=new tryyy();
    String beginWord = "hit";
    String endWord = "cog";
    List<String> wordList = new ArrayList<>();
    String[] s={"hot","dot","dog","lot","log","cog"};
    for(String ss:s)
      wordList.add(ss);
    int a=tr.ladderLength(beginWord,endWord,wordList);
    System.out.println(a);
  }
}



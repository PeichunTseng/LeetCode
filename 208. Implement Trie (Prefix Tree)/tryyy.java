import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Stack;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.LinkedList;
class Trie{
    Trie[] arr;
    String s;
    public Trie(){
      arr= new Trie[26];
      s="";
    }
}

public class tryyy
{
//////////////////////Mine//////////////////////
    Trie root;
    public tryyy() {
        root = new Trie();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie temp = root;
        for(int i=0;i<word.length();i++){
            if(temp.arr[word.charAt(i)-'a']==null){
                temp.arr[word.charAt(i)-'a']=new Trie();
            }
            temp=temp.arr[word.charAt(i)-'a'];
            if(i==word.length()-1)
                temp.s=word;
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie temp = root;
        for(int i=0;i<word.length();i++){
            if(temp.arr[word.charAt(i)-'a']==null){
                return false;
            }
            temp=temp.arr[word.charAt(i)-'a'];
            if(i==word.length()-1 && !temp.s.equals(word))
                return false;                
        }
        return temp.s.equals(word);
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie temp = root;
        for(int i=0;i<prefix.length();i++){
            if(temp.arr[prefix.charAt(i)-'a']==null){
                return false;
            }
            temp=temp.arr[prefix.charAt(i)-'a'];              
        }
        return true;
    }


    public static void main(String[] args){
       tryyy tr=new tryyy();
       tr.insert("apple");
       System.out.println(tr.search("apple"));   // returns true
       System.out.println(tr.search("app"));     // returns false
       System.out.println(tr.startsWith("app")); // returns true
       tr.insert("app");   
       System.out.println(tr.search("app"));     // returns true 

    }
}



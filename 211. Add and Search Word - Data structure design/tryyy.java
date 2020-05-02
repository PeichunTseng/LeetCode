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
import java.util.Collections;


public class tryyy
{
//////////////////////////////Mine  Time Limit ///////////////////////////////
    // Set<String> set;
    // public tryyy() {
    //     set=new HashSet<>();
    // }
    
    // /** Adds a word into the data structure. */
    // public void addWord(String word) {
    //     set.add(word);
    // }
    
    // /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    // public boolean search(String word) {
    //     if(set.contains(word))
    //         return true;
    //     boolean res=false;
    //     char[] arr=word.toCharArray();
    //     for(int i=0;i<word.length();i++){
    //         if(word.charAt(i)=='.'){
    //             for(char ch='a';ch<='z';ch++){
    //                 arr[i]=ch;
    //                 if(search(String.valueOf(arr))){
    //                     set.add(String.valueOf(arr));
    //                     return true;
    //                 }
    //             }
    //         }
            
    //     }
    //     return res;
    // }

//////////////////////////////Others  Trie ///////////////////////////////
    class Trie{
        Trie[] child = new Trie[26];
        String s="";
    }
    Trie root;

    public tryyy() {
        root= new Trie();;
    }   
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Trie temp = root;
        for(char ch:word.toCharArray()){
            if(temp.child[ch-'a']==null)
                temp.child[ch-'a']=new Trie();
            temp=temp.child[ch-'a'];
        }
        temp.s=word;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return help(word.toCharArray(),root,0);
    }

    public boolean help(char[] arr, Trie node, int ind){
        // if(ind==arr.length && !node.s.equals(""))  //Error, Because if it's false, it will still run the 
        //     return true;                           //following code that will cause IndexOutOfBounds 
        
        if(ind==arr.length)
            return !node.s.equals("");
        if(arr[ind]!='.')
            return node.child[arr[ind]-'a']!=null && help(arr,node.child[arr[ind]-'a'],ind+1);
        else{
            for(int i=0;i<26;i++){
                if(node.child[i] !=null && help(arr,node.child[i],ind+1))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
       tryyy tr=new tryyy(); 
       tr.addWord("bad");
       tr.addWord("dad");
       tr.addWord("mad");
       System.out.println(tr.search("pad"));
       System.out.println(tr.search("bad"));
       System.out.println(tr.search(".ad"));
       System.out.println(tr.search("b.."));          
    }

}



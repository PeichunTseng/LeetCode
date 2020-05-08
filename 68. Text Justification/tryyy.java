import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class tryyy
{
  /////////////////////Mine//////////////////////
  public List<String> fullJustify(String[] words, int maxWidth){
    List<String> res= new ArrayList<>();
    int count=0;
    String temp="";
    for(int i=0;i<words.length;i++){    
      if(count==0){
        temp+=words[i];
        count+=words[i].length();
      }
      else{
        temp=temp+" "+words[i];
        count+=words[i].length()+1;
      }
      if(i+1<=words.length-1 && count+words[i+1].length()+1<=maxWidth)
        continue;
      if(i==words.length-1){
        int time=temp.length();
        for(int j=0;j<maxWidth-time;j++){
          temp+=" ";
        }
        res.add(temp);
        break;
      }
      temp=transfer(temp,maxWidth);
      res.add(temp);
      temp="";
      count=0;
    }
    return res;
  }

  public String transfer(String s, int w){
    s=s.trim();
    String res="";
    String[] arr = s.split(" ");
    int remain=w;
    int space=arr.length-1;

    for(String str:arr)
      remain-=str.length();

    Stack<Integer> stack = new Stack<>();

    while(remain!=0 && space!=0){
      stack.push(remain/space);
      remain=remain-remain/space;
      space--;
    }
    if(remain!=0)
      stack.push(remain);
    
    res+=arr[0];
    int index=1;
    while(!stack.isEmpty()){
      int count=stack.pop();
      for(int i=0;i<count;i++){
        res+=" ";
      }
      if(index<arr.length)
        res+=arr[index++];
    }
    return res;
  }
/////////////////////Others//////////////////////
   public List<String> fullJustify(String[] words, int maxWidth) {
        int left = 0; 
        List<String> result = new ArrayList<>();
        
        while (left < words.length) {
            int right = findRight(left, words, maxWidth);
            result.add(justify(left, right, words, maxWidth));
            left = right + 1;
        }
        
        return result;
    }
    
    private int findRight(int left, String[] words, int maxWidth) {
        int right = left;
        int sum = words[right++].length();
        
        while (right < words.length && (sum + 1 + words[right].length()) <= maxWidth)
            sum += 1 + words[right++].length();
            
        return right - 1;
    }
    
    private String justify(int left, int right, String[] words, int maxWidth) {
        if (right - left == 0) return padResult(words[left], maxWidth);
        
        boolean isLastLine = right == words.length - 1;
        int numSpaces = right - left;
        int totalSpace = maxWidth - wordsLength(left, right, words);
        
        String space = isLastLine ? " " : blank(totalSpace / numSpaces);
        int remainder = isLastLine ? 0 : totalSpace % numSpaces;
        
        StringBuilder result = new StringBuilder();
        for (int i = left; i <= right; i++)
            result.append(words[i])
                .append(space)
                .append(remainder-- > 0 ? " " : "");
        
        return padResult(result.toString().trim(), maxWidth);
    }
    
    private int wordsLength(int left, int right, String[] words) {
        int wordsLength = 0;
        for (int i = left; i <= right; i++) wordsLength += words[i].length();
        return wordsLength;
    }
    
    private String padResult(String result, int maxWidth) {
        return result + blank(maxWidth - result.length());
    }
    
    private String blank(int length) {
        return new String(new char[length]).replace('\0', ' ');
    }


  public static void main(String[] args){
     tryyy tr=new tryyy();
     String[] words={"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
     int maxWidth=20;
     List<String> ans = tr.fullJustify(words,maxWidth);
     System.out.println(ans);        
  }
}



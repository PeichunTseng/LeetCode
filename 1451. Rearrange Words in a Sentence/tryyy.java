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
import java.util.Random;

public class tryyy
{
//////////////////Mine//////////////////
    // public String arrangeWords(String text) {
    //     if(text.length()<=1)
    //         return text;
    //     text=text.toLowerCase();
    //     String[] arr = text.split(" ");
    //     Arrays.sort(arr,(a,b)->a.length()==b.length()?0:a.length()-b.length());
    //     char[] temp=arr[0].toCharArray();
    //     temp[0]=Character.toUpperCase(temp[0]);
    //     arr[0]=String.valueOf(temp);
    //     StringBuilder sb=new StringBuilder();
    //     sb.append(arr[0]);
    //     for(int i=1;i<arr.length;i++){
    //         sb.append(" ");
    //         sb.append(arr[i]);
    //     }
    //     return sb.toString();
        
    // }
//////////////////Others better//////////////////
    public String arrangeWords(String text) {
        String[] arr = text.toLowerCase().split(" ");
        Arrays.sort(arr, (a,b) ->  a.length() - b.length());
        String res = String.join(" ", arr);
        return Character.toUpperCase(res.charAt(0)) + res.substring(1);
    }

    public static void main(String[] args){
        tryyy tr=new tryyy();
        String text = "Leetcode is cool";
        String ans = tr.arrangeWords(text);
        System.out.println(ans);
    }
}
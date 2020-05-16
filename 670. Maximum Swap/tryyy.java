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
    // public int maximumSwap(int num){
    //     char[] arr= String.valueOf(num).toCharArray();
    //     int[] temp= new int[arr.length];
    //     for(int i=0;i<arr.length;i++)
    //         temp[i]=arr[i]-'0';
        
    //     Map<Integer,List<Integer>> map = new HashMap<>();
    //     int[] recordMaxRight = new int[temp.length];
    //     int max=temp[temp.length-1];
    //     for(int i=temp.length-2;i>=0;i--){
    //         max=Math.max(max,temp[i+1]);
    //         recordMaxRight[i]=max;
    //         map.putIfAbsent(temp[i+1],new ArrayList<>());
    //         map.get(temp[i+1]).add(i+1);

    //     }

    //     for(int i=0;i<temp.length-1;i++){
    //         if(recordMaxRight[i]>temp[i]){
    //             int index=map.get(recordMaxRight[i]).get(0);
    //             int t=temp[index];
    //             temp[index]=temp[i];
    //             temp[i]=t;
    //             break;
    //         }
    //     }
    //     int res=0;
    //     int count=temp.length;
    //     for(int i=0;i<temp.length;i++){
    //         res+=temp[i]*Math.pow(10,count-1);
    //         count--;
    //     }
    //     return res;
        
    // }
//////////////////Others better//////////////////
    public int maximumSwap(int num) {
        char[] A = Integer.toString(num).toCharArray();
        int[] last = new int[10];
        for (int i = 0; i < A.length; i++) {
            last[A[i] - '0'] = i;
        }

        for (int i = 0; i < A.length; i++) {
            for (int d = 9; d > A[i] - '0'; d--) {
                if (last[d] > i) {
                    char tmp = A[i];
                    A[i] = A[last[d]];
                    A[last[d]] = tmp;
                    return Integer.valueOf(new String(A));
                }
            }
        }
        return num;
    }

    public static void main(String[] args){
        tryyy tr=new tryyy();
        int num = 2736;
        int ans = tr.maximumSwap(num);
        System.out.println(ans);
    }
}
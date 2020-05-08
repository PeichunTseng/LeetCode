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
  /////////////////////Mine Error//////////////////////
    // public int sumSubarrayMins(int[] A){
    //   int res=0;
    //   for(int i=0;i<A.length;i++){
    //     int min=A[i];
    //     for(int j=i;j<A.length;j++){
    //       min=Math.min(min,A[j]);
    //       res+=min;
    //     }
    //   }
    //   return res;
    // }


  /////////////////////Others//////////////////////
    public int sumSubarrayMins(int[] A){
        int res=0;
        int len = A.length;
        int[] left=new int[len];
        int[] right= new int[len];
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<len;i++){
          while(!s.isEmpty() && A[s.peek()]>=A[i])// have "="
            s.pop();
          left[i]=s.isEmpty()?i+1:i-s.peek();
          s.push(i);
        }

        s = new Stack<>();

        for(int i=len-1;i>=0;i--){
          while(!s.isEmpty() && A[s.peek()]>A[i]) // no "=", Explain below
            s.pop();
          right[i]=s.isEmpty()?len-i:s.peek()-i;
          s.push(i);
        }

        // for(int a:left)
        //   System.out.println(a);
        // for(int a:right)
        //   System.out.println(a);  

        int mod = 1000000007;
        for(int i=0;i<len;i++){
          // res+=A[i]*left[i]*right[i];
          res=(res+A[i]*left[i]*right[i])%mod;
        }
        return res;

    }

      // Explain: If two "=", we will calculate 5 twice.
      // Take array {7,5,8,5} for example
      // left={1,2,1,2};  right={1,3,1,1}
      // 1. the first 5
      //    7,5;
      //    7,5,8;
      //    7,5,8,5;
      //    5;
      //    5,8;
      //    5,8,5;
      // 2. the second 5
      //    7,5,8,5;//
      //    5,8,5;//
      //    8,5;
      //    5;


    public static void main(String[] args){
       tryyy tr=new tryyy();
       int[] A={3,1,2,4};//17
       //int[] A={71,55,82,55};//593
       int ans = tr.sumSubarrayMins(A);
       System.out.println(ans);        
    }
}

// Explain:  int[] A={3,1,2,4};
// //////////////////////////////////////////
//     int[] A={3,1,2,4};

//     i=0
//     preStack={}
//     left={1,}
//     preStack={3,0}

//     i=1
//     preStack={}
//     left={1,2}
//     preStack={1,1}

//     i=2
//     preStack={1,1}
//     left={1,2,1,}
//     preStack={2,2},{1,1}

//     i=3
//     preStack={2,2},{1,1}
//     left={1,2,1,1}
//     preStack={4,3},{2,2},{1,1}
// //////////////////////////////////////////
//     int[] A={3,1,2,4};

//     i=3
//     nextStack={}
//     right={1,}
//     nextStack={4,3}

//     i=2
//     nextStack={}
//     right={1,2,}
//     nextStack={2,2}

//     i=1
//     nextStack={}
//     right={1,2,3,}
//     nextStack={1,1}

//     i=2
//     nextStack={1,1}
//     right={1,2,3,1}
//     nextStack={3,0},{1,1}

// //////////////////////////////////////////
//     int[] A={3,1,2,4};
//     left={1,2,1,1}
//     right={1,2,3,1}

//     3+4+6+4=17
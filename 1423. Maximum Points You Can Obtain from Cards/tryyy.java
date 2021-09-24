import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.Stack;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Queue;
import java.util.LinkedList;

public class tryyy {

//////////////////////Mine/////////////////////
  public int maxScore(int[] cardPoints, int k) {
    int len = cardPoints.length;
    int res = 0;
    int temp = res;
    if(k >= len){
        for(int i=0;i<len;i++) res += cardPoints[i];
        return res;
    }
    
    for(int i=0;i<k;i++){
        res += cardPoints[i];
        temp += cardPoints[i];
    }
    
    for(int i=k-1;i>=0;i--){
        int next = cardPoints[i-k+len];
        temp = temp - cardPoints[i] + next;
        res = Math.max(res,temp);
    }
    return res;
  }

  public static void main(String[] args) {
    tryyy tr = new tryyy(); 
    int[] cardPoints = {1,2,3,4,5,6,1};
    int k = 3;
    int ans = tr.maxScore(cardPoints,k);
    System.out.println(ans);            
  }
}
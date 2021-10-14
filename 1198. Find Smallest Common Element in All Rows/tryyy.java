import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.lang.Math; 
import java.util.Vector;
import java.util.Collections;

public class tryyy {
///////////////////////Mine////////////////////////////////
    // public int smallestCommonElement(int[][] input) {
    //     int row = input.length;
    //     int col = row == 0 ? 0 : input[0].length;
    //     TreeMap<Integer, Integer> map = new TreeMap<>();

    //     for(int i = 0; i < row; i++){
    //       for(int element : input[i]){
    //         if(!map.containsKey(element)) map.put(element,0);
    //         map.put(element, map.get(element)+1);
    //       }
    //     }

    //     for(int key : map.keySet()){
    //       if(map.get(key) == row)
    //         return key;
    //     }
    //     return -1;
    // }


//////////////////Mine Improve/////////////////////////////////////
    public int smallestCommonElement(int[][] input) {
        int row = input.length;
        int col = row == 0 ? 0 : input[0].length;

        for(int i = 0; i < col; i++){
          int element = input[0][i];
          int total = 0;
          for(int j = 1; j < row; j++){
            int find = binarySearch(element, input[j]);
            if(find == 0)
              break;
            total += find;
          }
          if(total == row-1)
            return element;
        }
        return -1;
    }

    public int binarySearch(int element, int[] arr){
      int left = 0;
      int right = arr.length-1;

      while(left <= right){
        int mid = left + (right-left)/2;
        int temp = arr[mid];

        if(element == temp) return 1;
        if(element < temp) right = mid-1;
        else left = mid+1;
      }
      return 0;
    }

 
    public static void main(String[] args) {
       tryyy tr = new tryyy();
       int[][] input = {{1,2,3,4,5},
                        {2,4,5,8,10},
                        {3,5,7,9,11},
                        {1,3,5,7,9}};
       int ans = tr.smallestCommonElement(input);
       System.out.println(ans);

    }
}
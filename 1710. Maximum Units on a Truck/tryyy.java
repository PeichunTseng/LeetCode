import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Comparator;
import java.util.Collections;

public class tryyy {

  public int maximumUnits(int[][] boxTypes, int truckSize) {
    Arrays.sort(boxTypes, (a, b) -> b[1]-a[1]);
    int res = 0;
    int ind = 0;
    while(truckSize != 0 && ind < boxTypes.length){
      int[] temp = boxTypes[ind];
      int num = truckSize >= temp[0] ? temp[0] : truckSize;
      res += num * temp[1];
      truckSize -= num;
      ind++;
    }
    return res;
  }


  public static void main(String[] args) {
     tryyy tr = new tryyy();
     int[][] boxTypes = {{5, 10}, {2, 5}, {4, 7}, {3, 9}}; 
     int truckSize = 10;
     int ans = tr.maximumUnits(boxTypes, truckSize);
     System.out.println(ans);
  }
}



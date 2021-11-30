import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;

public class tryyy{
/////////////////////////////Mine///////////////////////////////
  public boolean searchMatrix(int[][] matrix, int target) {
    int row = matrix.length;
    int col = row == 0 ? 0 : matrix[0].length;

    for(int i = 0; i < row; i++){
      if(target >= matrix[i][0] && target <= matrix[i][col-1] && binarySearch(matrix[i], target))
        return true;
    }
    return false;
  }

  public boolean binarySearch(int[] arr, int target){
    int l = 0;
    int r = arr.length-1;

    while(l <= r){
      int mid = l + (r-l)/2;
      int temp = arr[mid];
      if(target > temp) l = mid + 1;
      else if(temp > target) r = mid - 1;
      else return true;
    }
    return false;
  }

  public static void main(String[] args) {
    tryyy tr=new tryyy(); 
    int[][] matrix = {{1, 3, 5, 7},
                      {10, 11, 16, 20},
                      {23, 30, 34, 60}};
    int target = 13;
    boolean ans = tr.searchMatrix(matrix, target);
    System.out.println(ans);     
  }
}
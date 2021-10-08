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

public class tryyy{ 
///////////////////////////Others/////////////////////////////
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<>(); 
        if (matrix == null || matrix.length == 0) return res;
        int row = matrix.length;
        int col = matrix[0].length;
        int up = 0, down = row-1;
        int left = 0, right = col-1;

        while(res.size() < row*col){
            for(int i = left; i <= right; i++){
                res.add(matrix[up][i]);
            }

            for(int j = up+1; j <= down && res.size() < row*col; j++){
                res.add(matrix[j][right]);
            }

            for(int i = right-1; i >= left && res.size() < row*col; i--){
                res.add(matrix[down][i]);
            }

            for(int j = down-1; j >= up+1 && res.size() < row*col; j--){
                res.add(matrix[j][left]);
            }
            up++; down--; left++; right--;
        }
        return res;
    }
    


    public static void main(String[] args) {
       tryyy tr=new tryyy(); 
       int[][] matrix = {{1,2,3},
                         {4,5,6},
                         {7,8,9}};
       List<Integer> ans =tr.spiralOrder(matrix);
       System.out.println(ans);
    }
}
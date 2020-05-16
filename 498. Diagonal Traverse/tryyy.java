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
////////////////////Others//////////////////////
    public int[] findDiagonalOrder(int[][] matrix){
        int row=matrix.length;
        int col= row==0 ? 0 : matrix[0].length;
        if(row*col==0)
            return new int[]{};
        int[] res=new int[row*col];
        int index=0;
        for(int i=0;i<res.length;i++){
            List<Integer> inner = new ArrayList<>();
            int r=0;
            int c=0;
            if(i<col){
                r=0;
                c=i;
            }
            else{
                r=i-col+1;
                c=col-1;
            }

            while(r<row && c>=0){
                inner.add(matrix[r][c]);
                r++;
                c--;
            }
            if(i%2==0)
                Collections.reverse(inner);
            for(int a:inner)
                res[index++]=a;
        }
        return res;
    }

    public static void main(String[] args){
        tryyy tr=new tryyy();
        int[][] matrix={{1,2,3},{4,5,6},{7,8,9}};
        // 1 2 3
        // 4 5 6 
        // 7 8 9 
        int[] ans=tr.findDiagonalOrder(matrix);
        for(int a:ans)
            System.out.println(a);
    }
}
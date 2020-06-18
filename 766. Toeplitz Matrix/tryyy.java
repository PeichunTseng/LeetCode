import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;
import java.util.Stack;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.PriorityQueue; 
import java.util.LinkedList;

public class tryyy
{
//////////////////////////Others////////////////////////////////
    public boolean isToeplitzMatrix(int[][] matrix) {
        int row=matrix.length;
        int col= row==0 ? 0 : matrix[0].length;
        for(int i=0;i<row-1;i++){
            for(int j=0;j<col-1;j++){
                if(matrix[i][j]!=matrix[i+1][j+1])
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
       tryyy tr=new tryyy(); 
       int[][] matrix={{1,2,3,4},
                       {5,1,2,3},
                       {9,5,1,2}};
       boolean ans=tr.isToeplitzMatrix(matrix);
       System.out.println(ans);           
    }
}
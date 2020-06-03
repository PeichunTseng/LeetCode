import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;
import java.util.Stack;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Queue;
import java.util.PriorityQueue; 
import java.util.LinkedList;
import java.util.Random;


public class tryyy
{
///////////////////////Mine////////////////////////
    int[][] arr;
    public tryyy(int[][] matrix) {
        arr=new int[matrix.length][matrix.length==0?0:matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(i==0 || j==0){
                    if(i==0 && j==0)
                        arr[i][j]=matrix[i][j];
                    else if(i==0)
                        arr[i][j]=matrix[i][j]+arr[i][j-1];
                    else
                        arr[i][j]=matrix[i][j]+arr[i-1][j];
                }
                else{
                    arr[i][j]=arr[i-1][j]+arr[i][j-1]-arr[i-1][j-1]+matrix[i][j];
                }
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res=arr[row2][col2];
        if(row1-1>=0)
            res-=arr[row1-1][col2];
        if(col1-1>=0)
            res-=arr[row2][col1-1];
        if(row1-1>=0 && col1-1>=0)
            res+=arr[row1-1][col1-1];
        return res;
    }
 
    public static void main(String[] args){
        int[][] matrix={{3, 0, 1, 4, 2},
                        {5, 6, 3, 2, 1},
                        {1, 2, 0, 1, 5},
                        {4, 1, 0, 1, 7},
                        {1, 0, 3, 0, 5}};
        tryyy tr=new tryyy(matrix);
        int ans=tr.sumRegion(2,1,4,3);
        //int ans=tr.sumRegion(0,0,3,0);
        System.out.println(ans);
    }
}
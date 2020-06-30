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
////////////////////////////Mine//////////////////////////////
    public int matrixScore(int[][] A) {
        int row=A.length;
        int col=row==0?0:A[0].length;
        int[] arr=new int[col];
        
        for(int i=0;i<row;i++){
            boolean flag=false;
            for(int j=0;j<col;j++){
                if(j==0 && A[i][j]==0){
                    flag=true;
                }
                if(flag){
                    if(A[i][j]==0)
                        A[i][j]=1;
                    else
                        A[i][j]=0;
                }
            }
        }
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(A[i][j]==1){
                    arr[j]++;
                }
            }
        }
        
        int res=(int)Math.pow(2,col-1)*row;
        int power=col-2;
        for(int i=1;i<arr.length;i++){
            int temp=Math.max(arr[i],row-arr[i]);
            res=res+(int)Math.pow(2,power)*temp;
            power--;
        }
        return res;
    }

    public static void main(String[] args){
       tryyy tr=new tryyy(); 
       int[][] A={{0,0,1,1},{1,0,1,0},{1,1,0,0}};
       int ans=tr.matrixScore(A);
       System.out.println(ans);           
    }
}
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
//////////////////Mine//////////////////
    public int countSquares(int[][] matrix) {
        int row=matrix.length;
        int col=row>0 ? matrix[0].length : 0;
        int res=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(i!=0 && j!=0 && matrix[i][j]==1){
                   matrix[i][j]=Math.min(matrix[i-1][j-1],Math.min(matrix[i-1][j],matrix[i][j-1]))+1;
                }
                res+=matrix[i][j];
            }
        }
        return res;
    }
 
    public static void main(String[] args){
        tryyy tr=new tryyy();
        int[][] matrix={{0,1,1,1},{1,1,1,1},{0,1,1,1}};
        int ans=tr.countSquares(matrix);
        System.out.println(ans);
    }
}
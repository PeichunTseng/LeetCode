import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;

public class tryyy
{
    public int numSubmatrixSumTarget(int[][] matrix, int target){
        int row=matrix.length;
        int col=matrix[0].length;
        int ans=0;
        int[][] rec=new int[row+1][col+1];

        for(int i=1;i<rec.length;i++){//先把(0,0)到每個index時的和記錄下來
            for(int j=1;j<rec[i].length;j++){
                rec[i][j]=rec[i-1][j]+rec[i][j-1]-rec[i-1][j-1]+matrix[i-1][j-1];
            }
        }

        Map<Integer,Integer> map = new HashMap<>();//map用來記錄走過每個column時出現過的值
        for(int r1=1;r1<rec.length;r1++)//r1為要計算的row 的範圍
            for(int r2=r1;r2<rec.length;r2++){//r2為一個row一個row往下找
                map.clear();
                map.put(0,1);
                for(int c=1;c<rec[r1].length;c++){//c為每一個row裡要走的column(會走遍全部的column)
                    int curr=rec[r2][c]-rec[r1-1][c];
                    ans=ans+map.getOrDefault(curr-target,0);
                    map.put(curr,map.getOrDefault(curr,0)+1);
                }
            }
        return ans;
    }

    public static void main(String[] args) 
    {
       tryyy tr=new tryyy(); 
       int[][] matrix={{1,1,1},{1,1,1},{0,1,0}};
       int target = 2;
       System.out.println(tr.numSubmatrixSumTarget(matrix,target));            
    }
}



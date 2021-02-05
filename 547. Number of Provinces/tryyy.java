import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;

public class tryyy{
  public int findCircleNum(int[][] isConnected) {
    int row = isConnected.length;
    int col = row==0 ? 0 :isConnected[0].length;
    int res = 0;
    for(int i=0;i<row;i++){
      if(isConnected[i][i]==1){
        dfs(isConnected,i,i);
        res++;
      }
    }
    return res;
  }


  public void dfs(int[][] arr, int x, int y){
    if(arr[x][x]==0)
      return;
    arr[x][x]=0;
    for(int j=0;j<arr[x].length;j++){
      if(arr[x][j]==1){
        arr[j][x]=0;
        arr[x][j]=0;
        dfs(arr,j,x);
      }
    }
  }

  public static void main(String[] args){
    int[][] isConnected ={{1,1,0},
                          {1,1,0},
                          {0,0,1}};
    tryyy tr=new tryyy();
    int ans=tr.findCircleNum(isConnected);
    System.out.println(ans);
  }
}
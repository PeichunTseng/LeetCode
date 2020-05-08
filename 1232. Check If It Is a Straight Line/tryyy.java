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

public class tryyy
{
   public boolean checkStraightLine(int[][] coordinates){
        int dx=coordinates[1][0]-coordinates[0][0];
        int dy=coordinates[1][1]-coordinates[0][1];
        for(int i=2;i<coordinates.length;i++){
            int slopX=coordinates[i][0]-coordinates[i-1][0];
            int slopY=coordinates[i][1]-coordinates[i-1][1];
            if(dy*slopX!=dx*slopY)
              return false;
        }
        return true;
    }

    public static void main(String[] args) {
       tryyy tr=new tryyy(); 
       //int[][] coordinates={{1,1},{2,2},{3,4},{4,5},{5,6},{6,7}};
       int[][] coordinates={{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}};
       boolean ans=tr.checkStraightLine(coordinates);
       System.out.println(ans);           
    }
}



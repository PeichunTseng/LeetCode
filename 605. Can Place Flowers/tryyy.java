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
///////////////////////Mine/////////////////////
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        boolean flag=true;
        int count=0;
        for(int i=0;i<flowerbed.length;i++){
            if(flowerbed[i]==1){
                flag=false;
            }
            else{
                if(flag && (i+1==flowerbed.length || flowerbed[i+1]==0)){
                    count++;
                    flag=false;
                }
                else
                    flag=true;
            }
        }
        return count>=n;
    }

    public static void main(String[] args) {
       tryyy tr=new tryyy(); 
       int[] flowerbed={1,0,0,0,1};  
       int n=1;  
       boolean ans=tr.canPlaceFlowers(flowerbed,n);
       System.out.println(ans);      
    }
}
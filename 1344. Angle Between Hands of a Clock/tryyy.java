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
    
    public double angleClock(int hour, int minutes) {
        hour = hour>=12 ? hour-12 : hour;
        double hDegree=(double)(hour*30)+((30.0*minutes)/60)%30;
        double mDegree=(double)(6*minutes);
        double temp=Math.abs(hDegree-mDegree);
        return Math.min(temp,360-temp);
    }


    public static void main(String[] args){
       tryyy tr=new tryyy(); 
       int hour=3; 
       int minutes=30;
       double ans=tr.angleClock(hour,minutes);
       System.out.println(ans);           
    }
}
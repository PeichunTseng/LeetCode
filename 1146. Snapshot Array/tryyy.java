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
////////////////////mine Memory Limit Exceeded/////////////////////
  // class SnapshotArray {
  //     int[] arr;
  //     Map<Integer,int[]> map;
  //     int id;
  //     public SnapshotArray(int length) {
  //         arr=new int[length];
  //         map=new HashMap<>();
  //         id=0;
  //     }
      
  //     public void set(int index, int val) {
  //         arr[index]=val;
  //     }
      
  //     public int snap() {
  //         int[] tem=arr.clone();
  //         map.put(id,tem);
  //         id++;
  //         return id-1;
  //     }
      
  //     public int get(int index, int snap_id) {
  //         int[] tem=map.get(snap_id);
  //         return tem[index];
  //     }
  // }

  /**
   * Your SnapshotArray object will be instantiated and called as such:
   * SnapshotArray obj = new SnapshotArray(length);
   * obj.set(index,val);
   * int param_2 = obj.snap();
   * int param_3 = obj.get(index,snap_id);
   */

////////////////////others/////////////////////
    class SnapshotArray {
        TreeMap<Integer, Integer>[] arr;
        int id = 0;
        public SnapshotArray(int length) {
            arr= new TreeMap[length];
            for (int i = 0; i < length; i++) {
                arr[i] = new TreeMap<Integer, Integer>();
                arr[i].put(0, 0);
            }
        }

        public void set(int index, int val) {
            arr[index].put(id, val);
        }

        public int snap() {
            return id++;
        }

        public int get(int index, int snap_id) {
            int key=arr[index].floorKey(snap_id);
            return arr[index].get(key);
        }
    }

    public static void main(String[] args) 
    {
       tryyy tr=new tryyy();      
    }

}



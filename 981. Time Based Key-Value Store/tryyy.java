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

class Record {
  List<Integer> list;
  Map<Integer,String> val;
  public Record() {
      list = new ArrayList<>();
      val = new HashMap<>();
  }
}
public class tryyy{
//////////////////////////////Mine////////////////////////////////////////////

  Map<String,Record> map;
  public tryyy() {
      map = new HashMap<>();
  }
  
  public void set(String key, String value, int timestamp) {
      Record record = map.getOrDefault(key,new Record());
      record.list.add(timestamp);
      record.val.put(timestamp,value);
      map.put(key,record);
  }
  
  public String get(String key, int timestamp) {
      if(!map.containsKey(key))
          return "";
      Record record = map.get(key);
      List<Integer> list = record.list;
      int ind = help(list,timestamp);
      if(ind>timestamp)
          return "";
      return record.val.get(ind);
  }
  
  public int help(List<Integer> list, int time){
      int l = 0;
      int r = list.size()-1;
      while(l<r){
          int ind = l + (r-l)/2;
          if(list.get(ind)>time)
              r=ind;
          else if(list.get(ind)<=time){
              if(list.get(ind)==time || ind==list.size()-1 || list.get(ind+1)>time)
                  return list.get(ind);
              else
                  l=ind+1;
          }
      }
      return list.get(l);
  }

  public static void main(String[] args){
     tryyy tr=new tryyy(); 
     tr.set("foo","bar",1);
     System.out.println(tr.get("foo",1));
     System.out.println(tr.get("foo",3));
     tr.set("foo","bar2",4);
     System.out.println(tr.get("foo",4));
     System.out.println(tr.get("foo",5));    
  }
}
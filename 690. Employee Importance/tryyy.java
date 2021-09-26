import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.Stack;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Queue;
import java.util.LinkedList;

public class tryyy {

    public static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
        public Employee(int id, int importance){
            this.id = id;
            this.importance = importance;
            this.subordinates = new ArrayList<>();
        }
    }
//////////////////////Mine/////////////////////
    // int res = 0;
    // public int getImportance(List<Employee> employees, int id) {
    //     Map<Integer,Integer> imp = new HashMap<>();
    //     Map<Integer,List<Integer>> map = new HashMap<>();

    //     for(Employee e : employees){
    //         imp.put(e.id,e.importance);
    //         map.put(e.id,e.subordinates);
    //     }

    //     help(imp,map,id);
    //     return res;
    // }

    // public void help(Map<Integer,Integer> imp, Map<Integer,List<Integer>> map, int id){
    //     res += imp.get(id);
    //     List<Integer> next = map.get(id);
    //     for(int a : next){
    //         help(imp,map,a);
    //     }
    // }

//////////////////////Others BFS/////////////////////
    public int getImportance(List<Employee> employees, int id) {
        int total = 0;
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        Queue<Employee> queue = new LinkedList<>();
        queue.offer(map.get(id));
        while (!queue.isEmpty()) {
            Employee current = queue.poll();
            total += current.importance;
            for (int subordinate : current.subordinates) {
                queue.offer(map.get(subordinate));
            }
        }
        return total;
    }

  public static void main(String[] args) {
    tryyy tr = new tryyy(); 
    List<Employee> employees = new ArrayList<>();
    Employee employee1 = new Employee(1,5);
    Employee employee2 = new Employee(2,3);
    Employee employee3 = new Employee(3,3);
    employee1.subordinates.add(2);
    employee1.subordinates.add(3);
    employees.add(employee1);
    employees.add(employee2);
    employees.add(employee3);
    int id = 1;
    int ans = tr.getImportance(employees, id);
    System.out.println(ans);            
  }
}
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Deque;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Collections;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.text.ParseException;


public class tryyy
{
//////////////////////////////Other///////////////////////////////

    public boolean isNumber(String s){
      s=s.trim();
      boolean seePoint=false;
      boolean seeNum=false;
      boolean seeE=false;
      boolean seeOperator=false;
      boolean numberAfterE = true;
      for(int i=0;i<s.length();i++){
        if(s.charAt(i)>='0' && s.charAt(i)<='9'){
          seeNum=true;
          numberAfterE=true;
        }
        else if(s.charAt(i)=='.'){
          if(seeE || seePoint)
            return false;
          seePoint=true;
        }
        else if(s.charAt(i)=='+' || s.charAt(i)=='-'){
          if(i==0 || s.charAt(i-1)=='e'){
              seeOperator=true;
              continue;
          }
          else
              return false;
        }
        else if(s.charAt(i)=='e'){
          if( seeE || !seeNum)
            return false;
          seeE=true;
          numberAfterE=false;
        }
        else 
          return false;

      }
      return seeNum && numberAfterE;

    }


    // test(1, "123", true);
    // test(2, " 123 ", true);
    // test(3, "0", true);
    // test(4, "0123", true);  //Cannot agree
    // test(5, "00", true);  //Cannot agree
    // test(6, "-10", true);
    // test(7, "-0", true);
    // test(8, "123.5", true);
    // test(9, "123.000000", true);
    // test(10, "-500.777", true);
    // test(11, "0.0000001", true);
    // test(12, "0.00000", true);
    // test(13, "0.", true);  //Cannot be more disagree!!!
    // test(14, "00.5", true);  //Strongly cannot agree
    // test(15, "123e1", true);
    // test(16, "1.23e10", true);
    // test(17, "0.5e-10", true);
    // test(18, "1.0e4.5", false);
    // test(19, "0.5e04", true);
    // test(20, "12 3", false);
    // test(21, "1a3", false);
    // test(22, "", false);
    // test(23, "     ", false);
    // test(24, null, false);
    // test(25, ".1", true); //Ok, if you say so
    // test(26, ".", false);
    // test(27, "2e0", true);  //Really?!
    // test(28, "+.8", true);  
    // test(29, " 005047e+6", true);  //Damn = =|||
    // test(27, "46.e3", true);

    public static void main(String[] args){
        tryyy tr=new tryyy(); 
        String s="2e10";
        boolean ans = tr.isNumber(s);
        System.out.println (ans);  
    }
}



// import java.util.ArrayList;
// import java.util.List;
// import java.util.Arrays;
// import java.util.Set;
// import java.util.HashSet;
// import java.util.Iterator;

public class tryyy
{


   public String reverseString(String s) 
   {
        //我第一次寫
        // char[] news=s.toCharArray();
        // char[] reverses=new char[news.length];
        // for(int i=news.length-1;i>=0;i--)
        // {
        //     reverses[news.length-1-i]=news[i];
        // }

        // String ss=String.valueOf(reverses);
        // return ss;




        //較好的答案 o(n)
        // String result = "";
        // for (int i = s.length() - 1; i >= 0; i--)
        //     result += s.charAt(i);
        
        // return result;

        //更好的解 o(n/2)
        char[] ch = s.toCharArray();
        int halfLength = s.length() / 2;
        char temp;
        for (int i = 0; i < halfLength; i++) 
        {
            temp = ch[s.length() - 1 - i];
            ch[s.length() - 1 - i] = ch[i];
            ch[i] = temp;
        }
        return new String(ch);

        
            
        
    }
   

    public static void main(String[] args) 
    {
      tryyy tr=new tryyy();
      System.out.print(tr.reverseString("A man,"));
      

    }



}
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;
import java.util.Stack;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.PriorityQueue; 
import java.util.LinkedList;

public class tryyy
{
////////////////////////////Others//////////////////////////////
    public int countBattleships(char[][] board) {
        int row=board.length;
        int col= row>0 ? board[0].length : 0;
        int count = 0;
        for(int i=0;i<row;i++)
            for(int j=0;j<col;j++)
                if(board[i][j]=='X' && (i==0 || board[i-1][j]=='.') && (j==0 || board[i][j-1]=='.'))
                    count++;
        return count;
    }

    public static void main(String[] args){
        tryyy tr=new tryyy();
        char[][] board={{'X','.','.','X'},
                        {'.','.','.','X'},
                        {'.','.','.','X'}};
        int ans=tr.countBattleships(board);
        System.out.println(ans);
    }
}
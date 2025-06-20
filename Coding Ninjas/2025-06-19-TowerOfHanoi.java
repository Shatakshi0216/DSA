import java.util.ArrayList;

public class Solution 
{   public static void solveHanoi(int n,int src,int hel,int des,ArrayList < ArrayList<Integer>> result)
    {
        if(n==0) return;
        solveHanoi(n-1,src,des,hel,result);

        ArrayList<Integer> move = new ArrayList<>();

        move.add(src);
        move.add(des);
        result.add(move);

        solveHanoi(n-1,hel,src,des,result);

    }
    public static ArrayList < ArrayList<Integer>> towerOfHanoi(int n) 
    {
        //    Write your code here.
        ArrayList < ArrayList<Integer>> result = new ArrayList<>();
        
        solveHanoi(n,1,2,3,result);
        return result;


    }
}

import java.util.ArrayList;

public class Solution 
{
    public static void solve(int n,int fromRod,int toRod,int auxRod,ArrayList < ArrayList<Integer>> result)
    {
        if(n==0) return;

        // Move n-1 disks from source to auxillary 
        solve(n-1,fromRod,auxRod,toRod,result);

        // Move nth disk from source to destination 
        ArrayList<Integer> move = new ArrayList<>();
        move.add(fromRod);
        move.add(toRod);
        result.add(move);

        // Move n-1 disks from auxillary to destination 
        solve(n-1,auxRod,toRod,fromRod,result); 
    }
    public static ArrayList < ArrayList<Integer>> towerOfHanoi(int n) 
    {
        //    Write your code here.
        ArrayList < ArrayList<Integer>> result = new ArrayList<>();
        solve(n,1,3,2,result); // Move rod 1 to 3 using 2 
        return result;
    }
}

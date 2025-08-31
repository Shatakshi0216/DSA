import java.util.*;
public class Solution {
    public static List<Integer> collidingAsteroids(int []asteroids) {
        //    Write your code here.
        List<Integer> result = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        for(int x : asteroids)
        {
            if(x>0) st.push(x); // Positive 
            else 
            {
                while(!st.isEmpty() && st.peek()>0 && st.peek()<Math.abs(x)) st.pop(); // negative no. and peaks are positive and small
                if(!st.isEmpty() && st.peek()==Math.abs(x)) st.pop(); // Same size different sign
                else if(st.isEmpty() || st.peek()<=0) st.push(x); // Negative and negative 
            }
            
        }
        while(!st.isEmpty())
        {
            result.add(st.pop());
        }
        Collections.reverse(result);
        return result;
    }
}

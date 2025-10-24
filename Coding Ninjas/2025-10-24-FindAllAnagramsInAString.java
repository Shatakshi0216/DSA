import java.util.*;

public class Solution {
    public static ArrayList<Integer> findAnagramsIndices(String str, int n, String ptr, int m){
        // Write your code here.
        ArrayList<Integer> result = new ArrayList<>();
        if(m>n) return result;
        
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<m;i++)
        {
            map.put(ptr.charAt(i),map.getOrDefault(ptr.charAt(i),0)+1);
        }
        int i = 0;
        int j = 0;
        int count = map.size();
        while(j<n)
        {
            char ch = str.charAt(j);
            if(map.containsKey(ch))
            {
                map.put(ch,map.get(ch)-1);
                if(map.get(ch)==0) count--;
            }

            if(j-i+1<m) j++;

            else if(j-i+1==m)
            {
                if(count==0) result.add(i);
                char left = str.charAt(i);
                if(map.containsKey(left))
                {
                    if(map.get(left)==0) count++;
                    map.put(left,map.get(left)+1);
                }
                i++;
                j++;
            }
        }
        return result;

    }
}

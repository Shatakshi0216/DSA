import java.util.*;
public class Solution {

	public static int kDistinctChars(int k, String str) {
		// Write your code here
		HashMap<Character,Integer> map = new HashMap<>();
		int l = 0,r = 0,max = 0;
		while(r<str.length())
		{
			map.put(str.charAt(r),map.getOrDefault(str.charAt(r),0)+1);
			if(map.size()>k)
			{
				map.put(str.charAt(l),map.get(str.charAt(l))-1);
				if(map.get(str.charAt(l))==0) map.remove(str.charAt(l));
				l++;
			}
			max = Math.max(max,r-l+1);
			r++;
		}
		return max;
	}

}

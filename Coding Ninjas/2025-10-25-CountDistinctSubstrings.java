
import java.util.*;

public class Solution 
{

	public static int countDistinctSubstrings(String s) 
	{
		//	  Write your code here.
		
		HashSet<String> set = new HashSet<>();
		
		for(int i=0;i<s.length();i++)
		{	
			StringBuilder sb = new StringBuilder();
			for(int j=i;j<s.length();j++)
			{
				sb.append(s.charAt(j));
				set.add(sb.toString());
			}
		}
		return set.size()+1;
	}
}

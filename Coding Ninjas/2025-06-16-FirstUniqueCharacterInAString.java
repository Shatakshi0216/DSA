import java.util.* ;
import java.io.*; 
public class Solution {
	public static char firstNonRepeating(String str) {
		// Write your code here
		HashMap<Character,Integer> map = new HashMap<>();
		for(int i=0;i<str.length();i++)
		{
			if(map.containsKey(str.charAt(i))) map.put(str.charAt(i),map.get(str.charAt(i))+1);
			else map.put(str.charAt(i),1);
		}
		for(int i=0;i<str.length();i++)
		{
			if(map.get(str.charAt(i))==1) return str.charAt(i);
		}
		return '#';
	}
}

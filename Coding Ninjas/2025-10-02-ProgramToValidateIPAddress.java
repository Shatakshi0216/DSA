import java.util.* ;
import java.io.*; 

public class Solution {

	public static boolean isValidIPv4(String ipAddress) {
		// write your code here
		String[] parts = ipAddress.split("\\.");
		if(parts.length!=4) return false; // Must have 4 parts 

		for(String part : parts)
		{
			if(part.isEmpty()) return false; // Empty part not allowed

			try{
				int num = Integer.parseInt(part);
				if(num<0 || num>255) 	return false; // Out of range 
			}
			catch(NumberFormatException e)
			{
				return false;
			}

		}
		return true;
	}

}

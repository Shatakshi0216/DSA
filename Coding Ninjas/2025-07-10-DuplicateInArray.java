import java.util.ArrayList;
import java.util.*;
public class Solution {

	public static int findDuplicate(ArrayList<Integer> arr) {

		//    Write your code here.
		Collections.sort(arr);
		for(int i=1;i<arr.size();i++)
		{
			if(arr.get(i).equals(arr.get(i-1))) return arr.get(i);
		}
		return -1;
	}
}

import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {

	public static int findSum(int n, ArrayList<Integer> arr) {
		// Write your code here
		int sum = 0;
		for(int i = 0; i < arr.size(); i++){
			if (arr.get(i) % 2 == 0 || arr.get(i) % 3 == 0){
				sum += arr.get(i);
			}
		}
		return sum;
	}
}

import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {

	public static String decrypt(String message, ArrayList<ArrayList<Integer>> operations) {
		// Write your code here.
		int n = message.length();
		int netRot = 0;

		for(int i = 0; i < operations.size(); i++){
			int dir = operations.get(i).get(0);
			int amt = operations.get(i).get(1);

			if (dir == -1)
				netRot -= amt;
			else if (dir == 1)
				netRot += amt;
		}

		netRot = ((netRot % n) + n) % n;

		String rotated = message.substring(n - netRot) + message.substring(0, n - netRot);

		return rotated;
	}
}

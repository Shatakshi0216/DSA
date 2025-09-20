public class Solution {

	
	public static void answer(String s1,String s2,String s3)
	{

		// Write your code here
		// Step 1: quick length check
        if (s1.length() + s2.length() != s3.length()) {
            System.out.println("NO");
            return;
        }

        // Step 2: frequency arrays for 26 uppercase letters
        int[] count = new int[26];
        
        // count for s1
        for (char c : s1.toCharArray()) {
            count[c - 'A']++;
        }
        // count for s2
        for (char c : s2.toCharArray()) {
            count[c - 'A']++;
        }
        // subtract count using s3
        for (char c : s3.toCharArray()) {
            count[c - 'A']--;
        }

        // Step 3: check if all counts are zero
        for (int val : count) {
            if (val != 0) {
                System.out.println("NO");
                return;
            }
        }
        
        System.out.println("YES");
	}
	

	
}

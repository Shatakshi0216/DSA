import java.util.* ;
import java.io.*; 
public class Solution {

	public static boolean splitString(String s) {
		// Write your code here
        int n = s.length();
        if (n < 3) return false; // cannot get 3 non-empty parts

        // try every split position: a = s[0..i-1], b = s[i..j-1], c = s[j..n-1]
        for (int i = 1; i <= n - 2; i++) {
            for (int j = i + 1; j <= n - 1; j++) {
                String a = s.substring(0, i);
                String b = s.substring(i, j);
                String c = s.substring(j, n);

                // check the three possibilities
                // a substring of both b and c
                if (b.indexOf(a) != -1 && c.indexOf(a) != -1) return true;
                // b substring of both a and c
                if (a.indexOf(b) != -1 && c.indexOf(b) != -1) return true;
                // c substring of both a and b
                if (a.indexOf(c) != -1 && b.indexOf(c) != -1) return true;
            }
        }
        return false;
	}

}

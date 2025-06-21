import java.util.* ;
import java.io.*; 
/*
	This is signature of helper function 'knows'.
	You should not implement it, or speculate about its implementation.

	boolean knows(int A, int B); 
	Function 'knows(A, B)' will returns "true" if the person having
	id 'A' know the person having id 'B' in the party, "false" otherwise.
	Use it as Runner.knows(A, B);
*/
	
public class Solution {
	public static int findCelebrity(int n) {
        // Write your code here.
		int i=0;
		int j=n-1;
		
		while(i<=j)
		{
			if(Runner.knows(i,j)) i++; // i cant be celeb
			else j--; // j cant be celeb 
		}
		int celeb = i; // at last i and j will be equal and that one can be celeb because it it not eiminated
		
		for(int k = 0; k < n; k++) {
			if(k != celeb) {
				if(Runner.knows(celeb, k) || !Runner.knows(k, celeb)) return -1;
			}	
		}	
		return celeb;
	}
}


    

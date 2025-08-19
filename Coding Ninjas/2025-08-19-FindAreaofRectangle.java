import java.util.Scanner;

class Solution {
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		// Taking input of length and breadth
		int L = sc.nextInt();
		int B = sc.nextInt();
		
		// Calculating area
		int area = L * B;
		
		// Printing output
		System.out.println(area);
		
		sc.close();
	}
}

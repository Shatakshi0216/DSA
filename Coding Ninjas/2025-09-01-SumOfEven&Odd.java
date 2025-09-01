import java.util.Scanner;

class Solution {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        // Input integer N
        int N = sc.nextInt();
        
        int evenSum = 0; // sum of even digits
        int oddSum = 0;  // sum of odd digits
        
        int temp = N; // copy of N to process digits
        
        while (temp > 0) {
            int digit = temp % 10; // extract last digit
            
            if (digit % 2 == 0) {
                evenSum += digit; // add to even sum
            } else {
                oddSum += digit; // add to odd sum
            }
            
            temp /= 10; // remove last digit
        }
        
        // Print sums
        System.out.println(evenSum + " " + oddSum);
        
        sc.close();
    }
}

public class Solution {  

    public static int findUnique(int[] arr) {
        int unique = 0;
        for(int num : arr) {
            unique ^= num;   // XOR with each element
        }
        return unique;
    }
}

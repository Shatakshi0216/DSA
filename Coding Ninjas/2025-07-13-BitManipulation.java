public class Solution {
    public static int[] bitManipulation(int num, int i){
        int pos = i - 1;

        int bit = (num >> pos) & 1;

        int setBit = num | (1 << pos);

        int clearBit = num & ~(1 << pos);

        return new int[]{bit, setBit, clearBit};
    }
}

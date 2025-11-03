class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length - 1;

        while (i <= j) {
            if (nums[i] == val) {
                // Swap nums[i] with nums[j] and shrink the array from the right
                nums[i] = nums[j];
                j--;
            } else {
                i++;
            }
        }

        // After the loop, 'j + 1' is the length of the array without 'val'
        return j + 1;
    }
}

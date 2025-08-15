class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[nums1.length];

        // Step 1: Find Next Greater Element for each element in nums2
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= nums2[i]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                map.put(nums2[i], st.peek());
            } else {
                map.put(nums2[i], -1);
            }
            st.push(nums2[i]);
        }

        // Step 2: For each element in nums1, get its NGE from map
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }

        return result;
    }
}

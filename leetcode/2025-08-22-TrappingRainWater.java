class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length-1;
        int ans  = 0;
        int lMax = 0;
        int rMax = 0;
        while(l<r)
        {
            lMax = Math.max(lMax,height[l]);
            rMax = Math.max(rMax,height[r]);

            if(lMax<rMax)
            {
                ans += lMax - height[l];
                l++;
            }
            else 
            {
                ans += rMax - height[r];
                r--;
            }
        }
        return ans;
    }
}

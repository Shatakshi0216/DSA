class Solution {
    public int nthUglyNumber(int n) {
        int  ugly[] = new int[n];    // 1 2 3 4 5

        ugly[0] = 1;
        int i2=0; //2
        int i3=0; //1
        int i5=0; //1
        int next2=2; // 8
        int next3=3; // 6
        int next5=5;

        for(int i=1;i<n;i++)
        {
            int uglyNum = Math.min(next2,Math.min(next3,next5));
            ugly[i] = uglyNum;

            if(uglyNum==next2)   i2++;
            if(uglyNum==next3)   i3++;
            if(uglyNum==next5)   i5++;

            next2 = ugly[i2]*2;
            next3 = ugly[i3]*3; 
            next5 = ugly[i5]*5;

        }
        return ugly[n-1];


    }
}

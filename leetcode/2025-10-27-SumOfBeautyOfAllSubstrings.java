class Solution {
    public int max(int fre[])
    {   
        int maxEle = Integer.MIN_VALUE;
        for(int i=0;i<26;i++)
        {
            maxEle = Math.max(fre[i],maxEle);
        }
        return maxEle;
    }
    public int min(int fre[])
    {   
        int minEle = Integer.MAX_VALUE;
        for(int i=0;i<26;i++)
        {   
            if(fre[i]!=0)
            {
                minEle = Math.min(fre[i],minEle);
            }
            
        }
        return minEle;
    }
    public int beautySum(String s) {
        int n = s.length();
        
        int sum = 0;
        for(int i=0;i<n;i++)
        {   
            int fre[] = new int[26];
            for(int j=i;j<n;j++)
            {   
                
                fre[s.charAt(j)-'a']++;
                int mostFre = max(fre);
                int leastFre = min(fre);
                sum += (mostFre-leastFre);
            }
            
        }
        return sum;
    }
}

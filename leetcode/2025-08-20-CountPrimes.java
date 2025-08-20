class Solution {
    public int countPrimes(int n) {
        if(n <= 2) return 0; // There are no primes < 2
        int primes[] = new int[n+1];
        
        Arrays.fill(primes, 1); // for loop (i->2 to n)
        primes[0] = 0;
        primes[1] = 0;

        for(int i=2;i<=Math.sqrt(n);i++)
        {
            if(primes[i]==1)
            {
                for(int j=i*i;j<n;j+=i)
                {
                    primes[j] = 0;
                }
            }
        }
        int count = 0;
        for(int i=2;i<n;i++)
        {
            if(primes[i]==1) count++;
        }
        return count;
    }
    
}

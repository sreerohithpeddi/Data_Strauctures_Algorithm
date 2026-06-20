class Solution {
    public int countPrimes(int n) {

        int count = 0;
        Boolean[] primes = new Boolean[n];
        if(n<2){
            return 0;
        }
        
        for(int i=2;i<n;i++){
            primes[i] = true;
        }

        for(int i=2;i<n;i++){
            if(primes[i]){
                for(int j=2*i;j<n;j+=i){
                    primes[j]=false;
                }
            }
        }

        for(int i=2;i<n;i++){
            if(primes[i]){
                count++;
            }
        }
        return count;
        
    }
}
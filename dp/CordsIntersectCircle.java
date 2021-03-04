public class Solution {
    public int chordCnt(int a) {
        int n =  2*a;
        int M = 1000000007;
        long[] dp = new long[n+1];
        dp[0] = 1;
        dp[2] = 1;
        
        for(int i = 4; i <= n ; i+=2){
            for(int j = 0; j < i; j+=2){
                dp[i] += (dp[j]%M * dp[i-j-2]%M)%M;
                dp[i] %= M;
            }
        }
        
        return (int)dp[n];
        
    }
}

/*
5 + 4 + 5

28
8
36
42

4+2-1
1+ 4+ 3 + 4 +5
  1 2 3 4 5 6 7 8
1 0 1 0 2 0 5 0 14
2   0 1 0 2 0 5 0
3     0 1 0 2 0 5
4       0 1 0 2 0
5         0 1 0 2
6           0 1 0
7             0 1
8               0

*/

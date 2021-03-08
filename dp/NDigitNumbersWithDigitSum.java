public class Solution {
    public int solve(int n, int s) {
        int M = 1000000007;
        long[][] dp = new long[n+1][s+1];
        
        for(int i = 0 ; i <= n ; i++){
            for(int j = 0 ; j <= s; j++){
                if(i==0 && j==0){
                    dp[i][j] = 1;
                } 
                else if(i == 0 || j==0) continue;
                else{
                    for(int p = 0; p <= 9; p++){
                        if(j-p >= 0){
                            dp[i][j] = (dp[i][j] + dp[i-1][j-p]%M)%M;
                        }
                    }
                }
            }
        }
        return (int)dp[n][s];
    }
}

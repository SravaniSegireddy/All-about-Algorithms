class Solution {
    public int coinChange(int[] arr, int k) {
        int n = arr.length;
        int dp[][] = new int[n+1][k+1];
        
        for(int i = 0 ; i <= n ; i++){
            for(int j = 0 ; j <= k ; j++){
                if(i == 0) dp[i][j] = Integer.MAX_VALUE;
                else if(j == 0) dp[i][j] = 0;
                else{
                    dp[i][j] = dp[i-1][j];
                    
                    if(j >= arr[i-1]){
                        dp[i][j] = Math.min(dp[i][j], dp[i][j-arr[i-1]] == Integer.MAX_VALUE ? Integer.MAX_VALUE : 1+dp[i][j-arr[i-1]]);
                    }
                    
                }
            }
        }
        
        return dp[n][k] == Integer.MAX_VALUE ? -1 : dp[n][k];
    }
}

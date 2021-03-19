public class Solution {
    public int solve(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        if(n ==1 && m == 1) return arr[0][0];
        
        int[][] dp = new int[n][m];
        dp[n-1][m-1] = arr[n-1][m-1];
        int max = Math.max(Integer.MIN_VALUE, dp[n-1][m-1]);
        
        for(int j = m-2; j >= 0 ; j--){
            
            dp[n-1][j] = arr[n-1][j]+dp[n-1][j+1];
            max = Math.max(dp[n-1][j], max);
        }
        for(int i = n-2; i >= 0 ; i--){
            dp[i][m-1] = arr[i][m-1]+dp[i+1][m-1];
            max = Math.max(dp[i][m-1], max);
        }
        
        for(int j = m-2; j >= 0 ; j--){
            for(int i = n-2; i >= 0 ; i--){
                dp[i][j] =  arr[i][j]+dp[i][j+1]+dp[i+1][j]-dp[i+1][j+1];
                max = Math.max(dp[i][j], max);
            }
        }
        
        return max;
    }
}

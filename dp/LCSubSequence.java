// https://www.interviewbit.com/problems/longest-common-subsequence/


public class Solution {
    public int solve(String a, String b) {
        int m = a.length();
        int n = b.length();
        
        int[][] dp = new int[n][m];
        
        for(int i = 1; i <= n; i++){
            for(int j= 1; j <= m ; j++){
                if(a.charAt(j-1) == b.charAt(i-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
}

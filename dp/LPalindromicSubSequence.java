public class Solution {
    public int solve(String a) {
        int n = a.length();
        int[][] dp = new int[n][n];
        
        for(int l = 1; l <= n ; l++){
            int i = 0 , j = l-1;
            while(j<n){
                if(a.charAt(i) == a.charAt(j)){
                    dp[i][j] = i==j ? 1 : 2+dp[i+1][j-1];
                }
                else{
                    dp[i][j] = i==j ? 0 : Math.max(dp[i+1][j],dp[i][j-1]);
                }
                i++;j++;
            }
        }
        return dp[0][n-1];
    }
    //reverse the string
     public int lcs(String a, String b) {
        int m = a.length();
        int n = b.length();
        
        int[][] dp = new int[n+1][m+1];
        
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

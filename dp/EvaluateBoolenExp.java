public class Solution {
    int m = 1003;
    public int cnttrue(String s) {
        
        int n = s.length();
        int[][][] dp = new int[n+1][n+1][2];
        
        
        for(int j = 1; j <= n ; j+=2){
            for(int i = n ; i > 0 ; i-=2){
                if(i > j) continue;
                else if(i == j){
                    dp[i][j][1] = s.charAt(i-1) == 'T' ? 1 : 0;
                    dp[i][j][0] = s.charAt(i-1) == 'F' ? 1 : 0;
                }
               
                else{
                    
                    for(int k = i+1; k < j; k+=2){
                        dp[i][j][1] += countT(i, k, j, dp, s)%m;
                        dp[i][j][0] += countF(i, k, j, dp, s)%m;
                        dp[i][j][1] %= m;
                        dp[i][j][0] %= m;
                    }
                    
                }
            }
        }
        
        return dp[1][n][1];
    }
    
    int countT(int i, int k, int j, int[][][] dp, String s){
        char op = s.charAt(k-1);
        if(op == '|')
            return dp[i][k-1][0]*dp[k+1][j][1]+dp[i][k-1][1]*dp[k+1][j][0]+dp[i][k-1][1]*dp[k+1][j][1];
        else if(op == '&')
            return dp[i][k-1][1]*dp[k+1][j][1];
        return  dp[i][k-1][0]*dp[k+1][j][1] +dp[i][k-1][1]*dp[k+1][j][0]; 
    }
    
    int countF(int i, int k, int j, int[][][] dp, String s){
        char op = s.charAt(k-1);
        if(op == '&')
            return dp[i][k-1][0]*dp[k+1][j][1]+dp[i][k-1][1]*dp[k+1][j][0]+dp[i][k-1][0]*dp[k+1][j][0];
        else if(op == '|')
            return dp[i][k-1][0]*dp[k+1][j][0];
        return  dp[i][k-1][0]*dp[k+1][j][0] +dp[i][k-1][1]*dp[k+1][j][1]; 
    }
}

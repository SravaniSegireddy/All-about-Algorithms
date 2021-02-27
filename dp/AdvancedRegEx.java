public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    boolean dp[][];
    public int isMatch(final String a, final String b) {
        
        int m = a.length();
        int n = b.length();
        
        dp = new boolean[n+1][m+1];
        
        dp[0][0] = true;
        boolean allZero = false;
        for(int i = 1 ; i <= n ; i++){
            if(allZero) dp[i][0] = false;
            if(i == 1){
                if(b.charAt(i-1) == '*') dp[i][0] = true;
                else dp[i][0] = false;
            }
            else{
                if(b.charAt(i-1) != '*' && b.charAt(i-2) != '*')
                allZero = true;
            
                dp[i][0] = b.charAt(i-1) == '*' ? true:false;
            }
            
        }
        
        char prev = '$';
        
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= m; j++){
                if(b.charAt(i-1) == '*'){
                    dp[i][j] = dp[i-1][j] || (dp[i][j-1] &&(prev == '$' || a.charAt(j-1)==prev)) || (i > 1 ? dp[i-2][j] : false);
                }
                else{
                    if(b.charAt(i-1) == '.') dp[i][j] = dp[i-1][j-1];
                    else{
                        prev = b.charAt(i-1);
                        dp[i][j] = a.charAt(j-1) == b.charAt(i-1) && dp[i-1][j-1];
                    } 
                    
                }
            }
        }
        
        return dp[n][m]?1:0;
}
}

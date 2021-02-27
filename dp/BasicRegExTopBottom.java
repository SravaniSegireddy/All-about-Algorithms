public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    boolean dp[][];
    public int isMatch(final String a, final String b) {
        
        int m = a.length();
        int n = b.length();
        dp = new boolean[n+1][m+1];
        dp[0][0] = true;
        for(int j = 1 ; j <= n ; j++){
            dp[j][0] = b.charAt(j-1) == '*' && dp[j-1][0];
        }
        
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= m; j++){
                if(b.charAt(i-1) == '*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
                else{
                    if(b.charAt(i-1) == '?') dp[i][j] = dp[i-1][j-1];
                    else dp[i][j] = a.charAt(j-1) == b.charAt(i-1) && dp[i-1][j-1];
                }
            }
        }
        
        return dp[n][m]?1:0;
    }
    
    
    // boolean util(String a, String b , int i , int j){
    //     if(i == a.length() && j == b.length()) return true;
    //     if(j == b.length() ) return false;
        
    //     if(i == a.length()){
    //         int tmp  = j;
    //         while(tmp < b.length()){
    //             if(b.charAt(tmp) != '*'){
    //                 return false;
    //             }  
    //             tmp++;
    //         }
    //         return true;
    //     }
        
    //     if(dp[i][j] != -1) return dp[i][j] == 1 ? true:false;
        
    //     if(b.charAt(j) != '*' && b.charAt(j) != '?'){
    //         if(a.charAt(i) != b.charAt(j)){
    //             dp[i][j] = 0;
    //             return false;
    //         } 
    //     }
        
    //     // consider
        
    //     boolean left = util(a, b, i+1, j+1);
        
    //     if(left){
    //         dp[i][j] = 1;
    //         return left;
    //     } 
        
    //     //not consider
    //     boolean right = false;
    //     if(b.charAt(j) == '*'){
    //         right = util(a, b, i+1, j) || util(a, b, i, j+1);
    //     }
        
    //     dp[i][j] = left || right ? 1 : 0;
    //     return left || right;
    // }
}


/*

A = "caab"
B = "c*a*b"

*/

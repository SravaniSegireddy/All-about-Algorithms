public class Solution {
    int[][] dp;
    public int isInterleave(String a, String b, String c) {
        
        int m = a.length()+1;
        int n = b.length()+1;
        
        dp = new int[a.length()+1][b.length()+1];
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                dp[i][j] = -1;
            }
        }
        
        return check(a, b, c, 0,0, 0) ? 1 : 0;
    }
    
    boolean check(String a, String b, String c, int i, int j, int index){
        if(i==a.length() && j == b.length()) return true;
        
        if(dp[i][j] != -1)  return dp[i][j] == 1 ? true:false;
        
        boolean left = false;
        if(i < a.length()){
            left = c.charAt(index) == a.charAt(i) && check(a, b, c, i+1, j, index+1);
        }
        
        boolean right = false;
        if(j< b.length()){
           right =  c.charAt(index) == b.charAt(j) && check(a, b, c, i, j+1, index+1);
        }
        dp[i][j] = left||right ? 1 : 0;
        return left || right;
    }
}

public class Solution {
    public int canJump(int[] a) {
        int n = a.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        // System.out.println(n);
        for(int i = 0 ; i < n ; i++){
            if(!dp[i]) {
                // System.out.println("reached");
                return 0;
            }
            // System.out.println(a[i]);
            for(int j = 1; j <= a[i] && i+j < n ; j++){
                dp[i+j] = true;
                if(i+j == n-1) return 1;
            }
        }
        return 1;
    }
}

public class Solution {
    public int maxcoin(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        
        for(int j = 0; j < n ; j++){
            for(int i = n-1; i >= 0; i--){
                if(i > j) continue;
                if(i == j) dp[i][j] = arr[i];
                else{
                    dp[i][j] = Math.max(arr[i]+getSum(i+1,j,arr)-dp[i+1][j], arr[j]+getSum(i, j-1,arr)-dp[i][j-1]);
                }
            }
        }
        
        return dp[0][n-1];
    }
    
    int getSum(int i, int j, int[] arr){
        // System.out.println(i+" "+j);
        int sum = 0;
        while(i <= j){
            sum += arr[i];
            i++;
        }
        
        return sum;
    }
}

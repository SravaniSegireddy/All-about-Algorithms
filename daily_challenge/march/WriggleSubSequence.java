class Solution {
    public int wiggleMaxLength(int[] arr) {
        int n = arr.length;
        
        int[][] dp = new int[n][2];
        int max = 1;
        for(int i = 0 ; i < n ; i++){
            dp[i][0] = 1;
            dp[i][1] = 1;
            for(int j = i-1; j >= 0 ; j--){
                if(arr[i] > arr[j]) dp[i][1] = Math.max(dp[i][1], dp[j][0]+1);
                else if(arr[i] < arr[j]) dp[i][0] = Math.max(dp[i][0], dp[j][1]+1);
            }
            max = Math.max(max, Math.max(dp[i][0],dp[i][1]));
        }
        
        return max;
    }
}

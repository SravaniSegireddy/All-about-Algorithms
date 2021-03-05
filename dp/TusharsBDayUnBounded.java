public class Solution {
    public static int[] solve(int a, int[] arr) {
        int[] dp = new int[a+1];
        int[] index = new int[a+1];
        int n = arr.length;
        
        for(int i = 0 ; i <=a;i++){
            for(int j = 0 ; j < n ; j++){
                if(i >= arr[j]){
                    if(dp[i] < dp[i-arr[j]]+1){
                        index[i] = j;
                        dp[i] = dp[i-arr[j]]+1;
                    }
                }
            }
        }
        
        int res[] = new int[dp[a]];
        int i = 0 ;
        
        while(a > 0 && a >= arr[index[a]]){
            res[i++] = index[a];
            a -= arr[index[a]];
        }
        return res;
    }
}

/*
  0 1 2 3 4 5 6 7 8 9 10 11
" 0 0 0 ===================
6 0 0======== 1 0 0 0 0  0
8 0 ==========1===1 0 0  0 
5 0 ========1 1 0 0 0 2  2
4 0 ======1 1 1 0 2 2 2  2
7 0=======1 1 1 1 2 2 2  2

*/
/*
1. sum should be max and <= A
2. length shoudl be max
3. order should be lexicographic min

*/

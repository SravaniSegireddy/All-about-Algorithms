public class Solution {
    public int solve(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int[][] col = new int[m][n];
        
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(i == 0){
                    col[i][j] = arr[i][j];
                }
                else{
                    col[i][j] = arr[i][j] == 0 ? 0 : col[i-1][j]+1;
                }
            }
        }
        
        for(int[] curr : col){
            Arrays.setAll(curr, i -> ~curr[i]);
            Arrays.sort(curr);
            Arrays.setAll(curr, i -> ~curr[i]);
        }
        
        int max = Integer.MIN_VALUE;
        
        for(int i = 0 ; i < m ;i++){
            for(int j = 0 ; j < n ; j++){
                // System.out.print(col[i][j]+" ");
                max = Math.max(max, col[i][j]*(j+1));
            }
            // System.out.println();
        }
        return max;
        
    }
}

class Solution {
    
    int[][] arr;
    int[] dx = new int[]{-1,1,0,0};
    int[] dy = new int[]{0,0,-1,1};
    public List<List<Integer>> pacificAtlantic(int[][] a) {
        int n = a.length;
        
        if(n==0) return new ArrayList<List<Integer>>();
        int m = a[0].length;
        
        arr = a;
        
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];
        
        for(int i= 0 ; i < n ; i++){
            dfs(i, 0, pacific);
            dfs(i, m-1, atlantic);
        }
        
        for(int j = 0 ; j < m ; j++){
            dfs(0, j, pacific);
            dfs(n-1, j, atlantic);
        }
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i= 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){

                if(pacific[i][j] && atlantic[i][j]){
                    ArrayList<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(i);tmp.add(j);
                    res.add(tmp);
                }
                    
            }
        }
        
        return res;
    }
    
    
    void dfs(int i , int j, boolean[][] dp){
        int n = dp.length;
        int m = dp[0].length;
        
            dp[i][j] = true;
            for(int p = 0 ; p < 4; p++){
                int tmpx = i+dx[p];
                int tmpy = j+dy[p];
                if(tmpx>= 0 && tmpy >= 0 && tmpx < n && tmpy < m){
                    if(dp[tmpx][tmpy]) continue;
                    
                    if(arr[i][j] <= arr[tmpx][tmpy])
                        dfs(tmpx, tmpy, dp);
                }
            }
    }
}

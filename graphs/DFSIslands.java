public class Solution {
    int m,n;
    int[] dx = new int[]{-1, 1, 0, 0};
    int[] dy = new int[]{0, 0, -1, 1};
    public int black(ArrayList<String> a) {
        m = a.size();
        n = a.get(0).length();
        
        int count = 0;
        
        for(int i = 0 ; i < m ; i++){
            for(int j = 0; j < n ; j++){
                if(a.get(i).charAt(j) == 'X'){
                    dfs(i, j, a);count++;
                }
                    
            }
        }
        
        return count;
    }
    
    
    void dfs(int i, int j, ArrayList<String> a){
        
        if(i < 0 || j < 0 || i >= m || j >= n) return;
        char c = a.get(i).charAt(j);
        if(c == 'Y' || c == 'O') return;
        
        StringBuilder sb = new StringBuilder(a.get(i));
        sb.setCharAt(j, 'Y');
        a.set(i, sb.toString());
        
        for(int p = 0 ; p < 4 ; p++){
            dfs(i+dx[p], j+dy[p], a);
        }
        
    }
}

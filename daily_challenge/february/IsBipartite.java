class Solution {
    public boolean isBipartite(int[][] graph) {
        int color[] = new int[graph.length];
        
        Arrays.fill(color, -1);
        
        for(int i = 0 ; i < graph.length ; i++){
            if(color[i] == -1){
                color[i] = 0;
                if(!dfs(graph, i, color)) return false;
            }
        }
                
        return true;
        
    }
    
    boolean dfs(int[][] graph, int node, int[] color){
        int[] adj = graph[node];
        
        for(int v : adj){
            if(color[v] == color[node]) return false;
            if(color[v] == -1){
                
                color[v] = 1-color[node];
                if(!dfs(graph, v, color)) return false;
            }
        }    
        
        
        return true;
    }
    
    
}

class Solution {
    int[] dx = new int[]{-1,-1,1,1, 0,0,-1,1};
    int[] dy = new int[]{-1,1,-1,1,-1,1,0,0};
    public int shortestPathBinaryMatrix(int[][] arr) {
        
        int n = arr.length;
        if(arr[0][0] == 1) return -1;
        Queue<Pair> q = new LinkedList<Pair>();
        int[][] visited = new int[n][n];
        q.add(new Pair(0,0));
        visited[0][0] = 1;
        
        int steps = 0;
        while(!q.isEmpty()){
            int size = q.size();
            steps++;
            while(size-- > 0){
                Pair p = q.remove();
                
                if(p.x == n-1 && p.y == n-1) return steps;
                
                for(int iter = 0; iter < 8 ; iter++){
                    int tmpx = dx[iter] + p.x;
                    int tmpy = dy[iter] + p.y;
                    if(tmpx >= 0 && tmpy >= 0 && tmpx < n && tmpy < n && visited[tmpx][tmpy] == 0 && arr[tmpx][tmpy] == 0){
                        visited[tmpx][tmpy] = 1;
                        q.add(new Pair(tmpx, tmpy));
                    }
                }
            }
        }
        
        return -1;
    }
}

class Pair{
    int x;
    int y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

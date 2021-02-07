public class Solution {
    
    int[] dx = new int[]{-1,1,0,0};
    int[] dy = new int[]{0,0,-1,1};
    char[] dp = new char[]{'U','D','L','R'};
    public int solve(int n, int m, ArrayList<String> arr) {
        
        // HashSet<String> visited = new HashSet<String>(); 
        int[][] visited = new int[n][m];
        Deque<Node> q= new LinkedList<Node>();
        if(n==0) return 0;
        q.addFirst(new Node(0,0,arr.get(0).charAt(0),0));

        while(!q.isEmpty()){
            Node curr = q.pollFirst();
            
            if(curr.x == n-1 && curr.y == m-1){
                return curr.cost;
            }
            // visited.add(curr.x+" "+curr.y);
            visited[curr.x][curr.y] = 1;

            for(int i = 0; i < 4 ; i++){
                int tmpx = curr.x+dx[i];
                int tmpy = curr.y+dy[i];
                
                if(tmpx < 0 || tmpy < 0 || tmpx >= n || tmpy >= m || visited[tmpx][tmpy] == 1){
                    continue;
                }
                
                int cost = 0;
                if(curr.val == 'L' && dx[i] ==0 && dy[i] ==-1) cost=0;
                else if (curr.val == 'U' && dx[i] ==-1 && dy[i] ==0)cost =0;
                else if (curr.val == 'D' && dx[i] ==1 && dy[i] ==0)cost=0;
                else if (curr.val == 'R' && dx[i] ==0 && dy[i] ==1) cost=0;
                else cost =1;
                
                if(cost == 0){
                    q.addFirst(new Node(tmpx, tmpy, arr.get(tmpx).charAt(tmpy), curr.cost));
                }
                else{
                    // System.out.println(tmpx);
                    q.addLast(new Node(tmpx, tmpy, arr.get(tmpx).charAt(tmpy), curr.cost+1));
                }
                    
                
            }
        }
        return -1;
    }
}

class Node{
    int x;
    int y;
    char val;
    int cost;
    
    Node(int x, int y, char val, int cost){
        this.x = x;
        this.y = y;
        this.val = val;
        this.cost = cost;
    }
}

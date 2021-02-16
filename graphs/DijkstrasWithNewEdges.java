public class Solution {
    int a;
    public int solve(int a, ArrayList<ArrayList<Integer>> b, int c, int d, ArrayList<ArrayList<Integer>> e) {
        this.a = a;
        HashMap<Integer, ArrayList<Node>> graph = new HashMap<Integer, ArrayList<Node>>();
        for(ArrayList<Integer> arr : b){
            graph.computeIfAbsent(arr.get(0), v-> new ArrayList<Node>()).add(new Node(arr.get(1), arr.get(2)));
            graph.computeIfAbsent(arr.get(1), v-> new ArrayList<Node>()).add(new Node(arr.get(0), arr.get(2)));
        }
        
        int[] cd = new int[a+1];
        djkstra(cd, graph, c, d);
        
        int[] dd = new int[a+1];
        djkstra(dd, graph, d, c);
        
        int min = cd[d];
        // System.out.println(min);
        for(ArrayList<Integer> arr : e){
            int left = arr.get(0);
            int right = arr.get(1);
            int weight = arr.get(2);
            
            if(cd[left] != Integer.MAX_VALUE && dd[right] != Integer.MAX_VALUE)
                min = Math.min(min, cd[left]+dd[right]+weight);
                
            if(dd[left] != Integer.MAX_VALUE && cd[right] != Integer.MAX_VALUE)
                min = Math.min(min, dd[left]+cd[right]+weight);
        }
        
        return min == Integer.MAX_VALUE ? -1 : min;
        
        
        
    }
    
    void djkstra(int[] cd, HashMap<Integer, ArrayList<Node>> graph, int c, int d){
        PriorityQueue<Node> pq = new PriorityQueue<Node>(a, new Node());
        pq.add(new Node(c,0));
        
        HashSet<Integer> visited = new HashSet<Integer>();
        visited.add(c);
        
        
        Arrays.fill(cd, Integer.MAX_VALUE);
        cd[c] = 0;
        
        
        while(!pq.isEmpty()){
            
            Node curr = pq.remove();
            
            if(!graph.containsKey(curr.value)) continue;
            
            for(Node adj : graph.get(curr.value)){
                
                if(!visited.contains(adj.value)){
                    
                    visited.add(adj.value);
                    
                    int edgeW = adj.cost;
                    int distSoFar = cd[curr.value]+edgeW;
                    
                    if(distSoFar < cd[adj.value])
                        cd[adj.value] = distSoFar;
                    // System.out.println(adj.value);
                    if(adj.value == d) return;
                    
                    pq.add(adj);
                }
            }
        }
    }
}




class Node implements Comparator<Node>{
    
    int cost;
    int value;
    
    Node(){}
    Node(int value, int cost){
        this.cost = cost;
        this.value = value;
    }
    public int compare(Node o1, Node o2){
        return o1.cost-o2.cost;
    }
}

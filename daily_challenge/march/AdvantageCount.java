class Solution {
    public int[] advantageCount(int[] a, int[] b) {
        
        int n = a.length;
        
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        for(int i = 0 ; i < n; i++){
            pq.add(new Node(b[i], i));
        }
        
        Arrays.sort(a);
        // Arrays.sort(b);
        
        int[] res = new int[n];
        Arrays.fill(res,-1);
        ArrayList<Integer> discard = new ArrayList<Integer>();
    
        int i = 0 , j = 0;
        while(i<n && !pq.isEmpty()){
            
            if(a[i] > pq.peek().val){
                
                Node curr = pq.poll();
                int idx = curr.idx;
                int val = curr.val;
                System.out.println(curr.val);
                res[idx] = a[i];   
            }
            else{
                discard.add(a[i]);
            }
            i++;
        }
        
        
        j = discard.size()-1;
        for(i=0;i < n;i++){
           if(res[i] == -1) {
               if(j>=0) res[i] = discard.get(j);j--;
           }
        }
        
        return res;
    }
    
    public class Node implements Comparable<Node>{
        int idx;
        int val;
        
        Node(int val,int idx){
            this.val=val;
            this.idx=idx;
        }
        
        @Override
        public int compareTo(Node other){
            return this.val-other.val;
        }
    }
}

class FreqStack {
    int pos;
    HashMap<Integer, Integer> hm;
    PriorityQueue<Node> pq;
    public FreqStack() {
        pos = 0;
        hm = new HashMap<Integer, Integer>();
        pq = new PriorityQueue<Node>(new Node());
    }
    
    public void push(int x) {
        hm.put(x, hm.getOrDefault(x,0)+1);
        pq.add(new Node(x, pos, hm.get(x)));
        pos++;
    }
    
    public int pop() {
        Node curr = pq.poll();
        int ans = curr.val;
        hm.put(ans, hm.get(ans)-1);
        return ans;
    }
}

class Node implements Comparator<Node>{
    int val;
    int pos;
    int freq;
    Node(){}
    Node(int val, int pos, int freq){
        this.val = val;
        this.pos = pos;
        this.freq = freq;
    }
    
    public int compare(Node o1, Node o2){
        if(o1.freq > o2.freq) return -1;
        else if(o1.freq < o2.freq) return 1;
        else{
            if(o1.pos >= o2.pos) return -1;
            else return 1;
        }
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */


/*

[[],[5],[7],[5],[4],[5],[],[],[],[]]
    5   7   5   5   5
5 -> index, freq (5, 0,1)
(1,1)
(2,2)
(3,1)
(4,3)
*/

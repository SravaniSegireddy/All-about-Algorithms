class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(new Pair());
        int row = 0;
        for(int[] arr : mat){
            int count = 0;
            for(int i = 0 ; i < arr.length ; i++){
                if(arr[i] == 0) break;
                count++;
            }
            pq.add(new Pair(row, count));
            row++;
        }
        
        int[] res = new int[k];
        
        for(int i = 0 ; i < k ; i++){
            res[i] = pq.remove().row;
        }
        
        return res;
    }
}

class Pair implements Comparator<Pair>{
    int row;
    int count;
    Pair(){}
    Pair(int row, int count){
        this.row = row;
        this.count = count;
    }
    
    public int compare(Pair p1, Pair p2){
        if(p1.count < p2.count) return -1;
        else if(p1.count > p2.count) return 1;
        else return p1.row - p2.row;
    }
}

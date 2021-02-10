public class Solution {
    public int solve(int n, ArrayList<ArrayList<Integer>> arr) {
        
        UnionFind ob = new UnionFind(n+1);
        
        for(ArrayList<Integer> curr : arr){
            if(ob.isConnected(curr.get(0), curr.get(1))) return 1;
            ob.union(curr.get(0), curr.get(1));
        }
        return 0;
    }
}

class UnionFind {
        int size;
        int components;
        int [] parent;
        int [] rank;
        UnionFind(int n) {
            if (n <= 0) throw new IllegalArgumentException("Size <= 0 is not allowed");
            size = n;
            components = n;
            parent = new int [n];
            rank = new int [n];
            for (int i=0; i<n; i++)
                parent[i] = i;
        }

        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rank[rootQ] > rank[rootP]) {
                parent[rootP] = rootQ;
            }
            else {
                parent[rootQ] = rootP;
                if (rank[rootQ] == rank[rootP])
                    rank[rootP] += 1;
            }
            components -= 1;
        }

        public int size() {
            return size;
        }

        public boolean isConnected(int p, int q) {
            return find(p) == find(q);
        }

        public int numberComponents() {
            return components;
        }
}


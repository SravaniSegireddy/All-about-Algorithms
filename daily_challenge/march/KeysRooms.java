class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        HashSet<Integer> hs = new HashSet<Integer>();
        // hs.add(0);
        
        dfs(rooms, 0, hs);
        
        return hs.size() == rooms.size();
    }
    
    void dfs(List<List<Integer>> arr, int room, HashSet<Integer> hs){
        hs.add(room);
        
        for(int v : arr.get(room)){
            if(!hs.contains(v)){
                dfs(arr, v, hs);
            }
        }
    }
}

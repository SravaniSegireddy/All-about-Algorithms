class Solution {
    public int distributeCandies(int[] arr) {
        
        int n = arr.length;
        
        HashSet<Integer> hs = new HashSet<Integer>();
        
        for(int ele : arr){
            hs.add(ele);
        }
        
        return Math.min(n/2, hs.size());
    }
}

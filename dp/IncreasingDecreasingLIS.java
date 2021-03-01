public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int longestSubsequenceLength(final List<Integer> arr) {
        int n = arr.size();
        if(n==0) return 0;
        List<Integer> left = new ArrayList<Integer>(Collections.nCopies(n,1));
        List<Integer> right = new ArrayList<Integer>(Collections.nCopies(n,1));
        
        
        left.set(0,1);
        for(int i = 1 ; i < n; i++){
            for(int j = i-1; j >= 0; j--){
                if(arr.get(j) < arr.get(i))
                left.set(i, Math.max(left.get(i), left.get(j)+1));
            }
        }
        
        right.set(n-1,1);
        for(int i = n-2 ; i >= 0; i--){
            for(int j = i+1; j < n; j++){
                if(arr.get(j) < arr.get(i))
                right.set(i, Math.max(right.get(i), right.get(j)+1));
            }
        }
        
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ; i++){
            // System.out.println(left.get(i)+" "+right.get(i));
            max = Math.max(left.get(i)+right.get(i)-1, max);
        }
        
        return max;
    }
}

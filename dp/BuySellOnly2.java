
    public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int maxProfit(final int[] arr) {
        int n = arr.length;
        if(n <= 1) return 0;
        int fb = Integer.MIN_VALUE, sb = Integer.MIN_VALUE;
        int fs = 0, ss=0;
        
            
        for(int i = 0; i < n ; i++){
            fb = Math.max(fb, -arr[i]);
            fs = Math.max(fs, fb+arr[i]);
            sb = Math.max(sb, fs-arr[i]);
            ss = Math.max(ss, sb+arr[i]);
        }
        return ss > fs ? ss : fs;
        
    }
}


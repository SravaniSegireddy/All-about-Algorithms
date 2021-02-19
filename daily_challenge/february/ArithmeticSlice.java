class Solution {
    public int numberOfArithmeticSlices(int[] arr) {
        
        int n = arr.length;
        if(n<3) return 0;
        
        int count = 0;
        
        int prev = arr[1]-arr[0];
        int start = 0,end=1;
        
        for(;end < n ; end++){
            
            
            if(prev == arr[end]-arr[end-1]) continue;

            int tmp = end-start-2;
            count+= tmp *(tmp+1)/2;
            start = end-1;
            prev = arr[end]-arr[end-1];
                
            
        }
        int tmp = end-start-2;
        count+= tmp *(tmp+1)/2;
        
        return count;
    }
}

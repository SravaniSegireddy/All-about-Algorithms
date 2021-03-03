class Solution {
    public int[] findErrorNums(int[] arr) {
        int n = arr.length;
        int[] res= new int[2];
        for(int i = 0 ; i < n ; i++){
            int val = Math.abs(arr[i]);
            if(arr[val-1] < 0) res[0] = val;
            else arr[val-1] *= -1;
        }
        
        for(int i = 0 ; i < n ; i++){
            if(arr[i] > 0) res[1] = i+1;
        }
        
        return res;
    }
}


/*

n = 4;
10 = 9 - dup + miss
dup  = mis-1

*/

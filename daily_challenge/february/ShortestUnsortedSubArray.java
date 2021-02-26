class Solution {
    public int findUnsortedSubarray(int[] arr) {
        int n = arr.length;
        
        int maxSoFar = arr[0];
        int end = -1;
        for(int i = 1 ; i < n ; i++){
            if(maxSoFar > arr[i]) end = i;
            maxSoFar = Math.max(maxSoFar, arr[i]);
        }
        if(end == -1) return 0;
        
        int minSoFar = arr[n-1];
        int start = -1;
        for(int i = n-2 ; i >= 0; i--){
            if(minSoFar < arr[i]) start = i;
            minSoFar = Math.min(minSoFar, arr[i]);
        }
        
        return end-start+1;
    }
}

/*
[2,6,4,8,10,9,15]

[2,6,9,10,4,5,15]

[1,2,3,4]
[2,1]
*/

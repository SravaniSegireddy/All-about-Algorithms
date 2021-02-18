class Solution {
    public int maxArea(int[] arr) {
        int i = 0 ;
        int j = arr.length-1;
        
        int max = Integer.MIN_VALUE;
        while(i < j){
            max = Math.max(max, Math.min(arr[i], arr[j])*(j-i));
            if(arr[i] < arr[j]) i++;
            else if(arr[i] > arr[j]) j--;
            else{
                i++;j--;
            }
        }
        
        return max;
    }
}

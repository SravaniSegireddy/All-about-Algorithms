class Solution {
    public int threeSumMulti(int[] arr, int target) {
        Arrays.sort(arr);
        int size = arr.length;
        int m = 1000000007;
        //count frequency 
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int i = 0 ; i < size ; i++){
            hm.put(arr[i], hm.getOrDefault(arr[i],0)+1);
        }
        
        long result = 0;
        for(int i = 0 ; i < size ; i++){
            
            if(i!=0 && arr[i] == arr[i-1]) continue;
            
            // two pointer
            int left = i+1,right = size-1;
            while(left < right){
                if(left!=i+1 && arr[left] == arr[left-1]){
                    left++;continue;
                } 
                if(right!=size-1 && arr[right] == arr[right+1]){
                    right--;continue;
                } 
                if(arr[left]+arr[right] == target-arr[i]){
                    // System.out.println(arr[left]+" "+arr[right]);
                    if(arr[i] == arr[left] && arr[left]== arr[right]){
                        long n = 1L*hm.get(arr[i]);
                        long val = n * (n - 1) * (n - 2) / 6;
                        result = (result + val)%m;
                        System.out.println(result+" "+size+" ");
                    }
                    else if(arr[i] == arr[left]){
                        int n = hm.get(arr[i]);
                        long val =  (long)(((((n-1)*n*0.5)%m) * hm.get(arr[right]))%m)%m;
                        result = (result + val)%m;
                    }
                    else if(arr[right] == arr[left]){
                        int n = hm.get(arr[left]);
                        long val = (long)(((((n-1)*n*0.5)%m) * hm.get(arr[i]))%m)%m;
                        result = (result + val)%m;
                    }
                    else{
                        result = (result+ ((hm.get(arr[i]) *hm.get(arr[left])%m)* hm.get(arr[right]) )%m)%m;
                    }
                    left++;right--;
                    
                }
                else if(arr[left]+arr[right] > target-arr[i]){
                    right--;
                }
                else left++;
            }
            
        }
        
        return (int)(result%m);
    }
}

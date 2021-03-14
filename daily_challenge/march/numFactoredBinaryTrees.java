class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        
        HashMap<Integer, Long> hm = new HashMap<Integer, Long>();
        
        
        
        long sum = 0;
        for(int i = 0; i < n ; i++){
            long tmp = 1;
            for(int j = 0; j <= i-1; j++){
                if(arr[i]%arr[j] == 0 && hm.containsKey(arr[i]/arr[j])){
                    tmp += hm.get(arr[j]) * hm.get(arr[i]/arr[j]);
                    // tmp %= 1000000007;
                }
            }
            // System.out.println(tmp+" "+i);
            hm.put(arr[i],tmp);
            sum += tmp;
            sum %= 1000000007;
        }
        return (int)sum%1000000007;
    }
}
//1 1 

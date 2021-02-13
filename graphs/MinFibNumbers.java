public class Solution {
    public int fibsum(int n) {
        
        HashSet<Integer> fib = new HashSet<Integer>();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        generateFib(fib, n, arr);
        
        // ArrayList<Integer> arr = new ArrayList<Integer>();
        if(fib.contains(n)) return 1;
        
        return recur(fib, n, arr);
        
    }
    
    
    int recur(HashSet<Integer> fib, int n, ArrayList<Integer> arr ){
        if(n < 0) return 0;
        if(fib.contains(n)) return 1;
        
        int min = n;
        for(int j = arr.size()-1 ; j >= 0; j--){
            if(n-arr.get(j) >0){
                int tmp = recur(fib, n-arr.get(j), arr);
                min = Math.min(1+tmp, min);
                if(tmp < n){
                    break;
                }
            }
            
        }
        return min;
    }
    void generateFib(HashSet<Integer> fib, int n, ArrayList<Integer> arr){
        int first = 1, second = 1;
        
        while(second <= n){
            fib.add(second);
            arr.add(second);
            int tmp = second;
            second += first;
            first = tmp;
        }
    }
}

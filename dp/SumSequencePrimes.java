public class Solution {
    public ArrayList<Integer> solve(int a, int b, int c, int d) {
        int[] dp = new int[3];
        int[] arr = new int[3];
        arr[0]=a;
        arr[1]= b;
        arr[2] = c;
        
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        while(res.size() < d){
            int minIndex = getMin(arr);
            if(res.size() == 0 || res.get(res.size()-1) != arr[minIndex]) res.add(arr[minIndex]);
            if(minIndex == 0){
                arr[minIndex] = res.get(dp[minIndex]) * a;
            }
            else if(minIndex == 1){
                arr[minIndex] = res.get(dp[minIndex]) * b;
            }
            else{
                arr[minIndex] = res.get(dp[minIndex]) * c;
            }
            dp[minIndex]++;

        }
        
        return res;
    }
    
    int getMin(int[] arr){
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        
        for(int i = 0 ; i < 3 ;i++){
            if(arr[i] < min){
                min = arr[i];
                minIndex = i;
            }
        }
        
        return minIndex;
    }
}



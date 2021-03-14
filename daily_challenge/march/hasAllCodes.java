class Solution {
    public boolean hasAllCodes(String s, int k) {
        int n = s.length();
        int sum = 0;
        HashSet<Integer> hs = new HashSet<Integer>();
        
        for(int i = n-1; i>=0 && i >= n-k; i--){
            sum += s.charAt(i) == '1' ? Math.pow(2, n-i-1):0;
        }
        hs.add(sum);
        
        int start = n-1;
        for(int end = n-k-1; end >= 0; end--){
            // System.out.println(start+" "+end);
            sum /= 2;
            if(s.charAt(end) == '1') sum += Math.pow(2, k-1);
            hs.add(sum);
        }
        // System.out.println(hs.size());
        return hs.size() == Math.pow(2,k) ? true:false;
        
    }
}

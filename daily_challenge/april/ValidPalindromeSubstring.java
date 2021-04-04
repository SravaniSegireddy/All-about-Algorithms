class Solution {
    public int longestValidParentheses(String s) {
        int max = 0;
        
        int n = s.length();
        
        for(int i = 0 ; i < n; i++) {
            if(s.charAt(i) == '(') {
                int count = 1;
                for(int j = i+1; j < n ; j++) {
                    if(s.charAt(j) == ')') count--;
                    else count++;
                    if(count < 0 ) break;
                    if(count == 0) max = Math.max(j-i+1, max);
                } 
            }
        }
        
        return max;
    }
}

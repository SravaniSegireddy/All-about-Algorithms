public class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int max = 0;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        for(int i = 0 ; i < n ; i++){
            // if(s.charAt(i) == '(') stack.push(i);
            // else{
                if(s.charAt(i) == ')' && stack.peek()!= -1 && s.charAt(stack.peek()) == '('){
                    stack.pop();
                    max = Math.max(max, i- stack.peek());
                    
                }
                else stack.push(i);
                
            // }
        }
        
        return max;
    }
    
}

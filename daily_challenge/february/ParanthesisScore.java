https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/587/week-4-february-22nd-february-28th/3651/

class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(-1);
            }
            else{
                int count = 0;
                while(stack.peek() != -1){
                    count += stack.pop();
                }
                stack.pop();
                stack.push( count == 0 ? 1 : count*2);
                
            }
        }
        int res = 0;
        while(!stack.isEmpty()){res += stack.pop();}
        return res;
    }
}

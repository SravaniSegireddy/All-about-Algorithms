class Solution {
    public boolean validateStackSequences(int[] push, int[] pop) {
        Stack<Integer> stack = new Stack<Integer>();
        
        int i = 0 , j = 0;
        int n = push.length;
        int m = pop.length;
        
        while(i < n && j < m){
            stack.push(push[i]);
            
            while(!stack.isEmpty() && j < m && stack.peek() == pop[j]){
                stack.pop();
                j++;
            }
            
            i++;       
        }
        
        return stack.isEmpty();
    }
}

/*
1 2 3 4 5
4 3 5 1 2

*/

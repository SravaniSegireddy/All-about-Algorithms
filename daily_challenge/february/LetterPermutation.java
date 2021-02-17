class Solution {
    ArrayList<String> res;
    public List<String> letterCasePermutation(String s) {
        res = new ArrayList<String>();
        recur(s, new StringBuilder(), 0);
        return res;
    }
    
    void recur(String s, StringBuilder sb, int index){
        if(index == s.length()) {
            res.add(sb.toString());
            return;
        }
        // for(int i = index; i < s.length(); i++){
        int i = index;
            if(Character.isDigit(s.charAt(i))) {
                // System.out.println(s.charAt(i)+"");
                sb.append(s.charAt(i));
                recur(s, new StringBuilder(sb.toString()), i+1);
            }
            else{
                
                recur(s, new StringBuilder(sb.toString()+s.charAt(i)), i+1);
                
                char other = Character.isUpperCase(s.charAt(i))?Character.toLowerCase(s.charAt(i)):Character.toUpperCase(s.charAt(i));
                
                recur(s, new StringBuilder(sb.toString()+other), i+1);
                
            }
            
        // }
        
        
    }
}

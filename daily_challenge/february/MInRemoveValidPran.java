class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        remove('(',')',s, sb);
        // System.out.println(sb.toString());
        reverse(')','(',sb.toString(), sb);
        return sb.toString();
    }
    
    void remove(char left, char right,String s, StringBuilder sb){
        int leftCount = 0;
        int rightCount = 0;
        int curr = 0;
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == left) leftCount++;
            else if(s.charAt(i) == right){
                if(leftCount > 0) leftCount--;
                else{
                    sb.deleteCharAt(curr);
                    curr--;
                }
            }
            curr++;
        }
    }
    
    void reverse(char left, char right,String s, StringBuilder sb){
        int leftCount = 0;
        int rightCount = 0;
        int curr = s.length()-1;
        for(int i =s.length()-1  ; i >= 0 ; i--){
            if(s.charAt(i) == left) leftCount++;
            else if(s.charAt(i) == right){
                if(leftCount > 0) leftCount--;
                else{
                    sb.deleteCharAt(curr);
                    // curr++;
                }
            }
            curr--;
        }
    }
}

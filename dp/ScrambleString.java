class Solution {
    
    public static String sortString(String inputString) { 
        char tempArray[] = inputString.toCharArray(); 
        Arrays.sort(tempArray); 
        return new String(tempArray); 
    }
    public int isScramble(String s1, String s2) {
        return isScrambleUtil(s1,s2) ? 1:0;
        
    }
    public boolean isScrambleUtil(String s1, String s2) {
        if(s1.equals(s2)) return true;
        if(s1.length() != s2.length()) return false;
        if (!sortString(s1).equals(sortString(s2))) return false;
        for(int i = 1 ; i < s1.length(); i++){
            boolean swap = isScrambleUtil(s1.substring(0,i), s2.substring(s2.length()-i)) && isScrambleUtil(s1.substring(i), s2.substring(0,s2.length()-i));
            
            boolean noSwap = isScrambleUtil(s1.substring(0,i), s2.substring(0,i)) && isScrambleUtil(s1.substring(i), s2.substring(i));
            
            if(swap || noSwap)
                 return true;
        }
        
        return false;
    }
}

class Solution {
    public int removePalindromeSub(String s) {
        if(s.equals("")) return 0;
        if(isPalindrome(s)) return 1;
        else return 2;
    }
    
    boolean isPalindrome(String s){
        int i = 0 , j = s.length()-1;
        while(i <= j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;j--;
        }
        return true;
    }
}


/*

  a b a b a
a 1 1 3 3 5
b - 1 1 3 3
a - - 1 1 3
b - - - 1 1
a - - - - 1





*/

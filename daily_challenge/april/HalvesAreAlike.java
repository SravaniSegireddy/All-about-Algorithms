class Solution {
    public boolean halvesAreAlike(String s) {
        int count = 0;
        HashSet<Character> vowels = new HashSet<Character>();
        populate(vowels);
        int n = s.length();
        for(int i = 0; i < s.length(); i++){
            if(vowels.contains(s.charAt(i))){
                if(i < n/2) count++;
                else count--;
            }
        }
        
        return count==0;
    }
    
    void populate(HashSet<Character> hs ){
        hs.add('a');hs.add('A');
        hs.add('e');hs.add('E');
        hs.add('i');hs.add('I');
        hs.add('o');hs.add('O');
        hs.add('u');hs.add('U');
    }
}

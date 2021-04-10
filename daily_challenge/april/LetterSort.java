  Verifying an Alien Dictionary

/*Solution
In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.

Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographicaly in this alien language.

 

Example 1:

Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
Example 2:

Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
Output: false
Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
Example 3:

Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
Output: false
Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicograp/*


*/

class Solution {
    
    public boolean isAlienSorted(String[] arr, String order) {
        
        int[] index = new int[26];
        for(int i = 0 ; i < 26; i++){
            index[order.charAt(i)-'a'] = i;
        }
        
    
        
        for(int p = 1 ; p < arr.length; p++){
            int i =0, j =0;
            int m = arr[p-1].length(), n = arr[p].length();
            while(i < m && j < n){
                if(index[arr[p-1].charAt(i)-'a'] == index[arr[p].charAt(j)-'a']){
                    i++;j++;
                }
                else if(index[arr[p-1].charAt(i)-'a'] < index[arr[p].charAt(j)-'a']) break;
                else return false;
            }
            
            if(i < m && j == n){
                return false;
            }
               
        }
                                          
        return true;
    }
}

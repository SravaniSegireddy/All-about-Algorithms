class Solution {
    public List<String> wordSubsets(String[] a, String[] b) {
        
        
        ArrayList<String> result = new ArrayList<String>();
        
        int[] maxSub = new int[26];
        int[] curr = new int[26];
        for(String sub : b){
            generateCounts(sub, curr);
            for(int i = 0 ; i < 26; i++){
                maxSub[i] = Math.max(maxSub[i], curr[i]);
            }
        }
        
        int[] count = new int[26];
        for(String s : a){
            generateCounts(s, count);
            boolean isSubset = true;
            
            for(int i = 0 ; i < 26; i++){
                if(count[i]-maxSub[i] < 0) {
                    isSubset = false;break;
                }
            }     
            if(isSubset) result.add(s);
        }
        return result;
    }
    
    void generateCounts(String s , int[] count){
        Arrays.fill(count, 0);
        for(char c : s.toCharArray()){
            count[c-'a']++;
        }
    }
}

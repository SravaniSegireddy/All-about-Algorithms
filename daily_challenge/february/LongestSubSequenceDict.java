class Solution {
    public String findLongestWord(String s, List<String> d) {
        
        int m = s.length();
        int min = -1;
        int minIndex = -1;
        for(int p = 0 ; p < d.size(); p++){
            String curr = d.get(p);
            int n = curr.length();
            int i = 0, j = 0;
            while(i < m && j < n){
                if(s.charAt(i) == curr.charAt(j)){
                    i++;
                    j++;
                }
                else i++;
            }
            if(j == n){
                if(n > min){
                    min = n;
                    minIndex = p;
                }
                else if(min == n){
                    if(d.get(minIndex).charAt(0) > curr.charAt(0))
                        minIndex = p;
                }
            }
        }
        
        return minIndex == -1 ? "":d.get(minIndex);
    }
}

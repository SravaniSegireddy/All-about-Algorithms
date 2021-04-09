class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Integer, String> hm = new HashMap<Integer, String>();
        populateHM(hm);
        List<String> res = new ArrayList<>();
        if(digits.equals("")) return res;
        dfs(digits,0, "", res, hm);
        return res;
    }
    
    void dfs(String dig, int index, String curr, List<String> res, HashMap<Integer, String> hm) {
        if(index == dig.length() || curr.length() == dig.length()){
            if(!curr.equals(""))res.add(curr);
            return;åç
        }
        
        for(char c : hm.get(dig.charAt(index)-'0').toCharArray()){
            dfs(dig, index+1, curr+c, res, hm);
        }
        
    }
    void populateHM(HashMap<Integer, String> hm) {
        hm.put(2, "abc");
        hm.put(3, "def");
        hm.put(4, "ghi");
        hm.put(5, "jkl");
        hm.put(6, "mno");
        hm.put(7, "pqrs");
        hm.put(8, "tuv");
        hm.put(9, "wxyz");
    }
}

class Solution {
    public int romanToInt(String s) {
        
        int n = s.length();
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        hm.put('I',1);hm.put('V',5);hm.put('X',10);hm.put('L',50);hm.put('C',100);hm.put('D',500);hm.put('M',1000);
        
        int sum = 0;
        for(int i = 0 ; i < n ; i++){
            char c = s.charAt(i);
            if(i == n-1){
                sum+=hm.get(c);
            }
            else{
                char nc = s.charAt(i+1);
                if(hm.get(c) >= hm.get(nc))
                    sum += hm.get(c);
                else{
                    int curr = hm.get(c);
                    int next = hm.get(nc);
                    sum += next-curr;
                    i++;
                }
            }
        }
        
        return sum;
    }
}

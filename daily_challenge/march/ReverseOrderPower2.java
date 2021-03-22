class Solution {
    public boolean reorderedPowerOf2(int n) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        
        int tmp = n;
        while(tmp > 0 ){
            hm.put(tmp%10, hm.getOrDefault(tmp%10,0)+1);
            tmp /= 10;
        }
        
        int digits = getDigits(n);
        int pos = getMsb(n);
        
        // System.out.println(pos);
        tmp = 1 << pos;
        while(getDigits(tmp) >= digits){
            // System.out.println(tmp);
            if(isEqual(tmp, new HashMap<>(hm))) return true;
            tmp >>= 1;
        }
        
        tmp = 1 << pos;
        while(getDigits(tmp) <= digits){
            if(isEqual(tmp, new HashMap<>(hm))) return true;
            // System.out.println(tmp);
            tmp <<= 1;
        }
        
        return false;
    }
    
    int getDigits(int n){
        return (int)Math.floor(Math.log10(n))+1;
    }
    
    int getMsb(int n){
        return (int)(Math.log(n) / Math.log(2));
    }
    
    boolean isEqual(int left, HashMap<Integer, Integer> hm){
        int tmp = left;
        while(tmp > 0){
            if(!hm.containsKey(tmp%10)) return false;
            hm.put(tmp%10, hm.get(tmp%10)-1);
            if(hm.get(tmp%10) == 0) hm.remove(tmp%10);
            tmp /= 10;
        }
        return hm.size() > 0 ? false: true;
    }
}

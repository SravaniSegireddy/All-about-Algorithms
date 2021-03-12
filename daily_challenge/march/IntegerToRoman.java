class Solution {
    HashMap<Integer, String> hm ;
    List<Integer> arr;
    
    public String intToRoman(int num) {
        hm = new HashMap<Integer, String>();
        generate();
        arr = new ArrayList<Integer>(hm.keySet());
        Collections.sort(arr, Collections.reverseOrder());
        
        return recur(num);
    }
    
    String recur(int val){
        
        StringBuilder sb = new StringBuilder();
        int i=0;
        while(val > 0){
            for(;i < arr.size(); i++){
                if((val / arr.get(i)) > 0){
                    // System.out.println(hm.get(arr.get(i)));
                    sb.append(hm.get(arr.get(i)));
                    val -= arr.get(i);
                    break;
                }
            }
        }
    
        return sb.toString();
    }
    public void generate(){
        hm.put(1, "I");
        hm.put(5, "V");
        hm.put(10, "X");
        hm.put(50, "L");
        hm.put(100, "C");
        hm.put(500, "D");
        hm.put(1000, "M");
        
        hm.put(4, "IV");
        hm.put(9, "IX");
        
        hm.put(40, "XL");
        hm.put(90, "XC");
        
        hm.put(400, "CD");
        hm.put(900, "CM");
    }
}

/*
48 = XXXXVIII


*/

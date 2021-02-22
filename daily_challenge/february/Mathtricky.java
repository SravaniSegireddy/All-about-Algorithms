class Solution {
    /*
    x > y => x-y
    o o = 3 15 => 3 * 2 * 2 * 2 = 3 *  8 = 3 * 2 ^ 3
    o e = 5 8. => 5 * 2
    5 ==> 5 * 2, 5-1
    10,4 , 4-1, 4*2 => 3 * 8
    
    e o
    e e
    */
    
    public int brokenCalc(int x, int y) {
       if(x >= y) return x-y;
        int count = 0;
       while(x < y){
           y = y%2==0 ? y/2 : y+1;
           count++;
       }
        return count+x-y;
    }
    
    
}

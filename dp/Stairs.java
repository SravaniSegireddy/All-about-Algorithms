public class Solution {
    public int climbStairs(int a) {
        if(a == 1 || a == 2) return a;
        int f1 = 1;
        int f2 =2;
        int f3 = -1;
        while(a-- > 2){
            f3 = f1+f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }
}

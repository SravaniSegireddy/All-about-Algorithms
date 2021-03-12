public class Solution {
    int m = 1000000007;
    
    public int solve(int n) {
        long ans2 = 12,ans3 = 24;
        long t2, t3;
        
        while(n-- > 1){
            t2 = ((5 * ans3)%m + (7 * ans2)%m)%m;
            t3 = ((11 * ans3)%m + (10 * ans2)%m)%m;
            ans2 = t2;
            ans3 = t3;
        }
        return (int)((ans2+ans3)%m);
    }
    
    
}
/*
a = 1

3 1_ _ _



*/

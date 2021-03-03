class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0)
            return 0;
            
        int M = 1000000007;

        long[] dp = new long[s.length() + 1];
        
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : s.charAt(0) == '*' ? 9 : 1;
        
        for(int i = 2; i < dp.length; i += 1) {

            if(s.charAt(i-1) == '*'){
                dp[i] = dp[i-1] * 9;
                if(s.charAt(i-2) == '1'){
                    dp[i] = (dp[i] + (dp[i-2] * 9))%M;
                }
                else if(s.charAt(i-2) == '2'){
                    dp[i] = (dp[i] + (dp[i-2] * 6))%M;
                }
                else if(s.charAt(i-2) == '*'){
                    dp[i] = (dp[i] + (dp[i-2] * 15))%M;
                }
            }
            else{
                if(s.charAt(i-1) != '0')
                    dp[i] = dp[i-1];  
                
                if(s.charAt(i-2) == '*'){
                    if(s.charAt(i-1) <= '6')
                        dp[i] = (dp[i] + (dp[i-2] * 2))%M;
                    else dp[i] = (dp[i] + (dp[i-2] * 1))%M;
                }
                else{
                    int twoDigit = Integer.valueOf(s.substring(i-2, i));
                    if(twoDigit >= 10 && twoDigit <= 26) 
                        dp[i] = (dp[i] + dp[i-2])%M;
                }
                
            }
            System.out.print(dp[i]+" ");
            
        }
        
        return (int)dp[s.length()];
    }
}

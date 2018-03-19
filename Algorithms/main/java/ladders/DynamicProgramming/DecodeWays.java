package main.java.ladders.DynamicProgramming;
/**
 * 512. Decode Ways - Medium

A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

Have you met this question in a real interview? 
Example
Given encoded message 12, it could be decoded as AB (1 2) or L (12).
The number of ways decoding 12 is 2.

Tags 
String Dynamic Programming
 * */
public class DecodeWays {
	/**
     * @param s a string,  encoded message
     * @return an integer, the number of ways decoding
     */
    public int numDecodings(String s) {
        if(s.length()==0||s==null){
            return 0;
        }
        int []dp = new int[s.length()+1];
        dp[0] = 1; // for dp[i-1], e.g. 12= dp1 +dp2 + dp0 where dp12 = dp 0 (index 2-2)
        if(s.charAt(0)=='0'){
            dp[1]=0;
        }else{
            dp[1]=1;
        }

        for(int i =2; i < s.length()+1;i++){
            if(s.charAt(i-1)!='0'){
                dp[i]=dp[i-1];
            }
            
            int two= Integer.valueOf(s.substring(i-2, i));
            if(two>=10&&two<=26){
                dp[i]+=dp[i-2];
            }

        }
        return dp[s.length()];
    }

}

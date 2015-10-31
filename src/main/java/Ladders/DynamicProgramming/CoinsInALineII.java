package DynamicProgramming;
/*
 * There are n coins with different value in a line. 
 * Two players take turns to take one or two coins from left side until 
 * there are no more coins left. The player who take the coins with 
 * the most value wins.
 * Could you please decide the first player will win or lose?
 * Given values array A = [1,2,2], return true.
 * Given A = [1,2,4], return false.
 * */
public class CoinsInALineII {
	/**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
    	if (values == null || values.length <= 2)
            return true;
        int second = values[values.length - 1];
        int first = values[values.length - 2] + second;
        int sum = first; 
        
        for (int i = values.length - 3; i >= 0; i--){
            sum += values[i];
            int cur = sum - Math.min(second, first);
            second = first;
            first = cur;
        }
        return first > (sum - first);
    }
    
    // another solution 
    public boolean firstWillWin1(int[] values) {
        // write your code here
        int []dp = new int[values.length + 1];
        boolean []flag =new boolean[values.length + 1];
        int sum = 0;
        for(int now : values) 
            sum += now;
        
        return sum < 2*MemorySearch(values.length, dp, flag, values);
    }
    int MemorySearch(int n, int []dp, boolean []flag, int []values) { 
        if(flag[n] == true)
            return dp[n];
        flag[n] = true;
        if(n == 0)  {
            dp[n] = 0;  
        } else if(n == 1) {
            dp[n] = values[values.length-1];
        } else if(n == 2) {
            dp[n] = values[values.length-1] + values[values.length-2]; 
        } else if(n == 3){
            dp[n] = values[values.length-2] + values[values.length-3]; 
        } else {
            dp[n] = Math.max(
                Math.min(MemorySearch(n-2, dp, flag,values) , MemorySearch(n-3, dp, flag, values)) + values[values.length-n],
                Math.min(MemorySearch(n-3, dp, flag, values), MemorySearch(n-4, dp, flag, values)) + values[values.length-n] + values[values.length - n + 1]
                );
        }
    
        return dp[n];
    }
}

package main.java.ladders.DynamicProgramming;
/**
 * 584. Drop Eggs II - Medium - Related

There is a building of n floors. 
If an egg drops from the k th floor or above, it will break. 
If it's dropped from any floor below, it will not break.

You're given m eggs, Find k while minimize the number of drops for the worst case. 
Return the number of drops in the worst case.

Example
Given m = 2, n = 100 return 14
Given m = 2, n = 36 return 8

Tags 
Dynamic Programming
Related Problems 
Easy Drop Eggs 34 %
 * */
public class DropEggs2 {
	/**
     * @param e the number of eggs
     * @param n the umber of floors
     * @return the number of drops in the worst case
     */
    public int dropEggs2(int e, int n) {
        
        if(n==1||n==0){
            return n;
        }
        if(e==1){
            return n;
        }
        // We need one trial for one floor and 0 trials for 0 floors
        int dp[][]= new int[e+1][n+1];
        for(int i=1; i<= e; i++){
            dp[i][0]=0;
            dp[i][1]=1;
        }
        // We always need j trials for one egg and j floors.
        for(int i=1; i<= n; i++){
            dp[1][i]=i;
        }
        for(int i= 2; i<=e; i++){
            for (int j=2; j<=n;j++){
                dp[i][j] = Integer.MAX_VALUE;
                for(int k=1;k<=j;k++ ){
                    dp[i][j] = Math.min(dp[i][j], 1+Math.max(dp[i][j-k],dp[i-1][k-1]));
                }
            }
        }

        return dp[e][n];
    }

}

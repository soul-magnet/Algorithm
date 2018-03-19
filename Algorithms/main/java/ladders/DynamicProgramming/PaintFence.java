/**
 * 514. Paint Fence - Easy

There is a fence with n posts, each post can be painted with one of the k colors.
You have to paint all the posts such that no more than two adjacent fence posts have the same color.
Return the total number of ways you can paint the fence.

 Notice
n and k are non-negative integers.

Example
Given n=3, k=2 return 6

      post 1,   post 2, post 3
way1    0         0       1 
way2    0         1       0
way3    0         1       1
way4    1         0       0
way5    1         0       1
way6    1         1       0
Tags 
Dynamic Programming
Related Problems 
Medium House Robber II 28 %
Hard Paint House II 26 %
Medium Paint House 35 %
Medium House Robber 34 %
 * */
public class PaintFence {
	/**
     * @param n non-negative integer, n posts
     * @param k non-negative integer, k colors
     * @return an integer, the total number of ways
     */
    public int numWays1(int n, int k) {
          if (n<=0){
            return 0;
        }else if (n==1){
            return k;
        }
        int dp[][]= new int[n][2];// first line  has 7 opeions
         dp[1][0]=k*1;//same
        dp[1][1]=k*(k-1);//diff

        for(int i=2; i<n; i++){
            dp[i][0]= dp[i-1][1]*1;//same= diff(i-1) *1
            dp[i][1] =  dp[i-1][0]*(k-1)+ dp[i-1][1]*(k-1);// diff= same*(k-1) + diff(i-1)*(k-1)
        }
        return dp[n-1][0]+dp[n-1][1];
    }
     public int numWays(int n, int k) {
         if (n<=0){
            return 0;
        }else if (n==1){
            return k;
        }
        int same =k*1;//same
        int diff=k*(k-1);//diff
        for(int i=2; i<n; i++){
            int oldDiff = diff; int oldSame= same;
            same= oldDiff*1;//same= diff(i-1) *1
            diff =  oldSame*(k-1)+ oldDiff*(k-1);// diff= same*(k-1) + diff(i-1)*(k-1)
        }
        return same+ diff;
    }

}

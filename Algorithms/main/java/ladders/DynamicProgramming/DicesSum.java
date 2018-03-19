package main.java.ladders.DynamicProgramming;
/**
 * 20. Dices Sum - Hard

Throw n dices, the sum of the dices' faces is S. Given n, 
find the all possible value of S along with its probability.

 Notice
You do not care about the accuracy of the result, we will help you to output results.

Example
Given n = 1, return [ [1, 0.17], [2, 0.17], [3, 0.17], [4, 0.17], [5, 0.17], [6, 0.17]].

Tags 
Mathematics Dynamic Programming Probability
 * */
public class DicesSum {
	/**
     * @param n an integer
     * @return a list of Map.Entry<sum, probability>
     */
    public List<Map.Entry<Integer, Double>> dicesSum(int n) {
        // Write your code here
        // Ps. new AbstractMap.SimpleEntry<Integer, Double>(sum, pro)
        // to create the pair
         List<Map.Entry<Integer, Double>> res = new ArrayList<>();
        double dp [][]= new double[n+1][6*n+1];
        for(int i=1; i<=6; i++){
            dp[1][i]= 1.0/6;
        }
        for(int i=2; i<=n; i++){
            for(int j=i; j<=i*6; j++){
                for(int k=1; k<=6; k++){
                    if(j-k>0)
                    dp[i][j] += dp[i-1][j-k];
                   
                } dp[i][j] /= 6.0;
            }
        }
        for(int i = n; i <= 6*n; i++){
            res.add(new AbstractMap.SimpleEntry<Integer, Double>(i, dp[n][i]));
        }
        return res;
    }
}

package main.java.ladders.DynamicProgramming;
/**
 * 752. Rogue Knight Sven - Medium 

In material plane "reality", there are n + 1 planets, namely planet 0, planet 1, ..., planet n.
Each planet has a portal through which we can reach the target planet directly without passing through other planets.
But portal has two shortcomings.
First, planet i can only reach the planet whose number is greater than i, 
and the difference between i can not exceed the limit.
Second, it takes cost[j] gold coins to reach the planet j through the portal.
Now, Rogue Knight Sven arrives at the planet 0 with m gold coins, 
how many ways does he reach the planet n through the portal?

 Notice
1 <= n <= 50, 0 <= m <= 100, 1 <= limit <= 50,0 <= cost[i] <= 100。
The problem guarantees cost [0] = 0, cause cost[0] does not make sense

Example
Give n = 1, m = 1, limit = 1, cost = [0, 1],return 1.

Explanation:
Plan 1: planet 0 → planet 1
Give n = 1, m = 1, limit = 1, cost = [0, 2],return 0.

Explanation:
He can not reach the target planet.
Give n = 2, m = 3, limit = 2, cost = [0, 1, 1],return 2.

Explanation:
Plan 1: planet 0 → planet 1 → planet 2
Plan 2: planet 0 → planet 2
Give n = 2, m = 3, limit = 2, cost = [0, 3, 1],return 1.

Explanation:
Plan 1: planet 0 → planet 2
Tags 
Dynamic Programming
Related Problems 
Medium Maximum Product Subarray 30 %
Medium Jump Game 37 %
Medium Minimum Adjustment Cost 31 %
 * */
public class RougeKnightSven {
	/**
     * @param n: the max identifier of planet.
     * @param m: gold coins that Sven has.
     * @param limit: the max difference.
     * @param cost: the number of gold coins that reaching the planet j through the portal costs.
     * @return: return the number of ways he can reach the planet n through the portal.
     */
    public long getNumberOfWays(int n, int m, int limit, int[] cost) {
        // Write your code here
    }

}

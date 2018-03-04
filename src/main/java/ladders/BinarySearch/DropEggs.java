package main.java.ladders.BinarySearch;
/**
 * 254. Drop Eggs - Easy - Optional

There is a building of n floors. If an egg drops from the k th floor or above, it will break. 
If it's dropped from any floor below, it will not break.

You're given two eggs, Find k while minimize the number of drops for the worst case. 
Return the number of drops in the worst case.

Clarification
For n = 10, a naive way to find k is drop egg from 1st floor, 2nd floor ... kth floor. 
But in this worst case (k = 10), you have to drop 10 times.

Notice that you have two eggs, so you can drop at 4th, 7th & 9th floor, in the worst case 
(for example, k = 9) you have to drop 4 times.

Example
Given n = 10, return 4.
Given n = 100, return 14.

Related Problems 
Medium Drop Eggs II 40 %
 * 
 * */
public class DropEggs {
	/**
     * @param n an integer
     * @return an integer
     */
     
     /*Solution 1:  2864 ms*/
   /* public int dropEggs(int n) {
        if(n==1||n==0){
            return 1;
        }
        long ans = 0;
        for (int i = 1; ; ++i) {
            ans += (long)i;
            if (ans >= (long)n)
                return i;
        }
    }*/
    
    
   /* Solution 2:*/
   public int dropEggs(int n){
       
   }

}

package IntegerArray;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/*
 * Given an integer array, find a subarray with sum closest to zero. 
 * Return the indexes of the first number and last number. 
 * Example: Given [-3, 1, 1, -3, 5], return [0, 2], [1, 3], [1, 1], [2, 2] or [0, 4]
 * Challenge: O(nlogn) time
 * 
 * Analysis: Use a TreeMap to save<sum from index 0 to i, i>
 * Iterate the array (O(n)): for each index j with sum = S,
 *  Find the ceiling sum S1 and bottom sum S2 from previous sums saved in TreeMap O(logn)
 *  Update minDif = min(|S1 - S|,|S2 - S|)
 *  Total time O(nlogn)
 *  reference : http://www.lifeincode.net/programming/leetcode-two-sum-3-sum-3-sum-closest-and-4-sum-java/
 * */
public class SubarraySumClosest {
	/**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
	
	public ArrayList<Integer> subarraySumClosest(int[] nums) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (nums == null || nums.length == 0){
			return result;
		}
		
		TreeMap<Long, Integer> map = new TreeMap<Long, Integer>();
		long sum = 0;
		long minDiff = (long)Integer.MAX_VALUE + 1;
		
		result.add(0);
		result.add(0);
		
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			// ..[floorEntry][sum][ceilingEntry]...
			Map.Entry floorEntry = map.floorEntry(sum);
			Map.Entry ceilingEntry = map.ceilingEntry(sum);
			int curDiff = 0;
			if (floorEntry != null || ceilingEntry != null ){
				// ceiling
				if (floorEntry != null || ceilingEntry != null && Math.abs((long)floorEntry.getKey() - sum) > Math.abs((long)ceilingEntry.getKey() - sum)) {
					if (Math.abs((long)ceilingEntry.getKey() - sum) < minDiff){
						result.set(0, (int)ceilingEntry.getValue() + 1);
						result.set(1, i);
					}
					
					
				} else { 
					// floor
					if (Math.abs((long)floorEntry.getKey() - sum) < minDiff) {
                        result.set(0, (int)floorEntry.getValue() + 1);
                        result.set(1, i);
                        minDiff = Math.abs((long)floorEntry.getKey() - sum);
					
				}
			}
		}
			
			map.put(sum, i);
	}
		
		return result;
	}
}

// 2nd Approach

/*public class Solution {
	private class Pair {
	    int sum;
	    int index;
	    public Pair (int s, int i){
	        sum = s;
	        index = i;
	    }
	}

	public ArrayList<Integer> subarraySumClosets(int[] nums) {
	    ArrayList<Integer> res = new ArrayList<Integer>();
	    if (nums == null || nums.length == 0 )
	        return 0;
	    
	    int len = nums.length;
	    if (len == 1){
	        res.add(0);
	        res.add(0);
	        return res;
	    }
	    
	    Pair[] sums = new Pair[len +1];
	    int prev  = 0;
	    sums[0] = new Pair(0, 0);
	    for (int i = 1; i <= len; i++) {
	        sums[i] = new Pair(prev + nums[i -1], i);
	        prev = sums[i];
	    }
	    Arrays.sort(sums, new Comparator<Pair>() {
	       public int compare(Pair a, Pair b) {
	           return a.sum - b.sum;
	       } 
	    });
	    
	    int ans = Integer.MAX_VALUE;
	    for (int i = 1; i <= len; i++) {
	        if (ans > sums[i].sum - sums[i-1].sum) {
	            ans = sums[i]. sum - sums[i-1].sum;
	            res.clear();
	            int[] temp = new int[]{
	                sums[i].index - 1, sums[i-1].index -1
	            };
	            Arrays.sort(temp);
	            res.add(temp[0] + 1);
	            res.add(temp[1]);
	        }
	    }
	    
	    return res;
	    
	}
	}


*/
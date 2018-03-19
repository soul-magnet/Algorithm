package DataStructure;

import java.util.HashMap;

/*
 * Given an unsorted array of integers, 
 * find the length of the longest consecutive elements sequence.
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. 
 * Return its length: 4.
 * Clarification: Your algorithm should run in O(n) complexity.
 * 
 * Analysis: At first glance, "the longest" requirement may lead us to DP.
 * But this problem actually tests data structure rather than a certain algorithm.
 * 
 * Without time limit, first of all, we can just sort the array O(nLogn), 
 * then find longest sequence after a scan.
 * 
 * With the time limit O(n), first of all what comes to my mind is HashMap.
 * Because hasmMap searches value by key in O(1)time. 
 * 
 * Firstly, we put the element into a map.
 * Secondly, how to find the consecutive elements? Since the O(n) requirement, 
 * scan the array is must.
 * For each element, we need to find its consecutive elements.
 * Consecutive means +1 or -1, a while loop is enough to handle.
 * Search two directions respectively(+1, -1), during the search if the key is found,
 * remove the current item from the map. 
 * This is because if two items are consecutive, the longest elements for this two are the same, 
 * no need to search again. In this way, the length of longest consecutive elements can be easily found.
 * */
public class LongestConsecutiveSequence {
	/**
     * @param nums: A list of integers
     * @return an integer
     */
     
     // Sort & Search space O(1), time O(nlogn)
     // HashMap: space O(n), time O(n)
    public int longestConsecutive(int[] num) {
    	if (num == null || num.length == 0){
    		return 0;
    	}
    	
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	int max = 0;
    	
    	int len = num.length;
    	
    	for (int i = 0; i < len; i++){
    		// Looking to num[i] from beginning to end,
    		// if we find it, we can skip it 
    		// because we don't need to duplicate numbers
    		if (map.get(num[i]) != null){
    			continue;
    		}
    		
    		int left = num[i];
    		int right = num[i];
    		
    		// find the left margin
    		Integer board = map.get(num[i]-1);
    		if (board != null && board < left){
    			// Update the left margin 
    			left = board;
    			// Delete 2 set left
    			map.remove(left);
    			map.remove(num[i]-1);
    		}
    		
    		// find the right border
    		board = map.get(num[i] + 1);
    		if (board != null && board > right){
    			// update the right boundary
    			right = board;
    			// delete 2 set on the right
    			map.remove(right);
    			map.remove(num[i] + 1);
    		}
    		
    		// Create a new connection to merge
    		map.put(left, right);
    		map.put(right, left);
    		
    		max = Math.max(max, right - left + 1);
    	}
    	
    	return max;
    }
    
    // Another solution using HashMap from jiuzhang
    public int longestConsecutive1(int[] num){
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	int maxL = 1;
    	for (int i : num){
    		map.put(i, 0);
    		if (map.get(i) == 1) continue;
    		int tmp = i;
    		int currentMax = 1;
    		while (map.containsKey(tmp + 1)){
    			currentMax++;
    			tmp++;
    			map.put(tmp, 1);
    		}
    		tmp = i;
    		while (map.containsKey(tmp - 1)){
    			currentMax++;
    			tmp--;
    			map.put(tmp, 1);
    		}
    		maxL = Math.max(currentMax, maxL);
    	}
    	
    	return maxL;
    }

}

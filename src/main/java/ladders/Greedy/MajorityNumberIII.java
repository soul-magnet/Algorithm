package Greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * Given an array of integers and a number k, 
 * the majority number is the number that occurs more than 
 * 1/k of the size of the array.
 * Example: Given [3,1,2,3,2,3,3,4,4,4] and k=3, return 3.
 * Note: There is only one majority number in the array.
 * Challenge: O(n) time and O(k) extra space
 * 
 * Analysis: 
 * Keep k -1 pointers and counters. 
 * Use HashMap to store numbers and counters, 
 * every delete operation will cost k-1, however, 
 * the max times of deletion is n/(k-1) because deletion only hapens 
 * when there are (k-1) numbers in the map. 
 * So the overall complexity is still O(n). 
 * 
 * 
 * Same as Majority NumberII, As there could be at most (k – 1) elements 
 * Occurring more than 1 / k of the array, we have (k – 1) slots 
 * for majority number candidates. The voting rule is the same as Majority Number II
 * Careful for the ConcurrentModificationException in HashMap, 
 * we should remove (write) the keys during the HashMap being iterated (read). 
 * Write the hashmap after read.
 * */
public class MajorityNumberIII {
	 /**
     * @param nums: A list of integers
     * @param k: As described
     * @return: The majority number
     */
	public int majorityNumber(ArrayList<Integer> nums, int k) {
		if (nums == null || nums.size() == 0)
			return 0;
		int len = nums.size();
		
		HashMap<Integer, Integer> counters = new HashMap<Integer, Integer>();
		for (Integer i : nums){
			if (!counters.containsKey(i)){
				counters.put(i, 1);
			}else {
				counters.put(i, counters.get(i) + 1);
			}
			if (counters.size() >= k){
				removeKey(counters);
			}
		}
		// corner case
		if (counters.size() == 0)
			return Integer.MIN_VALUE;
		// recalculate counters
		for (Integer i : counters.keySet()){
			counters.put(i, 0);
		}
		
		for (Integer i : nums) {
			if (counters.containsKey(i)){
				counters.put(i, counters.get(i) + 1);
			}
		}
		
		// find the max key
		int maxCounter = 0, maxKey = 0;
		for (Integer i : counters.keySet()){
			if (counters.get(i) > maxCounter){
				maxCounter = counters.get(i);
			}
		}
		return maxKey;
	}
	
	private void removeKey(HashMap<Integer, Integer> counters){
		Set<Integer> keySet = counters.keySet();
		List<Integer> removeList = new ArrayList<>();
		for (Integer key : keySet){
			counters.put(key, counters.get(key) - 1);
			if (counters.get(key) == 0)
				removeList.add(key);
		}
		for (Integer key : removeList){
			counters.remove(key);
		}
	}
	// Natural Thinking
	
	public int majorityNumber2(ArrayList<Integer> nums, int k){
		if (nums == null || nums.size() == 0){
	        return 0;
	    }
	    
	    int len = nums.size();
	    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	    map.put(nums.get(0), 1);
	    
	    for (int i = 0; i < len; i++) {
	        if (map.containsKey(nums.get(i))) {
	            int val = map.get(nums.get(i));
	            if (val == 0) map.remove(nums.get(i));
	            else map.put(nums.get(i), val);
	        } else {
	            // if the number of existing number is less than k-1, then just add one.
	            if (map.size() < k-1) {
	                map.put(nums.get(i), 1);
	            } else {
	                List<Integer> keyList = new ArrayList<Integer>();
	                // decrease the vale of every key by 1.
	                for (Map.Entry en : map.entrySet()) {
	                    int key = (int) en.getKey();
	                    int value = (int) en.getValue();
	                    value--;
	                    if (value == 0) keyList.add(key);
	                    map.put(key, value);
	                }
	                
	                for (int key : keyList) map.remove(key);
	            }
	        }
	        
	        for (Map.Entry en : map.entrySet()) en.setValue(0);
	        int num = 0, count = 0;
	        for (int i = 0; i < len; i++){
	            if(map.containsKey(nums.get(i))) {
	                int val = map.get(nums.get(i)) + 1;
	                if (val > count) {
	                    num = nums.get(i);
	                    count = val;
	                }
	                map.put(nums.get(i), val);
	            }
	            
	        }
	        
	        return num;
	            
	    }
	    
	}
	
	
	
}

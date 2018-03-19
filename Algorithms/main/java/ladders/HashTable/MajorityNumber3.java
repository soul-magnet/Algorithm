package main.java.ladders.HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * 48. Majority Number III - Medium

Given an array of integers and a number k, 
the majority number is the number that occurs more than 1/k of the size of the array.

Find it.

 Notice
There is only one majority number in the array.

 
Example
Given [3,1,2,3,2,3,3,4,4,4] and k=3, return 3.

Challenge 
O(n) time and O(k) extra space

Tags : Hash Table LintCode Copyright Linked List
Related Problems 
Medium Single Number III 36 %
Medium Single Number II 40 %
Easy Single Number 46 %
Medium Majority Number III 30 %
Medium Majority Number II 31 %
Easy Majority Number 43 %
*/
public class MajorityNumber3 {
	/**
     * @param nums: A list of integers
     * @param k: As described
     * @return: The majority number
     */
        public int majorityNumber(ArrayList<Integer> nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (Integer i : nums) {
            if (map.size()==k-1&&!map.containsKey(i)){
                removeKey(map);
                if (map.size()<k-1){
                    map.put(i, 1);
                }
            }
            else  {
                if (!map.containsKey(i)) {
                    map.put(i, 1);
                } else {
                    map.put(i, map.get(i) + 1);
                }
            }
        }
        if (map.size() == 0) {
            return Integer.MIN_VALUE;
        }

        int maxKey = 0;
        int max = 0;
        Set<Integer> keySet = map.keySet();
        for (Integer i : keySet) {
            int count = 0;
            for (Integer j : nums) {
                if (i.equals(j)) {
                    count++;
                }
            }
            if (count > max) {
                max = count;
                maxKey = i;
            }
        }
        
        return maxKey;
    }
    
    private void removeKey(Map<Integer, Integer> map) {
          Set<Integer> set = new HashSet<>() ;
        
        for (Map.Entry<Integer,Integer> entry: map.entrySet()) {
            if (entry.getValue()==1) {
                set.add(entry.getKey());
            }
            else {
                entry.setValue(entry.getValue()+1);
            }
        }
        for (Integer i : set){
            map.remove(i);
        }

    }

}

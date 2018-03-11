package main.java.ladders.HashTable;

import java.util.HashMap;

/**
 * 607. Two Sum - Data structure design - Easy

Design and implement a TwoSum class. It should support the following operations: add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.

Have you met this question in a real interview? 
Example
add(1); add(3); add(5);
find(4) // return true
find(7) // return false
Tags 

Hash Table LinkedIn Data Structure Design

Related Problems 
Medium Two Sum - Input array is sorted 47 %
Medium Word Abbreviation Set 28 %
Medium Two Sum - Difference equals to target 26 %
Medium Two Sum - Less than or equal to target 39 %
Medium Two Sum - Unique pairs 34 %
Medium Two Sum - Closest to target 43 %
Medium Two Sum - Greater than target 38 %
Easy Two Sum 28 %
 * */
public class TwoSumDataStructureDesign {

}

public class TwoSum {
    HashMap<Integer, Integer> hm = new HashMap<>();
    
    // Add the number to an internal data structure.
    public void add(int number) {
        if(hm.containsKey(number)){
            hm.put(number,hm.get(number)+1);
        }else{
            hm.put(number,1);
        }
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        for(Integer i : hm.keySet()){
            if(hm.containsKey(value-i)){
                if(value-i==i&&hm.get(i)<2){
                    continue;
                }
                return true;
            }
        }
        return false;
    }
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);

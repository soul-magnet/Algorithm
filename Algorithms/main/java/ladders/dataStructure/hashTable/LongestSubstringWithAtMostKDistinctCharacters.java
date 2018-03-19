package dataStructure.hashTable;

import java.util.HashMap;
import java.util.Map;

/*
 * Given a string s, find the length of the longest substring T 
 * that contains at most k distinct characters. 
 * For example, Given s = "eceba", k = 3,
 * T is "eceb" which its length is 4.
 * Challenge: O(n), n is the size of the string s.
 * Tags: String, Two Pointers, HashTable
 * 
 * Analysis: 
 * Solution is to maintain a sliding window, and a hashmap, key is char,
 * and the value is the car obtained in the current window in the number of occurences.
 * Start and end are the start and end of the current index of the string.
 * When the current window,when k exceeds the number of characters from the start
 * began to remove, 
 * */
public class LongestSubstringWithAtMostKDistinctCharacters {
	/**
    * @param s : A string
    * @return : The length of the longest substring 
    *           that contains at most k distinct characters.
    */
   public int lengthOfLongestSubstringKDistinct(String s, int k) {
       if (s == null || s.length() == 0 || k <= 0)
    	   return 0;
       int start = 0;
       int res = 1;
       Map<Character, Integer>map = new HashMap<Character, Integer>();
       map.put(s.charAt(0), 1);
       for (int end = 1; end < s.length(); end++){
    	   char ch = s.charAt(end);
    	   if (map.containsKey(ch)){
    		   map.put(ch, map.get(ch)+1);
    	   } else {
    		   if (map.size() == k){
    			   res = Math.max(res, end - start);
    			   // full map, need to remove the first character in the substring
    			   for (int index = start; index < end; index++){
    				   map.put(s.charAt(index), map.get(s.charAt(index)) -1);
    				   start++;
    				   if (map.get(s.charAt(index)) == 0){
    					   // have removed all occurance of a char
    					   map.remove(s.charAt(index));
    					   break;
    				   }
    			   }
    		   }
    		   map.put(ch, 1);
    	   }
       }
       
       res = Math.max(res, s.length() - start);
       return res;
   }
   
   // Another solution from jiuzhang
   public int lengthOfLongestSubstringKDistinct1(String s, int k) {
       int slow = 0;
       int maxLen = 0;
       
       // Key: letter; value: the number of occurences
       Map<Character, Integer>map = new HashMap<Character, Integer>();
       int fast;
       for (fast = 0; fast < s.length(); fast++){
           char c = s.charAt(fast);
           if (map.containsKey(c)) {
               map.put(c, map.get(c) + 1);
           } else {
               map.put(c, 1);
               while (map.size() > k){
                   char slowChar = s.charAt(slow++);
                   int count = map.get(slowChar);
                   if (count > 1){
                       map.put(slowChar, count - 1);
                   } else {
                       map.remove(slowChar);
                   }
               }
           }
           maxLen = Math.max(maxLen, fast - slow + 1);
       }
       return maxLen;
   }
}

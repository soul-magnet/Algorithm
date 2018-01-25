package ladderIFollowupCodingInt;

import java.util.HashMap;
import java.util.Map;

/** Required
 * 386. Longest Substring with At Most K Distinct Characters
 * 
 * Given a string s, find the length of the longest substring T that contains at most k distinct characters.


Example
For example, Given s = "eceba", k = 3,

T is "eceb" which its length is 4.

Challenge: O(n), n is the size of the string s.

Tags: Two Pointers LintCode Copyright Hash Table String

Related Problems 
1- Medium Longest Substring Without Repeating Characters
 * 
 * */

public class LongestSubstringwithAtMostKDistinctCharacters {
    

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
		int dic[] = new int[256], l=0, r=0, ct=0, res=0;
		char s1[] = s.toCharArray();
		while(r<s.length()){
			if(dic[s1[r++]]++==0){
				ct++;
			}
			if(ct<=k){
				res= Math.max(res, r-l);
			}
			while(ct>k){
				if(--dic[s1[l++]]<1)ct--;
			}
		}
		return res;

	}
    /**
     * @param s : A string
     * @return : The length of the longest substring 
     *           that contains at most k distinct characters.
     */
    public int lengthOfLongestSubstringKDistinct1(String s, int k) {
		     // write your code here
      int maxLen = 0;

      // Key: letter; value: the number of occurrences.
      Map<Character, Integer> map = new HashMap<Character, Integer>();
      int i, j = 0;
      char c;
      for (i = 0; i < s.length(); i++) {
        while (j < s.length()) {
          c = s.charAt(j);
          if (map.containsKey(c)) {
            map.put(c, map.get(c) + 1);
          } else {
            if(map.size() ==k) 
              break;
            map.put(c, 1);
          }
          j++;
        }
      
        maxLen = Math.max(maxLen, j - i);
        c = s.charAt(i);
        if(map.containsKey(c)){
          int count = map.get(c);
          if (count > 1) {
            map.put(c, count - 1);
          } else {
            map.remove(c);
          }
        }
      }
      return maxLen; 
  }  
	public int lengthOfLongestSubstringKDistinct2(String s, int k) {
		// write your code here
		int slow = 0;
		int maxLen = 0;

		// Key: letter; value: the number of occurrences.
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int fast;
		for (fast = 0; fast < s.length(); ++fast) {
			char c = s.charAt(fast);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
				while (map.size() > k) {
					char slowChar = s.charAt(slow++);
					int count = map.get(slowChar);
					if (count > 1) {
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

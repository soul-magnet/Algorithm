package Ladder1.FollowupCodingInt;
/** Required
 * 384. Longest Substring Without Repeating Characters
 * 
 * Given a string, find the length of the longest substring without repeating characters.


Example: For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
which the length is 3.

For "bbbbb" the longest substring is "b", with the length of 1.

Challenge 
O(n) time

Tags: Two Pointers Hash Table String

Related Problems 
1 - Medium Longest Substring with At Most K Distinct Characters
 * */

public class LongestSubstringWithoutRepeatingCharacters {
    /**
     * @param s: a string
     * @return: an integer 
     */
    public int lengthOfLongestSubstring(String s) {
     	if (s == null || s.length() == 0) {return 0;}
		int [] set = new int [256] ; char [] s1 = s.toCharArray();
		int l = 0, r=0, res = Integer.MIN_VALUE ;
		while(r<s1.length) {
			if (set[s1[r]]== 0) {
			    set[s1[r]]++;r++;
			    res = Math.max(res, r-l);
			} else {
			    res = Math.max(res, r-l);
				while (set[s1[l]] != set[s1[r]]) {
					l++;
				}
				set[s1[l++]]--;
			}
		}
		return res;
    }
    
     public int lengthOfLongestSubstring1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int [] dic = new int[256];
        int l=0, r=0,ct= 0, res=0;
        char[] s1 = s.toCharArray();
        while(r<s.length()){
            if(dic[s1[r]]<1){
                dic[s1[r]]++; r++;ct++;
            }else //if(dic[s1[r]]>0)
            {
                res = Math.max(res, ct);
                dic[s1[l]]--;l++;ct--;
            }

        }
        
        res = Math.max(res, ct);
        return res;
    }
}

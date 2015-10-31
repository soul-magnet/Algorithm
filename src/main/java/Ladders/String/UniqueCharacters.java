package String;
/*
 * Implement an algorithm to determine if a string has all unique characters.
 *Example: Given "abc", return true. Given "aab", return false.
 *Challenge: What if you can not use additional data structures? 
 *
 **/
public class UniqueCharacters {
	/**
     * @param str: a string
     * @return: a boolean
     */
    public boolean isUnique(String str) {
    	for (int i = 0; i < str.length(); i++){
    		char c = str.charAt(i);
    		for (int j = i + 1; j < str.length(); j++){
    			char d = str.charAt(j);
    			if (c == d)
    				return false;
    		}
    	}
    	return true;
    }
}

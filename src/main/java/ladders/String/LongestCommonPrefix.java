package String;
/*
 * Given k strings, find the longest common prefix (LCP)
 * Example
 * For strings "ABCD", "ABEF" and "ACEF", the LCP is "A"
 * For strings "ABCDEFG", "ABCEFG" and "ABCEFA", the LCP is "ABC"
 * 
 * Analysis: 
 * To solve this problem, we need to find the two loop conditions.
 * One is the length of the shortest String. 
 * The other is iteration of every element.
 * */
public class LongestCommonPrefix {
	/**
     * @param strs: A list of strings
     * @return: The longest common prefix
     */
	
	// Brute Force Algorithm 
	/*public String longestCommonPrefix(String[] strs){
		if (strs == null || strs.length == 0){
			return "";
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("");
		for (int i = 0; i < strs[0].length(); i++){
			for (int j = 1; j < strs.length; j++) {
				if (i == strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i)){
					return sb.toString();
				}
			}
			sb.append(strs[0].charAt(i));
		}
		
		return sb.toString();
	}*/
	
	public String longestCommonPrefix(String[] strs){
		if (strs == null || strs.length == 0){
			return "";
		}
		
		int minLen = Integer.MAX_VALUE;
		for (String str : strs){
			if (minLen > str.length()){
				minLen = str.length();
			}
		}
		
		if (minLen == 0) return "";
		for (int j = 0; j < minLen; j++){
			char prev = '0';
			for (int i = 0; i < strs.length; i++){
				if (i == 0){
					prev = strs[i].charAt(j);
					continue;
				}
				if(strs[i].charAt(j) != prev){
					return strs[i].substring(0, j);
				}
			}
		}
		
		return strs[0].substring(0, minLen);
	}
}

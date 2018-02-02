package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Given an array of strings, 
 * return all groups of strings that are anagrams.
 * Example
 * Given ["lint", "intl", "inlt", "code"], return ["lint", "inlt", "intl"].
 * Given ["ab", "ba", "cd", "dc", "e"], return ["ab", "ba", "cd", "dc"].
 * Note
 * All inputs will be in lower-case
 * Analysis:
 * Establish a hashMap. Key is sorted String. Value is the list of the key's anagrams
 * Return lists which size > 1 in maps's value
 * */
public class Anagrams {
	/**
     * @param strs: A list of strings
     * @return: A list of strings
     */
	
	public List<String> anagrams(String[] strs){
		List<String> result = new ArrayList<String>();
		
		if (strs == null) {
			return result;
		}
		
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		for (int i = 0; i < strs.length; i++) {
			String s = strs[i];
			char[] chars = s.toCharArray();
			// sort the chars
			Arrays.sort(chars);
			String strSort = new String(chars);
			
			if (map.containsKey(strSort)){
				map.get(strSort).add(s);
			} else {
				List<String> list = new ArrayList<String>();
				list.add(s);
				map.put(strSort, list);
			}
		}
		
		// Bug 1: Should use map.entrySet() instead of MAP
		/*for (Map.Entry<String, List<String>> entry : map.entrySet()){
			List<String> list = entry.getValue();
			if (list.size() > 1){
				result.addAll(list);
			}
		}
		
		*/
		
		for (String key : map.keySet()){
			if (map.get(key).size() > 1){
				result.addAll(map.get(key));
			}
		}
		
		return result;
		
	}

}

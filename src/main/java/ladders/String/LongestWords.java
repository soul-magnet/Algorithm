package String;

import java.util.ArrayList;

/*
 * Given a dictionary, find all of the longest words in the dictionary.
 * Given

{
  "dog",
  "google",
  "facebook",
  "internationalization",
  "blabla"
}
the longest words are(is) ["internationalization"].

Given

{
  "like",
  "love",
  "hate",
  "yes"
}
the longest words are ["like", "love", "hate"].

Challenge: It's easy to solve it in two passes, can you do it in one pass? 

*/
public class LongestWords {
	/**
     * @param dictionary: an array of strings
     * @return: an arraylist of strings
     */
    ArrayList<String> longestWords(String[] dictionary) {
        ArrayList<String> result = new ArrayList<String>();
        for (String str : dictionary){
        	if(result.isEmpty() || result.get(0).length() < str.length()){
        		result.clear();
        		result.add(str);
        	} else if(result.get(0).length() == str.length()){
        		result.add(str);
        	}
        }
        return result;
    }
}

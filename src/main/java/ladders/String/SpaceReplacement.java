package String;
/*
 * Write a method to replace all spaces in a string with %20. 
 * The string is given in a characters array, you can assume it has enough space 
 * for replacement and you are given the true length of the string.
 * Example: Given "Mr John Smith", length = 13.
 * The string after replacement should be "Mr%20John%20Smith".
 * Note: If you are using Java or Python，please use characters array 
 * instead of string.
 * Challenge: Do it in-place.
 * 
 * Tags: String
 * 
 * Analysis: Parse twice, the first pass calculates the reqired length, 
 * the second time from back the fill
 * */
public class SpaceReplacement {
	/**
     * @param string: An array of Char
     * @param length: The true length of the string
     * @return: The true length of new string
     */
    public int replaceBlank(char[] string, int length) {
        if (string == null || length == 0)
        	return 0;
        int result = length;
        for (int i = 0; i < length; i++){
        	if (string[i] == ' '){
        		result += 2;
        	}
        }
        
        int index = result - 1;
        for (int i = length - 1; i >= 0; i--){
        	if (string[i] == ' '){
        		string[index] = '0';
        		string[index - 1] = '2';
        		string[index - 2] = '%';
        		index -= 3;
        	} else {
        		string[index] = string[i];
        		index--;
        	}
        }
        return result;
    }
}

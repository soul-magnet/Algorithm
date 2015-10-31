package String;
/*
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', 
 * return the length of last word in the string.
 * If the last word does not exist, return 0.
 * Example: Given s = "Hello World", return 5.
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * 
 * */
public class LengthOfLastWord {
	public int lengthOfLastWord(String s){
		int length = 0;
		char[] chars = s.toCharArray();
		for (int i = s.length() - 1; i >= 0; i--){
			if(length == 0){
				if(chars[i] == ' '){
					continue;
				} else {
					length++;
				}
			} else {
				if (chars[i] == ' '){
					break;
				} else {
					length++;
				}
			}
		}
		return length;
	}
}

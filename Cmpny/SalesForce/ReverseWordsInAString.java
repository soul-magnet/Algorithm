package SalesForce;
/**
 * 53. Reverse Words in a String - Easy
 
Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".


Clarification
What constitutes a word?
A sequence of non-space characters constitutes a word.
Could the input string contain leading or trailing spaces?
Yes. However, your reversed string should not contain leading or trailing spaces.
How about multiple spaces between two words?
Reduce them to a single space in the reversed string.
Example

Tags 
String
Related Problems 
Medium Reverse Linked List II 30 %
Easy Reverse Linked List 40 %
 * */
public class ReverseWordsInAString {
	/**
     * @param s : A string
     * @return : A string
     */
    public String reverseWords(String s) {
           String [] dic = s.split(" ");
           if(dic.length==0){
               return "";
           }
        StringBuffer stringBuffer = new StringBuffer();
        for(int i=dic.length-1;i>-1;i--){
            stringBuffer.append(dic[i]);
            stringBuffer.append(" ");
        }
        stringBuffer.deleteCharAt(stringBuffer.length()-1);
        return stringBuffer.toString();
    }

}

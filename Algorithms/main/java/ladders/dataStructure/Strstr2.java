package main.java.ladders.dataStructure;
/**
 * 594. strStr II - Hard - Required

Implement strStr function in O(n + m) time.

strStr return the first index of the target string in a source string. 
The length of the target string is m and the length of the source string is n.
If target does not exist in source, just return -1.

Example
Given source = abcdef, target = bcd, return 1.

Tags 
Hash Table
Related Problems 
Easy strStr 18 %
 * */
public class Strstr2 {
	 /**
     * @param source a source string
     * @param target a target string
     * @return an integer as index
     */
    public int strStr2(String s, String t) {
        if(s==null||t==null)return  -1;
        if(t.length()==0) return 0;
        if(s.length()==0) return -1;
        int base = 10000000;
        int power = 1;for(int i=0; i<t.length();i++){power=(power*31);}
        int thash=0; for(int i=0; i<t.length();i++){thash=(thash*31+t.charAt(i));}
        int shash=0;
        for(int i=0; i<s.length();i++){
            shash=(shash*31+s.charAt(i));
            if(i<t.length()-1){continue;}
            if(i>=t.length()) {
                shash -= (s.charAt(i - t.length()) * power) % base;
                if(shash<0)shash+=base;
            }
            if (shash == thash) {
                if (s.substring(i - t.length() + 1, i + 1).equals(t))
                    return i - t.length() + 1;
            }
        }
        return -1;
    }

}

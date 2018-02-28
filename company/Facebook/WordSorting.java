package Facebook;

import java.util.Arrays;

/**
 * 
 * 819. Word Sorting 
 
Give a new alphabet, such as {c,b,a,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z}. 
Sort the string array according to the new alphabet

 Notice
The length of word does not exceed 100.
The number of words does not exceed 10000.
You can assume that the given new alphabet is a 26-character string.
Only lowercase letters.

Example
Given Alphabet = {c,b,a,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z}, String array = {cab,cba,abc}, 
return {cba,cab,abc}.

Explanation:
According to the new dictionary order, output the sorted result {cba, cab, abc}.
Given Alphabet = {z,b,a,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,c}, 
String array = {bca,czb,za,zba,ade}, return {zba,za,bca,ade,czb}.

Explanation:
According to the new dictionary order, output the sorted result {zba,za,bca,ade,czb}.

Tags: Facebook
 * */

//Juizhang Solution
public class WordSorting {
	/**
     * @param alphabet: the new alphabet
     * @param words: the original string array
     * @return: the string array after sorting
     */
    public String[] wordSort(char[] alphabet, String[] words) {
        // Write your code here
    	char []Into = new char[1000];
        char []Outto = new char[1000];
        for(int i = 0; i < alphabet.length; i++) {
            Into[(int)alphabet[i]] = (char)('a' + i);
            Outto['a' + i] = alphabet[i];
        }
        for(int i = 0; i < words.length; i++) {
            String temp = new String();
            for(int j = 0; j < words[i].length(); j++) {
                temp += Into[(int)words[i].charAt(j)];
            }
            words[i] = temp;
        }
        Arrays.sort(words);
        for(int i = 0; i < words.length; i++) {
            String temp = new String();
            for(int j = 0; j < words[i].length(); j++) {
                temp += Outto[(int)words[i].charAt(j)];
            }
             words[i] = temp;
        }
        return words;
    }

}

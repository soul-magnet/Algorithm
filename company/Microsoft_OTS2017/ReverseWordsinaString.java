package MS.OA2017;

/**Given an input string, reverse the string word by word.

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
 * Created by K25553 on 9/16/2016.
 */
public class ReverseWordsinaString {
    /**
     * @param s : A string
     * @return : A string
     */
    public static  String reverseWords(String s) {
        String [] dic = s.split(" ");
        if(dic.length==0){
            return "";
        }
        StringBuffer sb = new StringBuffer();
        for(String now : dic){
            int l=0, r=now.length()-1; char[] crt = now.toCharArray();
            while(l<r){
                char temp =  crt[l];
                crt[l] =crt[r];
                crt[r] =temp;
                l++; r--;
            }
            sb.append(crt);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    public static void main(String [] args){
        System.out.println(reverseWords( "black friday"));
    }
}

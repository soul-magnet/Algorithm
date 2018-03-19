package MS.OA2017;

/**
 * Created by wtnwi on 1/15/2017.
 */
public class PalindromeDigitalClock {
    static boolean isPalindrom(String s){
        if(s==null||s.length()==0){
            return false;
        }
        String dic = s.replaceAll(":\\s*","");
        System.out.println(dic);
        if(dic.length()==3){
            int l=0, r=2;
            if(dic.charAt(l)==dic.charAt(2)){
                return true;
            }else{
                return false;
            }
        }
        if(dic.length()==4){
            int l=1,r=2;
            if(dic.charAt(l)==dic.charAt(r)&&dic.charAt(1-1)==dic.charAt(r+1)){
                return true;
            }else{
                return false;
            }
        }
        return false;
    }
    public static void main(String[] args){
       System.out.println(isPalindrom("12:21"));
        System.out.println(isPalindrom("12:   1"));
        System.out.println(isPalindrom("1:   21"));
        System.out.println(isPalindrom("1: 22"));
        System.out.println(isPalindrom("12:   123"));
        System.out.println(isPalindrom("1: 1"));
    }
}

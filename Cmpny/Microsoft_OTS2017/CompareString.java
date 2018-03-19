package MS.OA2017;

/**给两个string 第一个string里的character全部按顺序在第二个string的话return true 反之return false。

 * Created by wtnwi on 1/13/2017.
 */
public class CompareString {
    public static boolean compareStrings(String a, String b) {
       char[] a1 = a.toCharArray(),b1= b.toCharArray();
        int i=0, j=0;
        while(i<a1.length&&j<b1.length){
            while(i+1<a1.length&&a1[i+1]==a1[i])i++;
            while(j+1<b1.length&&b1[j+1]==b1[j])j++;
            if(a1[i]!=b1[j]){
                System.out.println(a1[i]+" "+b1[j]);
                return false;
            }
            i++;j++;
        }
        return i==a1.length;
    }
    public  static void main(String [] args){
        System.out.println(compareStrings("adsf","aaddddsf"));
    }
}

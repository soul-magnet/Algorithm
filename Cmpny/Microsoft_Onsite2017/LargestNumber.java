package MS.Onsite2017;

import java.util.Arrays;
import java.util.Comparator;

/**Given a list of non negative integers, arrange them such that they form the largest number.

 Notice

 The result may be very large, so you need to return a string instead of an integer.

 Have you met this question in a real interview? Yes
 Example
 Given [1, 20, 23, 4, 8], the largest formed number is 8423201.

 Challenge
 Do it in O(nlogn) time complexity.
 * Created by K25553 on 10/20/2016.
 */
public class LargestNumber {
    /**
     *@param num: A list of non negative integers
     *@return: A string
     */
    public String largestNumber(int[] num) {
        if(num==null ||num.length==0){
            return "";
        }
        String [] dic = new String[num.length];
        for(int i=0; i< num.length;i++){
            dic[i]=String.valueOf(num[i]);
        }
        Arrays.sort(dic, new Comparator<String>(){

            @Override
            public int compare(String o1, String o2) {
                return o2.concat(o1).compareTo(o1.concat(o2));
            }
        });
        String res ="";
        for(String s :dic){
            res += s;
        }
        if(res.charAt(0)=='0'){
            return "0";
        }
        return res;
    }
}

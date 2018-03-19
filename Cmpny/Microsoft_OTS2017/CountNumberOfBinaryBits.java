/**
 *
 */
package MS.OA2017;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 输出一个int里面的0和1的个数，但是给了个例子很迷惑：123 = 01111011， 输出[2,6]
 *
 * @author K25553
 *
 */
public class CountNumberOfBinaryBits {
	static int[] NumberOfBinaryBits(int n){
		int[] res = new int [2];
		if(n<=0){
			return res;
		}
		while(n!= 0){
			if(n%2==0){
				res[0]++;
			}else{
				res[1]++;
			}
			n/=2;
		}
		res[0]++;
		return res;
	}
	private String parseInteger(String str) {
		int n = Integer.parseInt(str);
		if (str.equals("") || str.equals("0")) {
			return "0";
		}
		String binary = "";
		while (n != 0) {
			binary = Integer.toString(n % 2) + binary;
			n = n / 2;
		}
		binary = "0"+ binary;
		return binary;
	}

	private String parseFloat(String str) {
		double d = Double.parseDouble("0." + str);
		String binary = "";
		HashSet<Double> set = new HashSet<Double>();
		while (d > 0) {
			if (binary.length() > 32 || set.contains(d)) {
				return "ERROR";
			}
			set.add(d);
			d = d * 2;
			if (d >= 1) {
				binary = binary + "1";
				d = d - 1;
			} else {
				binary = binary + "0";
			}
		}
		return binary;
	}

	public String binaryRepresentation(String n) {
		if (n.indexOf('.') == -1) {
			return parseInteger(n);
		}
		String[] params = n.split("\\.");
		String flt = parseFloat(params[1]);
		if (flt == "ERROR") {
			return flt;
		}
		if (flt.equals("0") || flt.equals("")) {
			return parseInteger(params[0]);
		}
		return parseInteger(params[0]) + "." + flt;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(Arrays.toString(NumberOfBinaryBits(123)));
	}

}

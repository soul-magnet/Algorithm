package BitManipulation;

import java.util.HashSet;

/*
 * Given a (decimal - e.g. 3.72) number that is passed in as a string, 
 * return the binary representation that is passed in as a string. 
 * If the fractional part of the number can not be represented accurately 
 * in binary with at most 32 characters, return ERROR.
 * Example
 * For n = "3.72", return "ERROR".
 * For n = "3.5", return "11.1"
 * 
 * */
public class BinaryRepresentation {
	
	/**
     *@param n: Given a decimal number that is passed in as a string
     *@return: A string
     */
     
     /* 1. Use %2 to get each digit from lowest bit to the highest bit
        2. int right shift 1 position (=>> 1)
        3. Construct binary number (always add to the higher position of the curent number)
        4. For decimal part, use *2 approach. For example: int n = 0.75 so n*2 = 1.5
        Therefore, the first digit of binary number after '.' is 1(i.e. 0.1)
        After constructed the first digit, n = n*2 - 1
     */
	
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
		return binary;
	}
	
	private String parseFloat (String str) {
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
		
		String [] params = n.split("\\.");
		String flt = parseFloat(params[1]);
		if (flt == "ERROR"){
			return flt;
		}
		
		if (flt.equals("0") || flt.equals("")){
			return parseInteger(params[0]);
		}
		
		return parseInteger(params[0]) + "." + flt;
	}
	
	// Another Solution 
	
	/*
	  public String binaryRepresentation(String n) {
        int intPart  = Integer.parseInt(n.substring(0, n.indexOf('.')));
        double decPart = Double.parseDouble(n.substring(n.indexOf('.')));
        String intstr = "";
        String decstr = "";
        
        if (intPart == 0) intstr += '0';
        while (intPart > 0) {
            int c = intPart % 2;
            intstr = c + intstr;
            intPart = intPart / 2;
        }
        
        while (decPart > 0.0) {
            if (decstr.length() > 32) return "ERROR";
            double r = decPart * 2;
            if (r >= 1.0) {
                decstr += '1';
                decPart = r - 1.0;
            } else {
                decstr += '0';
                decPart = r;
            }
        }
        
        return decstr.length() > 0 ? intstr + "." + decstr : intstr;
    }*/

}

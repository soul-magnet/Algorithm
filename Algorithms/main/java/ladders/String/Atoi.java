package String;

/*
 * Implement function atoi to convert a string to an integer.
 * If no valid conversion could be performed, a zero value is returned.
 * If the correct value is out of the range of representable values, 
 * INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 * Example
 * "10" => 10
 * "-1" => -1
 * "123123123123123" => 2147483647
 * "1.0" => 1
 * */

public class Atoi {
	/**
     * @param str: A string
     * @return An integer
     */
	
	/*
    Implement atoi to convert a string to an integer.
    Hint: Carefully consider all possible input cases. 
    If you want a challenge, please do not see below and ask yourself 
    what are the possible input cases. 
    Notes: It is intended for this problem to be specified vaguely (ie, no given input specs).
    You are responsible to gather all the input requirements up front. 
    spoilers alert... click to show requirements for atoi. 
    Requirements for atoi: The function first discards as many whitespace characters as necessary
    until the first non-whitespace character is found. 
    Then, starting from this character, takes an optional initial plus or minus sign 
    followed by as many numerical digits as possible, and interprets them as a numerical value. 
    The string can contain additional characters after those that form the integral number, 
    which are ignored and have no effect on the behavior of this function. 
    If the first sequence of non-whitespace characters in str is not a valid integral number, 
    or if no such sequence exists because either str is empty or it contains only whitespace characters, 
    no conversion is performed. If no valid conversion could be performed, a zero value is returned. 
    If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned
    */
	
	public int atoi(String str){
		if (str == null || str.length() == 0){
			return 0;
		}
		
		str = str.trim();
		int sign  = 1;
		int index = 0;
		
		if (str.charAt(index) == '+'){
			index++;
		} else if (str.charAt(index) == '-') {
			sign = -1;
			index++;
		}
		
		long num = 0;
		for (; index < str.length(); index++){
			if (str.charAt(index) < '0' || str.charAt(index) > '9')
				break;
			num = num * 10 + (str.charAt(index) - '0');
			if(num > Integer.MAX_VALUE){
				break;
			}
		}
		
		if (num * sign >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        
        if (num * sign <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        
        return (int)num*sign;
	}

}

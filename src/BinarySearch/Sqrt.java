package BinarySearch;

/**
 * 141. Sqrt(x) - Easy - Related

Implement int sqrt(int x).

Compute and return the square root of x.

Example
sqrt(3) = 1

sqrt(4) = 2

sqrt(5) = 2

sqrt(10) = 3

Challenge 
O(log(x))

Tags: Binary Search Mathematics Facebook

Related Problems 
Easy Valid Perfect Square 34 %
Medium Sqrt(x) II 32 %
Medium Pow(x, n) 34 %
Easy First Position of Target 33 %
 * 
 * */
/* Analysis:
 * We can use binary search for this problem. It's possible that integer overflows.
 * So in the following code I use long type. 
 * There is another way, which is Newton's Method.
 * */
public class Sqrt {
	/**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
    	long lo = 0;
    	long hi = x / 2 + 1;
    	while (lo <= hi){
    		long mid = (lo + hi) / 2;
    		if (mid * mid == x)
    			return (int)mid;
    		if (mid * mid < x)
    			lo = mid + 1;
    		else 
    			hi = mid - 1;
    	}
    	return (int)hi;
    }
    
    // Newton iterative method
    
    /*public int sqrt(int x){
    	if (x == 0) return 0;
    	Double last = 0.0;
    	Double res = 1.0;
    	while (res != last){
    		last = res;
    		res = (res + x / res)/ 2;
    	}
    	
    	return res;
    	
    }*/
}

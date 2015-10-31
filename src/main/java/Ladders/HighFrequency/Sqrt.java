package HighFrequency;
/*
 *Implement int sqrt(int x).
 *Compute and return the square root of x.
 *Analysis: Binary Search
 *We can use binary search for this problem. 
 *It could be pretty easy to implement. 
 *It’s possible that integer overflows. 
 *So in the following code I use long type.
 *There is another way, which is Newton’s Method.  */
public class Sqrt {
	public int sqrt(int x) {
		long lo = 0;
		long hi = x;
		
		while (hi >= lo) {
			long mid = lo + (hi - lo)/2;
			if (x < mid * mid) {
				hi = mid -1;
			} else {
				lo = mid + 1;
			}
		}
		
		return (int)hi;
	}

}

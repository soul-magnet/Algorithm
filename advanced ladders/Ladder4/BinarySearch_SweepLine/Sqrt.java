package Ladder4.BinarySearch_SweepLine;
/**
 * 141. Sqrt(x) - Easy - Required
 * 
Implement int sqrt(int x).

Compute and return the square root of x.

Example
sqrt(3) = 1

sqrt(4) = 2

sqrt(5) = 2

sqrt(10) = 3

Challenge 
O(log(x))

Tags: Mathematics Binary Search Facebook

Related Problems 
Easy Valid Perfect Square 38 %
Medium Sqrt(x) II 32 %
Medium Pow(x, n) 34 %
Easy First Position of Target 33 %
 * */
public class Sqrt {
	
	/**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
       /*long l=1, r=x;
        while(l+1<r){
            long mid= l+(r-l)/2;
            if(mid*mid==x){
                return (int)mid;
            }else
            if(mid*mid>x){
                r=mid;
            }else{
                l=mid;
            }
        }

        if(r*r<=x){
            return (int)r;
        }else {
            return (int)l;
        }*/
        
        /*long start = 1, end = x;
        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            if (mid * mid <= x) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (end * end <= x) {
            return (int) end;
        }
        return (int) start;*/
        
        long i = 0;
        long j = x / 2 + 1;
        while (i <= j) {
            long mid = (i + j) / 2;
            if (mid * mid == x)
                return (int)mid;
            if (mid * mid < x)
                i = mid + 1;
            else
                j = mid - 1;
        }
        return (int)j;

    }

}

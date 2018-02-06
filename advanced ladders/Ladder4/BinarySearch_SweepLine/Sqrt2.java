package Ladder4.BinarySearch_SweepLine;
/**
 * 586. Sqrt(x) II - Medium - Required

Implement double sqrt(double x) and x >= 0.

Compute and return the square root of x.

 Notice
You do not care about the accuracy of the result, we will help you to output results.

Example
Given n = 2 return 1.41421356

Tags 
Mathematics Binary Search Facebook
Related Problems 
Easy Valid Perfect Square 38 %
Easy Sqrt(x) 25 %
 * */
public class Sqrt2 {
	/**
     * @param x a double
     * @return the square root of x
     */
    public double sqrt1(double x) {
        // Write your code here
        
        long start = 0;
        long end = (long)x - 1;
        
        while(start + 1 < end){
            double mid =(double)(start + (end - start)/2);
            if(mid * mid == x){
                return mid;
            }else if(mid * mid < x){
                start = (long)mid;
            }else{
                end = (long)mid;
            }
        }
        
        if(start * start <= x){
            return (double)start;
        }else{
            return (double)end;
        }
    }
    
    //Note to Emine: Need to review
    public double sqrt(double x) {
        // Write your code here
        
        double start = 0.0;
        double end = x;
        double eps = 1e-12;
        
        if (x < 1.0) {
            end = 1.0;
        }
        
        while (end - start > eps) {
            double mid = (start + end) / 2;
            if (mid * mid < x) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        
        return start;
    }

}

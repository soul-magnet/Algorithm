package Ladder4.BinarySearch_SweepLine;
/**
 * 74. First Bad Version - Medium - Required

The code base version is an integer start from 1 to n. One day, someone committed a bad version in the code case,
so it caused this version and the following versions are all failed in the unit tests. Find the first bad version.

You can call isBadVersion to help you determine which version is the first bad one. 
The details interface can be found in the code's annotation part.

 Notice
Please read the annotation in code area to get the correct way to call isBadVersion in different language. 
For example, Java is SVNRepo.isBadVersion(v)

Example
Given n = 5:

isBadVersion(3) -> false
isBadVersion(5) -> true
isBadVersion(4) -> true
Here we are 100% sure that the 4th version is the first bad version.

Challenge 
You should call isBadVersion as few as possible.

Tags: LintCode Copyright Binary Search Facebook

Related Problems 
Easy Guess Number Game 25 %
Medium Nuts & Bolts Problem 19 %
 * 
*/

/**
 * public class VersionControl {
 *     public static boolean isBadVersion(int k);
 * }
 * you can use VersionControl.isBadVersion(k) to judge whether 
 * the kth code version is bad or not.
*/
public class FirstBadVersion {
	
	/**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        
       if (n <= 1) {
            return n;
        }
        
        int start = 0, end = n;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (SVNRepo.isBadVersion(mid)) {
                end = mid;
            } else {
                // Bad interval must be in the right
                start = mid;
            }
        }
        return SVNRepo.isBadVersion(start) ? start : end;
        
    }
    
    /* public int findFirstBadVersion(int n) {
        
        if (n <= 1) {
            return n;
        }
        
        int start = 1, end = n;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (SVNRepo.isBadVersion(mid)) {
                end = mid;
            } else {
                // Bad interval must be in the right
                start = mid;
            }
        }
        return SVNRepo.isBadVersion(start) ? start : end;
        
    }*/

}

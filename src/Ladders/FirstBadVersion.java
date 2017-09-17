package Ladders;

//The code base version is an integer start from 1 to n. One day, someone committed a bad version in the code case, so it caused this version and the following versions are all failed in the unit tests. Find the first bad version.
//
//You can call isBadVersion to help you determine which version is the first bad one. The details interface can be found in the code's annotation part.
//
//Have you met this question in a real interview? Yes
//Example
//Given n = 5:
//
//isBadVersion(3) -> false
//isBadVersion(5) -> true
//isBadVersion(4) -> true
//Here we are 100% sure that the 4th version is the first bad version
public class FirstBadVersion {
	/**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */
	/**
	 * public class VersionControl {
	 *     public static boolean isBadVersion(int k);
	 * }
	 * you can use VersionControl.isBadVersion(k) to judge whether 
	 * the kth code version is bad or not.
	*/
	
	public class VersionControl {
		     public static boolean isBadVersion(int k);
		 }
    public int findFirstBadVersion(int n) {
        int start = 1, end = n;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (VersionControl.isBadVersion(mid)){
                end = mid;
            } else {
                start = mid;
            }
        }
        if (VersionControl.isBadVersion(start)) {
            return start;
        }
        return end;
    }
}
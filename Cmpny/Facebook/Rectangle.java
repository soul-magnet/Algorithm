package Facebook;

import java.util.HashSet;
import java.util.Set;

/**
 *820. Rectangle - Medium
 
Give a set, if you can find four points that make up a rectangle that is parallel to the coordinate axis and 
outputs YES or NO.

 Notice
The number of points in the set is less than 2000, and the coordinate range is [-10000000,10000000].

Example
Given set = [[0,0],[0,1],[1,1],[1,0]], return YES.

Explanation:
We can find four points that make up a rectangle which is parallel to the coordinate axis.
Given set = [[0,0],[0,1],[1,1],[2,0]], return NO.

Explanation:
We can not find four points that meet the conditions.

Tags: Facebook
 * 
 * */

/*
public class Point {
    public int x;
    public int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
*/

//Juizhang Solution
public class Rectangle {
    /**
     * @param pointSet: The point set
     * @return: The answer
     */
    public String rectangle(Point[] pointSet) {
        // Write your code here
    	// Write your code here
        Set<Long> hashtable = new HashSet<Long>();
        for(int i = 0; i < pointSet.length; i++) {
            hashtable.add(hash(pointSet[i].x, pointSet[i].y));
        }
        for(int i = 0; i < pointSet.length; i++) {
            for(int j = 0; j < pointSet.length; j++) {
                if(pointSet[i].x < pointSet[j].x && pointSet[i].y < pointSet[j].y) {
                    long temp1 = hash(pointSet[i].x, pointSet[j].y);
                    long temp2 = hash(pointSet[j].x, pointSet[i].y);
                    if(hashtable.contains(temp1) && hashtable.contains(temp2)) {
                        return "YES";
                    }
                }
            }
        }
        return "NO";
    }
    
    
    long hash(int x, int y) {
        return (long)x * 10000000 + y;
     }
}


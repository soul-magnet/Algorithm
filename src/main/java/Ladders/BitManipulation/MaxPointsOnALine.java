package BitManipulation;

import java.util.HashMap;

/* Given n points on a 2D plane, find the maximum number of points 
 * that lie on the same straight line.
 * Example: Given 4 points: (1,2), (3,6), (0,0), (1,3).
 * The maximum number is 3.
 * 
 * Analysis: This problem can be solve by counting points that have the same slope
 * for each point. When counting, we need to be careful about the duplicate points
 * on the vertical lines. 
 * 
 * Algorithm:
 * for each point i in the plane:
 * 	for each point j in the plane:
 * 		if (i != j)
 * 			compute and store the slope
 * 		Sort the slope array
 * 		Count how many slops are the same
 * 		Store the max number
 * 
 * Reference: http://yucoding.blogspot.com/2013/12/leetcode-question-max-points-on-line.html
 * */

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class MaxPointsOnALine {
	 /**
     * @param points an array of point
     * @return an integer
     */
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0)
        	return 0;
        HashMap<Double, Integer> map = new HashMap<Double, Integer>();
        int max =1;
        for (int i = 0; i < points.length; i++){
        	// shared point changed, map should be cleared and server the new point
        	map.clear();
        	// maybe all points contained in the list are same points, and same points' k is
        	// represented by Integer.MIN_VALUE
        	map.put((double)Integer.MIN_VALUE, 1);
        	int dup = 0;
        	for (int j = i + 1; j < points.length; j++){
        		if (points[j].x == points[i].x && points[j].y == points[i].y){
        			dup++;
        			continue;
        		}
        		
        		// look 0.0+(double)(points[j].y-points[i].y)/(double)(points[j].x-points[i].x)
                // because (double)0/-1 is -0.0, so we should use 0.0+-0.0=0.0 to solve 0.0 !=-0.0
                // problem

                // if the line through two points are parallel to y coordinator, then K(slop) is 
                // Integer.MAX_VALUE
                double key=points[j].x - points[i].x == 0 ? 
                    Integer.MAX_VALUE :
                    0.0 + (double)(points[j].y - points[i].y) / (double)(points[j].x - points[i].x);

                if (map.containsKey(key)) {
                    map.put(key, map.get(key) + 1);
                } else {
                    map.put(key, 2);
                }
            }

            for (int temp: map.values()) {
                // duplicate may exist
                if (temp + dup > max) {
                    max = temp + dup;
                }
            }

        }
        return max;
    }
}

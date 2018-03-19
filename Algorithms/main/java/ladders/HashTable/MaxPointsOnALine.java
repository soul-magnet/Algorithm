package main.java.ladders.HashTable;
/**
 * 186. Max Points on a Line - Medium

Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

Have you met this question in a real interview? 
Example
Given 4 points: (1,2), (3,6), (0,0), (1,3).

The maximum number is 3.

Tags 
Hash Table Mathematics LinkedIn
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
	/*
     * @param points: an array of point
     * @return: An integer
     */
    
    /*public int maxPoints(Point[] points) {
        if(points.length <= 0) return 0;
        if(points.length <= 2) return points.length;
        int result = 0;
        for(int i = 0; i < points.length; i++){
            HashMap<Double, Integer> hm = new HashMap<Double, Integer>();
            int samex = 1;
            int samep = 0;
            for(int j = 0; j < points.length; j++){
                if(j != i){
                    if((points[j].x == points[i].x) && (points[j].y == points[i].y)){
                        samep++;
                    }
                    if(points[j].x == points[i].x){
                        samex++;
                        continue;
                    }
                    double k = (double)(points[j].y - points[i].y) / (double)(points[j].x - points[i].x);
                    if(hm.containsKey(k)){
                        hm.put(k,hm.get(k) + 1);
                    }else{
                        hm.put(k, 2);
                    }
                    result = Math.max(result, hm.get(k) + samep);
                }
            }
            result = Math.max(result, samex);
        }
        return result;
    }*/
    
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
         
        int max = 1;
        for (int i = 0; i < points.length - 1; i++) {
            Map<Double, Integer> map = new HashMap<Double, Integer>();
            int samePoints = 0;
            double slope = 0;
            int localMax = 1;
            for (int j = i + 1; j < points.length; j++) {
                // check if point i and j are the same
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    samePoints++;
                    continue;
                } else {
                    slope = (double) (points[j].y - points[i].y) / (points[j].x - points[i].x);
                }
                 
                 
                if (map.containsKey(slope)) {
                    map.put(slope, map.get(slope) + 1);
                } else {
                    map.put(slope, 2);
                }
            }
            for (Integer num : map.values()) {
                localMax = Math.max(localMax, num);
            }
            localMax += samePoints;
            max = Math.max(max, localMax);
        }
        return max;
    }

}

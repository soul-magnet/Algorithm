package Ladder4.BinarySearch_SweepLine;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 391. Number of Airplanes in the Sky - Medium - Required

 Judge
Given an interval list which are flying and landing time of the flight. How many airplanes are on the sky at most?

 Notice
If landing and flying happens at the same time, we consider landing should happen at first.

Example
For interval list

[
  [1,10],
  [2,3],
  [5,8],
  [4,7]
]
Return 3

Tags 
Array LintCode Copyright Interval
Related Problems 
Easy Merge Intervals 22 %
 * */

/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */
public class NumberOfAirplanesInTheSky {
	class Point {
		int time, status;

		Point(int time, int status) {
			this.time = time;
			this.status = status;
		}
		 
	}

	/**
	 * 
	 *            : An interval array
	 * @return: Count of airplanes are in the sky.
	 */
	public int countOfAirplanes(List<Interval> airplanes) {
		if (airplanes.size() == 0 || airplanes == null) {
			return 0;
		}
		Point [] points = new Point[airplanes.size()*2]; int i=0;
		for(Interval crt : airplanes){
			points[i++] = new Point(crt.start, 0);
			points[i++] = new Point(crt.end, 1);
		}
		 Comparator<Point> pointComparator = new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				if (o1.time == o2.time) {
					// to aviod case like 12 23 34 the max is 1 not 2
					return o2.status - o1.status;
				}
				return o1.time - o2.time;
			}
		};
		Arrays.sort(points,pointComparator);
		int res = 0;
		int ct =0;
		for(Point crt : points){
			if(crt.status==0){
				ct++;
			}else{
				ct--;
			}
			res= Math.max(ct, res);
		}
		return res;
	}

}

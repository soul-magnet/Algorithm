package Facebook;

import java.util.ArrayList;
import java.util.List;

/**
 * 821. Time Intersection - Medium

Give two users' ordered online time series, and each section records the user's login time point x 
and offline time point y. Find out the time periods when both users are online at the same time, 
and output in ascending order.

 Notice
We guarantee that the length of online time series meet 1 <= len <= 1e6.
For a user's online time series, any two of its sections do not intersect.

Example
Given seqA = [[1,2],[5,100]], seqB = [[1,6]], return [[1,2],[5,6]].

Explanation:
In these two time periods [1,2],[5,6], both users are online at the same time.
Given seqA = [[1,2],[10,15]], seqB = [[3,5],[7,9]], return [].

Explanation:
There is no time period, both users are online at the same time.

Tags: Facebook
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
public class TimeIntersection {
    /**
     * @param seqA: the list of intervals
     * @param seqB: the list of intervals
     * @return: the time periods
     */
	//Juizhang Solution
    public List<Interval> timeIntersection(List<Interval> seqA, List<Interval> seqB) {
        // Write your code here
        int [] visit = new int[1000001];
        for(int i = 0; i < 1000001; i++) {
            visit[i] = 0;
        }
        for(int i = 0; i < seqA.size(); i++) {
            for(int j = seqA.get(i).start; j <= seqA.get(i).end; j++) {
                visit[j] ++;
            }
        }
        for(int i = 0; i < seqB.size(); i++) {
            for(int j = seqB.get(i).start; j <= seqB.get(i).end; j++) {
                visit[j] ++;
            }
        }
        List<Interval> ans = new ArrayList<>();
        for(int i = 0; i < 1000001; i++) {
            if(visit[i] >= 2) {
                int x = i;
                int y = i;
                while(y + 1 < 1000001 && visit[y + 1] >= 2) {
                    y++;
                }
                ans.add(new Interval(x, y));
                i = y + 1;
            }
        }
        return ans;
    }
}


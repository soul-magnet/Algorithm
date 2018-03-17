package MS.OA2017;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), 
 * find the minimum number of conference rooms required.

 For example,
 Given [[0, 30],[5, 10],[15, 20]],
 return 2.
 * Created by wtnwi on 1/13/2017.
 */
public class MeetingRoomsII {
    public class Interval {int start, end;
        Interval(int start, int end) {this.start = start;this.end = end;}
    }
    class Point {int time, status;
        Point(int time, int status) {this.time = time;this.status = status;}
    }
    public static Comparator<Point> PointComparator  = new Comparator<Point>(){
        @Override
        public int compare(Point o1, Point o2) {
            if (o1.time == o2.time) {
                // 1 start 0 end , if at same time, put end in advance then start, no conflict
                return o1.status - o2.status;
            }
            return o1.time - o2.time;
        }
    };
    public int minMeetingRooms(Interval[] intervals){
        ArrayList<Point> list = new ArrayList<>();
        for(Interval i: intervals){
            list.add(new Point(i.start, 1));
            list.add(new Point(i.end, 0));
        }
        Collections.sort(list,  PointComparator ); int ct =0, res=0;
        for(Point p : list){
            if(p.status==1){
                ct++;
            }else{
                ct--;
            }
            res = Math.max(res,ct);
        }
        return res;
    }

    public List<Interval> EmptyMeetingRooms(Interval[] intervals){
        List<Interval> res = new ArrayList<>();
        ArrayList<Point> list = new ArrayList<>();
        for(Interval i: intervals){
            list.add(new Point(i.start, 1));
            list.add(new Point(i.end, 0));
        }
        Collections.sort(list,  PointComparator ); int ct =0, start=0;
        for(Point p : list){
            if(p.status==1){
                if(ct==0&&start!=0&&start!=p.time){res.add(new Interval(start,p.time));}
                ct++;
            }else{
                ct--;
                if(ct==0){start=p.time;}
            }
        }
        return res;
    }
}

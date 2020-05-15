package amazon;

import java.util.*;

public class MeetingRooms {
    class Interval {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {

    }

    public boolean canAttendAllMeetings(Interval[] intervals) {

        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }

        });

        for(int i=1;i<intervals.length;i++){
            if(intervals[i].start < intervals[i-1].end){
                return false;
            }
        }

        return true;
    }

}
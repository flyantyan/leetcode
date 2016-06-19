package leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import leetcode.Interval;

public class M253_Meeting_Rooms_II {

	public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length == 0)
            return 0;
        
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval t1, Interval t2) {
                if(t1.start != t2.start)
                    return t1.start - t2.start;
                else
                    return t1.end - t2.end;
            }
        });
        
        int maxOverlappingMeetings = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();      // min oriented priority queue
        
        for(int i = 0; i < intervals.length; i++) {         // sweeping-line algorithms
            pq.add(intervals[i].end);
            while(pq.size() > 0 && intervals[i].start >= pq.peek())
                pq.remove();
                
            maxOverlappingMeetings = Math.max(maxOverlappingMeetings, pq.size());
        }
        
        return maxOverlappingMeetings;
    }
}

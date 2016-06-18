package leetcode.easy;

import java.util.Arrays;
import java.util.Comparator;

import leetcode.Interval;

public class E252_Meeting_Rooms {

	public boolean canAttendMeetings(Interval[] intervals) {
		if (intervals == null)
			return true;
		Arrays.sort(intervals, new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				if(o1.start != o2.start)
					return o1.start - o2.start;
				else
					return o1.end - o2.end;
			}
		});
		
		for(int i = 0 ; i < intervals.length-1 ; i++){
			if(intervals[i].end > intervals[i+1].start)
				return false ;
		}
		return true ;
	}
	//Time Limit Exceeded
	public boolean canAttendMeetings_1(Interval[] intervals) {
		if (intervals == null)
			return true;

		for (int i = 0; i < intervals.length; i++) {
			for (int j = 0; j < intervals.length; j++) {
				if (i == j)
					continue;
				int s1 = intervals[i].start;
				int e1 = intervals[i].end;
				int s2 = intervals[j].start;
				int e2 = intervals[j].end;
				if ((s1 == s2 && e1 == e2) || between(s2, s1, e1) || between(e2, s1, e1) || between(s1, s2, e2)
						|| between(e1, s2, e2))
					return false;
			}
		}
		return true;
	}

	private boolean between(int num, int nu1, int nu2) {
		return num > nu1 && num < nu2;
	}

}

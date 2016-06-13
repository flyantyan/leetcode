package leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class H57_Insert_Interval {

	public class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}

	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> result = new ArrayList<>();
		if (intervals == null){
			result.add(newInterval);
			return result;
		}

		for (int i = 0; i < intervals.size(); i++){
			Interval current = intervals.get(i);
			if (newInterval.end < current.start) {
				result.add(newInterval);
				while (i < intervals.size()) {
					result.add(intervals.get(i++));
				}
				return result;
			} else if (newInterval.start > current.end)
				result.add(intervals.get(i));
			else {
				// overlapping
				newInterval.start = Math.min(current.start, newInterval.start);
				newInterval.end = Math.max(current.end, newInterval.end);
			}
		}

		result.add(newInterval);
		return result;
	}
}

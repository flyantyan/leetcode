package leetcode.medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class M207_Course_Schedule {

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		if (prerequisites == null || prerequisites.length == 0)
			return true;
		int len = prerequisites.length;
		int[] inDegree = new int[numCourses];
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < len; i++) {
			inDegree[prerequisites[i][0]]++;
		}
		for (int i = 0; i < numCourses; i++) {
			if (inDegree[i] == 0)
				queue.offer(i);
		}

		while (!queue.isEmpty()) {
			int course = queue.poll();
			for (int i = 0; i < len; i++) {
				if (course == prerequisites[i][1]) {
					inDegree[prerequisites[i][0]]--;
					if (inDegree[prerequisites[i][0]] == 0) {
						queue.offer(prerequisites[i][0]);
					}
				}
			}
		}

		for (int i = 0; i < numCourses; i++) {
			if (inDegree[i] != 0) {
				return false;
			}
		}
		return true;
	}
}

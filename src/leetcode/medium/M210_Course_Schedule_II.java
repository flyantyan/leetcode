package leetcode.medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class M210_Course_Schedule_II {

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		// if (prerequisites == null || prerequisites.length == 0)
		// return new int[]{0};

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
		int[] result = new int[numCourses];
		Set<Integer> set = new HashSet<>();
		int j = 0;
		int count = 0;
		while (!queue.isEmpty()) {
			int course = queue.poll();
			result[count++] = course;
			for (int i = 0; i < len; i++) {
				if (course == prerequisites[i][1]) {
					inDegree[prerequisites[i][0]]--;
					if (inDegree[prerequisites[i][0]] == 0) {
						queue.offer(prerequisites[i][0]);
					}
				}
			}
		}
		if (count == numCourses)
			return result;
		return new int[] {};
	}

	public static void main(String[] args) {
		new M210_Course_Schedule_II().findOrder(2, new int[][] { { 1, 0 }, { 0, 1 } });
	}
}

package leetcode.hard;

import java.awt.Point;

public class H149_Max_Points_on_a_Line {

	public static void main(String[] args) {
		Point points[] = new Point[] { new Point(1, 1), new Point(1, 1), new Point(2, 2), new Point(2, 2) };
		new H149_Max_Points_on_a_Line().maxPoints(points);
	}

	//Note: Do by myself
	// [[0,0],[1,1],[0,0]]
	// [[2,3],[3,3],[-5,3]]
	// [[0,9],[138,429],[115,359],[115,359],[-30,-102],[230,709],[-150,-686],[-135,-613],[-60,-248],[-161,-481],[207,639],[23//,79],[-230,-691],[-115,-341],[92,289],[60,336],[-105,-467],[135,701],[-90,-394],[-184,-551],[150,774]]
	public int maxPoints(Point[] points) {
		if (points == null)
			return 0;
		if (points.length <= 2)
			return points.length;
		int result = 2, max = 0, overlap = 0;
		for (int i = 0; i < points.length; i++) {
			for (int j = i + 1; j < points.length; j++) {
				max = 1;
				int x1 = points[i].x;
				int y1 = points[i].y;
				int x2 = points[j].x;
				int y2 = points[j].y;
				if (x1 == x2 && y1 == y2) {
					overlap++;
				} else {
					max++;
					for (int m = j + 1; m < points.length; m++) {

						int x3 = points[m].x;
						int y3 = points[m].y;

						if ((x1 - x3) * (y2 - y3) - (x2 - x3) * (y1 - y3) == 0) {
							max++;
						}

					}
				}
				result = Math.max(max + overlap, result);

			}
			overlap = 0;

		}

		return result;
	}

	public class Solution {
		public int maxPoints_1(Point[] points) {
			int n = points.length;
			if (n < 2)
				return n;
			int currentL = 0, maxL = 2, x = 0, y = 0, dx = 0, dy = 0, overlap = 0, upperB = n;
			for (int i = 0; i < upperB; i++) {
				for (int j = i + 1; j < n; j++) {
					currentL = 1;
					/*
					 * Given two points: (a,b) and (c,d), the corresponding
					 * normal vector is (b-d,c-a) If another point (s,t) is in
					 * the same line uniquely defined by (a,b) and (c,d), then
					 * (s-a,t-b) dot (b-d,c-a) = 0
					 */
					x = points[i].y - points[j].y;
					y = points[j].x - points[i].x;

					/*
					 * If two points are the same, there is no need to check
					 * further, since a line has to be defined by exactly two
					 * distinct points.
					 */
					if (x == 0 && y == 0)
						overlap++;

					/*
					 * Well, it might be the case that duplicates are not
					 * consecutive, but as long as we can have a non-trivial
					 * normal vector, it won't matter.
					 */
					else {
						currentL++;

						/*
						 * Explaining (currentL+n-k>maxL): no further checking
						 * is necessary when there isn't enough left to make it
						 * surpass maxL.
						 */
						for (int k = j + 1; k < n && currentL + n - k > maxL; k++) {
							dx = points[k].x - points[i].x;
							dy = points[k].y - points[i].y;
							if (x * dx + y * dy == 0)
								currentL++;
						}
					}
					maxL = Math.max(currentL + overlap, maxL);
				}

				/*
				 * Explaining (upperB=n-maxL): it would be crystal clear as soon
				 * as you draw a table for combinations of case n>3.
				 */
				upperB = n - maxL;
				overlap = 0;
			}
			return maxL;
		}
	}
}

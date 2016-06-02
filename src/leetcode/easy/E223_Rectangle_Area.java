package leetcode.easy;

public class E223_Rectangle_Area {

	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int common = (C <= E || A >= G || B >= H || D <= F) ? 0
				: (Math.min(C, G) - Math.max(A, E)) * (Math.min(D, H) - Math.max(B, F));
		return (C - A) * (D - B) + (G - E) * (H - F) - common;
	}
}

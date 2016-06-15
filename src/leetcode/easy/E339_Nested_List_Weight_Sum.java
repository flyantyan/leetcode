package leetcode.easy;

import java.util.List;

import leetcode.NestedInteger;

public class E339_Nested_List_Weight_Sum {

	public int depthSum(List<NestedInteger> nestedList) {
		return depthSum(nestedList, 1);
	}

	public int depthSum(List<NestedInteger> nestedList, int depth) {
		if (nestedList == null)
			return 0;
		int sum = 0;
		for (NestedInteger nestedInteger : nestedList) {
			if (nestedInteger.isInteger()) {
				sum += nestedInteger.getInteger() * depth;
			} else {
				sum += depthSum(nestedInteger.getList(), depth + 1);
			}
		}

		return sum;
	}
}

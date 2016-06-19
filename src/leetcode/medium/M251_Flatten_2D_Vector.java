package leetcode.medium;

import java.util.Iterator;
import java.util.List;

public class M251_Flatten_2D_Vector  implements Iterator<Integer>{

	private Iterator<List<Integer>> nums;
	private Iterator<Integer> row;

	public M251_Flatten_2D_Vector(List<List<Integer>> vec2d) {
	        this.nums = vec2d.iterator() ;
	    }

	@Override
	public Integer next() {
		hasNext();
		return row.next();
	}

	@Override
	public boolean hasNext() {
		while ((row == null || !row.hasNext()) && nums.hasNext()) {
			row = nums.next().iterator();
		}

		return row != null && row.hasNext();
	}
}

package leetcode.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

public class M332_Reconstruct_Itinerary {

	/*
	 * The nodes which have odd degrees (int and out) are the entrance or exit.
	 * In your example it's JFK and A.
	 * 
	 * If there are no nodes have odd degrees, we could follow any path without
	 * stuck until hit the last exit node
	 * 
	 * The reason we got stuck is because that we hit the exit
	 * 
	 */
	public List<String> findItinerary(String[][] tickets) {
		LinkedList<String> ret = new LinkedList<String>();
		Map<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
		Stack<String> stack = new Stack<String>();
		for (String[] t : tickets) {
			if (!map.containsKey(t[0]))
				map.put(t[0], new PriorityQueue<String>());
			map.get(t[0]).offer(t[1]);
		}
		stack.push("JFK");
		while (!stack.isEmpty()) {
			String next = stack.peek();
			if (map.containsKey(next) && map.get(next).size() > 0)
				stack.push(map.get(next).poll());
			else
				ret.addFirst(stack.pop());
		}
		return ret;
	}
}

package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class E359_Logger_Rate_Limiter {

	private Map<String, Integer> cache;

	/** Initialize your data structure here. */
	    public E359_Logger_Rate_Limiter() {
	        cache = new HashMap<>();
	    }

	/**
	 * Returns true if the message should be printed in the given timestamp,
	 * otherwise returns false. The timestamp is in seconds granularity.
	 */
	public boolean shouldPrintMessage(int timestamp, String message) {
		if (cache.get(message) == null || timestamp - cache.get(message) >= 10) {
			cache.put(message, timestamp);
			return true;
		} else
			return false;
	}
}

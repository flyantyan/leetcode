package leetcode.hard;

import java.util.Hashtable;

public class H146_LRU_Cache {

	private Hashtable<Integer, DLinkedNode> cache = new Hashtable<Integer, DLinkedNode>();
	private int count;
	private int capacity;

	public H146_LRU_Cache(int capacity) {
		this.capacity = capacity;
		this.count = 0;
		head = new DLinkedNode();
		head.pre = null;
		tail = new DLinkedNode();
		tail.post = null;

		head.post = tail;
		tail.pre = head;
	}

	public int get(int key) {
		DLinkedNode node = cache.get(key);
		if (node == null) {
			return -1;
		} else {
			this.moveToHead(node);
			return node.value;
		}
	}

	public void set(int key, int value) {
		DLinkedNode node = cache.get(key);
		if (node == null) {
			DLinkedNode temp = new DLinkedNode();
			temp.value = value;
			temp.key = key;
			this.cache.put(key, temp);
			addNode(temp);
			count++;

			if (count > capacity) {
				this.cache.remove(this.popTail().key);
				count--;
			}

		} else {
			// update cache
			node.key = key;
			node.value = value;
			this.moveToHead(node);
		}
	}

	private DLinkedNode head;
	private DLinkedNode tail;

	public void addNode(DLinkedNode node) {
		node.pre = head;
		node.post = head.post;

		head.post.pre = node;
		head.post = node;
	}

	public void removeNode(DLinkedNode node) {
		DLinkedNode pre = node.pre;
		DLinkedNode post = node.post;
		pre.post = post;
		post.pre = pre;
	}

	private void moveToHead(DLinkedNode node) {
		removeNode(node);
		addNode(node);
	}

	private DLinkedNode popTail() {
		DLinkedNode res = tail.pre;
		removeNode(res);
		return res;
	}
}

class DLinkedNode {
	int key;
	int value;
	DLinkedNode pre;
	DLinkedNode post;

}
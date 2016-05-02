package leetcode.medium;

public class M55_Jump_Game {

	public boolean canJump(int[] nums) {
		int reachable = 0;
		for (int i = 0; i < nums.length; ++i) {
			if (i > reachable)
				return false;
			reachable = Math.max(reachable, i + nums[i]);
		}
		return true;
	}
	
	//提议理解错了
	// public boolean canJump(int[] nums) {
	// if(nums == null || nums.length == 0)
	// return false ;
	// int currentIndex = 0 ;
	// while(currentIndex < nums.length){
	// if(nums[currentIndex] == 0)
	// break;
	// currentIndex = nums[currentIndex]+currentIndex ;
	//
	// if(currentIndex == nums.length-1)
	// return true ;
	// }
	//
	// return false;
	// }

	public static void main(String[] args) {
		new M55_Jump_Game().canJump(new int[] { 2, 3, 1, 1, 4 });
	}

}

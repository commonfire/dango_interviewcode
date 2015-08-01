package dango_interviewcode_class2;

/**
 * @author zjd
 * 寻找给定整数数组中的峰值问题
 */
public class FindPeakElement {
	
	/**
	 * @param nums 给定的整数数组
	 * @param l    数组的左边界
	 * @param r    数组的右边界
	 * @return     数组的峰值元素的位置下标
	 */
	private int findPeakElement(int[]nums,int l,int r){
		int mid = (l+r)/2;
		boolean smaller_than_left = (mid!=l&&nums[mid]<nums[mid-1]);
		boolean smaller_than_right = (mid!=r&&nums[mid]<nums[mid+1]);
		if(smaller_than_left) return findPeakElement(nums, l, mid-1);  //或r = mid-1
		else if(smaller_than_right) return findPeakElement(nums, mid+1, r); //或l = mid+1
		else return mid;
	}

	/**
	 * @param nums  给定的整数数组
	 * @return      数组的峰值元素的位置下标
	 */
	private int findPeakElement(int[]nums){
		int n = nums.length;
		if(n==0) return -1;
		return findPeakElement(nums, 0, n-1);
	}
	
	public static void main(String[] args) {
		FindPeakElement test = new FindPeakElement();
		int[] nums = new int[]{1,3,2};
		System.out.println(test.findPeakElement(nums));
	}
	
}

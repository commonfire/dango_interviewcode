package dango_interviewcode_class2;

public class SortColor {
	
	/**
	 * 一个数组中只包含0,1,2三种数字，实现对其排序
	 * @param nums
	 * @return
	 */
	private int[] sortColors(int nums[]){
		int p0 = -1,p1 = -1,p2 = -1;  //排序好的数组中0,1,2的末尾位置
		for(int i = 0;i<nums.length;i++){
			if(nums[i] == 0){
				nums[++p2] = 2;
				nums[++p1] = 1;
				nums[++p0] = 0;
			}
			else if(nums[i] == 1){
				nums[++p2] = 2;
				nums[++p1] = 1;
			}
			else{
				nums[++p2] = 2;
			}
		}
		return nums;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{0,0,1,2,2,1};
		for (int num : new SortColor().sortColors(nums)){
			System.out.println(num);
		}


	}

}

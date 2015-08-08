package dango_interviewcode_class2;

public class SortColor {
	
	private void swap(int[] nums,int x,int y){
		int tmp = nums[x];
		nums[x] = nums[y];
		nums[y] = tmp;
	}
	
	/**
	 * 一个数组中只包含0,1,2三种数字，实现对其排序
	 * @param nums    待排序的数组
	 * @return  	     排好序的数组
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
	
	/**
	 * 方法二：利用快速划分思想（划分通过交换，三个‘指针’实现）
	 * @param nums   待排序的数组
	 * @return       排好序的数组
	 */
	private int[] sortColors2(int nums[]){
		int p0 = -1,p2=nums.length;
		for(int i = 0;i < p2;i++){
			if(nums[i] == 0){
				swap(nums,++p0,i);
			}
			else if(nums[i] == 2){
				swap(nums,--p2,i);
				i--;      //此i--与i++抵消，保持位置不变，在下一轮判断可能“2”交换过来“0”的情况
			}	
		}
		return nums;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{0,0,1,2,2,1};
		for (int num : new SortColor().sortColors2(nums)){
			System.out.println(num);
		}


	}

}

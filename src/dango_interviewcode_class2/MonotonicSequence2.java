package dango_interviewcode_class2;

public class MonotonicSequence2 {
	
	/**
	 * 寻找使得给定整数序列变为严格递增序列的改变幅度的最小值
	 * @param a       给定的整数序列
	 * @param start   改变幅度的遍历起始值
	 * @param end     改变幅度的遍历结束值
	 * @return        最小改变幅度
	 */
	private int minChangeRange(int[]a,int start,int end){
		int left = start,right = end;
		int ans = right; //寻找最小值，先赋最大值（起始可以随便赋值，此是意义更明确）
		while(left <= right){
			int mid = (left + right)/2;
			if(MonotonicSequence1.seqCheck(a,mid)){  
				right = mid -1;
				ans = mid;   //找到了一个可行解,从而赋新值
			}
			else{
				left = mid + 1;
			}
			
		}
		return ans;
	}
	
	public static void main(String[] args) {
		int[] a = new int[]{1,2,3,3};
		System.out.println(new MonotonicSequence2().minChangeRange(a, 0, 1000));
		
	}

}

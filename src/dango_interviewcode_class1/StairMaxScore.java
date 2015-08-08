package dango_interviewcode_class1;


public class StairMaxScore {
	

	/**
	 * 楼梯取数问题
	 * @param A  给定长度的整数数列，有正有负
	 * @return   “指针”经过的数字之和的最大值
	 */
	private int computeMaxScore(int[] A){
		int n = A.length;
		int dp[] = new int[n+3];    //dp[i]为从第i个数字出发到达终点的最大分数
		dp[n+1]=dp[n]=0;            //边界条件
		for (int i = n-1;i>=0;i--){
			dp[i] = Math.max(dp[i+2],dp[i+1])+A[i];
		}
		return dp[0];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = new int[]{1,3};
		System.out.println(new StairMaxScore().computeMaxScore(A));
	}

}

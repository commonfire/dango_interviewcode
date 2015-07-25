package dango_interviewcode_class1;

public class StairMaxScore {
	
	private int max(int a,int b){
		int max = a;
		if (b>=a) max=b;
		return max;
	}

	private int computeMaxScore(int[] A){
		int n = A.length;
		int dp[] = new int[n+3];    //dp[i]为从第i个数字出发到达终点的最大分数
		dp[n+1]=dp[n]=0;            //边界条件
		for (int i = n-1;i>=0;i--){
			dp[i] = max(dp[i+2],dp[i+1])+A[i];
		}
		return dp[0];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = new int[]{1,3};
		System.out.println(new StairMaxScore().computeMaxScore(A));
	}

}

package dango_interviewcode_class1;

/**
 * @author zjd
 * 序列修改问题
 *
 */
public class MinSeqChange {
	
	private int max(int a,int b){
		int max = a;
		if (b>=a) max=b;
		return max;
	}
	
	/**
	 * 给定一个长度的整数数列，修改尽可能少的数，使得整个数列是一个不下降序列
	 * @param A   给定一个长度的整数数列  
	 * @return    最少修改数的个数
	 */
	private int computeMinChange(int[]A){
		int dp[] = new int[A.length];
		int longest = 0;
		for (int i=0;i<A.length;i++){
			dp[i]=1;    //初始化dp[i],其中dp[i]是以第i个数结尾 的最大不下降序列长度
			for(int j=0;j<i;j++){
				if(A[j]<=A[i]){
					dp[i] = max(dp[i],dp[j]+1);
				}
			}
			longest = max(longest,dp[i]);
		}
		return A.length-longest;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = new int[]{1,1,1};
		System.out.println(new MinSeqChange().computeMinChange(A));

	}

}

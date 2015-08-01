package dango_interviewcode_class2;

/**
 * @author zjd
 * 统计区间[m,n]内0出现的次数。转化为[0,n]-[0,m-1]形式
 */
public class CountZeroOccurence {
	
	/**
	 * @param n  小于等于n的非负整数0出现的次数  
	 * @return   返回0的次数
	 */
	private int countZero(int n){
		if(n<0) return 0;
		int ans = 1,base = 1,left = n,right;
		int m = n;
		while(m>0){   //依次处理每一位，当处理到超过最高位是，返回的m为0
			int now = m%10;
			m /= 10;
			left = n/(base*10);
			right = n%base;
			if(now!=0){
				ans += left * base;
			}else{
				ans += (left-1)*base + 1*(right+1);
			}
			base *= 10;
		}
		
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new CountZeroOccurence().countZero(12));
		

	}

}

package dango_interviewcode_class2;

/**
 * @author zjd
 * 将没有7的国家的数字翻译成我们日常的数字
 */
public class NoSevenNation {
	
	/**
	 * @param x   没有7的国家的数字
	 * @return    翻译后我们的数字
	 */
	private int transNum(int x){
		int ans = 0;
		int base = 1; //九进制的底
		Integer now = 0;
		while(x>0){
			now = x%10;
			if(now == 8){
				now = 7;
			}
			if(now == 9){
				now = 8;
			}
			ans += now*base;
			x/=10;
			base *=9;
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new NoSevenNation().transNum(19));

	}

}

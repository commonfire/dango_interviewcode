package dango_interviewcode_class2;

public class MonotonicSequence1 {
	
	private static int  max(int a,int b){
		int max = a;
		if (a<=b) max = b;
		return max;
	}
	
	/**
	 * 给定一个序列，每个数改变幅度不能超过x，检查能否使序列变成严格递增
	 * @param a   给定的整数序列
	 * @param x   改变幅度x（正值）
	 * @return    返回能否得到严格递增序列判断值
	 */
	public static boolean seqCheck(int[] a,int x){
		int last = 0;  //记录前一个元素
		for(int i = 0;i<a.length;i++){
			if (i==0) last = a[i] - x;   //初次赋值last
			else{
				if(a[i]+x <= last) return false;  //能达到的最大值不大于左边值，无解
				else{
					last = max(last+1,a[i]-x);   //通过取max得到新值并更新last值:1、新值>=last+1 2、新值>=a[i]-x
				}
			}
		}
		return true;
		
	}

	public static void main(String[] args) {
		int[] a = new int[]{1,2,3,3};
		System.out.println(seqCheck(a, 3));   //静态方法通过类对象也可以调用
		// TODO Auto-generated method stub
	}

}

package dango_interviewcode_class1;

/**
 * @author zjd
 * 字符串翻转问题
 */
public class StringReverse {
	
	private void reverse(char[]c,int a, int b){
		for (int i = a;i<a+b-i;i++){
			//swap(s,a,a+b-i);
			char tmp = c[i];
			c[i] = c[a+b-i];
			c[a+b-i] = tmp;
		}	
	}
	
	/**
	 * 给定一个URL，将URL翻转同时URL的每个域保持原有顺序
	 * 如www.dango.io变成io.dango.www
	 * @param s  待翻转的字符串URL
	 * @return   返回翻转后的字符串
	 */
	private String stringReverse(String s){
		char[] a = s.toCharArray();
		reverse(a, 0, a.length-1);
		int last = 0;
		for(int i = 0;i<a.length;i++){
			if(i!=a.length-1){ //如果是结尾，则此时没有.标识符
				if(a[i] == '.'){
					reverse(a, last, i-1);
					last = i+1;
				}
			}
			else{
				reverse(a, last, i);
			}
		}
		return new String(a);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringReverse test = new StringReverse();
		System.out.println(test.stringReverse("www.dango.io"));
	}
}

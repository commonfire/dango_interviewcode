package dango_interviewcode_class1;

public class SubstringContainAllChars {
	
	private static int min(int a ,int b){
		int min = a;
		if (b<=a) min = b;
		return min;
	}
	
	
	/**
	 * 获取包含指定字符集中所有字符的最短子串
	 * @param s  指定字符集
	 * @param t  目标字符串
	 * @return   满足条件的最短子串长度
	 */
	private int computeSubstring(String s,String t){
		int counter[] = new int[26];  //纪录t中遍历的字符满足s字符集中字符的个数
		int occur = 0;  //纪录字符串t中出现字符集s的情况
		int pivot = 0;
		int result = Integer.MAX_VALUE;   //满足条件的最短子串长度
		for (int i=0;i<t.length();i++){
			while(pivot<t.length()&&occur<s.length()){
				int key = t.charAt(pivot)-'a';
				for(int j=0;j<s.length();j++){
					if(key == s.charAt(j)-'a'){
						if(counter[key]==0) occur++;
						counter[key]++;
					}
				}
				pivot++;
			}
			if (occur<s.length())break;  //t中不再包含字符集s中字符

			result = min(result,pivot-i);
			
			int key = t.charAt(i)-'a';
			for(int j=0;j<s.length();j++){
				if(key==s.charAt(j)-'a'){
					counter[key]--;
					if(counter[key]==0) occur--;
				}
			}
		}
		return result == Integer.MAX_VALUE ? -1 : result;
	}
	
	
	public static void main(String[] args) {
		System.out.println(new SubstringContainAllChars().computeSubstring("abc", "abdecbdac"));
		//new SubstringContainAllChars().computeSubstring("abc", "abdecbdac");
	    
	}

}

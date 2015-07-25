package dango_interviewcode_class1;

/**
 * @author zjd
 * 
 * 问题描述：给定n个长度不超过s且只包含小写字母的字符串
 * 求是否存在某个字符出现在所有的字符中
 */
public class OccurInAllStrings {
	
	/**
	 * @param strings 输入的字符串数字
	 * @return        是否含有共同的某个字符
	 */
	private boolean computeCommonChars(String[] strings){
		int result = 2^26-1;
		for (int i = 0;i < strings.length;i++){
			int hash = 0;    //每个字符串映射成一个hash值（整数）
			for (int j = 0; j < strings[i].length();j++){
				int key = strings[i].charAt(j)-'a';
				hash |= 1<<key;
			}
			result &= hash;
		}
		return result > 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] test = new String[]{"d","abc"};
		System.out.println(new OccurInAllStrings().computeCommonChars(test));
	}

}

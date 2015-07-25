package dango_interviewcode_class1;

public class OccurInAllStrings {
	
	private boolean computeCommonChars(String[] strings){
		int result = 2^26-1;
		for (int i = 0;i < strings.length;i++){
			int hash = 0;
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

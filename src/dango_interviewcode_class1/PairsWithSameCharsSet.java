package dango_interviewcode_class1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PairsWithSameCharsSet {
	
	/**
	 * 计算拥有相同字符集的字符串对数
	 * @param strings  字符串集合
	 * @return          满足条件的对数
	 */
	private long computePairs(ArrayList<String>strings){
		HashMap<Long, Long> number = new HashMap<Long, Long>();
		Long value = 0l;
		for (int i = 0;i < strings.size();i++){
			long hash = 0l;
			for(int j =0;j < strings.get(i).length();j++){
				int key = strings.get(i).charAt(j) - 'a';
				hash |= 1<<key;
			}
			if(!number.containsKey(hash)){
				number.put(hash, 1l);
			}else{
				value = number.get(hash);	
				number.put(hash, value+1);    //此处 value++不可以，++value可以，因为会前者会先将value值赋给map的value，然后再加。
											  //此时用+1肯定没错。且不能number.get(hash)++因为不能对常量++
			}
		}
		long result = 0;
		for(Map.Entry<Long,Long> entry :number.entrySet()){
			long times = entry.getValue();
			result += times*(times-1)/2;
		}
		return result;	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   ArrayList<String> test = new ArrayList<String>();
		   test.add("abc");
		   test.add("abcabc");
		   test.add("cababc");
           System.out.println(new PairsWithSameCharsSet().computePairs(test));
	}

}

package dango_interviewcode_class2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Range{
	int start;
	int end;
	int[] range;
	int length;
	public Range(int start,int end){    //构造Range对象时，range属性得到范围[start,end]范围的整数数组
		this.range = new int[end-start+1];
		for(int i=start,j=0;i<=end;i++,j++){
			this.range[j] = i;
		}
		this.length = end - start + 1;
	}
}

public class CoverRange {
	
	private boolean isContains(int a,ArrayList<Integer> b){
		for(int i = 0;i<b.size();i++){
			if(a==b.get(i)) return true;
		}
		return false;
	}
	
	private Integer[] findRange(ArrayList<Range> rangelist){
		ArrayList<Integer> ans = new ArrayList<Integer>();
		Collections.sort(rangelist, new Comparator<Range>() {  //按区间的结束终点排序
			@Override
			public int compare(Range o1, Range o2) {
				// TODO Auto-generated method stub
				return o1.end-o2.end;
			}
		});
		
		for (int i = 0;i < rangelist.size();i++){
			if(i == 0){
				ans.add(rangelist.get(i).range[rangelist.get(i).length-1]);  //加入第一个区间的倒数第一个元素
				ans.add(rangelist.get(i).range[rangelist.get(i).length-2]);  //加入第一个区间的倒数第二个元素
			}
			
			if(!isContains(rangelist.get(i).range[rangelist.get(i).length-1], ans)){
				ans.add(rangelist.get(i).range[rangelist.get(i).length-1]); 
			}
			if(!isContains(rangelist.get(i).range[rangelist.get(i).length-2], ans)){
				ans.add(rangelist.get(i).range[rangelist.get(i).length-2]); 
			}			
		}
	    Integer[] ans_array = ans.toArray(new Integer[0]);
		return ans_array;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Range r1 = new Range(2,5);
		Range r2 = new Range(5,6);
		Range r3 = new Range(8,9);
		ArrayList<Range> rangelist = new ArrayList<Range>();
		rangelist.add(r1);
		rangelist.add(r2);
		rangelist.add(r3);
		Integer[] test = new CoverRange().findRange(rangelist);
		for (Integer i:test){
			System.out.println(i);
		}
		

		
	}

}

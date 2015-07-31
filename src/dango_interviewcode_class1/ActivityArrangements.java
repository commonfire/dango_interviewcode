package dango_interviewcode_class1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author zjd
 * 算法与程序设计课的贪心算法---活动安排
 */
/**
 * @author zjd
 * 定义活动类型
 */
class ACT{
	int begintime;  //活动开始时间
	int endtime;    //活动结束时间
	String activityname;    //活动名称
	
	public ACT(int begintime,int endtime,String activityname){
		this.begintime = begintime;
		this.endtime = endtime;
		this.activityname = activityname;
	}
}


public class ActivityArrangements {

	private static ArrayList<ACT> arrangeActivity(ArrayList<ACT> activity){
		ArrayList<ACT> ans = new ArrayList<ACT>();
		if(activity.size()==0)return null;
		Collections.sort(activity, new Comparator<ACT>() {
			@Override
			public int compare(ACT o1, ACT o2) {
				// TODO Auto-generated method stub
				return o1.endtime-o2.endtime;
			}
		});
		
		int curtime = activity.get(0).endtime;
		ans.add(activity.get(0));
		for(int i = 1;i < activity.size();i++){
			if(curtime<=activity.get(i).begintime){
				curtime = activity.get(i).endtime;
				ans.add(activity.get(i));
			}
		}
		return ans;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ACT a1 = new ACT(1,2,"speech");
		ACT a2 = new ACT(3,5,"class");
		ACT a3 = new ACT(5,6,"sport");
		
		ArrayList<ACT> test = new ArrayList<ACT>();
		test.add(a1);
		test.add(a2);
		test.add(a3);
		for(ACT a : arrangeActivity(test)){  //注意static方法可以不用自己类的main方法中不用写类名
			System.out.println(a.activityname);
		}
	}

}

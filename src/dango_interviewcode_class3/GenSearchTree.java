package dango_interviewcode_class3;

/**
 * @author zjd
 * 计算排序二叉树的种数
 */
public class GenSearchTree {
	
	class Node{ 
		int val;          //节点value值
		Node left;
		Node right;
		public Node(int val){
			this.val = val;
			left = null;
			right = null;
	 }
	}
	
	/**
	 * 给定n，求1~n的所有可能的排序二叉树的种数
	 * @param n   给定的数n
	 * @return    返回种数
	 */
	private int numTrees(int n){
		if(n == 1) return 1;
		if(n == 2) return 2;
		int[] record = new int[n+1];  //还要保存0时的状况
		record[0] = 1;   //不是0，因为结合下面的乘法“record”分析
		record[1] = 1;
		record[2] = 2;
		for(int i = 3;i <=n;i++){
			int tmp = 0;
			for(int k = 0;k<i;k++){  //对于计算给定的数i时排序二叉树的种数，左边最少为0个，最多为i-1个
				tmp += record[k] * record[i-1-k];
			}
			record[i] = tmp;
		}
		return record[n];	
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new GenSearchTree().numTrees(3));
	}

}

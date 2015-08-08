package dango_interviewcode_class3;

import java.util.ArrayList;

/**
 * @author zjd
 * 计算排序二叉树的种数以及可能的排序二叉树
 */
public class GenSearchTree {
	
	class TreeNode{ 
		int val;          //节点value值
		TreeNode left;
		TreeNode right;
		public TreeNode(int val){
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
	
	/**
	 * 给定n，生成1~n的所有可能的排序二叉树
	 * @param n    给定的n
	 * @return     返回所有可能的排序二叉树
	 */
	private ArrayList<TreeNode> generateTrees(int n){
		return createTree(1, n);
	}
	
	private ArrayList<TreeNode> createTree(int start,int end){
		ArrayList<TreeNode> results = new ArrayList<TreeNode>();
		if(start > end){
			results.add(null);
			return results;
		}
		for(int k = start;k <= end;k++){
			ArrayList<TreeNode> left = createTree(start, k-1);
			ArrayList<TreeNode> right = createTree(k+1, end);
			for(int i=0,j=0;i<left.size()&&j<right.size();i++,j++){
				TreeNode root = new TreeNode(k);
				root.left = left.get(i);
				root.right = right.get(j);
				results.add(root);
			}
		}
		return results;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(new GenSearchTree().numTrees(3));
		//System.out.println(new GenSearchTree().generateTrees(3));
	}

}

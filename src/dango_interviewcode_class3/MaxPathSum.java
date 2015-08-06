package dango_interviewcode_class3;

import java.util.LinkedList;


public class MaxPathSum {	
	int ans;  //保存答案

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
	
	private int max(int a,int b){
		int max = a;
		if (b>=a) max=b;
		return max;
	}
	
	/**
	 * @param a   构造树的数组
	 * @return    构造的树的根
	 * 构造的树的样子如下：
	 *        0 
	 *       / \
	 *      1   2
	 *     / \
	 *    3   4
	 *   /
	 *  5
	 */
	private Node createTree(int[]a){
		LinkedList<Node> nodelist = new LinkedList<>();
		for(int i = 0;i<a.length;i++){
			nodelist.add(new Node(a[i]));
		}
		Node root = nodelist.get(0);
		root.left = nodelist.get(1);
		root.right = nodelist.get(2);
		root.left.left = nodelist.get(3);
		root.left.right = nodelist.get(4);
		root.left.left.left = nodelist.get(5);
		return root;
	}
	
	private int solve(Node root){
		if(root == null) return 0;
		int sum = root.val;
		int left = solve(root.left),right = solve(root.right);
		if(left > 0) sum += left;
		if(right > 0) sum += right;
		ans = max(ans,sum);
		return max(0,max(left,right))+root.val;   //若left，right都为负，则不继续向下走
	}
	
	private int maxPathSum(Node root){
		ans = Integer.MIN_VALUE;
		solve(root);
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[]{0,1,2,3,4,5};
		Node root = new MaxPathSum().createTree(a);
		int result = new MaxPathSum().maxPathSum(root);
		System.out.println(result);
	}

}

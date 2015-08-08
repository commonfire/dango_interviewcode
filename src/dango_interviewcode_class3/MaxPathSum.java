package dango_interviewcode_class3;

import java.util.LinkedList;


/**
 * @author zjd
 * 计算最大路径和
 */
public class MaxPathSum {	
	int ans;  //保存答案

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
	private TreeNode createTree(int[]a){
		LinkedList<TreeNode> nodelist = new LinkedList<>();
		for(int i = 0;i<a.length;i++){
			nodelist.add(new TreeNode(a[i]));
		}
		TreeNode root = nodelist.get(0);
		root.left = nodelist.get(1);
		root.right = nodelist.get(2);
		root.left.left = nodelist.get(3);
		root.left.right = nodelist.get(4);
		root.left.left.left = nodelist.get(5);
		return root;
	}
	
	/**
	 * 获取以某个“根”节点的最大“链”（可能是来自左子链或右子链）
	 * @param root   遍历的“根”节点
	 * @return       某个“根”节点的最大“链”的最大值     
	 */
	private int solve(TreeNode root){
		if(root == null) return 0;
		int sum = root.val;
		int left = solve(root.left),right = solve(root.right);
		if(left > 0) sum += left;
		if(right > 0) sum += right;
		ans = Math.max(ans,sum);
		return Math.max(0,Math.max(left,right))+root.val;   //若left，right都为负，则不继续向下走
	}
	
	private int maxPathSum(TreeNode root){
		ans = Integer.MIN_VALUE;  
		solve(root);
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[]{0,1,2,3,4,5};
		TreeNode root = new MaxPathSum().createTree(a);
		int result = new MaxPathSum().maxPathSum(root);
		System.out.println(result);
	}

}

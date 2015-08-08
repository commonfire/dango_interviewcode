package dango_interviewcode_class3;

import java.util.LinkedList;


/**
 * @author zjd
 * 判断是否为排序（搜索）二叉树（BST）
 */
public class CheckSearchTree {
	
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
	 * 判断是否为排序（搜索）二叉树
	 * @param root    待判断的树
	 * @param minv    当前树应大于的最小值
	 * @param maxv    当前树应小于的最大值
	 * @return
	 */
	private boolean checkSearchTree(TreeNode root,long minv,long maxv){
		if(root == null) return true;
		if(root.val > maxv || root.val < minv) return false;  //判断的边界条件
		if(!checkSearchTree(root.left, minv, root.val-(long)1)) return false;
		if(!checkSearchTree(root.right, root.val+1l, maxv)) return false;
		return true;
	}
	
	private boolean isSearchTree(TreeNode root){
		return checkSearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[]{0,1,2,3,4,5};
		TreeNode root = new CheckSearchTree().createTree(a);
		System.out.println(new CheckSearchTree().isSearchTree(root));
	}

}

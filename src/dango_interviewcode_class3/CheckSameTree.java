package dango_interviewcode_class3;

import java.util.LinkedList;


public class CheckSameTree {

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
	
	/**
	 * 判读两棵树是否为同一棵树，即结构相同且对应节点的值相同
	 * @param root1           树1
	 * @param root2           树2
  	 * @return         判断两棵树是否相同的结果
	 */
	private boolean checkSameTree(Node root1,Node root2){
		if(root1 == null && root2 == null) return true;
		if(root1 == null || root2 == null) return false;
		if(root1.val == root2.val){
			boolean checkleft = checkSameTree(root1.left, root2.left);
			boolean checkright = checkSameTree(root1.right, root2.right);
			return checkleft&&checkright;
		}
		else return false;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[]{0,1,2,3,4,5};
		int[] b = new int[]{0,1,6,8,4,5};
		Node root1 = new CheckSameTree().createTree(a);
		Node root2 = new CheckSameTree().createTree(b);
		System.out.println(new CheckSameTree().checkSameTree(root1, root2));
	}

}

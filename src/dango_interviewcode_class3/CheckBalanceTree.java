package dango_interviewcode_class3;

import java.util.LinkedList;


class Node{
	Node left;
	Node right;
	int num;
	public Node(int num){
		left = null;
		right = null;
		this.num = num;
	}
}


class Height{
	int height;
	public Height(){}
	public Height(int height){
		this.height = height;
	}
}


public class CheckBalanceTree {
	
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
	
	/**
	 * 判断一棵树是否为平衡二叉树
	 * @param root     树的根节点
	 * @param height   树的高度（因为需要通过高度判读是否为二叉树）
	 * @return         判断结果
	 */
	private boolean checkBalanceTree(Node root,Height h){
		if(root == null){
			h.height = 0;
			return true;
		}
		Height left_height = new Height(),right_height = new Height();
		boolean left_balance = checkBalanceTree(root.left, left_height);
		boolean right_balance = checkBalanceTree(root.right, right_height);
		h.height = max(left_height.height,right_height.height)+1;
		return left_balance&&right_balance&&(Math.abs(left_height.height-right_height.height)<=1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[]{0,1,2,3,4,5};
		Node root = new CheckBalanceTree().createTree(a);
		Height h = new Height(3);
		boolean result = new CheckBalanceTree().checkBalanceTree(root, h);
		System.out.println(result);
	}

}

package dango_interviewcode_class3;

import java.util.LinkedList;

import dango_interviewcode_class3.NearestCommonAncestor.TreeNode;

/**
 * @author zjd
 * 计算树的高度
 */
public class CalTreeHeight {
	
	class TreeNode{
		TreeNode[] children;  //某节点的孩子节点 
		int num;          //节点标号
		public TreeNode(int num){
			this.num = num;
			children = new TreeNode[]{null,null};
	 }
	}

	
	/**
	 * @param a   构造树的数组
	 * @return    构造的树的根
	 * 构造的树的样子如下：
	 *        0 
	 *       /
	 *      1
	 *     / \
	 *    2   3
	 *   /
	 *  4
	 *    
	 */
	private TreeNode createTree(int[]a){
		LinkedList<TreeNode> nodelist = new LinkedList<>();
		for(int i = 0;i<a.length;i++){
			nodelist.add(new TreeNode(a[i]));
		}
		TreeNode root = nodelist.get(0);		
		root.children[0] = nodelist.get(1);
		nodelist.get(1).children[0] = nodelist.get(2);
		nodelist.get(1).children[1] = nodelist.get(3);
		nodelist.get(2).children[0] = nodelist.get(4);
		return root;
	}
	
	private int calTreeHeight(TreeNode root){
		if(root == null) return 0;
		int ans = 1;    //最后叶子节点当作根节点时，树的高度为1
		for(int i = 0;i<root.children.length;i++){
			ans = Math.max(ans,calTreeHeight(root.children[i])+1);  //更新ans值
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] a = new int[]{0,1,2,3,4};
		TreeNode tree = new CalTreeHeight().createTree(a);
		int result = new CalTreeHeight().calTreeHeight(tree);
		System.out.println(result);
	}
}


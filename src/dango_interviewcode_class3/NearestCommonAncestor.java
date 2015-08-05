package dango_interviewcode_class3;

import java.util.LinkedList;

/**
 * @author zjd
 * 给定树上两点，求它们的最近公共祖先
 */
public class NearestCommonAncestor {
	
	/**
	 * @author zjd
	 * 定义树的节点结构
	 */
	class  Node{
		Node[] children;  //某节点的孩子节点 
		Node father;      //某节点的父节点
		int num;          //节点标号
		public Node(int num){
			this.num = num;
			father = null;
			children = new Node[]{null,null};
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
	private  Node createTree(int[]a){
		LinkedList<Node> nodelist = new LinkedList<>();
		for(int i = 0;i<a.length;i++){
			nodelist.add(new Node(a[i]));
		}
		Node root = nodelist.get(0);
		nodelist.get(1).father = root;
		nodelist.get(2).father = nodelist.get(1);
		nodelist.get(3).father = nodelist.get(1);
		nodelist.get(4).father = nodelist.get(2);
		
		root.children[0] = nodelist.get(1);
		nodelist.get(1).children[0] = nodelist.get(2);
		nodelist.get(1).children[1] = nodelist.get(3);
		nodelist.get(2).children[0] = nodelist.get(4);
		return root;
	}
	
	/**
	 * 计算树上两个点的公共祖先节点
	 * @param node1           树上节点1
	 * @param node2           树上节点2
	 * @return         最近公共祖先节点
	 */
	private static Node calComAncestor(Node node1,Node node2){
		int length1 = 0,length2 = 0;   //分别以node1和node2为起点的构成的“链表”长度(节点数)
		Node now = node1;              //node1拷贝到now
		while(now!=null){
			length1++;
			now = now.father;
		}
		now = node2;       //node2拷贝到now
		while(now!=null){
			length2++;
			now = now.father;
		}
		System.out.println(length1);
		System.out.println(length2);
		for(int i = 1;i<=length1-length2;i++){   //若length1比length2大
			node1 = node1.father;                //移动node1节点
		}
		for(int i = 1;i<=length2-length1;i++){   //若length2比length1大
			node2 = node2.father;				 //移动node2节点
		}
		while(node1!=node2){
			node1 = node1.father;
			node2 = node2.father;
		}
		return node1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[]{0,1,2,3,4};
		Node tree = new NearestCommonAncestor().createTree(a);
		Node result = calComAncestor(tree.children[0].children[0], tree.children[0].children[1]);
		System.out.println(result.num);
		
	}

}

//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题8：二叉树的下一个结点
// 题目：给定一棵二叉树和其中的一个结点，如何找出中序遍历顺序的下一个结点？
// 树中的结点除了有两个分别指向左右子结点的指针以外，还有一个指向父结点的指针。

// 思路：1、该节点有右子树的情况，下一个节点为右子树的最左子节点。
// 2、没有右子树且父节点不为空的情况：1、该节点为父节点的左节点，故下个节点为父节点
// 2、该节点为父节点的右节点，就需要往上查找，直到某节点是父节点的左节点，则该父节点为下个节点
// 注：需要自己二叉树结构，本题创建简单的二叉树结构即可。
//==================================================================
// NextNodeInBinaryTrees.java

public class NextNodeInBinaryTrees {

	// 创建一个内部类
	class TreeNode {
		int Value;
		TreeNode left;
		TreeNode right;
		TreeNode parent;
	}

//===================算法实现部分============================
	public TreeNode GetNex(TreeNode node) {
		if (node == null) {
			return null;
		}
		TreeNode nextNode = null;
		// 该节点有右子树的情况，下一个节点为右子树的最左子节点。
		if (node.right != null) {
			nextNode = node.right;
			while (nextNode.left != null) {
				nextNode = nextNode.left;
			}
		} else if (node.parent != null) { //没有右子树且父节点不为空的情况：1、该节点为父节点的左节点，故下个节点为父节点
										  //2、该节点为父节点的右节点，就需要往上查找，直到某节点是父节点的左节点，则该父节点为下个节点
			nextNode = node.parent;
			while (nextNode != null && node == nextNode.right) {
				node = node.parent;
				nextNode = node.parent;
			}
		}

		return nextNode;
	}

//===================辅助代码构建二叉树========================
	public TreeNode CreateTreeNode(int Value) {
		TreeNode node = new TreeNode();
		node.Value = Value;
		return node;
	}

	public void ConnectTreeNodes(TreeNode parent, TreeNode left, TreeNode right) {
		if (parent != null) {
			parent.left = left;
			parent.right = right;

			if (left != null) {
				left.parent = parent;
			}
			if (right != null) {
				right.parent = parent;
			}
		}
	}

//==========================测试代码====================================
	public void Test(TreeNode node, TreeNode result) {
		TreeNode next = new TreeNode();
		next = GetNex(node);
		if (next == null) {
			System.out.printf("节点%d的下一个节点为null\n", node.Value);
		} else if (next.Value == result.Value) {
			System.out.printf("节点%d的下一个节点为%d,结果正确\n", node.Value, next.Value);
		} else if (next.Value != result.Value) {
			System.out.printf("节点%d的下一个节点为%d,结果不正确\n", node.Value, next.Value);
		}
	}

//	  8
//	6      10
//	5 7    9  11
	public void Test1() {
		System.out.println("Test1的结果为：");
		TreeNode node8 = CreateTreeNode(8);
		TreeNode node6 = CreateTreeNode(6);
		TreeNode node10 = CreateTreeNode(10);
		TreeNode node5 = CreateTreeNode(5);
		TreeNode node7 = CreateTreeNode(7);
		TreeNode node9 = CreateTreeNode(9);
		TreeNode node11 = CreateTreeNode(11);

		ConnectTreeNodes(node8, node6, node10);
		ConnectTreeNodes(node6, node5, node7);
		ConnectTreeNodes(node10, node9, node11);
		Test(node8, node9);
		Test(node6, node7);
		Test(node10, node11);
		Test(node5, node6);
		Test(node7, node8);
		Test(node9, node10);
		Test(node11, null);

	}

//			  5
//			4
//		3
//	2
	public void Test2() {
		System.out.println("Test2的结果为：");
		TreeNode node5 = CreateTreeNode(5);
		TreeNode node4 = CreateTreeNode(4);
		TreeNode node3 = CreateTreeNode(3);
		TreeNode node2 = CreateTreeNode(2);

		ConnectTreeNodes(node5, node4, null);
		ConnectTreeNodes(node4, node3, null);
		ConnectTreeNodes(node3, node2, null);

		Test(node5, null);
		Test(node4, node5);
		Test(node3, node4);
		Test(node2, node3);
	}

//  2
//  	3
// 		  4
//  		  5
	public void Test3() {
		System.out.println("Test3的结果为：");
		TreeNode node2 = CreateTreeNode(2);
		TreeNode node3 = CreateTreeNode(3);
		TreeNode node4 = CreateTreeNode(4);
		TreeNode node5 = CreateTreeNode(5);

		ConnectTreeNodes(node2, null, node3);
		ConnectTreeNodes(node3, null, node4);
		ConnectTreeNodes(node4, null, node5);

		Test(node5, null);
		Test(node4, node5);
		Test(node3, node4);
		Test(node2, node3);
	}

	public void Test4() {
		System.out.println("Test4的结果为：");
		TreeNode node5 = CreateTreeNode(5);
		Test(node5, null);
	}

	public static void main(String[] args) {
		NextNodeInBinaryTrees n = new NextNodeInBinaryTrees();
		n.Test1();
		n.Test2();
		n.Test3();
		n.Test4();
	}

}

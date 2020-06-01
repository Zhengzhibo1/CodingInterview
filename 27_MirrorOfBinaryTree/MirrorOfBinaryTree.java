//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题27：二叉树的镜像
// 题目：请完成一个函数，输入一个二叉树，该函数输出它的镜像。

//==================================================================
//MirrorOfBinaryTree.java

public class MirrorOfBinaryTree {

// ===================内部类：树的结构================
	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}

	}

// ===================算法实现========================
	public void mirror(TreeNode root) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			return;
		}

		// 交换左右节点
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;

		if (root.left != null) {
			mirror(root.left);
		}
		if (root.right != null) {
			mirror(root.right);
		}

	}

// ====================测试代码====================
	public void printTreeNode(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.print(root.val + "\t");
		printTreeNode(root.left);
		printTreeNode(root.right);
	}

// 测试完全二叉树：除了叶子节点，其他节点都有两个子节点
//	            8
//	        6      10
//	       5 7    9  11
	public void test1() {
		System.out.print("=====Test1 starts:=====\n");
		TreeNode pNode8 = new TreeNode(8);
		TreeNode pNode6 = new TreeNode(6);
		TreeNode pNode10 = new TreeNode(10);
		TreeNode pNode5 = new TreeNode(5);
		TreeNode pNode7 = new TreeNode(7);
		TreeNode pNode9 = new TreeNode(9);
		TreeNode pNode11 = new TreeNode(11);

		pNode8.left = pNode6;
		pNode8.right = pNode10;
		pNode6.left = pNode5;
		pNode6.right = pNode7;
		pNode10.left = pNode9;
		pNode10.right = pNode11;

		printTreeNode(pNode8);
		System.out.println();

		System.out.print("=====Test1: MirrorRecursively=====\n");
		mirror(pNode8);
		printTreeNode(pNode8);
		System.out.println();

		System.out.print("=====Test1: MirrorIteratively=====\n");
		mirror(pNode8);
		printTreeNode(pNode8);
		System.out.println();

	}

	// 测试二叉树：出叶子结点之外，左右的结点都有且只有一个左子结点
//	            8
//	          7   
//	        6 
//	      5
//	    4
	public void test2() {
		System.out.print("=====Test2 starts:=====\n");
		TreeNode pNode8 = new TreeNode(8);
		TreeNode pNode7 = new TreeNode(7);
		TreeNode pNode6 = new TreeNode(6);
		TreeNode pNode5 = new TreeNode(5);
		TreeNode pNode4 = new TreeNode(4);

		pNode8.left = pNode7;
		pNode7.left = pNode6;
		pNode6.left = pNode5;
		pNode5.left = pNode4;

		printTreeNode(pNode8);
		System.out.println();

		System.out.print("=====Test2: MirrorRecursively=====\n");
		mirror(pNode8);
		printTreeNode(pNode8);
		System.out.println();

		System.out.print("=====Test2: MirrorRecursively=====\n");
		mirror(pNode8);
		printTreeNode(pNode8);
		System.out.println();

	}

	// 测试二叉树：出叶子结点之外，左右的结点都有且只有一个右子结点
//	            8
//	             7   
//	              6 
//	               5
//	                4
	public void test3() {
		System.out.print("=====Test3 starts:=====\n");
		TreeNode pNode8 = new TreeNode(8);
		TreeNode pNode7 = new TreeNode(7);
		TreeNode pNode6 = new TreeNode(6);
		TreeNode pNode5 = new TreeNode(5);
		TreeNode pNode4 = new TreeNode(4);

		pNode8.right = pNode7;
		pNode7.right = pNode6;
		pNode6.right = pNode5;
		pNode5.right = pNode4;

		printTreeNode(pNode8);
		System.out.println();

		System.out.print("=====Test3: MirrorRecursively=====\n");
		mirror(pNode8);
		printTreeNode(pNode8);
		System.out.println();

		System.out.print("=====Test3: MirrorRecursively=====\n");
		mirror(pNode8);
		printTreeNode(pNode8);
		System.out.println();

	}

	// 测试空二叉树：根结点为空指针
	public void test4() {
		System.out.print("=====Test4 starts:=====\n");
		TreeNode pNode = null;

		printTreeNode(pNode);
		System.out.println();

		System.out.print("=====Test4: MirrorRecursively=====\n");
		mirror(pNode);
		printTreeNode(pNode);
		System.out.println();

		System.out.print("=====Test4: MirrorRecursively=====\n");
		mirror(pNode);
		printTreeNode(pNode);
		System.out.println();

	}

	// 测试只有一个结点的二叉树
	public void test5() {
		System.out.print("=====Test5 starts:=====\n");
		TreeNode pNode8 = new TreeNode(8);

		printTreeNode(pNode8);
		System.out.println();

		System.out.print("=====Test5: MirrorRecursively=====\n");
		mirror(pNode8);
		printTreeNode(pNode8);
		System.out.println();

		System.out.print("=====Test5: MirrorIteratively=====\n");
		mirror(pNode8);
		printTreeNode(pNode8);
		System.out.println();

	}

	public static void main(String[] args) {
		MirrorOfBinaryTree m = new MirrorOfBinaryTree();
		m.test1();
		m.test2();
		m.test3();
		m.test4();
		m.test5();

	}

}

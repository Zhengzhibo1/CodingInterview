//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题36：二叉搜索树与双向链表
// 题目：输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求
// 不能创建任何新的结点，只能调整树中结点指针的指向。

//==================================================================
//ConvertBinarySearchTree.java

public class ConvertBinarySearchTree {

// ==================内部类：树的结构=================	
	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}

	}

// ====================算法实现========================
	public TreeNode Convert(TreeNode pRootOfTree) {
		TreeNode LastNodeInList = null;
		LastNodeInList = convertNode(pRootOfTree, LastNodeInList);

		TreeNode HeadOfList = LastNodeInList;
		while (HeadOfList != null && HeadOfList.left != null) {
			HeadOfList = HeadOfList.left;
		}

		return HeadOfList;
	}

	public TreeNode convertNode(TreeNode pNode, TreeNode LastNodeInList) {
		if (pNode == null) {
			return null;
		}

		TreeNode curNode = pNode;
		if (curNode.left != null) {
			LastNodeInList = convertNode(curNode.left, LastNodeInList);
		}

		curNode.left = LastNodeInList;
		if (LastNodeInList != null) {
			LastNodeInList.right = curNode;
		}
		LastNodeInList = curNode;

		if (curNode.right != null) {
			LastNodeInList = convertNode(curNode.right, LastNodeInList);
		}

		return LastNodeInList;
	}

// ====================测试代码====================
	public void printDoubleLinkedList(TreeNode pHeadOfList) {
		TreeNode pNode = pHeadOfList;

		System.out.print("The nodes from left to right are:\n");
		while (pNode != null) {
			System.out.printf("%d\t", pNode.val);

			if (pNode.right == null)
				break;
			pNode = pNode.right;
		}

		System.out.print("\nThe nodes from right to left are:\n");
		while (pNode != null) {
			System.out.printf("%d\t", pNode.val);

			if (pNode.left == null)
				break;
			pNode = pNode.left;
		}

		System.out.println();
	}

	public void test(String testName, TreeNode pRootOfTree) {
		if (testName != null)
			System.out.printf("%s begins:\n", testName);

		TreeNode pHeadOfList = Convert(pRootOfTree);

		printDoubleLinkedList(pHeadOfList);
	}

//	            10
//	         /      \
//	        6        14
//	       /\        /\
//	      4  8     12  16
	public void test1() {
		TreeNode pNode10 = new TreeNode(10);
		TreeNode pNode6 = new TreeNode(6);
		TreeNode pNode14 = new TreeNode(14);
		TreeNode pNode4 = new TreeNode(4);
		TreeNode pNode8 = new TreeNode(8);
		TreeNode pNode12 = new TreeNode(12);
		TreeNode pNode16 = new TreeNode(16);

		pNode10.left = pNode6;
		pNode10.right = pNode14;
		pNode6.left = pNode4;
		pNode6.right = pNode8;
		pNode14.left = pNode12;
		pNode14.right = pNode16;

		test("Test1", pNode10);

	}

//	               5
//	              /
//	             4
//	            /
//	           3
//	          /
//	         2
//	        /
//	       1
	public void test2() {
		TreeNode pNode5 = new TreeNode(5);
		TreeNode pNode4 = new TreeNode(4);
		TreeNode pNode3 = new TreeNode(3);
		TreeNode pNode2 = new TreeNode(2);
		TreeNode pNode1 = new TreeNode(1);

		pNode5.left = pNode4;
		pNode4.left = pNode3;
		pNode3.left = pNode2;
		pNode2.left = pNode1;

		test("Test2", pNode5);

	}

//   1
//    \
//     2
//	    \
// 	     3
//	      \
//	       4
//	        \
//	         5
	public void test3() {
		TreeNode pNode1 = new TreeNode(1);
		TreeNode pNode2 = new TreeNode(2);
		TreeNode pNode3 = new TreeNode(3);
		TreeNode pNode4 = new TreeNode(4);
		TreeNode pNode5 = new TreeNode(5);

		pNode1.right = pNode2;
		pNode2.right = pNode3;
		pNode3.right = pNode4;
		pNode4.right = pNode5;

		test("Test3", pNode1);

	}

	// 树中只有1个结点
	public void test4() {
		TreeNode pNode1 = new TreeNode(1);
		test("Test4", pNode1);

	}

	// 树中没有结点
	public void test5() {
		test("Test5", null);
	}

	public static void main(String[] args) {
		ConvertBinarySearchTree c = new ConvertBinarySearchTree();
		c.test1();
		c.test2();
		c.test3();
		c.test4();
		c.test5();

	}

}

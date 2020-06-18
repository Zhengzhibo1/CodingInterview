//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题55（二）：平衡二叉树
// 题目：输入一棵二叉树的根结点，判断该树是不是平衡二叉树。如果某二叉树中
// 任意结点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。

//==================================================================
//BalancedBinaryTree.java


public class BalancedBinaryTree {

// ====================内部类：树的结构=================
	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}

	}

// ====================算法实现====================
	private boolean isBalanced = true;

	public boolean isBalanced_Solution(TreeNode root) {
		isBalanced = true;
		getTreeDepth(root);
		return isBalanced;
	}

	public int getTreeDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int left = getTreeDepth(root.left);
		int right = getTreeDepth(root.right);

		if (Math.abs(left - right) > 1) {
			isBalanced = false;
		}

		return left > right ? (left + 1) : (right + 1);
	}

// ====================测试代码====================
	public void test(String testName, TreeNode pRoot, boolean expected) {
		if (testName != null)
			System.out.printf("%s begins: ", testName);

		if (isBalanced_Solution(pRoot) == expected)
			System.out.print("Passed.\n");
		else
			System.out.print("Failed.\n");

	}

	// 完全二叉树
//                 1
//             /      \
//            2        3
//           /\       / \
//          4  5     6   7
	public void test1() {
		TreeNode pNode1 = new TreeNode(1);
		TreeNode pNode2 = new TreeNode(2);
		TreeNode pNode3 = new TreeNode(3);
		TreeNode pNode4 = new TreeNode(4);
		TreeNode pNode5 = new TreeNode(5);
		TreeNode pNode6 = new TreeNode(6);
		TreeNode pNode7 = new TreeNode(7);

		pNode1.left = pNode2;
		pNode1.right = pNode3;
		pNode2.left = pNode4;
		pNode2.right = pNode5;
		pNode3.left = pNode6;
		pNode3.right = pNode7;

		test("Test1", pNode1, true);

	}

	// 不是完全二叉树，但是平衡二叉树
//                 1
//             /      \
//            2        3
//           /\         \
//          4  5         6
//            /
//           7
	public void test2() {
		TreeNode pNode1 = new TreeNode(1);
		TreeNode pNode2 = new TreeNode(2);
		TreeNode pNode3 = new TreeNode(3);
		TreeNode pNode4 = new TreeNode(4);
		TreeNode pNode5 = new TreeNode(5);
		TreeNode pNode6 = new TreeNode(6);
		TreeNode pNode7 = new TreeNode(7);

		pNode1.left = pNode2;
		pNode1.right = pNode3;
		pNode2.left = pNode4;
		pNode2.right = pNode5;
		pNode5.left = pNode7;
		pNode3.right = pNode6;

		test("Test2", pNode1, true);

	}

	// 不是平衡二叉树
//                 1
//             /      \
//            2        3
//           /\         
//          4  5        
//            /
//           6
	public void test3() {
		TreeNode pNode1 = new TreeNode(1);
		TreeNode pNode2 = new TreeNode(2);
		TreeNode pNode3 = new TreeNode(3);
		TreeNode pNode4 = new TreeNode(4);
		TreeNode pNode5 = new TreeNode(5);
		TreeNode pNode6 = new TreeNode(6);

		pNode1.left = pNode2;
		pNode1.right = pNode3;
		pNode2.left = pNode4;
		pNode2.right = pNode5;
		pNode5.left = pNode6;

		test("Test3", pNode1, false);

	}

//                   1
//                  /
//                 2
//                /
//               3
//              /
//             4
//            /
//           5
	public void test4() {
		TreeNode pNode1 = new TreeNode(1);
		TreeNode pNode2 = new TreeNode(2);
		TreeNode pNode3 = new TreeNode(3);
		TreeNode pNode4 = new TreeNode(4);
		TreeNode pNode5 = new TreeNode(5);

		pNode1.left = pNode2;
		pNode2.left = pNode3;
		pNode3.left = pNode4;
		pNode4.left = pNode5;

		test("Test4", pNode1, false);

	}

	// 1
	// \
	// 2
//        \
//         3
//          \
//           4
//            \
//             5
	public void test5() {
		TreeNode pNode1 = new TreeNode(1);
		TreeNode pNode2 = new TreeNode(2);
		TreeNode pNode3 = new TreeNode(3);
		TreeNode pNode4 = new TreeNode(4);
		TreeNode pNode5 = new TreeNode(5);

		pNode1.right = pNode2;
		pNode2.right = pNode3;
		pNode3.right = pNode4;
		pNode4.right = pNode5;

		test("Test5", pNode1, false);

	}

	// 树中只有1个结点
	public void test6() {
		TreeNode pNode1 = new TreeNode(1);
		test("Test6", pNode1, true);

	}

	// 树中没有结点
	public void test7() {
		test("Test7", null, true);
	}

	public static void main(String[] args) {
		BalancedBinaryTree b = new BalancedBinaryTree();
		b.test1();
		b.test2();
		b.test3();
		b.test4();
		b.test5();
		b.test6();
		b.test7();

	}

}

//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题55（一）：二叉树的深度
// 题目：输入一棵二叉树的根结点，求该树的深度。从根结点到叶结点依次经过的
// 结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。

//==================================================================
//TreeDepth.java


public class TreeDepth {
// ====================内部类：树的结构=================
	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}
	}

// ====================算法实现=========================
	public int getTreeDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int left = getTreeDepth(root.left);
		int right = getTreeDepth(root.right);

		return left > right ? (left + 1) : (right + 1);

	}

// ====================测试代码====================
	public void test(String testName, TreeNode pRoot, int expected) {
		int result = getTreeDepth(pRoot);
		if (expected == result)
			System.out.printf("%s passed.\n", testName);
		else
			System.out.printf("%s FAILED.\n", testName);
	}

//                1
//             /      \
//            2        3
//           /\         \
//          4  5         6
//            /
//           7
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
		pNode5.left = pNode7;
		pNode3.right = pNode6;

		test("Test1", pNode1, 4);

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
	public void test2() {
		TreeNode pNode1 = new TreeNode(1);
		TreeNode pNode2 = new TreeNode(2);
		TreeNode pNode3 = new TreeNode(3);
		TreeNode pNode4 = new TreeNode(4);
		TreeNode pNode5 = new TreeNode(5);

		pNode1.left = pNode2;
		pNode2.left = pNode3;
		pNode3.left = pNode4;
		pNode4.left = pNode5;

		test("Test2", pNode1, 5);

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

		test("Test3", pNode1, 5);

	}

	// 树中只有1个结点
	public void test4() {
		TreeNode pNode1 = new TreeNode(1);
		test("Test4", pNode1, 1);

	}

	// 树中没有结点
	public void test5() {
		test("Test5", null, 0);
	}

	public static void main(String[] args) {
		TreeDepth t = new TreeDepth();
		t.test1();
		t.test2();
		t.test3();
		t.test4();
		t.test5();

	}

}

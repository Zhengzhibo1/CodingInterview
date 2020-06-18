//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题54：二叉搜索树的第k个结点
// 题目：给定一棵二叉搜索树，请找出其中的第k大的结点。

//==================================================================
//KthNodeInBST.java


public class KthNodeInBST {
// ====================内部类：树的结构===================
	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}
	}

// ====================算法实现=============================
	public TreeNode kthNode(TreeNode pRoot, int k) {

		if (pRoot == null || k < 1) {
			return null;
		}

		int[] count = new int[1];
		count[0] = k;
		return kthNodeCore(pRoot, count);
	}

	public TreeNode kthNodeCore(TreeNode pRoot, int[] count) {

		TreeNode target = null;

		if (pRoot.left != null) {
			target = kthNodeCore(pRoot.left, count);
		}

		if (target == null) {
			if (count[0] == 1) {
				target = pRoot;
			}

			count[0]--;
		}

		if (target == null && pRoot.right != null) {
			target = kthNodeCore(pRoot.right, count);
		}

		return target;
	}

// ====================测试代码=====================
	public void test(String testName, TreeNode pRoot, int k, boolean isNull, int expected) {
		if (testName != null)
			System.out.printf("%s begins: ", testName);

		TreeNode target = kthNode(pRoot, k);
		if ((isNull && target == null) || (!isNull && target.val == expected))
			System.out.print("Passed.\n");
		else
			System.out.print("FAILED.\n");
	}

//                8
//            6      10
//           5 7    9  11
	public void testA() {
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

		test("TestA0", pNode8, 0, true, -1);
		test("TestA1", pNode8, 1, false, 5);
		test("TestA2", pNode8, 2, false, 6);
		test("TestA3", pNode8, 3, false, 7);
		test("TestA4", pNode8, 4, false, 8);
		test("TestA5", pNode8, 5, false, 9);
		test("TestA6", pNode8, 6, false, 10);
		test("TestA7", pNode8, 7, false, 11);
		test("TestA8", pNode8, 8, true, -1);

		System.out.println('\n');
	}

//                   5
//                  /
//                 4
//                /
//               3
//              /
//             2
//            /
//           1
	public void testB() {
		TreeNode pNode5 = new TreeNode(5);
		TreeNode pNode4 = new TreeNode(4);
		TreeNode pNode3 = new TreeNode(3);
		TreeNode pNode2 = new TreeNode(2);
		TreeNode pNode1 = new TreeNode(1);

		pNode5.left = pNode4;
		pNode4.left = pNode3;
		pNode3.left = pNode2;
		pNode2.left = pNode1;

		test("TestB0", pNode5, 0, true, -1);
		test("TestB1", pNode5, 1, false, 1);
		test("TestB2", pNode5, 2, false, 2);
		test("TestB3", pNode5, 3, false, 3);
		test("TestB4", pNode5, 4, false, 4);
		test("TestB5", pNode5, 5, false, 5);
		test("TestB6", pNode5, 6, true, -1);

		System.out.println('\n');
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
	public void testC() {
		TreeNode pNode5 = new TreeNode(5);
		TreeNode pNode4 = new TreeNode(4);
		TreeNode pNode3 = new TreeNode(3);
		TreeNode pNode2 = new TreeNode(2);
		TreeNode pNode1 = new TreeNode(1);

		pNode1.right = pNode2;
		pNode2.right = pNode3;
		pNode3.right = pNode4;
		pNode4.right = pNode5;

		test("TestC0", pNode1, 0, true, -1);
		test("TestC1", pNode1, 1, false, 1);
		test("TestC2", pNode1, 2, false, 2);
		test("TestC3", pNode1, 3, false, 3);
		test("TestC4", pNode1, 4, false, 4);
		test("TestC5", pNode1, 5, false, 5);
		test("TestC6", pNode1, 6, true, -1);

		System.out.println('\n');
	}

	// 树只有一个节点
	public void testD() {
		TreeNode pNode1 = new TreeNode(1);

		test("TestD0", pNode1, 0, true, -1);
		test("TestD1", pNode1, 1, false, 1);
		test("TestD2", pNode1, 2, true, -1);

		System.out.println('\n');
	}

	// null
	public void testE() {
		test("TestE0", null, 0, true, -1);
		test("TestE1", null, 1, true, -1);

		System.out.println('\n');
	}

	public static void main(String[] args) {
		KthNodeInBST k = new KthNodeInBST();
		k.testA();
		k.testB();
		k.testC();
		k.testD();
		k.testE();

	}

}

//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题32（二）：分行从上到下打印二叉树
// 题目：从上到下按层打印二叉树，同一层的结点按从左到右的顺序打印，每一层
// 打印到一行。

//==================================================================
//PrintTreesInLines.java

import java.util.ArrayDeque;
import java.util.Deque;

public class PrintTreesInLines {

// ====================内部类：树的结构==============
	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}

	}

// ====================算法实现=======================
	public void printTreeNode(TreeNode root) {
		if (root == null) {
			return;
		}

		Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
		queue.add(root);
		int nextPrintNodes = 0;
		int curPrintNodes = 1;
		while (!queue.isEmpty()) {
			TreeNode node = queue.pollFirst();
			System.out.print(node.val + "\t");

			if (node.left != null) {
				queue.add(node.left);
				nextPrintNodes++;
			}
			if (node.right != null) {
				queue.add(node.right);
				nextPrintNodes++;
			}
			curPrintNodes--;

			if (curPrintNodes == 0) {
				System.out.println();
				curPrintNodes = nextPrintNodes;
				nextPrintNodes = 0;
			}

		}

	}

// ====================测试代码====================
//  8
//6      10
//5 7    9  11
	public void test1() {
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

		System.out.print("====Test1 Begins: ====\n");

		printTreeNode(pNode8);
		System.out.println();

	}

	//     5
	//   4
	//  3
	// 2
	public void test2() {
		TreeNode pNode5 = new TreeNode(5);
		TreeNode pNode4 = new TreeNode(4);
		TreeNode pNode3 = new TreeNode(3);
		TreeNode pNode2 = new TreeNode(2);

		pNode5.left = pNode4;
		pNode4.left = pNode3;
		pNode3.left = pNode2;

		System.out.print("====Test2 Begins: ====\n");

		printTreeNode(pNode5);
		System.out.println();
	}

	// 5
	//   4
	//     3
	//       2
	public void test3() {
		TreeNode pNode5 = new TreeNode(5);
		TreeNode pNode4 = new TreeNode(4);
		TreeNode pNode3 = new TreeNode(3);
		TreeNode pNode2 = new TreeNode(2);

		pNode5.right = pNode4;
		pNode4.right = pNode3;
		pNode3.right = pNode2;

		System.out.print("====Test3 Begins: ====\n");

		printTreeNode(pNode5);
		System.out.println();
	}

	public void test4() {
		TreeNode pNode5 = new TreeNode(5);

		System.out.print("====Test4 Begins: ====\n");

		printTreeNode(pNode5);
		System.out.println();

	}

	public void test5() {
		System.out.print("====Test5 Begins: ====\n");
		printTreeNode(null);
		System.out.println();
	}

//    100
//   /
//  50   
//    \
//    150
	public void test6() {
		TreeNode pNode100 = new TreeNode(100);
		TreeNode pNode50 = new TreeNode(50);
		TreeNode pNode150 = new TreeNode(150);

		pNode100.left = pNode50;
		pNode50.right = pNode150;

		System.out.print("====Test6 Begins: ====\n");

		printTreeNode(pNode100);
		System.out.println();
	}

	public static void main(String[] args) {
		PrintTreesInLines p = new PrintTreesInLines();
		p.test1();
		p.test2();
		p.test3();
		p.test4();
		p.test5();
		p.test6();
	}

}

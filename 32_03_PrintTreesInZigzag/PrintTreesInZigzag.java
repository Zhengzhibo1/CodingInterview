//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题32（三）：之字形打印二叉树
// 题目：请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺
// 序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，
// 其他行以此类推。

//==================================================================
//PrintTreesInZigzag.java

import java.util.Stack;

public class PrintTreesInZigzag {

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

		Stack<TreeNode>[] levels = new Stack[2];
		levels[0] = new Stack<TreeNode>();
		levels[1] = new Stack<TreeNode>();
		int current = 0;
		int next = 1;

		levels[current].push(root);
		while (!levels[0].isEmpty() || !levels[1].isEmpty()) {
			TreeNode node = levels[current].peek();
			levels[current].pop();
			System.out.print(node.val + "\t");

			if (current == 0) {
				if (node.left != null) {
					levels[next].add(node.left);
				}
				if (node.right != null) {
					levels[next].add(node.right);
				}
			} else {
				if (node.right != null) {
					levels[next].add(node.right);
				}
				if (node.left != null) {
					levels[next].add(node.left);
				}
			}

			if (levels[current].isEmpty()) {
				System.out.println();
				current = 1 - current;
				next = 1 - next;
			}
		}
	}

// ====================测试代码====================
//      8
//  6      10
// 5 7    9  11
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

//      5
//    4
//  3
//2
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

//  5
//   4
//    3
//     2
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

//  100
//  /
// 50   
//   \
//   150
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

//          8
//  4              12
//2     6       10      14
//1  3  5  7     9 11   13  15
	public void test7() {
		TreeNode pNode8 = new TreeNode(8);
		TreeNode pNode4 = new TreeNode(4);
		TreeNode pNode12 = new TreeNode(12);
		TreeNode pNode2 = new TreeNode(2);
		TreeNode pNode6 = new TreeNode(6);
		TreeNode pNode10 = new TreeNode(10);
		TreeNode pNode14 = new TreeNode(14);
		TreeNode pNode1 = new TreeNode(1);
		TreeNode pNode3 = new TreeNode(3);
		TreeNode pNode5 = new TreeNode(5);
		TreeNode pNode7 = new TreeNode(7);
		TreeNode pNode9 = new TreeNode(9);
		TreeNode pNode11 = new TreeNode(11);
		TreeNode pNode13 = new TreeNode(13);
		TreeNode pNode15 = new TreeNode(15);

		pNode8.left = pNode4;
		pNode8.right = pNode12;
		pNode4.left = pNode2;
		pNode4.right = pNode6;
		pNode12.left = pNode10;
		pNode12.right = pNode14;
		pNode2.left = pNode1;
		pNode2.right = pNode3;
		pNode6.left = pNode5;
		pNode6.right = pNode7;
		pNode10.left = pNode9;
		pNode10.right = pNode11;
		pNode14.left = pNode13;
		pNode14.right = pNode15;

		System.out.print("====Test7 Begins: ====\n");
		printTreeNode(pNode8);
		System.out.println();

	}

	public static void main(String[] args) {
		PrintTreesInZigzag p = new PrintTreesInZigzag();
		p.test1();
		p.test2();
		p.test3();
		p.test4();
		p.test5();
		p.test6();
		p.test7();

	}

}

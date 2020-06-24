//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题68：树中两个结点的最低公共祖先
// 题目：输入两个树结点，求它们的最低公共祖先。

//==================================================================
//CommonParentInTree.java


import java.util.ArrayList;

public class CommonParentInTree {
// ====================内部类：树的结构================
	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}

	}

// ====================算法实现====================
	public boolean getNodePath(TreeNode root, TreeNode pNode, ArrayList<TreeNode> path) {

		if (root == pNode) {
			return true;
		}

		path.add(root);
		boolean found = false;
		TreeNode leftNode = root.left;
		if (!found && leftNode != null) {
			found = getNodePath(leftNode, pNode, path);
		}

		TreeNode rightNode = root.right;
		if (!found && rightNode != null) {
			found = getNodePath(rightNode, pNode, path);
		}

		if (found == false) {
			path.remove(path.size() - 1);
		}
		return found;
	}

	public TreeNode getLastCommonNode(ArrayList<TreeNode> path1, ArrayList<TreeNode> path2) {

		int index1 = 0;
		int index2 = 0;
		TreeNode lastCommonNode = null;
		while (index1 != path1.size() && index2 != path2.size()) {
			if (path1.get(index1) == path2.get(index2)) {
				lastCommonNode = path1.get(index1);
			}

			index1++;
			index2++;
		}

		return lastCommonNode;

	}

	public TreeNode getLastCommonParent(TreeNode root, TreeNode node1, TreeNode node2) {
		if (root == null || node1 == null || node2 == null) {
			return null;
		}

		ArrayList<TreeNode> path1 = new ArrayList<TreeNode>();
		ArrayList<TreeNode> path2 = new ArrayList<TreeNode>();

		getNodePath(root, node1, path1);
		getNodePath(root, node2, path2);

		TreeNode result = getLastCommonNode(path1, path2);

		return result;
	}

// ====================测试代码====================
	public void test(String testName, TreeNode pRoot, TreeNode pNode1, TreeNode pNode2, TreeNode pExpected) {
		if (testName != null)
			System.out.printf("%s begins: ", testName);

		TreeNode pResult = getLastCommonParent(pRoot, pNode1, pNode2);

		if ((pExpected == null && pResult == null)
				|| (pExpected != null && pResult != null && pResult.val == pExpected.val))
			System.out.print("Passed.\n");
		else
			System.out.print("Failed.\n");
	}

	// 形状普通的树
//	              1
//	            /   \
//	           2     3
//	         /    \
//	        4       5
//	       / \    /   \ 
//	      6   7  8     9  
	public void test1() {
		TreeNode pNode1 = new TreeNode(1);
		TreeNode pNode2 = new TreeNode(2);
		TreeNode pNode3 = new TreeNode(3);
		TreeNode pNode4 = new TreeNode(4);
		TreeNode pNode5 = new TreeNode(5);
		TreeNode pNode6 = new TreeNode(6);
		TreeNode pNode7 = new TreeNode(7);
		TreeNode pNode8 = new TreeNode(8);
		TreeNode pNode9 = new TreeNode(9);


		pNode1.left = pNode2;
		pNode1.right = pNode3;

		pNode2.left = pNode4;
		pNode2.right = pNode5;

		pNode4.left = pNode6;
		pNode4.right = pNode7;

		pNode5.left = pNode8;
		pNode5.right = pNode9;

		test("Test1", pNode1, pNode6, pNode8, pNode2);
	}

	// 树退化成一个链表
//	               1
//	              /
//	             2
//	            /
//	           3
//	          /
//	         4
//	        /
//	       5
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

		test("Test2", pNode1, pNode5, pNode4, pNode3);
	}

	// 树退化成一个链表，一个结点不在树中
//	               1
//	              /
//	             2
//	            /
//	           3
//	          /
//	         4
//	        /
//	       5
	public void test3() {
		TreeNode pNode1 = new TreeNode(1);
		TreeNode pNode2 = new TreeNode(2);
		TreeNode pNode3 = new TreeNode(3);
		TreeNode pNode4 = new TreeNode(4);
		TreeNode pNode5 = new TreeNode(5);

		pNode1.left = pNode2;
		pNode2.left = pNode3;
		pNode3.left = pNode4;
		pNode4.left = pNode5;

		TreeNode pNode6 = new TreeNode(6);

		test("Test3", pNode1, pNode5, pNode6, null);
	}

	// 输入null
	public void test4() {
		test("Test4", null, null, null, null);
	}

	public static void main(String[] args) {
		CommonParentInTree c = new CommonParentInTree();
		c.test1();
		c.test2();
		c.test3();
		c.test4();

	}

}

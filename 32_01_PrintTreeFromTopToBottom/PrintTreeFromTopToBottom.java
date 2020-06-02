//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题32（一）：不分行从上往下打印二叉树
// 题目：从上往下打印出二叉树的每个结点，同一层的结点按照从左到右的顺序打印。

//==================================================================
//PrintTreeFromTopToBottom.java

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class PrintTreeFromTopToBottom {

// ===================内部类：树的结构==============	
	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}

	}
// ===================算法实现======================
	public ArrayList<Integer> printFromTopToBottom(TreeNode root) {
		if(root == null) {
			return null;
		}
		ArrayList<Integer> result = new ArrayList<Integer>();
		Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode node = queue.pollFirst();
			result.add(node.val);
			if(node.left != null) {
				queue.add(node.left);
			}
			if(node.right != null) {
				queue.add(node.right);
			}
		}
		
		return result;
	}
	
// ====================测试代码====================
	public void printResult(ArrayList<Integer> result) {
		for(int i = 0; i < result.size(); ++i) {
			System.out.print(result.get(i) + "\t");
		}
	}
	public void test(String testName, TreeNode pRoot)
	{
	    if(testName != null)
	        System.out.printf("%s begins: \n", testName);

	    System.out.print("The nodes from top to bottom, from left to right are: \n");
	    printResult(printFromTopToBottom(pRoot));
	    System.out.print("\n\n");
	}

//	            10
//	         /      \
//	        6        14
//	       /\        /\
//	      4  8     12  16
	public void test1()
	{
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
	public void test2()
	{
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

	// 1
	//  \
	//   2
//	    \
//	     3
//	      \
//	       4
//	        \
//	         5
	public void test3()
	{
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
	public void test4()
	{
	    TreeNode pNode1 = new TreeNode(1);
	    test("Test4", pNode1);

	}

	// 树中没有结点
	public void test5()
	{
		ArrayList<Integer> result = printFromTopToBottom(null);
		if(result == null) {
			System.out.println("Test5 is NULL");
		}
		
	}
	public static void main(String[] args) {
		PrintTreeFromTopToBottom p = new PrintTreeFromTopToBottom();
		p.test1();
		p.test2();
		p.test3();
		p.test4();
		p.test5();

	}

}

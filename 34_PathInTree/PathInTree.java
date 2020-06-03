//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题34：二叉树中和为某一值的路径
// 题目：输入一棵二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所
// 有路径。从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。

//==================================================================
//PathInTree.java

import java.util.ArrayList;

public class PathInTree {

// ====================内部类：树的结构=================
	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}

	}

// ====================算法实现========================
	public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
		
		ArrayList<ArrayList<Integer>> allPath = new ArrayList<ArrayList<Integer>>();
		if (root == null) {
			return allPath;
		}
		
		int currentSum = 0;
		ArrayList<Integer> path = new ArrayList<Integer>();
		findpath(root, target, allPath, currentSum, path);
		return allPath;
	}

	public void findpath(TreeNode root, int target, ArrayList<ArrayList<Integer>> allPath, int currentSum,
			ArrayList<Integer> path) {
		currentSum += root.val;
		path.add(root.val);
		boolean leaf = root.left == null && root.right == null;
		if (currentSum == target && leaf) {
			allPath.add(new ArrayList<Integer>(path));
		}

		if (root.left != null) {
			findpath(root.left, target, allPath, currentSum, path);
		}
		if (root.right != null) {
			findpath(root.right, target, allPath, currentSum, path);
		}

		path.remove(path.size() - 1);

	}

// ====================测试代码====================
	public void printPath(ArrayList<ArrayList<Integer>> allPath) {
		for(ArrayList<Integer> path : allPath) {
			for(int i : path) {
				System.out.print(i + "\t");
			}
			System.out.println();
		}
		
	}
	
//       10
//    /      \
//   5        12
//  /\        
// 4  7     
//有两条路径上的结点和为22
	public void test1()
	{
	    TreeNode pNode10 = new TreeNode(10);
	    TreeNode pNode5 = new TreeNode(5);
	    TreeNode pNode12 = new TreeNode(12);
	    TreeNode pNode4 = new TreeNode(4);
	    TreeNode pNode7 = new TreeNode(7);

	    pNode10.left = pNode5;
	    pNode10.right = pNode12;
	    pNode5.left = pNode4;
	    pNode5.right = pNode7;

	    System.out.print("Test1: \n");
	    printPath(findPath(pNode10, 22));

	}

//	            10
//	         /      \
//	        5        12
//	       /\        
//	      4  7     
	// 没有路径上的结点和为15
	public void test2()
	{
	    TreeNode pNode10 = new TreeNode(10);
	    TreeNode pNode5 = new TreeNode(5);
	    TreeNode pNode12 = new TreeNode(12);
	    TreeNode pNode4 = new TreeNode(4);
	    TreeNode pNode7 = new TreeNode(7);

	    pNode10.left = pNode5;
	    pNode10.right = pNode12;
	    pNode5.left = pNode4;
	    pNode5.right = pNode7;

	    System.out.print("Test2: \n");
	    printPath(findPath(pNode10, 15));

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
	// 有一条路径上面的结点和为15
	public void test3()
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


	    System.out.print("Test3: \n");
	    printPath(findPath(pNode5, 15));
	    
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
	// 没有路径上面的结点和为16
	public void test4()
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


	    System.out.print("Test4: \n");
	    printPath(findPath(pNode1, 16));
	    
	}

	// 树中只有1个结点
	public void test5()
	{
	    TreeNode pNode1 = new TreeNode(1);

	    System.out.print("Test5: \n");
	    printPath(findPath(pNode1, 1));
	    
	}

	// 树中没有结点
	public void test6()
	{
	    System.out.print("Test6: \n");
	    printPath(findPath(null, 0));
	}
	public static void main(String[] args) {
		PathInTree p = new PathInTree();
		p.test1();
		p.test2();
		p.test3();
		p.test4();
		p.test5();
		p.test6();

	}

}

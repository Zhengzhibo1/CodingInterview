//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题26：树的子结构
// 题目：输入两棵二叉树A和B，判断B是不是A的子结构。

//==================================================================
//SubstructureInTree.java

public class SubstructureInTree {

// ==================内部类：树的结构===============
	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}

	}

// ==================算法实现=======================
	// 两步：判断B树是否属于A的子树
	// 1、从A树中找到与B树根节点值相等的节点
	// 2、判断A的子树与B树是否相等
	
	public boolean hasSubtree(TreeNode root1,TreeNode root2) {
		boolean result = false;
		
		if(root1 != null && root2 != null) {
			if(root1.val == root2.val) {
				result = doesTree1HavaTree2(root1, root2);
			}
			if(!result) {
				result = hasSubtree(root1.left, root2);
			}
			if(!result) {
				result = hasSubtree(root1.right, root2);
			}
		}		
		
		return result;
	}
	
	public boolean doesTree1HavaTree2(TreeNode root1,TreeNode root2) {
		
		if(root2 == null) {
			return true;
		}
		if(root1 == null) {
			return false;
		}
		
		if(root1.val != root2.val) {
			return false;
		}
		
		return doesTree1HavaTree2(root1.left, root2.left) && doesTree1HavaTree2(root1.right, root2.right);
	}

// ====================测试代码====================
	public void test(String testName, TreeNode pRoot1, TreeNode pRoot2, boolean expected)
	{
	    if(hasSubtree(pRoot1, pRoot2) == expected)
	        System.out.printf("%s passed.\n", testName);
	    else
	    	System.out.printf("%s failed.\n", testName);
	}

	// 树中结点含有分叉，树B是树A的子结构
//	                  8                8
//	              /       \           / \
//	             8         7         9   2
//	           /   \
//	          9     2
//	               / \
//	              4   7
	public void test1()
	{
		TreeNode pNodeA1 = new TreeNode(8);
		TreeNode pNodeA2 = new TreeNode(8);
		TreeNode pNodeA3 = new TreeNode(7);
		TreeNode pNodeA4 = new TreeNode(9);
		TreeNode pNodeA5 = new TreeNode(2);
		TreeNode pNodeA6 = new TreeNode(4);
		TreeNode pNodeA7 = new TreeNode(7);

		pNodeA1.left = pNodeA2;
		pNodeA1.right = pNodeA3;
		pNodeA2.left = pNodeA4;
		pNodeA2.right = pNodeA5;
		pNodeA5.left = pNodeA6;
		pNodeA5.right = pNodeA7;
		


		TreeNode pNodeB1 = new TreeNode(8);
		TreeNode pNodeB2 = new TreeNode(9);
		TreeNode pNodeB3 = new TreeNode(2);

		pNodeB1.left = pNodeB2;
		pNodeB1.right = pNodeB3;


	    test("Test1", pNodeA1, pNodeB1, true);

	}

	// 树中结点含有分叉，树B不是树A的子结构
//	                  8                8
//	              /       \           / \
//	             8         7         9   2
//	           /   \
//	          9     3
//	               / \
//	              4   7
	void test2()
	{
		TreeNode pNodeA1 = new TreeNode(8);
		TreeNode pNodeA2 = new TreeNode(8);
		TreeNode pNodeA3 = new TreeNode(7);
		TreeNode pNodeA4 = new TreeNode(9);
		TreeNode pNodeA5 = new TreeNode(3);
		TreeNode pNodeA6 = new TreeNode(4);
		TreeNode pNodeA7 = new TreeNode(7);

		pNodeA1.left = pNodeA2;
		pNodeA1.right = pNodeA3;
		pNodeA2.left = pNodeA4;
		pNodeA2.right = pNodeA5;
		pNodeA5.left = pNodeA6;
		pNodeA5.right = pNodeA7;

		TreeNode pNodeB1 = new TreeNode(8);
		TreeNode pNodeB2 = new TreeNode(9);
		TreeNode pNodeB3 = new TreeNode(2);

		pNodeB1.left = pNodeB2;
		pNodeB1.right = pNodeB3;

	    test("Test2", pNodeA1, pNodeB1, false);

	}

	// 树中结点只有左子结点，树B是树A的子结构
//	                8                  8
//	              /                   / 
//	             8                   9   
//	           /                    /
//	          9                    2
//	         /      
//	        2        
//	       /
//	      5
	void test3()
	{
		TreeNode pNodeA1 = new TreeNode(8);
		TreeNode pNodeA2 = new TreeNode(8);
		TreeNode pNodeA3 = new TreeNode(9);
		TreeNode pNodeA4 = new TreeNode(2);
		TreeNode pNodeA5 = new TreeNode(5);
		
		pNodeA1.left = pNodeA2;
		pNodeA2.left = pNodeA3;
		pNodeA3.left = pNodeA4;
		pNodeA4.left = pNodeA5;

		TreeNode pNodeB1 = new TreeNode(8);
		TreeNode pNodeB2 = new TreeNode(9);
		TreeNode pNodeB3 = new TreeNode(2);

		pNodeB1.left = pNodeB2;
		pNodeB2.left = pNodeB3;


	    test("Test3", pNodeA1, pNodeB1, true);

	}

	// 树中结点只有左子结点，树B不是树A的子结构
//	                8                  8
//	              /                   / 
//	             8                   9   
//	           /                    /
//	          9                    3
//	         /      
//	        2        
//	       /
//	      5
	void test4()
	{
		TreeNode pNodeA1 = new TreeNode(8);
		TreeNode pNodeA2 = new TreeNode(8);
		TreeNode pNodeA3 = new TreeNode(9);
		TreeNode pNodeA4 = new TreeNode(2);
		TreeNode pNodeA5 = new TreeNode(5);
		
		pNodeA1.left = pNodeA2;
		pNodeA2.left = pNodeA3;
		pNodeA3.left = pNodeA4;
		pNodeA4.left = pNodeA5;

		TreeNode pNodeB1 = new TreeNode(8);
		TreeNode pNodeB2 = new TreeNode(9);
		TreeNode pNodeB3 = new TreeNode(3);

		pNodeB1.left = pNodeB2;
		pNodeB2.left = pNodeB3;

	    test("Test4", pNodeA1, pNodeB1, false);

	}

	// 树中结点只有右子结点，树B是树A的子结构
//	       8                   8
//	        \                   \ 
//	         8                   9   
//	          \                   \
//	           9                   2
//	            \      
//	             2        
//	              \
//	               5
	void test5()
	{
		TreeNode pNodeA1 = new TreeNode(8);
		TreeNode pNodeA2 = new TreeNode(8);
		TreeNode pNodeA3 = new TreeNode(9);
		TreeNode pNodeA4 = new TreeNode(2);
		TreeNode pNodeA5 = new TreeNode(5);

		pNodeA1.right = pNodeA2;
		pNodeA2.right = pNodeA3;
		pNodeA3.right = pNodeA4;
		pNodeA4.right = pNodeA5;

		
		TreeNode pNodeB1 = new TreeNode(8);
		TreeNode pNodeB2 = new TreeNode(9);
		TreeNode pNodeB3 = new TreeNode(2);

		pNodeB1.right = pNodeB2;
		pNodeB2.right = pNodeB3;
		

	    test("Test5", pNodeA1, pNodeB1, true);

	}

	// 树A中结点只有右子结点，树B不是树A的子结构
//	       8                   8
//	        \                   \ 
//	         8                   9   
//	          \                 / \
//	           9               3   2
//	            \      
//	             2        
//	              \
//	               5
	void test6()
	{
		TreeNode pNodeA1 = new TreeNode(8);
		TreeNode pNodeA2 = new TreeNode(8);
		TreeNode pNodeA3 = new TreeNode(9);
		TreeNode pNodeA4 = new TreeNode(2);
		TreeNode pNodeA5 = new TreeNode(5);

		pNodeA1.right = pNodeA2;
		pNodeA2.right = pNodeA3;
		pNodeA3.right = pNodeA4;
		pNodeA4.right = pNodeA5;

		
		TreeNode pNodeB1 = new TreeNode(8);
		TreeNode pNodeB2 = new TreeNode(9);
		TreeNode pNodeB3 = new TreeNode(3);
		TreeNode pNodeB4 = new TreeNode(2);

		pNodeB1.right = pNodeB2;
		pNodeB2.right = pNodeB4;
		pNodeB2.left = pNodeB3;
		

	    test("Test6", pNodeA1, pNodeB1, false);

	}

	// 树A为空树
	void test7()
	{
		TreeNode pNodeB1 = new TreeNode(8);
		TreeNode pNodeB2 = new TreeNode(9);
		TreeNode pNodeB3 = new TreeNode(3);
		TreeNode pNodeB4 = new TreeNode(2);

		pNodeB1.right = pNodeB2;
		pNodeB2.right = pNodeB4;
		pNodeB2.left = pNodeB3;

	    test("Test7", null, pNodeB1, false);

	}

	// 树B为空树
	void test8()
	{
		TreeNode pNodeA1 = new TreeNode(8);
		TreeNode pNodeA2 = new TreeNode(9);
		TreeNode pNodeA3 = new TreeNode(3);
		TreeNode pNodeA4 = new TreeNode(2);

		pNodeA1.right = pNodeA2;
		pNodeA2.right = pNodeA4;
		pNodeA2.left = pNodeA3;
	    test("Test8", pNodeA1, null, false);

	}

	// 树A和树B都为空
	void test9()
	{
	    test("Test9", null, null, false);
	}
	public static void main(String[] args) {
		SubstructureInTree s = new SubstructureInTree();
		s.test1();
		s.test2();
		s.test3();
		s.test4();
		s.test5();
		s.test6();
		s.test7();
		s.test8();
		s.test9();

	}

}

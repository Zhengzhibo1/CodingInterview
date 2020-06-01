//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题28：对称的二叉树
// 题目：请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和
// 它的镜像一样，那么它是对称的。

//==================================================================
//SymmetricalBinaryTree.java

public class SymmetricalBinaryTree {

// ===================内部类：树的结构===============
	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}

	}
// ===================算法实现=======================
	public boolean isSymmetrical(TreeNode pRoot){
		return isSymmetrical(pRoot, pRoot);
    }
	
	public boolean isSymmetrical(TreeNode pRoot1, TreeNode pRoot2) {
		if(pRoot1 == null && pRoot2 == null) {
			return true;
		}
		if(pRoot1 == null || pRoot2 ==null) {
			return false;
		}	
		if(pRoot1.val != pRoot2.val) {
			return false;
		}
		
		return  isSymmetrical(pRoot1.left, pRoot2.right) && isSymmetrical(pRoot1.right, pRoot2.left);
	}

// ===================测试代码======================
	
	public void test(String testName, TreeNode pRoot, boolean expected)
	{
	    if(testName != null)
	        System.out.printf("%s begins: ", testName);

	    if(isSymmetrical(pRoot) == expected)
	    	System.out.print("Passed.\n");
	    else
	    	System.out.print("FAILED.\n");
	}

//	            8
//	        6      6
//	       5 7    7 5
	public void test1()
	{
	    TreeNode pNode8 = new TreeNode(8);
	    TreeNode pNode61 = new TreeNode(6);
	    TreeNode pNode62 = new TreeNode(6);
	    TreeNode pNode51 = new TreeNode(5);
	    TreeNode pNode71 = new TreeNode(7);
	    TreeNode pNode72 = new TreeNode(7);
	    TreeNode pNode52 = new TreeNode(5);

	    pNode8.left = pNode61;
	    pNode8.right = pNode62;
	    pNode61.left = pNode51;
	    pNode61.right = pNode71;
	    pNode62.left = pNode72;
	    pNode62.right = pNode52;
	    
	    test("Test1", pNode8, true);

	}

//	            8
//	        6      9
//	       5 7    7 5
	public void test2()
	{
	    TreeNode pNode8 = new TreeNode(8);
	    TreeNode pNode61 = new TreeNode(6);
	    TreeNode pNode62 = new TreeNode(9);
	    TreeNode pNode51 = new TreeNode(5);
	    TreeNode pNode71 = new TreeNode(7);
	    TreeNode pNode72 = new TreeNode(7);
	    TreeNode pNode52 = new TreeNode(5);

	    pNode8.left = pNode61;
	    pNode8.right = pNode62;
	    pNode61.left = pNode51;
	    pNode61.right = pNode71;
	    pNode62.left = pNode72;
	    pNode62.right = pNode52;

	    test("Test2", pNode8, false);


	}

//	            8
//	        6      6
//	       5 7    7
	public void test3()
	{
		TreeNode pNode8 = new TreeNode(8);
	    TreeNode pNode61 = new TreeNode(6);
	    TreeNode pNode62 = new TreeNode(6);
	    TreeNode pNode51 = new TreeNode(5);
	    TreeNode pNode71 = new TreeNode(7);
	    TreeNode pNode72 = new TreeNode(7);


	    pNode8.left = pNode61;
	    pNode8.right = pNode62;
	    pNode61.left = pNode51;
	    pNode61.right = pNode71;
	    pNode62.left = pNode72;

	    test("Test3", pNode8, false);

	}

//	               5
//	              / \
//	             3   3
//	            /     \
//	           4       4
//	          /         \
//	         2           2
//	        /             \
//	       1               1
	public void test4()
	{
	    TreeNode pNode5 = new TreeNode(5);
	    TreeNode pNode31 = new TreeNode(3);
	    TreeNode pNode32 = new TreeNode(3);
	    TreeNode pNode41 = new TreeNode(4);
	    TreeNode pNode42 = new TreeNode(4);
	    TreeNode pNode21 = new TreeNode(2);
	    TreeNode pNode22 = new TreeNode(2);
	    TreeNode pNode11 = new TreeNode(1);
	    TreeNode pNode12 = new TreeNode(1);

	    pNode5.left = pNode31;
	    pNode5.right = pNode32;	    
	    pNode31.left = pNode41;    
	    pNode32.right = pNode42;	    
	    pNode41.left = pNode21;
	    pNode42.right = pNode22;	    
	    pNode21.left = pNode11;
	    pNode22.right = pNode12;

	    test("Test4", pNode5, true);

	}


//	               5
//	              / \
//	             3   3
//	            /     \
//	           4       4
//	          /         \
//	         6           2
//	        /             \
//	       1               1
	public void test5()
	{
		TreeNode pNode5 = new TreeNode(5);
	    TreeNode pNode31 = new TreeNode(3);
	    TreeNode pNode32 = new TreeNode(3);
	    TreeNode pNode41 = new TreeNode(4);
	    TreeNode pNode42 = new TreeNode(4);
	    TreeNode pNode21 = new TreeNode(6);
	    TreeNode pNode22 = new TreeNode(2);
	    TreeNode pNode11 = new TreeNode(1);
	    TreeNode pNode12 = new TreeNode(1);

	    pNode5.left = pNode31;
	    pNode5.right = pNode32;	    
	    pNode31.left = pNode41;    
	    pNode32.right = pNode42;	    
	    pNode41.left = pNode21;
	    pNode42.right = pNode22;	    
	    pNode21.left = pNode11;
	    pNode22.right = pNode12;

	    test("Test5", pNode5, false);

	}

//	               5
//	              / \
//	             3   3
//	            /     \
//	           4       4
//	          /         \
//	         2           2
//	                      \
//	                       1
	public void test6()
	{
		TreeNode pNode5 = new TreeNode(5);
	    TreeNode pNode31 = new TreeNode(3);
	    TreeNode pNode32 = new TreeNode(3);
	    TreeNode pNode41 = new TreeNode(4);
	    TreeNode pNode42 = new TreeNode(4);
	    TreeNode pNode21 = new TreeNode(2);
	    TreeNode pNode22 = new TreeNode(2);

	    TreeNode pNode12 = new TreeNode(1);

	    pNode5.left = pNode31;
	    pNode5.right = pNode32;	    
	    pNode31.left = pNode41;    
	    pNode32.right = pNode42;	    
	    pNode41.left = pNode21;
	    pNode42.right = pNode22;	    

	    pNode22.right = pNode12;

	    test("Test6", pNode5, false);

	}

	// 只有一个结点
	public void test7()
	{
	    TreeNode pNode1 = new TreeNode(1);
	    test("Test7", pNode1, true);

	}

	// 没有结点
	public void test8()
	{
	    test("Test8", null, true);
	}

	// 所有结点都有相同的值，树对称
//	               5
//	              / \
//	             5   5
//	            /     \
//	           5       5
//	          /         \
//	         5           5
	public void test9()
	{
	    TreeNode pNode1 = new TreeNode(5);
	    TreeNode pNode21 = new TreeNode(5);
	    TreeNode pNode22 = new TreeNode(5);
	    TreeNode pNode31 = new TreeNode(5);
	    TreeNode pNode32 = new TreeNode(5);
	    TreeNode pNode41 = new TreeNode(5);
	    TreeNode pNode42 = new TreeNode(5);

	    pNode1.left = pNode21;
	    pNode1.right = pNode22;
	    pNode21.left = pNode31;
	    pNode22.right = pNode32;
	    pNode31.left = pNode41;
	    pNode32.right = pNode42;
	   
	    test("Test9", pNode1, true);

	}

	// 所有结点都有相同的值，树不对称
//	               5
//	              / \
//	             5   5
//	            /     \
//	           5       5
//	          /       /
//	         5       5
	public void test10()
	{
		TreeNode pNode1 = new TreeNode(5);
	    TreeNode pNode21 = new TreeNode(5);
	    TreeNode pNode22 = new TreeNode(5);
	    TreeNode pNode31 = new TreeNode(5);
	    TreeNode pNode32 = new TreeNode(5);
	    TreeNode pNode41 = new TreeNode(5);
	    TreeNode pNode42 = new TreeNode(5);

	    pNode1.left = pNode21;
	    pNode1.right = pNode22;
	    pNode21.left = pNode31;
	    pNode22.right = pNode32;
	    pNode31.left = pNode41;
	    pNode32.left = pNode42;

	    test("Test10", pNode1, false);

	}
	public static void main(String[] args) {
		SymmetricalBinaryTree s = new SymmetricalBinaryTree();
		s.test1();
		s.test2();
		s.test3();
		s.test4();
		s.test5();
		s.test6();
		s.test7();
		s.test8();
		s.test9();
		s.test10();
		
	}

}

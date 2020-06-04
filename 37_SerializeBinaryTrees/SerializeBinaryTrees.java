//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题37：序列化二叉树
// 题目：请实现两个函数，分别用来序列化和反序列化二叉树。

//==================================================================
//SerializeBinaryTrees.java

public class SerializeBinaryTrees {

// ===================内部类：树的结构==================
	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}

	}

// ===================算法实现==========================
	// 序列化
	public String serialize(TreeNode root) {
		StringBuffer result = new StringBuffer();
		if (root == null) {
			result.append("$").append(',');
			return result.toString();
		}

		result.append(root.val).append(',');
		result.append(serialize(root.left));
		result.append(serialize(root.right));

		return result.toString();
	}

	// 反序列化
	public TreeNode deserialize(String str) {
		if (str.length() == 0) {
			return null;
		}
		String[] strs = str.split(",");

		// 用数组里的元素作为索引，在函数传递的过程中可以改变其值
		int[] index = new int[1];
		index[0] = -1;
		TreeNode root = deserializeCore(strs, index);

		return root;
	}

	public TreeNode deserializeCore(String[] strs, int[] index) {

		index[0]++;
		if (!strs[index[0]].equals("$")) {
			int number = Integer.parseInt(strs[index[0]]);
			TreeNode root = new TreeNode(number);
			root.left = deserializeCore(strs, index);
			root.right = deserializeCore(strs, index);
			return root;
		}

		return null;
	}

// ===================测试代码==========================

	public boolean isSameTree(TreeNode pRoot1, TreeNode pRoot2) {
		if (pRoot1 == null && pRoot2 == null)
			return true;

		if (pRoot1 == null || pRoot2 == null)
			return false;

		if (pRoot1.val != pRoot2.val)
			return false;

		return isSameTree(pRoot1.left, pRoot2.left) && isSameTree(pRoot1.right, pRoot2.right);
	}

	public void test(String testName, TreeNode pRoot) {
		if (testName != null)
			System.out.printf("%s begins: \n", testName);

		String result = serialize(pRoot);
		System.out.println(result);

		TreeNode pNewRoot = deserialize(result);

		if (isSameTree(pRoot, pNewRoot))
			System.out.print("The deserialized tree is same as the oritinal tree.\n\n");
		else
			System.out.print("The deserialized tree is NOT same as the oritinal tree.\n\n");

	}

//	            8
//	        6      10
//	       5 7    9  11
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

		test("Test1", pNode8);

	}

//	            5
//	          4
//	        3
//	      2
	public void test2() {
		TreeNode pNode5 = new TreeNode(5);
		TreeNode pNode4 = new TreeNode(4);
		TreeNode pNode3 = new TreeNode(3);
		TreeNode pNode2 = new TreeNode(2);

		pNode5.left = pNode4;
		pNode4.left = pNode3;
		pNode3.left = pNode2;

		test("Test2", pNode5);

	}

//	        5
//	         4
//	          3
//	           2
	public void test3() {
		TreeNode pNode5 = new TreeNode(5);
		TreeNode pNode4 = new TreeNode(4);
		TreeNode pNode3 = new TreeNode(3);
		TreeNode pNode2 = new TreeNode(2);

		pNode5.right = pNode4;
		pNode4.right = pNode3;
		pNode3.right = pNode2;

		test("Test3", pNode5);

	}

	public void test4() {
		TreeNode pNode5 = new TreeNode(5);

		test("Test4", pNode5);

	}

	public void test5() {
		test("Test5", null);
	}

//	        5
//	         5
//	          5
//	         5
//	        5
//	       5 5
//	      5   5
	public void test6() {
		TreeNode pNode1 = new TreeNode(5);
		TreeNode pNode2 = new TreeNode(5);
		TreeNode pNode3 = new TreeNode(5);
		TreeNode pNode4 = new TreeNode(5);
		TreeNode pNode5 = new TreeNode(5);
		TreeNode pNode61 = new TreeNode(5);
		TreeNode pNode62 = new TreeNode(5);
		TreeNode pNode71 = new TreeNode(5);
		TreeNode pNode72 = new TreeNode(5);

		pNode1.right = pNode2;
		pNode2.right = pNode3;
		pNode3.left = pNode4;
		pNode4.left = pNode5;
		pNode5.left = pNode61;
		pNode5.right = pNode62;
		pNode61.left = pNode71;
		pNode62.right = pNode72;

		test("Test6", pNode1);

	}

	public static void main(String[] args) {
		SerializeBinaryTrees s = new SerializeBinaryTrees();
		s.test1();
		s.test2();
		s.test3();
		s.test4();
		s.test5();
		s.test6();

	}

}

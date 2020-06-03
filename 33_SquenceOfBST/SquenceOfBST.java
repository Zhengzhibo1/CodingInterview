//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题33：二叉搜索树的后序遍历序列
// 题目：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
// 如果是则返回true，否则返回false。假设输入的数组的任意两个数字都互不相同。

//==================================================================
//SquenceOfBST.java

public class SquenceOfBST {

// ====================算法实现==================
	public boolean verifySquenceOfBST(int[] sequence) {
		if (sequence == null || sequence.length <= 0) {
			return false;
		}

		return verifySquenceOfBST(sequence, sequence.length);
	}

	public boolean verifySquenceOfBST(int[] sequence, int length) {
		int root = sequence[length - 1];
		// 二叉树中，左子树节点值小于根节点
		int i = 0;
		for (; i < length - 1; ++i) {
			if (sequence[i] > root) {
				break;
			}
		}

		// 二叉树中，右子树节点值小于跟节点值
		int j = i;
		for (; j < length - 1; ++j) {
			if (sequence[j] < root) {
				return false;
			}
		}

		// 判断左子树是否成立
		boolean left = true;
		if (i > 0) {
			left = verifySquenceOfBST(sequence, i);
		}

		// 判断右子树是否成立
		boolean right = true;
		if (i < length - 1) {
			right = verifySquenceOfBST(sequence, length - i - 1);
		}
		return left && right;
	}

// ====================测试代码====================
	public void test(String testName, int sequence[], int length, boolean expected) {
		if (testName != null)
			System.out.printf("%s begins: ", testName);

		if (verifySquenceOfBST(sequence) == expected)
			System.out.print("passed.\n");
		else
			System.out.print("failed.\n");
	}

//                10
//             /      \
//            6        14
//           /\        /\
//          4  8     12  16
	public void test1() {
		int data[] = { 4, 8, 6, 12, 16, 14, 10 };
		test("Test1", data, data.length, true);
	}

//               5
//              / \
//             4   7
//                /
//               6
	public void test2() {
		int data[] = { 4, 6, 7, 5 };
		test("Test2", data, data.length, true);
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
	public void test3() {
		int data[] = { 1, 2, 3, 4, 5 };
		test("Test3", data, data.length, true);
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
	public void test4() {
		int data[] = { 5, 4, 3, 2, 1 };
		test("Test4", data, data.length, true);
	}

	// 树中只有1个结点
	public void test5() {
		int data[] = { 5 };
		test("Test5", data, data.length, true);
	}

	public void test6() {
		int data[] = { 7, 4, 6, 5 };
		test("Test6", data, data.length, false);
	}

	public void test7() {
		int data[] = { 4, 6, 12, 8, 16, 14, 10 };
		test("Test7", data, data.length, false);
	}

	public void test8() {
		test("Test8", null, 0, false);
	}
	
	public void test9() {
		int data[] = {};
		test("Test9",data, data.length, false);
	}

	public static void main(String[] args) {
		SquenceOfBST s = new SquenceOfBST();
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

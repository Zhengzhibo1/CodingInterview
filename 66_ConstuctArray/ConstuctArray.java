//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题66：构建乘积数组
// 题目：给定一个数组A[0, 1, …, n-1]，请构建一个数组B[0, 1, …, n-1]，其
// 中B中的元素B[i] =A[0]×A[1]×… ×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。

//==================================================================
//ConstuctArray.java


public class ConstuctArray {

// ====================算法实现=================
	public int[] multiply(int[] A) {
		int length = A.length;
		int[] B = new int[length];

		B[0] = 1;
		for (int i = 1; i < length; ++i) {
			B[i] = B[i - 1] * A[i - 1];
		}

		int temp = 1;
		for (int i = length - 2; i >= 0; --i) {
			temp *= A[i + 1];
			B[i] *= temp;
		}

		return B;
	}

// ============================测试代码=====================	
	public boolean equalArray(int[] A, int[] B) {
		int lengthA = A.length;
		int lengthB = B.length;

		if (lengthA != lengthB) {
			return false;
		}

		for (int i = 0; i < lengthA; ++i) {
			if (A[i] != B[i]) {
				return false;
			}
		}

		return true;
	}

	public void test(String testName, int[] A, int[] expected) {
		System.out.printf("%s Begins: ", testName);

		int[] B = multiply(A);
		if (equalArray(B, expected))
			System.out.print("Passed.\n");
		else
			System.out.print("FAILED.\n");
	}

	public void test1() {
		// 输入数组中没有0
		int[] input = { 1, 2, 3, 4, 5 };
		int[] expected = { 120, 60, 40, 30, 24 };

		test("Test1", input, expected);
	}

	public void test2() {
		// 输入数组中有一个0
		int[] input = { 1, 2, 0, 4, 5 };
		int[] expected = { 0, 0, 40, 0, 0 };

		test("Test2", input, expected);
	}

	public void test3() {
		// 输入数组中有两个0
		int[] input = { 1, 2, 0, 4, 0 };
		int[] expected = { 0, 0, 0, 0, 0 };

		test("Test3", input, expected);
	}

	public void test4() {
		// 输入数组中有正、负数
		int[] input = { 1, -2, 3, -4, 5 };
		int[] expected = { 120, -60, 40, -30, 24 };

		test("Test4", input, expected);
	}

	public void test5() {
		// 输入输入中只有两个数字
		int[] input = { 1, -2 };
		int[] expected = { -2, 1 };

		test("Test4", input, expected);
	}

	public static void main(String[] args) {
		ConstuctArray c = new ConstuctArray();
		c.test1();
		c.test2();
		c.test3();
		c.test4();
		c.test5();

	}

}

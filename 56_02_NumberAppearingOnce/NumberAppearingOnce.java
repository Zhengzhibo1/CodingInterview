//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题56（二）：数组中唯一只出现一次的数字
// 题目：在一个数组中除了一个数字只出现一次之外，其他数字都出现了三次。请
// 找出那个吃出现一次的数字。

//==================================================================
//NumberAppearingOnce.java


public class NumberAppearingOnce {

// ====================算法实现===================
	public int findNumberAppearingOnce(int[] numbers) throws Exception {
		if (numbers == null || numbers.length < 1) {
			throw new Exception("Invalid Input");
		}

		int[] result = new int[32];

		for (int i = 0; i < numbers.length; ++i) {
			int bitMask = 1;
			for (int j = 31; j >= 0; --j) {
				if ((numbers[i] & bitMask) != 0) {
					result[j]++;
				}
				bitMask = bitMask << 1;
			}
		}

		int number = 0;
		for (int i = 0; i < 32; ++i) {
			number = number << 1;
			number += result[i] % 3;

		}

		return number;
	}

// ====================测试代码====================
	public void test(String testName, int[] numbers, int expected) {
		try {
			int result = findNumberAppearingOnce(numbers);
			if (result == expected)
				System.out.printf("%s passed.\n", testName);
			else
				System.out.printf("%s FAILED.\n", testName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 所有数字都是正数，唯一的数字是最小的
	public void test1() {
		int numbers[] = { 1, 1, 2, 2, 2, 1, 3 };
		int expected = 3;
		test("Test1", numbers, expected);
	}

	// 所有数字都是正数，唯一的数字的大小位于中间
	public void test2() {
		int numbers[] = { 4, 3, 3, 2, 2, 2, 3 };
		int expected = 4;
		test("Test2", numbers, expected);
	}

	// 所有数字都是正数，唯一的数字是最大的
	public void test3() {
		int numbers[] = { 4, 4, 1, 1, 1, 7, 4 };
		int expected = 7;
		test("Test3", numbers, expected);
	}

	// 唯一的数字是负数
	public void test4() {
		int numbers[] = { -10, 214, 214, 214 };
		int expected = -10;
		test("Test4", numbers, expected);
	}

	// 除了唯一的数字，其他数字都是负数
	public void test5() {
		int numbers[] = { -209, 3467, -209, -209 };
		int expected = 3467;
		test("Test5", numbers, expected);
	}

	// 重复的数字有正数也有负数
	public void test6() {
		int numbers[] = { 1024, -1025, 1024, -1025, 1024, -1025, 1023 };
		int expected = 1023;
		test("Test6", numbers, expected);
	}

	// 所有数字都是负数
	public void test7() {
		int numbers[] = { -1024, -1024, -1024, -1023 };
		int expected = -1023;
		test("Test7", numbers, expected);
	}

	// 唯一的数字是0
	public void test8() {
		int numbers[] = { -23, 0, 214, -23, 214, -23, 214 };
		int expected = 0;
		test("Test8", numbers, expected);
	}

	// 除了唯一的数字，其他数字都是0
	public void test9() {
		int numbers[] = { 0, 3467, 0, 0, 0, 0, 0, 0 };
		int expected = 3467;
		test("Test9", numbers, expected);
	}

	public static void main(String[] args) {
		NumberAppearingOnce n = new NumberAppearingOnce();
		n.test1();
		n.test2();
		n.test3();
		n.test4();
		n.test5();
		n.test6();
		n.test7();
		n.test8();
		n.test9();

	}

}

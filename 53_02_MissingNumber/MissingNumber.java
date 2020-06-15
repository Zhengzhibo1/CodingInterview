//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题53（二）：0到n-1中缺失的数字
// 题目：一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字
// 都在范围0到n-1之内。在范围0到n-1的n个数字中有且只有一个数字不在该数组
// 中，请找出这个数字。

//==================================================================
//MissingNumber.java


public class MissingNumber {

// ===================算法实现===================
	public int getMissingNumber(int[] numbers, int length) {
		if (numbers == null || numbers.length <= 0) {
			return -1;
		}
		int left = 0;
		int right = numbers.length - 1;
		int middle = 0;
		while (left <= right) {
			middle = (left + right) >> 1;
			if (middle != numbers[middle]) {
				if (middle == 0 || middle - 1 == numbers[middle - 1]) {
					return middle;
				} else {
					right = middle - 1;
				}
			} else {
				left = middle + 1;
			}
		}

		if (left == length) {
			return length;
		}

		return -1;
	}

// ====================测试代码====================
	public void test(String testName, int numbers[], int length, int expected) {
		if (testName != null)
			System.out.printf("%s begins: ", testName);

		int result = getMissingNumber(numbers, length);
		if (result == expected)
			System.out.print("Passed.\n");
		else
			System.out.print("Failed.\n");
	}

	// 缺失的是第一个数字0
	public void test1() {
		int numbers[] = { 1, 2, 3, 4, 5 };
		int expected = 0;
		test("Test1", numbers, 5, expected);
	}

	// 缺失的是最后一个数字
	public void test2() {
		int numbers[] = { 0, 1, 2, 3, 4 };
		int expected = 5;
		test("Test2", numbers, 5, expected);
	}

	// 缺失的是中间某个数字
	public void test3() {
		int numbers[] = { 0, 1, 2, 4, 5 };
		int expected = 3;
		test("Test3", numbers, 5, expected);
	}

	// 数组中只有一个数字，缺失的是第一个数字0
	public void test4() {
		int numbers[] = { 1 };
		int expected = 0;
		test("Test4", numbers, 1, expected);
	}

	// 数组中只有一个数字，缺失的是最后一个数字1
	public void test5() {
		int numbers[] = { 0 };
		int expected = 1;
		test("Test5", numbers, 1, expected);
	}

	// 空数组
	public void test6() {
		int expected = -1;
		test("Test6", null, 0, expected);
	}

	public static void main(String[] args) {
		MissingNumber m = new MissingNumber();
		m.test1();
		m.test2();
		m.test3();
		m.test4();
		m.test5();
		m.test6();

	}

}

//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题53（三）：数组中数值和下标相等的元素
// 题目：假设一个单调递增的数组里的每个元素都是整数并且是唯一的。请编程实
// 现一个函数找出数组中任意一个数值等于其下标的元素。例如，在数组{-3, -1,
// 1, 3, 5}中，数字3和它的下标相等。

//==================================================================
//IntegerIdenticalToIndex.java


public class IntegerIdenticalToIndex {

// ====================算法实现======================
	public int getNumberSameAsIndex(int[] numbers) {

		if (numbers == null || numbers.length == 0) {
			return -1;
		}

		int left = 0;
		int right = numbers.length - 1;
		int middle = 0;

		while (left <= right) {
			middle = (left + right) >> 1;
			if (numbers[middle] == middle) {
				return middle;
			} else if (numbers[middle] > middle) {
				right = middle - 1;
			} else {
				left = middle + 1;
			}
		}

		return -1;
	}

// ============================测试代码=================================
	public void test(String testName, int numbers[], int expected) {
		if (getNumberSameAsIndex(numbers) == expected)
			System.out.printf("%s passed.\n", testName);
		else
			System.out.printf("%s FAILED.\n", testName);
	}

	public void test1() {
		int numbers[] = { -3, -1, 1, 3, 5 };
		int expected = 3;
		test("Test1", numbers, expected);
	}

	public void test2() {
		int numbers[] = { 0, 1, 3, 5, 6 };
		int expected = 0;
		test("Test2", numbers, expected);
	}

	public void test3() {
		int numbers[] = { -1, 0, 1, 2, 4 };
		int expected = 4;
		test("Test3", numbers, expected);
	}

	public void test4() {
		int numbers[] = { -1, 0, 1, 2, 5 };
		int expected = -1;
		test("Test4", numbers, expected);
	}

	public void test5() {
		int numbers[] = { 0 };
		int expected = 0;
		test("Test5", numbers, expected);
	}

	public void test6() {
		int numbers[] = { 10 };
		int expected = -1;
		test("Test6", numbers, expected);
	}

	public void test7() {
		test("Test7", null, -1);
	}

	public static void main(String[] args) {
		IntegerIdenticalToIndex i = new IntegerIdenticalToIndex();
		i.test1();
		i.test2();
		i.test3();
		i.test4();
		i.test5();
		i.test6();
		i.test7();

	}

}

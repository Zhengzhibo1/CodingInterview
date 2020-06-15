//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题53（一）：数字在排序数组中出现的次数
// 题目：统计一个数字在排序数组中出现的次数。例如输入排序数组{1, 2, 3, 3,
// 3, 3, 4, 5}和数字3，由于3在这个数组中出现了4次，因此输出4。

//==================================================================
//NumberOfK.java


public class NumberOfK {

// ====================算法实现====================
	public int getNumberOfK(int[] array, int k) {
		int number = 0;
		if (array != null && array.length > 0) {
			int first = getFirst(array, k, 0, array.length - 1);
			int last = getLast(array, k, 0, array.length - 1);
			if (first > -1 && last > -1) {
				number = last - first + 1;
			}
		}

		return number;
	}

	public int getFirst(int[] array, int k, int start, int end) {
		if (start > end) {
			return -1;
		}

		int middle = (end + start) >> 1;
		if (k == array[middle]) {
			if ((middle > 0 && array[middle - 1] != k) || middle == 0) {
				return middle;
			} else {
				end = middle - 1;
			}
		} else if (k > array[middle]) {
			start = middle + 1;
		} else {
			end = middle - 1;
		}

		return getFirst(array, k, start, end);
	}

	public int getLast(int[] array, int k, int start, int end) {
		if (start > end) {
			return -1;
		}

		int middle = (end + start) >> 1;
		if (k == array[middle]) {
			if ((middle < array.length - 1 && array[middle + 1] != k) || middle == array.length - 1) {
				return middle;
			} else {
				start = middle + 1;
			}
		} else if (k > array[middle]) {
			start = middle + 1;
		} else {
			end = middle - 1;
		}

		return getLast(array, k, start, end);
	}

// ====================测试代码====================
	public void test(String testName, int data[], int k, int expected) {
		if (testName != null)
			System.out.printf("%s begins: ", testName);

		int result = getNumberOfK(data, k);
		if (result == expected)
			System.out.print("Passed.\n");
		else
			System.out.print("Failed.\n");
	}

	// 查找的数字出现在数组的中间
	public void test1() {
		int data[] = { 1, 2, 3, 3, 3, 3, 4, 5 };
		test("Test1", data, 3, 4);
	}

	// 查找的数组出现在数组的开头
	public void test2() {
		int data[] = { 3, 3, 3, 3, 4, 5 };
		test("Test2", data, 3, 4);
	}

	// 查找的数组出现在数组的结尾
	public void test3() {
		int data[] = { 1, 2, 3, 3, 3, 3 };
		test("Test3", data, 3, 4);
	}

	// 查找的数字不存在
	public void test4() {
		int data[] = { 1, 3, 3, 3, 3, 4, 5 };
		test("Test4", data, 2, 0);
	}

	// 查找的数字比第一个数字还小，不存在
	public void test5() {
		int data[] = { 1, 3, 3, 3, 3, 4, 5 };
		test("Test5", data, 0, 0);
	}

	// 查找的数字比最后一个数字还大，不存在
	public void test6() {
		int data[] = { 1, 3, 3, 3, 3, 4, 5 };
		test("Test6", data, 6, 0);
	}

	// 数组中的数字从头到尾都是查找的数字
	public void test7() {
		int data[] = { 3, 3, 3, 3 };
		test("Test7", data, 3, 4);
	}

	// 数组中的数字从头到尾只有一个重复的数字，不是查找的数字
	public void test8() {
		int data[] = { 3, 3, 3, 3 };
		test("Test8", data, 4, 0);
	}

	// 数组中只有一个数字，是查找的数字
	public void test9() {
		int data[] = { 3 };
		test("Test9", data, 3, 1);
	}

	// 数组中只有一个数字，不是查找的数字
	public void test10() {
		int data[] = { 3 };
		test("Test10", data, 4, 0);
	}

	// 鲁棒性测试，数组空指针
	public void test11() {
		test("Test11", null, 0, 0);
	}

	public static void main(String[] args) {
		NumberOfK n = new NumberOfK();
		n.test1();
		n.test2();
		n.test3();
		n.test4();
		n.test5();
		n.test6();
		n.test7();
		n.test8();
		n.test9();
		n.test10();
		n.test11();

	}

}

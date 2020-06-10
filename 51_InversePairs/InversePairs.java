//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题51：数组中的逆序对
// 题目：在数组中的两个数字如果前面一个数字大于后面的数字，则这两个数字组
// 成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。

//==================================================================
//InversePairs.java


public class InversePairs {

// ====================算法实现======================	
	public int inversePairs(int[] array) {
		int result = 0;
		if (array == null || array.length == 0) {
			return 0;
		}

		int[] copy = new int[array.length];
		for (int i = 0; i < array.length; ++i) {
			copy[i] = array[i];
		}
		result = inversePairsCore(array, copy, 0, array.length - 1);

		return result;
	}

	public int inversePairsCore(int[] data, int[] copy, int start, int end) {
		if (start == end) {
//    		copy[start] = data[start];
			return 0;
		}
		int length = (end - start) >> 1;
		int left = inversePairsCore(copy, data, start, start + length);
		int right = inversePairsCore(copy, data, start + length + 1, end);

		int index1 = start + length;
		int index2 = end;
		int indexCopy = end;
		int count = 0;

		while (index1 >= start && index2 >= start + length + 1) {
			if (data[index1] > data[index2]) {
				copy[indexCopy--] = data[index1--];
				count += index2 - start - length;
			} else {
				copy[indexCopy--] = data[index2--];
			}
		}

		for (; index1 >= start; --index1) {
			copy[indexCopy--] = data[index1];
		}
		for (; index2 >= start + length + 1; --index2) {
			copy[indexCopy--] = data[index2];
		}

		return left + right + count;
	}

// ====================测试代码====================
	public void test(String testName, int[] data, int expected) {
		if (testName != null)
			System.out.printf("%s begins: ", testName);

		if (inversePairs(data) == expected)
			System.out.print("Passed.\n");
		else
			System.out.print("Failed.\n");
	}

	public void test1() {
		int data[] = { 1, 2, 3, 4, 7, 6, 5 };
		int expected = 3;

		test("Test1", data, expected);
	}

	// 递减排序数组
	public void test2() {
		int data[] = { 6, 5, 4, 3, 2, 1 };
		int expected = 15;

		test("Test2", data, expected);
	}

	// 递增排序数组
	public void test3() {
		int data[] = { 1, 2, 3, 4, 5, 6 };
		int expected = 0;

		test("Test3", data, expected);
	}

	// 数组中只有一个数字
	public void test4() {
		int data[] = { 1 };
		int expected = 0;

		test("Test4", data, expected);
	}

	// 数组中只有两个数字，递增排序
	public void test5() {
		int data[] = { 1, 2 };
		int expected = 0;

		test("Test5", data, expected);
	}

	// 数组中只有两个数字，递减排序
	public void test6() {
		int data[] = { 2, 1 };
		int expected = 1;

		test("Test6", data, expected);
	}

	// 数组中有相等的数字
	public void test7() {
		int data[] = { 1, 2, 1, 2, 1 };
		int expected = 3;

		test("Test7", data, expected);
	}

	public void test8() {
		int expected = 0;

		test("Test8", null, expected);
	}

	public static void main(String[] args) {
		InversePairs i = new InversePairs();
		i.test1();
		i.test2();
		i.test3();
		i.test4();
		i.test5();
		i.test6();
		i.test7();
		i.test8();

	}

}

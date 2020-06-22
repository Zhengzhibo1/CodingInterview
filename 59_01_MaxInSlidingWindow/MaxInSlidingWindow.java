//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题59（一）：滑动窗口的最大值
// 题目：给定一个数组和滑动窗口的大小，请找出所有滑动窗口里的最大值。例如，
// 如果输入数组{2, 3, 4, 2, 6, 2, 5, 1}及滑动窗口的大小3，那么一共存在6个
// 滑动窗口，它们的最大值分别为{4, 4, 6, 6, 6, 5}，

//==================================================================
//MaxInSlidingWindow.java


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class MaxInSlidingWindow {

// ===================算法实现=================
	public ArrayList<Integer> maxInWindows(int[] num, int size) {
		ArrayList<Integer> maxInWindows = new ArrayList<Integer>();
		if (num == null || num.length < size || size < 1) {
			return maxInWindows;
		}

		Deque<Integer> index = new LinkedList<Integer>();

		for (int i = 0; i < size; ++i) {

			while (!index.isEmpty() && num[i] > num[index.getLast()]) {
				index.pollLast();
			}
			index.add(i);
		}

		for (int i = size; i < num.length; ++i) {
			maxInWindows.add(num[index.getFirst()]);

			while (!index.isEmpty() && num[i] > num[index.getLast()]) {
				index.pollLast();
			}

			if (!index.isEmpty() && index.getFirst() <= (i - size)) {
				index.pollFirst();
			}

			index.add(i);
		}

		maxInWindows.add(num[index.getFirst()]);
		return maxInWindows;
	}

// ====================测试代码====================
	public void test(String testName, int[] num, int size) {
		if (testName != null)
			System.out.printf("%s begins: ", testName);

		ArrayList<Integer> result = maxInWindows(num, size);
		System.out.println();
		System.out.print("数组为：");
		if (num != null) {
			for (int i = 0; i < num.length; ++i) {
				System.out.print(num[i] + " ");
			}
		}

		System.out.println();
		System.out.print("滑动窗口最大值为：");
		for (int i : result) {
			System.out.print(i + " ");
		}

		System.out.println();
	}

	public void test1() {
		int[] num = { 2, 3, 4, 2, 6, 2, 5, 1 };
		int size = 3;

		test("Test1", num, size);
	}

	public void test2() {
		int num[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int size = 3;

		test("Test2", num, size);
	}

	// 输入数组单调递增
	public void test3() {
		int[] num = { 1, 3, 5, 7, 9, 11, 13, 15 };
		int size = 4;

		test("Test3", num, size);
	}

	// 输入数组单调递减
	public void test4() {
		int[] num = { 16, 14, 12, 10, 8, 6, 4 };
		int size = 5;

		test("Test4", num, size);
	}

	// 滑动窗口的大小为1
	public void test5() {
		int[] num = { 10, 14, 12, 11 };
		int size = 1;

		test("Test5", num, size);
	}

	// 滑动窗口的大小等于数组的长度
	public void test6() {
		int[] num = { 10, 14, 12, 11 };
		int size = 4;

		test("Test6", num, size);
	}

	// 滑动窗口的大小为0
	public void test7() {
		int[] num = { 10, 14, 12, 11 };
		int size = 0;

		test("Test7", num, size);
	}

	// 滑动窗口的大小大于输入数组的长度
	public void test8() {
		int[] num = { 10, 14, 12, 11 };
		int size = 5;

		test("Test8", num, size);
	}

	// 输入数组为空
	public void test9() {
		int size = 5;

		test("Test9", null, size);
	}

	public static void main(String[] args) {
		MaxInSlidingWindow m = new MaxInSlidingWindow();

		m.test1();
		m.test2();
		m.test3();
		m.test4();
		m.test5();
		m.test6();
		m.test7();
		m.test8();
		m.test9();
	}
}

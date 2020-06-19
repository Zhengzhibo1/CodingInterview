//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题57（一）：和为s的两个数字
// 题目：输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们
// 的和正好是s。如果有多对数字的和等于s，输出任意一对即可。
//==================================================================
//TwoNumbersWithSum.java


import java.util.ArrayList;

public class TwoNumbersWithSum {

// ====================算法实现===================
	public ArrayList<Integer> findNumbersWithSum(int[] array, int sum) {

		ArrayList<Integer> result = new ArrayList<Integer>();
		if (array == null || array.length < 2) {
			return result;
		}
		int ahead = array.length - 1;
		int behind = 0;

		while (ahead > behind) {
			int temp = array[behind] + array[ahead];
			if (temp == sum) {
				result.add(array[behind]);
				result.add(array[ahead]);
				break;
			} else if (temp > sum) {
				ahead--;
			} else {
				behind++;
			}
		}

		return result;
	}

// ====================测试代码====================
	public void test(String testName, int data[], int sum) {
		if (testName != null)
			System.out.printf("%s begins: ", testName);

		ArrayList<Integer> result = findNumbersWithSum(data, sum);

		if (result.size() == 0) {
			System.out.println("result is null");
		} else {

			if (result.get(0) + result.get(1) == sum)
				System.out.print("Passed. \n");
			else
				System.out.print("FAILED. \n");
		}

	}

	// 存在和为s的两个数字，这两个数字位于数组的中间
	public void test1() {
		int[] data = { 1, 2, 4, 7, 11, 15 };
		test("Test1", data, 15);
	}

	// 存在和为s的两个数字，这两个数字位于数组的两段
	public void test2() {
		int[] data = { 1, 2, 4, 7, 11, 16 };
		test("Test2", data, 17);
	}

	// 不存在和为s的两个数字
	public void test3() {
		int[] data = { 1, 2, 4, 7, 11, 16 };
		test("Test3", data, 10);
	}

	// 鲁棒性测试
	public void test4() {
		test("Test4", null, 0);
	}

	public static void main(String[] args) {
		TwoNumbersWithSum t = new TwoNumbersWithSum();

		t.test1();
		t.test2();
		t.test3();
		t.test4();

	}

}

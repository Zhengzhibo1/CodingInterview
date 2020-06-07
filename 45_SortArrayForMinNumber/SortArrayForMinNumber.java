//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题45：把数组排成最小的数
// 题目：输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼
// 接出的所有数字中最小的一个。例如输入数组{3, 32, 321}，则打印出这3个数
// 字能排成的最小数字321323。

//==================================================================
//SortArrayForMinNumber.java


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortArrayForMinNumber {

// ====================算法实现==================
	public String printMinNumber(int[] numbers) {
		String result = new String();
		if (numbers == null || numbers.length <= 0) {
			return result;
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < numbers.length; ++i) {
			list.add(numbers[i]);
		}

		Collections.sort(list, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {

				String s1 = o1 + "" + o2;
				String s2 = o2 + "" + o1;
				return s1.compareTo(s2);
			}
		});

		for (int i : list) {
			result += i;
		}
		return result;
	}

// ====================测试代码====================
	public void test(String testName, int[] numbers, String expectedResult) {
		if (testName != null)
			System.out.printf("%s begins:\n", testName);

		if (expectedResult != null)
			System.out.printf("Expected result is: \t%s\n", expectedResult);

		System.out.print("Actual result is: \t");
		
		System.out.print(printMinNumber(numbers));

		System.out.println();
	}

	public void test1() {
		int numbers[] = { 3, 5, 1, 4, 2 };
		test("Test1", numbers, "12345");
	}

	public void test2() {
		int numbers[] = { 3, 32, 321 };
		test("Test2", numbers, "321323");
	}

	public void test3() {
		int numbers[] = { 3, 323, 32123 };
		test("Test3", numbers, "321233233");
	}

	public void test4() {
		int numbers[] = { 1, 11, 111 };
		test("Test4", numbers, "111111");
	}

	// 数组中只有一个数字
	public void test5() {
		int numbers[] = { 321 };
		test("Test5", numbers, "321");
	}

	public void test6() {
		test("Test6", null, "Don't print anything.");
	}

	public static void main(String[] args) {
		SortArrayForMinNumber s = new SortArrayForMinNumber();
		s.test1();
		s.test2();
		s.test3();
		s.test4();
		s.test5();
		s.test6();

	}

}

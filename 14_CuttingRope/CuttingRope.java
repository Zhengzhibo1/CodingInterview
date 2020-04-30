//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题14：剪绳子
// 题目：给你一根长度为n绳子，请把绳子剪成m段（m、n都是整数，n>1并且m≥1）。
// 每段的绳子的长度记为k[0]、k[1]、……、k[m]。k[0]*k[1]*…*k[m]可能的最大乘
// 积是多少？例如当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此
// 时得到最大的乘积18。
//==================================================================
//CuttingRope.java

public class CuttingRope {

// ==============算法实现======================
	// 1、动态规划实现
	public int maxProductAfterCutting_solution1(int length) {

		if (length < 2) {
			return 0;
		}
		if (length == 2) {
			return 1;
		}
		if (length == 3) {
			return 2;
		}

		int[] products = new int[length + 1];
		// 该部分用于储存0-3的绳长
		products[0] = 0;
		products[1] = 1;
		products[2] = 2;
		products[3] = 3;

		int max = 0;
		for (int i = 4; i <= length; ++i) {
			max = 0;
			for (int j = 1; j <= i / 2; ++j) {
				int product = products[j] * products[i - j];
				if (max < product) {
					max = product;
				}
			}
			products[i] = max;
		}

		max = products[length];

		return max;
	}

	// 2、贪婪算法
	/*
	 * 尽可能剪长度为3的绳子 当长度为4时，剪成2-2的绳子
	 */

	int maxProductAfterCutting_solution2(int length) {

		if (length < 2) {
			return 0;
		}
		if (length == 2) {
			return 1;
		}
		if (length == 3) {
			return 2;
		}

		// 尽可能多地剪成长度为3的绳子
		int timesOf3 = length / 3;

		if (length - timesOf3 * 3 == 1) {
			timesOf3 -= 1;
		}

		int timesOf2 = (length - timesOf3 * 3) / 2;

		
		
		return (int) Math.pow(3, timesOf3) * (int) Math.pow(2, timesOf2);
	}

// ===================测试代码=====================

	public void test(String testName, int length, int expected) {
		int result1 = maxProductAfterCutting_solution1(length);
		if (result1 == expected) {
			System.out.printf("Solution1 for %s Passed.\n", testName);
		} else {
			System.out.printf("Solution1 for %s FAILED.\n", testName);
		}

		int result2 = maxProductAfterCutting_solution2(length);
		if (result2 == expected) {
			System.out.printf("Solution2 for %s Passed.\n", testName);
		} else {
			System.out.printf("Solution2 for %s FAILED.\n", testName);
		}
	}

	public void test1() {
		int length = 1;
		int expected = 0;
		test("test1", length, expected);
	}

	public void test2() {
		int length = 2;
		int expected = 1;
		test("test2", length, expected);
	}

	public void test3() {
		int length = 3;
		int expected = 2;
		test("test3", length, expected);
	}

	public void test4() {
		int length = 4;
		int expected = 4;
		test("test4", length, expected);
	}

	public void test5() {
		int length = 5;
		int expected = 6;
		test("test5", length, expected);
	}

	public void test6() {
		int length = 6;
		int expected = 9;
		test("test6", length, expected);
	}

	public void test7() {
		int length = 7;
		int expected = 12;
		test("test7", length, expected);
	}

	public void test8() {
		int length = 8;
		int expected = 18;
		test("test8", length, expected);
	}

	public void test9() {
		int length = 9;
		int expected = 27;
		test("test9", length, expected);
	}

	public void test10() {
		int length = 10;
		int expected = 36;
		test("test10", length, expected);
	}

	public void test11() {
		int length = 50;
		int expected = 86093442;
		test("test11", length, expected);
	}

	public static void main(String[] args) {
		CuttingRope c = new CuttingRope();
		c.test1();
		c.test2();
		c.test3();
		c.test4();
		c.test5();
		c.test6();
		c.test7();
		c.test8();
		c.test9();
		c.test10();
		c.test11();

	}

}

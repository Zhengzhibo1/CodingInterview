//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题61：扑克牌的顺子
// 题目：从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
// 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王可以看成任意数字。

//==================================================================
//ContinousCards.java


import java.util.Arrays;

public class ContinousCards {

// ====================算法实现=====================
	public boolean isContinuous(int[] numbers) {

		if (numbers == null || numbers.length < 5) {
			return false;
		}

		// 对数组进行排序
		Arrays.sort(numbers);

		int numberOfZero = 0;
		int numberOfGrap = 0;

		for (int i = 0; i < numbers.length; ++i) {
			if (numbers[i] == 0) {
				numberOfZero++;
			} else {
				break;
			}
		}

		for (int i = numberOfZero; i < numbers.length - 1; ++i) {
			if (numbers[i] == numbers[i + 1]) {
				return false;
			}
			numberOfGrap += numbers[i + 1] - numbers[i] - 1;
		}

		if (numberOfGrap <= numberOfZero) {
			return true;
		}

		return false;
	}

// ====================测试代码====================
	public void test(String testName, int[] numbers, boolean expected) {
		if (testName != null)
			System.out.printf("%s begins: ", testName);

		if (isContinuous(numbers) == expected)
			System.out.println("Passed.\n");
		else
			System.out.println("Failed.\n");
	}

	public void test1() {
		int numbers[] = { 1, 3, 2, 5, 4 };
		test("test1", numbers, true);
	}

	public void test2() {
		int numbers[] = { 1, 3, 2, 6, 4 };
		test("test2", numbers, false);
	}

	public void test3() {
		int numbers[] = { 0, 3, 2, 6, 4 };
		test("test3", numbers, true);
	}

	public void test4() {
		int numbers[] = { 0, 3, 1, 6, 4 };
		test("test4", numbers, false);
	}

	public void test5() {
		int numbers[] = { 1, 3, 0, 5, 0 };
		test("test5", numbers, true);
	}

	public void test6() {
		int numbers[] = { 1, 3, 0, 7, 0 };
		test("test6", numbers, false);
	}

	public void test7() {
		int numbers[] = { 1, 0, 0, 5, 0 };
		test("test7", numbers, true);
	}

	public void test8() {
		int numbers[] = { 1, 0, 0, 7, 0 };
		test("test8", numbers, false);
	}

	public void test9() {
		int numbers[] = { 3, 0, 0, 0, 0 };
		test("test9", numbers, true);
	}

	public void test10() {
		int numbers[] = { 0, 0, 0, 0, 0 };
		test("test10", numbers, true);
	}

	// 有对子
	public void test11() {
		int numbers[] = { 1, 0, 0, 1, 0 };
		test("test11", numbers, false);
	}

	// 鲁棒性测试
	public void test12() {
		test("test12", null, false);
	}

	public static void main(String[] args) {
		ContinousCards c = new ContinousCards();

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
		c.test12();
	}

}

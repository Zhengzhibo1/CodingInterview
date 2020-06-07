//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题46：把数字翻译成字符串
// 题目：给定一个数字，我们按照如下规则把它翻译为字符串：0翻译成"a"，1翻
// 译成"b"，……，11翻译成"l"，……，25翻译成"z"。一个数字可能有多个翻译。例
// 如12258有5种不同的翻译，它们分别是"bccfi"、"bwfi"、"bczi"、"mcfi"和
// "mzi"。请编程实现一个函数用来计算一个数字有多少种不同的翻译方法。

//==================================================================
//TranslateNumbersToStrings.java


public class TranslateNumbersToStrings {

// ====================算法实现====================
	public int getTranslationCount(int number) {
		if (number < 0) {
			return 0;
		}
		String numberToString = String.valueOf(number);
		return getTranslationCount(numberToString);
	}

	public int getTranslationCount(String number) {
		int length = number.length();
		int[] counts = new int[length];
		int count = 0;

		for (int i = length - 1; i >= 0; --i) {
			count = 0;
			if (i < length - 1) {
				count = counts[i + 1];
			} else {
				count = 1;
			}

			if (i < length - 1) {
				int digit1 = number.charAt(i) - '0';
				int digit2 = number.charAt(i + 1) - '0';
				int converted = digit1 * 10 + digit2;
				if (converted >= 10 && converted <= 25) {
					if (i < length - 2) {
						count += counts[i + 2];
					} else {
						count += 1;
					}
				}
			}
			counts[i] = count;
		}

		return counts[0];
	}

// ======================测试代码====================
	public void test(String testName, int number, int expected) {
		if (getTranslationCount(number) == expected)
			System.out.println(testName + " Passed!");
		else
			System.out.println(testName + " FAILED!");
	}

	public void test1() {
		int number = 0;
		int expected = 1;
		test("Test1", number, expected);
	}

	public void test2() {
		int number = 10;
		int expected = 2;
		test("Test2", number, expected);
	}

	public void test3() {
		int number = 125;
		int expected = 3;
		test("Test3", number, expected);
	}

	public void test4() {
		int number = 126;
		int expected = 2;
		test("Test4", number, expected);
	}

	public void test5() {
		int number = 426;
		int expected = 1;
		test("Test5", number, expected);
	}

	public void test6() {
		int number = 100;
		int expected = 2;
		test("Test6", number, expected);
	}

	public void test7() {
		int number = 101;
		int expected = 2;
		test("Test7", number, expected);
	}

	public void test8() {
		int number = 12258;
		int expected = 5;
		test("Test8", number, expected);
	}

	public void test9() {
		int number = -100;
		int expected = 0;
		test("Test9", number, expected);
	}

	public static void main(String[] args) {
		TranslateNumbersToStrings t = new TranslateNumbersToStrings();
		t.test1();
		t.test2();
		t.test3();
		t.test4();
		t.test5();
		t.test6();
		t.test7();
		t.test8();
		t.test9();

	}

}

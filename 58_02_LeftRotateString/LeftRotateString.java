//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题58（二）：左旋转字符串
// 题目：字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
// 请定义一个函数实现字符串左旋转操作的功能。比如输入字符串"abcdefg"和数
// 字2，该函数将返回左旋转2位得到的结果"cdefgab"。

//==================================================================
//LeftRotateString.java


public class LeftRotateString {

// ====================算法实现====================
	public String leftRotateString(String str, int n) {
		String result = "";
		if (str == null || str.length() <= 0 || n > str.length() || n < 0) {
			return result;
		}

		int firstStartIndex = 0;
		int firstEndIndex = n - 1;
		int secondStartIndex = n;
		int secondEndIndex = str.length() - 1;

		char[] strs = str.toCharArray();

		reverse(strs, firstStartIndex, firstEndIndex);
		reverse(strs, secondStartIndex, secondEndIndex);
		reverse(strs, firstStartIndex, secondEndIndex);

		result = String.valueOf(strs);
		return result;
	}

	// 翻转字符数组函数
	public void reverse(char[] strs, int first, int last) {
		if (first >= strs.length || last >= strs.length) {
			return;
		}

		char temp = '\0';
		while (first < last) {
			temp = strs[first];
			strs[first] = strs[last];
			strs[last] = temp;
			first++;
			last--;
		}

	}

// ====================测试代码====================
	public void test(String testName, String input, int num, String expectedResult) {
		if (testName != null)
			System.out.printf("%s begins: ", testName);

		String result = leftRotateString(input, num);

		if ((input == null && expectedResult == "") || (input != null && result.equals(expectedResult)))
			System.out.print("Passed.\n\n");
		else
			System.out.print("Failed.\n\n");
	}

	// 功能测试
	public void test1() {
		String input = "abcdefg";
		String expected = "cdefgab";

		test("Test1", input, 2, expected);
	}

	// 边界值测试
	public void test2() {
		String input = "abcdefg";
		String expected = "bcdefga";

		test("Test2", input, 1, expected);
	}

	// 边界值测试
	public void test3() {
		String input = "abcdefg";
		String expected = "gabcdef";

		test("Test3", input, 6, expected);
	}

	// 鲁棒性测试
	public void test4() {
		test("Test4", null, 6, "");
	}

	// 鲁棒性测试
	public void test5() {
		String input = "abcdefg";
		String expected = "abcdefg";

		test("Test5", input, 0, expected);
	}

	// 鲁棒性测试
	public void test6() {
		String input = "abcdefg";
		String expected = "abcdefg";

		test("Test6", input, 7, expected);
	}

	public static void main(String[] args) {
		LeftRotateString l = new LeftRotateString();
		l.test1();
		l.test2();
		l.test3();
		l.test4();
		l.test5();
		l.test6();

	}

}

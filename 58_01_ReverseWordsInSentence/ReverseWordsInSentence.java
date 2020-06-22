//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题58（一）：翻转单词顺序
// 题目：输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
// 为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，
// 则输出"student. a am I"。

//==================================================================
//ReverseWordsInSentence.java


public class ReverseWordsInSentence {

// ====================算法实现===================
	public String reverseSentence(String str) {
		String result = new String("");
		if (str == null || str.length() <= 0) {
			return result;
		}

		char[] strs = str.toCharArray();
		// 首先翻转整个字符串
		reverse(strs, 0, strs.length - 1);

		// 然后翻转每个单词
		int first = 0;
		int last = 0;
		while (first != strs.length) {
			if (strs[first] == ' ') {
				first++;
				last++;
			}

			if (last == strs.length || strs[last] == ' ') {
				reverse(strs, first, last - 1);
				first = last;
			} else {
				last++;
			}
		}

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
	public void test(String testName, String input, String expectedResult) {
		if (testName != null)
			System.out.printf("%s begins: ", testName);

		String result = reverseSentence(input);

		if ((input == null && expectedResult == null) || (result != null && result.equals(expectedResult)))
			System.out.print("Passed.\n\n");
		else
			System.out.print("Failed.\n\n");
	}

	// 功能测试，句子中有多个单词
	public void test1() {
		String input = "I am a student.";
		String expected = "student. a am I";

		test("Test1", input, expected);
	}

	// 功能测试，句子中只有一个单词
	public void test2() {
		String input = "Wonderful";
		String expected = "Wonderful";

		test("Test2", input, expected);
	}

	// 鲁棒性测试
	public void test3() {
		test("Test3", null, "");
	}

	// 边界值测试，测试空字符串
	public void test4() {
		test("Test4", "", "");
	}

	// 边界值测试，字符串中只有空格
	public void test5() {
		String input = "   ";
		String expected = "   ";
		test("Test5", input, expected);
	}

	public static void main(String[] args) {
		ReverseWordsInSentence r = new ReverseWordsInSentence();

		r.test1();
		r.test2();
		r.test3();
		r.test4();
		r.test5();

	}

}

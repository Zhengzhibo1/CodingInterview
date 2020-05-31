  //==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题20：表示数值的字符串
// 题目：请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，
// 字符串“+100”、“5e2”、“-123”、“3.1416”及“-1E-16”都表示数值，但“12e”、
// “1a3.14”、“1.2.3”、“+-5”及“12e+5.4”都不是

// 思路：将字符串拆开3部分 A：整数部分，有符号
// B：小数部分，无符号
// C：指数部分，有符号
//==================================================================
//NumericStrings.java

public class NumericStrings {

// ===================算法实现====================
	public boolean isNumeric(char[] str) {
		if (str == null) {
			return false;
		}
		// 索引
		int[] index = new int[1];
		index[0] = 0;

		// 扫描整数部分
		boolean numeric = scanInteger(str, index);

		// 扫描小数部分
		if (index[0] < str.length && str[index[0]] == '.') {
			index[0]++;
			numeric = scanUnsignedInteger(str, index) || numeric;
		}

		// 扫描指数部分
		if (index[0] < str.length && (str[index[0]] == 'e' || str[index[0]] == 'E')) {
			index[0]++;
			numeric = numeric && scanInteger(str, index);
		}

		return numeric && index[0] == str.length;
	}

	// 扫描带符号整数部分
	public boolean scanInteger(char[] str, int[] index) {
		if (index[0] < str.length && (str[index[0]] == '+' || str[index[0]] == '-')) {
			index[0]++;
		}
		return scanUnsignedInteger(str, index);
	}

	// 扫描无符号整数部分
	public boolean scanUnsignedInteger(char[] str, int[] index) {
		int before = index[0];
		while (index[0] < str.length && str[index[0]] >= '0' && str[index[0]] <= '9') {
			index[0]++;
		}
		// 当str中存在若干0~9的数字时，返回true
		return index[0] > before;
	}

// ======================测试代码======================
	public void test(String testName, String str, boolean expected) {
		if (testName != null)
			System.out.printf("%s begins: ", testName);

		if (str == null) {
			if (isNumeric(null) == expected)
				System.out.print("Passed.\n");
			else
				System.out.print("FAILED.\n");
		} else {
			char[] s = str.toCharArray();
			if (isNumeric(s) == expected)
				System.out.print("Passed.\n");
			else
				System.out.print("FAILED.\n");
		}
	}

	public static void main(String[] args) {

		NumericStrings n = new NumericStrings();
		n.test("Test1", "100", true);
		n.test("Test2", "123.45e+6", true);
		n.test("Test3", "+500", true);
		n.test("Test4", "5e2", true);
		n.test("Test5", "3.1416", true);
		n.test("Test6", "600.", true);
		n.test("Test7", "-.123", true);
		n.test("Test8", "-1E-16", true);
		n.test("Test9", "1.79769313486232E+308", true);

		System.out.println();
		System.out.println();

		n.test("Test10", "12e", false);
		n.test("Test11", "1a3.14", false);
		n.test("Test12", "1+23", false);
		n.test("Test13", "1.2.3", false);
		n.test("Test14", "+-5", false);
		n.test("Test15", "12e+5.4", false);
		n.test("Test16", ".", false);
		n.test("Test17", ".e1", false);
		n.test("Test18", "e1", false);
		n.test("Test19", "+.", false);
		n.test("Test20", "", false);
		n.test("Test21", null, false);

	}

}

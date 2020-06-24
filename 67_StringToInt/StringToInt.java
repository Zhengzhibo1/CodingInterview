//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题67：把字符串转换成整数
// 题目：请你写一个函数StrToInt，实现把字符串转换成整数这个功能。当然，不
// 能使用atoi或者其他类似的库函数。

//==================================================================
//StringToInt.java


public class StringToInt {

// =====================算法实现=================
	final static int kValid = 0;
	final static int kInvalid = -1;
	int g_Status = kValid;

	public int strToInt(String str) {

		int index = 0;
		g_Status = kInvalid;
		long num = 0;
		if (str != null && str.length() > 0) {
			char[] strs = str.toCharArray();
			boolean minus = false;
			if (strs[0] == '+') {
				index++;
			} else if (strs[0] == '-') {
				minus = true;
				index++;
			}

			if (index < strs.length) {
				num = strToIntCore(strs, minus, index);
			}
		}

		return (int) num;
	}

	public int strToIntCore(char[] strs, boolean minus, int index) {
		long num = 0;

		while (index < strs.length) {
			if (strs[index] >= '0' && strs[index] <= '9') {
				int flag = minus ? -1 : 1;
				num = num * 10 + flag * (strs[index] - '0');

				if ((!minus && num > 0x7FFFFFFF) || (minus && num < 0x80000000)) {
					num = 0;
					break;
				}

				index++;
			} else {
				num = 0;
				break;
			}
		}

		if (index == strs.length) {
			g_Status = kValid;
		}

		return (int) num;
	}

// ====================测试代码====================
	public void test(String string) {
		int result = strToInt(string);
		if (result == 0 && g_Status == kInvalid)
			System.out.printf("the input %s is invalid.\n", string);
		else
			System.out.printf("number for %s is: %d.\n", string, result);
	}

	public static void main(String[] args) {
		StringToInt s = new StringToInt();

		s.test(null);

		s.test("");

		s.test("123");

		s.test("+123");

		s.test("-123");

		s.test("1a33");

		s.test("+0");

		s.test("-0");

		// 有效的最大正整数, 0x7FFFFFFF
		s.test("+2147483647");

		s.test("-2147483647");

		s.test("+2147483648");

		// 有效的最小负整数, 0x80000000
		s.test("-2147483648");

		s.test("+2147483649");

		s.test("-2147483649");

		s.test("+");

		s.test("-");

	}

}

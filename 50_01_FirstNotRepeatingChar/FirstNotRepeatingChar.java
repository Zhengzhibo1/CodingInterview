//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题50（一）：字符串中第一个只出现一次的字符
// 题目：在字符串中找出第一个只出现一次的字符。如输入"abaccdeff"，则输出
// 'b'。
// 本题根据牛客网题意，输出第一个只出现一次的字符的位置。

//==================================================================
//FirstNotRepeatingChar.java


public class FirstNotRepeatingChar {

// ====================算法实现=====================
	public int firstNotRepeatingChar(String str) {
		if (str == null || str.length() == 0) {
			return -1;
		}
		int[] hashTable = new int[256];
		char[] strs = str.toCharArray();
		int position = -1;
		for (int i = 0; i < strs.length; ++i) {
			hashTable[strs[i]]++;
		}
		for (int i = 0; i < strs.length; ++i) {
			if (hashTable[strs[i]] == 1) {
				position = i;
				break;
			}
		}

		return position;
	}

// ====================测试代码========================
	public void test(String pString, char expected) {
		int result = firstNotRepeatingChar(pString);
		char resultChar = '\0';
		if (result != -1) {
			resultChar = pString.charAt(result);
		}
		if (resultChar == expected)
			System.out.print("Test passed.\n");
		else
			System.out.print("Test failed.\n");
	}

	public static void main(String[] args) {
		FirstNotRepeatingChar f = new FirstNotRepeatingChar();

		// 常规输入测试，存在只出现一次的字符
		f.test("google", 'l');

		// 常规输入测试，不存在只出现一次的字符
		f.test("aabccdbd", '\0');

		// 常规输入测试，所有字符都只出现一次
		f.test("abcdefg", 'a');

		// 鲁棒性测试，输入null
		f.test(null, '\0');

	}

}

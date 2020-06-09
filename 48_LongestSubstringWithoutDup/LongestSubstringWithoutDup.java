//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题48：最长不含重复字符的子字符串
// 题目：请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子
// 字符串的长度。假设字符串中只包含从'a'到'z'的字符。

//==================================================================
//LongestSubstringWithoutDup.java

public class LongestSubstringWithoutDup {

// ====================算法实现=======================
	public int longestSubstringWithoutDuplication(String str) {
		if (str == null) {
			return 0;
		}
		int maxLength = 0;
		int curLength = 0;
		char[] strs = str.toCharArray();
		int[] position = new int[26];
		for (int i = 0; i < 26; ++i) {
			position[i] = -1;
		}

		for (int i = 0; i < strs.length; ++i) {
			int preIndex = position[strs[i] - 'a'];
			if (preIndex < 0 || i - preIndex > curLength) {
				curLength++;
			} else {
				if (curLength > maxLength) {
					maxLength = curLength;
				}
				curLength = i - preIndex;
			}
			position[strs[i] - 'a'] = i;
			if (curLength > maxLength) {
				maxLength = curLength;
			}
		}

		return maxLength;
	}

// ====================测试代码====================
	public void test(String input, int expected) {
		int output = longestSubstringWithoutDuplication(input);
		if (output == expected) {
			System.out.println("Passed!");
		} else {
			System.out.println("FAILED!");
		}
	}

	public void test1() {
		String input = "abcacfrar";
		int expected = 4;
		test(input, expected);
	}

	public void test2() {
		String input = "acfrarabc";
		int expected = 4;
		test(input, expected);
	}

	public void test3() {
		String input = "arabcacfr";
		int expected = 4;
		test(input, expected);
	}

	public void test4() {
		String input = "aaaa";
		int expected = 1;
		test(input, expected);
	}

	public void test5() {
		String input = "abcdefg";
		int expected = 7;
		test(input, expected);
	}

	public void test6() {
		String input = "aaabbbccc";
		int expected = 2;
		test(input, expected);
	}

	public void test7() {
		String input = "abcdcba";
		int expected = 4;
		test(input, expected);
	}

	public void test8() {
		String input = "abcdaef";
		int expected = 6;
		test(input, expected);
	}

	public void test9() {
		String input = "a";
		int expected = 1;
		test(input, expected);
	}

	public void test10() {
		String input = "";
		int expected = 0;
		test(input, expected);
	}

	public void test11() {
		test(null, 0);
	}

	public static void main(String[] args) {
		LongestSubstringWithoutDup l = new LongestSubstringWithoutDup();
		l.test1();
		l.test2();
		l.test3();
		l.test4();
		l.test5();
		l.test6();
		l.test7();
		l.test8();
		l.test9();
		l.test10();
		l.test11();

	}

}


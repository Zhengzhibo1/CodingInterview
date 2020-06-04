//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题38：字符串的排列
// 题目：输入一个字符串，打印出该字符串中字符的所有排列。例如输入字符串abc，
// 则打印出由字符a、b、c所能排列出来的所有字符串abc、acb、bac、bca、cab和cba。
// 牛客网该题条件：含重复字符，且输出按字典排序

//==================================================================
//StringPermutation.java

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class StringPermutation {

	public ArrayList<String> Permutation(String str) {

		ArrayList<String> result = new ArrayList<String>();

		if (str == null || str.length() == 0) {
			return result;
		}
		char[] strs = str.toCharArray();

		PermutationCore(strs, result, 0);
		sortString(result);
		return result;
	}

	public void PermutationCore(char[] strs, ArrayList<String> result, int index) {
		if (index == strs.length) {
			result.add(String.valueOf(strs));
		} else {
			int length = strs.length;
			Set<Character> charSet = new HashSet<Character>();
			for (int i = index; i < length; ++i) {
				if (i == index || !charSet.contains(strs[i])) {// 与不同的字符只交换一次
																// 例如abb，a与第二个b交换过，就不会与第三个b交换。
					charSet.add(strs[i]);

					char temp = strs[index];
					strs[index] = strs[i];
					strs[i] = temp;

					PermutationCore(strs, result, index + 1);

					strs[i] = strs[index];
					strs[index] = temp;

				}
			}
		}
	}

	// 结果冒泡排序，按字典序，(为满足牛客网该题目的要求)
	public void sortString(ArrayList<String> result) {
		if (result == null || result.size() == 0) {
			return;
		}

		for (int i = 1; i < result.size(); ++i) {
			for (int j = i + 1; j < result.size(); ++j) {
				if ((result.get(i).compareTo(result.get(j)) > 0)) {
					String temp = result.get(i);
					result.set(i, result.get(j));
					result.set(j, temp);
				}

			}
		}
	}

// ====================测试代码====================
	public void test(String pStr) {
		if (pStr == null)
			System.out.print("Test for null begins:\n");
		else
			System.out.printf("Test for %s begins:\n", pStr);

		ArrayList<String> result = Permutation(pStr);
		for (String str : result) {
			System.out.print(str + "\t");
		}

		System.out.println();
	}

	public static void main(String[] args) {
		StringPermutation s = new StringPermutation();

		s.test(null);

		String string1 = "aa";
		s.test(string1);

		String string2 = "abab";
		s.test(string2);

		String string3 = "ab";
		s.test(string3);

		String string4 = "abc";
		s.test(string4);
	}

}

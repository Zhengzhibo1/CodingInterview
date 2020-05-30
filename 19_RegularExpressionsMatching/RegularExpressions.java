//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题18（一）：在O(1)时间删除链表结点
// 题目：给定单向链表的头指针和一个结点指针，定义一个函数在O(1)时间删除该
// 结点。

// 思路：考虑到c++可以用指向指针的指针来修改链表头，java解答中采用返回值来修改链表头
//==================================================================
//RegularExpressions.java

public class RegularExpressions {

// ============算法实现================
	public boolean match(char[] str, char[] pattern) {
		if(str == null || pattern == null) {
			return false;
		}
		int strIndex = 0;
		int patternIndex = 0;
		return matchCore(str, strIndex, pattern, patternIndex);
	}
	
	public boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
		//str与pattern均到尾部，匹配成功
		if(strIndex == str.length && patternIndex == pattern.length) {
			return true;
		}
		//如果pattern先到尾，匹配失败
		if(strIndex != str.length && patternIndex == pattern.length) {
			return false;
		}
		//模式第2个是*
		if(patternIndex + 1 < pattern.length && pattern[patternIndex+1] == '*') {
			if((strIndex < str.length && pattern[patternIndex] == str[strIndex]) || (strIndex < str.length && pattern[patternIndex] == '.')) {
				return matchCore(str, strIndex + 1, pattern, patternIndex)
						|| matchCore(str, strIndex + 1, pattern, patternIndex + 2)
						|| matchCore(str, strIndex, pattern, patternIndex + 2);
			}else {
				return matchCore(str, strIndex, pattern, patternIndex + 2);
			}
		}
		//模式第2个不是*
		if(strIndex < str.length && (pattern[patternIndex] == str[strIndex] || pattern[patternIndex] == '.')) {
			return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
		}
		
		return false;
	}

// ==================测试代码=========================
	
	public void test(String testName, String str, String pattern, boolean expected) {
	    if(testName != null)
	        System.out.printf("%s begins: ", testName);

	    char[] string = str.toCharArray();
	    char[] pat = pattern.toCharArray();
	    if(match(string, pat) == expected)
	    	System.out.printf("Passed.\n");
	    else
	    	System.out.printf("FAILED.\n");
	}
	public static void main(String[] args) {
		RegularExpressions r = new RegularExpressions();
		r.test("test01", "", "", true);
	    r.test("test02", "", ".*", true);
	    r.test("test03", "", ".", false);
	    r.test("test04", "", "c*", true);
	    r.test("test05", "a", ".*", true);
	    r.test("test06", "a", "a.", false);
	    r.test("test07", "a", "", false);
	    r.test("test08", "a", ".", true);
	    r.test("test09", "a", "ab*", true);
	    r.test("test10", "a", "ab*a", false);
	    r.test("test11", "aa", "aa", true);
	    r.test("test12", "aa", "a*", true);
	    r.test("test13", "aa", ".*", true);
	    r.test("test14", "aa", ".", false);
	    r.test("test15", "ab", ".*", true);
	    r.test("test16", "ab", ".*", true);
	    r.test("test17", "aaa", "aa*", true);
	    r.test("test18", "aaa", "aa.a", false);
	    r.test("test19", "aaa", "a.a", true);
	    r.test("test20", "aaa", ".a", false);
	    r.test("test21", "aaa", "a*a", true);
	    r.test("test22", "aaa", "ab*a", false);
	    r.test("test23", "aaa", "ab*ac*a", true);
	    r.test("test24", "aaa", "ab*a*c*a", true);
	    r.test("test25", "aaa", ".*", true);
	    r.test("test26", "aab", "c*a*b", true);
	    r.test("test27", "aaca", "ab*a*c*a", true);
	    r.test("test28", "aaba", "ab*a*c*a", false);
	    r.test("test29", "bbbba", ".*a*a", true);
	    r.test("test30", "bcbbabab", ".*a*a", false);

	}

}

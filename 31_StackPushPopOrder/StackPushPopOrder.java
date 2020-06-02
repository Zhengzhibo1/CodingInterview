//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题31：栈的压入、弹出序列
// 题目：输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是
// 否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1、2、3、4、
// 5是某栈的压栈序列，序列4、5、3、2、1是该压栈序列对应的一个弹出序列，但
// 4、3、5、1、2就不可能是该压栈序列的弹出序列。

//==================================================================
//StackPushPopOrder.java

import java.util.Stack;

public class StackPushPopOrder {

// ====================算法实现==================
	public boolean IsPopOrder(int[] pushA, int[] popA) {
		boolean result = false;

		if (pushA != null && popA != null) {
			int pushAIndex = 0;
			int popAIndex = 0;
			Stack<Integer> stack = new Stack<Integer>();

			while (popAIndex < popA.length) {
				while (stack.isEmpty() || stack.peek() != popA[popAIndex]) {
					if (pushAIndex == pushA.length) {
						break;
					}
					stack.push(pushA[pushAIndex]);
					pushAIndex++;
				}
				if (stack.peek() != popA[popAIndex]) {
					break;
				}

				stack.pop();
				popAIndex++;
			}

			if (popAIndex == popA.length && stack.isEmpty()) {
				result = true;
			}
		}

		return result;
	}

// ====================测试代码==================	
	public void test(String testName, int[] pushA, int[] popA, boolean expected) {
		if (testName != null)
			System.out.printf("%s begins: ", testName);

		if (IsPopOrder(pushA, popA) == expected)
			System.out.print("Passed.\n");
		else
			System.out.print("failed.\n");
	}

	public void test1() {

		int[] pushA = { 1, 2, 3, 4, 5 };
		int[] popA = { 4, 5, 3, 2, 1 };

		test("Test1", pushA, popA, true);
	}

	public void test2() {

		int[] pushA = { 1, 2, 3, 4, 5 };
		int[] popA = { 3, 5, 4, 2, 1 };

		test("Test2", pushA, popA, true);
	}

	public void test3() {
		int[] pushA = { 1, 2, 3, 4, 5 };
		int[] popA = { 4, 3, 5, 1, 2 };

		test("Test3", pushA, popA, false);
	}

	public void test4() {
		int[] pushA = { 1, 2, 3, 4, 5 };
		int[] popA = { 3, 5, 4, 1, 2 };

		test("Test4", pushA, popA, false);
	}

	// push和pop序列只有一个数字
	public void test5() {
		int[] pushA = { 1 };
		int[] popA = { 2 };

		test("Test5", pushA, popA, false);
	}

	public void test6() {
		int[] pushA = { 1 };
		int[] popA = { 1 };

		test("Test6", pushA, popA, true);
	}

	public void test7() {
		test("Test7", null, null, false);
	}

	public static void main(String[] args) {
		StackPushPopOrder s = new StackPushPopOrder();
		s.test1();
		s.test2();
		s.test3();
		s.test4();
		s.test5();
		s.test6();
		s.test7();
	}

}

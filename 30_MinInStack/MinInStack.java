//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题30：包含min函数的栈
// 题目：定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min
// 函数。在该栈中，调用min、push及pop的时间复杂度都是O(1)。

//==================================================================
//MinInStack.java

import java.util.Stack;

public class StackWithMin {

// ===================算法实现=================
	// 数据栈
	Stack<Integer> m_data = new Stack<Integer>();
	// 辅助栈
	Stack<Integer> m_min = new Stack<Integer>();

	public void push(int node) {
		m_data.push(node);

		if (m_min.isEmpty() || node < m_min.peek()) {
			m_min.push(node);
		} else {
			m_min.push(m_min.peek());
		}
	}

	public void pop() {
		m_data.pop();
		m_min.pop();
	}

	public int top() {
		return m_data.peek();
	}

	public int min() {
		return m_min.peek();
	}

// ===================测试代码=================
	public void test(String testName, StackWithMin stack, int expected) {
		if (testName != null)
			System.out.printf("%s begins: ", testName);

		if (stack.min() == expected)
			System.out.print("Passed.\n");
		else
			System.out.print("Failed.\n");
	}

	public static void main(String[] args) {
		StackWithMin stack = new StackWithMin();
		stack.push(3);
		stack.test("Test1", stack, 3);

		stack.push(4);
		stack.test("Test2", stack, 3);

		stack.push(2);
		stack.test("Test3", stack, 2);

		stack.push(3);
		stack.test("Test4", stack, 2);

		stack.pop();
		stack.test("Test5", stack, 2);

		stack.pop();
		stack.test("Test6", stack, 3);

		stack.pop();
		stack.test("Test7", stack, 3);

		stack.push(0);
		stack.test("Test8", stack, 0);

	}

}

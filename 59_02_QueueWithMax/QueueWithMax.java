//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题59（二）：队列的最大值
// 题目：给定一个数组和滑动窗口的大小，请找出所有滑动窗口里的最大值。例如，
// 如果输入数组{2, 3, 4, 2, 6, 2, 5, 1}及滑动窗口的大小3，那么一共存在6个
// 滑动窗口，它们的最大值分别为{4, 4, 6, 6, 6, 5}，

//==================================================================
//QueueWithMax.java


import java.util.Deque;
import java.util.LinkedList;

public class QueueWithMax {

// ====================算法实现==================
	Deque<Integer> maximums = new LinkedList<Integer>();
	Deque<Integer> data = new LinkedList<Integer>();

	public void push_back(int num) {
		while (!maximums.isEmpty() && num > maximums.getLast()) {
			maximums.pollLast();
		}
		maximums.add(num);
		data.add(num);
	}

	public void pop_front() throws Exception {
		if (maximums.isEmpty()) {
			throw new Exception("queue is empty");
		}
		if (maximums.getFirst() == data.getFirst()) {
			maximums.pollFirst();
		}
		data.pollFirst();

	}

	public int max() throws Exception {
		if (maximums.isEmpty()) {
			throw new Exception("queue is empty");
		}
		return maximums.getFirst();
	}

// ====================测试代码====================
	public static void test(String testName, QueueWithMax queue, int expected) {
		if (testName != null)
			System.out.printf("%s begins: ", testName);

		try {
			if (queue.max() == expected)
				System.out.print("Passed.\n");
			else
				System.out.print("FAILED.\n");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		QueueWithMax queue = new QueueWithMax();

		queue.push_back(2);
		test("test1", queue, 2);

		// {2, 3}
		queue.push_back(3);
		test("test2", queue, 3);

		// {2, 3, 4}
		queue.push_back(4);
		test("test3", queue, 4);

		// {2, 3, 4, 2}
		queue.push_back(2);
		test("test4", queue, 4);

		// {3, 4, 2}
		queue.pop_front();
		test("test5", queue, 4);

		// {4, 2}
		queue.pop_front();
		test("test6", queue, 4);

		// {2}
		queue.pop_front();
		test("test7", queue, 2);

		// {2, 6}
		queue.push_back(6);
		test("test8", queue, 6);

		// {2, 6, 2}
		queue.push_back(2);
		test("test9", queue, 6);

		// {2, 6, 2, 5}
		queue.push_back(5);
		test("test9", queue, 6);

		// {6, 2, 5}
		queue.pop_front();
		test("test10", queue, 6);

		// {2, 5}
		queue.pop_front();
		test("test11", queue, 5);

		// {5}
		queue.pop_front();
		test("test12", queue, 5);

		// {5, 1}
		queue.push_back(1);
		test("test13", queue, 5);
	}

}

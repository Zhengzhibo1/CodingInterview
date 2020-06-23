//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题62：圆圈中最后剩下的数字
// 题目：0, 1, …, n-1这n个数字排成一个圆圈，从数字0开始每次从这个圆圈里
// 删除第m个数字。求出这个圆圈里剩下的最后一个数字。

//==================================================================
//LastNumberInCircle.java


import java.util.ArrayList;

public class LastNumberInCircle {

// ====================算法实现=================
	// 1、数组实现
	public int lastRemaining_Solution_1(int n, int m) {
		if (n < 1 || m < 1) {
			return -1;
		}

		int[] numbers = new int[n];
		for (int i = 0; i < n; ++i) {
			numbers[i] = i;
		}
		int count = 0;
		int index = 0;
		while (count != n - 1) {
			int i = 1;
			while (i < m || numbers[index] == -1) {
				if (numbers[index] == -1) {
					index++;
					if (index == n) { // 模拟环
						index = 0;
					}
					continue;
				}
				index++;
				if (index == n) { // 模拟环
					index = 0;
				}
				i++;
			}

			numbers[index] = -1;
			index++;
			if (index == n) { // 模拟环
				index = 0;
			}
			count++;
		}

		int result = -1;
		for (int i = 0; i < n; ++i) {
			if (numbers[i] != -1) {
				result = numbers[i];
				break;
			}
		}
		return result;
	}

	// 2、ArrayList实现
	public int lastRemaining_Solution_2(int n, int m) {
		if (n < 1 || m < 1) {
			return -1;
		}

		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for (int i = 0; i < n; ++i) {
			numbers.add(i);
		}
		int index = 0;
		while (numbers.size() > 1) {
			for (int i = 1; i < m; ++i) {
				index++;
				if (index == numbers.size()) {
					index = 0;
				}
			}

			numbers.remove(index);
			if (index == numbers.size()) {
				index = 0;
			}

		}

		return numbers.get(0);
	}

	// 3、找规律
	public int lastRemaining_Solution_3(int n, int m) {
		if (n < 1 || m < 1) {
			return -1;
		}

		int last = 0;
		for (int i = 2; i <= n; ++i) {
			last = (last + m) % i;
		}
		return last;
	}

// ===============================测试代码========================
	public void test(String testName, int n, int m, int expected) {
		if (testName != null)
			System.out.printf("%s begins: \n", testName);

		if (lastRemaining_Solution_1(n, m) == expected)
			System.out.print("Solution1 passed.\n");
		else
			System.out.print("Solution1 failed.\n");

		if (lastRemaining_Solution_2(n, m) == expected)
			System.out.print("Solution2 passed.\n");
		else
			System.out.print("Solution2 failed.\n");

		if (lastRemaining_Solution_3(n, m) == expected)
			System.out.print("Solution3 passed.\n");
		else
			System.out.print("Solution3 failed.\n");

		System.out.print("\n");
	}

	public void test1() {
		test("test1", 5, 3, 3);
	}

	public void test2() {
		test("test2", 5, 2, 2);
	}

	public void test3() {
		test("test3", 6, 7, 4);
	}

	public void test4() {
		test("test4", 6, 6, 3);
	}

	public void test5() {
		test("test5", 0, 0, -1);
	}

	public void test6() {
		test("test6", 4000, 997, 1027);
	}

	public static void main(String[] args) {
		LastNumberInCircle l = new LastNumberInCircle();
		l.test1();
		l.test2();
		l.test3();
		l.test4();
		l.test5();
		l.test6();
	}

}

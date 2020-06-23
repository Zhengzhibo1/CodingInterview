//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题63：股票的最大利润
// 题目：假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖交易该股
// 票可能获得的利润是多少？例如一只股票在某些时间节点的价格为{9, 11, 8, 5,
// 7, 12, 16, 14}。如果我们能在价格为5的时候买入并在价格为16时卖出，则能
// 收获最大的利润11。

//==================================================================
//MaximalProfit.java


public class MaximalProfit {

// ====================算法实现==================
	public int maximalProfit(int[] num) {
		if (num == null || num.length < 2) {
			return 0;
		}

		int min = num[0];
		int maxDiff = num[1] - num[0];

		for (int i = 2; i < num.length; ++i) {
			if (num[i - 1] < min) {
				min = num[i - 1];
			}

			int currentDiff = num[i] - min;
			if (currentDiff > maxDiff) {
				maxDiff = currentDiff;
			}
		}
		return maxDiff;
	}

// ==================== 测试代码 ====================
	public void test(String testName, int[] numbers, int expected) {
		if (testName != null)
			System.out.printf("%s begins: ", testName);

		if (maximalProfit(numbers) == expected)
			System.out.print("Passed.\n");
		else
			System.out.print("FAILED.\n");
	}

	public void test1() {
		int numbers[] = { 4, 1, 3, 2, 5 };
		test("test1", numbers, 4);
	}

	// 价格递增
	public void test2() {
		int numbers[] = { 1, 2, 4, 7, 11, 16 };
		test("test2", numbers, 15);
	}

	// 价格递减
	public void test3() {
		int numbers[] = { 16, 11, 7, 4, 2, 1 };
		test("test3", numbers, -1);
	}

	// 价格全部相同
	public void test4() {
		int numbers[] = { 16, 16, 16, 16, 16 };
		test("test4", numbers, 0);
	}

	public void test5() {
		int numbers[] = { 9, 11, 5, 7, 16, 1, 4, 2 };
		test("test5", numbers, 11);
	}

	public void test6() {
		int numbers[] = { 2, 4 };
		test("test6", numbers, 2);
	}

	public void test7() {
		int numbers[] = { 4, 2 };
		test("test7", numbers, -2);
	}

	public void test8() {
		test("test8", null, 0);
	}

	public static void main(String[] args) {
		MaximalProfit m = new MaximalProfit();
		m.test1();
		m.test2();
		m.test3();
		m.test4();
		m.test5();
		m.test6();
		m.test7();
		m.test8();
	}

}

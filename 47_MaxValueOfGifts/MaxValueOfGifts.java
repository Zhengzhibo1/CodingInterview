//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题47：礼物的最大价值
// 题目：在一个m×n的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值
// （价值大于0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向左或
// 者向下移动一格直到到达棋盘的右下角。给定一个棋盘及其上面的礼物，请计
// 算你最多能拿到多少价值的礼物？

//==================================================================
//MaxValueOfGifts.java


public class MaxValueOfGifts {

// =========================算法实现=======================
	int getMaxValue_solution(int[][] values, int rows, int cols) {
		if (values == null || rows <= 0 || cols <= 0) {
			return 0;
		}
		int max[] = new int[cols];
		for (int i = 0; i < rows; ++i) {
			for (int j = 0; j < cols; ++j) {
				int left = 0;
				int up = 0;
				if (i > 0) {
					up = max[j];
				}
				if (j > 0) {
					left = max[j - 1];
				}
				max[j] = Math.max(left, up) + values[i][j];
			}
		}
		return max[cols - 1];
	}

// ====================测试代码====================
	public void test(String testName, int[][] values, int rows, int cols, int expected) {
		if (getMaxValue_solution(values, rows, cols) == expected) {
			System.out.println("Passed!");
		}

		else {
			System.out.println("FAILED");
		}

	}

	public void test1() {
		// 三行三列
		int values[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int expected = 29;
		test("test1", values, 3, 3, expected);
	}

	public void test2() {
		// 四行四列
		int values[][] = { { 1, 10, 3, 8 }, { 12, 2, 9, 6 }, { 5, 7, 4, 11 }, { 3, 7, 16, 5 } };
		int expected = 53;
		test("test2", values, 4, 4, expected);
	}

	public void test3() {
		// 一行四列
		int values[][] = { { 1, 10, 3, 8 } };
		int expected = 22;
		test("test3", values, 1, 4, expected);
	}

	public void test4() {
		int values[][] = { { 1 }, { 12 }, { 5 }, { 3 } };
		int expected = 21;
		test("test4", values, 4, 1, expected);
	}

	public void test5() {
		// 一行一列
		int values[][] = { { 3 } };
		int expected = 3;
		test("test5", values, 1, 1, expected);
	}

	public void test6() {
		// 空指针
		int expected = 0;
		test("test6", null, 0, 0, expected);
	}

	public static void main(String[] args) {
		MaxValueOfGifts m = new MaxValueOfGifts();
		m.test1();
		m.test2();
		m.test3();
		m.test4();
		m.test5();
		m.test6();

	}

}

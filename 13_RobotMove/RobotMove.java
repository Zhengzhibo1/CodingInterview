//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题13：机器人的运动范围
// 题目：地上有一个m行n列的方格。一个机器人从坐标(0, 0)的格子开始移动，它
// 每一次可以向左、右、上、下移动一格，但不能进入行坐标和列坐标的数位之和
// 大于k的格子。例如，当k为18时，机器人能够进入方格(35, 37)，因为3+5+3+7=18。
// 但它不能进入方格(35, 38)，因为3+5+3+8=19。请问该机器人能够到达多少个格子？

// 思路：回溯法
//==================================================================
//RobotMove.java

public class RobotMove {

// ===================算法实现===================
	public int movingCount(int threshold, int rows, int cols) {

		if (threshold < 0 || rows < 1 || cols < 1) {
			return 0;
		}

		boolean[][] visited = new boolean[rows][cols];
		int count = movingCountCore(threshold, rows, cols, 0, 0, visited);
		return count;
	}

	public int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[][] visited) {

		int count = 0;
		if (check(threshold, rows, cols, row, col, visited)) {
			visited[row][col] = true;
			count = 1 + movingCountCore(threshold, rows, cols, row, col - 1, visited)
					+ movingCountCore(threshold, rows, cols, row + 1, col, visited)
					+ movingCountCore(threshold, rows, cols, row, col + 1, visited)
					+ movingCountCore(threshold, rows, cols, row - 1, col, visited);
		}
		return count;
	}

	public boolean check(int threshold, int rows, int cols, int row, int col, boolean[][] visited) {

		if (row >= 0 && col >= 0 && row < rows && col < cols && getDigitSum(row) + getDigitSum(col) <= threshold
				&& !visited[row][col]) {
			return true;
		}
		return false;
	}

	public int getDigitSum(int number) {
		int sum = 0;
		while(number > 0) {
			sum += number % 10;
			number /= 10;
		}
		return sum;
	}

// ==============测试代码========================
	public void test(String testName, int threshold, int rows, int cols, int expected) {
		if(testName != null) {
			System.out.printf("%s begins：", testName);
		}
		if(movingCount(threshold, rows, cols) == expected) {
			System.out.print("Passed.\n");
		}else {
			System.out.print("FAILED.\n");
		}
	}
	
	// 方格多行多列
	public void test1() {
		test("Test1", 5, 10, 10, 21);
	}
	
	// 方格多行多列
	void test2()
	{
	    test("Test2", 15, 20, 20, 359);
	}

	// 方格只有一行，机器人只能到达部分方格
	void test3()
	{
	    test("Test3", 10, 1, 100, 29);
	}

	// 方格只有一行，机器人能到达所有方格
	void test4()
	{
	    test("Test4", 10, 1, 10, 10);
	}

	// 方格只有一列，机器人只能到达部分方格
	void test5()
	{
	    test("Test5", 15, 100, 1, 79);
	}

	// 方格只有一列，机器人能到达所有方格
	void test6()
	{
	    test("Test6", 15, 10, 1, 10);
	}

	// 方格只有一行一列
	void test7()
	{
	    test("Test7", 15, 1, 1, 1);
	}

	// 方格只有一行一列
	void test8()
	{
	    test("Test8", 0, 1, 1, 1);
	}

	// 机器人不能进入任意一个方格
	void test9()
	{
	    test("Test9", -10, 10, 10, 0);
	}
	
	public static void main(String[] args) {
		RobotMove r = new RobotMove();
		r.test1();
		r.test2();
		r.test3();
		r.test4();
		r.test5();
		r.test6();
		r.test7();
		r.test8();
		r.test9();

	}

}

//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题10：斐波那契数列
// 题目：写一个函数，输入n，求斐波那契（Fibonacci）数列的第n项。
// 思路：1、递归 2、循环
//==================================================================
//Fibonacci.java
package fibonacci;

public class Fibonacci {

// ===============算法实现=======================
// ===============方法1：递归====================
	public long Fibonacci_Solution1(int n) {
		if (n <= 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}

		return Fibonacci_Solution1(n - 1) + Fibonacci_Solution1(n - 2);
	}

// ================方法2：循环=====================
	public long Fibonacci_Solution2(int n) {
		int[] result = { 0, 1 };
		if (n < 2) {
			return result[n];
		}

		long fibNMinusOne = 1;
		long fibNMinusTwo = 0;
		long fibN = 0;
		for (int i = 2; i <= n; ++i) {
			fibN = fibNMinusOne + fibNMinusTwo;

			fibNMinusTwo = fibNMinusOne;
			fibNMinusOne = fibN;
		}

		return fibN;
	}

// ==================测试代码=====================
	// 分别用两种方法进行求解，并比较所消耗的时间
	public static void main(String[] args) {
		Fibonacci f = new Fibonacci();
		int i = 40; // 求第40项的值
		long time1 = System.currentTimeMillis();
		long result1 = f.Fibonacci_Solution1(i);
		long time2 = System.currentTimeMillis();
		System.out.printf("斐波拉契数列第%d项的值为%d,总用时 %d 毫秒\n", i, result1, time2 - time1);
		long result2 = f.Fibonacci_Solution2(i);
		System.out.printf("斐波拉契数列第%d项的值为%d,总用时 %d 毫秒\n", i, result2, System.currentTimeMillis() - time2);
	}

}

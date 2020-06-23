//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题64：求1+2+…+n
// 题目：求1+2+…+n，要求不能使用乘除法、for、while、if、else、switch、case
// 等关键字及条件判断语句（A?B:C）。

//==================================================================
//Accumulate.java


public class Accumulate {

	private static int N = 0;
	private static int SUM = 0;

	public Accumulate() {
		N++;
		SUM += N;
	}

	public static void reset() {
		N = 0;
		SUM = 0;
	}

	public static int getSum() {
		return SUM;
	}

	// 2、短路原理
	public static int accumulate(int n) {
		int result = n;
		boolean flag = (n > 0) && ((result += accumulate(n - 1)) > 0);
		return result;
	}

// ====================测试代码====================
	public static void main(String[] args) {
		Accumulate.reset();
		Accumulate[] a = new Accumulate[10];
		for (int i = 0; i < a.length; ++i) {
			a[i] = new Accumulate();
		}
		System.out.println(Accumulate.getSum());

		System.out.println(accumulate(10));
	}

}

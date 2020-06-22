//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题60：n个骰子的点数
// 题目：把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s
// 的所有可能的值出现的概率。

//==================================================================
//DicesProbability.java


public class DicesProbability {

	int g_maxValue = 6;

// ====================算法实现====================
	public void printProbability(int number) {

		if (number < 1) {
			return;
		}
		int[][] probabilities = new int[2][number * g_maxValue + 1];
		int flag = 0;

		for (int i = 1; i < g_maxValue; ++i) {
			probabilities[flag][i] = 1;
		}

		for (int k = 2; k <= number; ++k) {
			for (int i = 1; i < g_maxValue; ++i) {
				probabilities[1 - flag][i] = 0;
			}

			for (int i = k; i <= g_maxValue * k; ++i) {
				probabilities[1 - flag][i] = 0;
				for (int j = 1; j <= i && j <= g_maxValue; ++j) {
					probabilities[1 - flag][i] += probabilities[flag][i - j];
				}
			}

			flag = 1 - flag;
		}

		double total = Math.pow(g_maxValue, number);
		for (int i = number; i <= g_maxValue * number; ++i) {
			double ratio = (double) probabilities[flag][i] / total;
			System.out.printf("%d: %e\n", i, ratio);
		}
	}

// ===================测试代码========================
	public static void main(String[] args) {
		DicesProbability d = new DicesProbability();
		d.printProbability(2);

	}

}

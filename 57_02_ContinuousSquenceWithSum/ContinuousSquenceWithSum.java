//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题57（二）：为s的连续正数序列
// 题目：输入一个正数s，打印出所有和为s的连续正数序列（至少含有两个数）。
// 例如输入15，由于1+2+3+4+5=4+5+6=7+8=15，所以结果打印出3个连续序列1～5、
// 4～6和7～8。

//==================================================================
//ContinuousSquenceWithSum.java


import java.util.ArrayList;

public class ContinuousSquenceWithSum {

// ====================算法实现=====================
	public ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {

		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		if (sum < 3) {
			return results;
		}

		int small = 1;
		int big = 2;
		int middle = (sum + 1) >> 1;
		int curSum = small + big;

		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(small);
		result.add(big);
		while (small < middle) {
			if (curSum == sum) {
				results.add(new ArrayList<Integer>(result));
			}

			while (curSum > sum && small < middle) {
				result.remove(0);
				curSum -= small;
				small++;

				if (curSum == sum) {
					results.add(new ArrayList<Integer>(result));
				}
			}

			big++;
			curSum += big;
			result.add(big);
		}

		return results;
	}

// ====================测试代码====================
	public void test(int sum) {
		System.out.print("SUM is " + sum + "\n");
		ArrayList<ArrayList<Integer>> results = findContinuousSequence(sum);
		for (ArrayList<Integer> result : results) {
			for (int i : result) {
				System.out.print(i + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) {
		ContinuousSquenceWithSum c = new ContinuousSquenceWithSum();
		c.test(1);
		c.test(3);
		c.test(4);
		c.test(9);
		c.test(15);
		c.test(100);

	}

}

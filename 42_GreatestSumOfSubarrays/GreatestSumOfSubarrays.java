//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题42：连续子数组的最大和
// 题目：输入一个整型数组，数组里有正数也有负数。数组中一个或连续的多个整
// 数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为O(n)。

//==================================================================
//GreatestSumOfSubarrays.java

public class GreatestSumOfSubarrays {

// ====================算法实现==================
	// 定义一个全局变量用于判断输入的有效性
	public boolean g_InvalidInput = false;

	public int FindGreatestSumOfSubArray(int[] array) {
		if (array == null || array.length <= 0) {
			g_InvalidInput = true;
			return 0;
		}

		g_InvalidInput = false;
		int curSum = 0;
		int greatestSum = 0x80000000; // int类型的最小值
		for (int i = 0; i < array.length; ++i) {
			if (curSum < 0) {
				curSum = array[i];
			} else {
				curSum += array[i];
			}

			if (curSum > greatestSum) {
				greatestSum = curSum;
			}
		}
		return greatestSum;
	}

// ====================测试代码====================
	public void test(String testName, int[] pData, int expected, boolean expectedFlag) {
		if (testName != null)
			System.out.printf("%s begins: \n", testName);

		int result = FindGreatestSumOfSubArray(pData);
		if (result == expected && expectedFlag == g_InvalidInput)
			System.out.print("Passed.\n");
		else
			System.out.print("Failed.\n");
	}

	// 1, -2, 3, 10, -4, 7, 2, -5
	public void test1() {
		int[] data = { 1, -2, 3, 10, -4, 7, 2, -5 };
		test("Test1", data, 18, false);
	}

	// 所有数字都是负数
	// -2, -8, -1, -5, -9
	public void test2() {
		int[] data = { -2, -8, -1, -5, -9 };
		test("Test2", data, -1, false);
	}

	// 所有数字都是正数
	// 2, 8, 1, 5, 9
	public void test3() {
		int[] data = { 2, 8, 1, 5, 9 };
		test("Test3", data, 25, false);
	}

	// 无效输入
	public void test4() {
		test("Test4", null, 0, true);
	}

	public static void main(String[] args) {
		GreatestSumOfSubarrays g = new GreatestSumOfSubarrays();
		g.test1();
		g.test2();
		g.test3();
		g.test4();

	}

}

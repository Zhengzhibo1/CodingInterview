//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题56（一）：数组中只出现一次的两个数字
// 题目：一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序
// 找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。

//==================================================================
//NumbersAppearOnce.java


public class NumbersAppearOnce {

// ====================算法实现=======================
	// num1,num2分别为长度为1的数组。传出参数
	// 将num1[0],num2[0]设置为返回结果
	public void findNumsAppearOnce(int[] array, int num1[], int num2[]) {
		if (array == null || array.length < 2) {
			num1[0] = 0;
			num2[0] = 0;
			return;
		}

		int resultExclusiveOR = 0;
		for (int i = 0; i < array.length; ++i) {
			resultExclusiveOR ^= array[i];
		}

		int indexOf1 = findFirstBitIs1(resultExclusiveOR);
		for (int i = 0; i < array.length; ++i) {
			if (((array[i] >> indexOf1) & 1) == 0) {
				num1[0] ^= array[i];
			} else {
				num2[0] ^= array[i];
			}
		}

	}

	// 从右往左找到第一个为1的位置
	public int findFirstBitIs1(int num) {
		int indexBitIs1 = 0;
		while (((num & 1) == 0) && (indexBitIs1 < 32)) {
			num = num >> 1;
			indexBitIs1++;
		}

		return indexBitIs1;
	}

// ====================测试代码====================
	public void test(String testName, int data[], int expected1, int expected2) {
		if (testName != null)
			System.out.printf("%s begins: ", testName);

		int[] num1 = new int[1];
		int[] num2 = new int[1];
		findNumsAppearOnce(data, num1, num2);

		if ((expected1 == num1[0] && expected2 == num2[0]) || (expected2 == num1[0] && expected1 == num2[0]))
			System.out.print("Passed.\n\n");
		else
			System.out.print("Failed.\n\n");
	}

	public void test1() {
		int[] data = { 2, 4, 3, 6, 3, 2, 5, 5 };
		test("Test1", data, 4, 6);
	}

	public void test2() {
		int[] data = { 4, 6 };
		test("Test2", data, 4, 6);
	}

	public void test3() {
		int[] data = { 4, 6, 1, 1, 1, 1 };
		test("Test3", data, 4, 6);
	}

	public static void main(String[] args) {
		NumbersAppearOnce n = new NumbersAppearOnce();
		n.test1();
		n.test2();
		n.test3();

	}

}

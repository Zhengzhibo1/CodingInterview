//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题44：数字序列中某一位的数字
// 题目：数字以0123456789101112131415…的格式序列化到一个字符序列中。在这
// 个序列中，第5位（从0开始计数）是5，第13位是1，第19位是4，等等。请写一
// 个函数求任意位对应的数字。

//==================================================================
//DigitsInSequence.java

public class DigitsInSequence {

// ====================算法实现======================
	public int digitAtIndex(int index) {
		if (index < 0) {
			return -1;
		}
		int digits = 1;

		while (true) {
			int numbers = countOfIntegers(digits);
			if (index < numbers * digits) {
				return digitAtIndex(index, digits);
			}
			index -= digits * numbers;
			digits++;
		}

	}

	// 得到m位的数字总个数
	public int countOfIntegers(int digits) {
		if (digits == 1) {
			return 10;
		}
		int count = (int) Math.pow(10, (digits - 1));
		return 9 * count;
	}

	// 找出数字
	public int digitAtIndex(int index, int digits) {
		int number = beginNumber(digits) + index / digits;
		int indexFromRight = digits - index % digits;
		for (int i = 1; i < indexFromRight; ++i) {
			number /= 10;
		}
		number %= 10;
		return number;
	}

	// 找到m位数的第一个数字
	public int beginNumber(int digits) {
		if (digits == 1) {
			return 0;
		}
		return (int) Math.pow(10, (digits - 1));
	}

// ====================测试代码======================

	public void test(String testName, int inputIndex, int expectedOutput) {
		if (digitAtIndex(inputIndex) == expectedOutput)
			System.out.println("Passed!");
		else
			System.out.println("FAILED!");
	}

	public static void main(String[] args) {
		DigitsInSequence d = new DigitsInSequence();
		d.test("Test1", 0, 0);
		d.test("Test2", 1, 1);
		d.test("Test3", 9, 9);
		d.test("Test4", 10, 1);
		d.test("Test5", 189, 9); // 数字99的最后一位，9
		d.test("Test6", 190, 1); // 数字100的第一位，1
		d.test("Test7", 1000, 3); // 数字370的第一位，3
		d.test("Test8", 1001, 7); // 数字370的第二位，7
		d.test("Test9", 1002, 0); // 数字370的第三位，0

	}

}

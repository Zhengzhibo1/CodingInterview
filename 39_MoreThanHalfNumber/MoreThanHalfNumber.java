//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题38：字符串的排列
// 题目：输入一个字符串，打印出该字符串中字符的所有排列。例如输入字符串abc，
// 则打印出由字符a、b、c所能排列出来的所有字符串abc、acb、bac、bca、cab和cba。
// 牛客网该题条件：含重复字符，且输出按字典排序

//==================================================================
//MoreThanHalfNumber.java

import java.util.Random;

public class MoreThanHalfNumber {

// =====================算法实现===================
// 方法1：
	// 基于快速排序算法找出数组中间的数字
	// 因为当一个数字在数组中出现次数超过一半时，
	// 该数字一定出现在中位数的位置。
	public int moreThanHalfNum_Solution(int[] array) {
		if (checkInvalidArray(array)) {
			return 0;
		}

		int length = array.length;
		int middle = length >> 1;
		int start = 0;
		int end = length - 1;
		int index = partition(array, length, start, end);
		while (index != middle) {
			if (index > middle) {
				end = index - 1;
				index = partition(array, length, start, end);
				if (g_bInputInvalid == true) {
					return 0;
				}
			} else {
				start = index + 1;
				index = partition(array, length, start, end);
				if (g_bInputInvalid == true) {
					return 0;
				}
			}
		}

		int result = array[index];
		if (!checkMoreThanHalf(array, result)) {
			result = 0;
		}
		return result;
	}

	// 判断数组是否符合条件，若不符合条件，则通过全部变量告知
	public boolean g_bInputInvalid = false;

	public boolean checkInvalidArray(int[] array) {
		g_bInputInvalid = false;
		if (array == null || array.length <= 0) {
			g_bInputInvalid = true;
		}
		return g_bInputInvalid;
	}

	// 判断找出的数字是否在数组中出现的次数超过一半
	public boolean checkMoreThanHalf(int[] array, int number) {
		int times = 0;
		for (int i = 0; i < array.length; ++i) {
			if (array[i] == number) {
				times++;
			}
		}

		boolean isMoreThanHalf = true;
		if (times * 2 <= array.length) {
			isMoreThanHalf = false;
			g_bInputInvalid = true;
		}
		return isMoreThanHalf;
	}

	// 快速排序算法
	int partition(int array[], int length, int start, int end) {
		if (array == null || length <= 0 || start < 0 || end > length) {
			g_bInputInvalid = true;
			return 0;
		}

		// 生产随机数，先根据end与start之间的长度生成0~该值的随机数
		// 然后加上start的值，即为start~end之间的随机数
		// random.nextInt(10)生成0~9之间的随机数
		Random random = new Random();
		int index = random.nextInt(end - start + 1) + start;
		swap(array, index, end);

		int small = start - 1;
		for (index = start; index < end; ++index) {
			if (array[index] < array[end]) {
				++small;
				if (small != index) {
					swap(array, small, index);
				}
			}
		}

		small++;
		swap(array, small, end);

		return small;
	}

	// 交换数组中的两个数字
	public void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}

//方法二：
	public int moreThanHalfNum_Solution_2(int[] array) {
		if (checkInvalidArray(array)) {
			return 0;
		}
		int result = array[0];
		int times = 1;

		for (int i = 1; i < array.length; ++i) {

			if (times == 0) {
				result = array[i];
				times = 1;
			} else if (array[i] == result) {
				times++;
			} else {
				times--;
			}

		}
		
		if (!checkMoreThanHalf(array, result)) {
			result = 0;
		}
		return result;
	}

// ====================测试代码============================
	
	public void test(String testName, int[] numbers, int length, int expectedValue, boolean expectedFlag)
	{
	    if(testName != null)
	        System.out.printf("%s begins: \n", testName);

	    int[] copy = new int[length];
	    for(int i = 0; i < length; ++i)
	        copy[i] = numbers[i];

	    System.out.print("Test for solution1: ");
	    int result = moreThanHalfNum_Solution(numbers);
	    if(result == expectedValue && g_bInputInvalid == expectedFlag)
	        System.out.print("Passed.\n");
	    else
	    	System.out.print("Failed.\n");

	    System.out.print("Test for solution2: ");
	    result = moreThanHalfNum_Solution_2(copy);
	    if(result == expectedValue && g_bInputInvalid == expectedFlag)
	    	System.out.print("Passed.\n");
	    else
	    	System.out.print("Failed.\n");
	}

	// 存在出现次数超过数组长度一半的数字
	public void test1()
	{
	    int numbers[] = {1, 2, 3, 2, 2, 2, 5, 4, 2};
	    test("Test1", numbers, numbers.length, 2, false);
	}

	// 不存在出现次数超过数组长度一半的数字
	public void test2()
	{
	    int numbers[] = {1, 2, 3, 2, 4, 2, 5, 2, 3};
	    test("Test2", numbers, numbers.length, 0, true);
	}

	// 出现次数超过数组长度一半的数字都出现在数组的前半部分
	public void test3()
	{
	    int numbers[] = {2, 2, 2, 2, 2, 1, 3, 4, 5};
	    test("Test3", numbers, numbers.length, 2, false);
	}

	// 出现次数超过数组长度一半的数字都出现在数组的后半部分
	public void test4()
	{
	    int numbers[] = {1, 3, 4, 5, 2, 2, 2, 2, 2};
	    test("Test4", numbers, numbers.length, 2, false);
	}

	// 输入数组只有一个数字
	public void test5()
	{
	   int numbers[] = {1};
	   test("Test5", numbers, 1, 1, false);
	}

	// 输入空指针
	public void test6()
	{
	    test("Test6", null, 0, 0, true);
	}

	public static void main(String[] args) {
		MoreThanHalfNumber m = new MoreThanHalfNumber();
		m.test1();
		m.test2();
		m.test3();
		m.test4();
		m.test5();
		m.test6();

	}

}

//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题21：调整数组顺序使奇数位于偶数前面
// 题目：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有
// 奇数位于数组的前半部分，所有偶数位于数组的后半部分。

//==================================================================
//ReorderArray.java

public class ReorderArray {

// =================算法实现=======================
	// 方法1：仅调整数组顺序使奇数位于偶数前面
	public void reOrderArray1(int[] array) {
		if (array == null) {
			return;
		}

		int beforeIndex = 0;
		int afterIndex = array.length - 1;

		while (beforeIndex < afterIndex) {
			// 向前移动指针，直到指到偶数为止
			while (beforeIndex < afterIndex && !isEven(array[beforeIndex])) {
				beforeIndex++;
			}
			// 向后移动指针，直到指到奇数为止
			while (beforeIndex < afterIndex && isEven(array[afterIndex])) {
				afterIndex--;
			}

			if (beforeIndex < afterIndex) {
				int temp = array[beforeIndex];
				array[beforeIndex] = array[afterIndex];
				array[afterIndex] = temp;
			}
		}
	}

	// 方法2：调整数组数组顺序使奇数位于偶数前面的同时，不改变奇数与奇数，偶数与偶数的相对位置
	/*
	 * 1.要想保证原有次序，则只能顺次移动或相邻交换。 
	 * 2.i从左向右遍历，找到第一个偶数。 
	 * 3.j从i+1开始向后找，直到找到第一个奇数。
	 * 4.将[i,...,j-1]的元素整体后移一位，最后将找到的奇数放入i位置，然后i++。 
	 * 5.終止條件：j向後遍歷查找失敗。
	 */
	public void reOrderArray2(int[] array) {
		if (array == null) {
			return;
		}
		int beforeIndex = 0;
		int afterIndex;
		while (beforeIndex < array.length) {
			while (beforeIndex < array.length && !isEven(array[beforeIndex])) {
				beforeIndex++;
			}

			afterIndex = beforeIndex + 1;
			while (afterIndex < array.length && isEven(array[afterIndex])) {
				afterIndex++;
			}
			if (afterIndex < array.length) {
				int temp = array[afterIndex];
				for (int i = afterIndex - 1; i >= beforeIndex; --i) {
					array[i + 1] = array[i];
				}
				array[beforeIndex++] = temp;
			} else {
				break;
			}
		}
	}

// ================公共函数============================
	// 判断是否为偶数
	public boolean isEven(int n) {
		return (n & 0x1) == 0;
	}
// ==================测试代码==========================

	public void test1() {
		System.out.print("Test1: ");
		int numbers[] = { 1, 2, 3, 4, 5, 6, 7 };
		reOrderArray2(numbers);
		for (int i = 0; i < numbers.length; ++i) {
			System.out.print(numbers[i]);
		}
		System.out.println();
	}

	void test2() {
		System.out.print("Test2: ");
		int numbers[] = { 2, 4, 6, 1, 3, 5, 7 };
		reOrderArray1(numbers);
		for (int i = 0; i < numbers.length; ++i) {
			System.out.print(numbers[i]);
		}
		System.out.println();
	}

	void test3() {
		System.out.print("Test3: ");
		int numbers[] = { 1, 3, 5, 7, 2, 4, 6 };
		reOrderArray1(numbers);
		for (int i = 0; i < numbers.length; ++i) {
			System.out.print(numbers[i]);
		}
		System.out.println();
	}

	void test4() {
		System.out.print("Test4: ");
		int numbers[] = { 1 };
		reOrderArray1(numbers);
		for (int i = 0; i < numbers.length; ++i) {
			System.out.print(numbers[i]);
		}
		System.out.println();
	}

	void test5() {
		System.out.print("Test5: ");
		int numbers[] = { 2 };
		reOrderArray1(numbers);
		for (int i = 0; i < numbers.length; ++i) {
			System.out.print(numbers[i]);
		}
		System.out.println();
	}

	void test6() {
		System.out.print("Test6: ");
		int numbers[] = null;
		reOrderArray1(numbers);
		System.out.println();
	}

	public static void main(String[] args) {
		ReorderArray r = new ReorderArray();
		r.test1();
		r.test2();
		r.test3();
		r.test4();
		r.test5();
		r.test6();

	}

}

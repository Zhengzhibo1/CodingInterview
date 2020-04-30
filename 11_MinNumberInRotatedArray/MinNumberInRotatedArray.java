//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题11：旋转数组的最小数字
// 题目：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
// 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如数组
// {3, 4, 5, 1, 2}为{1, 2, 3, 4, 5}的一个旋转，该数组的最小值为1。

// 思路：采用二分查找，采用两个索引分别指向头与尾，若中间节点大于头，说明中间节点在第一个子数组中，
// 则头索引指向中间节点，若中间节点小于尾，则将尾索引指向中间节点，直到两索引间隔为1时，尾索引值即为最小值。
// 特殊情况：头、尾、中间节点的值均相等时，采用顺序查找方式。
//==================================================================
//MinNumberInRotatedArray.java

public class MinNumberInRotatedArray {

// ==================算法实现===================
	public int Min(int[] numbers, int length) throws Exception {
		if (numbers == null || length <= 0) {
			throw new Exception("Invalid parameters");
		}

		int index1 = 0;
		int index2 = length - 1;
		int indexMid = index1;

		while (numbers[index1] >= numbers[index2]) {

			// 如果index1和index2指向相邻的两个数，
			// 则index1指向第一个递增子数组的最后一个数字，
			// index2指向第二个子数组的第一个数字，也就是数组中的最小数字
			if (index2 - index1 == 1) {
				return numbers[index2];
//				indexMid = index2;
//				break;
			}

			// 如果下标为index1、index2和indexMid指向的三个数字相等，
			// 则只能顺序查找
			indexMid = (index2 + index1) / 2;
			if (numbers[index1] == numbers[index2] && numbers[indexMid] == numbers[index1]) {
				return MinInorder(numbers, index1, index2);
			}

			// 缩小查找范围
			if (numbers[index1] <= numbers[indexMid]) {
				index1 = indexMid;
			} else if (numbers[index2] >= numbers[indexMid]) {
				index2 = indexMid;
			}
		}
		return numbers[indexMid];
	}

	public int MinInorder(int[] numbers, int index1, int index2) {
		int result = numbers[index1];
		for (int i = index1; i < index2; ++i) {
			if (result > numbers[i]) {
				result = numbers[i];
			}
		}
		return result;
	}

// ==================测试代码========================
	// 典型输入，单调升序的数组的一个旋转
	public void Test1() {
		int[] array = { 3, 4, 5, 1, 2 };
		int result = 0;
		try {
			result = Min(array, array.length);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Test2结果为：" + result);
	}

	// 有重复数字，并且重复的数字刚好的最小的数字
	public void Test2() {
		int[] array = { 3, 4, 5, 1, 1, 2 };
		int result = 0;
		try {
			result = Min(array, array.length);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Test2结果为：" + result);
	}

	// 有重复数字，但重复的数字不是第一个数字和最后一个数字
	public void Test3() {
		int[] array = { 3, 4, 5, 1, 2, 2 };
		int result = 0;
		try {
			result = Min(array, array.length);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Test3结果为：" + result);
	}

	// 有重复的数字，并且重复的数字刚好是第一个数字和最后一个数字
	public void Test4() {
		int[] array = { 1, 0, 1, 1, 1 };
		int result = 0;
		try {
			result = Min(array, array.length);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Test4结果为：" + result);
	}

	// 单调升序数组，旋转0个元素，也就是单调升序数组本身
	public void Test5() {
		int[] array = { 1, 2, 3, 4, 5 };
		int result = 0;
		try {
			result = Min(array, array.length);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Test5结果为：" + result);
	}

	// 数组中只有一个数字
	public void Test6() {
		int[] array = { 2 };
		int result = 0;
		try {
			result = Min(array, array.length);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Test6结果为：" + result);
	}

	// 输入null
	public void Test7() {
		int result = 0;
		try {
			result = Min(null, 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Test7结果为：" + result);
	}

	public static void main(String[] args) {
		MinNumberInRotatedArray m = new MinNumberInRotatedArray();
		m.Test1();
		m.Test2();
		m.Test3();
		m.Test4();
		m.Test5();
		m.Test6();
		m.Test7();
	}

}

//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题3（一）：找出数组中重复的数字
// 题目：在一个长度为n的数组里的所有数字都在0到n-1的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，
// 也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。例如，如果输入长度为7的数组{2, 3, 1, 0, 2, 5, 3}，
// 那么对应的输出是重复的数字2或者3。
// 思路：对数组的每个元素按下标比对，即该元素的值与下标是否一致
// 若不一致，则比较该元素作为下标时所对应的元素值，若相等，则该元素重复，找出；若不等，则调换这两元素位置。
//==================================================================
public class FindDuplication {

	public boolean duplicate(int numbers[], int length, int duplication[]) {

		if (numbers == null || length <= 0) {
			return false;
		}

		for (int i = 0; i < length; ++i) {
			if (numbers[i] < 0 || numbers[i] > length - 1) {
				return false;
			}
		}

		for (int i = 0; i < length; ++i) {
			while (numbers[i] != i) {
				if (numbers[i] == numbers[numbers[i]]) {
					duplication[0] = numbers[i];
					return true;
				} else {
					int temp = numbers[i];
					numbers[i] = numbers[temp];
					numbers[temp] = temp;
				}
			}
		}
		return false;
	}

	// 测试代码
	// 重复的数字是数组中最大的数字
	public void test1() {
		int[] numbers = { 2, 1, 3, 1, 4 };
		int[] duplication = new int[1];
		boolean validInput = duplicate(numbers, numbers.length, duplication);
		if (validInput == true) {
			System.out.println("test1重复的数字为：" + duplication[0]);
		}
	}

	// 重复的数字是数组中最大的数字
	void test2() {
		int[] numbers = { 2, 4, 3, 1, 4 };
		int[] duplication = new int[1];
		boolean validInput = duplicate(numbers, numbers.length, duplication);
		if (validInput == true) {
			System.out.println("test2重复的数字为：" + duplication[0]);
		}
	}

	// 数组中存在多个重复的数字
	void test3() {
		int[] numbers = { 2, 4, 2, 1, 4 };
		int[] duplication = new int[1];
		boolean validInput = duplicate(numbers, numbers.length, duplication);
		if (validInput == true) {
			System.out.println("test3重复的数字为：" + duplication[0]);
		}
	}

	// 没有重复的数字
	void test4() {
		int[] numbers = { 2, 1, 3, 0, 4 };
		int[] duplication = new int[1];
		boolean validInput = duplicate(numbers, numbers.length, duplication);
		if (validInput == true) {
			System.out.println("test4重复的数字为：" + duplication[0]);
		} else {
			System.out.println("Failed！");
		}
	}

	// 没有重复的数字
	void test5() {
		int numbers[] = { 2, 1, 3, 5, 4 };
		int[] duplication = new int[1];
		boolean validInput = duplicate(numbers, numbers.length, duplication);
		if (validInput == true) {
			System.out.println("test4重复的数字为：" + duplication[0]);
		} else {
			System.out.println("Failed！");
		}
	}

	// 无效的输入
	void test6() {
		int[] numbers = null;
		int[] duplication = new int[1];
		boolean validInput = duplicate(numbers, 6, duplication); //因为输入的数组为空，故数组长度随便给
		if (validInput == true) {
			System.out.println("test4重复的数字为：" + duplication[0]);
		} else {
			System.out.println("Failed！");
		}
	}

	public static void main(String[] args) {
		FindDuplication findDuplication = new FindDuplication();
		findDuplication.test1();
		findDuplication.test2();
		findDuplication.test3();
		findDuplication.test4();
		findDuplication.test5();
		findDuplication.test6();
	}

}


//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题3（二）：不修改数组找出重复的数字
// 题目：在一个长度为n+1的数组里的所有数字都在1到n的范围内，所以数组中至
// 少有一个数字是重复的。请找出数组中任意一个重复的数字，但不能修改输入的
// 数组。例如，如果输入长度为8的数组{2, 3, 5, 4, 3, 2, 6, 7}，那么对应的
// 输出是重复的数字2或者3。
// 思路：按输入的数字范围对半分，比对两部分内的数字出现总次数是否超出该范围的长度。。
// 若超出，则表示重复数字在该部分，然后重复操作，直至找出重复数字为止。
// 例如：{2, 3, 5, 4, 3, 2, 6, 7}，数字范围1-7，分为1-4，5-7两部分，1-4中数字出现次数为5次，
// 超过数字个数4，故存在重复数字，将其继续分为1-2，3-4两部分，继续操作。
//==================================================================
public class FindDuplicationNoEdit {

	public int getDuplication(int numbers[], int length) {
		if(numbers == null || length <= 0) {
			return -1;
		}
		int start = 1;
		int end = length - 1 ;
		while(end >= start) {
			int middle = ((end - start) >> 1) + start; //二进制向右移动一位
			int count = countRange(numbers, length, start, middle);
			if(end == start) {
				if(count > 1) {
					return start;
				}else {
					break;
				}
			}
			
			if(count > (middle - start + 1)) {
				end = middle;
			}else {
				start = middle + 1;
			}
		}
		return -1;
	}
	
	public int countRange(int numbers[], int length, int start, int middle) {
		if(numbers == null) {
			return 0;
		}
		int count = 0;
		for(int i = 0; i < length; ++i) {
			if(numbers[i] >= start && numbers[i] <= middle) {
				++count;
			}
		}
		return count;
	}
	
	// 测试代码
	// 重复的数字是数组中最大的数字
	public void test1() {
		int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 1, 8 };
		int validInput = getDuplication(numbers, numbers.length);
		if (validInput != -1) {
			System.out.println("test1重复的数字为：" + validInput);
		}
	}

	// 重复的数字是数组中最大的数字
	void test2() {
		int[] numbers = { 1, 7, 3, 4, 5, 6, 8, 2, 8 };
		int validInput = getDuplication(numbers, numbers.length);
		if (validInput != -1) {
			System.out.println("test2重复的数字为：" + validInput);
		}
	}

	// 数组中存在多个重复的数字
	void test3() {
		int[] numbers = { 2, 3, 5, 4, 3, 2, 6, 7 };
		int validInput = getDuplication(numbers, numbers.length);
		if (validInput != -1) {
			System.out.println("test3重复的数字为：" + validInput);
		}
	}

	// 没有重复的数字
	void test4() {
		int[] numbers = { 2, 1, 3, 0, 4 };
		int validInput = getDuplication(numbers, numbers.length);
		if (validInput != -1) {
			System.out.println("test4重复的数字为：" + validInput);
		}else {
			System.out.println("Failed！");
		}
	}

	// 没有重复的数字
	void test5() {
		int numbers[] = { 2, 1, 3, 5, 4 };
		int validInput = getDuplication(numbers, numbers.length);
		if (validInput != -1) {
			System.out.println("test5重复的数字为：" + validInput);
		}else {
			System.out.println("Failed！");
		}
	}

	// 无效的输入
	void test6() {
		int[] numbers = null;
		int validInput = getDuplication(numbers, 6); // 因为输入的数组为空，故数组长度随便给
		if (validInput != -1) {
			System.out.println("test6重复的数字为：" + validInput);
		}else {
			System.out.println("Failed！");
		}
	}
	
	// 数组中只有两个数字
	void test7()
	{
	    int numbers[] = { 1, 1 };
		int validInput = getDuplication(numbers, numbers.length);
		if (validInput != -1) {
			System.out.println("test7重复的数字为：" + validInput);
		}
	}
	
	// 一个数字重复三次
	void test8()
	{
	    int numbers[] = { 1, 2, 2, 6, 4, 5, 2 };
		int validInput = getDuplication(numbers, numbers.length);
		if (validInput != -1) {
			System.out.println("test8重复的数字为：" + validInput);
		}
	}
	
	public static void main(String[] args) {
		FindDuplicationNoEdit findDuplicationNoEdit = new FindDuplicationNoEdit();
		findDuplicationNoEdit.test1();
		findDuplicationNoEdit.test2();
		findDuplicationNoEdit.test3();
		findDuplicationNoEdit.test4();
		findDuplicationNoEdit.test5();
		findDuplicationNoEdit.test6();
		findDuplicationNoEdit.test7();
		findDuplicationNoEdit.test8();

	}

}

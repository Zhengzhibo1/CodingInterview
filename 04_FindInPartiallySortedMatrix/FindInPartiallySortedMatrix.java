//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题4：二维数组中的查找
// 题目：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按
// 照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个
// 整数，判断数组中是否含有该整数。
// 思路：从二维数组左上角或者右下角开始判断；
// 以左上角为例，若目标数字小于左上角数字，则最后一列不存在目标数字，删除；
// 若目标数组大于左上角数字，则第一行不存在目标数字，删除；
// 如此循环最终找出目标数字是否在数组中。
//==================================================================
public class FindInPartiallySortedMatrix {

	public boolean Find(int matrix[][], int rows, int columns, int number) {
		boolean found = false;
		if (matrix != null && rows > 0 && columns > 0) {
			int i = 0;
			int j = columns - 1;
			while (i < rows && j >= 0) {
				if (number == matrix[i][j]) {
					found = true;
					break;
				} else if (number < matrix[i][j]) {
					--j;
				} else {
					++i;
				}
			}
		}

		return found;
	}

// ================测试代码====================

//  1   2   8   9
//  2   4   9   12
//  4   7   10  13
//  6   8   11  15
// 要查找的数在数组中
	void Test1() {
		int[][] matrix = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 }, { 6, 8, 11, 15 } };
		boolean result = Find(matrix, matrix.length, matrix[0].length, 7);
		if (result == true) {
			System.out.println("Test1: Passed！");
		} else {
			System.out.println("Test1: Failed！");
		}
	}

//  1   2   8   9
//  2   4   9   12
//  4   7   10  13
//  6   8   11  15
// 要查找的数不在数组中
	void Test2() {
		int matrix[][] = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 }, { 6, 8, 11, 15 } };
		boolean result = Find(matrix, matrix.length, matrix[0].length, 5);
		if (result == true) {
			System.out.println("Test2: Passed！");
		} else {
			System.out.println("Test2: Failed！");
		}
	}

//  1   2   8   9
//  2   4   9   12
//  4   7   10  13
//  6   8   11  15
// 要查找的数是数组中最小的数字
	void Test3() {
		int matrix[][] = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 }, { 6, 8, 11, 15 } };
		boolean result = Find(matrix, matrix.length, matrix[0].length, 1);
		if (result == true) {
			System.out.println("Test3: Passed！");
		} else {
			System.out.println("Test3: Failed！");
		}
	}

//  1   2   8   9
//  2   4   9   12
//  4   7   10  13
//  6   8   11  15
// 要查找的数是数组中最大的数字
	void Test4() {
		int matrix[][] = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 }, { 6, 8, 11, 15 } };
		boolean result = Find(matrix, matrix.length, matrix[0].length, 15);
		if (result == true) {
			System.out.println("Test4: Passed！");
		} else {
			System.out.println("Test4: Failed！");
		}
	}
	
//  1   2   8   9
//  2   4   9   12
//  4   7   10  13
//  6   8   11  15
// 要查找的数比数组中最小的数字还小
	void Test5() {
		int matrix[][] = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 }, { 6, 8, 11, 15 } };
		boolean result = Find(matrix, matrix.length, matrix[0].length, 0);
		if (result == true) {
			System.out.println("Test5: Passed！");
		} else {
			System.out.println("Test5: Failed！");
		}
	}

//  1   2   8   9
//  2   4   9   12
//  4   7   10  13
//  6   8   11  15
// 要查找的数比数组中最大的数字还大
	void Test6() {
		int matrix[][] = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 }, { 6, 8, 11, 15 } };
		boolean result = Find(matrix, matrix.length, matrix[0].length, 16);
		if (result == true) {
			System.out.println("Test6: Passed！");
		} else {
			System.out.println("Test6: Failed！");
		}
	}
	
	// 鲁棒性测试，输入空
	void Test7() {
		boolean result = Find(null, 0, 0, 16);
		if (result == true) {
			System.out.println("Test7: Passed！");
		} else {
			System.out.println("Test7: Failed！");
		}
	}

	public static void main(String[] args) {
		FindInPartiallySortedMatrix findInPartiallySortedMatrix = new FindInPartiallySortedMatrix();
		findInPartiallySortedMatrix.Test1();
		findInPartiallySortedMatrix.Test2();
		findInPartiallySortedMatrix.Test3();
		findInPartiallySortedMatrix.Test4();
		findInPartiallySortedMatrix.Test5();
		findInPartiallySortedMatrix.Test6();
		findInPartiallySortedMatrix.Test7();
	}

}

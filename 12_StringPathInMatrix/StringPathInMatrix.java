 //==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题12：矩阵中的路径
// 题目：请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有
// 字符的路径。路径可以从矩阵中任意一格开始，每一步可以在矩阵中向左、右、
// 上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入
// 该格子。例如在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字
// 母用下划线标出）。但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个
// 字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
// A B T G
// C F C S
// J D E H

// 思路：回溯法
//==================================================================
//StringPathInMatrix.java

package stringPathInMatrix;

public class StringPathInMatrix {

// =============算法实现=================
	public boolean hasPath(char[][] matrix, int rows, int cols, char[] str) {

		if (matrix == null || rows < 1 || cols < 1 || str == null) {
			return false;
		}
		boolean[][] visited = new boolean[rows][cols];

		int pathLength = 0;
		for (int row = 0; row < rows; ++row) {
			for (int col = 0; col < cols; ++col) {
				if (hasPathCore(matrix, rows, cols, row, col, str, pathLength, visited)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean hasPathCore(char[][] matrix, int rows, int cols, int row, int col, char[] str, int pathLength,
			boolean[][] visited) {

		if (pathLength == str.length) {
			return true;
		}

		boolean hasPath = false;
		if (row >= 0 && row < rows && col >= 0 && col < cols && matrix[row][col] == str[pathLength]
				&& !visited[row][col]) {
			++pathLength;
			visited[row][col] = true;

			hasPath = hasPathCore(matrix, rows, cols, row, col - 1, str, pathLength, visited)
					|| hasPathCore(matrix, rows, cols, row - 1, col, str, pathLength, visited)
					|| hasPathCore(matrix, rows, cols, row + 1, col, str, pathLength, visited)
					|| hasPathCore(matrix, rows, cols, row, col + 1, str, pathLength, visited);

			if (hasPath != true) {
				--pathLength;
				visited[row][col] = false;
			}
		}

		return hasPath;
	}

// =========================测试代码========================
	// ABCE
	// SFCS
	// ADEE

	// SEE
	public void Test1() {
		char[][] matrix = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		char[] str = { 'S', 'E', 'E' };
		boolean realResult = true;
		boolean result = hasPath(matrix, matrix.length, matrix[0].length, str);
		if (result == realResult) {
			System.out.println("Test1结果正确");
		}else {
			System.out.println("Test1结果不正确");
		}
	}

	// ABTG
	// CFCS
	// JDEH

	// BFCE
	public void Test2() {
		char[][] matrix = { { 'A', 'B', 'T', 'G' }, { 'C', 'F', 'C', 'S' }, { 'J', 'D', 'E', 'H' } };
		char[] str = { 'B', 'F', 'C', 'E' };
		boolean realResult = true;
		boolean result = hasPath(matrix, matrix.length, matrix[0].length, str);
		if (result == realResult) {
			System.out.println("Test2结果正确");
		}else {
			System.out.println("Test2结果不正确");
		}
	}

	// ABTG
	// CFCS
	// JDEH

	// ABFB
	public void Test3() {
		char[][] matrix = { { 'A', 'B', 'T', 'G' }, { 'C', 'F', 'C', 'S' }, { 'J', 'D', 'E', 'H' } };
		char[] str = { 'A', 'B', 'F', 'B' };
		boolean realResult = false;
		boolean result = hasPath(matrix, matrix.length, matrix[0].length, str);
		if (result == realResult) {
			System.out.println("Test3结果正确");
		}else {
			System.out.println("Test3结果不正确");
		}
	}

	// ABCEHJIG
	// SFCSLOPQ
	// ADEEMNOE
	// ADIDEJFM
	// VCEIFGGS

	// SLHECCEIDEJFGGFIE
	public void Test4() {
		char[][] matrix = { { 'A', 'B', 'C', 'E', 'H', 'J', 'I', 'G' }, { 'S', 'F', 'C', 'S', 'L', 'O', 'P', 'Q' },
				{ 'A', 'D', 'E', 'E', 'M', 'N', 'O', 'E' }, { 'A', 'D', 'I', 'D', 'E', 'J', 'F', 'M' },
				{ 'V', 'C', 'E', 'I', 'F', 'G', 'G', 'S' } };
		char[] str = { 'S', 'L', 'H', 'E', 'C', 'C', 'E', 'I', 'D', 'E', 'J', 'F', 'G', 'G', 'F', 'I', 'E' };
		boolean realResult = true;
		boolean result = hasPath(matrix, matrix.length, matrix[0].length, str);
		if (result == realResult) {
			System.out.println("Test4结果正确");
		}else {
			System.out.println("Test4结果不正确");
		}
	}

	// ABCEHJIG
	// SFCSLOPQ
	// ADEEMNOE
	// ADIDEJFM
	// VCEIFGGS

	// SGGFIECVAASABCEHJIGQEM
	public void Test5() {
		char[][] matrix = { { 'A', 'B', 'C', 'E', 'H', 'J', 'I', 'G' }, { 'S', 'F', 'C', 'S', 'L', 'O', 'P', 'Q' },
				{ 'A', 'D', 'E', 'E', 'M', 'N', 'O', 'E' }, { 'A', 'D', 'I', 'D', 'E', 'J', 'F', 'M' },
				{ 'V', 'C', 'E', 'I', 'F', 'G', 'G', 'S' } };
		char[] str = { 'S', 'G', 'G', 'F', 'I', 'E', 'C', 'V', 'A', 'A', 'S', 'A', 'B', 'C', 'E', 'H', 'J', 'I', 'G',
				'Q', 'E', 'M' };
		boolean realResult = true;
		boolean result = hasPath(matrix, matrix.length, matrix[0].length, str);
		if (result == realResult) {
			System.out.println("Test5结果正确");
		}else {
			System.out.println("Test5结果不正确");
		}
	}

	// ABCEHJIG
	// SFCSLOPQ
	// ADEEMNOE
	// ADIDEJFM
	// VCEIFGGS

	// SGGFIECVAASABCEEJIGOEM
	public void Test6() {
		char[][] matrix = { { 'A', 'B', 'C', 'E', 'H', 'J', 'I', 'G' }, { 'S', 'F', 'C', 'S', 'L', 'O', 'P', 'Q' },
				{ 'A', 'D', 'E', 'E', 'M', 'N', 'O', 'E' }, { 'A', 'D', 'I', 'D', 'E', 'J', 'F', 'M' },
				{ 'V', 'C', 'E', 'I', 'F', 'G', 'G', 'S' } };
		char[] str = { 'S', 'G', 'G', 'F', 'I', 'E', 'C', 'V', 'A', 'A', 'S', 'A', 'B', 'C', 'E', 'E', 'J', 'I', 'G',
				'O', 'E', 'M' };
		boolean realResult = false;
		boolean result = hasPath(matrix, matrix.length, matrix[0].length, str);
		if (result == realResult) {
			System.out.println("Test6结果正确");
		}else {
			System.out.println("Test6结果不正确");
		}
	}

	// ABCEHJIG
	// SFCSLOPQ
	// ADEEMNOE
	// ADIDEJFM
	// VCEIFGGS

	// SGGFIECVAASABCEHJIGQEMS
	public void Test7() {
		char[][] matrix = { { 'A', 'B', 'C', 'E', 'H', 'J', 'I', 'G' }, { 'S', 'F', 'C', 'S', 'L', 'O', 'P', 'Q' },
				{ 'A', 'D', 'E', 'E', 'M', 'N', 'O', 'E' }, { 'A', 'D', 'I', 'D', 'E', 'J', 'F', 'M' },
				{ 'V', 'C', 'E', 'I', 'F', 'G', 'G', 'S' } };
		char[] str = { 'S', 'G', 'G', 'F', 'I', 'E', 'C', 'V', 'A', 'A', 'S', 'A', 'B', 'C', 'E', 'H', 'J', 'I', 'G',
				'Q', 'E', 'M', 'S' };
		boolean realResult = false;
		boolean result = hasPath(matrix, matrix.length, matrix[0].length, str);
		if (result == realResult) {
			System.out.println("Test7结果正确");
		}else {
			System.out.println("Test7结果不正确");
		}
	}

	// AAAA
	// AAAA
	// AAAA

	// AAAAAAAAAAAA
	public void Test8() {
		char[][] matrix = { { 'A', 'A', 'A', 'A' }, { 'A', 'A', 'A', 'A' }, { 'A', 'A', 'A', 'A' } };
		char[] str = { 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A' };
		boolean realResult = true;
		boolean result = hasPath(matrix, matrix.length, matrix[0].length, str);
		if (result == realResult) {
			System.out.println("Test8结果正确");
		}else {
			System.out.println("Test8结果不正确");
		}
	}
	
	//A

	//A
	public void Test9() {
		char[][] matrix = { { 'A' } };
		char[] str = { 'A' };
		boolean realResult = true;
		boolean result = hasPath(matrix, matrix.length, matrix[0].length, str);
		if (result == realResult) {
			System.out.println("Test9结果正确");
		}else {
			System.out.println("Test9结果不正确");
		}
	}
	
	//A

	//A
	public void Test10() {
		char[][] matrix = { { 'A' } };
		char[] str = { 'B' };
		boolean realResult = false;
		boolean result = hasPath(matrix, matrix.length, matrix[0].length, str);
		if (result == realResult) {
			System.out.println("Test10结果正确");
		}else {
			System.out.println("Test10结果不正确");
		}
	}
	
	public void Test11() {
		boolean realResult = false;
		boolean result = hasPath(null, 0, 0, null);
		if (result == realResult) {
			System.out.println("Test10结果正确");
		}else {
			System.out.println("Test10结果不正确");
		}
	}

	public static void main(String[] args) {

		StringPathInMatrix s = new StringPathInMatrix();
		s.Test1();
		s.Test2();
		s.Test3();
		s.Test4();
		s.Test5();
		s.Test6();
		s.Test7();
		s.Test8();
		s.Test9();
		s.Test10();
		s.Test11();
	}

}

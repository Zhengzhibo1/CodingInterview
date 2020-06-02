//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题29：顺时针打印矩阵
// 题目：输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。

//==================================================================
//PrintMatrix.java

import java.util.ArrayList;

public class PrintMatrix {

// ===================算法实现=================
	// 判断是否循环输出矩阵
	public ArrayList<Integer> printMatrix(int[][] matrix) {
		if (matrix == null) {
			return null;
		}
		ArrayList<Integer> output = new ArrayList<Integer>();
		int rows = matrix.length;
		int columns = matrix[0].length;
		int start = 0;
		while (columns > 2 * start && rows > 2 * start) {
			addToArrayList(matrix, columns, rows, start, output);
			start++;
		}

		return output;
	}

	// 输出这一环矩阵
	public void addToArrayList(int[][] matrix, int columns, int rows, int start, ArrayList<Integer> output) {
		int endX = columns - 1 - start;
		int endY = rows - 1 - start;

		// 从左到右输出
		for (int i = start; i <= endX; ++i) {
			output.add(matrix[start][i]);
		}

		// 从上到下输出
		if (start < endY) {
			for (int i = start + 1; i <= endY; ++i) {
				output.add(matrix[i][endX]);
			}
		}

		// 从右到左输出
		if (start < endY && start < endX) {
			for (int i = endX - 1; i >= start; --i) {
				output.add(matrix[endY][i]);
			}
		}
		
		// 从下到上输出
		if (start < endY -1 && start < endX) {
			for(int i = endY -1; i > start; --i) {
				output.add(matrix[i][start]);
			}
		}
	}

// ===========================测试代码=====================
	public void test(int columns, int rows)
	{
	    System.out.printf("Test Begin: %d columns, %d rows.\n", columns, rows);

	    if(columns < 1 || rows < 1)
	        return;

	    int[][] matrix = new int[rows][columns];
	    for(int i = 0; i < rows; ++i)
	    {
	        for(int j = 0; j < columns; ++j)
	        {
	        	matrix[i][j] = i * columns + j + 1;
	        }
	    }

	    ArrayList<Integer> output = printMatrix(matrix);
	    for(int i = 0; i < output.size(); ++i) {
	    	System.out.print(output.get(i) + "\t");
	    }
	    System.out.println();
	}
	public static void main(String[] args) {
		PrintMatrix p = new PrintMatrix();
		
	    /*
	    1    
	    */
	    p.test(1, 1);

	    /*
	    1    2
	    3    4
	    */
	    p.test(2, 2);

	    /*
	    1    2    3    4
	    5    6    7    8
	    9    10   11   12
	    13   14   15   16
	    */
	    p.test(4, 4);

	    /*
	    1    2    3    4    5
	    6    7    8    9    10
	    11   12   13   14   15
	    16   17   18   19   20
	    21   22   23   24   25
	    */
	    p.test(5, 5);

	    /*
	    1
	    2
	    3
	    4
	    5
	    */
	    p.test(1, 5);

	    /*
	    1    2
	    3    4
	    5    6
	    7    8
	    9    10
	    */
	    p.test(2, 5);

	    /*
	    1    2    3
	    4    5    6
	    7    8    9
	    10   11   12
	    13   14   15
	    */
	    p.test(3, 5);

	    /*
	    1    2    3    4
	    5    6    7    8
	    9    10   11   12
	    13   14   15   16
	    17   18   19   20
	    */
	    p.test(4, 5);

	    /*
	    1    2    3    4    5
	    */
	    p.test(5, 1);

	    /*
	    1    2    3    4    5
	    6    7    8    9    10
	    */
	    p.test(5, 2);

	    /*
	    1    2    3    4    5
	    6    7    8    9    10
	    11   12   13   14    15
	    */
	    p.test(5, 3);

	    /*
	    1    2    3    4    5
	    6    7    8    9    10
	    11   12   13   14   15
	    16   17   18   19   20
	    */
	    p.test(5, 4);

	}

}

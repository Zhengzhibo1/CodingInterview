//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题49：丑数
// 题目：我们把只包含因子2、3和5的数称作丑数（Ugly Number）。求按从小到
// 大的顺序的第1500个丑数。例如6、8都是丑数，但14不是，因为它包含因子7。
// 习惯上我们把1当做第一个丑数。

//==================================================================
//UglyNumber.java


public class UglyNumber {

// =====================算法实现======================	
	public int getUglyNumber_Solution(int index) {
		if (index == 0) {
			return 0;
		}
		int uglyNumbers[] = new int[index];
		uglyNumbers[0] = 1;
		int nextUglyNumberIndex = 1;

		int multiply2 = 0;
		int multiply3 = 0;
		int multiply5 = 0;

		while (nextUglyNumberIndex < index) {
			uglyNumbers[nextUglyNumberIndex] = min(uglyNumbers[multiply2] * 2, uglyNumbers[multiply3] * 3,
					uglyNumbers[multiply5] * 5);

			while (uglyNumbers[multiply2] * 2 <= uglyNumbers[nextUglyNumberIndex]) {
				multiply2++;
			}
			while (uglyNumbers[multiply3] * 3 <= uglyNumbers[nextUglyNumberIndex]) {
				multiply3++;
			}
			while (uglyNumbers[multiply5] * 5 <= uglyNumbers[nextUglyNumberIndex]) {
				multiply5++;
			}

			nextUglyNumberIndex++;
		}

		int uglynumber = uglyNumbers[nextUglyNumberIndex - 1];

		return uglynumber;
	}

	// 比较三个数中的最小数
	public int min(int number1, int number2, int number3) {
		int min = (number1 < number2) ? number1 : number2;
		return (min < number3) ? min : number3;
	}

// ====================测试代码====================
	public void test(int index, int expected) {
		if (getUglyNumber_Solution(index) == expected)
			System.out.print("solution passed\n");
		else
			System.out.print("solution failed\n");

	}

	public static void main(String[] args) {

		UglyNumber u = new UglyNumber();
		u.test(1, 1);
		u.test(2, 2);
		u.test(3, 3);
		u.test(4, 4);
		u.test(5, 5);
		u.test(6, 6);
		u.test(7, 8);
		u.test(8, 9);
		u.test(9, 10);
		u.test(10, 12);
		u.test(11, 15);
		u.test(1500, 859963392);
		u.test(0, 0);

	}

}

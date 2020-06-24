//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题65：不用加减乘除做加法
// 题目：写一个函数，求两个整数之和，要求在函数体内不得使用＋、－、×、÷
// 四则运算符号。

//==================================================================
//AddTwoNumbers.java


public class AddTwoNumbers {

// ===================算法实现=====================
	public int add(int num1, int num2) {
		int sum = 0;
		int carry = 0;

		do {
			sum = num1 ^ num2;
			carry = (num1 & num2) << 1;

			num1 = sum;
			num2 = carry;
		} while (num2 != 0);

		return num1;
	}

// ====================测试代码====================
	public void test(int num1, int num2, int expected) {
		int result = add(num1, num2);
		if (result == expected)
			System.out.printf("%d + %d is %d. Passed\n", num1, num2, result);
		else
			System.out.printf("%d + %d is %d. FAILED\n", num1, num2, result);
	}

	public static void main(String[] args) {
		AddTwoNumbers a = new AddTwoNumbers();
		a.test(1, 2, 3);
		a.test(111, 899, 1010);

		a.test(-1, 2, 1);
		a.test(1, -2, -1);

		a.test(3, 0, 3);
		a.test(0, -4, -4);

		a.test(-2, -8, -10);

	}

}

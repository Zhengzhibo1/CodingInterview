//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题16：数值的整数次方
// 题目：实现函数double Power(double base, int exponent)，求base的exponent
// 次方。不得使用库函数，同时不需要考虑大数问题。
//==================================================================
// Power.java

public class Power {

// =================算法实现===================
	public static boolean g_InvalidInput = false;
	
	public static double power(double base, int exponent) {
		
		g_InvalidInput = false;
		
		if(equal(base, 0.0) && exponent < 0) {
			g_InvalidInput = true;
			return 0.0;
		}
		
		int absExponent = exponent;
		if(exponent < 0) {
			absExponent = -exponent;
		}
		double result = powerWithUnsignedExponent(base, absExponent);
		if(exponent < 0) {
			result = 1.0 / result;
		}
		
		return result;
	}

	private static double powerWithUnsignedExponent(double base, int absExponent) {
		if(absExponent == 0) {
			return 1; 
		}
		if(absExponent ==1) {
			return base;
		}
		
		double result = powerWithUnsignedExponent(base, absExponent >> 1);
		result *= result;
		if((absExponent & 0x1) == 1) {
			result *= base;
		}
		return result;
	}
	
	private static boolean equal(double num1, double num2) {
		
		if((num1 - num2 > -0.0000001) && (num1 - num2 < 0.0000001)) {
			return true;
		}else {
			return false;
		}
	}
	
// ==================测试代码====================
	public static void test(String testName, double base, int exponent, double expected, boolean expectedFlag) {
		double result = power(base, exponent);
		if(equal(result, expected) && g_InvalidInput == expectedFlag) {
			System.out.printf("%s Passed.\n", testName);
		}else {
			System.out.printf("%s FAILED.\n", testName);
		}
	}
	
	public static void main(String[] args) {
		// 底数、指数都为正数
		Power.test("Test1", 2, 3, 8, false);

	    // 底数为负数、指数为正数
		Power.test("Test2", -2, 3, -8, false);

	    // 指数为负数
		Power.test("Test3", 2, -3, 0.125, false);

	    // 指数为0
		Power.test("Test4", 2, 0, 1, false);

	    // 底数、指数都为0
		Power.test("Test5", 0, 0, 1, false);

	    // 底数为0、指数为正数
		Power.test("Test6", 0, 4, 0, false);

	    // 底数为0、指数为负数
		Power.test("Test7", 0, -4, 0, true);


	}

}

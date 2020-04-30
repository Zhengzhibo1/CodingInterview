//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题15：二进制中1的个数
// 题目：请实现一个函数，输入一个整数，输出该数二进制表示中1的个数。例如
// 把9表示成二进制是1001，有2位是1。因此如果输入9，该函数输出2。
//==================================================================
//NumberOf1InBinary.java

package numberOf1InBinary;

public class NumberOf1InBinary {

// =================算法实现================
	//1、整数左移1位
	public int numberOf1_solution1(int n) {
		
		int count = 0;
		int flag = 1;
		while(flag != 0) {
			if((n & flag) != 0)
			{
				count++;
			}
			flag = flag << 1;
		}
		
		return count;
	}
	
	//2、
	/*把一个整数减去1之后，再与原来的整数做位与运算，
	 * 得到的结果相当于把原整数的二进制表示中，最右边的1变成0。
	 * */
	public int numberOf1_solution2(int n) {
		
		int count = 0;
		while(n != 0) {
			n = n & (n - 1);
			count++;
		}
		return count;
	}
	
// =================测试代码=====================
	public void test(int number, int expected) {
		int result = numberOf1_solution1(number);
		if(result == expected) {
			System.out.printf("Solution1:%d passed.\n", number);
		}else {
			System.out.printf("Solution1:%d FAILED.\n", number);
		}
		result = numberOf1_solution2(number);
		if(result == expected) {
			System.out.printf("Solution2:%d passed.\n", number);
		}else {
			System.out.printf("Solution2:%d FAILED.\n", number);
		}
	}

	public static void main(String[] args) {
		NumberOf1InBinary n = new NumberOf1InBinary();
		n.test(0, 0);
		n.test(1, 1);
		n.test(10, 2);
		n.test(0x7FFFFFFF, 31);
		n.test(0xFFFFFFFF, 32);
		n.test(0x80000000, 1);

	}

}

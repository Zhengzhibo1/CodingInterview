
//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题43：从1到n整数中1出现的次数
// 题目：输入一个整数n，求从1到n这n个整数的十进制表示中1出现的次数。例如
// 输入12，从1到12这些整数中包含1 的数字有1，10，11和12，1一共出现了5次。

//==================================================================
//NumberOf1.java

public class NumberOf1 {
// ====================算法实现================
	// 为了便于操作，先把整数转换成字符串
    public int numberOf1Between1AndN_Solution(int n) {
        if(n <= 0) {
        	return 0;
        }
        
        char[] strN = Integer.toString(n).toCharArray();
        
        return numberOf1(strN ,0);
    }
	
    // 利用Index表示指向数组中的第几位
    public int numberOf1(char[] strN, int index) {
    	int first = strN[index] - '0';
    	int length = strN.length - index;
    	
    	if(length == 1 && first == 0) {
    		return 0;
    	}
    	
    	if(length == 1 && first > 0) {
    		return 1;
    	}
    	int numFirstDigit = 0;
    	if(first > 1) {
    		numFirstDigit = powerBase10(length - 1);
    	}else if(first == 1){
    		char[] str = new char[length - 1];
    		for(int i = 0; i < length - 1; ++i) {
    			str[i] = strN[i + 1 + index];
    		}
    		numFirstDigit = Integer.parseInt(String.valueOf(str)) + 1;
    	}
    	
    	int numOtherDigits = first * (length - 1) *powerBase10(length - 2);
    	
    	int numRecursive = numberOf1(strN, index + 1);
    	
    	
    	return numFirstDigit + numOtherDigits + numRecursive;
    }
    
    public int powerBase10(int num) {
    	int result = 1;
    	for(int i = 0; i < num; ++i) {
    		result *= 10;
    	}
    	return result;
    }
  
// ====================测试代码========================
    public void test(String testName, int n, int expected)
    {
        if(testName != null)
            System.out.printf("%s begins: \n", testName);
        
        if(numberOf1Between1AndN_Solution(n) == expected)
            System.out.print("passed.\n");
        else
        	System.out.print("failed.\n");

        System.out.println();
    }

    public void test()
    {
        test("Test1", 1, 1);
        test("Test2", 5, 1);
        test("Test3", 10, 2);
        test("Test4", 55, 16);
        test("Test5", 99, 20);
        test("Test6", 10000, 4001);
        test("Test7", 21345, 18821);
        test("Test8", 0, 0);
    }
	public static void main(String[] args) {
		NumberOf1 n = new NumberOf1();
		n.test();

	}

}

//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题4：二维数组中的查找
// 面试题5：替换空格
// 题目：请实现一个函数，把字符串中的每个空格替换成"%20"。例如输入“We are happy.”，
// 则输出“We%20are%20happy.”。
// 思路：利用java的StringBuffer类型，总体思路从后往前进行替换
// 首先计算出新字符串长度：原始字符长度+空格数*2，对StringBuffer进行扩容
// 利用双指针，一个指向原始字符串末尾，一个指向扩容后末尾
// 判断字符是否为空格，若是则依次赋值为%20，若不是则赋值为该字符
// 指针不断前移直到位置相同或者指向原始字符串的指针小于0
//==================================================================
public class ReplaceSpaces {

 // String类虽然是引用数据类型，但是它当做参数传递时和基本数据类型是一样的
 // StringBuffer是引用数据类型，当做参数传递时改变其值
	public void ReplaceBlank(StringBuffer str) {
		if(str == null || str.length() <= 0) {
			return;
		}
		
		//originalLength为字符串str的实际长度
		int originalLength = str.length();
		int numberOfBlank = 0;
		for(int i = 0; i < originalLength; ++i) {
			if(str.charAt(i )== ' ') {
				++numberOfBlank;
			}
		}
		
		//newLength为把空格替换为%20之后的长度
		int newLength = originalLength + numberOfBlank * 2;
		//扩容
		str.setLength(newLength);
		int indexOfOriginal = originalLength - 1;
		int indexOfNew = newLength - 1;
		
		while(indexOfOriginal >= 0 && indexOfNew > indexOfOriginal) {
			if(str.charAt(indexOfOriginal) == ' ') {
				str.setCharAt(indexOfNew--, '0');
				str.setCharAt(indexOfNew--, '2');
				str.setCharAt(indexOfNew--, '%');
			}else {
				str.setCharAt(indexOfNew--, str.charAt(indexOfOriginal));
			}
			--indexOfOriginal;
		}
	}
	
//=========================测试代码================================
	void Test1()
	{
		StringBuffer str = new StringBuffer("hello world");
		ReplaceBlank(str);
		System.out.println(str);
	}
	
	// 空格在句子开头
	void Test2()
	{
		StringBuffer str = new StringBuffer(" helloworld");
		ReplaceBlank(str);
		System.out.println(str);
	}

	// 空格在句子末尾
	void Test3()
	{
		StringBuffer str = new StringBuffer("helloworld ");
		ReplaceBlank(str);
		System.out.println(str);
	}

	// 连续有两个空格
	void Test4()
	{
		StringBuffer str = new StringBuffer("hello  world");
		ReplaceBlank(str);
		System.out.println(str);
	}

	// 传入null
	void Test5()
	{
		StringBuffer str = null;
		ReplaceBlank(str);
		System.out.println(str);
	}

	// 传入内容为空的字符串
	void Test6()
	{
		StringBuffer str = new StringBuffer("");
		ReplaceBlank(str);
		System.out.println(str);
	}

	//传入内容为一个空格的字符串
	void Test7()
	{
		StringBuffer str = new StringBuffer(" ");
		ReplaceBlank(str);
		System.out.println(str);
	}

	// 传入的字符串没有空格
	void Test8()
	{
		StringBuffer str = new StringBuffer("helloworld");
		ReplaceBlank(str);
		System.out.println(str);
	}

	// 传入的字符串全是空格
	void Test9()
	{
		StringBuffer str = new StringBuffer("   ");
		ReplaceBlank(str);
		System.out.println(str);
	}
	
	public static void main(String[] args) {
		ReplaceSpaces replaceSpaces = new ReplaceSpaces();
		replaceSpaces.Test1();
		replaceSpaces.Test2();
		replaceSpaces.Test3();
		replaceSpaces.Test4();
		replaceSpaces.Test5();
		replaceSpaces.Test6();
		replaceSpaces.Test7();
		replaceSpaces.Test8();
		replaceSpaces.Test9();
	}

}

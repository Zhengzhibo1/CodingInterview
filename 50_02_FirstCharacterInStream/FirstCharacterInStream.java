//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题50（二）：字符流中第一个只出现一次的字符
// 题目：请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从
// 字符流中只读出前两个字符"go"时，第一个只出现一次的字符是'g'。当从该字
// 符流中读出前六个字符"google"时，第一个只出现一次的字符是'l'。
// 如果当前字符流没有存在出现一次的字符，返回#字符。

//==================================================================
//FirstCharacterInStream.java


public class FirstCharacterInStream {

// ====================算法实现======================
	private int[] occurrence = new int[256];
	int index = 1;

	// Insert one char from stringstream
	public void insert(char ch) {
		if (occurrence[ch] == 0) {
			occurrence[ch] = index++;
		} else {
			occurrence[ch] = -1;
		}
	}

	// return the first appearence once char in current stringstream
	// 设置maxValue确保能找到第一个只出现一次的字符
	// maxValue存放的是字符出现的位置，若位置比当前位置更前，则记录该字符与该位置。
	public char firstAppearingOnce() {
		int maxValue = Integer.MAX_VALUE;
		char ch = '#';
		for (int i = 0; i < 256; ++i) {
			if (occurrence[i] > 0 && occurrence[i] < maxValue) {
				ch = (char) i;
				maxValue = occurrence[i];
			}
		}
		return ch;
	}

// =====================测试代码================================
	public static void main(String[] args) {
		FirstCharacterInStream f = new FirstCharacterInStream();
		String str = "google";
		char[] strs = str.toCharArray();
		for (int i = 0; i < strs.length; ++i) {
			f.insert(strs[i]);
			System.out.print(f.firstAppearingOnce());
		}
	}

}


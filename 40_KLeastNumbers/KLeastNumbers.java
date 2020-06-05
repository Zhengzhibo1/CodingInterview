//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题40：最小的k个数
// 题目：输入n个整数，找出其中最小的k个数。例如输入4、5、1、6、2、7、3、8
// 这8个数字，则最小的4个数字是1、2、3、4。

//==================================================================
//KLeastNumbers.java

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class KLeastNumbers {

// ===================算法实现====================
//方法1：基于快速排序算法的实现
	public ArrayList<Integer> getLeastNumbers_Solution(int[] input, int k) {
		ArrayList<Integer> result = new ArrayList<Integer>();

		if (input == null || input.length == 0 || k > input.length || k <= 0) {
			return result;
		}
		int length = input.length;
		int start = 0;
		int end = length - 1;
		int index = partition(input, length, start, end);
		while (index != k - 1) {
			if (index > k - 1) {
				end = index - 1;
				index = partition(input, length, start, end);
			} else {
				start = index + 1;
				index = partition(input, length, start, end);
			}
		}

		for (int i = 0; i < k; i++) {
			result.add(input[i]);
		}
		return result;
	}

	// 快速排序算法
	int partition(int array[], int length, int start, int end) {
//		if (array == null || length <= 0 || start < 0 || end > length) {
//			
//		}

		// 生产随机数，先根据end与start之间的长度生成0~该值的随机数
		// 然后加上start的值，即为start~end之间的随机数
		// random.nextInt(10)生成0~9之间的随机数
		Random random = new Random();
		int index = random.nextInt(end - start + 1) + start;
		swap(array, index, end);

		int small = start - 1;
		for (index = start; index < end; ++index) {
			if (array[index] < array[end]) {
				++small;
				if (small != index) {
					swap(array, small, index);
				}
			}
		}

		small++;
		swap(array, small, end);

		return small;
	}

	// 交换数组中的两个数字
	public void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}

// 方法2：基于最大堆的实现
	public ArrayList<Integer> getLeastNumbers_Solution_2(int[] input, int k) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (input == null || input.length == 0 || k > input.length || k <= 0) {
			return result;
		}

		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});

		for (int i = 0; i < input.length; ++i) {
			if (maxHeap.size() != k) {
				maxHeap.offer(input[i]);
			} else if (maxHeap.peek() > input[i]) {
				maxHeap.poll();
				maxHeap.offer(input[i]);
			}
		}

		for (int i : maxHeap) {
			result.add(i);
		}
		return result;
	}

// ===================测试代码=======================
	// k小于数组的长度
	public void test1() {
		System.out.println("Test1 : ");
		int data[] = { 4, 5, 1, 6, 2, 7, 3, 8 };
		for (int i : data) {
			System.out.print(i + "\t");
		}
		System.out.println();

		ArrayList<Integer> result = getLeastNumbers_Solution_2(data, 4);
		for (int i : result) {
			System.out.print(i + "\t");
		}
		System.out.println();
	}

	// k等于数组的长度
	public void test2() {
		System.out.println("Test2 : ");
		int data[] = { 4, 5, 1, 6, 2, 7, 3, 8 };
		for (int i : data) {
			System.out.print(i + "\t");
		}
		System.out.println();

		ArrayList<Integer> result = getLeastNumbers_Solution(data, 8);
		for (int i : result) {
			System.out.print(i + "\t");
		}
		System.out.println();
	}

	// k大于数组的长度
	public void test3() {
		System.out.println("Test3 : ");
		int data[] = { 4, 5, 1, 6, 2, 7, 3, 8 };
		for (int i : data) {
			System.out.print(i + "\t");
		}
		System.out.println();

		ArrayList<Integer> result = getLeastNumbers_Solution(data, 10);
		for (int i : result) {
			System.out.print(i + "\t");
		}
		System.out.println();
	}

	// k等于1
	public void test4() {
		System.out.println("Test4 : ");
		int data[] = { 4, 5, 1, 6, 2, 7, 3, 8 };
		for (int i : data) {
			System.out.print(i + "\t");
		}
		System.out.println();

		ArrayList<Integer> result = getLeastNumbers_Solution(data, 1);
		for (int i : result) {
			System.out.print(i + "\t");
		}
		System.out.println();

	}

	// k等于0
	public void test5() {
		System.out.println("Test5 : ");
		int data[] = { 4, 5, 1, 6, 2, 7, 3, 8 };
		for (int i : data) {
			System.out.print(i + "\t");
		}
		System.out.println();

		ArrayList<Integer> result = getLeastNumbers_Solution(data, 0);
		for (int i : result) {
			System.out.print(i + "\t");
		}
		System.out.println();
	}

	// 数组中有相同的数字
	public void test6() {
		System.out.println("Test6 : ");
		int data[] = { 4, 5, 1, 6, 2, 7, 2, 8 };

		for (int i : data) {
			System.out.print(i + "\t");
		}
		System.out.println();

		ArrayList<Integer> result = getLeastNumbers_Solution_2(data, 2);
		for (int i : result) {
			System.out.print(i + "\t");
		}
		System.out.println();
	}

	// 输入空指针
	public void test7() {
		System.out.println("Test7 : ");
		ArrayList<Integer> result = getLeastNumbers_Solution(null, 0);
		for (int i : result) {
			System.out.print(i + "\t");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		KLeastNumbers k = new KLeastNumbers();
		k.test1();
		k.test2();
		k.test3();
		k.test4();
		k.test5();
		k.test6();
		k.test7();

	}

}

/*
 * 写在最后，关于接口Comparator的方法compare(o1, o2)的一些见解： 此方法为抽象方法 int compare(T o1, T o2)
 * 比较用来排序的两个参数。 关于返回值：如果该方法返回值小于0，则代表o1，o2的位置不需要改变，即o1在前，o2在后。
 * 如果该方法返回值大于0，则代表o1，o2的位置需要改变，即o2在前，o1在后。
 * 另外一种见解：该方法的返回值代表了两个参数的权重大小，返回值大于0，代表前者权重大， 返回值小于0，代表后者权重大，最后按权重默认升序排列。
 * 最后，虽然接口Comparator有两个抽象方法，int compare(T o1, T o2)，boolean equals(Object obj)
 * 但继承时仅需实现compare方法即可，具体JAVA核心技术卷1应该有解释。
 */

//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题41：数据流中的中位数
// 题目：如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么
// 中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，
// 那么中位数就是所有数值排序之后中间两个数的平均值。

//==================================================================
//StreamMedian.java

import java.util.Comparator;
import java.util.PriorityQueue;

public class StreamMedian {
// ===================算法实现=====================
	//建立最大堆、最小堆
	private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o2.compareTo(o1);
		}
	});
	
	private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o1.compareTo(o2);
		}		
	});
	
    public void Insert(Integer num) {
        if(((minHeap.size() + maxHeap.size()) &1) == 0) {
        	// 总数目为偶数时
        	if(maxHeap.size() > 0 && num < maxHeap.peek()) {
        		maxHeap.offer(num);
        		num = maxHeap.poll();
        	}
        	minHeap.offer(num);
        }else {
        	// 总数目为奇数时
        	if(minHeap.size() > 0 && num > minHeap.peek()) {
        		minHeap.offer(num);
        		num = minHeap.poll();
        	}
        	maxHeap.offer(num);
        }
    }

    public Double GetMedian() throws Exception {
        int size = minHeap.size() + maxHeap.size();
        if(size == 0) {
        	throw new Exception("No numbers are available");
        }
        
        double median = 0;
        if((size & 1) == 1) {
        	// 总数目为奇数
        	median = minHeap.peek();
        }else {
        	median = (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
        return median;
    }
	
	
 // ====================测试代码====================
    public void test(String testName, double expected) throws Exception
    {
        if(testName != null)
            System.out.printf("%s begins: ", testName);

        if(Math.abs(GetMedian() - expected) < 0.0000001)
            System.out.print("Passed.\n");
        else
        	System.out.print("FAILED.\n");
    }	
	public static void main(String[] args) {
		StreamMedian s = new StreamMedian();
		
		System.out.print("Test1:");		
		try {
			s.GetMedian();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			s.Insert(5);
			s.test("Test2:", 5);
			
			s.Insert(2);
			s.test("Test3:", 3.5);
			
			s.Insert(3);
			s.test("Test4:", 3);
			
			s.Insert(4);
			s.test("Test5:", 3.5);
			
			s.Insert(1);
			s.test("Test6:", 3);
			
			s.Insert(6);
			s.test("Test7:", 3.5);
			
			s.Insert(7);
			s.test("Test7:", 4);
			
			s.Insert(0);
			s.test("Test7:", 3.5);
			
			s.Insert(8);
			s.test("Test7:", 4);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

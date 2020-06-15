//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题51：数组中的逆序对
// 题目：在数组中的两个数字如果前面一个数字大于后面的数字，则这两个数字组
// 成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。

//==================================================================
//FirstCommonNodesInLists.java


public class FirstCommonNodesInLists {
// ===================内部类：链表结构===============
	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

// ====================算法实现======================
	public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		if (pHead1 == null || pHead2 == null) {
			return null;
		}

		int length1 = 0;
		int length2 = 0;
		ListNode index1 = pHead1;
		ListNode index2 = pHead2;
		while (index1 != null) {
			length1++;
			index1 = index1.next;
		}

		while (index2 != null) {
			length2++;
			index2 = index2.next;
		}

		index1 = pHead1;
		index2 = pHead2;
		if (length1 >= length2) {
			for (int i = 0; i < length1 - length2; ++i) {
				index1 = index1.next;
			}
		} else {
			for (int i = 0; i < length2 - length1; ++i) {
				index2 = index2.next;
			}
		}

		while ((index1 != index2) && (index1 != null) && (index2 != null)) {
			index1 = index1.next;
			index2 = index2.next;
		}

		return index1;
	}

// ====================测试代码====================

	public void test(String testName, ListNode pHead1, ListNode pHead2, ListNode pExpected) {
		if (testName != null)
			System.out.printf("%s begins: ", testName);

		ListNode pResult = findFirstCommonNode(pHead1, pHead2);
		if (pResult == pExpected)
			System.out.print("Passed.\n");
		else
			System.out.print("Failed.\n");
	}

	// 第一个公共结点在链表中间
	// 1 - 2 - 3 \
//                6 - 7
//         4 - 5 /
	public void test1() {
		ListNode pNode1 = new ListNode(1);
		ListNode pNode2 = new ListNode(2);
		ListNode pNode3 = new ListNode(3);
		ListNode pNode4 = new ListNode(4);
		ListNode pNode5 = new ListNode(5);
		ListNode pNode6 = new ListNode(6);
		ListNode pNode7 = new ListNode(7);

		pNode1.next = pNode2;
		pNode2.next = pNode3;
		pNode3.next = pNode6;
		pNode4.next = pNode5;
		pNode5.next = pNode6;
		pNode6.next = pNode7;

		test("Test1", pNode1, pNode4, pNode6);
	}

	// 没有公共结点
	// 1 - 2 - 3 - 4
//                
	// 5 - 6 - 7
	public void test2() {
		ListNode pNode1 = new ListNode(1);
		ListNode pNode2 = new ListNode(2);
		ListNode pNode3 = new ListNode(3);
		ListNode pNode4 = new ListNode(4);
		ListNode pNode5 = new ListNode(5);
		ListNode pNode6 = new ListNode(6);
		ListNode pNode7 = new ListNode(7);

		pNode1.next = pNode2;
		pNode2.next = pNode3;
		pNode3.next = pNode4;
		pNode5.next = pNode6;
		pNode6.next = pNode7;

		test("Test2", pNode1, pNode5, null);

	}

	// 公共结点是最后一个结点
	// 1 - 2 - 3 - 4 \
//                    7
//             5 - 6 /
	public void test3() {
		ListNode pNode1 = new ListNode(1);
		ListNode pNode2 = new ListNode(2);
		ListNode pNode3 = new ListNode(3);
		ListNode pNode4 = new ListNode(4);
		ListNode pNode5 = new ListNode(5);
		ListNode pNode6 = new ListNode(6);
		ListNode pNode7 = new ListNode(7);

		pNode1.next = pNode2;
		pNode2.next = pNode3;
		pNode3.next = pNode4;
		pNode4.next = pNode7;

		pNode5.next = pNode6;
		pNode6.next = pNode7;

		test("Test3", pNode1, pNode5, pNode7);
	}

	// 公共结点是第一个结点
	// 1 - 2 - 3 - 4 - 5
	// 两个链表完全重合
	public void test4() {
		ListNode pNode1 = new ListNode(1);
		ListNode pNode2 = new ListNode(2);
		ListNode pNode3 = new ListNode(3);
		ListNode pNode4 = new ListNode(4);
		ListNode pNode5 = new ListNode(5);

		pNode1.next = pNode2;
		pNode2.next = pNode3;
		pNode3.next = pNode4;
		pNode4.next = pNode5;

		test("Test4", pNode1, pNode1, pNode1);

	}

	// 输入的两个链表有一个空链表
	public void test5() {
		ListNode pNode1 = new ListNode(1);
		ListNode pNode2 = new ListNode(2);
		ListNode pNode3 = new ListNode(3);
		ListNode pNode4 = new ListNode(4);
		ListNode pNode5 = new ListNode(5);

		pNode1.next = pNode2;
		pNode2.next = pNode3;
		pNode3.next = pNode4;
		pNode4.next = pNode5;

		test("Test5", null, pNode1, null);

	}

	// 输入的两个链表有一个空链表
	public void test6() {
		test("Test6", null, null, null);
	}

	public static void main(String[] args) {
		FirstCommonNodesInLists f = new FirstCommonNodesInLists();
		f.test1();
		f.test2();
		f.test3();
		f.test4();
		f.test5();
		f.test6();

	}

}

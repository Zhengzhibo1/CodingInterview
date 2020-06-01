//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题25：合并两个排序的链表
// 题目：输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按
// 照递增排序的。例如输入图3.11中的链表1和链表2，则合并之后的升序链表如链
// 表3所示。

//==================================================================
//MergeSortedLists.java

public class MergeSortedLists {

// ===================内部类：链表结构==============
	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

// ===================算法实现=======================
	public ListNode merge(ListNode list1, ListNode list2) {
		if (list1 == null) {
			return list2;
		} else if (list2 == null) {
			return list1;
		}

		ListNode mergeHead = null;

		if (list1.val < list2.val) {
			mergeHead = list1;
			mergeHead.next = merge(list1.next, list2);
		} else {
			mergeHead = list2;
			mergeHead.next = merge(list1, list2.next);
		}

		return mergeHead;
	}

// ===================测试代码==================
	// list1: 1->3->5
	// list2: 2->4->6
	public void test1() {
		System.out.print("Test1: ");
		ListNode pNode1 = new ListNode(1);
		ListNode pNode3 = new ListNode(3);
		ListNode pNode5 = new ListNode(5);

		pNode1.next = pNode3;
		pNode3.next = pNode5;

		ListNode pNode2 = new ListNode(2);
		ListNode pNode4 = new ListNode(4);
		ListNode pNode6 = new ListNode(6);

		pNode2.next = pNode4;
		pNode4.next = pNode6;

		ListNode pMergedHead = merge(pNode1, pNode2);

		ListNode node = pMergedHead;
		while (node != null) {
			System.out.print(node.val + "\t");
			node = node.next;
		}
		System.out.println();
	}

	// 两个链表中有重复的数字
	// list1: 1->3->5
	// list2: 1->3->5
	public void test2() {
		System.out.print("Test2: ");
		ListNode pNode1 = new ListNode(1);
		ListNode pNode3 = new ListNode(3);
		ListNode pNode5 = new ListNode(5);

		pNode1.next = pNode3;
		pNode3.next = pNode5;

		ListNode pNode2 = new ListNode(1);
		ListNode pNode4 = new ListNode(3);
		ListNode pNode6 = new ListNode(5);

		pNode2.next = pNode4;
		pNode4.next = pNode6;

		ListNode pMergedHead = merge(pNode1, pNode2);

		ListNode node = pMergedHead;
		while (node != null) {
			System.out.print(node.val + "\t");
			node = node.next;
		}
		System.out.println();
	}

	// 两个链表都只有一个数字
	// list1: 1
	// list2: 2
	public void test3() {
		System.out.print("Test3: ");
		ListNode pNode1 = new ListNode(1);
		ListNode pNode2 = new ListNode(2);

		ListNode pMergedHead = merge(pNode1, pNode2);

		ListNode node = pMergedHead;
		while (node != null) {
			System.out.print(node.val + "\t");
			node = node.next;
		}
		System.out.println();
	}

	// 一个链表为空链表
	// list1: 1->3->5
	// list2: 空链表
	public void test4() {
		System.out.print("Test4: ");
		ListNode pNode1 = new ListNode(1);
		ListNode pNode3 = new ListNode(3);
		ListNode pNode5 = new ListNode(5);

		pNode1.next = pNode3;
		pNode3.next = pNode5;

		ListNode pMergedHead = merge(pNode1, null);

		ListNode node = pMergedHead;
		while (node != null) {
			System.out.print(node.val + "\t");
			node = node.next;
		}
		System.out.println();
	}

	// 两个链表都为空链表
	// list1: 空链表
	// list2: 空链表
	public void test5() {
		System.out.print("Test5: ");
		ListNode pMergedHead = merge(null, null);
		if (pMergedHead == null) {
			System.out.println("null");
		}
	}

	public static void main(String[] args) {
		MergeSortedLists m = new MergeSortedLists();
		m.test1();
		m.test2();
		m.test3();
		m.test4();
		m.test5();

	}

}

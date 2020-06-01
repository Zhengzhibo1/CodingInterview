//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题24：反转链表
// 题目：定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的
// 头结点。

//==================================================================
//ReverseList.java

public class ReverseList {

// =================内部类：链表结构=============
	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

// ==================算法实现===================
	public ListNode reverseList(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode preNode = null;
		ListNode curNode = head;
		ListNode nextNode = null;

		while (curNode != null) {
			nextNode = curNode.next;
			curNode.next = preNode;

			preNode = curNode;
			curNode = nextNode;
		}

		return preNode;
	}

// ====================测试代码====================
	public void test(ListNode pHead) {
		System.out.print("The original list is: \n");
		ListNode node = pHead;
		while (node != null) {
			System.out.print(node.val + "\t");
			node = node.next;
		}

		ListNode pReversedHead = reverseList(pHead);

		System.out.println();
		System.out.print("The reversed list is: \n");
		node = pReversedHead;
		while (node != null) {
			System.out.print(node.val + "\t");
			node = node.next;
		}
		System.out.println();
	}

	// 输入的链表有多个结点
	void test1() {
		ListNode pNode1 = new ListNode(1);
		ListNode pNode2 = new ListNode(2);
		ListNode pNode3 = new ListNode(3);
		ListNode pNode4 = new ListNode(4);
		ListNode pNode5 = new ListNode(5);

		pNode1.next = pNode2;
		pNode2.next = pNode3;
		pNode3.next = pNode4;
		pNode4.next = pNode5;

		test(pNode1);

	}

	// 输入的链表只有一个结点
	void test2() {
		ListNode pNode1 = new ListNode(1);

		test(pNode1);
	}

	// 输入空链表
	void test3() {
		test(null);
	}

	public static void main(String[] args) {
		ReverseList r = new ReverseList();
		r.test1();
		r.test2();
		r.test3();

	}

}


//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题6：从尾到头打印链表
// 题目：输入一个链表的头结点，从尾到头反过来打印出每个结点的值。

// 思路：1、递归实现 2、反转链表，然后输出（修改原链表）
// 注：需要自己创建链表结构，本题创建简单的链表结构即可。
//==================================================================
// ======================创建链表类=================================
// ListNode.java
public class ListNode {
	// 数据
	private int value;
	// 下一个节点
	private ListNode next;
	
	//构造方法
	public ListNode(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public ListNode getNext() {
		return next;
	}
	public void setNext(ListNode next) {
		this.next = next;
	}
}

// 解决方法 PrintListInReversedOrder.java
//==================算法部分======================
public class PrintListInReversedOrder {

	// 递归实现
	public void PrintListReversingly_Recursively(ListNode node) {
		if (node != null) {
			if (node.getNext() != null) {
				PrintListReversingly_Recursively(node.getNext());
			}
			System.out.print(node.getValue() + " ");
		}
	}

	// 改动原链表，先反转，后输出
	public void PrintListReversingly_Inversely(ListNode node) {
		ListNode pre = null;
		ListNode cur = node;
		ListNode next = null;

		while (cur != null) { // 如果当前节点不为空
			next = cur.getNext(); // 先取出下一个节点
			cur.setNext(pre); // 将当前节点连接到上一个节点

			// 当前节点变成上一节点，下一节点变成当前节点，再次判断进入循环
			pre = cur;
			cur = next;
		}

		while (pre != null) {
			System.out.print(pre.getValue() + " ");
			pre = pre.getNext();
		}
	}

//======================测试代码=========================
// 链表存在多个节点
	public void Test1() {
		ListNode head = new ListNode(1);
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(4);
		ListNode node4 = new ListNode(5);
		ListNode node5 = new ListNode(6);

		head.setNext(node1);
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		node4.setNext(node5);
		System.out.print("递归实现的结果为：");
		PrintListReversingly_Recursively(head);
		System.out.println();
		System.out.print("反转链表实现的结果为：");
		PrintListReversingly_Inversely(head);
		System.out.println();
	}

	// 只有一个节点的链表
	public void Test2() {
		ListNode head = new ListNode(1);
		System.out.print("递归实现的结果为：");
		PrintListReversingly_Recursively(head);
		System.out.println();
		System.out.print("反转链表实现的结果为：");
		PrintListReversingly_Inversely(head);
		System.out.println();
	}

	// 空链表
	public void Test3() {
		ListNode head = null;
		System.out.print("递归实现的结果为：");
		PrintListReversingly_Recursively(head);
		System.out.println();
		System.out.print("反转链表实现的结果为：");
		PrintListReversingly_Inversely(head);
		System.out.println();
	}

	public static void main(String[] args) {
  
		PrintListInReversedOrder p = new PrintListInReversedOrder();
		p.Test1();
		p.Test2();
		p.Test3();
	}
}

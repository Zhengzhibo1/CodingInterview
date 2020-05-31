//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题22：链表中倒数第k个结点
// 题目：输入一个链表，输出该链表中倒数第k个结点。为了符合大多数人的习惯，
// 本题从1开始计数，即链表的尾结点是倒数第1个结点。例如一个链表有6个结点，
// 从头结点开始它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个结点是
// 值为4的结点。

//注意：头节点为空，输入参数大于链表长度，输入参数为0
//==================================================================
//KthNodeFromEnd.java

public class KthNodeFromEnd {

// ================内部类：链表的结构============
	public class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
// ================算法实现====================
	public ListNode FindKthToTail(ListNode head,int k) {
		if(head == null || k == 0) {
			return null;
		}
		ListNode ahead = head;
		ListNode behind = null;
		
		for(int i = 1; i < k; ++i) {
			if(ahead.next != null) {
				ahead = ahead.next;
			}else {
				return null;
			}
		}
		behind = head;
		while(ahead.next != null) {
			ahead = ahead.next;
			behind = behind.next;
		}
		
		return behind;
	}
	
// ====================测试代码====================
	// 测试要找的结点在链表中间
	public void test1()
	{
	    System.out.print("=====Test1 starts:=====\n");
	    ListNode pNode1 = new ListNode(1);
	    ListNode pNode2 = new ListNode(2);
	    ListNode pNode3 = new ListNode(3);
	    ListNode pNode4 = new ListNode(4);
	    ListNode pNode5 = new ListNode(5);

	    pNode1.next = pNode2;
	    pNode2.next = pNode3;
	    pNode3.next = pNode4;
	    pNode4.next = pNode5;

	    System.out.print("expected result: 4.\n");
	    ListNode pNode = FindKthToTail(pNode1, 2);
	    System.out.println(pNode.val);

	}

	// 测试要找的结点是链表的尾结点
	void test2()
	{
		System.out.print("=====Test2 starts:=====\n");
	    ListNode pNode1 = new ListNode(1);
	    ListNode pNode2 = new ListNode(2);
	    ListNode pNode3 = new ListNode(3);
	    ListNode pNode4 = new ListNode(4);
	    ListNode pNode5 = new ListNode(5);

	    pNode1.next = pNode2;
	    pNode2.next = pNode3;
	    pNode3.next = pNode4;
	    pNode4.next = pNode5;

	    System.out.print("expected result: 5.\n");
	    ListNode pNode = FindKthToTail(pNode1, 1);
	    System.out.println(pNode.val);
	    
	}

	// 测试要找的结点是链表的头结点
	void test3()
	{
		System.out.print("=====Test3 starts:=====\n");
	    ListNode pNode1 = new ListNode(1);
	    ListNode pNode2 = new ListNode(2);
	    ListNode pNode3 = new ListNode(3);
	    ListNode pNode4 = new ListNode(4);
	    ListNode pNode5 = new ListNode(5);

	    pNode1.next = pNode2;
	    pNode2.next = pNode3;
	    pNode3.next = pNode4;
	    pNode4.next = pNode5;

	    System.out.print("expected result: 1.\n");
	    ListNode pNode = FindKthToTail(pNode1, 5);
	    System.out.println(pNode.val);
	    
	}

	// 测试空链表
	void test4()
	{
		System.out.print("=====Test4 starts:=====\n");
		System.out.print("expected result: null.\n");
	    ListNode pNode = FindKthToTail(null, 100);
	    if(pNode == null) {
	    	System.out.print("pNode is NULL!\n");
	    }
	}

	// 测试输入的第二个参数大于链表的结点总数
	void test5()
	{
		System.out.print("=====Test5 starts:=====\n");
	    ListNode pNode1 = new ListNode(1);
	    ListNode pNode2 = new ListNode(2);
	    ListNode pNode3 = new ListNode(3);
	    ListNode pNode4 = new ListNode(4);
	    ListNode pNode5 = new ListNode(5);

	    pNode1.next = pNode2;
	    pNode2.next = pNode3;
	    pNode3.next = pNode4;
	    pNode4.next = pNode5;

	    System.out.print("expected result: null.\n");
	    ListNode pNode = FindKthToTail(pNode1, 6);
	    if(pNode == null) {
	    	System.out.print("测试输入的第二个参数大于链表的结点总数\n");
	    }
	    
	}

	// 测试输入的第二个参数为0
	void test6()
	{
		System.out.print("=====Test6 starts:=====\n");
	    ListNode pNode1 = new ListNode(1);
	    ListNode pNode2 = new ListNode(2);
	    ListNode pNode3 = new ListNode(3);
	    ListNode pNode4 = new ListNode(4);
	    ListNode pNode5 = new ListNode(5);

	    pNode1.next = pNode2;
	    pNode2.next = pNode3;
	    pNode3.next = pNode4;
	    pNode4.next = pNode5;

	    System.out.print("expected result: null.\n");
	    ListNode pNode = FindKthToTail(pNode1, 0);
	    if(pNode == null) {
	    	System.out.print("测试输入的第二个参数为0\n");
	    }
	    
	}
	public static void main(String[] args) {
		KthNodeFromEnd k = new KthNodeFromEnd();
		k.test1();
		k.test2();
		k.test3();
		k.test4();
		k.test5();
		k.test6();

	}

}

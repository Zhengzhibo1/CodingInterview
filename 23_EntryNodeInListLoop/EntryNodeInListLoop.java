//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题23：链表中环的入口结点
// 题目：一个链表中包含环，如何找出环的入口结点？例如，在图3.8的链表中，
// 环的入口结点是结点3。

//==================================================================
//EntryNodeInListLoop.java

public class EntryNodeInListLoop {

// ===================内部类：链表结构=============
	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

// ===================算法实现======================
	// 判断链表是否成环并返回环内点
	public ListNode meetingNode(ListNode pHead) {
		if(pHead == null) {
			return null;
		}
		
		ListNode pSlow = pHead.next;
		if(pSlow == null) {
			return null;
		}
		ListNode pFast = pSlow.next;
		while(pFast != null && pSlow != null) {
			if(pFast == pSlow) {
				return pFast;
			}
			
			pSlow = pSlow.next;
			pFast = pFast.next;
			if(pFast == null) {
				return null;
			}else {
				pFast = pFast.next;
			}
		}
		
		return null;
	}
	
	// 判断环内节点数，并求出链表环入口
	public ListNode entryNodeOfLoop(ListNode pHead) {
		
		ListNode meetingNode = meetingNode(pHead);
		if(meetingNode == null) {
			return null;
		}
		//计算环内节点数
		int nodesInLoop = 1;
		ListNode nodeIndex1 = meetingNode;
		while(nodeIndex1.next != meetingNode) {
			nodeIndex1 = nodeIndex1.next;
			nodesInLoop++;
		}
		
		// nodeIndex1先移动nodesInLoop步
		nodeIndex1 = pHead;
		for(int i = 0; i < nodesInLoop; ++i) {
			nodeIndex1 = nodeIndex1.next;
		}
		
		// 然后两个索引一起走
		ListNode nodeIndex2 = pHead;
		while(nodeIndex1 != nodeIndex2) {
			nodeIndex1 = nodeIndex1.next;
			nodeIndex2 = nodeIndex2.next;
		}
		return nodeIndex1;
	}

// =====================测试代码=====================	
	
	public void Test(String testName, ListNode pHead, ListNode entryNode)
	{
	    if(testName != null)
	        System.out.printf("%s begins: ", testName);

	    if(entryNodeOfLoop(pHead) == entryNode)
	    	System.out.print("Passed.\n");
	    else
	    	System.out.print("FAILED.\n");
	}

	// 链表仅一个节点
	void test1()
	{
	    ListNode pNode1 = new ListNode(1);
	    Test("Test1", pNode1, null);

	}

	// 链表仅一个节点且自成环
	void test2()
	{
	    ListNode pNode1 = new ListNode(1);
	    pNode1.next = pNode1;

	    Test("Test2", pNode1, pNode1);
	}

	// 链表有多个节点，且成环
	void test3()
	{
	    ListNode pNode1 = new ListNode(1);
	    ListNode pNode2 = new ListNode(2);
	    ListNode pNode3 = new ListNode(3);
	    ListNode pNode4 = new ListNode(4);
	    ListNode pNode5 = new ListNode(5);

	    pNode1.next = pNode2;
	    pNode2.next = pNode3;
	    pNode3.next = pNode4;
	    pNode4.next = pNode5;
	    pNode5.next = pNode3;

	    Test("Test3", pNode1, pNode3);

	}

	// 链表有多个节点，且成环
	void test4()
	{
	    ListNode pNode1 = new ListNode(1);
	    ListNode pNode2 = new ListNode(2);
	    ListNode pNode3 = new ListNode(3);
	    ListNode pNode4 = new ListNode(4);
	    ListNode pNode5 = new ListNode(5);

	    pNode1.next = pNode2;
	    pNode2.next = pNode3;
	    pNode3.next = pNode4;
	    pNode4.next = pNode5;
	    pNode5.next = pNode1;

	    Test("Test4", pNode1, pNode1);

	}

	// 链表有多个节点，且成环
	void test5()
	{
	    ListNode pNode1 = new ListNode(1);
	    ListNode pNode2 = new ListNode(2);
	    ListNode pNode3 = new ListNode(3);
	    ListNode pNode4 = new ListNode(4);
	    ListNode pNode5 = new ListNode(5);

	    pNode1.next = pNode2;
	    pNode2.next = pNode3;
	    pNode3.next = pNode4;
	    pNode4.next = pNode5;
	    pNode5.next = pNode5;

	    Test("Test5", pNode1, pNode5);
	    
	}

	// 链表有多个节点，无环
	void test6()
	{
	    ListNode pNode1 = new ListNode(1);
	    ListNode pNode2 = new ListNode(2);
	    ListNode pNode3 = new ListNode(3);
	    ListNode pNode4 = new ListNode(4);
	    ListNode pNode5 = new ListNode(5);

	    pNode1.next = pNode2;
	    pNode2.next = pNode3;
	    pNode3.next = pNode4;
	    pNode4.next = pNode5;

	    Test("Test6", pNode1, null);

	}

	// 空链表
	void test7()
	{
	    Test("Test7", null, null);
	}
	
	public static void main(String[] args) {
		EntryNodeInListLoop e = new EntryNodeInListLoop();
		e.test1();
		e.test2();
		e.test3();
		e.test4();
		e.test5();
		e.test6();
		e.test7();

	}

}

//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题35：复杂链表的复制
// 题目：请实现函数ComplexListNode* Clone(ComplexListNode* pHead)，复
// 制一个复杂链表。在复杂链表中，每个结点除了有一个m_pNext指针指向下一个
// 结点外，还有一个m_pSibling 指向链表中的任意结点或者nullptr。

//==================================================================
//CopyComplexList.java


public class CopyComplexList {

// ==================内部类：链表结构=================
	public class RandomListNode {
	    int label;
	    RandomListNode next = null;
	    RandomListNode random = null;

	    RandomListNode(int label) {
	        this.label = label;
	    }
	}
	
// ===================算法实现========================
	public RandomListNode Clone(RandomListNode pHead) {
		cloneNodes(pHead);
		connectRandom(pHead);
		RandomListNode cloneHead = reconnectNodes(pHead);
		return cloneHead;
	}
	
	// 第一步：复制节点，并与原链表连接起来
	public void cloneNodes(RandomListNode pHead) {

		RandomListNode node = pHead;
		while(node != null) {
			RandomListNode cloneNode = new RandomListNode(node.label);
			cloneNode.next = node.next;
			
			node.next = cloneNode;
			node = cloneNode.next;
		}
	}
	
	// 第二步：random连接起来
	public void connectRandom(RandomListNode pHead) {
		RandomListNode node = pHead;	
		RandomListNode cloneNode;
		while(node != null) {
			cloneNode = node.next;
			if(node.random != null) {
				cloneNode.random = node.random.next;
			}
			node = cloneNode.next;
		}
	}
	
	// 第三步:拆分成两个链表
	RandomListNode reconnectNodes(RandomListNode pHead) {
		RandomListNode node = pHead;
		RandomListNode cloneHead = null;
		RandomListNode cloneNode = null;
		
		if(node != null) {
			cloneHead = node.next;
			cloneNode = node.next;
			node.next = cloneHead.next;
			node = node.next;
		}
		
		while(node != null) {
			cloneNode.next = node.next;
			cloneNode = node.next;
			node.next = cloneNode.next;
			node = cloneNode.next;

		}
		
		return cloneHead;
	}
	
// ====================测试代码========================
	public void printListNode(RandomListNode pHead) {
		RandomListNode node = pHead;
		while(node != null) {
			System.out.print(node.label + "\t");
			node = node.next;
		}
		System.out.println();
	}
	
	public void test(String testName, RandomListNode pHead)
	{
	    if(testName != null)
	        System.out.printf("%s begins:\n", testName);

	    System.out.print("The original list is:\n");
	    printListNode(pHead);

	    RandomListNode pClonedHead = Clone(pHead);

	    System.out.print("The cloned list is:\n");
	    printListNode(pClonedHead);
	}

//	          -----------------
//	           \|/              |
	//  1-------2-------3-------4-------5
	//  |       |      /|\             /|\
	//  --------+--------               |
//	            -------------------------
	public void test1()
	{
		RandomListNode pNode1 = new RandomListNode(1);
		RandomListNode pNode2 = new RandomListNode(2);
		RandomListNode pNode3 = new RandomListNode(3);
		RandomListNode pNode4 = new RandomListNode(4);
		RandomListNode pNode5 = new RandomListNode(5);

		pNode1.next = pNode2;		
		pNode2.next = pNode3;
		pNode3.next = pNode4;
		pNode4.next = pNode5;
		
		pNode1.random = pNode3;
		pNode2.random = pNode5;
		pNode4.random = pNode2;


	    test("Test1", pNode1);
	}

	// m_pSibling指向结点自身
//	            -----------------
//	           \|/              |
	//  1-------2-------3-------4-------5
//	            |       | /|\          /|\
//	            |       | --            |
//	            |-----------------------|
	public void test2()
	{
		RandomListNode pNode1 = new RandomListNode(1);
		RandomListNode pNode2 = new RandomListNode(2);
		RandomListNode pNode3 = new RandomListNode(3);
		RandomListNode pNode4 = new RandomListNode(4);
		RandomListNode pNode5 = new RandomListNode(5);

		pNode1.next = pNode2;
		pNode2.next = pNode3;
		pNode3.next = pNode4;
		pNode4.next = pNode5;
		
		pNode2.random = pNode5;
		pNode3.random = pNode3;
		pNode4.random = pNode2;


	    test("Test2", pNode1);
	}

	// m_pSibling形成环
//	            -----------------
//	           \|/              |
	//  1-------2-------3-------4-------5
//	            |              /|\
//	            |               |
//	            |---------------|
	public void test3()
	{
		RandomListNode pNode1 = new RandomListNode(1);
		RandomListNode pNode2 = new RandomListNode(2);
		RandomListNode pNode3 = new RandomListNode(3);
		RandomListNode pNode4 = new RandomListNode(4);
		RandomListNode pNode5 = new RandomListNode(5);

		pNode1.next = pNode2;
		pNode2.next = pNode3;
		pNode3.next = pNode4;
		pNode4.next = pNode5;
		
		pNode2.random = pNode4;
		pNode4.random = pNode2;
		

	    test("Test3", pNode1);
	}

	// 只有一个结点
	public void test4()
	{
		RandomListNode pNode1 = new RandomListNode(1);
		pNode1.random = pNode1;

	    test("Test4", pNode1);
	}

	// 鲁棒性测试
	public void test5()
	{
	    test("Test5", null);
	}
	public static void main(String[] args) {
		CopyComplexList c = new CopyComplexList();
		c.test1();
		c.test2();
		c.test3();
		c.test4();
		c.test5();

	}

}

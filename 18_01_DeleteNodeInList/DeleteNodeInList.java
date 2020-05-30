//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题18（一）：在O(1)时间删除链表结点
// 题目：给定单向链表的头指针和一个结点指针，定义一个函数在O(1)时间删除该
// 结点。

// 思路：考虑到c++可以用指向指针的指针来修改链表头，java解答中采用返回值来修改链表头
//==================================================================
//DeleteNodeInList.java
public class DeleteNodeInList {

// =============内部类：链表结构==================
	class ListNode {
		int m_Value;
		ListNode m_Next = null;

		public ListNode(int n) {
			this.m_Value = n;
			this.m_Next = null;
		}
	}

// ==============算法实现==========================
//通过返回值修改链表头指针（主要针对删除有且仅有头节点时的情况）
	public ListNode deleteNode(ListNode pListHead, ListNode pToBeDeleted) {
		if (pListHead == null || pToBeDeleted == null) {
			return pListHead;
		}

		// 判断要删除的节点是否为尾节点
		if (pToBeDeleted.m_Next != null) {
			ListNode pNext = pToBeDeleted.m_Next;
			pToBeDeleted.m_Value = pNext.m_Value;
			pToBeDeleted.m_Next = pNext.m_Next;
			return pListHead;
		} else if (pListHead == pToBeDeleted) { // 链表只有一个节点，删除头节点(尾节点)
			pListHead = null;
			return pListHead;
		} else { // 链表有多个节点，删除尾节点
			ListNode pNode = pListHead;
			while (pNode.m_Next != pToBeDeleted) {
				pNode = pNode.m_Next;
			}
			pNode.m_Next = null;
			return pListHead;
		}
	}

// ====================测试代码=======================
//链表中多个节点，删除非尾节点	
	public void test1() {
		System.out.print("Test1: ");
		ListNode pNode1 = new ListNode(1);
		ListNode pNode2 = new ListNode(2);
		ListNode pNode3 = new ListNode(3);
		ListNode pNode4 = new ListNode(4);
		ListNode pNode5 = new ListNode(5);
		pNode1.m_Next = pNode2;
		pNode2.m_Next = pNode3;
		pNode3.m_Next = pNode4;
		pNode4.m_Next = pNode5;

		pNode1 = deleteNode(pNode1, pNode1);
		ListNode pNode = pNode1;
		while (pNode != null) {
			System.out.print(pNode.m_Value + " ");
			pNode = pNode.m_Next;
		}
	}

// 链表中一个节点，删除该节点
	public void test2() {
		System.out.print("Test2: ");
		ListNode pNode1 = new ListNode(1);
		pNode1 = deleteNode(pNode1, pNode1);
		ListNode pNode = pNode1;
		while (pNode != null) {
			System.out.print(pNode.m_Value + " ");
			pNode = pNode.m_Next;
		}
	}

// 链表中多个节点，删除尾节点
	public void test3() {
		System.out.print("Test3: ");
		ListNode pNode1 = new ListNode(1);
		ListNode pNode2 = new ListNode(2);
		ListNode pNode3 = new ListNode(3);
		ListNode pNode4 = new ListNode(4);
		ListNode pNode5 = new ListNode(5);
		pNode1.m_Next = pNode2;
		pNode2.m_Next = pNode3;
		pNode3.m_Next = pNode4;
		pNode4.m_Next = pNode5;
		pNode1 = deleteNode(pNode1, pNode5);
		ListNode pNode = pNode1;
		while (pNode != null) {
			System.out.print(pNode.m_Value + " ");
			pNode = pNode.m_Next;
		}
	}

// 链表为空
	public void test4() {
		System.out.print("Test4: ");
		ListNode pNode1 = null;
		pNode1 = deleteNode(pNode1, null);
		ListNode pNode = pNode1;
		while (pNode != null) {
			System.out.print(pNode.m_Value + " ");
			pNode = pNode.m_Next;
		}
	}

	public static void main(String[] args) {
		DeleteNodeInList d = new DeleteNodeInList();
		d.test1();
		System.out.println();
		d.test2();
		System.out.println();
		d.test3();
		System.out.println();
		d.test4();
	}

}

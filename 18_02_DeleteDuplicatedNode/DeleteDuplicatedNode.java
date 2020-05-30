//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题18（二）：删除链表中重复的结点
// 题目：在一个排序的链表中，如何删除重复的结点？例如，在图3.4（a）中重复
// 结点被删除之后，链表如图3.4（b）所示。

// 思路：考虑到c++可以用指向指针的指针来修改链表头，java解答中采用返回值来修改链表头
//==================================================================
//DeleteDuplicatedNode.java

public class DeleteDuplicatedNode {

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
	public ListNode deleteDuplication(ListNode pHead) {
		if (pHead == null) {
			return null;
		}
		ListNode preNode = null;
		ListNode pNode = pHead;
		while (pNode != null) {
			ListNode pNext = pNode.m_Next;
			boolean needDelete = false;
			if (pNext != null && pNode.m_Value == pNext.m_Value) {
				needDelete = true;
			}
			if (!needDelete) {
				preNode = pNode;
				pNode = pNext;
			} else {
				int value = pNode.m_Value;
				ListNode pToDelete = pNode;
				while (pToDelete != null && pToDelete.m_Value == value) {
					pNext = pToDelete.m_Next;
					pToDelete = pNext;
				}
				if (preNode == null) {
					pHead = pNext;
				} else {
					preNode.m_Next = pNext;
				}

				pNode = pNext;
			}
		}
		return pHead;
	}

// =====================测试代码=======================
// 某些节点是重复的
	public void test1() {
		System.out.print("Test1: ");
		ListNode pNode1 = new ListNode(1);
		ListNode pNode2 = new ListNode(2);
		ListNode pNode3 = new ListNode(3);
		ListNode pNode4 = new ListNode(3);
		ListNode pNode5 = new ListNode(4);
		ListNode pNode6 = new ListNode(4);
		ListNode pNode7 = new ListNode(5);
		pNode1.m_Next = pNode2;
		pNode2.m_Next = pNode3;
		pNode3.m_Next = pNode4;
		pNode4.m_Next = pNode5;
		pNode5.m_Next = pNode6;
		pNode6.m_Next = pNode7;
		pNode1 = deleteDuplication(pNode1);

		ListNode pNode = pNode1;
		while (pNode != null) {
			System.out.print(pNode.m_Value + " ");
			pNode = pNode.m_Next;
		}
	}

// 没有重复节点	
	public void test2() {
		System.out.print("Test2: ");
		ListNode pNode1 = new ListNode(1);
		ListNode pNode2 = new ListNode(2);
		ListNode pNode3 = new ListNode(3);
		ListNode pNode4 = new ListNode(4);
		ListNode pNode5 = new ListNode(5);
		ListNode pNode6 = new ListNode(6);
		ListNode pNode7 = new ListNode(7);
		pNode1.m_Next = pNode2;
		pNode2.m_Next = pNode3;
		pNode3.m_Next = pNode4;
		pNode4.m_Next = pNode5;
		pNode5.m_Next = pNode6;
		pNode6.m_Next = pNode7;
		pNode1 = deleteDuplication(pNode1);

		ListNode pNode = pNode1;
		while (pNode != null) {
			System.out.print(pNode.m_Value + " ");
			pNode = pNode.m_Next;
		}
	}

// 除了一个节点之外其他节点值都相同
	public void test3() {
		System.out.print("Test3: ");
		ListNode pNode1 = new ListNode(1);
		ListNode pNode2 = new ListNode(1);
		ListNode pNode3 = new ListNode(1);
		ListNode pNode4 = new ListNode(1);
		ListNode pNode5 = new ListNode(1);
		ListNode pNode6 = new ListNode(1);
		ListNode pNode7 = new ListNode(2);
		pNode1.m_Next = pNode2;
		pNode2.m_Next = pNode3;
		pNode3.m_Next = pNode4;
		pNode4.m_Next = pNode5;
		pNode5.m_Next = pNode6;
		pNode6.m_Next = pNode7;
		pNode1 = deleteDuplication(pNode1);

		ListNode pNode = pNode1;
		while (pNode != null) {
			System.out.print(pNode.m_Value + " ");
			pNode = pNode.m_Next;
		}
	}

// 所有节点的值都相同
	public void test4() {
		System.out.print("Test4: ");
		ListNode pNode1 = new ListNode(1);
		ListNode pNode2 = new ListNode(1);
		ListNode pNode3 = new ListNode(1);
		ListNode pNode4 = new ListNode(1);
		ListNode pNode5 = new ListNode(1);
		ListNode pNode6 = new ListNode(1);
		ListNode pNode7 = new ListNode(1);
		pNode1.m_Next = pNode2;
		pNode2.m_Next = pNode3;
		pNode3.m_Next = pNode4;
		pNode4.m_Next = pNode5;
		pNode5.m_Next = pNode6;
		pNode6.m_Next = pNode7;
		pNode1 = deleteDuplication(pNode1);

		ListNode pNode = pNode1;
		while (pNode != null) {
			System.out.print(pNode.m_Value + " ");
			pNode = pNode.m_Next;
		}
	}

	public static void main(String[] args) {
		DeleteDuplicatedNode d = new DeleteDuplicatedNode();
		d.test1();
		System.out.println();
		d.test2();
		System.out.println();
		d.test3();
		System.out.println();
		d.test4();
	}

}

//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题9：用两个栈实现队列
// 题目：用两个栈实现一个队列。队列的声明如下，请实现它的两个函数appendTail
// 和deleteHead，分别完成在队列尾部插入结点和在队列头部删除结点的功能。

// 思路：栈1用来添加数据，当需要删除头节点时，如果栈2为空，则将栈1中的数据放入栈2中，然后删除栈顶数据即可。
//==================================================================
//QueueWithTwoStacks.java

import java.util.Stack;
//<T> 表示泛型
public class QueueWithTwoStacks<T> {

	private Stack<T> stack1 = new Stack<T>();
	private Stack<T> stack2 = new Stack<T>();

// ====================算法实现===================
	public void appendTail(T node) {
		stack1.push(node);
	}
	
	public T deleteHead() throws Exception {
		if(stack2.size() <= 0){
			while(stack1.size() > 0) {
				stack2.push(stack1.pop());
			}
		}
		
		if(stack2.size() == 0) {
			throw new Exception("queue is empty");
		}
		
		return stack2.pop();
	}

// ==================测试代码=====================
	public static void Test1() {
		QueueWithTwoStacks<String> queue = new QueueWithTwoStacks<String>();
		queue.appendTail("a");
		queue.appendTail("b");
		queue.appendTail("c");
		
		try {
			System.out.println("删除的头节点是" + queue.deleteHead());
			System.out.println("删除的头节点是" + queue.deleteHead());
			queue.appendTail("d");
			System.out.println("删除的头节点是" + queue.deleteHead());
			queue.appendTail("e");
			System.out.println("删除的头节点是" + queue.deleteHead());
			System.out.println("删除的头节点是" + queue.deleteHead());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		Test1();
	}

}

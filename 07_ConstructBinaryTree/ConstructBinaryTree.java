//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 本人为初学者，参考原书籍。
// 面试题7：重建二叉树
// 题目：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输
// 入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,
// 2, 4, 7, 3, 5, 6, 8}和中序遍历序列{4, 7, 2, 1, 5, 3, 8, 6}，则重建出
// 图2.6所示的二叉树并输出它的头结点。

// 思路：1、前序遍历中第一个节点即为头节点
// 2、从中序遍历中找到头节点，其左边为左子树节点，右边为右子树节点
// 3、重复上述操作，递归重建二叉树
// 注：需要自己二叉树结构，本题创建简单的二叉树结构即可。
//==================================================================
//===========================创建二叉树节点类=========================
// TreeNode.java
// 遍历方法写成静态的方便调用
//树节点类
public class TreeNode {

	public int value;
	public TreeNode left;
	public TreeNode right;
	
	//构造函数
	public TreeNode(int value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}

	//前序遍历:递归实现
	public void preOrder(TreeNode root) {
		if(root != null) {
			System.out.print(root.value + " ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	
	//中序遍历:递归实现
	public void inOrder(TreeNode root) {
		if(root != null) {			
			inOrder(root.left);
			System.out.print(root.value + " ");
			inOrder(root.right);
		}
	}
	
	//后序遍历:递归实现
	public void postOrder(TreeNode root) {
		if(root != null) {			
			inOrder(root.left);
			inOrder(root.right);
			System.out.print(root.value + " ");
		}
	}
	
}

//=============================算法实现================================
//ConstructBinaryTree.java
//重构二叉树(前序遍历和中序遍历)

import binTree.TreeNode;

public class ConstructBinaryTree {

	public TreeNode ConstructCore(int preorder[], int startPreorder, int endPreorder, int inorder[], int startInorder,
			int endInorder) {
		int rootValue = preorder[startPreorder];
		TreeNode root = new TreeNode(rootValue);

		if (startPreorder == endPreorder) {
			if (startInorder == endInorder && preorder[startPreorder] == inorder[startInorder]) {
				return root;
			} else {
				System.out.print("Invalid input");
				return null;
			}
		}

		// 在中序遍历中找到根节点的值
		int rootInorder = startInorder;
		while (rootInorder <= endInorder && inorder[rootInorder] != rootValue) {
			++rootInorder;
		}

		if (rootInorder == endInorder && inorder[rootInorder] != rootValue) {
			System.out.print("Invalid input");
			return null;
		}

		int leftLength = rootInorder - startInorder;
		int leftPreorderEnd = startPreorder + leftLength;

		if (leftLength > 0) {
			// 构建左子树
			root.left = ConstructCore(preorder, startPreorder + 1, leftPreorderEnd, inorder, startInorder,
					rootInorder - 1);
		}
		if (leftLength < endPreorder - startPreorder) {
			// 构建右子树
			root.right = ConstructCore(preorder, leftPreorderEnd + 1, endPreorder, inorder, rootInorder + 1,
					endInorder);
		}

		return root;
	}

	public TreeNode Construct(int[] preorder, int[] inorder) {
		if (preorder == null || inorder == null || preorder.length <= 0 || inorder.length <= 0) {
			return null;
		}

		return ConstructCore(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
	}

	
	
//===================测试代码===========================
// 重构二叉树完成后，采用前序遍历进行输出验证结果
// 普通二叉树
//	  1
//	/     \
//	2       3  
//	/       / \
//	4       5   6
//	\         /
//	7       8
	void Test1()
	{
	    int preorder[] = {1, 2, 4, 7, 3, 5, 6, 8};
	    int inorder[] = {4, 7, 2, 1, 5, 3, 8, 6};
	    TreeNode t = Construct(preorder, inorder);
	    t.preOrder(t);
	    System.out.println();
	}		
			
// 所有结点都没有右子结点
//	  1
//	 / 
//	2   
//	/ 
//	3 
//	/
//	4
//	/
//	5
	void Test2()
	{
	    int preorder[] = {1, 2, 3, 4, 5};
	    int inorder[] = {5, 4, 3, 2, 1};
	    TreeNode t = Construct(preorder, inorder);
	    t.preOrder(t);
	    System.out.println();
	}
	
// 所有结点都没有左子结点
//  1
//   \ 
//    2   
//     \ 
//      3 
//       \
//        4
//         \
//          5
	void Test3()
	{
	    int preorder[] = {1, 2, 3, 4, 5};
	    int inorder[] = {1, 2, 3, 4, 5};
	    TreeNode t = Construct(preorder, inorder);
	    t.preOrder(t);
	    System.out.println();
	}
	
	// 树中只有一个结点
	void Test4()
	{
	    int preorder[] = {1};
	    int inorder[] = {1};
	    TreeNode t = Construct(preorder, inorder);
	    t.preOrder(t);
	    System.out.println();
	}
	
// 完全二叉树
//	  1
//	/     \
//	2       3  
//	/ \     / \
//	4   5   6   7
	void Test5()
	{

	int preorder[] = {1, 2, 4, 5, 3, 6, 7};
	int inorder[] = {4, 2, 5, 1, 6, 3, 7};
    TreeNode t = Construct(preorder, inorder);
    t.preOrder(t);
    System.out.println();
	}
	
	// 输入空指针
	void Test6()
	{
		int preorder[] = null;
		int inorder[] = null;
	    TreeNode t = Construct(preorder, inorder);
	    if(t == null) {
		    System.out.println();
	    }
	}

	// 输入的两个序列不匹配
	void Test7()
	{
	    int preorder[] = {1, 2, 4, 5, 3, 6, 7};
	    int inorder[] = {4, 2, 8, 1, 6, 3, 7};
	    TreeNode t = Construct(preorder, inorder);
	    t.preOrder(t);
	    System.out.println();
	}
	
	public static void main(String[] args) {
		ConstructBinaryTree constructBinaryTree = new ConstructBinaryTree();
		constructBinaryTree.Test1();
		constructBinaryTree.Test2();
		constructBinaryTree.Test3();
		constructBinaryTree.Test4();
		constructBinaryTree.Test5();
		constructBinaryTree.Test6();
		constructBinaryTree.Test7();

	}

}



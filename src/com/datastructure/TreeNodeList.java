package com.datastructure;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

// 二叉树相关的算法
public class TreeNodeList {
	TreeNode root;

	class TreeNode {
		private int value;

		private TreeNode left = null;
		private TreeNode right = null;
		private TreeNode parent = null;

		public TreeNode(int value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}

		public TreeNode() {
			root = null;
		}

		public TreeNode(int value, TreeNode left, TreeNode right, TreeNode parent) {
			super();
			this.value = value;
			this.left = left;
			this.right = right;
			this.parent = parent;
		}

		public int getvalueue() {
			return value;
		}

		public void setvalueue(int value) {
			this.value = value;
		}

		public TreeNode getLeft() {
			return left;
		}

		public void setLeft(TreeNode left) {
			this.left = left;
		}

		public TreeNode getRight() {
			return right;
		}

		public TreeNode getParent() {
			return parent;
		}

		@Override
		public String toString() {
			return "TreeNode [value=" + value + ", left=" + left + ", right=" + right + "]";
		}

		public void setRight(TreeNode right) {
			this.right = right;
		}
	}

	// 生成二叉树
	public boolean add(TreeNode bt, int value) {
		if (root == null) {
			root = new TreeNode(value);
		} else {
			if (value < bt.value) {
				if (bt.left == null) {
					bt.left = new TreeNode(value);
				} else {
					add(bt.left, value);
				}
			} else if (value > bt.value) {
				if (bt.right == null) {
					bt.right = new TreeNode(value);
				} else {
					add(bt.right, value);
				}
			} else {
				// 有重复值了
				return false;
			}
		}
		return true;
	}

	// 遍历方式
	// 前序遍历

	private void preOrderScan(TreeNode bt) {
		if (bt == null) {
			return;
		}
		System.out.print(bt.value + " ");
		preOrderScan(bt.left);
		preOrderScan(bt.right);
	}

	public void preOrderScan() {
		preOrderScan(root);
	}

	private void inOrderScan(TreeNode bt) {
		if (bt == null) {
			return;
		}
		inOrderScan(bt.left);
		System.out.print(bt.value + " ");
		inOrderScan(bt.right);
	}

	public void inOrderScan() {
		inOrderScan(root);
	}

	private void postOrderScan(TreeNode bt) {
		if (bt == null) {
			return;
		}
		postOrderScan(bt.left);
		postOrderScan(bt.right);
		System.out.println(bt.value + " ");
	}

	public void postOrderScan() {
		postOrderScan(root);
	}

	// 非递归遍历二叉树
	private void preOrderScanByStack(TreeNode bt) {
		if (root == null) {
			return;
		}
		TreeNode cur = bt;
		Deque<TreeNode> sNodes = new LinkedList<TreeNodeList.TreeNode>();
		while (!sNodes.isEmpty() || cur != null) {
			// 边遍历边打印，并存入栈中，并且需要借助这些节点进入右子树
			while (cur != null) {
				System.out.println(cur.value + " ");
				sNodes.addFirst(cur);
				cur = cur.left;
			}
			// p为空的时候，说明根和左子树都已经遍历结束了，可以进入右子树了
			if (!sNodes.isEmpty()) {
				cur = sNodes.removeFirst();
				cur = cur.right;
			}
		}
	}

	public void preOrderScanByStack() {
		preOrderScanByStack(root);
	}

	private void inOrderScanByStack(TreeNode bt) {
		if (bt == null) {
			return;
		}
		TreeNode cur = bt;
		Deque<TreeNode> sDeque = new LinkedList<TreeNode>();
		while (!sDeque.isEmpty() || cur != null) {
			if (cur != null) {
				sDeque.addFirst(cur);
				cur = cur.left;
			} else {
				cur = sDeque.removeFirst();
				System.out.println(cur.value);
				cur = cur.right;
			}
		}
	}

	public void inOrderScanByStack() {
		inOrderScanByStack(root);
	}

	// 后序遍历
	private void postOrderScanByStack(TreeNode root) {
		if (root == null)
			return;
		Deque<TreeNode> sDeque = new LinkedList<TreeNode>();
		// pCur:当前访问节点，pLastVisit:上次访问节点
		TreeNode pCur, pLastVisit = null;
		// pCur = root;
		pCur = root;
		// 先把pCur移动到左子树最下边
		while (pCur != null) {
			sDeque.addFirst(pCur);
			pCur = pCur.left;
		}
		while (!sDeque.isEmpty()) {
			// 走到这里，pCur都是空，并已经遍历到左子树底端(看成扩充二叉树，则空，亦是某棵树的左孩子)
			pCur = sDeque.peek();
			sDeque.pop();
			// 一个根节点被访问的前提是：无右子树或右子树已被访问过
			if (pCur.left == null || pCur.left == pLastVisit) {
				System.out.println(pCur.value + " ");
				// 修改最近被访问的节点
				pLastVisit = pCur;
			}
			/*
			 * 这里的else语句可换成带条件的else if: else if (pCur->lchild ==
			 * pLastVisit)//若左子树刚被访问过，则需先进入右子树(根节点需再次入栈) 因为：上面的条件没通过就一定是下面的条件满足。仔细想想！
			 */
			else {
				// 根节点再次入栈
				sDeque.push(pCur);
				// 进入右子树，且可肯定右子树一定不为空
				pCur = pCur.right;
				while (pCur != null) {
					sDeque.push(pCur);
					pCur = pCur.left;
				}
			}
		}
	}

	public void postOrderScanByStack() {
		postOrderScanByStack(root);
	}

	// 判断两个树是否相同
	public boolean isSameTree(TreeNode l, TreeNode r) {
		if (l == null && r == null) {
			return true;
		}
		if (l == null || r == null) {
			return false;
		}
		if (l.value == r.value) {
			return isSameTree(l.left, r.left) && isSameTree(l.right, r.right);
		}
		return false;
	}

	// 是否对称
	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		return isMirror(root.left, root.right);
	}

	public boolean isMirror(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		if (p == null || q == null)
			return false;
		if (p.value != q.value)
			return false;
		return isMirror(p.left, q.right) && isMirror(p.right, q.left);
	}

	// 非递归
	public boolean isSymmetricByStack(TreeNode root) {
		if (root == null)
			return true;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode left, right;
		if (root.left != null) {
			if (root.right == null)
				return false;
			stack.push(root.left);
			stack.push(root.right);
		} else if (root.right != null) {
			return false;
		}

		while (!stack.empty()) {
			if (stack.size() % 2 != 0)
				return false;
			right = stack.pop();
			left = stack.pop();
			if (right.value != left.value)
				return false;

			if (left.left != null) {
				if (right.right == null)
					return false;
				stack.push(left.left);
				stack.push(right.right);
			} else if (right.right != null) {
				return false;
			}

			if (left.right != null) {
				if (right.left == null)
					return false;
				stack.push(left.right);
				stack.push(right.left);
			} else if (right.left != null) {
				return false;
			}
		}

		return true;
	}
	// 层次遍历
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        levelGo(res,root,0);
        return res;
    }
    public void levelGo(List<List<Integer>> list,TreeNode t,int level){
        if(t==null) return;
        if(list.size()<=level){
            list.add(new ArrayList<Integer>());
        }
        levelGo(list,t.left,level+1);
        levelGo(list,t.right,level+1);
        list.get(level).add(t.value);
    }
    // 层次遍历反向 从叶子到根层
    public List<List<Integer>> levelOrderBottomReverse(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelGoReverse(res,root,1);
        return res;
    }
    public void levelGoReverse(List<List<Integer>> list,TreeNode t,int level){
        if(t==null) return;
        if(list.size()<level){
            list.add(0,new ArrayList<Integer>());
        }
        levelGo(list,t.left,level+1);
        levelGo(list,t.right,level+1);
        list.get(list.size()-level).add(t.value);
    }

	// 求树的最大深度
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}

	// 非递归式
	// 深度优先
	public int maxDepthByStackDFS(TreeNode root) {
		if (root == null) {
			return 0;
		}

		Stack<TreeNode> stack = new Stack<>();
		Stack<Integer> value = new Stack<>();
		stack.push(root);
		value.push(1);
		int max = 0;
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			int temp = value.pop();
			max = Math.max(temp, max);
			if (node.left != null) {
				stack.push(node.left);
				value.push(temp + 1);
			}
			if (node.right != null) {
				stack.push(node.right);
				value.push(temp + 1);
			}
		}
		return max;
	}

	// 非递归式
	// 广度优先
	public int maxDepthByStackBFS(TreeNode root) {
		if (root == null) {
			return 0;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int count = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				TreeNode node = queue.poll();
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
			count++;
		}
		return count;
	}
	// 有序数组转换为二叉搜索树
	public TreeNode sortedArrayToBST(int[] nums) {
        return sortArray(nums,0,nums.length-1);
    }
    public TreeNode sortArray(int[] nums,int s,int e){
        if(s > e)return null;
        int mid = s + (e-s)/2;
        TreeNode t = new TreeNode(nums[mid]);
        t.left = sortArray(nums,s,mid-1);
        t.right = sortArray(nums,mid+1,e);
        return t;
    }
    // 非递归的方式
    public TreeNode sortedArrayToBSTByStack(int[] nums) {       
        int len = nums.length;
        if ( len == 0 ) { return null; }
        TreeNode head = new TreeNode(0);         
        Stack<TreeNode> nodeStack       = new Stack<TreeNode>() ;//要被对应序号创建的节点压入此栈
        nodeStack.push(head);
        Stack<Integer>  leftIndexStack  = new Stack<Integer>();
        leftIndexStack.push(0);
        Stack<Integer>  rightIndexStack = new Stack<Integer>();
        rightIndexStack.push(len-1);
        while ( !nodeStack.isEmpty() ) {
            TreeNode currNode = nodeStack.pop();
            int left  = leftIndexStack.pop();
            int right = rightIndexStack.pop();
            int mid   = left + (right-left)/2; // avoid overflow
            currNode.value = nums[mid];
            if ( left <= mid-1 ) {
                currNode.left = new TreeNode(0);  
                nodeStack.push(currNode.left);
                leftIndexStack.push(left);
                rightIndexStack.push(mid-1);
            }
            if ( mid+1 <= right ) {
                currNode.right = new TreeNode(0);
                nodeStack.push(currNode.right);
                leftIndexStack.push(mid+1);
                rightIndexStack.push(right);
            }
        }
        return head;
    }

    // 判断这个数是否平衡 每个节点的子树高度差不超过1
    // 递归方式
    public int depth(TreeNode root) {
    	if(root == null) {
    		return 0;
    	}
    	return Math.max(depth(root.left), depth(root.right)) + 1;
    }
    
    public boolean isBalanced(TreeNode root) {
    	if(root == null) {
    		return true;
    	}
    	int left = depth(root.left);
    	int right = depth(root.right);
    	return Math.abs(left-right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
    
    // 非递归的方式判断 树是否平衡
    public boolean isBalancedByStack(TreeNode root) {
        if(root == null) return true;
        return ban(root)!= -1;
    }
    public int ban(TreeNode t){
        if(t == null)return 0;
        int tl = ban(t.left);
        if(tl == -1)return -1;
        int tr = ban(t.right);
        if(tr == -1)return -1;
        if(tl - tr>1||tl-tr<-1) return -1;
        return Math.max(tl,tr)+1;
    }
    
    // 只需要遍历一次的解法，判断是否是平衡二叉树
    public boolean isBanlance(TreeNode rt, int pDepth) {
    	if(rt == null) {
    		pDepth = 0;
    		return true;
    	}
    	int left = 0, right = 0;
    	if(isBanlance(rt.left, left) && isBanlance(rt.right, right)) {
    		int diff = left - right;
    		if(diff <= 1 || diff >= -1) {
    			pDepth = 1 + ((left > right) ? left : right);
    			return true;
    		}
    	}
    	return false;
    }
    // 求树的宽度
    public int treeWidth(TreeNode bt) {
    	LinkedList<TreeNode> linkedList = new LinkedList<>();
    	linkedList.offer(bt);
    	int currentIndex;// 当前位置节点。
        int lastIndex;// 当前层最大节点的数量，即当前层树的宽度。
        TreeNode currentBinaryTree;// 当前取出的节点。
        int maxLen = 0;// 最大层的值。
        while (!linkedList.isEmpty()) {
            currentIndex = 0;
            lastIndex = linkedList.size();
            while (currentIndex < lastIndex) {
                currentBinaryTree = linkedList.poll();
                currentIndex++;
                // 以下是将下一层加入队列，在下次循环中进行计算
                if (currentBinaryTree.left != null) {
                    linkedList.offer(currentBinaryTree.left);
                }
                if (currentBinaryTree.right != null) {
                    linkedList.offer(currentBinaryTree.right);
                }
            }
            // 处理最大层的数量
            if (lastIndex > maxLen) {
                maxLen = lastIndex;
            }
        }
        return maxLen;
    }
 // 递归求树的深度
    int treeDeepByRecursion(TreeNode binaryTree) {
        if (binaryTree == null)
            return 0;
        int leftDeep = treeDeepByRecursion(binaryTree.left);
        int rightDeep = treeDeepByRecursion(binaryTree.right);
        return leftDeep > rightDeep ? leftDeep + 1 : rightDeep + 1;
    }

    /*
     * 非递归求树的深度，思路：
     * 1.维护一个当前队列节点的长度a，在初始化一个长度为零的变量b。变量每次加一，取出一个数据，同时加入该节点的左右孩纸。当a=b,结束当前循环。
     * 2. 结束循环前维护一个深度l，深度l++。 3. 重复1,2。当队列时结束。
     */
    int treeDeepByNoRecursion(TreeNode binaryTree) {
        if (binaryTree == null)
            return 0;
        // 维护一个队列，
        LinkedList<TreeNode> binaryTreeList = new LinkedList<>();
        binaryTreeList.offer(binaryTree);
        int currentIndex;
        int lastIndex;
        TreeNode currentBinaryTree;
        //深度
        int leval=0;
        //结束条件
        while(!binaryTreeList.isEmpty()){
            currentIndex=0;
            lastIndex=binaryTreeList.size();
            while (currentIndex < lastIndex) {
                // poll取出一个元素，并从原来队列删除；peek查询第一个数据。
                currentBinaryTree = binaryTreeList.poll();
                currentIndex++;
                // 以下是将下一层加入队列，在下次循环中进行计算
                if (currentBinaryTree.left != null) {
                    binaryTreeList.offer(currentBinaryTree.left);
                }
                if (currentBinaryTree.right != null) {
                    binaryTreeList.offer(currentBinaryTree.right);
                }
            }
            leval++;

        }
        return leval;

    }
    // 找出二叉树的所有深度遍历路径
    ArrayList<Integer> list3 = new ArrayList<>();
    ArrayList<ArrayList<Integer>> listList3 = new ArrayList<>();

    private ArrayList<ArrayList<Integer>> getAllDeepPath(TreeNode binaryTree) {
        if (binaryTree == null)
            return listList3;
        list3.add(binaryTree.value);
        if (binaryTree.left == null && binaryTree.right == null) {
            // 这种写法不行，原因：@param c the collection whose elements are to be placed
            // into this list
            // listList3.add(list3);
            listList3.add(new ArrayList<Integer>(list3));//
        }
        if (binaryTree.left != null)
            getAllDeepPath(binaryTree.left);
        if (binaryTree.right != null)
            getAllDeepPath(binaryTree.right);
        list3.remove(list3.size() - 1);
        return listList3;
    }

    // 在二叉树中找出和为某一值的所有路径
    List<Integer> list4 = new ArrayList<>();
    List<List<Integer>> allList4 = new ArrayList<>();
    private List<List<Integer>> getSpDeepTree(TreeNode binaryTree, int target) {
        if (binaryTree == null)
            return allList4;
        list4.add(binaryTree.value);
        target -= binaryTree.value;
        if (target == 0 && binaryTree.left == null && binaryTree.right == null)
            allList4.add(new ArrayList<>(list4));
        if (binaryTree.left != null)
            getSpDeepTree(binaryTree.left, target);
        if (binaryTree.right != null)
            getSpDeepTree(binaryTree.right, target);

        list4.remove(list4.size() - 1);
        return allList4;
    }
    // 根据有序二叉树生成一棵平衡二叉树
    public TreeNode generateTree(int[] arr) {
    	if(arr==null||arr.length==0) {
    		return null;
    	}
    	return generate(arr, 0, arr.length);
    }
    private TreeNode generate(int[] arr, int s, int e) {
    	if(s>e) {
    		return null;
    	}
    	int mid = (s+e)/2;
    	TreeNode root = new TreeNode(arr[mid]);
    	root.left = generate(arr, s, mid-1);
    	root.right = generate(arr, mid+1, e);
    	return root;
    }
    // 判断一棵树是否是完全二叉树
    // 按层次遍历二叉树，从每层的左边到右边依次开始遍历所有的节点，如果当前节点有右孩子，但是没有左孩子，直接返回false
    // 如果当前节点并不是左右孩子全部都有，那之后的节点必须是叶子结点，负责的话false
    // 遍历过程中不返回false，就返回true
    public boolean isCompleteTree(TreeNode root) {
    	if(root == null) {
    		return true;
    	}
    	Deque<TreeNode> list = new LinkedList<>();
    	boolean leaf = false; // 记录是否是叶子节点
    	TreeNode left = null;
    	TreeNode right = null;
    	list.offer(root);
    	while(!list.isEmpty()) {
    		root = list.poll();
    		left = root.left;
    		right = root.right;
    		if((leaf==true&&(left!=null||right!=null)) || (left==null && right != null)) {
    			return false;
    		}
    		if(left != null) {
    			list.offer(left);
    		}
    		if(right != null) {
    			list.offer(right);
    		} else {
    			leaf = true;
    		}
    	}
    	return true;
    }
    // 根据后序数组重建二叉树
    // 首先先判断一下这个数组是不是二叉树后序遍历以后的结果
    public boolean isPostArray(int[] array) {
    	if(array == null || array.length == 0) {
    		return false;
    	}
    	return isPostArray(array, 0, array.length-1);
    }
    
    private boolean isPostArray(int[] arr, int s, int e) {
    	if(s == e) {
    		return true;
    	}
    	int less = -1;
    	int more = e;
    	for(int i = s; i < e; i++) {
    		if(arr[e] > arr[i]) {
    			less = i;
    		} else {
    			more = more == e ? i : more;
    		}
    	}
    	if(less == -1 || more == e) {
    		return isPostArray(arr, s, e - 1);
    	}
    	if(less != more -1) {
    		return false;
    	}
    	return isPostArray(arr, s, less) && isPostArray(arr, more, e-1);
    }
    // 二叉搜索树的第K大节点
    int index = 0;
    public TreeNode kThNode(TreeNode root, int k) {
    	if(root != null) {
    		TreeNode node = kThNode(root.left, k);
    		if(node != null) {
    			return node;
    		}
    		index++;
    		if(index == k) {
    			return root;
    		}
    		node = kThNode(root.right, k);
    		if(node != null) {
    			return node;
    		}
    	}
    	return null;
    }
    
    // 二叉树的高度
    // 二叉树的深度
    public int treeDepth(TreeNode rt) {
    	if(rt == null) {
    		return 0;
    	}
    	int leftD = treeDepth(rt.left);
    	int rightD = treeDepth(rt.right);
    	return leftD > rightD ? (leftD+1) : (rightD+1);
    }
    
    
    
    // TO DO : 反转二叉树
    public TreeNode invertTree(TreeNode root) {
    	if(root == null) {
    		return null;
    	}
    	if(root.left != null) {
    		invertTree(root.left);
    	}
    	if(root.right != null) {
    		invertTree(root.right);
    	}
    	TreeNode temp = root.left;
    	root.left = root.right;
    	root.right = temp;
    	return root;
    }
    
    // 之字形打印二叉樹
    // 第一行按照从左往右，第二层按照从右往左的顺序打印，第三行按照从左往右打印，依次类推
    public ArrayList<ArrayList<Integer>> printZhi(TreeNode tr) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    	if(tr == null) {
    		return null;
    	}
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	int rows = 1;
    	queue.add(tr);
    	while(!queue.isEmpty()) {
    		ArrayList<Integer> list = new ArrayList<>();
    		int size = queue.size();
    		for(int i = 0; i < size; i++) {
    			TreeNode treeNode = queue.poll();
    			if(rows % 2 == 0) {
    				list.add(0, treeNode.value);
    				// 将元素插入指定位置（头部），就相当于倒序了
    			} else {
    				list.add(treeNode.value);
    				// 将元素插入尾部
    			}
    			if(treeNode.left != null) {
    				queue.offer(treeNode.left);
    			}
    			if(treeNode.right != null) {
    				queue.offer(treeNode.right);
    			}
    		}
    		result.add(list);
    		rows++;
    	}
    	return result;
    }
    
    // 二叉树是否对称
    public boolean isSymmertrical(TreeNode rt) {
    	if(rt == null) {
    		return true;
    	}
    	return judgeChild(rt.left, rt.right);
    }
    
    public boolean judgeChild(TreeNode l, TreeNode r) {
    	if(l == null && r != null) {
    		return false;
    	}
    	if(l != null && r == null) {
    		return false;
    	}
    	if(l.value != r.value) {
    		return false;
    	}
    	return judgeChild(l.left, r.right) && judgeChild(l.right, r.left);
    }
    
    // 打印二叉树上所有的路径，使路径上所有节点之和刚好等于某个整数
    public ArrayList<ArrayList<Integer>> findPath(TreeNode rt, int target) {
    	ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	return findPath(rt, target, listAll, list);
    }
    public ArrayList<ArrayList<Integer>> findPath(TreeNode rt, int target, ArrayList<ArrayList<Integer>> listAll, ArrayList<Integer> list) {
    	if(rt == null) {
    		return listAll;
    	}
    	list.add(rt.value);
    	target = target - rt.value;
    	if(target == 0 && rt.left == null && rt.right == null) {
    		listAll.add(list);
    	}
    	findPath(rt.left, target, listAll, list);
    	findPath(rt.right, target, listAll, list);
    	list.remove(list.size()-1);
    	return listAll;
    }
    
    public static void main(String[] args) {
    	int[] arr = new int[] { 5, 3, 4, 1, 7, 8, 2, 6, 0, 9 };
        TreeNodeList binaryTreeList = new TreeNodeList();
        for (int i = 0; i < arr.length; i++) {
            binaryTreeList.add(binaryTreeList.root, arr[i]);
        }
        System.out.println("前序遍历");
        binaryTreeList.postOrderScan(binaryTreeList.root);
        System.out.println("中序遍历");
        binaryTreeList.inOrderScan(binaryTreeList.root);
        System.out.println("后序遍历");
        binaryTreeList.postOrderScan(binaryTreeList.root);
        System.out.println();
        System.out.println("递归树的深度："
                + binaryTreeList.treeDeepByRecursion(binaryTreeList.root));
        System.out.println("非递归树的深度："
                + binaryTreeList.treeDeepByNoRecursion(binaryTreeList.root));
        System.out.println("递归树的宽度："
                + binaryTreeList.treeWidth(binaryTreeList.root));

        System.out.println("在二叉树中找所有路径2:");
        ArrayList<ArrayList<Integer>> findPath3 = binaryTreeList
                .getAllDeepPath(binaryTreeList.root);
        for (List<Integer> arrayList : findPath3) {
            for (Integer integer : arrayList) {
                System.out.print(integer + ",");
            }
            System.out.println();
        }

        System.out.println("在二叉树中找出和为某一值的所有路径2:");
        List<List<Integer>> findPath4 = binaryTreeList.getSpDeepTree(
                binaryTreeList.root, 12);
        for (List<Integer> arrayList : findPath4) {
            for (Integer integer : arrayList) {
                System.out.print(integer + ",");
            }
            System.out.println();
        }
	}
}

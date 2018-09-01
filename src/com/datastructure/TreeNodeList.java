package com.datastructure;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

// ��������ص��㷨
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

	// ���ɶ�����
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
				// ���ظ�ֵ��
				return false;
			}
		}
		return true;
	}

	// ������ʽ
	// ǰ�����

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

	// �ǵݹ����������
	private void preOrderScanByStack(TreeNode bt) {
		if (root == null) {
			return;
		}
		TreeNode cur = bt;
		Deque<TreeNode> sNodes = new LinkedList<TreeNodeList.TreeNode>();
		while (!sNodes.isEmpty() || cur != null) {
			// �߱����ߴ�ӡ��������ջ�У�������Ҫ������Щ�ڵ����������
			while (cur != null) {
				System.out.println(cur.value + " ");
				sNodes.addFirst(cur);
				cur = cur.left;
			}
			// pΪ�յ�ʱ��˵���������������Ѿ����������ˣ����Խ�����������
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

	// �������
	private void postOrderScanByStack(TreeNode root) {
		if (root == null)
			return;
		Deque<TreeNode> sDeque = new LinkedList<TreeNode>();
		// pCur:��ǰ���ʽڵ㣬pLastVisit:�ϴη��ʽڵ�
		TreeNode pCur, pLastVisit = null;
		// pCur = root;
		pCur = root;
		// �Ȱ�pCur�ƶ������������±�
		while (pCur != null) {
			sDeque.addFirst(pCur);
			pCur = pCur.left;
		}
		while (!sDeque.isEmpty()) {
			// �ߵ����pCur���ǿգ����Ѿ��������������׶�(�����������������գ�����ĳ����������)
			pCur = sDeque.peek();
			sDeque.pop();
			// һ�����ڵ㱻���ʵ�ǰ���ǣ������������������ѱ����ʹ�
			if (pCur.left == null || pCur.left == pLastVisit) {
				System.out.println(pCur.value + " ");
				// �޸���������ʵĽڵ�
				pLastVisit = pCur;
			}
			/*
			 * �����else���ɻ��ɴ�������else if: else if (pCur->lchild ==
			 * pLastVisit)//���������ձ����ʹ��������Ƚ���������(���ڵ����ٴ���ջ) ��Ϊ�����������ûͨ����һ����������������㡣��ϸ���룡
			 */
			else {
				// ���ڵ��ٴ���ջ
				sDeque.push(pCur);
				// �������������ҿɿ϶�������һ����Ϊ��
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

	// �ж��������Ƿ���ͬ
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

	// �Ƿ�Գ�
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

	// �ǵݹ�
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
	// ��α���
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
    // ��α������� ��Ҷ�ӵ�����
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

	// ������������
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}

	// �ǵݹ�ʽ
	// �������
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

	// �ǵݹ�ʽ
	// �������
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
	// ��������ת��Ϊ����������
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
    // �ǵݹ�ķ�ʽ
    public TreeNode sortedArrayToBSTByStack(int[] nums) {       
        int len = nums.length;
        if ( len == 0 ) { return null; }
        TreeNode head = new TreeNode(0);         
        Stack<TreeNode> nodeStack       = new Stack<TreeNode>() ;//Ҫ����Ӧ��Ŵ����Ľڵ�ѹ���ջ
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

    // �ж�������Ƿ�ƽ�� ÿ���ڵ�������߶Ȳ����1
    // �ݹ鷽ʽ
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
    
    // �ǵݹ�ķ�ʽ�ж� ���Ƿ�ƽ��
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
    
    // ֻ��Ҫ����һ�εĽⷨ���ж��Ƿ���ƽ�������
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
    // �����Ŀ��
    public int treeWidth(TreeNode bt) {
    	LinkedList<TreeNode> linkedList = new LinkedList<>();
    	linkedList.offer(bt);
    	int currentIndex;// ��ǰλ�ýڵ㡣
        int lastIndex;// ��ǰ�����ڵ������������ǰ�����Ŀ�ȡ�
        TreeNode currentBinaryTree;// ��ǰȡ���Ľڵ㡣
        int maxLen = 0;// �����ֵ��
        while (!linkedList.isEmpty()) {
            currentIndex = 0;
            lastIndex = linkedList.size();
            while (currentIndex < lastIndex) {
                currentBinaryTree = linkedList.poll();
                currentIndex++;
                // �����ǽ���һ�������У����´�ѭ���н��м���
                if (currentBinaryTree.left != null) {
                    linkedList.offer(currentBinaryTree.left);
                }
                if (currentBinaryTree.right != null) {
                    linkedList.offer(currentBinaryTree.right);
                }
            }
            // �������������
            if (lastIndex > maxLen) {
                maxLen = lastIndex;
            }
        }
        return maxLen;
    }
 // �ݹ����������
    int treeDeepByRecursion(TreeNode binaryTree) {
        if (binaryTree == null)
            return 0;
        int leftDeep = treeDeepByRecursion(binaryTree.left);
        int rightDeep = treeDeepByRecursion(binaryTree.right);
        return leftDeep > rightDeep ? leftDeep + 1 : rightDeep + 1;
    }

    /*
     * �ǵݹ���������ȣ�˼·��
     * 1.ά��һ����ǰ���нڵ�ĳ���a���ڳ�ʼ��һ������Ϊ��ı���b������ÿ�μ�һ��ȡ��һ�����ݣ�ͬʱ����ýڵ�����Һ�ֽ����a=b,������ǰѭ����
     * 2. ����ѭ��ǰά��һ�����l�����l++�� 3. �ظ�1,2��������ʱ������
     */
    int treeDeepByNoRecursion(TreeNode binaryTree) {
        if (binaryTree == null)
            return 0;
        // ά��һ�����У�
        LinkedList<TreeNode> binaryTreeList = new LinkedList<>();
        binaryTreeList.offer(binaryTree);
        int currentIndex;
        int lastIndex;
        TreeNode currentBinaryTree;
        //���
        int leval=0;
        //��������
        while(!binaryTreeList.isEmpty()){
            currentIndex=0;
            lastIndex=binaryTreeList.size();
            while (currentIndex < lastIndex) {
                // pollȡ��һ��Ԫ�أ�����ԭ������ɾ����peek��ѯ��һ�����ݡ�
                currentBinaryTree = binaryTreeList.poll();
                currentIndex++;
                // �����ǽ���һ�������У����´�ѭ���н��м���
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
    // �ҳ���������������ȱ���·��
    ArrayList<Integer> list3 = new ArrayList<>();
    ArrayList<ArrayList<Integer>> listList3 = new ArrayList<>();

    private ArrayList<ArrayList<Integer>> getAllDeepPath(TreeNode binaryTree) {
        if (binaryTree == null)
            return listList3;
        list3.add(binaryTree.value);
        if (binaryTree.left == null && binaryTree.right == null) {
            // ����д�����У�ԭ��@param c the collection whose elements are to be placed
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

    // �ڶ��������ҳ���Ϊĳһֵ������·��
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
    // �����������������һ��ƽ�������
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
    // �ж�һ�����Ƿ�����ȫ������
    // ����α�������������ÿ�����ߵ��ұ����ο�ʼ�������еĽڵ㣬�����ǰ�ڵ����Һ��ӣ�����û�����ӣ�ֱ�ӷ���false
    // �����ǰ�ڵ㲢�������Һ���ȫ�����У���֮��Ľڵ������Ҷ�ӽ�㣬����Ļ�false
    // ���������в�����false���ͷ���true
    public boolean isCompleteTree(TreeNode root) {
    	if(root == null) {
    		return true;
    	}
    	Deque<TreeNode> list = new LinkedList<>();
    	boolean leaf = false; // ��¼�Ƿ���Ҷ�ӽڵ�
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
    // ���ݺ��������ؽ�������
    // �������ж�һ����������ǲ��Ƕ�������������Ժ�Ľ��
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
    // �����������ĵ�K��ڵ�
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
    
    // �������ĸ߶�
    // �����������
    public int treeDepth(TreeNode rt) {
    	if(rt == null) {
    		return 0;
    	}
    	int leftD = treeDepth(rt.left);
    	int rightD = treeDepth(rt.right);
    	return leftD > rightD ? (leftD+1) : (rightD+1);
    }
    
    
    
    // TO DO : ��ת������
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
    
    // ֮���δ�ӡ�����
    // ��һ�а��մ������ң��ڶ��㰴�մ��������˳���ӡ�������а��մ������Ҵ�ӡ����������
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
    				// ��Ԫ�ز���ָ��λ�ã�ͷ���������൱�ڵ�����
    			} else {
    				list.add(treeNode.value);
    				// ��Ԫ�ز���β��
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
    
    // �������Ƿ�Գ�
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
    
    // ��ӡ�����������е�·����ʹ·�������нڵ�֮�͸պõ���ĳ������
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
        System.out.println("ǰ�����");
        binaryTreeList.postOrderScan(binaryTreeList.root);
        System.out.println("�������");
        binaryTreeList.inOrderScan(binaryTreeList.root);
        System.out.println("�������");
        binaryTreeList.postOrderScan(binaryTreeList.root);
        System.out.println();
        System.out.println("�ݹ�������ȣ�"
                + binaryTreeList.treeDeepByRecursion(binaryTreeList.root));
        System.out.println("�ǵݹ�������ȣ�"
                + binaryTreeList.treeDeepByNoRecursion(binaryTreeList.root));
        System.out.println("�ݹ����Ŀ�ȣ�"
                + binaryTreeList.treeWidth(binaryTreeList.root));

        System.out.println("�ڶ�������������·��2:");
        ArrayList<ArrayList<Integer>> findPath3 = binaryTreeList
                .getAllDeepPath(binaryTreeList.root);
        for (List<Integer> arrayList : findPath3) {
            for (Integer integer : arrayList) {
                System.out.print(integer + ",");
            }
            System.out.println();
        }

        System.out.println("�ڶ��������ҳ���Ϊĳһֵ������·��2:");
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

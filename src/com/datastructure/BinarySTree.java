package com.datastructure;
import java.util.Arrays;
import java.util.Stack;


// ��ʽ�洢�Ķ�����
public class BinarySTree {
    private TreeNode root = null;
    public TreeNode getRoot() {
        return root;
    }
    public BinarySTree(TreeNode root) {
        this.root = root;
    }
    
    public boolean isEmpty() {
        return root == null;
    }

    // ���ĸ߶�
    public int height() {
        return TreeNode.height(root);
    }

    // �ڵ����
    public int size() {
        return TreeNode.size(root);
    }

    // ��������ĳ�ڵ�ĸ��ڵ�
    public TreeNode parent(TreeNode element) {
        return (root == null || root == element) ? null : TreeNode.getParent(root, element);
    }

    
    // �������Ľڵ�
    private static class TreeNode {
        private int data;
        private TreeNode leftChild = null;
        private TreeNode rightChild = null;
        
        public TreeNode(int data) {
            this.data = data;
            this.leftChild = null;
            this.rightChild = null;
        }
        
        public static TreeNode getParent(TreeNode subTree, TreeNode element) {
            if (subTree == null)
                return null;
            if (subTree.leftChild == element || subTree.rightChild == element)
                return subTree;
            TreeNode p = null;
            // �ݹ���������
            if ((p = getParent(subTree.leftChild, element)) != null)
                return p;
            else
                return getParent(subTree.rightChild, element);
        }

        public static TreeNode getLeftChildNode(TreeNode element) {
            return (element != null) ? element.leftChild : null;
        }

        public static TreeNode getRightChildNode(TreeNode element) {
            return (element != null) ? element.rightChild : null;
        }
        
        public static int height(TreeNode subTree) {
            if (subTree == null)
                return 0;// �ݹ�����������߶�Ϊ0
            else {
                int i = height(subTree.leftChild);
                int j = height(subTree.rightChild);
                return (i < j) ? (j + 1) : (i + 1);
            }
        }
        
        public static int size(TreeNode subTree) {
            if (subTree == null) {
                return 0;
            } else {
                return 1 + size(subTree.leftChild) + size(subTree.rightChild);
            }
        }
        
        // ���ͷ�ĳ�����ǰ, �ý�����������Ӧ���Ѿ��ͷ�, ����Ӧ�ò��ú�������
        public static void destroySubTree(TreeNode subTree) {
            // ɾ����ΪsubTree������
            if (subTree != null) {
                destroySubTree(subTree.leftChild);
                destroySubTree(subTree.rightChild);
                // ɾ�������
                subTree = null;
            }
        }
        
        
        public static void visted(TreeNode subTree) {
            System.out.println("data: " + subTree.data);
        }
        
        // ǰ�����
        public static void preOrder(TreeNode subTree) {
            if (subTree != null) {
                visted(subTree);
                preOrder(subTree.leftChild);
                preOrder(subTree.rightChild);
            }
        }

        // �������
        public static void inOrder(TreeNode subTree) {
            if (subTree != null) {
                inOrder(subTree.leftChild);
                visted(subTree);
                inOrder(subTree.rightChild);
            }
        }

        // ��������
        public static void postOrder(TreeNode subTree) {
            if (subTree != null) {
                postOrder(subTree.leftChild);
                postOrder(subTree.rightChild);
                visted(subTree);
            }
        }
        
        // ǰ������ķǵݹ�ʵ��
        public static void nonRecPreOrder(TreeNode subTree) {
            Stack<TreeNode> stack = new Stack<TreeNode>();
            TreeNode node = subTree;
            while (node != null || stack.size() > 0) {
                if (node != null) {
                    visted(node);
                    stack.push(node);
                    node = node.leftChild;
                } else {
                    node = stack.pop();
                    node = node.rightChild;
                }
            }
        }

        // ��������ķǵݹ�ʵ��
        public static void nonRecInOrder(TreeNode subTree) {
            Stack<TreeNode> stack = new Stack<TreeNode>();
            TreeNode node = subTree;
            while (node != null || stack.size() > 0) {
                // ����������
                if (node != null) {
                    stack.push(node);
                    node = node.leftChild;
                }
                else {
                    node = stack.pop();
                    visted(node);
                    node = node.rightChild;
                }
            }
        }

        // ��������ķǵݹ�ʵ��
        public static void nonRecPostOrder(TreeNode subTree) {
            if (null == subTree) { //Ϊȷ������ѭ������ִ��һ��
                return;  
            }
            Stack<TreeNode> stack = new Stack<TreeNode>();
            TreeNode node = subTree;
            TreeNode lastVisited = subTree;
            while (true) {
                // ��·��ջ
                while (node.leftChild != null) {
                    stack.push(node);    //��һ��ѹջ, Ϊ�˷�����·���˳�
                    node = node.leftChild;
                }
                // �����������·���صĽڵ�
                while (node.rightChild == null || node.rightChild == lastVisited) {
                    // ���ʲ���¼���η��ʽڵ�
                    visted(node);
                    lastVisited = node;
                    if (stack.empty()) {
                        return;
                    }
                    node = stack.pop();
                }
                // �������·���صĽڵ�
                stack.push(node);  // �ڶ���ѹջ, Ϊ�˷�����·���˳�
                node = node.rightChild;
            }
        }
    }
    
    
    // ����������
    public void add(int data) {
        add(root, data);
    }
    
    public boolean contains(int data) {
        return contains(root, data);
    }
    
    public int minValue() {
        return findMin(root).data;
    }
    
    public int maxValue() {
        return findMax(root).data;
    }
    
    private TreeNode findMin(TreeNode subTree) {
        if (null == subTree) {
            return null;
        } else if (null == subTree.leftChild) {
            return subTree;
        }
        return findMin(subTree.leftChild);
    }

    private TreeNode findMax(TreeNode subTree) {
        if (null != subTree) {
            while (null != subTree.rightChild) {
                subTree = subTree.rightChild;
            }
        }
        return subTree;
    }
    // ��ӽڵ��������
    private TreeNode add(TreeNode subTree, int data) {
        if (null == subTree) {
            return new TreeNode(data);
        } else if (data > subTree.data) {
            subTree.rightChild = add(subTree.rightChild, data);
            return subTree;
        } else if (data < subTree.data) {
            subTree.leftChild = add(subTree.leftChild, data);
            return subTree;
        } // �����޶���������Ԫ�ز��ظ�
        return subTree;
    }

    private boolean contains(TreeNode subTree, int data) {
        if (null == subTree) {
            return false;
        } else if (data > subTree.data) {
                return contains(subTree.rightChild, data);
        } else if (data < subTree.data){
                return contains(subTree.leftChild, data);
        } else {
            return true;
        }
    }
    
    private TreeNode remove(TreeNode subTree, int data) {
        if (null == subTree) {
            return null;
        } else if (data > subTree.data) {
            return remove(subTree.rightChild, data);
        } else if (data < subTree.data) {
            return remove(subTree.leftChild, data);
        } else if (null == subTree.leftChild || null == subTree.rightChild) {  //�ڵ�ƥ��, ֻ��һ�����ӻ�û�к���
            return (subTree.leftChild != null) ? subTree.leftChild : subTree.rightChild; 
        } else {      //�ڵ�ƥ��, ����������
            subTree.data = findMin(subTree.rightChild).data;
            subTree.rightChild = remove(subTree.rightChild, subTree.data);
            return subTree;
        }
    }
    
    // ����
    public static void main(String[] args) {
        // ������
        int[] values = new int[8];
        for (int i = 0; i < 8; i++) {
            int num = (int) (Math.random() * 15);
            if (!checkDup(values, num))
                values[i] = num;
            else
                i--;
        }
        System.out.println("generate Nums:" + Arrays.toString(values));

        BinarySTree tree = new BinarySTree(new TreeNode(values[0]));
        for (int i = 1; i < values.length; i++) {
            tree.add(values[i]);
        }

        System.out.println("����: " + TreeNode.height(tree.getRoot()));
        System.out.println("����С: " + TreeNode.size(tree.getRoot()));
        System.out.println("ǰ�����:");
        TreeNode.nonRecPreOrder(tree.getRoot());
        System.out.println("�������:");
        TreeNode.nonRecInOrder(tree.getRoot());
        System.out.println("�������:");
        TreeNode.nonRecPostOrder(tree.getRoot());
    }
    private static boolean checkDup(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value)
                return true;
        }
        return false;
    }
    
}
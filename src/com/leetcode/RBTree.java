package com.java.java_base;


public class RBTree<T extends Comparable<T>> {

    private RBTNode<T> mRoot;    // �����

    private static final boolean RED   = false;
    private static final boolean BLACK = true;

    public class RBTNode<T extends Comparable<T>> {
        boolean color;        // ��ɫ
        T key;                // �ؼ���(��ֵ)
        RBTNode<T> left;    // ����
        RBTNode<T> right;    // �Һ���
        RBTNode<T> parent;    // �����

        public RBTNode(T key, boolean color, RBTNode<T> parent, RBTNode<T> left, RBTNode<T> right) {
            this.key = key;
            this.color = color;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        public T getKey() {
            return key;
        }

        @Override
		public String toString() {
            return ""+key+(this.color==RED?"(R)":"B");
        }
    }
    
    public RBTree() {
    	mRoot = null;
    }
    
    private RBTNode<T> parentOf(RBTNode<T> node) {
    	return node != null ? node.parent : null;
    }
    
    private boolean colorOf(RBTNode<T> node) {
    	return node!=null ? node.color : BLACK;
    }
    
    private boolean isRed(RBTNode<T> node) {
    	return ((node != null) && (node.color == RED)) ? true : false;
    }
    
    private boolean isBlack(RBTNode<T> node) {
    	return !isRed(node);
    }
    
    private void setRed(RBTNode<T> node) {
    	if(node != null) {
    		node.color = RED;
    	}
    }
    
    private void setBlack(RBTNode<T> node) {
    	if(node != null) {
    		node.color = BLACK;
    	}
    }
    
    private void setParent(RBTNode<T> node, RBTNode<T> parent) {
    	if(node != null) {
    		node.parent = parent;
    	}
    }
    
    private void setColor(RBTNode<T> node, boolean color) {
    	if(node != null) {
    		node.color = color;
    	}
    }
    
    /**
     * 
     * ��������
     * */
    
    /**
     * ǰ�����
     * */
    
    private void preOrder(RBTNode<T> tree) {
    	if(tree!=null) {
    		System.out.println(tree.key + " ");
    		preOrder(tree.left);
    		preOrder(tree.right);
    	}
    }
    
    public void preOrder() {
    	preOrder(mRoot);
    }
    
    /**
     * �������
     * */
    private void inOrder(RBTNode<T> tree) {
    	if(tree!=null) {
    		inOrder(tree.left);
    		System.out.println(tree.key + " ");
    		inOrder(tree.right);
    	}
    }
    
    public void inOrder() {
    	inOrder(mRoot);
    }
    
    private void postOrder(RBTNode<T> tree) {
    	if(tree!=null) {
    		postOrder(tree.left);
    		postOrder(tree.right);
    		System.out.println(tree.key + " ");
    	}
    }
    
    
    public void postOrder() {
    	postOrder(mRoot);
    }
    
    /**
     * �ں����x�в���KeyΪkey�Ľڵ�
     * */
    /**
     * �ݹ����
     * */
    private RBTNode<T> search(RBTNode<T> x, T key) {
    	if(x == null) {
    		return x;
    	}
    	int cmp = key.compareTo(x.key);
    	
    	if(cmp < 0) {
    		return search(x.left, key);
    	} else if(cmp > 0) {
    		return search(x.right, key);
    	} else {
    		return x;
    	}
    }
    
    public RBTNode<T> search(T key) {
    	return search(mRoot, key);
    }
    
    /**
     * �ǵݹ����
     * */
    private RBTNode<T> iterativeSearch(RBTNode<T> x, T key) {
    	
    	while(x != null) {
    		int cmp = key.compareTo(x.key);
    		if(cmp < 0) {
    			x = x.left;
    		} else if(cmp > 0) {
    			x = x.right;
    		} else {
    			return x;
    		}
    	}
    	return x;
    }
    
    public RBTNode<T> iterativeSearch(T key){
    	return iterativeSearch(mRoot, key);
    }
    
    /**
     * ����С�ڵ�,���ظ��ڵ�Ϊtree�ĺ��������С�ڵ�
     * */
    
    private RBTNode<T> minNode(RBTNode<T> tree) {
    	if(tree == null) {
    		return null;
    	}
    	while(tree.left != null){
    		tree = tree.left;
    	}
    	return tree;
    }
    
    public T minNode() {
    	RBTNode<T> p = minNode(mRoot);
    	if(p != null) {
    		return p.key;
    	}
    	return null;
    }
    
    
    /**
     * 
     * �������ڵ�
     * */
    
    private RBTNode<T> maxNode(RBTNode<T> tree) {
    	if(tree == null) {
    		return null;
    	}
    	while(tree.right != null) {
    		tree = tree.right;
    	}
    	return tree;
    }
    
    public T maxNode() {
    	RBTNode<T> p = maxNode(mRoot);
    	if(p != null) {
    		return p.key;
    	}
    	return null;
    }
    
    /**
     * �ҽڵ�x�ĺ�̽ڵ㣨�����еĺ�̣�
     * */
    
    public RBTNode<T> successor(RBTNode<T> x) {
    	// ���Һ���
    	if(x.right != null) {
    		return minNode(x.right);
    	}
    	// û���Һ���
    	// (01) x��"һ������"����"x�ĺ�̽��"Ϊ "���ĸ����"
    	// (02)  x��"һ���Һ���"�������"x����͵ĸ���㣬
    	// ���Ҹø����Ҫ��������"���ҵ������"��͵ĸ����"����"x�ĺ��
    	RBTNode<T> yNode = x.parent;
    	while(yNode != null && x == yNode.right) {
    		x = yNode;
    		yNode = yNode.parent;
    	}
    	return yNode;
    }
    
    /**
     * ��ǰ��ڵ�
     * */
    
    public RBTNode<T> predecessor(RBTNode<T> x) {
    	// ���x�����Ӵ���
    	if(x.left != null) {
    		return maxNode(x.left);
    	}
    	
    	// ���xû�����ӡ���x���������ֿ���
    	// (01) x��"һ���Һ���"����"x��ǰ�����"Ϊ "���ĸ����"��
    	// (01) x��"һ������"�������"x����͵ĸ���㣬���Ҹø����Ҫ�����Һ���"��
    	// �ҵ������"��͵ĸ����"����"x��ǰ��
    	
    	RBTNode<T> y = x.parent;
    	while(y != null && x == y.left) {
    		x = y;
    		y = y.parent;
    	}
    	return y;
    }
    
    /**����
    * ����ʾ��ͼ(�Խڵ�x��������)��
    *      px                              px
    *     /                               /
    *    x                               y                
    *   /  \      --(����)-.           / \                #
    *  lx   y                         x  ry     
    *     /   \                      /  \
    *    ly   ry                    lx  ly  
    *
    *
    */
    
    private void leftRotate(RBTNode<T> x) {
    	
    	RBTNode<T> y = x.right;
    	
    	x.right = y.left;
    	if(y.left != null) {
    		y.left.parent = x;
    	}
    	y.parent = x.parent;
    	
    	if(x.parent == null) {
    		this.mRoot = y;
    	} else {
    		if(x.parent.left == x) {
    			x.parent.left = y;
    		} else {
    			x.parent.right = y;
    		}
    	}
    	y.left = x;
    	x.parent = y;
    }
    
    /* 
    * �Ժ�����Ľڵ�(y)��������ת
    *
    * ����ʾ��ͼ(�Խڵ�y��������)��
    *            py                               py
    *           /                                /
    *          y                                x                  
    *         /  \      --(����)-.            /  \                     #
    *        x   ry                           lx   y  
    *       / \                                   / \                   #
    *      lx  rx                                rx  ry
    * 
    */
    private void rightRotate(RBTNode<T> y) {
    	RBTNode<T> x = y.left;
    	
    	y.left = x.right;
    	if(x.right!=null) {
    		x.right.parent = y;
    	}
    	x.parent = y.parent;
    	if(y.parent == null) {
    		this.mRoot = x;
    	} else {
    		if(y == y.parent.left) {
    			y.parent.left = x;
    		} else {
    			y.parent.right = x;
    		}
    	}
    	x.right = y;
    	y.parent = x;
    }
    
    /**
     * 
     * ���������������
     * ʧȥƽ���Ժ�͵��øú���
     * Ŀ���Ǵ��¹����һ�ú����
     * */
    
    private void insertFixUp(RBTNode<T> node) {
    	RBTNode<T> parent, gparent;
    	// ���׽ڵ���ڣ����Ҹ��׽ڵ����ɫ�Ǻ�ɫ
    	while((parent = parentOf(node)) != null && (isRed(parent))) {
    		gparent = parentOf(parent);
    		
    		// ���׽ڵ������Ƚڵ������
    		if(parent == gparent.left) {
    			// case 1 ����ڵ��Ǻ�ɫ
    			RBTNode<T> uncle = gparent.right;
    			if(uncle != null && isRed(uncle)) {
    				setBlack(uncle);
    				setBlack(parent);
    				setRed(gparent);
    				node = gparent;
    				continue;
    			}
    			// case 2 �����Ǻ�ɫ���ҵ�ǰ�ڵ����Һ���
    			if(parent.right == node) {
    				node = parent;
    				leftRotate(parent);
    			}
    			// case 3 �����Ǻ�ɫ����ǰ�ڵ�������
    			if(parent.left == node) {
    				setBlack(parent);
    				setRed(gparent);
    				rightRotate(gparent);
    			}
    		} else {
    			// ���׽ڵ������Ƚڵ���Һ���
    			// case 1 ����������ڵ��Ǻ�ɫ
    			RBTNode<T> uncle = gparent.left;
    			if(uncle != null && isRed(uncle)) {
    				setBlack(uncle);
    				setBlack(parent);
    				setRed(gparent);
    				node = gparent;
    				continue;
    			}
    			if(parent.left == node) {
    				RBTNode<T> tmpNode;
    				rightRotate(parent);
    				tmpNode = parent;
    				parent = node;
    				node = tmpNode;
    			}
    			setBlack(parent);
    			setRed(gparent);
    			leftRotate(gparent);
    		}
    	}
    	setBlack(this.mRoot);
    }
    
    /* 
     * �������뵽�������
     *
     * ����˵����
     *     node ����Ľ��        // ��Ӧ���㷨���ۡ��е�node
     */
    private void insert(RBTNode<T> node) {
        int cmp;
        RBTNode<T> y = null;
        RBTNode<T> x = this.mRoot;

        // 1. �����������һ�Ŷ�������������ڵ���ӵ�����������С�
        while (x != null) {
            y = x;
            cmp = node.key.compareTo(x.key);
            if (cmp < 0)
                x = x.left;
            else
                x = x.right;
        }

        node.parent = y;
        if (y!=null) {
            cmp = node.key.compareTo(y.key);
            if (cmp < 0)
                y.left = node;
            else
                y.right = node;
        } else {
            this.mRoot = node;
        }

        // 2. ���ýڵ����ɫΪ��ɫ
        node.color = RED;

        // 3. ������������Ϊһ�Ŷ��������
        insertFixUp(node);
    }

    /* 
     * �½����(key)����������뵽�������
     *
     * ����˵����
     *     key ������ļ�ֵ
     */
    public void insert(T key) {
        RBTNode<T> node=new RBTNode<T>(key,BLACK,null,null,null);

        // ����½����ʧ�ܣ��򷵻ء�
        if (node != null)
            insert(node);
    }


    /*
     * �����ɾ����������
     *
     * �ڴӺ������ɾ������ڵ�֮��(�����ʧȥƽ��)���ٵ��øú�����
     * Ŀ���ǽ������������һ�ź������
     *
     * ����˵����
     *     node �������Ľڵ�
     */
    private void removeFixUp(RBTNode<T> node, RBTNode<T> parent) {
        RBTNode<T> other;

        while ((node==null || isBlack(node)) && (node != this.mRoot)) {
            if (parent.left == node) {
                other = parent.right;
                if (isRed(other)) {
                    // Case 1: x���ֵ�w�Ǻ�ɫ��  
                    setBlack(other);
                    setRed(parent);
                    leftRotate(parent);
                    other = parent.right;
                }

                if ((other.left==null || isBlack(other.left)) &&
                    (other.right==null || isBlack(other.right))) {
                    // Case 2: x���ֵ�w�Ǻ�ɫ����w����������Ҳ���Ǻ�ɫ��  
                    setRed(other);
                    node = parent;
                    parent = parentOf(node);
                } else {

                    if (other.right==null || isBlack(other.right)) {
                        // Case 3: x���ֵ�w�Ǻ�ɫ�ģ�����w�������Ǻ�ɫ���Һ���Ϊ��ɫ��  
                        setBlack(other.left);
                        setRed(other);
                        rightRotate(other);
                        other = parent.right;
                    }
                    // Case 4: x���ֵ�w�Ǻ�ɫ�ģ�����w���Һ����Ǻ�ɫ�ģ�����������ɫ��
                    setColor(other, colorOf(parent));
                    setBlack(parent);
                    setBlack(other.right);
                    leftRotate(parent);
                    node = this.mRoot;
                    break;
                }
            } else {

                other = parent.left;
                if (isRed(other)) {
                    // Case 1: x���ֵ�w�Ǻ�ɫ��  
                    setBlack(other);
                    setRed(parent);
                    rightRotate(parent);
                    other = parent.left;
                }

                if ((other.left==null || isBlack(other.left)) &&
                    (other.right==null || isBlack(other.right))) {
                    // Case 2: x���ֵ�w�Ǻ�ɫ����w����������Ҳ���Ǻ�ɫ��  
                    setRed(other);
                    node = parent;
                    parent = parentOf(node);
                } else {

                    if (other.left==null || isBlack(other.left)) {
                        // Case 3: x���ֵ�w�Ǻ�ɫ�ģ�����w�������Ǻ�ɫ���Һ���Ϊ��ɫ��  
                        setBlack(other.right);
                        setRed(other);
                        leftRotate(other);
                        other = parent.left;
                    }

                    // Case 4: x���ֵ�w�Ǻ�ɫ�ģ�����w���Һ����Ǻ�ɫ�ģ�����������ɫ��
                    setColor(other, colorOf(parent));
                    setBlack(parent);
                    setBlack(other.left);
                    rightRotate(parent);
                    node = this.mRoot;
                    break;
                }
            }
        }

        if (node!=null)
            setBlack(node);
    }

    /* 
     * ɾ�����(node)�������ر�ɾ���Ľ��
     *
     * ����˵����
     *     node ɾ���Ľ��
     */
    private void remove(RBTNode<T> node) {
        RBTNode<T> child, parent;
        boolean color;

        // ��ɾ���ڵ��"���Һ��Ӷ���Ϊ��"�������
        if ( (node.left!=null) && (node.right!=null) ) {
            // ��ɾ�ڵ�ĺ�̽ڵ㡣(��Ϊ"ȡ���ڵ�")
            // ������ȡ��"��ɾ�ڵ�"��λ�ã�Ȼ���ٽ�"��ɾ�ڵ�"ȥ����
            RBTNode<T> replace = node;

            // ��ȡ��̽ڵ�
            replace = replace.right;
            while (replace.left != null)
                replace = replace.left;

            // "node�ڵ�"���Ǹ��ڵ�(ֻ�и��ڵ㲻���ڸ��ڵ�)
            if (parentOf(node)!=null) {
                if (parentOf(node).left == node)
                    parentOf(node).left = replace;
                else
                    parentOf(node).right = replace;
            } else {
                // "node�ڵ�"�Ǹ��ڵ㣬���¸��ڵ㡣
                this.mRoot = replace;
            }

            // child��"ȡ���ڵ�"���Һ��ӣ�Ҳ����Ҫ"�����Ľڵ�"��
            // "ȡ���ڵ�"�϶����������ӣ���Ϊ����һ����̽ڵ㡣
            child = replace.right;
            parent = parentOf(replace);
            // ����"ȡ���ڵ�"����ɫ
            color = colorOf(replace);

            // "��ɾ���ڵ�"��"���ĺ�̽ڵ�ĸ��ڵ�"
            if (parent == node) {
                parent = replace;
            } else {
                // child��Ϊ��
                if (child!=null)
                    setParent(child, parent);
                parent.left = child;

                replace.right = node.right;
                setParent(node.right, replace);
            }

            replace.parent = node.parent;
            replace.color = node.color;
            replace.left = node.left;
            node.left.parent = replace;

            if (color == BLACK)
                removeFixUp(child, parent);

            node = null;
            return ;
        }

        if (node.left !=null) {
            child = node.left;
        } else {
            child = node.right;
        }

        parent = node.parent;
        // ����"ȡ���ڵ�"����ɫ
        color = node.color;

        if (child!=null)
            child.parent = parent;

        // "node�ڵ�"���Ǹ��ڵ�
        if (parent!=null) {
            if (parent.left == node)
                parent.left = child;
            else
                parent.right = child;
        } else {
            this.mRoot = child;
        }

        if (color == BLACK)
            removeFixUp(child, parent);
        node = null;
    }

    /* 
     * ɾ�����(z)�������ر�ɾ���Ľ��
     *
     * ����˵����
     *     tree ������ĸ����
     *     z ɾ���Ľ��
     */
    public void remove(T key) {
        RBTNode<T> node; 

        if ((node = search(mRoot, key)) != null)
            remove(node);
    }

    /*
     * ���ٺ����
     */
    private void destroy(RBTNode<T> tree) {
        if (tree==null)
            return ;

        if (tree.left != null)
            destroy(tree.left);
        if (tree.right != null)
            destroy(tree.right);

        tree=null;
    }

    public void clear() {
        destroy(mRoot);
        mRoot = null;
    }

    /*
     * ��ӡ"�����"
     *
     * key        -- �ڵ�ļ�ֵ 
     * direction  --  0����ʾ�ýڵ��Ǹ��ڵ�;
     *               -1����ʾ�ýڵ������ĸ���������;
     *                1����ʾ�ýڵ������ĸ������Һ��ӡ�
     */
    private void print(RBTNode<T> tree, T key, int direction) {

        if(tree != null) {

            if(direction==0)    // tree�Ǹ��ڵ�
                System.out.printf("%2d(B) is root\n", tree.key);
            else                // tree�Ƿ�֧�ڵ�
                System.out.printf("%2d(%s) is %2d's %6s child\n", tree.key, isRed(tree)?"R":"B", key, direction==1?"right" : "left");

            print(tree.left, tree.key, -1);
            print(tree.right,tree.key,  1);
        }
    }

    public void print() {
        if (mRoot != null)
            print(mRoot, mRoot.key, 0);
    }
    
}
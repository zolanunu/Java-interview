package com.java.leetcode.coding;

public class MyStackImpl {
	// 10���Ƶ���numתΪn����
	public static String conversion(int num, int n) {
		MyArrayStack<Integer> myS = new MyArrayStack<>();
		Integer result = num;
		while(true) {
			myS.push(result%n);
			result = result / n;
			if(result == 0) {
				break;
			}
		}
		StringBuilder sBuilder = new StringBuilder();
		while((result = myS.pop()) != null) {
			sBuilder.append(result);
		}
		return sBuilder.toString();
	}
	
	// ����ƥ��
	public static boolean isMatch(String string) {
		MyArrayStack<Character> myS = new MyArrayStack<>();
		char[] arr = string.toCharArray();
		for(char c : arr) {
			Character temp = myS.pop();
			// ջΪ�յ�ʱ�򣬽�c��ջ
			if(temp==null) {
				myS.push(c);
			} else if(temp == '[' && c == ']') {
				
			}  else if (temp == '(' && c == ')') {
	        }  else {
				myS.push(temp);
				myS.push(c);
			}
		}
		return myS.isEmpty();
	}
	// ���������ַ�'#'��ʾ�˸�, '@'��ʾ֮ǰ������ȫ����Ч.
	public static String lineEdit(String input) {  
		MyArrayStack<Character> myStack = new MyArrayStack<Character>();  
	    char[] arr = input.toCharArray();  
	    for (char c : arr) {  
	        if (c == '#') {  
	            myStack.pop();  
	        } else if (c == '@') {  
	            myStack.clear();  
	        } else {  
	            myStack.push(c);  
	        }  
	    }
	    StringBuilder sb = new StringBuilder();
	    Character temp = null;
	    while ((temp = myStack.pop()) != null) {  
	        sb.append(temp);  
	    }  
	    // ��ת�ַ���  
	    sb.reverse();  
	    return sb.toString();
	}
	
	/***
	 * �Ԍm���
	 * 0 ͨ��
	 * 1 ����
	 * */
	class place{//�������λ��  
	    int row;  
	    int col;  
	    place(int row, int col){  
	        this.row = row;  
	        this.col = col;  
	    }  
	    place(){}  
	}
	interface Method {
		// ʵ���Թ���ջ�ṹ�Ľӿ�
		int MAX = 50; // ջ�����洢������Ҳ����·���������
		void stackInit(StackList stackList); // ջ�ĳ�ʼ��
		void stackAdd(StackList statckList, place Number); // ����
		void stackDelete(StackList stackList); //ɾ��
		void display(StackList stackList); // ��ӡ
	}
	
	class StackList {
		// ջ�ṹ
		place[] data;
		int size;
		int capacity;
	}
	
	
	class My_Method implements Method {
		@Override
		public void stackInit(StackList stackList) { // ջ�ĳ�ʼ��
			if(stackList == null) {
				return ;
			}
			stackList.data = new place[MAX];
			stackList.capacity = MAX;
			stackList.size = 0;
		}
		public void stackAdd(StackList statckList, place Number) { // ����
			if (statckList == null) {
				return ;
			}
			if (statckList.size == statckList.capacity) {
				return ;
			}
			statckList.data[statckList.size++] = Number;
		}
		
		public void stackDelete(StackList stackList) { //ɾ��
			if (stackList == null) {
				return ;
			}
			if (stackList.size == 0) {
				return ;
			}
			stackList.size--;
		}
		public void display(StackList stackList) { // ��ӡ
			if (stackList==null) {
				return ;
			}
			for(int i = 0; i < stackList.size; i++) {
				System.out.print(" "+stackList.data[i]);
			}
		}
	}
	
	interface Maze_Method{//�й��Թ���ͼ��ʵ�ַ����Ľӿ�  
	    int ROW = 6;//�Թ���������  
	    int COL = 6;  
	    boolean Exit(Maze maze,place now_place,place start);//����ǲ��ǳ���  
	    void mark(Maze maze, place now_place, place prev_place);//�����  
	    boolean CanStay(Maze maze, place now_place, place prev_place);//�ж��Ƿ�����䵽���λ����  
	    void Walk(Maze maze, place start, place now_place, place prev_place, StackList cur, StackList _short, Method My_Test);//�ݹ麯��  
	    void Init(Maze maze);//��ʼ����ͼ  
	    void Display(Maze maze);//��ӡ��ͼ  
	}  
	interface Maze_area{  
	    int ROW = 6;//�Թ��Ĵ�С  
	    int COL = 6;  
	}  
	  
	class Maze implements Maze_area{//�Թ���ͼ  
	    int[][] map = new int[ROW][COL];  
	}  
	class My_Maze_Method implements Maze_Method{//ʵ���Թ���صķ���  
	  
	    @Override  
	    public void Init(Maze maze) {//��ʼ����ͼ  
	        int[][] New_Map = new int[][]{{0,1,0,0,0,0},  
	                                      {1,1,0,0,0,0},  
	                                      {0,1,0,1,1,1},  
	                                      {1,1,1,1,0,0},  
	                                      {0,0,0,1,0,0},  
	                                      {0,0,0,1,0,0,}};  
	        maze.map = New_Map;  
	    }
	  
	    @Override  
	    public void Display(Maze maze) {//��ӡ��ͼ  
	        for(int i = 0;i<maze.map.length;i++){  
	            for(int j = 0;j<maze.map[0].length;j++){  
	                System.out.print(" "+ maze.map[i][j]);  
	            }  
	            System.out.println();  
	        }  
	    }  
	  
	    @Override  
	    public boolean Exit(Maze maze, place now_place, place start) {//����Ƿ��ǳ���  
	        if(now_place == start){  
	            return false;  
	        }  
	        if(now_place.row == 0 || now_place.row == ROW-1 || now_place.col == 0 || now_place.col == COL-1){  
	            return true;  
	        }  
	        return false;  
	    }  
	  
	    @Override  
	    public boolean CanStay(Maze maze, place now_place, place prev_place) {//���ĳλ���Ƿ�Ϸ�  
	        if((now_place.row >= ROW) || (now_place.row < 0) || (now_place.col >= COL) || (now_place.col < 0)){  
	            return false;  
	        }  
	        if(maze.map[now_place.row][now_place.col] == 0){  
	            return false;  
	        }  
	        if(maze.map[now_place.row][now_place.col] == 1){  
	            return true;
	        }  
	        if(maze.map[prev_place.row][prev_place.col] > (maze.map[now_place.row][now_place.col] + 1)){  
	            return true;  
	        }  
	        return false;  
	    }  
	  
	    @Override  
	    public void mark(Maze maze, place now_place, place prev_place) {//���һ��λ��  
	        if (prev_place.row == -1 && prev_place.col == -1) {	  
	            maze.map[now_place.row][now_place.col] = 2;  
	        } else {  
	            maze.map[now_place.row][now_place.col] = maze.map[prev_place.row][prev_place.col] + 1;  
	        }  
	    }  
	  
	    @Override  
	    public void Walk(Maze maze, place start, place now_place, place prev_place, StackList cur, StackList _short, Method My_test) {//�ݹ麯��  
	        if(!CanStay(maze,now_place,prev_place)){//���Ƿ���������λ����
	            return;
	        }
	        mark(maze,now_place,prev_place);//�����
	        My_test.stackAdd(cur,now_place);//�����ߵĵط���ջ  
	  
	        if(Exit(maze,now_place,start)){//����ǳ��ڣ���ô��curջ��_shortջ�Ĵ�С���Ƚϣ�  
	            if(_short.size == 0) {//�ѱȽ�С���Ǹ�������_shortջ��
	                _short.data = cur.data;  
	                _short.size = cur.size;  
	                _short.capacity = cur.capacity;  
	            }  
	            if(_short.size > cur.size){  
	                _short.data = cur.data;  
	                _short.size = cur.size;  
	                _short.capacity = cur.capacity;  
	            }  
	            My_test.stackDelete(cur);//����ǳ��ڣ���ôɾ��ջ��������  
	            System.out.println("�ҵ�һ������");  
	            return;  
	        }
	        //˳ʱ��ɨ��һ��λ�õ���������  
	        place up = new place(now_place.row-1,now_place.col);  
	        prev_place = now_place;  
	        Walk(maze,start,up,prev_place,cur,_short,My_test);  
	  
	        place right = new place(now_place.row,now_place.col+1);  
	        prev_place = now_place;  
	        Walk(maze,start,right,prev_place,cur,_short,My_test);  
	  
	        place down = new place(now_place.row+1,now_place.col);  
	        prev_place = now_place;  
	        Walk(maze,start,down,prev_place,cur,_short,My_test);  
	  
	        place left = new place(now_place.row,now_place.col-1);  
	        prev_place = now_place;  
	        Walk(maze,start,left,prev_place,cur,_short,My_test);  
	        My_test.stackDelete(cur);  
	    }  
	}  
	  
	  
	//-------------------------------------------------------  
	  
	
	  
	public static void main(String[] args) {
		String string = conversion(9, 8);
		System.out.println(string);
	}
}

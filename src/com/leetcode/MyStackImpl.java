package com.java.leetcode.coding;

public class MyStackImpl {
	// 10进制的数num转为n进制
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
	
	// 括号匹配
	public static boolean isMatch(String string) {
		MyArrayStack<Character> myS = new MyArrayStack<>();
		char[] arr = string.toCharArray();
		for(char c : arr) {
			Character temp = myS.pop();
			// 栈为空的时候，将c入栈
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
	// 输入行中字符'#'表示退格, '@'表示之前的输入全都无效.
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
	    // 反转字符串  
	    sb.reverse();  
	    return sb.toString();
	}
	
	/***
	 * 迷宮求解
	 * 0 通道
	 * 1 墻壁
	 * */
	class place{//描述点的位置  
	    int row;  
	    int col;  
	    place(int row, int col){  
	        this.row = row;  
	        this.col = col;  
	    }  
	    place(){}  
	}
	interface Method {
		// 实现迷宫的栈结构的接口
		int MAX = 50; // 栈的最大存储容量，也就是路径的最长长度
		void stackInit(StackList stackList); // 栈的初始化
		void stackAdd(StackList statckList, place Number); // 插入
		void stackDelete(StackList stackList); //删除
		void display(StackList stackList); // 打印
	}
	
	class StackList {
		// 栈结构
		place[] data;
		int size;
		int capacity;
	}
	
	
	class My_Method implements Method {
		@Override
		public void stackInit(StackList stackList) { // 栈的初始化
			if(stackList == null) {
				return ;
			}
			stackList.data = new place[MAX];
			stackList.capacity = MAX;
			stackList.size = 0;
		}
		public void stackAdd(StackList statckList, place Number) { // 插入
			if (statckList == null) {
				return ;
			}
			if (statckList.size == statckList.capacity) {
				return ;
			}
			statckList.data[statckList.size++] = Number;
		}
		
		public void stackDelete(StackList stackList) { //删除
			if (stackList == null) {
				return ;
			}
			if (stackList.size == 0) {
				return ;
			}
			stackList.size--;
		}
		public void display(StackList stackList) { // 打印
			if (stackList==null) {
				return ;
			}
			for(int i = 0; i < stackList.size; i++) {
				System.out.print(" "+stackList.data[i]);
			}
		}
	}
	
	interface Maze_Method{//有关迷宫地图的实现方法的接口  
	    int ROW = 6;//迷宫的行与列  
	    int COL = 6;  
	    boolean Exit(Maze maze,place now_place,place start);//检查是不是出口  
	    void mark(Maze maze, place now_place, place prev_place);//做标记  
	    boolean CanStay(Maze maze, place now_place, place prev_place);//判断是否可以落到这个位置上  
	    void Walk(Maze maze, place start, place now_place, place prev_place, StackList cur, StackList _short, Method My_Test);//递归函数  
	    void Init(Maze maze);//初始化地图  
	    void Display(Maze maze);//打印地图  
	}  
	interface Maze_area{  
	    int ROW = 6;//迷宫的大小  
	    int COL = 6;  
	}  
	  
	class Maze implements Maze_area{//迷宫地图  
	    int[][] map = new int[ROW][COL];  
	}  
	class My_Maze_Method implements Maze_Method{//实现迷宫相关的方法  
	  
	    @Override  
	    public void Init(Maze maze) {//初始化地图  
	        int[][] New_Map = new int[][]{{0,1,0,0,0,0},  
	                                      {1,1,0,0,0,0},  
	                                      {0,1,0,1,1,1},  
	                                      {1,1,1,1,0,0},  
	                                      {0,0,0,1,0,0},  
	                                      {0,0,0,1,0,0,}};  
	        maze.map = New_Map;  
	    }
	  
	    @Override  
	    public void Display(Maze maze) {//打印地图  
	        for(int i = 0;i<maze.map.length;i++){  
	            for(int j = 0;j<maze.map[0].length;j++){  
	                System.out.print(" "+ maze.map[i][j]);  
	            }  
	            System.out.println();  
	        }  
	    }  
	  
	    @Override  
	    public boolean Exit(Maze maze, place now_place, place start) {//检查是否是出口  
	        if(now_place == start){  
	            return false;  
	        }  
	        if(now_place.row == 0 || now_place.row == ROW-1 || now_place.col == 0 || now_place.col == COL-1){  
	            return true;  
	        }  
	        return false;  
	    }  
	  
	    @Override  
	    public boolean CanStay(Maze maze, place now_place, place prev_place) {//检查某位置是否合法  
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
	    public void mark(Maze maze, place now_place, place prev_place) {//标记一个位置  
	        if (prev_place.row == -1 && prev_place.col == -1) {	  
	            maze.map[now_place.row][now_place.col] = 2;  
	        } else {  
	            maze.map[now_place.row][now_place.col] = maze.map[prev_place.row][prev_place.col] + 1;  
	        }  
	    }  
	  
	    @Override  
	    public void Walk(Maze maze, place start, place now_place, place prev_place, StackList cur, StackList _short, Method My_test) {//递归函数  
	        if(!CanStay(maze,now_place,prev_place)){//看是否可以在这个位置走
	            return;
	        }
	        mark(maze,now_place,prev_place);//做标记
	        My_test.stackAdd(cur,now_place);//将能走的地方入栈  
	  
	        if(Exit(maze,now_place,start)){//如果是出口，那么把cur栈和_short栈的大小做比较，  
	            if(_short.size == 0) {//把比较小的那个保存在_short栈中
	                _short.data = cur.data;  
	                _short.size = cur.size;  
	                _short.capacity = cur.capacity;  
	            }  
	            if(_short.size > cur.size){  
	                _short.data = cur.data;  
	                _short.size = cur.size;  
	                _short.capacity = cur.capacity;  
	            }  
	            My_test.stackDelete(cur);//如果是出口，那么删除栈顶，回溯  
	            System.out.println("找到一个出口");  
	            return;  
	        }
	        //顺时针扫描一个位置的上下左右  
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

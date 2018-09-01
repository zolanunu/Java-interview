/**
 * 
 */
package com.leetcode;

import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * @author zolanunu
 * 
 */
public class ExpressionValue {
	/**
	 * 中缀表达式：a+(b-c/d)*e 前缀表达式：前缀表达式+a*-b/cde 后缀表达式abcd/-e*+
	 * 由于运算符有优先级，所以在计算机中计算一个中缀的表达式非常困难，特别是带括号的更麻烦
	 * 而后缀表达式中既无运算符优先又无括号的约束问题因为在后缀表达式中运算符出现的顺序正是计算的顺序，所以计算一个后缀的表达式更简单。
	 * 所以，可以将求算术表达式的值的过程化成两个过程： 1.将一个中缀表达式化成一个后缀表达式 2.对后缀表达式进行求值
	 * */
	/**
	 * 算法描述如下： （1）初始化一个运算符栈 （2）从算术表达式输入的字符串中，从左到右的读取一个字符 （3）若当前的
	 * 字符是操作数，则直接送往后缀表达式 （4）若当前的字符是左括号，则将其压入运算符栈 （5）若当前的字符是操作符，则进行如下 操作：
	 * ①当运算符栈为空时，直接将其压入栈。
	 * ②当此运算符的优先级高于栈顶的运算符时，则将此运算符压入栈，否则，弹出栈顶运算符送往后缀式，并将当前运算符压栈，重复步骤（5）
	 * （6）若当前字符是右括号，反复将栈顶符号弹出，并送往后缀表达式中，知道栈顶元素为左括号为止，然后将左括号出栈并丢弃
	 * （7）若读取还未结束，则重复步骤（2） （8）若读取结束，则将栈中剩余的所有的运算符弹出并送往后缀表达式
	 * 
	 * */
	/**
	 * @author_Stone6762
	 */

	/**
	 * @Describe_将原始的表达式转换成一个后缀表达式
	 * @param expression原始的表达式
	 * @return与元素表达式相对于的后缀表达式
	 * @throws Exception
	 */
	public String conver2Postfix(String expression) throws Exception {
		ArrayDeque<Character> st = new ArrayDeque<Character>();// 运算符栈
		String postFix = "";// 后缀表达式
		for (int i = 0; expression != null && i < expression.length(); i++) {
			char c = expression.charAt(i);// 遍历，如果是操作数，如果是操作符
			if (' ' != c) {// 字符不能为空
				if (isOpenParenthesis(c)) {// 左括号
					// 左括号就入栈
					st.add(c);
				} else if (isCloseParenthesis(c)) {// 右括号
					// 右括号就把所有的操作符出栈知道遇到一个左括号为止，然后将该左括号出栈并丢弃
					Character ac = (Character) st.pop();
					while (!isOpenParenthesis(ac)) {
						postFix += ac.toString();
						ac = (Character) st.pop();// 如果取出的是左括号，很显然就丢弃了
					}
				} else if (isOperator(c)) {// 操作符
					/*
					 * 如果栈为空，直接进栈。 如果栈非空，则需要将栈顶运算符的优先级和要入栈的运算符的优先级进行比较
					 * 将栈中比要入栈的运算符优先级高的运算符都出栈，然后将该运算符入栈
					 */
					if (!st.isEmpty()) { // 如果栈非空，则需要判断
						Character ac = (Character) st.pop();
						while (ac != null
								&& priority(ac.charValue()) > priority(c)) {
							postFix += ac;
							ac = (Character) st.pop();
							// 因为是先取出来后判断是，所以如果跳出循环 需要将最后一次取出的操作符压入栈
						}
						// 将最后一次取出的优先级低的运算符入栈
						if (ac != null) {
							st.push(ac);
						}
					}
					// 最后，将该运算符入栈
					st.push(c);
				} else {// 操作数，直接添加到后缀表达式 中
					postFix += c;
				}
			}
		}
		// 最后的时候，如果栈非空，则需要栈中的所有的运算符串联到后缀表达式的末尾
		while (!st.isEmpty()) {
			postFix += st.pop().toString();
		}
		return postFix;
	}

	/**
	 * @Describe_对后缀表达式进行运算
	 * @param postFix后缀表达式
	 * @return计算后的结果
	 * @throws Exception
	 */
	public double numberCalculate(String postFix) throws Exception {
		ArrayDeque<Object> st = new ArrayDeque<Object>();// 操作数栈
		for (int i = 0; i < postFix.length(); i++) {
			char c = postFix.charAt(i);
			if (isOperator(c)) {
				double d2 = Double.valueOf(st.pop().toString());
				double d1 = Double.valueOf(st.pop().toString());
				double d3 = 0;
				switch (c) {
				case '+':
					d3 = d1 + d2;
					break;
				case '-':
					d3 = d1 - d2;
					break;
				case '*':
					d3 = d1 * d2;
					break;
				case '/':
					d3 = d1 / d2;
					break;
				case '%':
					d3 = d1 % d2;
					break;
				case '^':
					d3 = Math.pow(d1, d2);
					break;

				default:
					break;
				}

				st.addLast(d3);// 将操作后的结果入栈
			} else {// 当是操作数时，就直接进操作数栈
				st.addLast(c);
			}

		}

		return (double) st.pop();
	}

	/**
	 * @Describe_求运算符的优先级
	 */
	private int priority(char c) {
		switch (c) {
		case '^':
			return 3;
		case '*':
		case '/':
		case '%':
			return 2;
		case '+':
		case '-':
			return 1;
		}
		return 0;
	}

	/**
	 * @Describe是否是一个操作符_
	 */
	private boolean isOperator(char c) {
		if ('+' == c || '-' == c || '*' == c || '/' == c || '^' == c
				|| '%' == c) {
			return true;
		}
		return false;
	}

	/**
	 * @Describe是否是一个右括号_
	 */
	private boolean isCloseParenthesis(char c) {
		return ')' == c;
	}

	/**
	 * @Describe_判断是否是一个左括号
	 */
	private boolean isOpenParenthesis(char c) {
		return '(' == c;
	}

	public static void main(String[] args) throws Exception {

		ExpressionValue p = new ExpressionValue();
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入算术表达式：   ");
		while (scan.hasNext()) {
			String str = scan.next();
			String postFix = p.conver2Postfix(str);
			System.out.println("结果是：    " + p.numberCalculate(postFix));
			System.out.println();
			System.out.println("请输入算术表达式：   ");
		}

	}
}

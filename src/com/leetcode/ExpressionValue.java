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
	 * ��׺���ʽ��a+(b-c/d)*e ǰ׺���ʽ��ǰ׺���ʽ+a*-b/cde ��׺���ʽabcd/-e*+
	 * ��������������ȼ��������ڼ�����м���һ����׺�ı��ʽ�ǳ����ѣ��ر��Ǵ����ŵĸ��鷳
	 * ����׺���ʽ�м�������������������ŵ�Լ��������Ϊ�ں�׺���ʽ����������ֵ�˳�����Ǽ����˳�����Լ���һ����׺�ı��ʽ���򵥡�
	 * ���ԣ����Խ����������ʽ��ֵ�Ĺ��̻����������̣� 1.��һ����׺���ʽ����һ����׺���ʽ 2.�Ժ�׺���ʽ������ֵ
	 * */
	/**
	 * �㷨�������£� ��1����ʼ��һ�������ջ ��2�����������ʽ������ַ����У������ҵĶ�ȡһ���ַ� ��3������ǰ��
	 * �ַ��ǲ���������ֱ��������׺���ʽ ��4������ǰ���ַ��������ţ�����ѹ�������ջ ��5������ǰ���ַ��ǲ���������������� ������
	 * �ٵ������ջΪ��ʱ��ֱ�ӽ���ѹ��ջ��
	 * �ڵ�������������ȼ�����ջ���������ʱ���򽫴������ѹ��ջ�����򣬵���ջ�������������׺ʽ��������ǰ�����ѹջ���ظ����裨5��
	 * ��6������ǰ�ַ��������ţ�������ջ�����ŵ�������������׺���ʽ�У�֪��ջ��Ԫ��Ϊ������Ϊֹ��Ȼ�������ų�ջ������
	 * ��7������ȡ��δ���������ظ����裨2�� ��8������ȡ��������ջ��ʣ������е������������������׺���ʽ
	 * 
	 * */
	/**
	 * @author_Stone6762
	 */

	/**
	 * @Describe_��ԭʼ�ı��ʽת����һ����׺���ʽ
	 * @param expressionԭʼ�ı��ʽ
	 * @return��Ԫ�ر��ʽ����ڵĺ�׺���ʽ
	 * @throws Exception
	 */
	public String conver2Postfix(String expression) throws Exception {
		ArrayDeque<Character> st = new ArrayDeque<Character>();// �����ջ
		String postFix = "";// ��׺���ʽ
		for (int i = 0; expression != null && i < expression.length(); i++) {
			char c = expression.charAt(i);// ����������ǲ�����������ǲ�����
			if (' ' != c) {// �ַ�����Ϊ��
				if (isOpenParenthesis(c)) {// ������
					// �����ž���ջ
					st.add(c);
				} else if (isCloseParenthesis(c)) {// ������
					// �����žͰ����еĲ�������ջ֪������һ��������Ϊֹ��Ȼ�󽫸������ų�ջ������
					Character ac = (Character) st.pop();
					while (!isOpenParenthesis(ac)) {
						postFix += ac.toString();
						ac = (Character) st.pop();// ���ȡ�����������ţ�����Ȼ�Ͷ�����
					}
				} else if (isOperator(c)) {// ������
					/*
					 * ���ջΪ�գ�ֱ�ӽ�ջ�� ���ջ�ǿգ�����Ҫ��ջ������������ȼ���Ҫ��ջ������������ȼ����бȽ�
					 * ��ջ�б�Ҫ��ջ����������ȼ��ߵ����������ջ��Ȼ�󽫸��������ջ
					 */
					if (!st.isEmpty()) { // ���ջ�ǿգ�����Ҫ�ж�
						Character ac = (Character) st.pop();
						while (ac != null
								&& priority(ac.charValue()) > priority(c)) {
							postFix += ac;
							ac = (Character) st.pop();
							// ��Ϊ����ȡ�������ж��ǣ������������ѭ�� ��Ҫ�����һ��ȡ���Ĳ�����ѹ��ջ
						}
						// �����һ��ȡ�������ȼ��͵��������ջ
						if (ac != null) {
							st.push(ac);
						}
					}
					// ��󣬽����������ջ
					st.push(c);
				} else {// ��������ֱ����ӵ���׺���ʽ ��
					postFix += c;
				}
			}
		}
		// ����ʱ�����ջ�ǿգ�����Ҫջ�е����е��������������׺���ʽ��ĩβ
		while (!st.isEmpty()) {
			postFix += st.pop().toString();
		}
		return postFix;
	}

	/**
	 * @Describe_�Ժ�׺���ʽ��������
	 * @param postFix��׺���ʽ
	 * @return�����Ľ��
	 * @throws Exception
	 */
	public double numberCalculate(String postFix) throws Exception {
		ArrayDeque<Object> st = new ArrayDeque<Object>();// ������ջ
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

				st.addLast(d3);// ��������Ľ����ջ
			} else {// ���ǲ�����ʱ����ֱ�ӽ�������ջ
				st.addLast(c);
			}

		}

		return (double) st.pop();
	}

	/**
	 * @Describe_������������ȼ�
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
	 * @Describe�Ƿ���һ��������_
	 */
	private boolean isOperator(char c) {
		if ('+' == c || '-' == c || '*' == c || '/' == c || '^' == c
				|| '%' == c) {
			return true;
		}
		return false;
	}

	/**
	 * @Describe�Ƿ���һ��������_
	 */
	private boolean isCloseParenthesis(char c) {
		return ')' == c;
	}

	/**
	 * @Describe_�ж��Ƿ���һ��������
	 */
	private boolean isOpenParenthesis(char c) {
		return '(' == c;
	}

	public static void main(String[] args) throws Exception {

		ExpressionValue p = new ExpressionValue();
		Scanner scan = new Scanner(System.in);
		System.out.println("�������������ʽ��   ");
		while (scan.hasNext()) {
			String str = scan.next();
			String postFix = p.conver2Postfix(str);
			System.out.println("����ǣ�    " + p.numberCalculate(postFix));
			System.out.println();
			System.out.println("�������������ʽ��   ");
		}

	}
}

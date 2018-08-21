/**
 * 
 */
package com.company;

import java.util.Scanner;

/**
 * @author zolanunu
 *
 */
public class WordPuzzle {
	/**
	 * �ַ����
	 * */
	public static void main(String[] args) {
		Scanner inScanner = new Scanner(System.in);
		int n = inScanner.nextInt();
		while(n-->0) {
			int rows = inScanner.nextInt();
			int cols = inScanner.nextInt();
			char[][] words = new char[rows][cols];
			for(int i = 0; i < rows; i++) {
				words[i] = inScanner.next().toCharArray();
			}
			char[] word = inScanner.next().toCharArray();
			// ��ʼѰ�ҵ��ʵĸ���
			int num = 0;
			for(int i = 0; i < rows; i++) {
				for(int j = 0; j < cols; j++) {
					if(word[0] == words[i][j]) {
						// ��������word���ȵ��ַ�
						for(int k = 0; k < word.length &&i+k<rows; k++) {
							if(words[i+k][j] == word[k]) {
								if(k==word.length-1) {
									num++;
								}
							} else {
								break;
							}
						}
						// ����
						for(int k = 0; k < word.length && j+k < cols; k++) {
							if(words[i][j+k]==word[k]) {
								if(k==word.length-1) {
									num++;
								}
							} else {
								break;
							}
						}
						// �����·�
						for(int k = 0; k < word.length && i+k<rows&&j+k<cols; k++) {
							if(words[i+k][j+k]==word[k]) {
								if(k==word.length-1) {
									num++;
								}
							} else {
								break;
							}
						}
					}
				}
			}
			System.out.println(num);
		}
		inScanner.close();
	}
	
	
	
}

/**
 * 
 */
package com.datastructure;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zolanunu
 *
 */
public class Coffeee {
	private static long counter = 0;
	private final long id = counter++;
	public String  toString() {
		return getClass().getSimpleName()+" " + id;
	}
	
	public static void main(String[] args) {
		ArrayDeque<String> a = new ArrayDeque<>();
		Deque<String> strings = new LinkedList<>();
		
	}
	
}

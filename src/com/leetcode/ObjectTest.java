package com.leetcode;

public class ObjectTest {
	public static void main(String[] args) {
		ObjectTest ot1 = new ObjectTest();
		try {
			ObjectTest ot2 = (ObjectTest)ot1.clone();
		} catch (CloneNotSupportedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

package com.java.java_base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflection {
	public static void main(String[] args) {
		try {
			TestForReflection objForReflection = TestForReflection.class.newInstance();
			BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
			String string = bReader.readLine();
			Method method;
			if(string.equals("sayh")) {
				method = TestForReflection.class.getDeclaredMethod("sayHello");
			} else {
				method = TestForReflection.class.getDeclaredMethod("sayWorld");
			}
			method.invoke(objForReflection);
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

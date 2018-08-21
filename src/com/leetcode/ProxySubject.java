package com.java.java_base;

/**
 * @author zola
 *
 */
public class ProxySubject implements AbstractSubject {

	/* (non-Javadoc)
	 * @see java_base.eclipsebase.AbstractSubject#sayHello()
	 */
	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
		// 真实角色引用
	}
	private RealSubject realSubject; 
	// source
}

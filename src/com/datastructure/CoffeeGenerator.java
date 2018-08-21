/**
 * 
 */
package com.datastructure;

import java.util.Iterator;
import java.util.Random;

/**
 * @author zolanunu
 *
 */
public class CoffeeGenerator implements Generator<Coffeee>, Iterable<Coffeee> {
	private Class[] typesClasses = {Mocha.class, Latte.class};
	private static Random rand = new Random(14);
	public CoffeeGenerator() {
		
	}
	private int size = 0;
	public CoffeeGenerator(int size) {
		this.size = size;
	}
	
	public Coffeee next() {
		try {
			return (Coffeee)typesClasses[rand.nextInt(typesClasses.length)].newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	class CoffeeIterator implements Iterator<Coffeee> {
		int count = size;
		public boolean hasNext() {
			return count > 0;
		}
		public Coffeee next() {
			count--;
			return CoffeeGenerator.this.next();
		}
		public void remove() {
			throw new UnsupportedOperationException();
		}
	};
	
	public Iterator<Coffeee> iterator() {
		return new CoffeeIterator();
	}
	public static void main(String[] args) {
		CoffeeGenerator gen = new CoffeeGenerator();
		for(int i = 0; i < 5; i++) {
			System.out.println(gen.next());
		}
		for(Coffeee c : new CoffeeGenerator(5)) {
			System.out.println(c);
		}
	}
}

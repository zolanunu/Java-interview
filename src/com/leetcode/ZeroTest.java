package com.leetcode;
public class ZeroTest {

	static int cnt = 6;
	static {
		cnt += 9;
	}
	static {
		cnt /= 3;
	};
	public int x;

	public static void main(String[] args) {
		Integer i = 42;
		Long l = 42l;
		Double d = 42.0;
		System.out.println(i.equals(l));
		System.out.println(d.equals(l));
		System.out.println(i.equals(d));
		System.out.println(l.equals(42L));
		System.out.println("cnt =" + cnt);
		//System.out.println(x);
		Integer i01 = 59;
		int i02 = 59;
		Integer i03 = Integer.valueOf(59);
		Integer i04 = new Integer(59);
		
		System.out.println(i01==i02);
		System.out.println(i01==i03);
		System.out.println(i03==i04);
		System.out.println(i02==i04);
//		try {
//			int i = 100/0;
//			System.out.println(i);
//		} catch (Exception e) {
//			System.out.println(1);
//			// TODO: handle exception
//			throw new RuntimeException();
//		} finally {
//			System.out.println(2);
//		}
//		
//		System.out.println(3);
		Thread thread = new Thread() {
			@Override
			public void run() {
				pong();
			}
		};
		thread.run();
		System.out.println("ping");
	}

	static void pong() {
		System.out.println("pong");
	}

}

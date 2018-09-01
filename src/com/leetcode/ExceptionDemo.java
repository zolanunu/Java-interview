package com.leetcode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ExceptionDemo {
	public String runtimeServerMethod(String s) {
		if (s == null) {
			throw new RuntimeException("runtimeServerMethod�������ַ�������Ϊ��");
		}
		// �������߳�ֱ���жϣ�����Ĵ��벻��ִ��
		return s;
	}

	private BufferedReader bufferedReader;

	public String checkedServerMethod(String s) throws IOException {
		File file = new File(s);
		Reader reader = new FileReader(file);
		bufferedReader = new BufferedReader(reader);
		String result = bufferedReader.readLine();
		return result;
	}

	// ����һ
	public void currentMethod() {
		System.out.println("-----------------------try-catch-before");
		String result = this.runtimeServerMethod(null);
		System.out.println("------------------------result: " + result);
		System.out.println("-----------------------try-catch-before");
	}

	// ���̶�
	/**
	 * ����һ�����õ�ʵ������Ϊ����ʱ�쳣��ò�Ҫ���� ����ʱϵͳ�����������쳣����
	 * �쳣�����Ժ�try�������Ĵ��벻����ִ�У���������catch����� �̲߳��жϣ�ִ������������
	 * */
	public void currentMethod2() {
		System.out.println("-----------------------try-catch-before");
		String result = null;
		try {
			result = this.runtimeServerMethod(null);
			System.out.println("--------------------result: " + result);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("-------------------in-catch");
		}
		System.out.println("-----------------------try-catch-after");
		// -----------------------try-catch-before
		// -------------------in-catch
		// -----------------------try-catch-after

	}

	// ������
	// ���Ϸ��񷽷��Ĺ���ʱ���Ͳ����׳�����ʱ�쳣�������Ϳ�������ִ�����
	public void currentMethod3() {
		System.out.println("--------------------try-catch-before");
		String result = null;
		result = this.runtimeServerMethod("Conform to the rules");
		System.out.println("--------------------result:" + result);
		System.out.println("--------------------try-catch-after");
		/**
		 * --------------------try-catch-before
		 * --------------------result:Conform to the rules
		 * --------------------try-catch-after
		 * */
	}

	// ������
	/**
	 * ������checkedServerMethod���������ҷ�����Checked Exceptionʱ�� һ��Ҫ������������쳣��������벻ͨ��
	 * */
	public void currentMethod4() {
		System.out.println("--------------------try-catch-before");
		String result = null;
		try {
			result = this.checkedServerMethod("");
			System.out.println("--------------------result:" + result);
		} catch (IOException e) {
			System.out.println("--------------------in-catch");
		} finally {
			System.out.println("--------------------in-finally");
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("--------------------try-catch-after");
		/**
		 * --------------------try-catch-before --------------------in-catch
		 * --------------------in-finally --------------------try-catch-after
		 * */
	}

	// ������
	/**
	 * catch��������һ��return���
	 * */
	public void currentMethod5() {
		System.out.println("--------------------try-catch-before");
		String result = null;
		try {
			result = this.checkedServerMethod("");
			System.out.println("--------------------result:" + result);
		} catch (IOException e) {
			System.out.println("--------------------in-catch");
			return;
		} finally {
			System.out.println("--------------------in-finally");
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("--------------------try-catch-after");
		/**
		 * --------------------try-catch-before --------------------in-catch
		 * --------------------in-finally
		 * */
	}

	// ������
	/**
	 * 
	 * */
	public void userMethod() {
		try {
			this.currentMethod6();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void currentMethod6() throws IOException {
		System.out.println("--------------------try-catch-before");
		String result = null;
		try {
			result = this.checkedServerMethod("");
			System.out.println("--------------------result:" + result);
		} catch (IOException e) {
			System.out.println("--------------------in-catch");
			this.checkedServerMethod("catch"); // �׳���һ���쳣
		} finally {
			System.out.println("--------------------in-finally");
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("--------------------try-catch-after");
	}

	// ������
	/**
	 * ������������������������finally�����Ҳ�׳���һ���쳣�� ������userMethod�������沶�񵽵���finally�������쳣��
	 * catch��������׳����쳣��ѹ���ˡ�
	 * */
	public void userMethod1() {
		try {
			this.currentMethod7();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void currentMethod7() throws IOException {
		System.out.println("--------------------try-catch-before");
		String result = null;
		try {
			result = this.checkedServerMethod("");
			System.out.println("--------------------result:" + result);
		} catch (IOException e) {
			System.out.println("--------------------in-catch");
			this.checkedServerMethod("catch"); // catch�׳����쳣
		} finally {
			System.out.println("--------------------in-finally");
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			this.checkedServerMethod("finally"); // finallyҲ�׳����쳣
		}
		System.out.println("--------------------try-catch-after");
	}

	// ���̰�
	/**
	 * ���û��catch����飬ǿ��Ҫ�������׳��쳣��
	 *  userMethod���񵽵���try������׳����쳣
	 * �����finally�����Ҳ�׳��쳣������쳣�ͻᱻѹ�֣���
	 *  finally����黹�ǻ�ִ�С�
	 * */
	public void userMethod3() {
		try {
			this.currentMethod8();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void currentMethod8() throws IOException {
		System.out.println("--------------------try-catch-before");
		String result = null;
		try {
			result = this.checkedServerMethod("");
			System.out.println("--------------------result:" + result);
		} finally {
			System.out.println("--------------------in-finally");
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("--------------------try-catch-after");
	}

	public static void main(String[] args) {
		ExceptionDemo ts = new ExceptionDemo();
		ts.currentMethod2();
	}
}

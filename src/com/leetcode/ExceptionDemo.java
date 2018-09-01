package com.leetcode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ExceptionDemo {
	public String runtimeServerMethod(String s) {
		if (s == null) {
			throw new RuntimeException("runtimeServerMethod方法的字符串不能为空");
		}
		// 主流程线程直接中断，后面的代码不再执行
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

	// 流程一
	public void currentMethod() {
		System.out.println("-----------------------try-catch-before");
		String result = this.runtimeServerMethod(null);
		System.out.println("------------------------result: " + result);
		System.out.println("-----------------------try-catch-before");
	}

	// 流程二
	/**
	 * 这是一个不好的实践，因为运行时异常最好不要捕获 运行时系统并不会区分异常类型
	 * 异常发生以后，try代码后面的代码不会在执行，而是跳到catch代码块 线程不中断，执行完整个代码
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

	// 流程三
	// 符合服务方法的规则时，就不会抛出运行时异常。方法就可以正常执行完成
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

	// 流程四
	/**
	 * 调用了checkedServerMethod方法，并且发生了Checked Exception时， 一定要捕获或声明该异常，否则编译不通过
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

	// 流程五
	/**
	 * catch代码块多了一条return语句
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

	// 流程六
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
			this.checkedServerMethod("catch"); // 抛出了一个异常
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

	// 流程七
	/**
	 * 和流程六比起来，流程七在finally代码块也抛出了一个异常， 最终在userMethod方法里面捕获到的是finally代码块的异常，
	 * catch代码块里抛出的异常被压抑了。
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
			this.checkedServerMethod("catch"); // catch抛出了异常
		} finally {
			System.out.println("--------------------in-finally");
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			this.checkedServerMethod("finally"); // finally也抛出了异常
		}
		System.out.println("--------------------try-catch-after");
	}

	// 流程八
	/**
	 * 如果没有catch代码块，强制要求声明抛出异常。
	 *  userMethod捕获到的是try代码块抛出的异常
	 * （如果finally代码块也抛出异常，这个异常就会被压抑）。
	 *  finally代码块还是会执行。
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

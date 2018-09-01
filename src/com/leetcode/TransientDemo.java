/**
 * 
 */
package com.leetcode;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author zolanunu
 *
 */
// 序列化Transient关键字
public class TransientDemo {
	static int id = 100;
	static String name = "大使丹";
	static String url = "http://dashidan.com";
	static String weather = "晴朗";
	
	public static void main(String[] args) {
		TestObject testObject = new TestObject(id, name, url, weather);
		try {
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			ObjectOutputStream outputStream = new ObjectOutputStream(byteArrayOutputStream);
			outputStream.writeObject(testObject);
			outputStream.close();
			byte[] bytes = byteArrayOutputStream.toByteArray();
			byteArrayOutputStream.close();
			
			/**
			 * 反序列化，转化为对象
			 * */
			
			ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            ObjectInputStream inputStream = new ObjectInputStream(byteArrayInputStream);
            TestObject obj = (TestObject) inputStream.readObject();
            inputStream.close();
            byteArrayInputStream.close();
			
			System.out.println(obj.getId());
            System.out.println(obj.getName());
            System.out.println(obj.getUrl());
            System.out.println(obj.getWeather());
		} catch (IOException e) {
			e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
	}
}

package com.leetcode;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomXml {
	public static void main(String[] args) {
		// 	1. 创建一个DocumentBuilderFactory对象
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
		try {
			// 2. 创建一个DocumentBuilder的对象
			DocumentBuilder db = dbf.newDocumentBuilder();
			// 3. 通过DocumentBuilder对象的parse方法解析xml文件
			Document document = db.parse("books.xml"); // 使用相对路径
			// db.pazrse("D:\zola_workspace\learn\xml\books.xml") // 采用绝对路径
			// 获取所有book节点的集合
			NodeList booklist = document.getElementsByTagName("book");
			// 遍历根节点bookstore下的所有子节点book
			System.out.println("=======书店中一共有：" + booklist.getLength() + "本书, 下面每本书的内容是：=======");
			for(int i = 0; i < booklist.getLength(); i++) {
				// 通过获取一个book节点
				Node book = booklist.item(i);
				// 获取book节点的所有属性集合
				NamedNodeMap  attrMap = book.getAttributes();
				System.out.println("第" + i+1 + "本书， 共有" + attrMap.getLength() + "个属性");
				// 遍历book的属性
				for(int j = 0; j < attrMap.getLength(); j++) {
					// 通过item方法获取book节点的某一个属性
					Node atrr = attrMap.item(j);
					// 获取属性名
					System.out.println("属性名：" + atrr.getNodeName());
					// 获取属性值
					System.out.println("属性值：" + atrr.getNodeValue());
				}
				System.out.println("==========================================");
				NodeList childNodes = book.getChildNodes();
				//遍历childNodes获取每个节点的节点名和节点值
				System.out.println("第" + (i+1) + "本书共有" + 
				childNodes.getLength() + "个子节点");
				for (int k = 0; k < childNodes.getLength(); k++) {
					//区分出text类型的node以及element类型的node
					if (childNodes.item(k).getNodeType() == Node.ELEMENT_NODE) {
						//获取了element类型节点的节点名
						System.out.print("第" + (k + 1) + "个节点的节点名：" 
						+ childNodes.item(k).getNodeName());
//						获取了element类型节点的节点值
						System.out.println("--节点值是：" + childNodes.item(k).getFirstChild().getNodeValue());
//						System.out.println("--节点值是：" + childNodes.item(k).getTextContent());
					}
				}
				System.out.println("======================结束遍历第" + (i + 1) + "本书的内容=================");
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

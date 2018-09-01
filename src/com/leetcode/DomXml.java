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
		// 	1. ����һ��DocumentBuilderFactory����
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
		try {
			// 2. ����һ��DocumentBuilder�Ķ���
			DocumentBuilder db = dbf.newDocumentBuilder();
			// 3. ͨ��DocumentBuilder�����parse��������xml�ļ�
			Document document = db.parse("books.xml"); // ʹ�����·��
			// db.pazrse("D:\zola_workspace\learn\xml\books.xml") // ���þ���·��
			// ��ȡ����book�ڵ�ļ���
			NodeList booklist = document.getElementsByTagName("book");
			// �������ڵ�bookstore�µ������ӽڵ�book
			System.out.println("=======�����һ���У�" + booklist.getLength() + "����, ����ÿ����������ǣ�=======");
			for(int i = 0; i < booklist.getLength(); i++) {
				// ͨ����ȡһ��book�ڵ�
				Node book = booklist.item(i);
				// ��ȡbook�ڵ���������Լ���
				NamedNodeMap  attrMap = book.getAttributes();
				System.out.println("��" + i+1 + "���飬 ����" + attrMap.getLength() + "������");
				// ����book������
				for(int j = 0; j < attrMap.getLength(); j++) {
					// ͨ��item������ȡbook�ڵ��ĳһ������
					Node atrr = attrMap.item(j);
					// ��ȡ������
					System.out.println("��������" + atrr.getNodeName());
					// ��ȡ����ֵ
					System.out.println("����ֵ��" + atrr.getNodeValue());
				}
				System.out.println("==========================================");
				NodeList childNodes = book.getChildNodes();
				//����childNodes��ȡÿ���ڵ�Ľڵ����ͽڵ�ֵ
				System.out.println("��" + (i+1) + "���鹲��" + 
				childNodes.getLength() + "���ӽڵ�");
				for (int k = 0; k < childNodes.getLength(); k++) {
					//���ֳ�text���͵�node�Լ�element���͵�node
					if (childNodes.item(k).getNodeType() == Node.ELEMENT_NODE) {
						//��ȡ��element���ͽڵ�Ľڵ���
						System.out.print("��" + (k + 1) + "���ڵ�Ľڵ�����" 
						+ childNodes.item(k).getNodeName());
//						��ȡ��element���ͽڵ�Ľڵ�ֵ
						System.out.println("--�ڵ�ֵ�ǣ�" + childNodes.item(k).getFirstChild().getNodeValue());
//						System.out.println("--�ڵ�ֵ�ǣ�" + childNodes.item(k).getTextContent());
					}
				}
				System.out.println("======================����������" + (i + 1) + "���������=================");
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

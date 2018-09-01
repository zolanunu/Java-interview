/**
 * 
 */
package com.leetcode;
import java.io.Serializable;

/**
 * @author zolanunu
 *
 */
public class TestObject implements Serializable {
	int id;
	String name;
	String url;
	transient String weather;
	
	
	/**   
	 * @Title:  TestObject   
	 * @Description:    TODO(这里用一句话描述这个方法的作用)   
	 * @param:  @param id
	 * @param:  @param name
	 * @param:  @param url
	 * @param:  @param weather  
	 * @throws   
	 */
	public TestObject(int id, String name, String url, String weather) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
		this.weather = weather;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	
	
}

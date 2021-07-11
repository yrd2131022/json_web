package com.yrd.json.fast_json;

import java.util.Date;

/*
 * int 数据：如果没有赋值默认为 0
 * Integer数据：默认值为null
 */
public class Student {
	
	private Integer id;
	private String name;
	private int age;
	private String email;
	private Date birthday;
	private Boolean flag;
	public Boolean getFlag() {
		return flag;
	}
	public void setFlag(Boolean flag) {
		this.flag = flag;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "Student {\"id\"=\"" + id + "\", \"name\"=\"" + name + "\", \"age\"=\"" + age + "\", \"email\"=\""
				+ email + "\", \"birthday\"=\"" + birthday + "\"}";
	}
	
	
	

}

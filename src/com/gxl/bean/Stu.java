package com.gxl.bean;

public class Stu extends Classes{
	private int id;
	private int xuehao;
	private String name;
	private String sex;
	private int age;
	private int cid;
	public Stu() {
		super();
	}
	public Stu(int id, int xuehao, String name, String sex, int age, int cid) {
		super();
		this.id = id;
		this.xuehao = xuehao;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.cid = cid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getXuehao() {
		return xuehao;
	}
	public void setXuehao(int xuehao) {
		this.xuehao = xuehao;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	@Override
	public String toString() {
		return "Stu [id=" + id + ", xuehao=" + xuehao + ", name=" + name
				+ ", sex=" + sex + ", age=" + age + ", cid=" + cid + ", getCname()="+getCname()+"]";
	}
	
	
}

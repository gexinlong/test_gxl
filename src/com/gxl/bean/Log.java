package com.gxl.bean;

public class Log {
	private int id;
	private String username;//µÇÂ¼ÓÃ»§Ãû
	private String password;//µÇÂ¼ÃÜÂë
	public Log() {
		super();
	}
	public Log(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Log [id=" + id + ", username=" + username + ", password="
				+ password + "]";
	}
	

}

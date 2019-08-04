package com.gxl.bean;

public class Classes {
	private int id;
	private int cid;
	private String cname;
	public Classes() {
		super();
	}
	public Classes(int cid, String cname) {
		super();
		this.cid = cid;
		this.cname = cname;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	@Override
	public String toString() {
		return "Class [cid=" + cid + ", cname=" + cname + "]";
	}
	

}

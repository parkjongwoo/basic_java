package com.day12.event;

public class InfoVO {
	private String name;
	private String phoneNum;
	private String pID;
	private String zender;
	private String age;
	private String home;
	
	public InfoVO() {}

	public InfoVO(String name, String phoneNum, String pID, String zender, String age, String home) {
		super();
		this.name = name;
		this.phoneNum = phoneNum;
		this.pID = pID;
		this.zender = zender;
		this.age = age;
		this.home = home;
	}	
	
	@Override
	public String toString() {		
		return "["+name+":"+phoneNum+":"+pID+":"+zender+":"+age+":"+home+"]\n";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getpID() {
		return pID;
	}

	public void setpID(String pID) {
		this.pID = pID;
	}

	public String getZender() {
		return zender;
	}

	public void setZender(String zender) {
		this.zender = zender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}
	
}

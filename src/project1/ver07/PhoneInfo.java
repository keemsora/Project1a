package project1.ver07;

import java.util.Scanner;


public class PhoneInfo {
	
	String name;
	String phoneNumber;

	
	public PhoneInfo(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	public void showPhoneInfo() {
		System.out.printf("이름:%s\n", name);
		System.out.printf("전화번호:%s\n", phoneNumber);
		System.out.println();
	
	}
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public int hashCode() {
		int hc = name.hashCode();
		return hc;
	}

	@Override
	public boolean equals(Object obj) {
		PhoneInfo phoneInfo = (PhoneInfo)obj;
		
		if(this.name.equals(phoneInfo.name)) {
			return true;
		}
		else {
			return false;
		}
	}

	
	
}























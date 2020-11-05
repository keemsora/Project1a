package project1.ver02;

import java.util.Scanner;


public class PhoneInfo {
	
	String name;
	String phoneNumber;
	String birthday;
	
	public PhoneInfo() {
	}
	
	public PhoneInfo(String name, String phoneNumber, String birthday) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
	}
	
	public PhoneInfo(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		birthday = "입력되지않음";
	}

	public void showPhoneInfo() {
		System.out.printf("이름:%s\n", name);
		System.out.printf("전화번호:%s\n", phoneNumber);
		System.out.printf("생년월일:%s\n", birthday);
		System.out.println();
	
	}
	
	public void addPhoneInfo() {
		
		Scanner scan = new Scanner(System.in);

		System.out.print("이름:");this.name=scan.nextLine();
		System.out.print("전화번호:");this.phoneNumber=scan.nextLine();
		System.out.print("생년월일:");this.birthday=scan.nextLine();
		
	}
	

	

	
}





















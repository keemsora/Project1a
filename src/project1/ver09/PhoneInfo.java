package project1.ver09;

import java.util.Scanner;


public class PhoneInfo {
	
	String name;
	String phoneNumber;
	String birthday;
	
	public PhoneInfo(String name, String phoneNumber, String birthday) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
	}
	
	public void showPhoneInfo() {
		System.out.printf("이름:%s\n", name);
		System.out.printf("전화번호:%s\n", phoneNumber);
		System.out.printf("생년월일:%s\n", birthday);
		System.out.println();
	
	}
	
	public void addPhoneInfo() {
		
		Scanner scan = new Scanner(System.in);

		System.out.print("이름:");name=scan.nextLine();
		System.out.print("전화번호:");phoneNumber=scan.nextLine();
		System.out.print("생년월일:");birthday=scan.nextLine();
		
	}
	
	public void dataAllShow() {
		System.out.println("이름:"+name);
		System.out.println("전화번호:"+phoneNumber);
		System.out.println("생년월일:"+birthday);
	}
	

	
}





















package project1;

import java.util.Scanner;

import project1.ver02.PhoneInfo;

public class PhoneBookVer02 {
	
	
	public static void menuShow() {
		System.out.println("선택하세요");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 프로그램 종료");
		System.out.print("선택:");
	}
	
	public static void main(String[] args) {
		
		PhoneInfo ph = new PhoneInfo();
		
		while(true) {
			menuShow();
			
			Scanner scan = new Scanner(System.in);
			int choice = scan.nextInt();
			
			switch(choice) {
			case 1:
				ph.addPhoneInfo();
				
				System.out.println("입력된 정보 출력");
				ph.showPhoneInfo();
				break;
				
			case 2:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}
		
	}
	

}

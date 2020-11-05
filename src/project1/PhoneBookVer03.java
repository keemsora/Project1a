package project1;

import java.util.Scanner;

import project1.ver02.PhoneInfo;
import project1.ver03.PhoneBookManager;

public class PhoneBookVer03 {
	
	public static void main(String[] args) {
		
		PhoneBookManager phMgr =
				new PhoneBookManager(100);
		
		while(true) {
			
			phMgr.printMenu();
			
			Scanner scan = new Scanner(System.in);
			int choice = scan.nextInt();
			
			switch(choice) {
			case 1:
				phMgr.dataInput();
				break;
			case 2:
				phMgr.dataSearch();
				break;
			case 3:
				phMgr.dataDelete();
				break;
			case 4:
				phMgr.dataAllShow();
				break;
			case 5:
				System.out.println("***프로그램을 종료합니다***");
				return;
			}
		}
		
	}
	

}

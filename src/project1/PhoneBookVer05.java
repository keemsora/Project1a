package project1;

import java.util.Scanner;

import project1.ver04.PhoneBookManager;
import project1.ver05.MenuItem;

public class PhoneBookVer05 implements MenuItem {
	
	public static void main(String[] args) {
		
		PhoneBookManager phMgr =
				new PhoneBookManager(100);
		
		while(true) {
			
			phMgr.printMenu();
			
			Scanner scan = new Scanner(System.in);
			int choice = scan.nextInt();
			
			switch(choice) {
			case MenuItem.데이터입력:
				phMgr.dataInput();
				break;
			case MenuItem.데이터검색:
				phMgr.dataSearch();
				break;
			case MenuItem.데이터삭제:
				phMgr.dataDelete();
				break;
			case MenuItem.출력:
				phMgr.dataAllShow();
				break;
			case MenuItem.프로그램종료:
				System.out.println("***프로그램을 종료합니다***");
				return;
			}
		}
		
	}
	

}

package project1;

import java.util.Scanner;

import project1.ver09.PhoneBookManager;

public class PhoneBookVer09 {

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
				System.out.println("***프로그램을 종료합니다***");
				return;
			}
		}
	}
}

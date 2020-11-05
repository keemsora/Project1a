package project1;

import java.util.InputMismatchException;
import java.util.Scanner;

import project1.ver06.MenuItem;
import project1.ver06.MenuSelectException;
import project1.ver06.PhoneBookManager;

public class PhoneBookVer06 implements MenuItem {

	public static void main(String[] args) {

		PhoneBookManager phMgr =
				new PhoneBookManager(100);

		while(true) {

			phMgr.printMenu();

			Scanner scan = new Scanner(System.in);

			try {	
				int choice = readChoice();

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
			catch(InputMismatchException e) {
				System.out.println("[예외발생] 숫자를 입력하세요.");
			}
			catch(MenuSelectException e) {
				System.out.println("[예외발생]"+e.getMessage());
			}
		}
	}////end of main


	private static int readChoice() throws MenuSelectException {
		Scanner sc = new Scanner(System.in);
		int inputNum= 0;

		try {
			inputNum = sc.nextInt();
		}
		catch(InputMismatchException e) {
			e.printStackTrace();
			System.exit(0);
		}

		if(inputNum>5 || inputNum<=0) {
			MenuSelectException ex = new MenuSelectException();
			throw ex;
		}
		return inputNum;
	}
}




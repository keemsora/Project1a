package project1;

import java.util.InputMismatchException;
import java.util.Scanner;

import project1.ver08.MenuItem;
import project1.ver08.PhoneBookManager;
import project1.ver08.MenuSelectException;
import project1.ver08.AutoSaverT;


public class PhoneBookVer08 implements MenuItem {
	
	public static void main(String[] args) {
		
		AutoSaverT auto = new AutoSaverT();
		PhoneBookManager phMgr = new PhoneBookManager();
		
			while(true) {

			try {	
				phMgr.printMenu();
				Scanner scan = new Scanner(System.in);
				int choice = readChoice();
							
				switch(choice) {
				case MenuItem.Input:
					phMgr.dataInput();
					break;
				case MenuItem.Search:
					phMgr.dataSearch();
					break;
				case MenuItem.Delete:
					phMgr.dataDelete();
					break;
				case MenuItem.Print:
					phMgr.dataAllShow();
					break;
				case MenuItem.Opt:
					phMgr.autoSave();
					break;
				case MenuItem.Exit:
					phMgr.saveAllData();
					
					System.out.println("***프로그램을 종료합니다***");
					return;
				}
			}
			catch(InputMismatchException e) {
				System.out.println("[예외발생] 숫자를 입력하세요.");
				System.out.println("");
			}
			catch(MenuSelectException e) {
				System.out.println("[예외발생] "+e.getMessage());
				System.out.println("");
			}
			
		}
	}////end of main


	private static int readChoice() throws MenuSelectException {
		Scanner sc = new Scanner(System.in);
		int inputNum= 0;
		inputNum = sc.nextInt();
		sc.nextLine();

		if(inputNum>6 || inputNum<=0) {
			MenuSelectException ex = new MenuSelectException();
			throw ex;
		}
		return inputNum;
	}
}




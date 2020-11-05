package project1.ver03;

import java.util.Scanner;

public class PhoneBookManager {
	
	private PhoneInfo[] phInfo;
	private int numOfPhones;
	
	public PhoneBookManager(int num) {
		phInfo = new PhoneInfo[num];
		numOfPhones = 0;
	}
	
	public void printMenu() {
		System.out.println("***원하시는 서비스를 선택하세요***");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 검색");
		System.out.println("3. 데이터 삭제");
		System.out.println("4. 주소록 출력");
		System.out.println("5. 프로그램 종료");
		System.out.print("번호 입력:");
	}
	
	public void dataInput() {
		
		Scanner sc = new Scanner(System.in);
		String iName, iPhNum, iBirth;
		
		System.out.println("이름:");iName=sc.nextLine();
		System.out.println("전화번호:");iPhNum=sc.nextLine();
		System.out.println("생년월일:");iBirth=sc.nextLine();
		
		phInfo[numOfPhones++] =
				new PhoneInfo(iName, iPhNum, iBirth);
		
		System.out.println("***데이터 입력이 완료되었습니다***");
	}
	
	public void dataSearch() {
		boolean isFind = false;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("검색 이름을 입력하세요:");
		String searchName = sc.nextLine();
		
		for(int i=0; i<numOfPhones; i++) {
	
			if(searchName.compareTo(phInfo[i].name)==0) {
				System.out.println("검색중인이름:"+ phInfo[i].name);
				phInfo[i].showPhoneInfo();
				System.out.println("***귀하가 요청하는 정보를 찾았습니다***");
				isFind = true;
			}
		}
		
		if(isFind==false)
			System.out.println("***찾는 정보가 없습니다***");
	}
	
	public void dataDelete() {
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 이름을 입력하세요:");
		String deleteName = sc.nextLine();
		
		int deleteIndex = -1;
		
		for(int i=0; i<numOfPhones; i++) {
			if(deleteName.compareTo(phInfo[i].name)==0) {
				phInfo[i]=null;
				deleteIndex=i;
				numOfPhones--;
			}
		}
		
		if(deleteIndex==-1) {
			System.out.println("***삭제된 데이터가 없습니다***");
		}
		else {
			for(int i=deleteIndex; i<numOfPhones; i++) {
				phInfo[i] = phInfo[i+1];
			}
			System.out.println("***데이터("+deleteIndex+"번)가 삭제되었습니다***");
		}
	}
	
	public void dataAllShow() {
		for(int i=0; i<numOfPhones; i++) {
			phInfo[i].dataAllShow();
		}
	}

}

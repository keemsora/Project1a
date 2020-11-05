package project1.ver07;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class PhoneBookManager implements SubMenuItem{
	
	HashSet<PhoneInfo> set= new HashSet<PhoneInfo>();
	Scanner sc = new Scanner(System.in);
	
	public PhoneBookManager() {
	}
	
	public void printMenu() {
		System.out.println("***원하시는 서비스를 선택하세요***");
		System.out.println("1. 주소록 입력");
		System.out.println("2. 검색");
		System.out.println("3. 삭제");
		System.out.println("4. 출력");
		System.out.println("5. 프로그램 종료");
		System.out.print("선택>>");
	}
	
	public void dataInput() {
		
		String iName, iPhNum, iMajor, iCpName;
		int iGrade;
		
		System.out.println("1. 일반 2. 동창 3. 회사");
		System.out.print("선택>>");
		int ch = sc.nextInt();

		
		if(ch==1) {
			System.out.print("이름:\n");iName=sc.next();
			System.out.print("전화번호:");iPhNum=sc.next();
			PhoneInfo ph = new PhoneInfo(iName, iPhNum);

			boolean flag = set.add(ph);
			
			if(flag==false) {
				
				System.out.println("이미 저장된 데이터입니다.");
				System.out.println("덮어쓸까요? Y(y) / N(n)");
				String ans = sc.next();
				if(ans.equals("y") || ans.equals("Y")) {
					set.remove(ph);
					set.add(ph);
					System.out.println("입력한 정보가 저장되었습니다.");
				}
				else if(ans.equals("n") || ans.equals("N")) {
					System.out.println("저장하지 않았습니다.");
				}
			}
		}
		else if(ch==2) {
			
			System.out.print("이름:");iName=sc.next();
			System.out.print("전화번호:");iPhNum=sc.next();
			System.out.print("전공:"); iMajor=sc.next();
			System.out.print("학년:"); iGrade=sc.nextInt();
			
			PhoneSchoolInfo phSch =
					new PhoneSchoolInfo(iName, iPhNum, iMajor, iGrade);
			
			boolean flag = set.add(phSch);
			
			if(flag==false) {
				System.out.println("이미 저장된 데이터입니다.");
				System.out.println("덮어쓸까요? Y(y) / N(n)");
				String ans = sc.next();
				if(ans.equals("y") || ans.equals("Y")) {
					set.remove(phSch);
					set.add(phSch);
					System.out.println("입력한 정보가 저장되었습니다.");
				}
				else if(ans.equals("n") || ans.equals("N")) {
					System.out.println("저장하지 않았습니다.");
				}
			}
		}
		else if(ch==3) {
			System.out.println("이름:");iName=sc.next();
			System.out.println("전화번호:");iPhNum=sc.next();
			System.out.print("회사명:"); iCpName=sc.next();
			PhoneCompanyInfo phCom =
					new PhoneCompanyInfo(iName, iPhNum, iCpName);
			
			boolean flag = set.add(phCom);
			
			if(flag==false) {
				System.out.println("이미 저장된 데이터입니다.");
				System.out.println("덮어쓸까요? Y(y) / N(n)");
				String ans = sc.next();
				if(ans.equals("y") || ans.equals("Y")) {
					set.remove(phCom);
					set.add(phCom);
					System.out.println("입력한 정보가 저장되었습니다.");
				}
				else if(ans.equals("n") || ans.equals("N")) {
					System.out.println("저장하지 않았습니다.");
				}
			}

		}
		System.out.println("***데이터 입력이 완료되었습니다***");
		System.out.println();
	}
	

	public void dataSearch() {
			
		Scanner sc = new Scanner(System.in);
		System.out.print("검색 이름을 입력하세요:");
		String searchName = sc.nextLine();
		boolean searchFlag = false;
		
		Iterator<PhoneInfo> itr = set.iterator();
		while (itr.hasNext()) {
			PhoneInfo ph = itr.next();
			if(ph.name.equals(searchName)==true) {
				searchFlag = true;
				System.out.println("***요청하신 정보를 찾았습니다***");
				ph.showPhoneInfo();
			}
		}
		if(searchFlag==false)
			System.out.println("***해당 이름은 존재하지 않습니다***");
	}
	
	public void dataDelete() {
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 이름을 입력하세요:");
		String deleteName = sc.nextLine();
		boolean searchFlag = false;
		
		Iterator<PhoneInfo> itr = set.iterator();
		while (itr.hasNext()) {
			PhoneInfo ph = itr.next();
			if(ph.name.equals(deleteName)) {
				itr.remove();
				searchFlag = true;
			}
		}
		if(searchFlag==true)
			System.out.println("***데이터 삭제가 완료되었습니다***");
		else
			System.out.println("***해당 이름이 존재하지 않아 삭제가 불가합니다***");
		

	}
	
	public void dataAllShow() {
		Iterator<PhoneInfo> itr = set.iterator();
		while(itr.hasNext()) {
			PhoneInfo ph = itr.next();
			ph.showPhoneInfo();
		}
	}

}

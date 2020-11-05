package project1.ver08;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;



public class PhoneBookManager implements SubMenuItem {

	AutoSaverT auto = new AutoSaverT();
	HashSet<PhoneInfo> set = new HashSet<PhoneInfo>();
	Scanner sc = new Scanner(System.in);

	public PhoneBookManager() {
	}

	public void printMenu() {

		System.out.println("=================메뉴를 선택하세요=================");
		System.out.println("1.주소록입력 2.검색 3.삭제 4.출력 5.저장옵션 6.종료");
		System.out.println("===================================================");
		System.out.print("선택>>>");
	}

	public void dataInput() {
		
		String iName, iPhNum, iMajor, iCpName;
		int iGrade;
		
		System.out.println("1. 일반 2. 동창 3. 회사");
		System.out.print("선택>>");
		int ch = sc.nextInt();

		
		if(ch==1) {
			System.out.print("이름:");iName=sc.next();
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
			System.out.print("검색할 이름을 입력하세요: ");
			String searchName = sc.nextLine();
			boolean searchFlag = false;

			Iterator<PhoneInfo> itr = set.iterator();
			while (itr.hasNext()) {
				PhoneInfo ph = itr.next();
				if (ph.getName().equals(searchName)) {
					searchFlag = true;
					System.out.println("[검색결과]");
					ph.showPhoneInfo();
					System.out.println("");
				}
			}
			if (searchFlag == false)
				System.out.println("[알람] 해당 이름은 존재하지 않습니다.");
		}

		public void dataDelete() {
			Scanner sc = new Scanner(System.in);
			System.out.print("삭제할 이름을 입력하세요:");
			String deleteName = sc.nextLine();
			boolean searchFlag = false;

			Iterator<PhoneInfo> itr = set.iterator();
			while (itr.hasNext()) {
				PhoneInfo ph = itr.next();
				if (ph.getName().equals(deleteName)) {
					itr.remove();
					searchFlag = true;
				}
			}
			if (searchFlag == true) {
				System.out.println("***데이터 삭제가 완료되었습니다***");
				System.out.println("");
			} else {
				System.out.println("[알람] 해당 이름이 존재하지 않아 삭제가 불가합니다.");
				System.out.println("");
			}
		}

		public void autoSave() {
			System.out.println("1.자동저장On 2.자동저장Off");
			System.out.print("선택>>");
			int ch = sc.nextInt();
			
			if (ch == 1) {
				if(!auto.isAlive()) {
					auto = new AutoSaverT();
					auto.setDaemon(true);
					auto.start();
					save();
					System.out.println("자동저장이 실행됩니다.");
				}
				else {
					System.out.println("이미 자동저장이 실행 중입니다.");
				}
			} else if (ch == 2) {
				auto.interrupt();
				System.out.println("자동저장이 종료되었습니다.");
			}
		}
		

		public void dataAllShow() {

			Iterator<PhoneInfo> itr = set.iterator();
			while (itr.hasNext()) {
				PhoneInfo ph = itr.next();
				ph.showPhoneInfo();
				System.out.println("");
			}
			
			try {
				ObjectInputStream in = new ObjectInputStream(
						new FileInputStream("src/project1/ver08/phoneBook.obj"));
				HashSet<PhoneInfo> ph = (HashSet<PhoneInfo>)in.readObject();
				System.out.println(ph.toString());
				in.close();
				}
			catch(FileNotFoundException e) {
				System.out.println("저장되어있는 주소록이 없습니다.");
			}
			catch(Exception e) {
				e.printStackTrace();
			}

			

		}

		public void saveAllData() {
			try {
				ObjectOutputStream out = new ObjectOutputStream(
						new FileOutputStream("src/project1/ver08/phoneBook.obj"));
					
					out.writeObject(set);
					out.close();
					System.out.println("주소록 저장이 완료되었습니다.");
			}
			catch (Exception e) {
				System.out.println("파일 저장 시 예외 발생");
				e.printStackTrace();
			} 
			
		}
		
		
		public void save() {
			try {
				ObjectOutputStream out = new ObjectOutputStream(
						new FileOutputStream("src/project1/ver08/AutoSaveBook.txt"));
				
				out.writeObject(set);
				out.close();
				
				}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
}
		




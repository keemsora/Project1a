package project1.ver09;

import java.util.Scanner;

public class InputData extends DBConnectImpl {
	
	public InputData() {
		super(ORACLE_DRIVER, "kosmo", "1234");
	}

	@Override
	public void execute() {
		try {
			String query = "INSERT INTO phonebook_tb VALUES (?,?,?)";
			
			psmt = con.prepareStatement(query);
			
			Scanner scan = new Scanner(System.in);
			System.out.print("이름:");
			String name = scan.nextLine();
			System.out.print("전화번호:");
			String phNum = scan.nextLine();
			System.out.print("생년월일:");
			String birthday = scan.nextLine();
			psmt.setString(1, name);
			psmt.setString(2, phNum);
			psmt.setString(3, birthday);
			
			int affected = psmt.executeUpdate();
			System.out.println(affected + "행이 입력되었습니다.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}
}
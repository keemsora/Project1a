package project1.ver09;

import java.sql.SQLException;
import java.util.Scanner;

public class SearchData extends ConnectDB {
	
	
	Scanner scan = new Scanner(System.in);
	
	public SearchData() {
		super();
	}
	
	@Override
	void execute() {
		try{
			stmt = con.createStatement();
			
			System.out.println("검색할 이름을 입력하세요: ");
			String searchName = scan.next();
			
			String query = "SELECT * FROM phonebook_tb "
					+ "WHERE name like '%"+searchName+"%'";
			rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				String name = rs.getString("name");
				String phNum = rs.getString("phNum");
				String birthday = rs.getString("birthday");
				
				System.out.println("====================================");
				System.out.printf("이름:%s\n전화번호:%s\n생년월일:%s\n", name, phNum, birthday);
				System.out.println("====================================");
			}
		}
		catch(SQLException e ) {
			System.out.println("검색 결과가 없습니다.");
			e.printStackTrace();
		}
		finally {
			close();
		}

		
	}
}


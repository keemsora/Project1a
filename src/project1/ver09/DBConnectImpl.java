package project1.ver09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DBConnectImpl implements DBConnect {
	
	public Connection con;
	public PreparedStatement psmt;
	public ResultSet rs;
	
	public DBConnectImpl() {
		System.out.println("기본생성자 호출");
	}
	
	public DBConnectImpl(String user, String pass) {
		System.out.println("인자생성자 호출");
		try {
			Class.forName(ORACLE_DRIVER);
			connect(user, pass);
		}
		catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		}
	}

	public DBConnectImpl(String driver, String user, String pass) {
		System.out.println("인자생성자 호출");
		try {
			Class.forName(ORACLE_DRIVER);
			connect(user, pass);
		}
		catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		}
	}

	@Override
	public void connect(String user, String pass) {
		try {
			con = DriverManager.getConnection(ORACLE_URL, user, pass);
		}
		catch(SQLException e) {
			System.out.println("데이터베이스 연결 오류");
			e.printStackTrace();
		}
	}

	@Override
	public void execute() {
	}

	@Override
	public void close() {
		try {
			if(con!=null)  con.close();
			if(psmt!=null) psmt.close();
			if(rs!=null) rs.close();
			System.out.println("자원 반납 완료");
		}
		catch(Exception e) {
			System.out.println("자원 반납 시 오류발생");
			e.printStackTrace();
		}
	}

	@Override
	public String scanValue(String title) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println(title);
		String inputStr = scan.nextLine();
		
		if("EXIT".equalsIgnoreCase(inputStr)) {
			System.out.println("프로그램을 종료합니다.");
			close();
			System.exit(0);
		}
		return inputStr;
	}
	
	
	
	

}

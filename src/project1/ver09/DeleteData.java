package project1.ver09;

public class DeleteData extends DBConnectImpl {

	public DeleteData() {
		super("kosmo", "1234");
	}

	@Override
	public void execute() {
		try {
			String query = "DELETE FROM phonebook_tb WHERE name=?";
			psmt = con.prepareStatement(query);
			psmt.setString(1, scanValue("삭제할 이름을 입력하세요: "));
			System.out.println(psmt.executeUpdate()
					+"행이 삭제되었습니다.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}
	
	
}


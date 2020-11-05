package project1.ver09;

public class PhoneBookManager extends DBConnectImpl{

	
	public PhoneBookManager(int num) {
		super(ORACLE_DRIVER, "kosmo", "1234");
	}
	
	public void printMenu() {
		System.out.println("========원하시는 서비스를 선택하세요========");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 검색");
		System.out.println("3. 데이터 삭제");
		System.out.println("4. 종료");
		System.out.print("선택>>> ");
	}
	
	public void dataInput() {
		InputData input = new InputData();
		input.execute();
		System.out.println("***데이터 입력이 완료되었습니다***");
	}
	
	public void dataSearch() {
		SearchData search = new SearchData();
		search.execute();
	}
	
	public void dataDelete() {
		DeleteData delete = new DeleteData();
		delete.execute();
	}
	

}

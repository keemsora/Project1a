package project1.ver07;

public class PhoneCompanyInfo extends PhoneInfo{
	
	String cpName;

	public PhoneCompanyInfo(String name, String phoneNumber, String cpName) {
		super(name, phoneNumber);
		this.cpName = cpName;
	}

	@Override
	public void showPhoneInfo() {
		super.showPhoneInfo();
		System.out.println("회사명:"+cpName);
	}
	
	

}

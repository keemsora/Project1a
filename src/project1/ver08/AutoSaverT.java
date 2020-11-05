package project1.ver08;


public class AutoSaverT extends Thread {
	

	@Override
	public void run() {
		try {
			while (true) {
				sleep(5000);
				System.out.println("주소록이 텍스트로 자동저장되었습니다.");
			}
		}catch (InterruptedException e) {}

	}

}
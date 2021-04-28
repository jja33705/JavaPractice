package ch14Practice;

public class Test {

	public static void main(String[] args) {
		String id = "scpa";
		String pw = "11111";
		try {
			login(id, pw);
			System.out.println("ȯ���մϴ�....");
		} catch (LoginIDException e) {
			System.out.println(e.getMessage()+" : "+e.getErrorCode());
			System.out.println("���̵�  �ȹٷ� �Է��ض� �� ����..");
		} catch (LoginPasswordException e) {
			System.out.println(e.getMessage()+" : "+e.getErrorCode());
			System.out.println("��й�ȣ  �ȹٷ� �Է��ض� �� ����..");
		}
	}
	
	private static void login(String id, String pw) throws LoginIDException, LoginPasswordException {
		checkDB(id, pw);
		
	}
	
	private static void checkDB(String id, String pw) throws LoginIDException, LoginPasswordException {
		if(id.equals("scpark") == false) {
			throw new LoginIDException("ID Error");
		} else if(pw.equals("11111") == false) {
			throw new LoginPasswordException("Password Error");
		} else {
			System.out.println("�α��� ����");
		}
	}
}

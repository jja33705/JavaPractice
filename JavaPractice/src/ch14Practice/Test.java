package ch14Practice;

public class Test {

	public static void main(String[] args) {
		String id = "scpark";
		String pw = "1111";
		try {
			login(id, pw);
			System.out.println("ȯ���մϴ�....");
		} catch (Exception e) {
			System.out.println("���̵�, ��ȣ �ȹٷ� �Է��ض� �� ����..");
		}
	}
	
	private static void login(String id, String pw) throws Exception {
//		try {
//			checkDB(id, pw);
//		} catch(Exception e) {
//			System.out.println(e.getMessage());
//		}
		
		checkDB(id, pw);
	}
	
	private static void checkDB(String id, String pw) throws Exception {
		if(id.equals("scpark") == false) {
			///id error
			throw new Exception("ID Error");
		} else if(pw.equals("1111") == false) {
			throw new Exception("Password Error");
		} else {
			System.out.println("�α��� ����");
		}
	}
}

package ch14Practice;

public class Test {

	public static void main(String[] args) {
		String id = "scpark";
		String pw = "1111";
		try {
			login(id, pw);
			System.out.println("환영합니다....");
		} catch (Exception e) {
			System.out.println("아이디, 암호 똑바로 입력해라 이 끼야..");
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
			System.out.println("로그인 성공");
		}
	}
}

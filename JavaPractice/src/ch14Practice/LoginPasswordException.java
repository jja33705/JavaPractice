package ch14Practice;

public class LoginPasswordException  extends LoginException{
	
	public LoginPasswordException(String errMsg) {
		super(errMsg);
	}
	
	public LoginPasswordException(String errMsg, int errCode) {
		super(errMsg, errCode);
	}
}

<<<<<<< HEAD
package Maverick_parking.model;

public class LoginErrorMsgs {
	
	private String errorMsg;
	private String userNamePasswordError;
	
	public String getErrorMsg() {
		return errorMsg;
	}
	//public void setErrorMsg(String errorMsg) {
//		if (!userNamePasswordError.equals(""))
//			errorMsg = "Please correct the following errors";
//		}
	public String getUserNamePasswordError() {
		return userNamePasswordError;
	}
	public void setUserNamePasswordError(String userNamePasswordError) {
		this.userNamePasswordError = userNamePasswordError;
	}
   
	

}
=======
package Maverick_parking.model;

public class LoginErrorMsgs {
	
	private String errorMsg;
	private String userNamePasswordError;
	
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		if (!userNamePasswordError.equals(""))
			errorMsg = "Please correct the following errors";
		}
	public String getUserNamePasswordError() {
		return userNamePasswordError;
	}
	public void setUserNamePasswordError(String userNamePasswordError) {
		this.userNamePasswordError = userNamePasswordError;
	}
   
	

}
>>>>>>> 33b67b3d4164e7ba319bd54766d6748fb733209b

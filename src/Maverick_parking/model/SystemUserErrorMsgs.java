<<<<<<< HEAD
package Maverick_parking.model;

public class SystemUserErrorMsgs {
	private String errorMsg;
	private String userNameError;
	private String passwordError;
	private String cpasswordError;
	private String nameError;
	
	public SystemUserErrorMsgs(){
		this.userNameError="";
		this.passwordError="";
		this.cpasswordError="";
		this.nameError="";
	}
		public String getErrorMsg() {
			return errorMsg;
		}
		public void setErrorMsg() {
			if (!userNameError.equals("") || !passwordError.equals("") || !cpasswordError.equals("") || !nameError.equals(""))
				errorMsg="Please correct the following errors";
			else
				errorMsg="";
		}
	
	
	public String getUserNameError() {
		return userNameError;
	}
	public void setUserNameError(String userNameError) {
		this.userNameError = userNameError;
	}
	public String getPasswordError() {
		return passwordError;
	}
	public void setPasswordError(String passwordError) {
		this.passwordError = passwordError;
	}
	public String getCpasswordError() {
		return cpasswordError;
	}
	public void setCpasswordError(String cpasswordError) {
		this.cpasswordError = cpasswordError;
	}
	public String getNameError() {
		return nameError;
	}
	public void setNameError(String nameError) {
		this.nameError = nameError;
	}
	
	
	
		
	}
	


=======
package Maverick_parking.model;

public class SystemUserErrorMsgs {
	private String errorMsg;
	private String userNameError;
	private String passwordError;
	private String cpasswordError;
	private String nameError;
	
	public SystemUserErrorMsgs(){
		this.userNameError="";
		this.passwordError="";
		this.cpasswordError="";
		this.nameError="";
	}
		public String getErrorMsg() {
			return errorMsg;
		}
		public void setErrorMsg() {
			if (!userNameError.equals("") || !passwordError.equals("") || !cpasswordError.equals("") || !nameError.equals(""))
				errorMsg="Please correct the following errors";
			else
				errorMsg="";
		}
	
	
	public String getUserNameError() {
		return userNameError;
	}
	public void setUserNameError(String userNameError) {
		this.userNameError = userNameError;
	}
	public String getPasswordError() {
		return passwordError;
	}
	public void setPasswordError(String passwordError) {
		this.passwordError = passwordError;
	}
	public String getCpasswordError() {
		return cpasswordError;
	}
	public void setCpasswordError(String cpasswordError) {
		this.cpasswordError = cpasswordError;
	}
	public String getNameError() {
		return nameError;
	}
	public void setNameError(String nameError) {
		this.nameError = nameError;
	}
	
	
	
		
	}
	


>>>>>>> 33b67b3d4164e7ba319bd54766d6748fb733209b

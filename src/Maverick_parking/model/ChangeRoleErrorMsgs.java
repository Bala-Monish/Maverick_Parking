package Maverick_parking.model;
import java.io.Serializable;

public class ChangeRoleErrorMsgs implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userNameError = "";
	private String roleTypeError = "";
	public String getUserNameError() {
		return userNameError;
	}
	public void setUserNameError(String userNameError) {
		this.userNameError = userNameError;
	}
	public String getRoleTypeError() {
		return roleTypeError;
	}
	public void setRoleTypeError(String roleTypeError) {
		this.roleTypeError = roleTypeError;
	}

	
}

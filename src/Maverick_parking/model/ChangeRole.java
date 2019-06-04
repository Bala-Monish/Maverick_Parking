package Maverick_parking.model;
import java.io.Serializable;
import java.sql.SQLException;

import Maverick_parking.data.ChangeRoleDAO;

public class ChangeRole implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName = "";
	private String roleType = "";
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRoleType() {
		return roleType;
	}
	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}
	public String validateFunction(String UserName,String Role ) throws SQLException{
		ChangeRole change = new ChangeRole();
		ChangeRoleErrorMsgs err = new ChangeRoleErrorMsgs();
		change.setUserName(UserName);
		change.setRoleType(Role);
		String act = "";
		err.setUserNameError(validate(UserName));
		if(err.getUserNameError().contentEquals(""))
		{
			checkRole(change,err);
			if(err.getRoleTypeError().contentEquals(""))
				return act;
			else
				return err.getRoleTypeError();
		}
		else
			return err.getUserNameError();
		
	}
	public String validate(String name) throws SQLException{
		String errmsg ="";
		if(!ChangeRoleDAO.exist(name))
		{
			errmsg = "The username does not exist";
		}
		
		return errmsg;
	}
	public void checkRole(ChangeRole change,ChangeRoleErrorMsgs change_error) throws SQLException{
		String errmsg ="";
		if(!ChangeRoleDAO.check(change))
		{
			errmsg = "The user already has that role";
		}
		change_error.setRoleTypeError(errmsg);
	}
}

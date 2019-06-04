<<<<<<< HEAD
package Maverick_parking.model;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Maverick_parking.data.SystemUserDAO;

public class SystemUser implements Serializable {

	private static final long serialVersionUID = 1L;
	private String userName;
	private String password;
	private String name;
	private String roleType;
	private String cpassword;
	
	public String getCpassword() {
		return cpassword;
	}
	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRoleType() {
		return roleType;
	}
	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}
	public void validateFunction(String uname,String pass,String cpass,String name,SystemUserErrorMsgs error){
		SystemUser user = new SystemUser();
		user.setCpassword(cpass);
		user.setName(name);
		user.setPassword(pass);
		user.setUserName(uname);
		validateUserName(user,error);
		validatePassword(user,error);
		validateCpassword(user,error);
		validateName(user,error);
	}
	public void validateUserName(SystemUser systemUser,SystemUserErrorMsgs errorMsgs){
		String res = "";
		String un = systemUser.getUserName();
		final String EMAIL_PATTERN = 
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(un);
		if(un.equals("")){
			res = "The User Name Field cannot be empty";
		}
		else if(un.length()<6){
			res = "The User Name must be at least 6 characters";
		}
		else if(un.length()>30){
			res = "The User Name cannot exceed 30 characters";
		}
		else if(!matcher.matches()){
			res = "Invalid User Name";
		}
		else if(SystemUserDAO.uniqueUserName(un)){
			res = "The User Name already Exists";
		}
		errorMsgs.setUserNameError(res);
		errorMsgs.setErrorMsg();
	}
	public void validatePassword(SystemUser systemUser,SystemUserErrorMsgs errorMsgs){
		String res="";
		String pass = systemUser.getPassword(); boolean sf = false;
		final String PASSWORD_PATTERN = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#!$%^_&+=])(?=\\S+$).{6,18}";
		Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
		Matcher matcher = pattern.matcher(pass);
		for(int i =0;i<pass.length();i++){
			if(pass.charAt(i)==' '){
				sf = true;
				break;
			}
		}
		if(pass.equals("")){
			res = "Password Field cannot be Empty";
		}
		else if(pass.length()<6){
			res = "Password length must be at least 6 characters";
		}
		else if(pass.length()>12){
			res = "Password length cannot exceed 12 characters";
		}
		else if(sf){
			res = "password cannot contain blank space character";
		}
		else if(!matcher.matches()){
			res = "Invalid password it must contain at least 1 digit 1 lc 1 uc 1 sc";
		}
		errorMsgs.setPasswordError(res);
		errorMsgs.setErrorMsg();
		
	}
	public void validateCpassword(SystemUser systemUser,SystemUserErrorMsgs errorMsgs){
		String res = "";
		String pass = systemUser.getPassword();
		String cpass = systemUser.getCpassword();
		if(cpass.equals("")){
			res = "confirm password field cannot be empty";
		}
		else if(!cpass.equals(pass)){
			res = "passwords do not match";
		}
		errorMsgs.setCpasswordError(res);
		errorMsgs.setErrorMsg();
	}
   public void validateName(SystemUser systemUser,SystemUserErrorMsgs errorMsgs){
	   String res = "";
	   String name = systemUser.getName();
	   boolean n = true;
	   char nameArr[] = name.toCharArray();
	   for(char c:nameArr){
		   if(!(Character.isLetter(c)||Character.isSpace(c))){
			   n = false;
			   break;
			  }
	   }
	   //String NAME_REGEX = "[A-Z]";
	   //Pattern pattern = Pattern.compile(NAME_REGEX);
	   //Matcher matcher = pattern.matcher(name);
	   if(name.equals("")){
		   res = "Name field cannot be empty";
	   }
	   else if(name.length()>50){
		   res = "Name Field cannot exceed 50 characters";
	   }
	   else if(!Character.isLetter(name.charAt(0))){
		   res = "First character must be a letter";
	   }
	   else if(!n){
		   res = "Name cannot have digits or special characters";
	   }
	   
	   errorMsgs.setNameError(res);
		errorMsgs.setErrorMsg();
   }

}
=======
package Maverick_parking.model;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Maverick_parking.data.SystemUserDAO;

public class SystemUser implements Serializable {

	private static final long serialVersionUID = 1L;
	private String userName;
	private String password;
	private String name;
	private String roleType;
	private String cpassword;
	
	public String getCpassword() {
		return cpassword;
	}
	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRoleType() {
		return roleType;
	}
	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}
	
	public void validateUserName(SystemUser systemUser,SystemUserErrorMsgs errorMsgs){
		String res = "";
		String un = systemUser.getUserName();
		final String EMAIL_PATTERN = 
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(un);
		if(un.equals("")){
			res = "The User Name Field cannot be empty";
		}
		else if(un.length()<6){
			res = "The User Name must be at least 6 characters";
		}
		else if(un.length()>30){
			res = "The User Name cannot exceed 30 characters";
		}
		else if(!matcher.matches()){
			res = "Invalid User Name";
		}
		else if(SystemUserDAO.uniqueUserName(un)){
			res = "The User Name already Exists";
		}
		errorMsgs.setUserNameError(res);
		errorMsgs.setErrorMsg();
	}
	public void validatePassword(SystemUser systemUser,SystemUserErrorMsgs errorMsgs){
		String res="";
		String pass = systemUser.getPassword(); boolean sf = false;
		final String PASSWORD_PATTERN = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#!$%^_&+=])(?=\\S+$).{6,18}";
		Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
		Matcher matcher = pattern.matcher(pass);
		for(int i =0;i<pass.length();i++){
			if(pass.charAt(i)==' '){
				sf = true;
				break;
			}
		}
		if(pass.equals("")){
			res = "Password Field cannot be Empty";
		}
		else if(pass.length()<6){
			res = "Password length must be at least 6 characters";
		}
		else if(pass.length()>12){
			res = "Password length cannot exceed 12 characters";
		}
		else if(sf){
			res = "password cannot contain blank space character";
		}
		else if(!matcher.matches()){
			res = "Invalid password, it must contain at least 1 digit, 1 lc, 1 uc, 1 sc";
		}
		errorMsgs.setPasswordError(res);
		errorMsgs.setErrorMsg();
		
	}
	public void validateCpassword(SystemUser systemUser,SystemUserErrorMsgs errorMsgs){
		String res = "";
		String pass = systemUser.getPassword();
		String cpass = systemUser.getCpassword();
		if(cpass.equals("")){
			res = "confirm password field cannot be empty";
		}
		else if(!cpass.equals(pass)){
			res = "passwords do not match";
		}
		errorMsgs.setCpasswordError(res);
		errorMsgs.setErrorMsg();
	}
   public void validateName(SystemUser systemUser,SystemUserErrorMsgs errorMsgs){
	   String res = "";
	   String name = systemUser.getName();
	   boolean n = true;
	   char nameArr[] = name.toCharArray();
	   for(char c:nameArr){
		   if(!(Character.isLetter(c)||Character.isSpace(c))){
			   n = false;
			   break;
			  }
	   }
	   //String NAME_REGEX = "[A-Z]";
	   //Pattern pattern = Pattern.compile(NAME_REGEX);
	   //Matcher matcher = pattern.matcher(name);
	   if(name.equals("")){
		   res = "Name field cannot be empty";
	   }
	   else if(name.length()>50){
		   res = "Name Field cannot exceed 50 characters";
	   }
	   else if(!Character.isLetter(name.charAt(0))){
		   res = "First character must be a letter";
	   }
	   else if(!n){
		   res = "Name cannot have digits or special characters";
	   }
	   
	   errorMsgs.setNameError(res);
		errorMsgs.setErrorMsg();
   }

}
>>>>>>> 33b67b3d4164e7ba319bd54766d6748fb733209b

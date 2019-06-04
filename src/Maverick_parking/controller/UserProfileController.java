package Maverick_parking.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Maverick_parking.data.UserProfileDAO;
import Maverick_parking.model.Login;
import Maverick_parking.model.UpdateProfileErrorMsgs;
import Maverick_parking.model.CreateUserProfile;
import Maverick_parking.model.CreateUserProfileErrorMsgs;
@WebServlet("/UserProfileController")
public class UserProfileController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserProfileController(){
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		CreateUserProfile user_profile = new CreateUserProfile();
		CreateUserProfileErrorMsgs createError = new CreateUserProfileErrorMsgs();
		Login pl = new Login();
		if(request.getParameter("btnRegister")!=null)
		
				{
					user_profile.setAddress(request.getParameter("address"));
					user_profile.setPhone(request.getParameter("phone"));
					user_profile.setCarLicense(request.getParameter("carLicense"));
					user_profile.setCreditCard(request.getParameter("creditCard"));
					user_profile.setPermitType(request.getParameter("permitType"));
					user_profile.setUtaId(request.getParameter("utaId"));
					user_profile.validateCarLicense(user_profile, createError);
					user_profile.validateCreditCard(user_profile, createError);
					user_profile.validatePhoneNumber(user_profile, createError);
					user_profile.validateUtaId(user_profile, createError);
					session.setAttribute("user_profile", user_profile);
					session.setAttribute("createError", createError);
					pl = (Login) session.getAttribute("login");
					if(createError.getErrorMsg().equals("")){
					try {
						UserProfileDAO.create(user_profile,pl);
					} catch (NoSuchFieldException | SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					session.removeAttribute("createError");
					getServletContext().getRequestDispatcher("/userHome.jsp").forward(request, response);
					}
					else{
						getServletContext().getRequestDispatcher("/createProfile.jsp").forward(request, response);
						session.removeAttribute("createError");
					}
					
				}
			
	}
}

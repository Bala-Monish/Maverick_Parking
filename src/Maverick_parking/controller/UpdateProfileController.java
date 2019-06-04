package Maverick_parking.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Maverick_parking.data.UpdateProfileDAO;
import Maverick_parking.model.Login;
import Maverick_parking.model.UpdateProfile;
import Maverick_parking.model.UpdateProfileErrorMsgs;
@WebServlet("/UpdateProfileController")
public class UpdateProfileController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UpdateProfileController(){
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		UpdateProfile user_profile = new UpdateProfile();
		UpdateProfileErrorMsgs updateError = new UpdateProfileErrorMsgs();
		Login un = new Login();
		un = (Login) session.getAttribute("login");
		if(request.getParameter("btnRegister")!=null)
			
		{
			user_profile.setAddress(request.getParameter("address"));
			user_profile.setPassword(request.getParameter("password"));
			user_profile.setPhone(request.getParameter("phone"));
			user_profile.setCarLicense(request.getParameter("carLicense"));
			user_profile.setCreditCard(request.getParameter("creditCard"));
			user_profile.setPermitType(request.getParameter("permitType"));
			user_profile.setUtaId(request.getParameter("utaId"));
			session.setAttribute("user_profile", user_profile);
			user_profile.validatePassword(user_profile, updateError);
			user_profile.validateCarLicense(user_profile, updateError);
			user_profile.validateCreditCard(user_profile, updateError);
			user_profile.validatePhoneNumber(user_profile, updateError);
			user_profile.validateUtaId(user_profile, updateError);
			un = (Login) session.getAttribute("login");
			session.setAttribute("updateError", updateError);
			if(updateError.getErrorMsg().equals("")){
			try {
				UpdateProfileDAO.create(user_profile,un);
			} catch (NoSuchFieldException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session.removeAttribute("updateError");
			getServletContext().getRequestDispatcher("/userProfileUpdateSuccess.jsp").forward(request, response);
			}
			else{
				getServletContext().getRequestDispatcher("/updateProfile.jsp").forward(request, response);
			}
			
		
}
}
}
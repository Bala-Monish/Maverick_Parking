package Maverick_parking.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Maverick_parking.data.SystemUserDAO;
import Maverick_parking.model.ActivateUser;

@WebServlet("/ActivateUserController")
public class ActivateUserController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ActivateUserController(){
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		//ActivateUser user = new ActivateUser();
		List<ActivateUser> users = new ArrayList<ActivateUser>();
		users = SystemUserDAO.getUsers();
		session.setAttribute("users", users);
		
		if(request.getParameter("modifyBtn") != null)
		{	String uname ="";
			uname = request.getParameter("userName");
			SystemUserDAO.changeStatus(uname);
			getServletContext().getRequestDispatcher("/adminHome.jsp").forward(request, response);
		}
		else{
			
		
		getServletContext().getRequestDispatcher("/activateUser.jsp").forward(request, response);

	}
	}
}

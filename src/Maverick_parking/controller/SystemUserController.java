<<<<<<< HEAD
package Maverick_parking.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Maverick_parking.data.SystemUserDAO;
import Maverick_parking.model.SystemUser;
import Maverick_parking.model.SystemUserErrorMsgs;

/**
 * Servlet implementation class SystemUserController
 */
@WebServlet("/SystemUserController")
public class SystemUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SystemUserController() {
    	super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		SystemUser systemUser = new SystemUser();
		if(request.getParameter("btnRegister")!=null){
		systemUser.setUserName(request.getParameter("userName"));
		SystemUserErrorMsgs errorMsgs = new SystemUserErrorMsgs();
		systemUser.validateUserName(systemUser, errorMsgs);
		systemUser.setPassword(request.getParameter("password"));
		systemUser.validatePassword(systemUser, errorMsgs);
		systemUser.setCpassword(request.getParameter("cpassword"));
		systemUser.validateCpassword(systemUser, errorMsgs);
		systemUser.setName(request.getParameter("name"));
		systemUser.validateName(systemUser, errorMsgs);
		systemUser.setRoleType(request.getParameter("roleType"));
		session.setAttribute("systemUser", systemUser);
		session.setAttribute("errorMsgs", errorMsgs);
		if(errorMsgs.getErrorMsg().equals("")){
		SystemUserDAO.insertUser(systemUser);
		session.removeAttribute("systemUser");
		session.removeAttribute("errorMsgs");
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		}
		else{
			
			getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
			session.removeAttribute("errorMsgs");
			
		}
		}
	}

}
=======
package Maverick_parking.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Maverick_parking.data.SystemUserDAO;
import Maverick_parking.model.SystemUser;
import Maverick_parking.model.SystemUserErrorMsgs;

/**
 * Servlet implementation class SystemUserController
 */
@WebServlet("/SystemUserController")
public class SystemUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SystemUserController() {
    	super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		SystemUser systemUser = new SystemUser();
		if(request.getParameter("btnRegister")!=null){
		systemUser.setUserName(request.getParameter("userName"));
		SystemUserErrorMsgs errorMsgs = new SystemUserErrorMsgs();
		systemUser.validateUserName(systemUser, errorMsgs);
		systemUser.setPassword(request.getParameter("password"));
		systemUser.validatePassword(systemUser, errorMsgs);
		systemUser.setCpassword(request.getParameter("cpassword"));
		systemUser.validateCpassword(systemUser, errorMsgs);
		systemUser.setName(request.getParameter("name"));
		systemUser.validateName(systemUser, errorMsgs);
		systemUser.setRoleType(request.getParameter("roleType"));
		session.setAttribute("systemUser", systemUser);
		session.setAttribute("errorMsgs", errorMsgs);
		if(errorMsgs.getErrorMsg().equals("")){
		SystemUserDAO.insertUser(systemUser);
		session.removeAttribute("systemUser");
		session.removeAttribute("errorMsgs");
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		}
		else{
			
			getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
			session.removeAttribute("errorMsgs");
			
		}
		}
	}

}
>>>>>>> 33b67b3d4164e7ba319bd54766d6748fb733209b

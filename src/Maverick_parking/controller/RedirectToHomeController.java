package Maverick_parking.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Maverick_parking.model.Login;

/**
 * Servlet implementation class RedirectToHomeController
 */
@WebServlet("/RedirectToHomeController")
public class RedirectToHomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RedirectToHomeController() {
        super();
        // TODO Auto-generated constructor stub
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
		session.removeAttribute("pr");
		session.removeAttribute("reservation");
		session.removeAttribute("parkdet");
		session.removeAttribute("user_search");
		session.removeAttribute("resersvationErrorMsgs");
		session.removeAttribute("modifyReservation");
		session.removeAttribute("updateReservation");
		session.removeAttribute("user_profile");
		session.removeAttribute("updateError");
		Login l = (Login) session.getAttribute("login");
		String roleType = l.getRoleType();
		if(roleType.equals("User"))
		getServletContext().getRequestDispatcher("/userHome.jsp").forward(request, response);
		else if(roleType.equals("Manager"))
			getServletContext().getRequestDispatcher("/managerHome.jsp").forward(request, response);
		else
			getServletContext().getRequestDispatcher("/adminHome.jsp").forward(request, response);
			
	}

}

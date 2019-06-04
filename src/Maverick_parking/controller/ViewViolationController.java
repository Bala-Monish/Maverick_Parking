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
import Maverick_parking.model.ViewViolation;
import Maverick_parking.data.SystemUserDAO;
import Maverick_parking.model.Login;
@WebServlet("/ViewViolationController")
public class ViewViolationController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ViewViolationController(){
		super();
	}
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
		Login un = new Login();
		un = (Login) session.getAttribute("login");
		List<ViewViolation> violation = new ArrayList<ViewViolation>();
		violation = SystemUserDAO.getViolation(un);
		session.setAttribute("violation", violation);
		getServletContext().getRequestDispatcher("/viewViolations.jsp").forward(request, response);
}
}
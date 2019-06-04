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
import Maverick_parking.data.ReservationDAO;
import Maverick_parking.model.Login;
import Maverick_parking.model.ViewReservation;

@WebServlet("/ViewReservationController")
public class ViewReservationController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ViewReservationController(){
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Login un = new Login();
		un = (Login) session.getAttribute("login");
		List<ViewReservation> res_det = new ArrayList<ViewReservation>();
		res_det = ReservationDAO.viewReservation(un);
		session.setAttribute("res_det", res_det);
		getServletContext().getRequestDispatcher("/viewReservation.jsp").forward(request, response);
	}
	
}

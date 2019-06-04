package Maverick_parking.controller;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Maverick_parking.data.AccountStatusDAO;
import Maverick_parking.model.Login;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;


@WebServlet("/AccountStatusController")
public class AccountStatusController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public AccountStatusController(){
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
		try {
			String status = AccountStatusDAO.userStatus(un);
			session.setAttribute("status", status);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher("/accountStatus.jsp").forward(request, response);
	}
}

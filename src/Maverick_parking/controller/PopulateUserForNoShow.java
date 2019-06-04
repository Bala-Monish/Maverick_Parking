package Maverick_parking.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Maverick_parking.data.SystemUserDAO;
import Maverick_parking.model.UpdateProfile;

/**
 * Servlet implementation class PopulateUserForNoShow
 */
@WebServlet("/PopulateUserForNoShow")
public class PopulateUserForNoShow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PopulateUserForNoShow() {
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
		//Login login = (Login) session.getAttribute("login");
		List<String> l = SystemUserDAO.getUsersForAdmitEdit();
		session.setAttribute("l", l);
		getServletContext().getRequestDispatcher("/populateUserForNoShow.jsp").forward(request, response);
		
	}

}

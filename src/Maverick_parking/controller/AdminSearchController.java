
package Maverick_parking.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Maverick_parking.data.AdminSearchDAO;
import Maverick_parking.model.AdminSearch;
import Maverick_parking.model.AdminSearchErrorMsgs;
import Maverick_parking.model.AdminSearchResults;
import Maverick_parking.model.Login;


@WebServlet("/AdminSearchController")
public class AdminSearchController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
public AdminSearchController()
{
	super();
	
}
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	doPost(request,response);
}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	HttpSession session = request.getSession();
	AdminSearch adminSearch = new AdminSearch();
    
	AdminSearchErrorMsgs adminErrorMsgs = new AdminSearchErrorMsgs();
	if(request.getParameter("btnSearch")!=null)
		try {
			{
				adminSearch.setUname(request.getParameter("uname"));
				session.setAttribute("adminSearch", adminSearch);
				session.setAttribute("adminErrorMsgs",adminErrorMsgs);
				List<AdminSearchResults> user_det = new ArrayList<AdminSearchResults>();
				String exist = adminSearch.validate(adminSearch.getUname());
				adminErrorMsgs.setUserNameError(exist);
				if(adminErrorMsgs.getUserNameError().equals("")){
				user_det = AdminSearchDAO.searchUser(adminSearch);
				session.removeAttribute("adminSearch");
				session.setAttribute("userdet", user_det);
				getServletContext().getRequestDispatcher("/adminSearchResults.jsp").forward(request, response);
				}
				else{
					
					getServletContext().getRequestDispatcher("/adminSearch.jsp").forward(request, response);
					session.removeAttribute("adminErrorMsgs");
					
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
=======
package Maverick_parking.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Maverick_parking.data.AdminSearchDAO;
import Maverick_parking.model.AdminSearch;
import Maverick_parking.model.AdminSearchErrorMsgs;
import Maverick_parking.model.AdminSearchResults;


@WebServlet("/AdminSearchController")
public class AdminSearchController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
public AdminSearchController()
{
	super();
	
}
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	doPost(request,response);
}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	HttpSession session = request.getSession();
	AdminSearch adminSearch = new AdminSearch();
	AdminSearchErrorMsgs adminErrorMsgs = new AdminSearchErrorMsgs();
	if(request.getParameter("btnSearch")!=null)
		try {
			{
				adminSearch.setUname(request.getParameter("uname"));
				session.setAttribute("adminSearch", adminSearch);
				session.setAttribute("adminErrorMsgs",adminErrorMsgs);
				List<AdminSearchResults> user_det = new ArrayList<AdminSearchResults>();
				adminSearch.validate(adminSearch, adminErrorMsgs);
				if(adminErrorMsgs.getUserNameError().equals("")){
				user_det = AdminSearchDAO.searchUser(adminSearch);
				session.removeAttribute("adminSearch");
				session.setAttribute("userdet", user_det);
				getServletContext().getRequestDispatcher("/adminSearchResults.jsp").forward(request, response);
				}
				else{
					
					getServletContext().getRequestDispatcher("/adminSearch.jsp").forward(request, response);
					session.removeAttribute("adminErrorMsgs");
					
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}

}
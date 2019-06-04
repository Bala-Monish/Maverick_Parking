<<<<<<< HEAD
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
import Maverick_parking.data.ManagerSearchDAO;
import Maverick_parking.model.ManagerSearch;
import Maverick_parking.model.ManagerSearchErrorMsgs;
import Maverick_parking.model.SearchResults;


@WebServlet("/ManagerSearchController")
public class ManagerSearchController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
public ManagerSearchController()
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
	ManagerSearch managerSearch = new ManagerSearch();
	String  search = "";
	if(request.getParameter("btnSearch")!=null) {
		managerSearch.setUname(request.getParameter("uname"));
		session.setAttribute("managerSearch", managerSearch);
		List<SearchResults> user_det = new ArrayList<SearchResults>();
		ManagerSearchErrorMsgs managerError = new ManagerSearchErrorMsgs();
		session.setAttribute("managerError", managerError);
		try {
		search =	managerSearch.validate(managerSearch.getUname());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		managerError.setUserNameError(search);
		if(managerError.getUserNameError().equals("")){
		user_det = ManagerSearchDAO.searchUser(managerSearch);
		session.removeAttribute("managerSearch");
		session.setAttribute("userdet", user_det);
		getServletContext().getRequestDispatcher("/managerSearchResults.jsp").forward(request, response);
		
		}
		else{
			getServletContext().getRequestDispatcher("/managerSearch.jsp").forward(request, response);
			session.removeAttribute("managerError");
		}
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
import Maverick_parking.data.ManagerSearchDAO;
import Maverick_parking.model.ManagerSearch;
import Maverick_parking.model.ManagerSearchErrorMsgs;
import Maverick_parking.model.SearchResults;


@WebServlet("/ManagerSearchController")
public class ManagerSearchController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
public ManagerSearchController()
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
	ManagerSearch managerSearch = new ManagerSearch();
	if(request.getParameter("btnSearch")!=null) {
		managerSearch.setUname(request.getParameter("uname"));
		session.setAttribute("managerSearch", managerSearch);
		List<SearchResults> user_det = new ArrayList<SearchResults>();
		ManagerSearchErrorMsgs managerError = new ManagerSearchErrorMsgs();
		session.setAttribute("managerError", managerError);
		try {
			managerSearch.validate(managerSearch, managerError);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(managerError.getUserNameError().equals("")){
		user_det = ManagerSearchDAO.searchUser(managerSearch);
		getServletContext().getRequestDispatcher("/managerSearchResults.jsp").forward(request, response);
		session.removeAttribute("managerSearch");
		session.setAttribute("userdet", user_det);
		}
		else{
			getServletContext().getRequestDispatcher("/managerSearch.jsp").forward(request, response);
			session.removeAttribute("managerError");
		}
	}
}
>>>>>>> 33b67b3d4164e7ba319bd54766d6748fb733209b
}
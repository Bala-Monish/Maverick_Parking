package Maverick_parking.controller;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Maverick_parking.data.ChangeRoleDAO;
import Maverick_parking.model.ChangeRole;
import Maverick_parking.model.ChangeRoleErrorMsgs;

@WebServlet("/ChangeRoleController")
public class ChangeRoleController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ChangeRoleController(){
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		ChangeRole change_role = new ChangeRole();
		ChangeRoleErrorMsgs change_err = new ChangeRoleErrorMsgs();
		
		
		if(request.getParameter("btnChange")!=null){
			change_role.setUserName(request.getParameter("searchUname"));
			change_role.setRoleType(request.getParameter("roleType"));
		}
		String uerror = "";
		try {
		uerror = 	change_role.validate(change_role.getUserName());
		if(uerror.contentEquals(""))
		{
			change_role.checkRole(change_role, change_err);
		}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		change_err.setUserNameError(uerror);
		session.setAttribute("change_err", change_err);
		if(change_err.getUserNameError().equals("")&&change_err.getRoleTypeError().equals(""))
		{
		try {
			ChangeRoleDAO.change(change_role);
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		session.removeAttribute("change_err");
		getServletContext().getRequestDispatcher("/changeRole.jsp").forward(request, response);
		
		}
		else{
			getServletContext().getRequestDispatcher("/changeRole.jsp").forward(request, response);
			session.removeAttribute("change_err");
		}
}
}
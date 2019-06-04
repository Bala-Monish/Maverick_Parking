package Maverick_parking.controller;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import Maverick_parking.data.ViewProfileDAO;
import Maverick_parking.model.Login;
import Maverick_parking.model.ViewProfile;;

@WebServlet("/ViewProfileController")
public class ViewProfileController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public ViewProfileController(){
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		ViewProfile user_profile = new ViewProfile();
		Login un = new Login();
		un = (Login) session.getAttribute("login");
		List<ViewProfile> prof_det = new ArrayList<ViewProfile>();
		try {
			prof_det = ViewProfileDAO.userDetails(un);
			session.setAttribute("prof_det", prof_det);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher("/viewProfile.jsp").forward(request, response);
}
}
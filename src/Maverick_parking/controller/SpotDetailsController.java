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

import Maverick_parking.data.SpotDetailsDAO;
import Maverick_parking.model.SpotDetails;
import Maverick_parking.model.SpotDetailsErrorMsgs;

/**
 * Servlet implementation class ManagerSpotController
 */
@WebServlet("/SpotDetailsController")
public class SpotDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SpotDetailsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session =  request.getSession();
		SpotDetails spotDetails = new SpotDetails();
		List<SpotDetails> spotinfo = new ArrayList<SpotDetails>();
		if(request.getParameter("btnSearch")!=null) {
			String spot_ID = request.getParameter("spotID");
			int spot = Integer.parseInt(spot_ID);
			spotDetails.setSpot_id(spot);
			session.setAttribute("spotDetails", spotDetails);
			SpotDetailsErrorMsgs error = new SpotDetailsErrorMsgs();
			session.setAttribute("spotIDerror", error);
			try{
				spotDetails.validate(spotDetails,error);
			}catch(Exception e){
				e.printStackTrace();
			}
			
			if(error.getSpotDetailerror().equals("")){
				spotinfo= SpotDetailsDAO.getSpotDetails(spotDetails);
				//session.removeAttribute("spotDetails");
				session.setAttribute("spotinfo", spotinfo);
				getServletContext().getRequestDispatcher("/spotSearchResults.jsp").forward(request, response);
			}else{
				getServletContext().getRequestDispatcher("/spotDetails.jsp").forward(request, response);
				session.removeAttribute("spotIDerror");
			}
		}
		
	}

}

package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import beans.PainTrack;
import dao.DAOFactory;
import dao.PainTrackDAO;
import dao.user;

/**
 * Servlet implementation class liste_pain
 */
public class liste_pain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public liste_pain() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		
		 user user_1 = (user) session.getAttribute("user");
		 
		 int id = user_1.getId() ;
		
		PainTrack pain = new PainTrack() ;
		
		PainTrackDAO p_dao = new PainTrackDAO(DAOFactory.getInstance()) ;
		
		List<PainTrack> pain_ = new ArrayList<>();
		
		List<Integer> li = new ArrayList<>();
		
		pain_ = p_dao.pain_level(id) ;
		
		if(pain_ != null) {
			
			for (PainTrack p : pain_) {
	            
			  li.add(p.getPainLevel())	 ;
			}	
	    }else {
	    	
	    	li =null ;
	    	
	    	li.add(-5) ;
	    }
			
			
		    String responseString = li.toString();
		    
		    System.out.println(responseString) ;

		    // Configurer la réponse HTTP
		    response.setContentType("text/plain");
		    response.setCharacterEncoding("UTF-8");

		    // Écrire la chaîne dans la réponse
		    response.getWriter().write(responseString);
	
			
		}
		
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}

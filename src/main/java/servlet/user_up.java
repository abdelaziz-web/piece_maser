package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import dao.DAOFactory;
import dao.user;
import dao.user_impl;

/**
 * Servlet implementation class user_up
 */
public class user_up extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public user_up() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		user user_1 = auth_user(request , response) ;
		
		request.setAttribute("user", user_1);
		
		this.getServletContext().getRequestDispatcher("/up_user.jsp").forward( request, response );
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
	}

	
	private user auth_user(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // Le code de votre nouvelle méthode
		
		 HttpSession session = request.getSession(false) ;
		
		if (session == null ) {
			
			this.getServletContext().getRequestDispatcher("/login.jsp").forward( request, response );
			
			return null ;
			
		}else {
			
			user user_1 = (user) session.getAttribute("user") ;
			
			return user_1 ;
			
		}
		
		
	}
	
	
	
}

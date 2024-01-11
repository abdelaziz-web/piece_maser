package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import beans.diagno;
import dao.DAOFactory;
import dao.diagno_impl;
import dao.user;

/**
 * Servlet implementation class acceuil
 */
public class acceuil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public acceuil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		 HttpSession session = request.getSession();
		
		 user user_1 = (user) session.getAttribute("user");
		 
		 request.setAttribute("user", user_1) ;
		 
		 diagno diag = new diagno() ;
		 
		 diagno_impl d_impl = new diagno_impl(DAOFactory.getInstance()) ;
		 
		   diag = d_impl.last_score(user_1.getId()) ;
		   
		   request.setAttribute("diag", diag) ;
		
		this.getServletContext().getRequestDispatcher("/ac.jsp").forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

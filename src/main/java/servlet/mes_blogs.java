package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import dao.DAOFactory;
import dao.blog;
import dao.blog_impl;
import dao.user;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class mes_blogs
 */
public class mes_blogs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mes_blogs() {
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
		
		blog_impl blog_imp = new blog_impl(DAOFactory.getInstance()) ;
		
		List<blog> liste   = blog_imp.blog_by_id(id) ;
		
		request.setAttribute("liste", liste);
		
		this.getServletContext().getRequestDispatcher("/Mesblogs_crud.jsp").forward( request, response );
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
	}

}

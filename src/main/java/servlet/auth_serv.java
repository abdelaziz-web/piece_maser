package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import dao.DAOFactory;
import dao.blog;
import dao.blog_impl;
import dao.user;
import dao.user_impl;


/**
 * Servlet implementation class auth_serv
 */
public class auth_serv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public auth_serv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);

        // Si une session existe
        if (session != null) {
            // Invalider la session (la déconnecter)
            session.invalidate();
        }

        // Rediriger vers la page de connexion ou une autre page de votre choix
        response.sendRedirect("login.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		user_impl  user_imp = new user_impl(DAOFactory.getInstance()) ;
		user user_1  = new user();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        user_1 = user_imp.find(email, password);
        
      
        if(user_1 == null) {
        	
        	            request.setAttribute("valide","email or password is wrong ");
        	
        	             this.getServletContext().
                         getRequestDispatcher("/login.jsp")
                         .forward( request, response );
        }
        else {
            HttpSession session = request.getSession(true);
            
            if(user_1.getPhoto() != null) {
            
            String encodedPhoto_1 = URLEncoder.encode(user_1.getPhoto(), StandardCharsets.UTF_8.toString());
            
            user_1.setPhoto(encodedPhoto_1);
            }
            session.setAttribute("user", user_1);
            blog blog_1 = new blog() ; 
            blog_impl blog_im = new blog_impl(DAOFactory.getInstance()) ;
            List<blog> listeDeBlogs = new ArrayList<>();
            listeDeBlogs = blog_im.getall() ;
            request.setAttribute("list", listeDeBlogs); 
            
            if(listeDeBlogs != null ) {
                
        		for (int i = 0; i < listeDeBlogs.size(); i++) {
        	        blog b_i = listeDeBlogs.get(i);
        	        System.out.println("Avant encodage - ID : " + b_i.getBlog_id());
        	        String encodedPhoto = URLEncoder.encode(b_i.getPhoto(), StandardCharsets.UTF_8.toString());
        	        b_i.setPhoto(encodedPhoto);
        	        listeDeBlogs.set(i, b_i);  // Mettez à jour l'objet dans la liste
        	    }       
        	
        }
        
       
        
            
            this.getServletContext().getRequestDispatcher("/blog.jsp").forward( request, response );
        }
	
		
		
	}

}

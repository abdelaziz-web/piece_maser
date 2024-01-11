package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import dao.DAOFactory;
import dao.user;
import dao.user_impl;

/**
 * Servlet implementation class profile_servlet
 */
public class profile_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 public static final String CHEMIN_FICHIER = "C:\\Users\\hp\\Desktop\\bb\\" ;
	 public static final int TAILLE_TAMPON = 10240 ;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public profile_servlet() {
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
		
		this.getServletContext().getRequestDispatcher("/profile.jsp").forward( request, response );
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		String username = request.getParameter("username");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String dateOfBirth = request.getParameter("date");
        String phoneNumber = request.getParameter("phoneNumber");
        String newPassword = request.getParameter("newPassword");
        String repeatNewPassword = request.getParameter("repeatNewPassword");

        // Perform any processing or validation as needed

        // For demonstration purposes, you can print the values to the console
        System.out.println("id: " + id);
        System.out.println("Username: " + username);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Date of Birth: " + dateOfBirth);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("New Password: " + newPassword);
        System.out.println("Repeat New Password: " + repeatNewPassword);
        
        
        
        
        
        
      
        int i = 0 ;
        
        if (newPassword == null || newPassword.trim().isEmpty() || repeatNewPassword == null || repeatNewPassword.trim().isEmpty()) {
            i=1 ;
           
        } else {
            // Vérifier si les mots de passe sont égaux
            if (newPassword.equals(repeatNewPassword)) {
               
            } else {
               i=1 ; 
            }
        }
        
        
        if(i==1) {
        	
        String message = "mot de passe non valide " ;	
        
        request.setAttribute("message", message) ;
        
        this.getServletContext().getRequestDispatcher("/profile.jsp").forward( request, response );
        	
        }else {
        	
        	String fileName ;
        	
        	Part filePart = request.getPart("plan");
            
            // Vérifier si un fichier a été envoyé
            if (filePart != null && filePart.getSize() > 0) {
            	
             fileName = getFileName(filePart);
             
             ecrire_fichier(filePart,fileName,CHEMIN_FICHIER) ;
             
             fileName = fileName + CHEMIN_FICHIER ;
             
            }else {
            	
            	 fileName = null ;
            }
           
           
        	
        user user_1 = new user(id,name,email,newPassword,phoneNumber,dateOfBirth,fileName,username)	 ;
           
        user_impl u_im = new user_impl(DAOFactory.getInstance()) ;        
        
        
        u_im.update(user_1);
        
        String message_1 = "Votre profil est bien été modifié " ;
        
        request.setAttribute("message_1", message_1) ;
        
        this.getServletContext().getRequestDispatcher("/profile.jsp").forward( request, response );
       
        }
        
        
        
        
	}   
        
        
	private void ecrire_fichier(Part part ,String fileName,String chemin_final)throws IOException {
		
		BufferedInputStream entre = null ;
		BufferedOutputStream sortie  =null;
		
		String fullPath = CHEMIN_FICHIER+fileName  ;
		
		try {
			entre = new BufferedInputStream(part.getInputStream(), TAILLE_TAMPON ) ;
			sortie = new BufferedOutputStream(new FileOutputStream(fullPath ),TAILLE_TAMPON) ;
			
			
			byte[] tampan = new byte[TAILLE_TAMPON];
			int longueur ;
			while( (longueur = entre.read(tampan)) > 0 ) {
				sortie.write(tampan, 0, longueur);
				
			}
			
		}finally {
			try {
				sortie.close() ;
			}catch(IOException ignore) {
				
			}
			try	{
				entre.close() ;
			}catch(IOException ignore) {					
				
			}
			
			
		}
		
	   
	}

	private String getFileName(final Part part) {
	    final String partHeader = part.getHeader("content-disposition");
	    for (String content : partHeader.split(";")) {
	      if (content.trim().startsWith("filename")) {
	          return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
	      }
	  }
	   return null;
	 } 
        
        
        
		
	}



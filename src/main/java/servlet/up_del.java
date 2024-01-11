package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

import org.apache.tomcat.util.http.fileupload.FileItem;

import dao.DAOFactory;
import dao.blog;
import dao.blog_impl;

/**
 * Servlet implementation class up_del
 */
@MultipartConfig
public class up_del extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	public static final int TAILLE_TAMPON = 10240 ;
    public static final String CHEMIN_FICHIER = "C:\\Users\\hp\\Desktop\\aa\\" ;   
    /**
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public up_del() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String entier= request.getParameter("id");
		   
		int id = Integer.parseInt(entier);
		
		if(request.getParameter("type").equals("del") ) {
		
        blog_impl blog_imp = new blog_impl(DAOFactory.getInstance()) ;
		
		blog_imp.delete(id);
		
		response.sendRedirect("mes_blogs");}
		 
		 else {

         request.setAttribute("id", id) ; 
         
         this.getServletContext().getRequestDispatcher("/update_blog.jsp").forward( request, response );
			 
		 }
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String titre = request.getParameter("titre");
        String description = request.getParameter("description");
       
        int     id      = Integer.parseInt( request.getParameter("blog_id"));
        
     
  
        Part filePart = request.getPart("plan");
   
        String fileName = getFileName(filePart);;
      //  private String getFileName(final Part part) {

        
        blog blog_1=  new blog( id,  titre,   description,  CHEMIN_FICHIER+fileName) ;
       	        
        blog_impl blog_im = new blog_impl(DAOFactory.getInstance()) ;
        
        blog_im.update(blog_1);
        
        ecrire_fichier(filePart,fileName,CHEMIN_FICHIER) ;
        
       request.setAttribute("message", "l'élement a bien éte modifié") ;
       
       request.setAttribute("id", id) ; 
        
       this.getServletContext().getRequestDispatcher("/update_blog.jsp").forward( request, response ); 
	
	
		
		
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
	

public static String generateRandomName(int NAME_LENGTH) {
    Random random = new Random();
    String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < NAME_LENGTH; i++) {
        int index = random.nextInt(ALPHABET.length());
        char randomChar = ALPHABET.charAt(index);
        sb.append(randomChar);
    }

 return sb.toString();
 
 
}
}
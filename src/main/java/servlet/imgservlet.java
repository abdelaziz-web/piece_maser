package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * Servlet implementation class imgservlet
 */
public class imgservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public imgservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	//	String imagePath = "C:\\Users\\hp\\Desktop\\Website-template-design-1\\paincare.png";
		
	//	String encoded = URLEncoder.encode(imagePath, StandardCharsets.UTF_8.toString());
		
		String imagePath = request.getParameter("id") ;
		
	//	int b =20 ;
		
	//	 String b = URLDecoder.decode(encoded, StandardCharsets.UTF_8);
		
	//	System.out.println(a) ;
		
	//	System.out.println(encoded) ;
		
		System.out.println(imagePath) ;


		
	//	System.out.println(imagePath) ;	

        // Ouvrez un flux d'entrée depuis le fichier
        try (InputStream in = new FileInputStream(imagePath)) {
            if (in != null) {
                // Configurez le type de contenu de la réponse
                response.setContentType(getServletContext().getMimeType(imagePath));

                // Copiez le flux d'entrée de l'image dans le flux de sortie de la réponse
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = in.read(buffer)) != -1) {
                    response.getOutputStream().write(buffer, 0, bytesRead);
                }
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
            }
        } 
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

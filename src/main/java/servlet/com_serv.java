package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import dao.DAOFactory;
import dao.blog;
import dao.blog_impl;
import dao.com;
import dao.com_impl;
import dao.user;
import dao.user_impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Servlet implementation class com_serv
 */
public class com_serv extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String com_serv;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public com_serv() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		int id_blog  = Integer.parseInt(request.getParameter("id_blog"));
		
		// PrintWriter out = response.getWriter();

        // Utilisez l'objet PrintWriter pour écrire du contenu dans la réponse
       // out.println("Hello, World!"+id_blog);

        // Assurez-vous de fermer le PrintWriter après utilisation
      //  out.close();
	 
		 HttpSession session = request.getSession();

	        // Exemple d'utilisation de la session
	     user user_ =  (user) session.getAttribute("user");
	     
	     request.setAttribute("user", user_) ;
		
		 com com_1 = new com();
		 
		 user author = new user();
		 
		 List<user> userList = new ArrayList<>(); 
		 
		 user_impl user_imp = new user_impl(DAOFactory.getInstance()) ;
		 
		 com_impl com_imp = new com_impl(DAOFactory.getInstance()) ;
		 
		 List<com> comList = com_imp.getAll(id_blog);
		 
		 
		 

		 for (int i = 0; i < comList.size(); i++) {
			  
			    int author_id = comList.get(i).getAuthorId();
			    author = user_imp.user_id(author_id);
			    userList.add(author) ;
			}
		
		 blog blog_1 = new blog() ;
		 
		 blog_impl blog_imp = new blog_impl(DAOFactory.getInstance()) ;
		 
		 blog_1 =  blog_imp.blog_id(id_blog) ;
		 
		
	        String encodedPhoto = URLEncoder.encode(blog_1.getPhoto(), StandardCharsets.UTF_8.toString());
	        blog_1.setPhoto(encodedPhoto);
	        
		 
		 request.setAttribute("blog", blog_1) ;
		 
    	 request.setAttribute("list_com", comList) ;
    	 
    	 request.setAttribute("users", userList) ;
		 
		 this.getServletContext()
		 .getRequestDispatcher("/coment.jsp")
		 .forward( request, response );
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		BufferedReader reader = request.getReader();
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }

        // Contenu du corps de la requête (données JSON)
        String donneesJson = stringBuilder.toString();
        //System.out.println("Données JSON reçues : " + donneesJson);
        
        donneesJson = donneesJson.trim();

     // Extraire la partie JSON de la chaîne
     int debutJson = donneesJson.indexOf('[');
     int finJson = donneesJson.lastIndexOf(']');
     String jsonPart = donneesJson.substring(debutJson + 1, finJson);

     // Diviser la chaîne en éléments du tableau
     String[] elements = jsonPart.split(",");
     
     // Extraire les valeurs
     String content_com = elements[0].replaceAll("\"", "").trim();
     int blog_id = Integer.parseInt(elements[1].replaceAll("\"", "").trim());
     int author_id = Integer.parseInt(elements[2].replaceAll("\"", "").trim());
     

     
    com com_1 = new com(blog_id,content_com,author_id);
     
   //  System.out.println(com_1.getAuthorId());
     
   //  System.out.println(com_1.getContent());
     
     
        
     com_impl com_imp = new com_impl(DAOFactory.getInstance()) ;  

    com_imp.create(com_1) ;

     System.out.println(com_1.getContent());	
     
     
	}
	
	
	private static Object[] deserialiserTableau(String json) {
        // Retirer les crochets carrés
        String contenuJson = json.substring(1, json.length() - 1);

        // Diviser la chaîne en éléments
        String[] elements = contenuJson.split(",");

        // Désérialiser chaque élément
        Object[] resultat = new Object[elements.length];
        for (int i = 0; i < elements.length; i++) {
            String element = elements[i].trim();

            if (element.startsWith("\"") && element.endsWith("\"")) {
                // C'est une chaîne, retirer les guillemets
                resultat[i] = element.substring(1, element.length() - 1);
            } else {
                // C'est un nombre, convertir en entier
                resultat[i] = Integer.parseInt(element);
            }
        }

        return resultat;
    }
	
	

}

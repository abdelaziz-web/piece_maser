package servlet;

import jakarta.servlet.ServletException;
import beans.PainTrack;
import beans.QuizQuestion;
import dao.DAOFactory;
import dao.PainTrackDAO;
import dao.user;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Servlet implementation class paint_track
 */
public class paint_track extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public paint_track() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<QuizQuestion> quizQuestions = new ArrayList<>();
		
		quizQuestions  = createStaticQuiz() ;

		String dataString_1 = quizQuestions.stream()
		        .map(question -> question.getText() + "+" + String.join("+", question.getOptions()))
		        .collect(Collectors.joining("*"));

		// Affichez la chaîne de données dans la console
		System.out.println(dataString_1);

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		 HttpSession session = request.getSession();
		
		 user user_1 = (user) session.getAttribute("user");
		 
		 int id = user_1.getId() ;
		
		
		String[] painLocations = request.getParameterValues("painLocation");
		
		String degre = request.getParameter("degre");
		
		System.out.println("Pain Location: " + degre) ;
		
		 List<String> opt = new ArrayList<>();
		
        if (painLocations != null) {
            for (String location : painLocations) {
                opt.add(location) ;
            }
        }
        
        


        // Récupérer les paramètres pour le groupe Symptoms
        String[] symptoms = request.getParameterValues("symptoms");
        if (symptoms != null) {
            for (String symptom : symptoms) {
                opt.add(symptom) ;
            }
        }
         
        // Récupérer les paramètres pour le groupe What makes Pain worse?
        String[] worseFactors = request.getParameterValues("worseFactors");
        if (worseFactors != null) {
            for (String factor : worseFactors) {
                opt.add(factor) ;
            }
        }
        
   
        // Récupérer les paramètres pour le groupe Feelings
        String[] feelings = request.getParameterValues("feelings");
        if (feelings != null) {
            for (String feeling : feelings) {
                opt.add(feeling)  ;
            }
        }
        
        
          String location_1 ="";
        if (opt != null) {
            for (String location : opt) {
            	
            	location_1 =location_1 + "+"+location ; 
                
            }
        } 
        
   

       
       PainTrack pain = new PainTrack(location_1,Integer.parseInt(degre),id); 
       
       PainTrackDAO pdao = new PainTrackDAO(DAOFactory.getInstance()) ;
        
        pdao.create(pain) ;
        
        	

        
        String message= "Nous avons enregistrer votre diagnostique" ;
        
        
        
        request.setAttribute("message", message) ;
        
        this.getServletContext().getRequestDispatcher("/main.jsp").forward( request, response );
        
        
	}

	
	
	
	
	private List<QuizQuestion> createStaticQuiz() {
        List<QuizQuestion> quizQuestions = new ArrayList<>();

        // Première question
        List<String> options1 = List.of("Option 1", "Option 2", "Option 3");
        quizQuestions.add(new QuizQuestion("Quelle est la capitale de la France?", options1));

        // Deuxième question
        List<String> options2 = List.of("Option A", "Option B", "Option C");
        quizQuestions.add(new QuizQuestion("Quel est le plus grand océan du monde?", options2));

        // Ajoutez d'autres questions ici...

        return quizQuestions;
    }
	
}
	
	


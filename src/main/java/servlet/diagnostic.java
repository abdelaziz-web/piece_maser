package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.text.DecimalFormat;

import beans.diagno;
import dao.DAOFactory;
import dao.diagno_impl;
import dao.user;

/**
 * Servlet implementation class diagnostic
 */
public class diagnostic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public diagnostic() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		this.getServletContext().getRequestDispatcher("/main_2.jsp").forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("------------------------------------------------------");
		
		// Récupération 
		
		String question1Value = request.getParameter("1");
	    String question2Value = request.getParameter("2");
	    String question3Value = request.getParameter("3");
	    String question4Value = request.getParameter("4");
	    String question5Value = request.getParameter("5");
	    String kgValue_1 = request.getParameter("Kg");
	    String cmValue_1 = request.getParameter("cm");
	    String question6Value = request.getParameter("6");
	    String question7Value = request.getParameter("7");
	    String question8Value = request.getParameter("8");
	    String question9Value = request.getParameter("9");
	    String question10Value = request.getParameter("10");
	    String question11Value = request.getParameter("11");
	    String question12Value = request.getParameter("12");
	    String question13Value = request.getParameter("13");
	    String question14Value = request.getParameter("14");
 
	    float kgValue = Float.parseFloat(kgValue_1);
	    
	    float cmValue = Float.parseFloat(cmValue_1);
	    
	    HttpSession session = request.getSession();
	    
	    String scoreString = (String) session.getAttribute("score");
	    
	    scoreString = scoreString.replaceAll("[^0-9.]", "");
	    
	    float scoreFloat = Float.parseFloat(scoreString);

	    // Limiter à deux chiffres après la virgule
	    DecimalFormat decimalFormat = new DecimalFormat("#.##");
	    String formattedScore = decimalFormat.format(scoreFloat);
	    
	    formattedScore = formattedScore.replace(",", ".");
	    
	    float scoreFloat_1 = Float.parseFloat(formattedScore); 

	    
	    user user_1 = (user) session.getAttribute("user") ;

	    
	    // affichage
	    
	    System.out.println("Question 1: " + question1Value);
	    System.out.println("Question 2: " + question2Value);
	    System.out.println("Question 3: " + question3Value);
	    System.out.println("Question 4: " + question4Value);
	    System.out.println("Question 5: " + question5Value);
	    System.out.println("Kg: " + kgValue);
	    System.out.println("cm: " + cmValue);
	    System.out.println("Question 6: " + question6Value);
	    System.out.println("Question 7: " + question7Value);
	    System.out.println("Question 8: " + question8Value);
	    System.out.println("Question 9: " + question9Value);
	    System.out.println("Question 10: " + question10Value);
	    System.out.println("Question 11: " + question11Value);
	    System.out.println("Question 12: " + question12Value);
	    System.out.println("Question 13: " + question13Value);
	    System.out.println("Question 14: " + question14Value);
		
	    
	    
	    StringBuilder result = new StringBuilder();
        result.append(question1Value).append("+");
	    result.append(question2Value).append("+");
	    result.append(question3Value).append("+");
	    result.append(question4Value).append("+");
	    result.append(question5Value).append("+");
	   // result.append("Kg: ").append(kgValue).append("\n");
	   // result.append("cm: ").append(cmValue).append("\n");
	    result.append(question6Value).append("+");
	    result.append(question7Value).append("+");
	    result.append(question8Value).append("+");
	    result.append(question9Value).append("+");
	    result.append(question10Value).append("+");
	    result.append(question11Value).append("+");
	    result.append(question12Value).append("+");
	    result.append(question13Value).append("+");
	    result.append(question14Value);

	    // Imprimer la chaîne résultante dans la console
	    String diag = removeNull(result.toString()) ;
	    
	    System.out.println(result.toString());
	    
	    diagno d = new diagno(kgValue ,cmValue,scoreFloat_1,diag,user_1.getId());
	    
	    diagno_impl d_impl = new diagno_impl(DAOFactory.getInstance()) ;
	    
        d_impl.create(d) ;
        
        String message= "" ;
        
        if(scoreFloat_1<=1.7 ) {
        	
        	message = "Risk Level is Low" ;
        }
        if(scoreFloat_1>1.7 && scoreFloat_1<=3.8 ) {
        	
        	message = "Risk Level is Median" ;
        }
        if(scoreFloat_1>1.7 && scoreFloat_1<=3.8 ) {
        	
        	message = "Risk Level is Hight" ;
        }
        
        request.setAttribute("message", message) ;
        
        this.getServletContext().getRequestDispatcher("/main_2.jsp").forward( request, response );
	}



private static String removeNull(String input) {
    // Remplacer toutes les occurrences de "null" par une chaîne vide
    return input.replaceAll("null", "");
}

}

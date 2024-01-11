<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Paincaret</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css" integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="main.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8sh+WyL/JqIcF5k9UJeg6KfNUAtGUKRveJ8Z9W" crossorigin="anonymous">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="flex">
    
    <%
    // Accéder à l'attribut "message" depuis la requête
    String message = (String) request.getAttribute("message");
    %>
   
   
    <div class="wrapper">
        <div class="quiz-container">
            <div class="quiz-head">
                <h1 class="quiz-title">Diagnostic</h1>
               <br>
               <br>
                <% if (message != null) { %>
    <div class="alert alert-danger" role="alert">
        <%= message %>
    </div>
<% } %>
               <br>
               <br>
               
            </div>
            <form action="diagnostic" method="post" id="form" >
            
            
                <div class="quiz-body">
                    <h2 class="quiz-question" id="question">When do you start your period?</h2>
                    <ul class="quiz-options">
                        <li>
                            <label>
                                <input type="checkbox" name="1" value="1.1">  before 11 years old
                            </label>
                        </li>
                        <li>
                            <label>
                                <input type="checkbox" name="1" value="1.2"> Above 11 years old
                            </label>
                        </li>
            
                    </ul>
                </div>
                
                
                <br>
                ---------------------------------------------------
                <br>
                
                <div class="quiz-body">
                    <h2 class="quiz-question" id="question">Your menstrual cycle length average?</h2>
                    <ul class="quiz-options">
                        <li>
                            <label>
                                <input type="checkbox" name="2" value="2.1"> Less than 27 days
                            </label>
                        </li>
                        <li>
                            <label>
                                <input type="checkbox" name="2" value="2.2">  More than 27 days 
                            </label>
                        </li>
                        <li>
                            <label>
                                <input type="checkbox" name="2" value="2.3">  Not sure
                            </label>
                        </li>
                    </ul>
                </div>
             
                
                <br>
                ---------------------------------------------------
                <br>
                
                <div class="quiz-body">
                    <h2 class="quiz-question" id="question">Do you have a family history of endometriosis?</h2>
                    <ul class="quiz-options">
                        <li>
                            <label>
                                <input type="checkbox" name="3" value="3.1"> Yes
                            </label>
                        </li>
                        <li>
                            <label>
                                <input type="checkbox" name="3" value="3.2"> No
                            </label>
                        </li>
                        
                    </ul>
                </div>
              
                
                <br>
                ---------------------------------------------------
                <br>
                
                <div class="quiz-body">
                    <h2 class="quiz-question" id="question">Did you give birth?</h2>
                    <ul class="quiz-options">
                        <li>
                            <label>
                                <input type="checkbox" name="4" value="4.1"> Yes
                            </label>
                        </li>
                        <li>
                            <label>
                                <input type="checkbox" name="4" value="4.2"> No
                            </label>
                        </li>
                        
                    </ul>
                </div>
                
                
                <br>
                ---------------------------------------------------
                <br>
                
                <div class="quiz-body">
                    <h2 class="quiz-question" id="question">Do you have a trouble getting pregnant?</h2>
                    <ul class="quiz-options">
                        <li>
                            <label>
                                <input type="checkbox" name="5" value="5.1"> Yes
                            </label>
                        </li>
                        <li>
                            <label>
                                <input type="checkbox" name="5" value="5.2"> No
                            </label>
                        </li>
                        
                    </ul>
                </div>
                
                <br>
                
              
                
                ---------------------------------------------------
                <br>
                
                <div class="quiz-body">
                    <h2 class="quiz-question" id="question">Body mass index: calculate your BMI</h2>
                    <ul class="quiz-options">
                        <li>
                         
                        
                            <label>
                                <input type="text" class="input" name="Kg" placeholder="Enter your weight in kg" required > 
                            </label>
                        </li>
                        <li>
                            <label>
                                <input type="text" class="input" name="cm" placeholder="Enter your height in cm" required > 
                            </label>
                        </li>
                        
                    </ul>
                </div>
                
                 <br>
                ---------------------------------------------------
                <br>
                
                <div class="quiz-body">
                    <h2 class="quiz-question" id="question">What is your abdominal/ pelvic pain intensity</h2>
                    <ul class="quiz-options">
                        <li>
                            <label>
                                <input type="checkbox" name="6" value="6.1"> 0-2
                            </label>
                        </li>
                        <li>
                            <label>
                                <input type="checkbox" name="6" value="6.2"> 3-5
                            </label>
                        </li>
                        <li>
                            <label>
                                <input type="checkbox" name="6" value="6.3"> 6-8
                            </label>
                        </li>
                        <li>
                            <label>
                                <input type="checkbox" name="6" value="6.4"> 9-10
                            </label>
                        </li>
                        
                        
                    </ul>
                </div>
                <br>
                ---------------------------------------------------
                <br>
                
                <div class="quiz-body">
                    <h2 class="quiz-question" id="question">When do you experience abdominal or pelvic pain?</h2>
                    <ul class="quiz-options">
                        <li>
                            <label>
                                <input type="checkbox" name="7" value="7.1"> Related to period
                            </label>
                        </li>
                        <li>
                            <label>
                                <input type="checkbox" name="7" value="7.2"> Rrelated to ovulation
                            </label>
                        </li>
                        <li>
                            <label>
                                <input type="checkbox" name="7" value="7.3">Unrelated to period and ovulation
                            </label>
                        </li>
                        
                    </ul>
                </div>
                <br>
                ---------------------------------------------------
                <br>
                
                <div class="quiz-body">
                    <h2 class="quiz-question" id="question">Severity of pain during intercourse?</h2>
                    <ul class="quiz-options">
                        <li>
                            <label>
                                <input type="checkbox" name="8" value="8.1">  0-2
                            </label>
                        </li>
                        <li>
                            <label>
                                <input type="checkbox" name="8" value="8.2">  3-5
                            </label>
                        </li>
                        <li>
                            <label>
                                <input type="checkbox" name="8" value="8.3"> 6-8
                            </label>
                        </li>
                        
                        <li>
                            <label>
                                <input type="checkbox" name="8" value="8.3">   9-10
                            </label>
                        </li>
                        
                    </ul>
                </div>
                
                <br>
                ---------------------------------------------------
                <br>  
              
                <div class="quiz-body">
        <!-- Question 1 -->
                  <h2 class="quiz-question" id="question1">What makes your pain worse?</h2>
              <ul class="quiz-options">
            <li>
                <label>
                    <input type="checkbox" name="9" value="9.1">  Bowel movement
                </label>
            </li>
            <li>
                <label>
                    <input type="checkbox" name="9" value="9.2">  Full bladder
                </label>
            </li>
            <li>
                <label>
                    <input type="checkbox" name="9" value="9.3">  Urination
                </label>
            </li>
            <li>
                <label>
                    <input type="checkbox" name="9" value="9.4">  Orgasm
                </label>
            </li>
            <li>
                <label>
                    <input type="checkbox" name="9" value="9.5">  Not related to anything
                </label>
            </li>

        </ul>
    </div>             
               <br>
                ---------------------------------------------------
                <br>            

    <div class="quiz-body">
        <!-- Question 2 -->
        <h2 class="quiz-question" id="question2">Duration of period?</h2>
        <ul class="quiz-options">
            <li>
                <label>
                    <input type="checkbox" name="10" value="10.1">  1-7 days
                </label>
            </li>
            <li>
                <label>
                    <input type="checkbox" name="10" value="10.2">  More than 7 days
                </label>
            </li>
            <!-- Ajoutez d'autres options ici selon la question 2 -->

        </ul>
    </div>
    
                  <br>
                ---------------------------------------------------
                <br>   


           <div class="quiz-body">
        <!-- Question 3 -->
        <h2 class="quiz-question" id="question3">Nature of periods?</h2>
        <ul class="quiz-options">
            <li>
                <label>
                    <input type="checkbox" name="11" value="11.1">  Heavy
                </label>
            </li>
            <li>
                <label>
                    <input type="checkbox" name="11" value="11.2">  Moderate
                </label>
            </li>
            <li>
                <label>
                    <input type="checkbox" name="11" value="11.3">  Light
                </label>
            </li>
        </ul>
    </div>
    
    
                  <br>
                ---------------------------------------------------
                <br>  

    <div class="quiz-body">
        <!-- Question 4 -->
        <h2 class="quiz-question" id="question4">What is your menstrual cycle pattern?</h2>
        <ul class="quiz-options">
            <li>
                <label>
                    <input type="checkbox" name="12" value="12.1">  Regular
                </label>
            </li>
            <li>
                <label>
                    <input type="checkbox" name="12" value="12.2">  Irregular
                </label>
            </li>
            <li>
                <label>
                    <input type="checkbox" name="12" value="12.3">  Bleeding or spotting between periods
                </label>
            </li>
        </ul>
    </div>
    
     <br>
                ---------------------------------------------------
                <br>

    <div class="quiz-body">
        <!-- Question 5 -->
        <h2 class="quiz-question" id="question5">Do you have?</h2>
        <ul class="quiz-options">
            <li>
                <label>
                    <input type="checkbox" name="13" value="13.1">  Blood in your stool
                </label>
            </li>
            <li>
                <label>
                    <input type="checkbox" name="13" value="13.2">  Diarrhea
                </label>
            </li>
            <li>
                <label>
                    <input type="checkbox" name="13" value=13.3">  Constipation
                </label>
            </li>
            <li>
                <label>
                    <input type="checkbox" name="13" value="13.4">  Abdominal Bloating
                </label>
            </li>
        </ul>
    </div>
    
     <br>
                ---------------------------------------------------
                <br>

    <div class="quiz-body">
        <!-- Question 6 -->
        <h2 class="quiz-question" id="question6">Have you ever faced any incidents of physical or sexual mistreatment</h2>
        <ul class="quiz-options">
            <li>
                <label>
                    <input type="checkbox" name="14" value="14.1">  Yes
                </label>
            </li>
            <li>
                <label>
                    <input type="checkbox" name="14" value="14.2">  No
                </label>
            </li>
        </ul>
    </div>


                <div class="quiz-foot"></div>
                
                <button type="submit" class="btn btn-primary">Valider</button>
                </div>




    </form>
    
    <script>
       
    
    document.addEventListener('DOMContentLoaded', function () {
        // Récupérer le bouton par son sélecteur de classe
        var submitButton = document.querySelector('.btn.btn-primary');

        // Ajouter un écouteur d'événements au clic sur le bouton
        submitButton.addEventListener('click', function (event) {
            // Empêcher le comportement par défaut du formulaire (rechargement de la page)
            event.preventDefault();

            // Récupérer tous les éléments de type checkbox
            var checkboxes = document.querySelectorAll('input[type="checkbox"]');

            // Fonction pour calculer le score
            function calculateScore() {
                // Définir les coefficients pour chaque checkbox
                var coefficients = {
            '1.1': 0.1,
            '1.2': 0.2,
            '2.1': 0.15,
            '2.2': 0.25,
            '2.3': 0.1,
            '3.1': 0.1,
            '3.2': 0.2,
            '4.1': 0.1,
            '4.2': 0.2,
            '5.1': 0.15,
            '5.2': 0.1,
            '6.1': 0.1,
            '6.2': 0.15,
            '6.3': 0.2,
            '6.4': 0.1,
            '7.1': 0.1,
            '7.2': 0.2,
            '7.3': 0.15,
            '8.1': 0.1,
            '8.2': 0.15,
            '8.3': 0.2,
            '8.3': 0.1,
            '9.1': 0.1,
            '9.2': 0.2,
            '9.3': 0.15,
            '9.4': 0.1,
            '9.5': 0.15,
            '10.1': 0.1,
            '10.2': 0.2,
            '11.1': 0.1,
            '11.2': 0.2,
            '11.3': 0.15,
            '12.1': 0.1,
            '12.2': 0.2,
            '12.3': 0.15,
            '13.1': 0.1,
            '13.2': 0.2,
            '13.3': 0.15,
            '13.4': 0.1,
            '14.1': 0.1,
            '14.2': 0.2,
        };


                // Initialiser le score
                var score = 0;

                // Parcourir toutes les checkboxes
                checkboxes.forEach(function (checkbox) {
                    // Vérifier si la checkbox est cochée
                    if (checkbox.checked) {
                        // Récupérer la valeur et ajouter au score en fonction du coefficient
                        var value = checkbox.value;
                        score += coefficients[value] || 0;
                    }
                });

                // Afficher le score (vous pouvez faire d'autres choses avec le score ici)
                console.log('Score:', score);
                
                return score ;
            }

            // Appeler la fonction de calcul du score
            score =  calculateScore();
            
            
           

            	const url = 'http://localhost:8080/paincare/quiz';

            	fetch(url, {
            	    method: 'POST',
            	    headers: {
            	        'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8',
            	    },
            	    body: new URLSearchParams(score),
            	})
            	.then(response => response.text())
            	.then(data => console.log('Réponse du serveur :', data))
            	.catch(error => console.error('Erreur lors de la requête :', error));
            
            
         setTimeout(function() {
            document.getElementById('form').submit();
            }, 1000);
        });
    });


    
    
    
    </script>
    
    </div>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
     <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-Xgcf1dLEq3Rnxn5ZrzCzjL3U2w8LUjZPfwz1uxHv3HKaC0ft56E7m3Lvzr5UJo4K" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8sh+WyL/JqIcF5k9UJeg6KfNUAtGUKRveJ8Z9W" crossorigin="anonymous"></script>

</body>
</html>

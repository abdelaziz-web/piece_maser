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
                <h1 class="quiz-title">Pain Track</h1>
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
            <form action="paint_track" method="post" >
            <div class="container mt-5">
        <h2>Degré de Douleur</h2>
        <div class="form-group">
            <label for="painLevel">Sélectionnez le degré de douleur :</label>
            <input type="range" name="degre" class="form-control-range danger" id="painLevel" min="0" max="10" step="1" value="5">
        </div>
        <div class="form-group">
            <label for="painLevelDisplay">Niveau de douleur actuel :</label>
            <output class="form-control" id="painLevelDisplay">0.5</output>
        </div>
    </div>
            
                <div class="quiz-body">
                    <h2 class="quiz-question" id="question">Pain Locations</h2>
                    <ul class="quiz-options">
                        <li>
                            <label>
                                <input type="checkbox" name="painLocation" value="1.1"> Abdomen
                            </label>
                        </li>
                        <li>
                            <label>
                                <input type="checkbox" name="painLocation" value="1.2"> Back
                            </label>
                        </li>
                        <li>
                            <label>
                                <input type="checkbox" name="painLocation" value="1.3"> Chest
                            </label>
                        </li>
                        <li>
                            <label>
                                <input type="checkbox" name="painLocation" value="1.4"> Head
                            </label>
                        </li>
                        <li>
                            <label>
                                <input type="checkbox" name="painLocation" value="1.5"> Neck
                            </label>
                        </li>
                        <li>
                            <label>
                                <input type="checkbox" name="painLocation" value="1.6"> Hips
                            </label>
                        </li>
                    </ul>
                </div>
                
                
                <br>
                ---------------------------------------------------
                <br>
                
                <div class="quiz-body">
                    <h2 class="quiz-question" id="question">Symptoms</h2>
                    <ul class="quiz-options">
                        <li>
                            <label>
                                <input type="checkbox" name="symptoms" value="2.1"> Cramps
                            </label>
                        </li>
                        <li>
                            <label>
                                <input type="checkbox" name="symptoms" value="2.2"> Tender breasts
                            </label>
                        </li>
                        <li>
                            <label>
                                <input type="checkbox" name="symptoms" value="2.3"> Headache
                            </label>
                        </li>
                        <li>
                            <label>
                                <input type="checkbox" name="symptoms" value="2.4"> Acne
                            </label>
                        </li>
                        <li>
                            <label>
                                <input type="checkbox" name="symptoms" value="2.5"> Fatigue
                            </label>
                        </li>
                        <li>
                            <label>
                                <input type="checkbox" name="symptoms" value="2.6"> Bloating
                            </label>
                        </li>
                        <li>
                            <label>
                                <input type="checkbox" name="symptoms" value="2.7"> Craving
                            </label>
                        </li>
                    </ul>
                </div>
             
                
                <br>
                ---------------------------------------------------
                <br>
                
                <div class="quiz-body">
                    <h2 class="quiz-question" id="question">What makes Pain worse?</h2>
                    <ul class="quiz-options">
                        <li>
                            <label>
                                <input type="checkbox" name="worseFactors" value="3.1"> Lack of sleep
                            </label>
                        </li>
                        <li>
                            <label>
                                <input type="checkbox" name="worseFactors" value="3.2"> Sitting
                            </label>
                        </li>
                        <li>
                            <label>
                                <input type="checkbox" name="worseFactors" value="3.3"> Standing
                            </label>
                        </li>
                        <li>
                            <label>
                                <input type="checkbox" name="worseFactors" value="3.4"> Stress
                            </label>
                        </li>
                        <li>
                            <label>
                                <input type="checkbox" name="worseFactors" value="3.5"> Walking
                            </label>
                        </li>
                        <li>
                            <label>
                                <input type="checkbox" name="worseFactors" value="3.6"> Exercise
                            </label>
                        </li>
                        <li>
                            <label>
                                <input type="checkbox" name="worseFactors" value="3.7"> Urination
                            </label>
                        </li>
                    </ul>
                </div>
              
                
                <br>
                ---------------------------------------------------
                <br>
                
                <div class="quiz-body">
                    <h2 class="quiz-question" id="question">Feelings</h2>
                    <ul class="quiz-options">
                        <li>
                            <label>
                                <input type="checkbox" name="feelings" value="4.1"> Anxious
                            </label>
                        </li>
                        <li>
                            <label>
                                <input type="checkbox" name="feelings" value="4.2"> Depressed
                            </label>
                        </li>
                        <li>
                            <label>
                                <input type="checkbox" name="feelings" value="4.3"> Dizzy
                            </label>
                        </li>
                        <li>
                            <label>
                                <input type="checkbox" name="feelings" value="4.4"> Vomiting
                            </label>
                        </li>
                        <li>
                            <label>
                                <input type="checkbox" name="feelings" value="4.5"> Diarrhea
                            </label>
                        </li>
                    </ul>
                </div>
                <div class="quiz-foot"></div>
                
                <button type="submit" class="btn btn-primary">Valider</button>
                </div>

    </form>
    
    <script>
        // Mettez à jour le niveau de douleur affiché en fonction du changement de l'input range
        var painLevelInput = document.getElementById('painLevel');
        var painLevelDisplay = document.getElementById('painLevelDisplay');

        painLevelInput.addEventListener('input', function() {
            painLevelDisplay.value = painLevelInput.value/10;
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

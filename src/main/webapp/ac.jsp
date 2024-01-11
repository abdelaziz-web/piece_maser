<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>


<style>
    body {
    font-family: 'Arial', sans-serif;
    margin: 0;
    padding: 0;
    overflow-y: auto; /* Ajout de cette propriété pour le défilement vertical */
}

header {
    background-color: #333;
    color: #fff;
    text-align: center;
    padding: 10px;
}

main {
    display: flex;
    justify-content: space-around;
    padding: 20px;
}

section {
    flex: 1;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    padding: 20px;
    text-align: center;
    min-height: 200px; /* Ajustez la hauteur souhaitée */
}

section:nth-child(odd) {
    background-color: #f0f0f0;
}

section:nth-child(even) {
    background-color: #e0e0e0;
}

footer {
    background-color: #333;
    color: #fff;
    text-align: center;
    padding: 10px;
}


</style>
<meta charset="UTF-8">
<title>Accueil</title>
<link rel="stylesheet" type="text/css" href="/acceuilDesign.jsp" />
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta name="author" content="" />

<style>
    .image-arrondie {
        border-radius: 10%; 
        overflow: hidden;
        width: 500px; 
        height: auto; 
    }

    .vertical-split {
        display: flex;
        height: 100%; 
    }

    .vertical-split-left,
    .vertical-split-right {
        flex: 1;
        overflow: hidden;
        border: 1px solid #ccc;
    }

    .vertical-split-left {
        background-color: #f0f0f0; 
    }

    .no-border {
        border: none;
    }
    
     .alpha {
      width: 300px; /* Ajustez la largeur selon vos besoins */
      height: 300px; /* Ajustez la hauteur selon vos besoins */
    }
    
    
</style>

<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700;900&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css" />
<link href="css/font-awesome.min.css" rel="stylesheet" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-nice-select/1.1.0/css/nice-select.min.css" integrity="sha256-mLBIhmBvigTFWPSCtvdu6a76T+3Xyt+K571hupeFLg4=" crossorigin="anonymous" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker.css">
<link href="css/style.css" rel="stylesheet" />
<link href="css/responsive.css" rel="stylesheet" />
</head>

<body>


<header>

<%@include file="navbar.jsp" %>

<div class="my-5 mx-5 " > 

<%@ page import="dao.user" %> 

<%@ page import="beans.diagno" %> 

<%
   user user_1 = (user)request.getAttribute("user");

   diagno diag = (diagno)request.getAttribute("diag");

   // Assurez-vous que la variable "user_1" est correctement déclarée et initialisée
%>

<h2> hi  <%= user_1.getUsername() %> </h2>



   
</header>

<main>
    <section>
        <h2>Your last Score :</h2>
        <p>  <% if (diag != null) { %>
                <%= diag.getScores() %>
            <% }   else { %>
            N/A 
        <% } %>  </p>
    </section>

    <section class="my-2">
        <h2>Diagnostic</h2>
        <p><button type="button" class="btn btn-primary btn-lg"> <a href="diagnostic" > DO IT  </a> </button></p>
    </section>

    <section class="my-2">
        <h2>Pain track</h2>
        <p><button type="button" class="btn btn-primary btn-lg"> <a href="main.jsp" >  DO IT </a></button></p>
    </section>
    
    
    
    <div class="container text-center">
  <div class="row">
    <div class="col">
      <div class="alpha">
   
  <canvas id="myChart_1"></canvas>
  
   </div>
    </div>
  
    <div class="col">
    <div class="alpha">
   
  <canvas id="myChart_2"></canvas>
  
   </div>
    </div>
  </div>

   <div class="alpha">
   
  <canvas id="myChart_2"></canvas>
  
   </div>
  
  <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
  
  
     <script>
  fetch('http://localhost:8080/paincare/liste_pain')
    .then(response => response.text())
    .then(data => {
      // Convertir la chaîne en un tableau JavaScript
      var li = JSON.parse(data);

      
      const hasNegativeValue = li.some(value => value < 0);

      if (hasNegativeValue) {
       
      } else {
        
    	  bar(li);
          bar_1(li);
    	  
      }
      

      console.log(li);
      console.log(typeof li);
    })
    .catch(error => {
      console.error('Erreur lors de la récupération des données :', error);
    });

  function bar(data) {
    const ctx = document.getElementById('myChart_1');

    const labels = Array.from({ length: data.length }, (_, i) => (i + 1).toString());
    
    new Chart(ctx, {
      type: 'pie',
      data: {
        labels: labels,
        datasets: [{
          label: 'Pain evolution',
          data: data, // Utilisez les données récupérées ici
          borderWidth: 1
        }]
      },
      options: {
        scales: {
          y: {
            beginAtZero: true
          }
        }
      }
    });
  }

  function bar_1(data) {
    const ctx = document.getElementById('myChart_2');

    const labels = Array.from({ length: data.length }, (_, i) => (i + 1).toString());
    
    new Chart(ctx, {
      type: 'line',
      data: {
        labels: labels,
        datasets: [{
          label: 'Pain distribution',
          data: data, // Utilisez les données récupérées ici
          borderWidth: 1
        }]
      },
      options: {
        scales: {
          y: {
            beginAtZero: true
          }
        }
      }
    });
  }
</script>
     
    
    
</main>

<footer>
    <p>Pied de page de la page</p>
</footer>





<script src="https://cdn.rawgit.com/image-resizer/resizer/master/src/resizer.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-Xgcf1dLEq3Rnxn5ZrzCzjL3U2w8LUjZPfwz1uxHv3HKaC0ft56E7m3Lvzr5UJo4K" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8sh+WyL/JqIcF5k9UJeg6KfNUAtGUKRveJ8Z9W" crossorigin="anonymous"></script>


</body>
</html>
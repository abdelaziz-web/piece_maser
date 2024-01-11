<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

 <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <!-- Mobile Metas -->
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <!-- Site Metas -->
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta name="author" content="" />

  <style>
  
  body {
    margin: 0;
    padding: 0;
    /* overflow: hidden; */ /* Retirez ou commentez cette ligne */
}
  
  
  .image-arrondie {
    border-radius: 10%; 
    overflow: hidden;
    width: 500px; /* Largeur souhaitée */
    height: auto; 
  }
  
  
  .vertical-split {
    display: flex;
    height: 100%; /* Ajustez la hauteur selon vos besoins */
}

.vertical-split-left,
.vertical-split-right {
    flex: 1;
    overflow: hidden;
    border: 1px solid #ccc;
}

.vertical-split-left {
    background-color: #f0f0f0; /* Fond différent pour la partie gauche (facultatif) */
}
  
  
  .no-border {
        border: none;
    }
  
</style>

  <!-- bootstrap core css -->
  <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />

  <!-- fonts style -->
  <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700;900&display=swap" rel="stylesheet">

  <!--owl slider stylesheet -->
  <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css" />

  <!-- font awesome style -->
  <link href="css/font-awesome.min.css" rel="stylesheet" />
  <!-- nice select -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-nice-select/1.1.0/css/nice-select.min.css" integrity="sha256-mLBIhmBvigTFWPSCtvdu6a76T+3Xyt+K571hupeFLg4=" crossorigin="anonymous" />
  <!-- datepicker -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker.css">
  <!-- Custom styles for this template -->
  <link href="css/style.css" rel="stylesheet" />
  <!-- responsive style -->
  <link href="css/responsive.css" rel="stylesheet" />

<style>
        body {
            margin: 0;
            padding: 0;
            overflow: hidden; /* Pour empêcher les débordements de défilement */
        }

        .container {
            display: flex; /* Utilisation de flexbox pour diviser horizontalement */
            height: 100vh; /* Hauteur de la vue à 100% */
        }

        .half {
            flex: 1; /* Utilisation de flex pour partager l'espace équitablement */
            overflow: hidden; /* Pour éviter que le contenu ne dépasse */
            border: 1px solid #ccc; /* Ajoutez une bordure pour visualiser la subdivision */
        }

        /* Styles optionnels pour le contenu */
        .half:nth-child(odd) {
            background-color: #f0f0f0; /* Ajoutez un fond différent à chaque moitié (facultatif) */
        }

        /* Ajoutez du contenu à chaque moitié (facultatif) */
        .content {
            padding: 20px;
        }
    </style>

</head>


<body>
<%@include file="navbar.jsp" %>

<div class="my-5 mx-5 " > 

<%@ page import="dao.user" %> 

<%
   user user_1 = (user)request.getAttribute("user");
   // Assurez-vous que la variable "user_1" est correctement déclarée et initialisée
%>

<h2> hi alpha</h2>

</div>


<div class="container no-border">
        <div class="half mx-1 no-border rounded ">
            <div class="content my-1 no-border " >
                <!-- Contenu de la première moitié -->
           
                
                <div class="h4 pb-2 mb-4 text-danger border-bottom border-danger">
                <h2>Record </h2>
                <p>Votre dérnier Score :</p>
                </div>
                
            </div>
        </div>
        <div class="half no-border rounded ">
            <div class="content p-0 no-border ">
                <!-- Contenu de la deuxième moitié -->
                 
                <div class="vertical-split-left my-1 no-border ">
                <h2> Diagnostic :</h2>
                <p>  <button type="button" class="btn btn-primary"> <a href="diagnostic" >  Primary </a></button> </p>
                </div>
            <div class="vertical-split-right mx-0 my-1 no-border">
                <div class="vertical-split-left my-1 no-border ">
                <h2> Pain_track : </h2>
                <p>  <button type="button" class="btn btn-primary"> <a href="main.jsp" > Primary</a> </button> </p>
                </div>
            </div>
               
                
            </div>

            </div>
        </div>
    </div>

<main>
   <div class="container mt-5">
    <div class="d-flex align-items-center justify-content-center border p-3 mb-3">
      <p class="text-center">Texte centré au milieu du div</p>
    </div>
  </div>
  
  <div class="container mt-5">
    <div class="d-flex align-items-center justify-content-center border p-3 mb-3">
      <p class="text-center">Texte centré au milieu du div</p>
    </div>
  </div>
  
  <div class="container mt-5">
    <div class="d-flex align-items-center justify-content-center border p-3 mb-3">
      <p class="text-center">Texte centré au milieu du div</p>
    </div>
  </div>
  
  
  <div class="container mt-5">
    <div class="d-flex align-items-center justify-content-center border p-3 mb-3">
      <p class="text-center">Texte centré au milieu du div</p>
    </div>
  </div>


   <div class="container overflow-hidden text-center">
  <div class="row gx-5">
    <div class="col">
     <div class="p-3  border border-danger ">Custom </div>
    </div>
    <div class="col">
      <div class="p-3  border border-danger ">Custom column padding</div>
    </div>
  </div>
</div>
</main>


  <!-- footer section -->
  <footer class="footer_section">
    <div class="container">
      <p>
        &copy; <span id="displayYear"></span> All Rights Reserved By
        <a href="https://html.design/">Free Html Templates</a>
      </p>
    </div>
  </footer>

<script src="https://cdn.rawgit.com/image-resizer/resizer/master/src/resizer.js"></script>
<!-- À la fin de la balise body -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-Xgcf1dLEq3Rnxn5ZrzCzjL3U2w8LUjZPfwz1uxHv3HKaC0ft56E7m3Lvzr5UJo4K" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8sh+WyL/JqIcF5k9UJeg6KfNUAtGUKRveJ8Z9W" crossorigin="anonymous"></script>
<!-- Votre fichier JavaScript personnalisé peut être ajouté ici -->



</body>
</html>
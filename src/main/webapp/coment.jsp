<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
  <!-- Basic -->
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <!-- Mobile Metas -->
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <!-- Site Metas -->
  <meta name="keywords" content="" />
  <meta name="description" content="" />

  <style>
  .image-arrondie {
    border-radius: 10%; 
    overflow: hidden;
    width: 500px; /* Largeur souhaitée */
    height: auto; 
  }
</style>

  <!-- bootstrap core css -->
  <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
 <script src="https://code.jquery.com/jquery-3.6.4.js"></script>
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
        /* Ajouter une classe personnalisée pour minimiser la taille de la carte */
        .minimize-card {
            max-width: 500px; /* Ajustez la largeur maximale selon vos besoins */
        }
        
        .usr-img{
         height: 5rem;
         width: 5rem;
       }
    </style>

</head>

<body>

 

    <%@include file="navbar.jsp" %>


 <%@ page import="dao.blog" %>

     
     <div class="hero_area my-5" >
    
    
    </div>
   <%@ page import="java.util.List" %>
   
   <%@ page import="dao.user" %> 
   
   <% 
        List<user> userList = (List<user>) request.getAttribute("users");
        int i = 0 ;
    %>
   
   
   <input type="hidden" id="blog_id"  value="${blog.blog_id}">
   <input type="hidden" id="author_id" value="${user.id}">
   <input type="hidden" id="username" value="${user.username}">
                   
   
    <div >
           
           
           <div class="card mb-3 minimize-card mx-auto">
           <img src="imgservlet?id=${blog.photo}" class="img-fluid" alt="...">
           <div class="card-body">
           <h5 class="card-title">${blog.title}</h5>
           <p class="card-text">${blog.description}</p>
           <p class="card-text"><small class="text-body-secondary">Last updated : ${blog.created_at} </small></p>
           </div>   
           </div> 
               
           <c:forEach items="${list_com}" var="li">    
               
               
           <div class="card mb-3 minimize-card mx-auto">
           <img src="rsz.png" class="usr-img"  alt="...">
           <div class="my-2" > 
           
             username :  <%=userList.get(0).getUsername()%>        
            </div> 
           <% i=i+1 ;     %> 
           <div class="border p-3">
           <!-- Le contenu de votre div va ici -->
           <p>${li.content}</p>
           </div>
           </div> 
           </c:forEach>

            <div id="1" >
           
           
           </div>


            <div class="card mb-3 minimize-card mx-auto">
           <img src="rsz.png" class="usr-img"  alt="...">
           <div class="my-2" > 
           
           
            username :  ${user.username}
            
            </div> 
            
            
           
           <div class="border p-3">
           
           
           
           <input id ="id_input" type="text" class="form-control" placeholder="Enter something..." onclick="envoyerFormulaire()">
  
  
           <button type="button" class="btn btn-primary" onclick="envoyerFormulaire()">Cliquez-moi</button>
           </div>
           </div>
       
           </div>
         
      


        <section class="info_section ">
          <div class="container">
            <div class="info_top">
              <div class="info_logo">
                <a href="">
                  <img src="pain.png" alt="" class="image-arrondie" >
                </a>
              </div>
             
            </div>
            <div class="info_bottom layout_padding2">
              <div class="row info_main_row">
                <div class="col-md-6 col-lg-3">
                  <h5>
                    Address
                  </h5>
                  <div class="info_contact">
                    <a href="">
                      <i class="fa fa-map-marker" aria-hidden="true"></i>
                      <span>
                        Location
                      </span>
                    </a>
                    <a href="">
                      <i class="fa fa-phone" aria-hidden="true"></i>
                      <span>
                        Call +01 1234567890
                      </span>
                    </a>
                    <a href="">
                      <i class="fa fa-envelope"></i>
                      <span>
                        demo@gmail.com
                      </span>
                    </a>
                  </div>
                  <div class="social_box">
                    <a href="">
                      <i class="fa fa-facebook" aria-hidden="true"></i>
                    </a>
                    <a href="">
                      <i class="fa fa-twitter" aria-hidden="true"></i>
                    </a>
                    <a href="">
                      <i class="fa fa-linkedin" aria-hidden="true"></i>
                    </a>
                    <a href="">
                      <i class="fa fa-instagram" aria-hidden="true"></i>
                    </a>
                  </div>
                </div>
                <div class="col-md-6 col-lg-3">
                  <div class="info_links">
                    <h5>
                      Useful link
                    </h5>
                    <div class="info_links_menu">
                      <a class="active" href="index.html">
                        Home
                      </a>
                      <a href="about.html">
                        About
                      </a>
                      <a href="treatment.html">
                        Treatment
                      </a>
                      <a href="doctor.html">
                        Doctors
                      </a>
                      <a href="testimonial.html">
                        Testimonial
                      </a>
                      <a href="contact.html">
                        Contact us
                      </a>
                    </div>
                  </div>
                </div>
                
               
                </div>
              </div>
            </div>
          </div>
        </section>
        <!-- end info_section -->
        
      

      <script>
    
      function envoyerFormulaire() {
          // Récupérer les données du formulaire
        
          
          var valeurInput = document.getElementById("id_input").value;
          
          if (valeurInput.trim() !== "") {
          
          var urlOriginal = "http://localhost:8080/paincare/com_serv";

          // Créer un objet XMLHttpRequest
          var xhr = new XMLHttpRequest();

          // Configurer la requête
          xhr.open("POST", urlOriginal, true);
          xhr.setRequestHeader("Content-Type",  "application/json");

          // Définir la fonction à exécuter lorsque la requête est terminée
          xhr.onreadystatechange = function() {
              if (xhr.readyState === 4 && xhr.status === 200) {
                  // La requête a réussi
                  console.log('Données envoyées avec succès:', xhr.responseText);
              } else if (xhr.readyState === 4 && xhr.status !== 200) {
                  // La requête a échoué
                  console.error('Erreur lors de l\'envoi des données:', xhr.status, xhr.statusText);
              }
          };
   
          var blog_id = document.getElementById("blog_id").value;

          var author_id = document.getElementById("author_id").value;
         
          var donnees = [valeurInput, blog_id,author_id];
          
          var donneesSerialisees = JSON.stringify(donnees);

          // Envoyer la requête avec les données du formulaire
          xhr.send(donneesSerialisees);
          
          setTimeout(function() {
        	    // Cacher l'attente après le délai
        	    hideLoading();
        	}, 1000);
          
          inserer(valeurInput) ;
          
          } else {
              // La valeur de l'input est vide, afficher un message ou effectuer d'autres actions si nécessaire
              alert('La valeur de l\'input est vide. Aucune requête ne sera envoyée.');
          }
          document.getElementById("id_input").value = "";
          
          
 
      }
         
   function inserer(content){
	   
	   var nouvelElement = document.createElement("div");
	   nouvelElement.className = "card mb-3 minimize-card mx-auto";
       var username = document.getElementById("username").value;
       nouvelElement.innerHTML = '<img src="rsz.png" class="usr-img" alt="..."> <div class="my-2"> username : ' + username + ' </div><div class="border p-3"> <p> ' + content + ' </p> </div> '  ;
        console.log(content) ;
        console.log(username) ;

       var conteneur = document.getElementById("1");
       conteneur.appendChild(nouvelElement);
       
   }  
 
</script>
      
      
        <!-- footer section -->
        <footer class="footer_section">
          <div class="container">
            <p>
              &copy; <span id="displayYear"></span> All Rights Reserved By
              <a href="https://html.design/">Free Html Templates</a>
            </p>
          </div>
        </footer>
        <!-- footer section -->


<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script src="https://cdn.rawgit.com/image-resizer/resizer/master/src/resizer.js"></script>
<!-- À la fin de la balise body -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-Xgcf1dLEq3Rnxn5ZrzCzjL3U2w8LUjZPfwz1uxHv3HKaC0ft56E7m3Lvzr5UJo4K" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8sh+WyL/JqIcF5k9UJeg6KfNUAtGUKRveJ8Z9W" crossorigin="anonymous"></script>
<!-- Votre fichier JavaScript personnalisé peut être ajouté ici -->

</body>
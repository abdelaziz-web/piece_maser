<header class="header_section">
      
      <div class="header_bottom">
        <div class="container-fluid">
          <nav class="navbar navbar-expand-lg custom_nav-container ">
            <a class="navbar-brand" href="#" width="200px"  >
              <img src="pain.png" alt="" class="image-arrondie" >
            </a>

             <%@ page import="jakarta.servlet.http.HttpSession" %>
             
              <%@ page import="dao.user" %>          
    
            <%
              // Récupérez la session
             HttpSession session_10 = request.getSession();
             user user_20 = (user) session.getAttribute("user") ;
             
             
            
              %>


            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
              <span class=""> </span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
              <div class="d-flex mr-auto flex-column flex-lg-row align-items-center">
                <ul class="navbar-nav  ">
                  <li class="nav-item active">
                    <a class="nav-link" href="acceuil">Accueil <span class="sr-only">(current)</span></a>
                  </li>
                  
                  <li class="nav-item">
                    <a class="nav-link" href="servlet_blog">Communaté</a>
                  </li>
                 <li class="nav-item">
                    <a class="nav-link" href="mes_blogs">Mes blog</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="profile_servlet">Profile</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="auth_serv">logout</a>
                  </li>
                  
                </ul>
              </div>

         <!--      <div>

              <a class="navbar-brand" href="#" width="200px"  >
                  <img src="women.png" alt="" class="image-arrondie" >
                </a><br>

                
              </div>--> 
<div>




              <a class="navbar-brand" href="#" width="200px"  >
              
            <% if (user_20 == null || user_20.getPhoto() == null) { %>
            <!-- Si user_20 ou user_20.getPhoto() est null, affichez une image par défaut -->
            <img src="women.png" alt="" class="image-arrondie">
        <% } else { %>
            <!-- Sinon, affichez la photo de l'utilisateur -->
            <img src="imgservlet?id=<%= user_20.getPhoto() %>" alt="" class="image-arrondie">
        <% } %>
        
        </a><br>

                
              </div>
              
             
              
   
            </div>
          </nav>
        </div>
      </div>
    </header>
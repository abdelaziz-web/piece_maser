package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class com_impl implements comment {

	
	
private DAOFactory        daoFactory;
	

    public com_impl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
        
    }
    
	public com_impl() {
		// TODO Auto-generated constructor stub
	}

	 
	  	   private static com map( ResultSet resultSet ) throws SQLException, ParseException {
    	   
           com  com_1 = new com()  ;
           				
           SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

           com_1.setCommentId((int)resultSet.getInt( "comment_id" ));
           com_1.setBlogId((int)resultSet.getInt( "blog_id" ));
    	   com_1.setAuthorId((int)resultSet.getInt( "author_id" ));
    	   com_1.setContent((String)resultSet.getString("content") );
    	   com_1.setCreatedAt( resultSet.getString("created_at")) ;
    	   
    	   
    	
   		   return com_1;
   		}
       
       
   	private static void setCommentId(int int1) {
			// TODO Auto-generated method stub
			
		}

	public static PreparedStatement initRequestPrepare( Connection connexion, String sql, Object... objets ) throws SQLException {
   	    PreparedStatement preparedStatement = connexion.prepareStatement( sql );
   	    for ( int i = 0; i < objets.length; i++ ) {
   	        preparedStatement.setObject( i + 1, objets[i] );
   	    }
   	    return preparedStatement;
   	}


	
	@Override
	public void create(  com com_1 ) throws DAOException {
	
		final String SQL_INSERT = "INSERT INTO  comments (blog_id,content,author_id) VALUES (?,?,?) ;"  ;
			

			Connection connexion = null;
		    PreparedStatement preparedStatement = null;
		   // ResultSet resultSet = null;
		    
		    try {
		        /* Récupération d'une connexion depuis la Factory */
		        connexion = daoFactory.getConnection();
		        preparedStatement = initRequestPrepare( connexion, SQL_INSERT
		        		,com_1.getBlogId()
		        		,com_1.getContent()
		        		,com_1.getAuthorId()
		                 );
		       preparedStatement.execute();
		        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
		        
		    } catch ( SQLException e ) {
		    	
		    	if (e instanceof SQLIntegrityConstraintViolationException) {
		            if (e.getMessage().contains("Duplicate entry")) {
		                // Gérer le cas de duplication, par exemple, afficher un message à l'utilisateur
		               
		            }else {
		            	
		            	throw new DAOException( e );	
		            }
		    	}
		    	} finally {
		    	 //ClosingAll( resultSet, preparedStatement, connexion );	
		    }
	
	}



	
	@Override
	
	public List<com> getAll( int blog_id ){
		
		
		final String SQL_SELECT = "SELECT * FROM comments where blog_id = ? ;" ;
		
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	   
	    ArrayList<com> listecom = new ArrayList<>();
	    
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_SELECT,blog_id);
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        while ( resultSet.next() ) {
	        			
	        	    int comment_id = resultSet.getInt("comment_id");
	        		int author_id = resultSet.getInt("author_id");
	                String content = resultSet.getString("content");
	                String created_at = resultSet.getString("created_at");
	               
	                
	                try {
	                    // Convertir la chaîne en objet Date
	                	Date date = dateFormat.parse(created_at);

	                	String dateAsString = dateFormat.format(date);
	                	
	                	com com_1 = new com(comment_id,blog_id,content,dateAsString ,author_id); 
	 	               
		                listecom.add(com_1) ;  
	                	
	                    // Afficher la date convertie
	                    System.out.println("Date convertie : " + date);
	                } catch (ParseException e) {
	                    // Gérer l'exception en cas d'erreur de conversion
	                    e.printStackTrace();
	                }

	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        //ClosingAll( resultSet, preparedStatement, connexion );
	    }

	 //   int nombreElements = listeInvestisseur.size();
	 //   System.out.println("Le nombre d'éléments dans la liste est : " + nombreElements);
	    
	    return listecom ;
		
		

	}

}

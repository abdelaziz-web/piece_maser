package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import beans.diagno;
import dao.DAOException;

public class diagno_impl {

	

	private DAOFactory        daoFactory;
	

    public diagno_impl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
        
    }
    
	public diagno_impl() {
		// TODO Auto-generated constructor stub
	}

	 
	  	    private static diagno map( ResultSet resultSet ) throws SQLException {
    	   
	  	    	diagno diag = new diagno();

	  	        diag.setId(resultSet.getInt("id"));
	  	        diag.setKg(resultSet.getFloat("kg"));
	  	        diag.setCm(resultSet.getFloat("cm"));
	  	        diag.setScores(resultSet.getFloat("Scores"));
	  	        diag.setDiag(resultSet.getString("diag"));
	  	        diag.setUserId(resultSet.getInt("user_id"));

	  	        return diag;
   		}
       
       
   	public static PreparedStatement initRequestPrepare( Connection connexion, String sql, Object... objets ) throws SQLException {
   	    PreparedStatement preparedStatement = connexion.prepareStatement( sql );
   	    for ( int i = 0; i < objets.length; i++ ) {
   	        preparedStatement.setObject( i + 1, objets[i] );
   	    }
   	    return preparedStatement;
   	}

   	
   
   	public void create(diagno diag) throws DAOException {

   	    final String SQL_INSERT = "INSERT INTO diagno (kg, cm, Scores, diag, user_id) VALUES (?, ?, ?, ?, ?);";

   	    Connection connexion = null;
   	    PreparedStatement preparedStatement = null;

   	    try {
   	        /* Récupération d'une connexion depuis la Factory */
   	        connexion = daoFactory.getConnection();
   	        preparedStatement = initRequestPrepare(
   	                connexion,
   	                SQL_INSERT,
   	                diag.getKg(),
   	                diag.getCm(),
   	                diag.getScores(),
   	                diag.getDiag(),
   	                diag.getUserId()
   	        );

   	        preparedStatement.execute();

   	    } catch (SQLException e) {

   	        if (e instanceof SQLIntegrityConstraintViolationException) {
   	            if (e.getMessage().contains("Duplicate entry")) {
   	                // Gérer le cas de duplication, par exemple, afficher un message à l'utilisateur
   	                System.out.println("La clé unique existe déjà.");
   	            } else {
   	                throw new DAOException(e);
   	            }
   	        }

   	    } finally {
   	        // À adapter en fonction de vos besoins, par exemple, fermer la connexion et les ressources
   	    }
   	}

   	public diagno last_score(int id) throws DAOException {

   	    final String SQL_SELE = "SELECT * FROM diagno WHERE user_id = ? ORDER BY id DESC LIMIT 1;";

   	    Connection connexion = null;
   	    PreparedStatement preparedStatement = null;

	    ResultSet resultSet = null;
	   
	    diagno diag = new diagno();
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_SELE,id );
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        if ( resultSet.next() ) {
	        	diag = map( resultSet );     
	        }else {
	        	diag = null ;
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {

	    }

	    
	    return diag ;
   	    
   	}


	
	
}

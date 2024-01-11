package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import beans.PainTrack;
import beans.diagno;

public class PainTrackDAO {

    private DAOFactory daoFactory;

    public PainTrackDAO(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    private static PainTrack map(ResultSet resultSet) throws SQLException {
        PainTrack painTrack = new PainTrack();

        painTrack.setId(resultSet.getInt("id"));
        painTrack.setTrack(resultSet.getString("track"));
        painTrack.setPainLevel(resultSet.getInt("pain_level"));
        painTrack.setUserId(resultSet.getInt("user_id"));

        return painTrack;
    }

    public static PreparedStatement initRequestPrepare(Connection connexion, String sql, Object... objets)
            throws SQLException {
        PreparedStatement preparedStatement = connexion.prepareStatement(sql);
        for (int i = 0; i < objets.length; i++) {
            preparedStatement.setObject(i + 1, objets[i]);
        }
        return preparedStatement;
    }

    public void create(PainTrack painTrack) throws DAOException {

        final String SQL_INSERT = "INSERT INTO paintrack (track, pain_level, user_id) VALUES (?, ?, ?);";

        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = daoFactory.getConnection();
            preparedStatement = initRequestPrepare(connexion, SQL_INSERT, painTrack.getTrack(),
                    painTrack.getPainLevel(), painTrack.getUserId());

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
            // À adapter en fonction de vos besoins, par exemple, fermer la connexion et les
            // ressources
        }
    }
    
    
    
    
    public List<PainTrack> pain_level(int  user_id) throws DAOException {

        final String SQL_SELE = "SELECT * FROM paintrack WHERE user_id = ?;";
        
   	    Connection connexion = null;
   	    PreparedStatement preparedStatement = null;

	    ResultSet resultSet = null;
	   
	    PainTrack pain = new PainTrack();
	    
	    List<PainTrack> pain_ = new ArrayList<>();
	    
	    List<Integer> pain_level = new ArrayList<>();
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_SELE,user_id );
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        while ( resultSet.next() ) {
	        	pain = map( resultSet );   
	        	pain_.add(pain) ;
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {

	    }

	    
	    return pain_ ;
   	    
        
        
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
}

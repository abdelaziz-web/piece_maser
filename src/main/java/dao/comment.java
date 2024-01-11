package dao;

import java.util.List;



public interface comment {

	public void create(  com com_1 ) throws DAOException;
	
	
	List<com> getAll( int blog_id );
	
}

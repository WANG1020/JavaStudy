package note.factory ;

import note.dao.PersonDao;
import note.dao.noteDao;
import note.dao.impl.PersonDaoImpl;
import note.dao.impl.noteDaoImpl;


public class DAOFactory
{
	public static PersonDao getPersonDAOInstance()
	{
		return new PersonDaoImpl() ;
	}
	public static noteDao getNoteDAOInstance(){
		return new noteDaoImpl();
	}
};
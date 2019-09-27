package note.dao;

import note.vo.person;

public interface PersonDao {
	public boolean login(person person)throws Exception;
	public boolean checkFlag(person person)throws Exception;
	public  void register(person person)throws Exception;
	
	public boolean checkUser(person person)throws Exception;
	public String QueryId(person person)throws Exception;
	public boolean checkUserById(String id)throws Exception;
	public person checkPersonById(String id)throws Exception;
	public void update(String id)throws Exception;
	public String checkPersonImg(person person)throws Exception;
	
} 

package note.dao;

import java.util.List;

import note.util.SplitPage;
import note.vo.Note;

public interface noteDao {
	public void insert(Note note);
	public void update(Note note);
	public void delete(int id);
	public boolean search(int id);
	
	public List<Note> queryAll();
	public List<Note> findAll(int contNow,int pageSize)throws Exception;
	public List<Note> findAll(SplitPage sp)throws Exception;
}

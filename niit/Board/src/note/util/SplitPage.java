package note.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;

import note.factory.DAOFactory;
import note.vo.Note;



public class SplitPage {
	//分页请求时,请求标识参数 
	final public static String FIRSTPAGE="first";//请求第一页 
	final public static String PREVIOUSEPAGE="previous";//请求上一页 
	final public static String NEXTPAGE="next";//请求下一页 
	final public static String LASTPAGE="last";//请求最后一页


	private int pageRows=3;//每页显示记录数,默认10条,可以在页面设置
	private int totalRows=0;//总的记录数,这个参数由NoteDAO对象提供 
	private int currentPage=1;//当前显示的页面编号,默认第一页 
	private int firstPage=1;//首页位置,默认第一页 
	private int totalPages=1;//总的页面数量,默认就一页

	public SplitPage() {
	}
	//实现属性方法（共10个 ）
	public int getPageRows() {
		return pageRows;
	}
	public void setPageRows(int pageRows) {
		if(pageRows==0)throw new ArithmeticException();
		this.pageRows = pageRows;//如果pageRows被设置为零,应当抛出异常. 
        //修改每页显示记录数,将会直接影响总页面数,所以要同时修改 
        this.totalPages=(this.totalRows%this.pageRows==0)?this.totalRows/this.pageRows:this.totalRows/this.pageRows+1; 
	}
	public int getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
		//计算总的页面数(或最后的页面号),两个整数相除如果刚好除尽,值就是相除后的商,否则如果有余数,商应当还加1. 
        this.totalPages=(this.totalRows%this.pageRows==0)?this.totalRows/this.pageRows:this.totalRows/this.pageRows+1; 
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getFirstPage() {
		return firstPage;
	}
	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}
	public int getTotalPages() {
		return totalPages;
	}
	/*public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}*/
	//核心方法,实现分页显示功能. Flag为请求标识参数
	public List<Note> pageContent(){
		List<Note> lists=new ArrayList<Note>();
		try{
			lists=DAOFactory.getNoteDAOInstance().findAll((this.getCurrentPage()-1)*this.getPageRows(),this.getPageRows());
		}catch(Exception e){
			e.printStackTrace();
		}
		return lists;
	}
	public int confirmPage(String flag){
		try{
			this.setTotalRows(DAOFactory.getNoteDAOInstance().queryAll().size());
			int pageCount=this.getTotalRows()%this.getPageRows()==0?this.getTotalRows()/this.getPageRows():this.getTotalRows()/this.getPageRows()+1;
			/*this.setTotalPages(pageCount);*/
		}catch(Exception e){
			e.printStackTrace();
		}
		int s_currentPage=0;
		if(flag!=null){
			if(flag.equals(SplitPage.FIRSTPAGE)){
				s_currentPage=1;
			}
			else if(flag.equals(SplitPage.LASTPAGE)){
				s_currentPage=this.getTotalPages();
			}
			else if(flag.equals(SplitPage.PREVIOUSEPAGE)){
				s_currentPage=this.getCurrentPage()-1;
			}
			else if(flag.equals(SplitPage.NEXTPAGE)){
				s_currentPage=this.getCurrentPage()+1;
			}else{//还需要判断是否为数字
				s_currentPage=Integer.parseInt(flag);
			}
		}else{
			s_currentPage=this.getCurrentPage();
		}
		this.setCurrentPage(s_currentPage);//如果进入的是list_notes.jsp留言板界面，那么这句要删除
		return s_currentPage;
	}
}

package note.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import note.factory.DAOFactory;
import note.vo.Note;

/**
 * Servlet implementation class insertNotes
 */
@WebServlet("/insertNotes")
public class insertNotes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertNotes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		String title=request.getParameter("note_title");
		String content=request.getParameter("note_content");
		System.out.println("内容"+content);
		HttpSession session=request.getSession();
		String author=(String) session.getAttribute("username");
		
		Note note=new Note();
		note.setTitle(title);
		note.setAuthor(author);
		note.setContent(content);
		
		try{
			DAOFactory.getNoteDAOInstance().insert(note);
			out.print("添加留言成功！！将在6秒后自动跳转留言表页面。<br>您也可以点击<a href=admin/insert.jsp>点此链接</a>跳转留言表页面！");
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.print("添加留言失败！！将在6秒后自动跳转留言表页面。<br>您也可以点击<a href=admin/insert.jsp>点此链接</a>跳转留言表页面！");
		}
		response.setHeader("refresh", "6;URL=../list_notes1.jsp");
	}

}

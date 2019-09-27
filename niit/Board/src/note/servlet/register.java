package note.servlet;

import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import note.factory.DAOFactory;
import note.util.Mail;
import note.vo.person;
import sun.security.action.PutAllAction;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("username");
		String password=request.getParameter("password1");
		String email=request.getParameter("email");
		String img=request.getParameter("imgsrc");
	
		person person=new person();
		person.setUserName(name);
		person.setPassword(password);
		person.setEmail(email);
		if(img==null){
			img="img/头像1.png";
		}
		person.setImage(img);
		person.setFlag(0);
		person.setActive(0);
		
		try {
			if(!DAOFactory.getPersonDAOInstance().checkUser(person)){
				DAOFactory.getPersonDAOInstance().register(person);
				person.setId(Integer.parseInt(DAOFactory.getPersonDAOInstance().QueryId(person)));
				new Mail(person);
				
				int i=email.indexOf("@");
				out.println("注册成功！邮件将发送至您的邮箱");
				out.println("<a href='http://mail.'+email.substring(i+1)+''>点击发送邮件</a>");
				
				/*JOptionPane.showMessageDialog(null, "插入成功！");*/
				/*System.out.println("验证成功！");*/
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

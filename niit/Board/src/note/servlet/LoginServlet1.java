package note.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.security.auth.login.FailedLoginException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import note.dao.PersonDao;
import note.dao.impl.PersonDaoImpl;
import note.factory.DAOFactory;
import note.vo.person;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet1")
public class LoginServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static  int number=0;//全局变量计算访客人数
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet1() {
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
		
		String name=request.getParameter("username");
		String password=request.getParameter("password");
		String flag=request.getParameter("flag");
		//验证验证码是否匹配
		String checkcode=request.getParameter("check");
		HttpSession session=request.getSession();
		String rightcode=(String)session.getAttribute("rand");
		//验证输入用户名密码是否在表中
		person person=new person();
		person.setUserName(name);
		person.setPassword(password);
		person.setFlag(Integer.parseInt(flag));
		number++;
		/*PersonDao personDao=new PersonDaoImpl();*/
		try {
			if(!DAOFactory.getPersonDAOInstance().checkFlag(person)){
				if(DAOFactory.getPersonDAOInstance().login(person)&&checkcode.equals(rightcode)){			
					HttpSession hs=request.getSession(true);
					hs.setMaxInactiveInterval(60);
					hs.setAttribute("username",name);
					hs.setAttribute("upass", password);
					//flag为1的话为true,为0的话是false
					hs.setAttribute("flag", DAOFactory.getPersonDAOInstance().checkFlag(person));
					/*request.getRequestDispatcher("admin/login_sucess.jsp").forward(request, response);*/
					hs.setAttribute("fkNumber",number);
					response.sendRedirect("admin/login_sucess.jsp");
				}else{
					response.sendRedirect("admin/login_fail.jsp");
				}
			}else{
				out.print("您是管理员！！");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

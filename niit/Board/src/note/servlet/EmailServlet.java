package note.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import javafx.scene.control.Alert;
import note.factory.DAOFactory;
import sun.security.action.PutAllAction;

/**
 * Servlet implementation class EmailServlet
 */
@WebServlet("/EmailServlet")
public class EmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		String sactive=request.getParameter("active");
		int active=Integer.parseInt(sactive);
		
		System.out.println("id为"+id);
		System.out.println("active为"+active);
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<body><center><h3>");
		try {
			if(DAOFactory.getPersonDAOInstance().checkUserById(id)){
				if(DAOFactory.getPersonDAOInstance().checkPersonById(id).getActive()==active){
					/*JOptionPane.showMessageDialog(null, 注册);*/
					DAOFactory.getPersonDAOInstance().update(id);
					out.print("账号激活成功！<a href='http://localhost:8086/Board/admin/login.htm'>请登录</a>");
				}else{
					out.print("账号已激活，链接失效！<a href='http://localhost:8086/Board/admin/login.htm'>请登录</a>");
				}
			}else{
				out.println("账号激活失败！<a href='register.jsp'>请重新注册</a>");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

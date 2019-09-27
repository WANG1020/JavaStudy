package note.util;

import javax.mail.*;
import javax.mail.internet.*;

import note.vo.person;

import javax.activation.*;
import java.util.*;



/**\
 * 
 * 使用JavaMail发送邮件
 *
 */
public class Mail {
	public Mail(person  person) {
		try {
			// 获得属性，并生成Session对象
			Properties props = new Properties();
			Session sendsession;
			Transport transport;
			sendsession = Session.getInstance(props, null);
			// 向属性中写入SMTP服务器的地址
			props.put("mail.smtp.host", "smtp.qq.com");
			// 设置SMTP服务器需要权限认证
			props.put("mail.smtp.auth", "true");
			//MyAuthenticator myauth = new MyAuthenticator("workniit@163.com", "99081035c");
			// 设置输出调试信息
			sendsession.setDebug(true);
			// 根据Session生成Message对象
			Message message = new MimeMessage(sendsession);
			// 设置发信人地址
			message.setFrom(new InternetAddress("1647088054@qq.com"));
			// 设置收信人地址
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(person.getEmail()));
			// 设置e-mail标题
			message.setSubject("您好！感谢您注册！");
			// 设置e-mail发送时间
			message.setSentDate(new Date());
			// 设置e-mail内容			
			message.setContent(person.getUserName()+"：请经常访问本网站！" +
					"  <br><a href='http://localhost:8086/Board/EmailServlet?id="+person.getId()+"&active="+person.getActive()+"'>请点击激活帐号</a>", "text/html;charset=UTF-8");
			//message.setContent(person.getName()+"：恭喜您注册成功！请经常访问本网站！" +
			//		"  <br><script type='text/javascript'>function goToClient(){window.location.href='verify.jsp?id="+person.getId()+";} </script>"+ 
            //"<a href='#' onclick='javascript:goToClient();'>请点击激活帐号</a> ", "text/html;charset=gbk");
			// 保存对于Email.的修改
			message.saveChanges();
			// 根据Session生成Transport对象
			transport = sendsession.getTransport("smtp");
			// 连接到SMTP服务器
			transport.connect("smtp.qq.com", "1647088054", "dyhabbdkbetnbagc");// !!!!!******注意修改************
			// 发送e-mail
			transport.sendMessage(message, message.getAllRecipients());
			// 关闭Transport连接
			transport.close();

		} catch (MessagingException me) {
			me.printStackTrace();
		}

	}

}

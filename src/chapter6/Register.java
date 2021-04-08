package chapter6;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register extends DBServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4338721939318093544L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.service(request, response);
		
		String userName = null;
		if(request.getParameter("login")!=null){
			response.sendRedirect("login.jsp");
			return;
		}
		
		try{
			userName = request.getParameter("userName");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			String validationCode = request.getParameter("validation_code");
			if(userName==null||password==null||validationCode==null)
				return;
			if(userName.equals("")||password.equals(""))
				return;
			userName = new String(userName.getBytes("ISO-8859-1"),"UTF-8");
			request.setAttribute("page", "register.jsp");
			if(!checkValidationCode(request, validationCode)){
				return;
			}
			email = (email==null)?"":email;
			String passwordMD5 = Encrypter.md5Encrypt(password);
			String sql = "insert intol"
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

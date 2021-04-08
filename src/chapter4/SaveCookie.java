package chapter4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SaveCookie
 */
@WebServlet(
		urlPatterns = { "/servlet/SaveCookie" }, 
		initParams = { 
				@WebInitParam(name = "SaveCookie", value = "chapter4.SaveCookie")
		})
public class SaveCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveCookie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Hello JAVA");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.service(request,response);
		response.setContentType("text/html;charset=GBK");
		PrintWriter out = response.getWriter();
		
		Cookie tempCookie = new Cookie("temp","876543121");
		response.addCookie(tempCookie);
		
		Cookie cookie = new Cookie("cookie","666");
		cookie.setMaxAge(0);
		
		response.addCookie(cookie);
		
		String user = request.getParameter("user");
		if(user!=null){
			Cookie userCookie = new Cookie("user",user);
			userCookie.setMaxAge(60*60*24);
			userCookie.setPath("/");
			response.addCookie(userCookie);
		}
		
		RequestDispatcher readCookie = getServletContext().getRequestDispatcher("/servlet/ReadCookie");
		readCookie.include(request, response);
	}

}

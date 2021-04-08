package chapter4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReadCookie
 */
@WebServlet(urlPatterns = { "/servlet/ReadCookie" }, initParams = {
		@WebInitParam(name = "ReadCookie", value = "chapter4.ReadCookie") })
public class ReadCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReadCookie() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected Cookie getCookieValue(Cookie[] cookies, String name) {
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals(name)) {
					return c;
				}
			}
		}
		return null;
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=GBK");
		PrintWriter out = response.getWriter();
		Cookie tempCookie = getCookieValue(request.getCookies(), "temp");
		if (tempCookie != null) {
			out.println("临时Cookie值:" + tempCookie.getValue() + "<br/>");
		} else {
			out.println("临时Cookie值未设置!");
		}
		
		Cookie cookie = getCookieValue(request.getCookies(), "cookie");
		if (cookie != null) {
			out.println("cookie值:" + cookie.getValue() + "<br/>");
		} else {
			out.println("cookie值未设置!");
		}
		
		Cookie userCookie = getCookieValue(request.getCookies(), "user");
		if (userCookie != null) {
			out.println("user值:" + userCookie.getValue() + "<br/>");
		} else {
			out.println("user值未设置!");
		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

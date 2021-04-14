package chapter7.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.opensymphony.xwork2.ActionContext;

import chapter7.dao.BookDAO;

public class QueryAction {
	
	public String execute() throws Exception{
		try{
			HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
			String name = request.getParameter("name");
			BookDAO book = new BookDAO();
			Map<String,Integer> books = book.getBooks(name);
			request.setAttribute("result", books);
			return "result";
			
		}catch(Exception e){
			return "error";
		}
	}
}

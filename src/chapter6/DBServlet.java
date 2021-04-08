package chapter6;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class DBServlet
 */
@WebServlet("/servlet/DBServlet")
public class DBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected Connection conn = null;
       
	//执行各种SQL语句的方法
	protected ResultSet execSQL(String sql,Object ... args) throws Exception{
		PreparedStatement pStmt = conn.prepareStatement(sql);
		for(int i = 0;i<args.length;i++){
			pStmt.setObject(i+1,args[i]);
		}
		pStmt.execute();
		return pStmt.getResultSet();
	}
	
	//核对用户输入的验证码是否合法
	protected boolean checkValidationCode(HttpServletRequest requset,String validationCode){
		String validationCodeSession = (String)requset.getSession().getAttribute("validation_code");
		if(validationCodeSession == null){
			requset.setAttribute("info", "验证码过期");
			requset.setAttribute("codeError", "验证码过期");
			return false;
		}
		
		if(!validationCode.equalsIgnoreCase(validationCodeSession)){
			requset.setAttribute("info", "验证码不正确");
			requset.setAttribute("codeError", "验证码不正确");
			return false;
		}
		
		return true;
		
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			if(conn == null){
				Context ctx = new InitialContext();
				DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/webdb");
				conn = ds.getConnection();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DBServlet() {
        super();
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
		doGet(request, response);
	}
	
	@Override
	public void destroy() {
		super.destroy();
		try{
			if(conn!=null){
				conn.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}

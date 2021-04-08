package chapter4;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ViewDictionary
 */
@WebServlet("/ViewDictionary")
public class ViewDictionary extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewDictionary() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try{
			javax.naming.Context ctx=  new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/webdb");
			Connection conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from t_dictionary");
			
			ResultSet rs = pstmt.executeQuery();
			StringBuilder table = new StringBuilder();
			table.append("<table border = '1'>");
			table.append("<tr><td>书名</td><td>价格</td></tr>");
			while(rs.next()){
				table.append("<tr><td>"+rs.getString("english")+"</td><td>");
				table.append(rs.getString("chinese")+"</td></tr>");
			}
			table.append("</table>");
			out.println(table.toString());
			pstmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

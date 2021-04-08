<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%!
  static 
  {
	System.out.println("正在装载由JSP生成的Servlet!");
  }

   private int globalCount = 0;
   
  public void jspInit()
  {
	  System.out.println("正在初始化JSP");
  }
  
  public void jspDestory()
  {
	  System.out.println("JSP已经销毁");
  }

%>
<title>Insert title here</title>
</head>
<body>

localCount:
<%
  int localCount = 0;
  out.println(++localCount);
%>
<br>

globalCount:<%=++globalCount %>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 导入相应的包 -->
<%@page import="java.text.*,java.util.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <font color="red">
  <%
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
    out.println(format.format(new Date()));
     
  %>
 
 </font>
</body>
</html>
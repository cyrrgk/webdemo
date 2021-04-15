<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Result</title>
</head>
<body>
<table>
 <tr>
   <td>书名</td>
   <td>价格</td>
 </tr>
 <%
   Map<String,Integer> result = (Map<String,Integer>)request.getAttribute("result");
   for(Map.Entry<String,Integer> entry:result.entrySet()){
 %>
 <tr>
   <td><%= entry.getKey() %></td>
   <td><%= entry.getValue() %></td>
 
 </tr>
 <%} %>

</table>

</body>
</html>
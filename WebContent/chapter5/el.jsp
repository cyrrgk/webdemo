<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在JSP中使用EL</title>
</head>
<body>
<form method="post">
 &nbsp;key:
 <p>
 <input type="text" name = "key"/>
 <p>
 value:
 <input type="text" name = "value"/>
 <p>
 <input type="submit" value = "提交">
 <p>
</form>
 &nbsp;key:${param.key}
 <p>
   value:${param.value}
   <jsp:useBean id="t" class="java.util.Date" scope="request"/>
 <p>
   自1970年1月1日00:00:00GMT到现在的秒数:${t.time}
 <p>
</body>
</html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Feedback Page</title>
   <script type="text/javascript" src="<%=path %>/js/jquery-3.1.1.js"></script>  

  </head>
  
  <body>
    This is my JSP page. <br>
    Name:${param.name }age:${param.age }
  </body>
</html>

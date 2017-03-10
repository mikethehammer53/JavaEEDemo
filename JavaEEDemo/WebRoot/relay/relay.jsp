<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>relay</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
	var  err='<%=request.getParameter("err")%>';
	//var err=p1+"";
	switch(err){
	case "1":alert("没有访问权限,请登录");window.location="login.jsp";break;
	case "2":alert("该用户名已注册,请重试");break;
	case "3":alert("验证码错误");break;
		
	};








</script>	
	


  </head>
  
  <body>
  ghjhgghj
  <br>
  </body>
</html>

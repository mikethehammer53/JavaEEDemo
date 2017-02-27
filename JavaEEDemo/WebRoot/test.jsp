<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <script type="text/javascript" src="./js/ajaxtest.js"></script>
    <title>Test Page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <input type="button" value="ajax test"
							onclick='
								var container=document.getElementById("view");
						sendRequest("<%=path %>/test.jsp", "POST", null, container)
							'
						>
	<div id="view"></div>
	<input type="button" value="json test"
		onclick='
			var container=document.getElementById("jsonview");
			sendRequest("<%=path %>/json.do?"+Math.random(), "GET", null, container)
		'>
		
	
	<form action="<%=path %>/CommonFileUpload" method="post" enctype="multipart/form-data">
		User:<input type="text" name="name"><br>
		File Upload:<input type="file" name="file"><br>
		<input type="submit" value="submit"/>
	</form>
	<a href="<%=path%>/download.do">download test</a>
  </body>
</html>

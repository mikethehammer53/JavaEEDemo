<%@page import="readwrite.FileProcess"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="xml" uri="http://java.sun.com/jsp/jstl/xml" %> --%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+
"://"+request.getServerName()+
":"+request.getServerPort()+path+"/";
//out.write(""+10/0);
Object obj=application.getAttribute("AccessCount");
int count=0;
String str="张三,李四,王二麻子";
pageContext.setAttribute("str", str);

/* String str;
boolean flag=true;
System.out.println(str=FileProcess.read("e:/viewcount.txt"));
for(int i=0;i<str.length();i++){
	if(!Character.isDigit(str.charAt(i))||str.equals("")){
		System.out.println("文件内容不是纯数字!");
		flag=false;
		return;
	}
}
if(flag){
	count=Integer.parseInt(str);
}
else{
	count=0;
} */

if(obj==null){
	application.setAttribute("AccessCount", 1);
}
else{
	count=(int)obj;
	if(session.isNew()){
		count++;
		FileProcess.write("e:/viewcount.txt", count);
	}
	application.setAttribute("AccessCount", count);
}
if(session.getAttribute("LoggedUser")==null){
	response.sendRedirect("login.jsp");
}

Calendar cal=Calendar.getInstance();
int week=cal.get(Calendar.DAY_OF_WEEK);
pageContext.setAttribute("week",week);


%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
  	EL方法: 访问量:${AccessCount} <br>
  	访问量:<%=application.getAttribute("AccessCount") %> <br>
 	<h1>使用forTokens</h1>
 	<jstl:forTokens items="${str }" delims="," var="sss">
 		<jstl:out value="${sss }"/><br>
 	</jstl:forTokens>
 	<jstl:choose>
 		<jstl:when test="${week==1 }">
 			<jstl:out value="星期天"/><br>
 		</jstl:when>
 		<jstl:when test="${week==2 }">
 			<jstl:out value="星期一"/><br>
 		</jstl:when>
 		<jstl:when test="${week==3 }">
 			<jstl:out value="星期二"/><br>
 		</jstl:when>
 		<jstl:when test="${week==4 }">
 			<jstl:out value="星期三"/><br>
 		</jstl:when>
 		<jstl:when test="${week==5 }">
 			<jstl:out value="星期四"/><br>
 		</jstl:when>
 		<jstl:when test="${week==6 }">
 			<jstl:out value="星期五"/><br>
 		</jstl:when>
 		<jstl:when test="${week==7 }">
 			<jstl:out value="星期六"/><br>
 		</jstl:when>
 		<jstl:otherwise>
 			<jstl:out value="ERROR"/><br>
 		</jstl:otherwise>
 	</jstl:choose>
  </body>
</html>

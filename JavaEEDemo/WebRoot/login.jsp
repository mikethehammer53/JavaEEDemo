<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title><fmt:message key="login.title"/></title>
	<link rel="stylesheet" type="text/css" href="./CSS/Center.css">
	<script type="text/javascript" src="./js/ajaxtest.js"></script>
  </head>
  <body>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	
	<c:choose>
		<c:when test='${param.lang=="CN"}'>
			<fmt:setLocale value="zh_CN" scope="session"/>
		</c:when>
		<c:when test='${param.lang=="US"}'>
			<fmt:setLocale value="en_US" scope="session"/>
		</c:when>
	</c:choose>
	<fmt:setBundle basename="message" scope="session"/>
		<form action="log.do" method="post" enctype="application/x-www-form-urlencoded">
				<table style="width:300px">
					<tr>
						<td colspan="2" align="center" >
						<h1><fmt:message key="login.title"/></h1>
						</td>
					</tr>
					<tr >
						<td>
							<fmt:message key="login.lblname"/>:
						</td>
						<td><input id="uid" name="name" type="text" style="width:100%"
							value="<%=request.getAttribute("username")==null?"":request.getAttribute("username")%>"></td>
					</tr>
					<tr>
						<td>
						<fmt:message key="login.lblpwd"/>：
						&nbsp;&nbsp;</td>
						<td><input id="pid" name="pwd" type="password" style="width:100%"></td>
						
					</tr>
					<tr>
						<td>
							<fmt:message key="login.check"/>：</td>
						<td>
							<input id="checkcode" name="checkcode" type="text">
						</td>
						<td>
							<img alt="验证码"  src="<%=path %>/checkCode.do" 
								onclick="this.src='<%=path %>/checkCode.do?'+Math.random()" style="cursor: pointer;width: 60px;height: 20px;">
						</td>
					</tr>
					<tr >
						<td colspan="3" align="center">
						<input type="button" value="<fmt:message key='login.cancel'/>">
						<input type="submit" value="<fmt:message key="login.submit"/>" >
						<input type="reset" value="<fmt:message key="login.reset"/>" onclick="reset()">
						<input type="button" 
							onclick='
								var data="";
								data+="name="+document.getElementById("name").value;
								data+="&pwd="+document.getElementById("pwd").value;
								data+="&checkCode"+document.getElementById("checkCode").value;
								alert(data);
								var url="<%=path %>/login.do";
								var mrthod="POST";
								var container=document.getElementById("view");
								sendRequest(url,method,data,container);
								'
								value="test">
						<input type="button" value="ajaxtest"
							onclick='
								var container=document.getElementById("view");
						sendRequest("<%=path %>/login.jsp", "POST", null, container)
							'
						
						>
						</td>
					</tr>
				</table>
		</form>
		<a href="login.jsp?lang=CN" >中文</a>
		<a href="login.jsp?lang=US" >English</a>
		<div>
			<%=request.getAttribute("LoginError")==null?"":request.getAttribute("LoginError") %>
		</div>	
		<div id="view" style="border: 1px solid #ff0000;display:none"></div>
  </body>
</html>

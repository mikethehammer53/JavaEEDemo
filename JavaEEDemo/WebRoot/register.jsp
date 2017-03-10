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
    
    <title><fmt:message key="register.title"/></title>
	<link rel="stylesheet" type="text/css" href="./CSS/Center.css">
	<script type="text/javascript" src="./js/ajaxtest.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery-3.1.1.js"></script>
	<!-- <script type="text/javascript" src="./js/jquery.validate.js"></script> -->
	<script type="text/javascript" src="./js/localization/messages_zh.js"></script>
	<script type="text/javascript" src="./js/RegValidate.js"></script>
	
	<script type="text/javascript">

		$(function(){
			$("#commentForm").validate();
		});
		
		$id=function(id){
			return document.getElementById(id);
		};
		$names=function(name){
			return document.getElementByName(name);
		};
		
	
	</script>
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
	<div style="border: solid 1px black;width:40%;" align="right">
	<fmt:setBundle basename="message" scope="session"/>
		<form id="commentForm" action="reg.do" method="post" enctype="application/x-www-form-urlencoded">
				<table>
					<tr><th>
						<td colspan="1" align="center" >
						<h1><fmt:message key="register.title"/></h1>
						</td>
					</tr>
					<tr >
						<td>
							<fmt:message key="login.lblname"/>:
						</td>
						<td><input id="uid" name="name" type="text"  required="required" minlength="5" maxlength="10"
							value="<%=request.getAttribute("name")==null?"":request.getAttribute("name")%>"
							></td>
							<td >
								<label id="nameerr" style="color: #ff0000"></label>
								<label id="nameexisted" style="color: red">${userExistErr }</label>
							</td>
					</tr>
					<tr>
						<td>
							<fmt:message key="register.email"></fmt:message>
						</td>
						<td>
							<input id="umail" name="email" type="text"  required="required" >
						</td>
							<td ><label id="mailerr" style="color: red"></label></td>
					</tr>
					<tr>
						<td>
							<fmt:message key="login.lblpwd"/>：
							&nbsp;&nbsp;
						</td>
						<td>
							<input id="pid" name="password" type="password"  required="required" minlength="6" maxlength="20">
						</td>
						<td>
							<label id="pwderr" style="color: red"></label>
						</td>
					</tr>
					<tr>
						<td>
							<fmt:message key="register.comfirmpwd"/>:
						</td>
						<td>
							<input id="comfirmpwd" name="password2" type="password"  required="required" minlength="6" maxlength="20">
						</td>
						<td>
							<label id="pwdcfmerr" style="color: red">${cfmpwderr }</label>
						</td>
					</tr>
					<tr>
						<td>
							<fmt:message key="login.check"/>：
						</td>
						<td>
							<input id="verifycodeid" name="verifycode" type="text">
						</td>
						<td width="60px" height="20px">
							<img alt="验证码"  src="<%=path %>/checkCode.do" 
								onclick="this.src='<%=path %>/checkCode.do?'+Math.random()" style="cursor: pointer;width: 60px;height: 20px;">
						</td>
						<td>
							<label id="verifycodeerr" style="color: red">${verifyCodeErr }</label>
						</td>
					</tr>
					<tr >
						<td colspan="3" align="center">
						<input type="button" value="<fmt:message key='login.cancel'/>">
						<input id="subbtn" type="submit" value="<fmt:message key="login.submit"/>" disabled>
						<input type="reset" value="<fmt:message key="login.reset"/>" onclick="reset()">
						<%-- <input type="button" 
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
						> --%>
						</td>
					</tr>
				</table>
		</form>
		<a href="register.jsp?lang=CN" >中文</a>
		<a href="register.jsp?lang=US" >English</a>
		<div>
			<%=request.getAttribute("LoginError")==null?"":request.getAttribute("LoginError") %>
		</div>	
		<div id="view" style="border: 1px solid #ff0000;display:none"></div>
		</div>
  </body>
</html>

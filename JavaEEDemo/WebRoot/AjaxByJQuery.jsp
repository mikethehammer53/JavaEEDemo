<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>AjaxByJQuery</title>
    <script type="text/javascript" src="<%=path %>/js/jquery-3.1.1.js"></script>
    <script type="text/javascript">
    $(function(){
    	$("#btnReqPage").on("click",function(){
    		$.ajax({
    			type:"GET",
    			url:"feedback.jsp",
    			cache:false,
    			data:"name=jack&age=7",
    			context:$("#pageContent"),
    			success:function(data,textStatus,xhr){
    				alert(xhr);
    				$("#pageContent").html(data+textStatus);
    			},
    			complete:function(xhr,textStatus){
    				alert("Complete:"+textStatus);
    			},
    		});
    	});
    	$("#btnReqScr").on("click",function(){
    		$.get("a.js",function(data){
    			$("#scriptConetnt").html(data);
    		},"script");
    	});
    });
    </script>

  </head>
  <input type="button" id="btnReqPage" value="request a page"><br>
  <input type="button" id="btnReqScr" value="request a script"><br>
  <div id="pageContent"></div>
  <div id="scriptConetnt"></div>
  <body>
  </body>
</html>

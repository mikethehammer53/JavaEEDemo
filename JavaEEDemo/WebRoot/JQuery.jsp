<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>JQuery</title>
    <style type="text/css">
    	.mouseOn{
    		background-color: red;
    	}
    	.mouseOnTh{
    		background-color: blue
    	}
    
    </style>
    <script type="text/javascript" src="<%=path %>/js/jquery-3.1.1.js"></script>
	<script type="text/javascript">
	var msg="<div style='color: red'>message</div>";
	$(function() {
		$("#a1").on("click",function(){
			$("#a1").css("display","none")
					.after("&nbsp;");
			$("#a2").css("display","");
		});
	});
	$(function() {
		$("#a2").on("click",function(){
			$("#a1").css("display","");
			$("#a2").css("display","none")
					.before("&nbsp;");
		});
	});
	/* $(document).on("click",function(){
		alert(event.pageX+":"+event.pageY);
	}); */
	$(function(){
		$("td").hover(
			function(){
				$(this).addClass("mouseOn");
				},
			function(){
				$(this).removeClass("mouseOn");
				}
		);
		$("th").hover(
				function(){
					$(this).addClass("mouseOnTh");
					},
				function(){
					$(this).removeClass("mouseOnTh");
					}
			);
	});
	function change(){
  		var select=document.getElementById("select");
  		var value=select.options[select.options.selectedIndex].value;
  		switch (value){
  		case "1":
  			alert($(".c1").length);
  			break;
  		case "2":
  			$("#span1").prependTo($("#span2"));
  			break;
  		case "3":
  			$("#span1").before($("#span3"));
  			break;
  		case "4":
  			$("p").replaceWith("<lable style='color: red'>replaced</lable>");
  			break;
  		case "5":
  			$("div").empty();
  			break;
  		case "6":
  			$("p").after($("div").clone());
  			break;
  		case "7":
  			$("#test").after(msg);
  			break;
  		}
  	}
  	</script>
	
  </head>
  <body>
  	<div>JQuery test</div><br>
  	<select id="select" onchange="change();">
  	<option value="1">Change Div</option>
  	<option value="2">Append</option>
  	<option value="3">Outter Append</option>
  	<option value="4">Replace</option>
  	<option value="5">Empty</option>
  	<option value="6">Clone</option>
  	<option value="7">Change Style</option>
  	</select><br>
  	<div id="div1" class="c1" style="border: 1px solid;color: red">div1</div>
  	<div id="div2" class="c2" style="border: 1px solid;color: orange">div2</div>
  	<div id="div3" class="c3" style="border: 1px solid;color: black">div3</div>
  	<span id="span1" class="c1" style="border: 1px solid;color: green">span1</span>
  	<span id="span2" class="c1" style="border: 1px solid;color: blue">span2</span>
  	<span id="span3" style="border: 1px solid;color: purple">span3</span>
  	<br>
  	<p id="p1">p1</p>
  	<a id="a1" href="javascript:void()" style="color: red">a1</a>
  	<a id="a2" href="javascript:void()" style="color: green;display: none">a2</a>
  	<div id="test">test div</div>
  	
  	<table border="1">
  		<tr>
  			<th></th>
  			<th>Line 1</th>
  			<th>Line 2</th>
  			<th>Line 3</th>
  			<th>Line 4</th>
  			<th>Line 5</th>
  		</tr>
  		<tr>
  			<td>Row 1</td>
  			<td>1,1</td>
  			<td>1,2</td>
  			<td>1,3</td>
  			<td>1,4</td>
  			<td>1,5</td>
  		</tr>	
  	<tr>
  			<td>Row 2</td>
  			<td>2,1</td>
  			<td>2,2</td>
  			<td>2,3</td>
  			<td>2,4</td>
  			<td>2,5</td>
  		</tr>	
  		<tr>
  			<td>Row 3</td>
  			<td>3,1</td>
  			<td>3,2</td>
  			<td>3,3</td>
  			<td>3,4</td>
  			<td>3,5</td>
  		</tr>	
  		<tr>
  			<td>Row 4</td>
  			<td>4,1</td>
  			<td>4,2</td>
  			<td>4,3</td>
  			<td>4,4</td>
  			<td>4,5</td>
  		</tr>	
  		<tr>
  			<td>Row 5</td>
  			<td>5,1</td>
  			<td>5,2</td>
  			<td>5,3</td>
  			<td>5,4</td>
  			<td>5,5</td>
  		</tr>	
  	</table>
  	
  </body>
</html>

function createRequest(){
	var req=null;
	try{
		req=new XMLHttpRequest();
	}
	catch(e){
		try{
			req=new ActiveXObject("Microsoft.XMLHTTP");
		}
		catch(e){
			alert("AJAX NOT SUPPORTTED");
		}
	}
	return req;
}

function sendRequest(url,method,data,container){
	var req=createRequest();
	req.open(method, url, true);
	req.setRequestHeader("enctype", "application/x-www-form-urlencoded");
	req.onreadystatechange=function(){
		/*if(req.readyState==4&&req.status==200){
			container.innerHTML=req.responseText;
			container.style.display="";
		}*/
		if(req.readyState==4&&req.status==200){
			var rdata=req.responseText;
			alert(rdata);
			var json=JSON.parse(rdata);
			container.firstChild.innerHTML=json.user.name;
			container.lastChild.innerHTML=json.phone;
			container.style.display="";
		}
	};
	req.send(data);
}
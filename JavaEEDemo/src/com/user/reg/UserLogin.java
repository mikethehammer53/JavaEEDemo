package com.user.reg;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserLogin {
	private HttpServletRequest request;
	private HttpServletResponse response;
	public UserLogin() {
		
	}
	public UserLogin(HttpServletRequest request,
			HttpServletResponse response)
				throws ServletException{
		this.request=request;
		this.response=response;
	}
	public void doService(){
		
	}
}

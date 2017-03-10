package com.user.reg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbProcess.InsertSQL;
import dbProcess.UserCheck;


public class LoginServlet extends HttpServlet {

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)resp;
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String verifyCode=request.getParameter("verifycode");
		verifyCode=verifyCode.toLowerCase();
		Object obj=request.getSession().getAttribute("verifycode");
		String trueVerifyCode=obj.toString();
		trueVerifyCode=trueVerifyCode.toLowerCase();
		RequestDispatcher rd2register=request.getRequestDispatcher("register.jsp");
		RequestDispatcher rd2login=request.getRequestDispatcher("login.jsp");
		RequestDispatcher rd2success=request.getRequestDispatcher("main.jsp");
		if(trueVerifyCode.equals(verifyCode)){
			UserCheck UserCheck=new UserCheck();
			//user not existed
			if(!UserCheck.existcheck(name)){
				req.setAttribute("name", name);
				req.setAttribute("userExistErr", "用户尚未注册");
				rd2register.forward(req, resp);
			}
			else{
				//check password
				if(UserCheck.pwdcheck(name, password)){
					PrintWriter out=response.getWriter();
					out.write("<script type='javascript/text'>alert('注册成功');</script>");
					HttpSession session=req.getSession();
					session.setAttribute("LoggedUser", name);
					resp.sendRedirect("main.jsp");
					
				}
			}
		}
		else{
			//verify code error
			request.setAttribute("verifyCodeErr", "验证码错误");
			rd2login.forward(request, response);
		}
	}
	

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}

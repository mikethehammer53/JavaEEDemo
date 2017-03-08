package com.user.reg;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import process.InsertSQL;
import process.UserCheck;

public class RegisterServlet extends HttpServlet {

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

		System.out.println("RegisterServlet doPost方法");
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)resp;
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String verifyCode=request.getParameter("verifycode");
		Object obj=request.getSession().getAttribute("verifycode");
		String trueVerifyCode=obj.toString();
		RequestDispatcher rd=request.getRequestDispatcher("register.jsp");
		if(trueVerifyCode.equals(verifyCode)){
			UserCheck UserCheck=new UserCheck();
			if(UserCheck.check(name)){
				request.setAttribute("userExistErr", "用户已存在");
				rd.forward(req, resp);
			}
			else{
				InsertSQL insertSql=new InsertSQL();
				int row=insertSql.insert(name, password, email);
				if(row==1){
					System.out.println("success");
					response.sendRedirect("Register success.jsp");
					rd.forward(req, resp);
				}
				else{
					System.out.println("falied");
					response.sendRedirect("Failed.jsp");
				}
			}
		
		}
		else{
			request.setAttribute("verifyCodeErr", "验证码错误");
			rd.forward(req, resp);
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

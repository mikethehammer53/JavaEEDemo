package com.user.reg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.ldap.Rdn;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class regservlet extends HttpServlet {

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
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("Servlet doGet方法");
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)resp;
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String name=request.getParameter("username");
		String pwd=request.getParameter("password");
		PrintWriter out=response.getWriter();
		out.write(name+"</br>");
		out.write(pwd+"\n");
		out.flush();
		out.close();
		
		
//		String name=req.getParameter("username");
//		String pwd=req.getParameter("password");
//		RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
//		if(!name.equals("admin")||!pwd.equals("admin")){
//			req.setAttribute("username", name);
//			req.setAttribute("LoginError", "请重新输入");
//		}
//		else{
//			resp.sendRedirect("index.jsp");		
//		}
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
		System.out.println("Servlet doPost方法");
		doGet(req, resp);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		System.out.println("Servlet初始化");
	}
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		HttpServletRequest request=(HttpServletRequest)arg0;
		HttpServletResponse response=(HttpServletResponse)arg1;
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String pwd=request.getParameter("pwd");
		String cmdPwd=request.getParameter("password2");
		PrintWriter out=response.getWriter();
		out.write("<script type='text/javascript'>alert('alert')</script>");
		out.write("name:"+name+"\n");
		//out.write("邮箱:"+email);
		//out.write("\n");
		out.write("password:"+pwd);
		out.close();
	}

}

package fileprocess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.File;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class fileuploadmanually extends HttpServlet {

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
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		InputStream is=request.getInputStream();
		//PrintWriter out=response.getWriter();
		BufferedReader reader=new BufferedReader(new InputStreamReader(is));
		String str="";
		while((str=reader.readLine())!=null){
			//System.out.println(str);
			//out.append(str);
			if(str.endsWith("--")&&str.startsWith("------")){
				break;
			}
			if(str.startsWith("------")){
				if(reader.readLine().indexOf("filename")>1){
					reader.readLine();
					reader.readLine();
					File file=new File(request.getServletContext().getRealPath("/")+
							System.currentTimeMillis());
					PrintStream ps=new PrintStream(file);
					String content=null;
					while((content=reader.readLine())!=null){
						if(content.startsWith("------")){
							break;
						}
						ps.println(content);
						System.out.println(content);
					}
					ps.flush();
					ps.close();
				}
			}
		}
		//out.flush();
		//out.close();
		reader.close();
		response.sendRedirect("uploadsuccess.jsp");
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

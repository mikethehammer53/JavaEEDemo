package fileprocess;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;



public class CommonFileUpload extends HttpServlet {

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

		DiskFileItemFactory factory=new DiskFileItemFactory();
		factory.setSizeThreshold(10*1024*1024);
		factory.setRepository(new File(request.getServletContext().getRealPath("/upload")));
		ServletFileUpload upload=new ServletFileUpload(factory);
		upload.setFileSizeMax(3*1024*1024);
		try{
			List<FileItem> items=upload.parseRequest(request);
			for(Iterator<FileItem> it=items.iterator();it.hasNext();){
				FileItem item=it.next();
				if(item.isFormField()){
					String name=item.getFieldName();
					String value=item.getString();
					System.out.println(name+":"+value);
				}
				else{
					String fieldName=item.getFieldName();
					String fileName=item.getName();
					String contentType=item.getContentType();
					FileOutputStream fos=new FileOutputStream(request.getServletContext().getRealPath("/upload/")+
							System.currentTimeMillis()+"_"+fileName.substring(0, fileName.lastIndexOf("."))+
							fileName.substring(fileName.lastIndexOf("."),fileName.length()));
					if(item.isInMemory()){
						fos.write(item.get());
					}
					else{
						InputStream is=item.getInputStream();
						byte[] buffer=new byte[1024];
						int len=0;
						while((len=is.read(buffer))>0){
							fos.write(buffer, 0, len);
						}
						is.close();
						fos.close();
					}
				}
			}
		}
		catch(FileUploadException e){
			e.printStackTrace();
		}
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

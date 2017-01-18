package servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *  
 * 上传文件servlet
 * @author Administrator
 * 
 */
@WebServlet(name = "upLoadServlet", urlPatterns = { "/UpLoadServlet" })
@MultipartConfig
public class UpLoadServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  request.setCharacterEncoding("UTF-8");  
	      Part part = request.getPart("upload");  
	      String disposition = part.getHeader("content-disposition");  
	      System.out.println(disposition);  
	      String fileName = disposition.substring(disposition.lastIndexOf("=")+2, disposition.length()-1);  
	      String fileType = part.getContentType();  
	      long fileSize = part.getSize();  
	      System.out.println("fileName: " + fileName);  
	      System.out.println("fileType: " + fileType);  
	      System.out.println("fileSize: " + fileSize);  
	      String uploadPath = request.getServletContext().getRealPath("/upload");  
	      System.out.println("uploadPath" + uploadPath);  
//	      part.write(uploadPath + File.separator +fileName);  
	}
}

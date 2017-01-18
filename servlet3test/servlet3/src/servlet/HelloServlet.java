package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  
 * 
 * @author Administrator
 * 
 */
@WebServlet(name = "helloServlet", urlPatterns = { "/HelloServlet" }, loadOnStartup = 1, initParams = {
		@WebInitParam(name = "name", value = "abc"),
		@WebInitParam(name = "age", value = "20") })
public class HelloServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = String.valueOf(request.getParameter("name1"));
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("content-type","text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1 align=\"center\">名称为:" + name+"</h1><br />");
		out.println("<h1 align=\"center\">Hello world 不在web.xml中配置" + "</h1><br />");
		out.println("</body>");
		out.println("</html>");
	}
}

package async;

import java.io.*;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import listener.MyAsyncListener;

@WebServlet(name = "AsyncServlet", urlPatterns = { "/AsyncServlet" }, asyncSupported = true)
public class AsyncServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("====异步页面处理开始====<hr />");
		out.println("====异步页面处理结束====<hr />");
		out.println("</body>");
		out.println("</html>");
		out.flush();
		AsyncContext actx = request.startAsync();
		// 设置当前异步调用对应的监听器
		actx.addListener(new MyAsyncListener());
		actx.setTimeout(30 * 3000);
		actx.start(new MyThread(actx));
	}
}

class MyThread implements Runnable {
	private AsyncContext actx;

	public MyThread(AsyncContext actx) {
		this.actx = actx;
	}

	public void run() {
		try {
			Thread.sleep(5 * 1000); // 消耗5秒
			actx.dispatch("/1.jsp");
		} catch (Exception e) {
		}
	}
}
package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.DispatcherType;
import javax.servlet.annotation.WebInitParam;
/**
 * 所有请求全都过滤
 * @author Administrator
 *
 */
@WebFilter(urlPatterns = { "/*" }, asyncSupported = true, dispatcherTypes = { DispatcherType.REQUEST }, initParams = @WebInitParam(name = "param1", value = "value1"))
public class HelloFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("destory filter……");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("filter……");
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("filter init……");
	}
}

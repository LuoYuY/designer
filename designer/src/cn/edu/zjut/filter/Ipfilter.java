package cn.edu.zjut.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;


@WebFilter("/Ipfilter")
public class Ipfilter implements Filter {

    /**
     * Default constructor. 
     */
    public Ipfilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
	    ServletContext servletContext = webApplicationContext.getServletContext();
        List<String> iplist = (List<String>)servletContext.getAttribute("iplist");
        String ip = request.getRemoteAddr();
        int flag =0;
        for(int i=0;i<iplist.size();i++)
        {
        	if(iplist.get(i).equals(ip)) flag=1;
        }
        if(flag==0){
            Integer count =(Integer)servletContext.getAttribute("visit");
            servletContext.setAttribute("visit", count+1);
            iplist.add(ip);
            servletContext.setAttribute("iplist", iplist);
        }
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

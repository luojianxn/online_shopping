package controler;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainControler extends HttpServlet{
	 public void init() throws ServletException {
	        System.out.println("做一些初始化的工作");
	    }

	    @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        System.out.println("doGet方法被调用了");
	       // resp.getOutputStream().write("doGet方法被调用了".getBytes());
	       /* String message = req.getParameter("message");
	        System.out.println("message="+message);
	        Writer out = resp.getWriter(); 
	        out.write("你说的很对"+"message="+message);
	        out.flush();   */
	        
	        
	        
	    }

	    @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	       /* System.out.println("doPost方法被调用了");
	        resp.getOutputStream().write("doPost方法被调用了".getBytes());*/
	    	
	    	
	    	
	    }

}

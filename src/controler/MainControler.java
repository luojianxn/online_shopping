package controler;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainControler extends HttpServlet{
	 public void init() throws ServletException {
	        System.out.println("��һЩ��ʼ���Ĺ���");
	    }

	    @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        System.out.println("doGet������������");
	       // resp.getOutputStream().write("doGet������������".getBytes());
	       /* String message = req.getParameter("message");
	        System.out.println("message="+message);
	        Writer out = resp.getWriter(); 
	        out.write("��˵�ĺܶ�"+"message="+message);
	        out.flush();   */
	        
	        
	        
	    }

	    @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	       /* System.out.println("doPost������������");
	        resp.getOutputStream().write("doPost������������".getBytes());*/
	    	
	    	
	    	
	    }

}

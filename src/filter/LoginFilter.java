package filter;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter{

    public void destroy() {
        // TODO Auto-generated method stub
    }

    public void doFilter(ServletRequest arg0, ServletResponse arg1,
            FilterChain arg2) throws IOException, ServletException {
        // TODO Auto-generated method stub
        HttpServletRequest req = (HttpServletRequest)arg0;
        HttpServletResponse resp =(HttpServletResponse) arg1;
        HttpSession session = req.getSession();
        String user = (String) session.getAttribute("user");  
       if (user == null || "".equals(user)) {           
            resp.sendRedirect("login.html");
        } else {
            arg2.doFilter(req, resp);
        }
    }
    
    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub
    }
}

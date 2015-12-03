package njxzc.royxu.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.util.LogUtil;

public class RightFilter extends HttpServlet implements Filter{
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LoggerFactory.getLogger(RightFilter.class);
	
	public void doFilter(ServletRequest arg0, ServletResponse arg1,  
            FilterChain arg2) throws IOException, ServletException {  
    	HttpServletResponse response = (HttpServletResponse) arg1; 
        HttpServletRequest request=(HttpServletRequest)arg0;
        HttpSession session = request.getSession(true);
        
//        session.setAttribute("user_id", 1);//测试时使用，正式系统中注释掉
//        session.setAttribute("user_name", "超级管理员");//测试时使用，正式系统中注释掉
//        session.setAttribute("role_ids", "1");//测试时使用，正式系统中注释掉
        
        String url=request.getRequestURI();
        LOG.debug("RightFilter-url: "+url);
        if(!("/tist".equals(url)||"/tist/".equals(url)||url.indexOf("index")>0||url.indexOf("ueditor")>0||url.indexOf("list")>0||url.indexOf("find")>0||url.indexOf("download.do")>0||url.indexOf("logout.do")>0)){
        	if(session.getAttribute("user_id") ==null){
        		System.err.println("user_id为空");
                //判断获取的路径不为空且不是访问登录页面或执行登录操作时跳转  并且将当前页面的url传给login页面
                if(url!=null && !url.equals("") && ( url.indexOf("Login")<0 && url.indexOf("login")<0 )){
                	System.out.println("当前url不是登录");
                	//如果当前是http://servername:serverport:/taoworkstation，则页面直接跳转至登陆页面
                	//否则表明当前请求的url是功能模块中的页面，则提示用户登陆超时，再重定向至登陆页面
            		PrintWriter out = response.getWriter();
            		String html = "<html>"
    	            			+ "<head>"
    	            			+ "<meta http-equiv=Content-Type content=text/html;charset=utf-8>"
    	            			+"<script type='text/javascript' >"
    	            				+ "function toLogin(){"
            						+ "alert('对不起，由于您长时间未操作或登陆已超时，请您重新登陆');"
    	            				+ "parent.location.href='http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/bjsp/login/login.jsp"+"';"
    	            			+ "}"
    	            			+ "</script>"
    	            			+ "</head>"
    	            			+ "<body onload='toLogin();'>"
    	            			+ "</body>";
                	out.print(html);
                    return ;  
                }             
            }else{
            	if((url.indexOf("create")>0||url.indexOf("save")>0)&&url.indexOf(".do")>0){
                	try {
        				LogUtil.saveCreateLog(request, session);
        			} catch (Exception e) {
        				// TODO Auto-generated catch block
        				e.printStackTrace();
        				try {
        					LogUtil.saveExceptionLog(request, session,e);
        				} catch (Exception e1) {
        					e1.printStackTrace();
        				}
        			}
                }
                if(url.indexOf("update")>0&&url.indexOf(".do")>0){
                	try {
        				LogUtil.saveUpdateLog(request, session);
        			} catch (Exception e) {
        				// TODO Auto-generated catch block
        				e.printStackTrace();
        				try {
        					LogUtil.saveExceptionLog(request, session,e);
        				} catch (Exception e1) {
        					e1.printStackTrace();
        				}
        			}
                }
                if(url.indexOf("delete")>0&&url.indexOf(".do")>0){
                	try {
        				LogUtil.saveDeleteLog(request, session);
        			} catch (Exception e) {
        				// TODO Auto-generated catch block
        				e.printStackTrace();
        				try {
        					LogUtil.saveExceptionLog(request, session,e);
        				} catch (Exception e1) {
        					e1.printStackTrace();
        				}
        			}
                }
            }
        }
        //已通过验证，用户访问继续   
        arg2.doFilter(arg0, arg1);  
        return;  
	}
  
	public void init(FilterConfig arg0) throws ServletException {
		
    }
}

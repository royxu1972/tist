package com.core;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

//import com.rsp.global.domain.User;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.ModelAndView;
/**
 * 通用Controller类，其他Controller需要继承；
 * @author KEVIN 
 *
 */
public class BaseController {
    protected static final String ERROR_MSG_KEY = "errorMsg";
    protected static final String CONTEXT_PATH = "contextPath";
//
//    protected User getSessionUser(HttpServletRequest request) {
//        return (User)request.getSession().
//                getAttribute(CommonConstant.USER_CONTEXT);
//    }
//
//    protected void setSessionUser(HttpServletRequest request, User user) {
//        request.getSession().setAttribute(CommonConstant.USER_CONTEXT,
//                user);
//    }

    protected String getContextPath(HttpServletRequest request) {
        return request.getContextPath();
    }

    public ModelAndView impExcel() {
        return null;
    }

    public ModelAndView expExcel() {
        return null;
    }
    
    /**
   	 * 将前台传递过来的日期格式的字符串，自动转化为Date类型
   	 * 
   	 * @param binder
   	 * 
   	 */
   	@InitBinder
   	public void initBinder(ServletRequestDataBinder binder) {
   		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
   		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
   	}
}
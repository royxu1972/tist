package com.util;

import java.util.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import njxzc.royxu.domain.SystemLog;
import njxzc.royxu.service.SystemLogServiceImpl;

import org.springframework.context.ApplicationContext;

public class LogUtil {
	private static SystemLogServiceImpl systemLogService;
	
	public static void saveCreateLog(HttpServletRequest request, HttpSession session) throws Exception{
		systemLogService = getSystemLogServiceImpl();
		SystemLog systemLog = getLogParamsFromRequest(request);
		systemLog.setCreate_by(""+session.getAttribute("user_name"));//create_by
		systemLog.setType("create");//日志类型为创建
		System.out.println(systemLog.toString());
		systemLogService.saveSystemLog(systemLog);
	}
	
	public static void saveUpdateLog(HttpServletRequest request, HttpSession session) throws Exception{
		systemLogService = getSystemLogServiceImpl();
		SystemLog systemLog = getLogParamsFromRequest(request);
		systemLog.setCreate_by(""+session.getAttribute("user_name"));//create_by
		systemLog.setType("update");//日志类型为创建
		System.out.println(systemLog.toString());
		systemLogService.saveSystemLog(systemLog);
	}
	
	public static void saveDeleteLog(HttpServletRequest request, HttpSession session) throws Exception{
		systemLogService = getSystemLogServiceImpl();
		SystemLog systemLog = getLogParamsFromRequest(request);
		systemLog.setCreate_by(""+session.getAttribute("user_name"));//create_by
		systemLog.setType("delete");//日志类型为创建
		System.out.println(systemLog.toString());
		systemLogService.saveSystemLog(systemLog);
	}
	
	public static void saveExceptionLog(HttpServletRequest request, HttpSession session, Exception e) throws Exception{
		systemLogService = getSystemLogServiceImpl();
		SystemLog systemLog = getLogParamsFromRequest(request);
		systemLog.setException("{'message':'"+e.getMessage()+"','cause':'"+e.getCause()+"',"+"'localizedmsg':'"+e.getLocalizedMessage()+"'}");
		systemLog.setCreate_by(""+session.getAttribute("user_name"));//create_by
		systemLog.setType("exception");//日志类型为创建
		System.out.println(systemLog.toString());
		systemLogService.saveSystemLog(systemLog);
	}
	
	@SuppressWarnings("rawtypes")
	public static SystemLog getLogParamsFromRequest(HttpServletRequest request) throws Exception{
		SystemLog systemLog = new SystemLog();
		String date = DateUtil.format2(new Date());
		systemLog.setCreate_time(date);//create_time
		if(!StringUtil.isEmpty(request.getMethod())){//method
			systemLog.setMethod(request.getMethod());
		}
		if(!StringUtil.isEmpty(request.getRemoteAddr())){//remote_addr
			systemLog.setRemote_addr(request.getRemoteAddr());
		}
		if(!StringUtil.isEmpty(request.getRequestURI())){//request_uri
			systemLog.setRequest_uri(request.getRequestURI());
		}
		if(!StringUtil.isEmpty(request.getHeader("user-agent"))){//user_agent
			systemLog.setUser_agent(request.getHeader("user-agent"));
		}
		
		Enumeration rnames = request.getParameterNames();
		String param = "{";
		for (Enumeration e = rnames; e.hasMoreElements();) {
			String thisName = e.nextElement().toString();
			String thisValue = request.getParameter(thisName);
			String pair_value = "'"+thisName+"':"+"'"+thisValue+"',";
			System.out.println(pair_value);
			param += pair_value;
		}
		if(param.indexOf(",")>0){
			param = param.substring(0,param.length()-1);
		}
		param += "}";
		systemLog.setParams(param);//params
		System.out.println(param);
		return systemLog;
	}
	
	public static SystemLogServiceImpl getSystemLogServiceImpl(){
		ApplicationContext ctx = SpringContextUtil.context;
		SystemLogServiceImpl systemLogServiceImpl = (SystemLogServiceImpl) ctx.getBean(SystemLogServiceImpl.class);
		return systemLogServiceImpl;
	}
	
}

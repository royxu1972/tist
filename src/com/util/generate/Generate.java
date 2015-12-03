/**
 * Copyright &copy; 2012-2013 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.util.generate;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Maps;
import com.util.FieldMembers;
import com.util.StringUtil;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * 代码生成器
 * @author LiangHong
 * @version 2015-06-2
 */
public class Generate {
	
	private static Logger logger = LoggerFactory.getLogger(Generate.class);
	
	/**
	 *  @param className  类名，例：user
	 *  @param functionName 功能名，例：用户
	 *  @param moduleName 模块名，例：sys
	 *  @return
	 **/
	public static String generate(String className, String functionName, String moduleName,String generate_jspjs,String left_right) {
		try{
			String return_message = "";
			String error_message = "";
			// 主要提供基本功能模块代码生成。
			// 目录生成结构：{packageName}/{dao,domain,service,controller}/{subModuleName}/{className}
			
			// packageName 包名，这里如果更改包名，请在applicationContext.xml和srping-mvc.xml中配置base-package、packagesToScan属性，来指定多个（共4处需要修改）。
			String packageName = "njxzc.royxu";
			String subModuleName = "";				// 子模块名（可选） 
			String classAuthor = "LiangHong";		// 类作者，例：ThinkGem
			
//			String className = "";// 类名，例：user
//			String functionName = "";// 功能名，例：用户
//			String moduleName = "";// 模块名，例：sys

			// ========== ↑↑↑↑↑↑ 执行前请修改参数，谨慎执行。↑↑↑↑↑↑ ====================
			
			if (StringUtils.isBlank(moduleName) || StringUtils.isBlank(moduleName) 
					|| StringUtils.isBlank(className) || StringUtils.isBlank(functionName)){
				logger.error("参数设置错误：包名、模块名、类名、功能名不能为空。");
				error_message = "fail;参数设置错误：包名、模块名、类名、功能名不能为空。";
				return error_message;
			}
			
			// 获取文件分隔符
			String separator = File.separator;
			String project_path = StringUtil.getAbsolutePath();//必须修改为当前项目的
			
			// 获取工程路径
//			File projectPath = new DefaultResourceLoader().getResource("").getFile();
			File projectPath = new File(project_path);
			while(!new File(projectPath.getPath()+separator+"src").exists()){
				projectPath = projectPath.getParentFile();
			}
			logger.info("Project Path: {}", projectPath);
			
			// 模板文件路径
			String tplPath = StringUtils.replace(projectPath+"/src/com/util/generate/template", "/", separator);
			logger.info("Template Path: {}", tplPath);
			
			// Java文件路径
			String javaPath = StringUtils.replaceEach(projectPath+"/src/"+StringUtils.lowerCase(packageName), 
					new String[]{"/", "."}, new String[]{separator, separator});
			logger.info("Java Path: {}", javaPath);
			
			// 视图文件路径
			String viewPath = StringUtils.replace(projectPath+"/WebContent/bjsp", "/", separator);
			logger.info("View Path: {}", viewPath);
			
			// 代码模板配置
			Configuration cfg = new Configuration();
			cfg.setDefaultEncoding("UTF-8");
			cfg.setDirectoryForTemplateLoading(new File(tplPath));

			// 定义模板变量
			Map<String, String> model = Maps.newHashMap();
			model.put("packageName", StringUtils.lowerCase(packageName));
			model.put("moduleName", StringUtils.lowerCase(moduleName));
			model.put("subModuleName", StringUtils.isNotBlank(subModuleName)?"."+StringUtils.lowerCase(subModuleName):"");
			model.put("className", StringUtils.uncapitalize(className));
			model.put("ClassName", StringUtils.capitalize(className));
			model.put("classname", className.toLowerCase());
			model.put("classAuthor", StringUtils.isNotBlank(classAuthor)?classAuthor:"Generate Tools");
			model.put("classVersion", DateUtils.getDate());
			model.put("functionName", functionName);
			model.put("tableName", model.get("moduleName")+(StringUtils.isNotBlank(subModuleName)
					?"_"+StringUtils.lowerCase(subModuleName):"")+"_"+model.get("className"));
			model.put("contextPath", "${pageContext.request.contextPath}");

			// 生成 Entity
			Template template = cfg.getTemplate("my_entity_new.ftl");
			String content = FreeMarkers.renderTemplate(template, model);
			String filePath = javaPath+separator+"domain"
					+separator+StringUtils.lowerCase(subModuleName)+separator+model.get("ClassName")+".java";
			return_message += "Domain:"+writeFile(content, filePath)+"\n"+filePath+"\n";
			logger.info("Entity: {}", filePath);
			
			// 生成 Dao
			template = cfg.getTemplate("my_dao.ftl");
			content = FreeMarkers.renderTemplate(template, model);
			filePath = javaPath+separator+"dao"+separator
					+StringUtils.lowerCase(subModuleName)+separator+model.get("ClassName")+"Dao.java";
			return_message += "Dao:"+writeFile(content, filePath)+"\n"+filePath+"\n";
			logger.info("Dao: {}", filePath);
			
			// 生成 Service
			template = cfg.getTemplate("my_service.ftl");
			content = FreeMarkers.renderTemplate(template, model);
			filePath = javaPath+separator+"service"+separator
					+StringUtils.lowerCase(subModuleName)+separator+model.get("ClassName")+"ServiceImpl.java";
			return_message += "Service:"+writeFile(content, filePath)+"\n"+filePath+"\n";
			logger.info("Service: {}", filePath);
			
			// 生成 Controller
			template = cfg.getTemplate("my_controller.ftl");
			content = FreeMarkers.renderTemplate(template, model);
			filePath = javaPath+separator+"controller"+separator
					+StringUtils.lowerCase(subModuleName)+separator+model.get("ClassName")+"Controller.java";
			return_message += "Controller:"+writeFile(content, filePath)+"\n"+filePath+"\n";
			
			if("1".equals(generate_jspjs)){
				// 生成 jsp
				if("1".equals(left_right)){
					template = cfg.getTemplate("my_left_right_jsp.ftl");
				}else{
					template = cfg.getTemplate("bootstrap_jsp.ftl");
				}
				content = FreeMarkers.renderTemplate(template, model);
				filePath = viewPath+separator+model.get("classname").toLowerCase()+separator+StringUtils.lowerCase(subModuleName)
						+separator+model.get("classname")+".jsp";
				System.err.println(filePath);
				return_message += "Jsp:"+writeFile(content, filePath)+"\n"+filePath+"\n";
				logger.info("ViewForm: {}", filePath);
				
				// 生成js
				if("1".equals(left_right)){
					template = cfg.getTemplate("my_left_right_js.ftl");
				}else{
					template = cfg.getTemplate("bootstrap_js.ftl");
				}
				content = FreeMarkers.renderTemplate(template, model);
				filePath = viewPath+separator+model.get("classname").toLowerCase()+separator+StringUtils.lowerCase(subModuleName)
						+separator+model.get("classname")+".js";
				return_message += "Js:"+writeFile(content, filePath)+"\n"+filePath+"\n";
				logger.info("ViewForm: {}", filePath);
				
				// 生成验证js
				template = cfg.getTemplate("bootstrap_validate_js.ftl");
				content = FreeMarkers.renderTemplate(template, model);
				filePath = viewPath+separator+model.get("classname").toLowerCase()+separator+StringUtils.lowerCase(subModuleName)
						+separator+model.get("classname")+"_validate.js";
				return_message += "Controller:"+writeFile(content, filePath)+"\n"+filePath+"\n";
				logger.info("ViewForm: {}", filePath);
			}
			
			logger.info("Controller: {}", filePath);
			logger.info("Generate Success.");
			return return_message;
		}catch(Exception e){
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	/**
	 * 
	 *  @Enclosing_Method  : generateNew
	 *  @Written by        : Hong Liang
	 *  @Creation Date     : 2015年7月16日 下午7:49:01 
	 *  @version           : v1.00
	 *  @Description       :  新增全自动生成
	 *  
	 *  @param className
	 *  @param functionName
	 *  @param moduleName
	 *  @param generate_jspjs
	 *  @param left_right
	 *  @param members
	 *  @return
	 *
	 */
	public static String generateNew(String className, String functionName, String moduleName,String generate_jspjs,String left_right,List<FieldMembers> members) {
		try{
			String return_message = "";
			String error_message = "";
			// 主要提供基本功能模块代码生成。
			// 目录生成结构：{packageName}/{dao,domain,service,controller}/{subModuleName}/{className}
			
			// packageName 包名，这里如果更改包名，请在applicationContext.xml和srping-mvc.xml中配置base-package、packagesToScan属性，来指定多个（共4处需要修改）。
			String packageName = "njxzc.royxu";
			String subModuleName = "";				// 子模块名（可选） 
			String classAuthor = "LiangHong";		// 类作者，例：ThinkGem
			
//			String className = "";// 类名，例：user
//			String functionName = "";// 功能名，例：用户
//			String moduleName = "";// 模块名，例：sys
			
			// ========== ↑↑↑↑↑↑ 执行前请修改参数，谨慎执行。↑↑↑↑↑↑ ====================
			
			if (StringUtils.isBlank(moduleName) || StringUtils.isBlank(moduleName) 
					|| StringUtils.isBlank(className) || StringUtils.isBlank(functionName)){
				logger.error("参数设置错误：包名、模块名、类名、功能名不能为空。");
				error_message = "fail;参数设置错误：包名、模块名、类名、功能名不能为空。";
				return error_message;
			}
			
			// 获取文件分隔符
			String separator = File.separator;
			String project_path = StringUtil.getAbsolutePath();//必须修改为当前项目的
			
			// 获取工程路径
//			File projectPath = new DefaultResourceLoader().getResource("").getFile();
			File projectPath = new File(project_path);
			while(!new File(projectPath.getPath()+separator+"src").exists()){
				projectPath = projectPath.getParentFile();
			}
			logger.info("Project Path: {}", projectPath);
			
			// 模板文件路径
			String tplPath = StringUtils.replace(projectPath+"/src/com/util/generate/template", "/", separator);
			logger.info("Template Path: {}", tplPath);
			
			// Java文件路径
			String javaPath = StringUtils.replaceEach(projectPath+"/src/"+StringUtils.lowerCase(packageName), 
					new String[]{"/", "."}, new String[]{separator, separator});
			logger.info("Java Path: {}", javaPath);
			
			// 视图文件路径
			String viewPath = StringUtils.replace(projectPath+"/WebContent/bjsp", "/", separator);
			logger.info("View Path: {}", viewPath);
			
			// 代码模板配置
			Configuration cfg = new Configuration();
			cfg.setDefaultEncoding("UTF-8");
			cfg.setDirectoryForTemplateLoading(new File(tplPath));
			
			// 定义模板变量
			Map<String, Object> model = Maps.newHashMap();
			model.put("packageName", StringUtils.lowerCase(packageName));
			model.put("moduleName", StringUtils.lowerCase(moduleName));
			model.put("subModuleName", StringUtils.isNotBlank(subModuleName)?"."+StringUtils.lowerCase(subModuleName):"");
			model.put("className", StringUtils.uncapitalize(className));
			model.put("ClassName", StringUtils.capitalize(className));
			model.put("classname", className.toLowerCase());
			model.put("classAuthor", StringUtils.isNotBlank(classAuthor)?classAuthor:"Generate Tools");
			model.put("classVersion", DateUtils.getDate());
			model.put("functionName", functionName);
			model.put("tableName", model.get("moduleName")+(StringUtils.isNotBlank(subModuleName)
					?"_"+StringUtils.lowerCase(subModuleName):"")+"_"+model.get("className"));
			model.put("contextPath", "${pageContext.request.contextPath}");
			model.put("fields", members);
			
			// 生成 Entity
			Template template = cfg.getTemplate("my_entity_new.ftl");
			String content = FreeMarkers.renderTemplate(template, model);
			String filePath = javaPath+separator+"domain"
					+separator+StringUtils.lowerCase(subModuleName)+separator+model.get("ClassName")+".java";
			return_message += "Domain:"+writeFile(content, filePath)+"\n"+filePath+"\n";
			logger.info("Entity: {}", filePath);
			
			// 生成 Dao
			template = cfg.getTemplate("my_dao.ftl");
			content = FreeMarkers.renderTemplate(template, model);
			filePath = javaPath+separator+"dao"+separator
					+StringUtils.lowerCase(subModuleName)+separator+model.get("ClassName")+"Dao.java";
			return_message += "Dao:"+writeFile(content, filePath)+"\n"+filePath+"\n";
			logger.info("Dao: {}", filePath);
			
			// 生成 Service
			template = cfg.getTemplate("my_service.ftl");
			content = FreeMarkers.renderTemplate(template, model);
			filePath = javaPath+separator+"service"+separator
					+StringUtils.lowerCase(subModuleName)+separator+model.get("ClassName")+"ServiceImpl.java";
			return_message += "Service:"+writeFile(content, filePath)+"\n"+filePath+"\n";
			logger.info("Service: {}", filePath);
			
			// 生成 Controller
			template = cfg.getTemplate("my_controller.ftl");
			content = FreeMarkers.renderTemplate(template, model);
			filePath = javaPath+separator+"controller"+separator
					+StringUtils.lowerCase(subModuleName)+separator+model.get("ClassName")+"Controller.java";
			return_message += "Controller:"+writeFile(content, filePath)+"\n"+filePath+"\n";
			
			if("1".equals(generate_jspjs)){
				// 生成 jsp
				if("1".equals(left_right)){
					template = cfg.getTemplate("my_left_right_jsp.ftl");
				}else{
					template = cfg.getTemplate("bootstrap_jsp.ftl");
				}
				content = FreeMarkers.renderTemplate(template, model);
				filePath = viewPath+separator+model.get("classname").toString().toLowerCase()+separator+StringUtils.lowerCase(subModuleName)
						+separator+model.get("classname")+".jsp";
				System.err.println(filePath);
				return_message += "Jsp:"+writeFile(content, filePath)+"\n"+filePath+"\n";
				logger.info("ViewForm: {}", filePath);
				
				// 生成js
				if("1".equals(left_right)){
					template = cfg.getTemplate("my_left_right_js.ftl");
				}else{
					template = cfg.getTemplate("bootstrap_js.ftl");
				}
				content = FreeMarkers.renderTemplate(template, model);
				filePath = viewPath+separator+model.get("classname").toString().toLowerCase()+separator+StringUtils.lowerCase(subModuleName)
						+separator+model.get("classname")+".js";
				return_message += "Js:"+writeFile(content, filePath)+"\n"+filePath+"\n";
				logger.info("ViewForm: {}", filePath);
				
				// 生成验证js
				template = cfg.getTemplate("bootstrap_validate_js.ftl");
				content = FreeMarkers.renderTemplate(template, model);
				filePath = viewPath+separator+model.get("classname").toString().toLowerCase()+separator+StringUtils.lowerCase(subModuleName)
						+separator+model.get("classname")+"_validate.js";
				return_message += "Validate:"+writeFile(content, filePath)+"\n"+filePath+"\n";
				logger.info("ViewForm: {}", filePath);
			}
			
			logger.info("Controller: {}", filePath);
			logger.info("Generate Success.");
			return return_message;
		}catch(Exception e){
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	/**
	 * 将内容写入文件
	 * @param content
	 * @param filePath
	 */
	public static String writeFile(String content, String filePath) {
		try {
			if (FileUtils.createFile(filePath)){
				FileOutputStream fos = new FileOutputStream(filePath);
				Writer writer = new OutputStreamWriter(fos,"UTF-8");
				BufferedWriter bufferedWriter = new BufferedWriter(writer);
				bufferedWriter.write(content);
				bufferedWriter.close();
				writer.close();
				return "生成成功";
			}else{
				logger.info("生成失败，文件已存在！");
				return "生成失败，文件已存在！";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	public static void main(String[] args){
//		System.err.println(generate("productOrder", "用户信息", "productorder","1","0"));
		List<FieldMembers> fields = new ArrayList<FieldMembers>();
		fields.add(new FieldMembers("int","user_id","用户id","int","11"));
		fields.add(new FieldMembers("String","user_name","用户名","varchar","30"));
		fields.add(new FieldMembers("String","user_password","密码","varchar","30"));
		System.err.println(generateNew("test2", "测试", "test2","1","1",fields));
	}
}

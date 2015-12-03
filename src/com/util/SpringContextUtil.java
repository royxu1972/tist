package com.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringContextUtil {
	public static ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

}

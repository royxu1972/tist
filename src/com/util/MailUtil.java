package com.util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtil {
	
	public static void sendEmail() throws Exception {
		String msgText = "测试邮件";
		// 获取系统属性
		Properties p = System.getProperties();
		// 设置邮件服务器:看看当地是否有邮局
		p.put("mail.smtp.host", "smtp.126.com");
		p.put("mail.smtp.auth", "true");

		// 创建一个邮件会话，准备发送邮件：买信封
		Session s = Session.getDefaultInstance(p, null);
		// 准备一个发送邮件的对象，即邮差
		Transport trans = s.getTransport("smtp");
		// 准备一封邮件：买信纸
		Message m = new MimeMessage(s);
		// 设置邮件的标题，即主题
		m.setSubject("问卷调查用户信息:同学");
		// 设置日期
		m.setSentDate(new Date());
		// 邮件正文
		m.setContent(msgText, "text/html;  charset=gb2312");// 用于发邮件 设置邮件的标题，即主题
		// 设置发件人:写自己的地址和名字
		Address from = new InternetAddress("owenjunefirst@126.com");
		m.setFrom(from);
		// 设置收件人：写对方的地址和名字
		Address to = new InternetAddress("448027296@qq.com");
		// 将收件人加到邮件中:将收件人写到信纸上
		m.addRecipient(Message.RecipientType.TO, to);
		// 连接服务器认证
		trans.connect("smtp.126.com", "owenjunefirst@126.com", "owenjunefirst");
		// 发送邮件，即投递
		trans.sendMessage(m, m.getAllRecipients());
		System.out.println(msgText + "\n" );
	}
	
	public static void sendValidateCodeTo(String toAddress,String code) throws Exception {
		String msgText = "<p>尊敬的用户，您好！</p>"
						+ "<p style='text-indent:2em;'>欢迎您使用Royxu信息管理系统，请您在基本信息页面中输入以下验证码：</p>"
						+ "<h1 style='color:red;text-indent:2em;'><strong>"+code+"</strong></h1>"
						+ "<p style='text-indent:2em;'>验证成功后您可以通过邮箱来修改您的系统密码</p>";
		// 获取系统属性
		Properties p = System.getProperties();
		// 设置邮件服务器:看看当地是否有邮局
		p.put("mail.smtp.host", "smtp.126.com");
		p.put("mail.smtp.auth", "true");
		
		// 创建一个邮件会话，准备发送邮件：买信封
		Session s = Session.getDefaultInstance(p, null);
		// 准备一个发送邮件的对象，即邮差
		Transport trans = s.getTransport("smtp");
		// 准备一封邮件：买信纸
		Message m = new MimeMessage(s);
		// 设置邮件的标题，即主题
		m.setSubject("Royxu系统邮箱验证");
		// 设置日期
		m.setSentDate(new Date());
		// 邮件正文
		m.setContent(msgText, "text/html;  charset=gb2312");// 用于发邮件 设置邮件的标题，即主题
		// 设置发件人:写自己的地址和名字
		Address from = new InternetAddress("owenjunefirst@126.com");
		m.setFrom(from);
		// 设置收件人：写对方的地址和名字
		Address to = new InternetAddress(toAddress);
		// 将收件人加到邮件中:将收件人写到信纸上
		m.addRecipient(Message.RecipientType.TO, to);
		// 连接服务器认证
		trans.connect("smtp.126.com", "owenjunefirst@126.com", "owenjunefirst");
		// 发送邮件，即投递
		trans.sendMessage(m, m.getAllRecipients());
		System.out.println(msgText + "\n" );
	}
	
	public static void main(String[] args){
		try {
//			sendEmail();
			sendValidateCodeTo("448027296@qq.com","68714350");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

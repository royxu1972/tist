package com.util;

import java.io.BufferedReader; 
import java.io.File; 
import java.io.FileInputStream; 
import java.io.FileOutputStream; 
import java.io.InputStream; 
import java.io.InputStreamReader; 
import java.io.OutputStream; 
import java.io.OutputStreamWriter; 

/**
 * 
 * @author wxz
 * 2014-10-7
 * 数据库备份，只完善了backup方法
 */
public class BakMysql { 

	//main的方法，主要是我用于测试的，是想着取得CLASS的路径，然后备份的文件写在服务器的类路径下 
	public static void main(String[] args) { 
		@SuppressWarnings("unused")
		BakMysql bk = new BakMysql(); 
		/*System.out.println(Thread.currentThread().getContextClassLoader().getResource("")); 
	System.out.println(BakMysql.class.getClassLoader().getResource("")); 
	System.out.println(ClassLoader.getSystemResource("")); 
	System.out.println(BakMysql.class.getResource("")); 
	System.out.println(BakMysql.class.getResource("/")); //Class文件所在路径 
	System.out.println(new File("/").getAbsolutePath()); 
	System.out.println(System.getProperty("user.dir")); */ 
		//bk.backup(); 
		//bk.load(); 
		//bk.backupMySql(); 
	} 


	//backup方法是备份数据库到服务器地址 
	public String backup() { 
		try { 
				String filePath = "d:\\twmsdatabak\\twms"+com.util.StringUtil.generateFileName()+".sql";//BakMysql.class.getResource("").toString(); 
				System.out.println(); 
				Runtime rt = Runtime.getRuntime(); 
				// 调用 mysql 的 cmd: 
				Process child = rt.exec("mysqldump -uroot -p123456 twms");// 设置导出编码为utf8。这里必须是utf8 
				//注意这一句，是指运行mysqldump命令，后面跟的是登录名和登录的密码，接着后面的是指备份的数据库的名字，到此结束，以此生成一个执行的进程，取得此进程的输出流到我们要备份的文件 
				// 把进程执行中的控制台输出信息写入.sql文件，即生成了备份文件。注：如果不对控制台信息进行读出，则会导致进程堵塞无法运行 
				InputStream in = child.getInputStream();// 控制台的输出信息作为输入流 
				InputStreamReader xx = new InputStreamReader(in, "utf8");// 设置输出流编码为utf8。这里必须是utf8，否则从流中读入的是乱码 
				String inStr; 
				StringBuffer sb = new StringBuffer(""); 
				String outStr; 
				// 组合控制台输出信息字符串 
				BufferedReader br = new BufferedReader(xx); 
				while ((inStr = br.readLine()) != null) { 
					sb.append(inStr + "\r\n"); 
				} 
				outStr = sb.toString();//备份出来的内容是一个字条串 
				// 要用来做导入用的sql目标文件： 
				FileOutputStream fout = new FileOutputStream(filePath); 
				OutputStreamWriter writer = new OutputStreamWriter(fout, "utf8"); 
				writer.write(outStr);//写文件 
				// 注：这里如果用缓冲方式写入文件的话，会导致中文乱码，用flush()方法则可以避免 
				writer.flush(); 
				// 别忘记关闭输入输出流 
				in.close(); 
				xx.close(); 
				br.close(); 
				writer.close(); 
				fout.close(); 
				System.out.println(""); 
				return filePath;
		} catch (Exception e) { 
				e.printStackTrace(); 
				return "";
		} 
	}
	
	public String backupMySqlToFile() { 
		String outStr = ""; 
		try { 
			Runtime rt = Runtime.getRuntime(); 
			Process child = rt.exec("mysqldump -uroot -pmysql dbname");// 设置导出编码为utf8。这里必须是utf8在此要注意，有时会发生一个mysqldump: Got error: 1045的错误，此时mysqldump必须加上你要备份的数据库的IP地址，即mysqldump -h192.168.0.1 -uroot -pmysql dbname，今天我就遇到了这样的问题，呵呵 // 把进程执行中的控制台输出信息写入.sql文件，即生成了备份文件。注：如果不对控制台信息进行读出，则会导致进程堵塞无法运行 
			InputStream in = child.getInputStream();// 控制台的输出信息作为输入流 
			InputStreamReader xx = new InputStreamReader(in, "utf8");// 设置输出流编码为utf8。这里必须是utf8，否则从流中读入的是乱码 
			String inStr; 
			StringBuffer sb = new StringBuffer(""); 
			// 组合控制台输出信息字符串 
			BufferedReader br = new BufferedReader(xx); 
			while ((inStr = br.readLine()) != null) { 
				sb.append(inStr + "\r\n"); 
			} 
			outStr = sb.toString(); 
			in.close(); 
			xx.close(); 
			br.close(); 

		} catch (Exception e) { 
			e.printStackTrace(); 
		} 
		return outStr; 
	} 

	public void load() { 
		try { 
			String fPath = "c:\\test.sql"; 
			Runtime rt = Runtime.getRuntime(); 
			Process child = rt.exec("mysql -uroot -pmysql bjtest"); 
			OutputStream out = child.getOutputStream();//控制台的输入信息作为输出流 
			String inStr; 
			StringBuffer sb = new StringBuffer(""); 
			String outStr; 
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fPath), "utf8")); 
			while ((inStr = br.readLine()) != null) { 
				sb.append(inStr + "\r\n"); 
			} 
			outStr = sb.toString(); 
			OutputStreamWriter writer = new OutputStreamWriter(out, "utf8"); 
			writer.write(outStr); 
			// 注：这里如果用缓冲方式写入文件的话，会导致中文乱码，用flush()方法则可以避免 
			writer.flush(); 
			out.close(); 
			br.close(); 
			writer.close(); 
		} catch (Exception e) { 
			e.printStackTrace(); 
		} 
	} 

	//当用户恢复数据的时候，直接传一个上传的文件给这个方法，就可以对数据库进行恢复了 
	public void restoreMysqlFromFile(File f) { 
		try { 
			FileInputStream fis = new FileInputStream(f); 
			Runtime rt = Runtime.getRuntime(); 
			Process child = rt.exec("mysql -uroot -pmysql dbname");//这里执行的是mysql命令，用户名，密码以及要恢复的数据库，命令执行完后会从我们上传的文件里面读取要执行的内容 
			OutputStream out = child.getOutputStream();//控制台的输入信息作为输出流 
			String inStr; 
			StringBuffer sb = new StringBuffer(""); 
			String outStr; 
			BufferedReader br = new BufferedReader(new InputStreamReader(fis, "utf8")); 
			while ((inStr = br.readLine()) != null) { 
				sb.append(inStr + "\r\n"); 
			} 
			outStr = sb.toString(); 
			OutputStreamWriter writer = new OutputStreamWriter(out, "utf8"); 
			writer.write(outStr); 
			// 注：这里如果用缓冲方式写入文件的话，会导致中文乱码，用flush()方法则可以避免 
			writer.flush(); 
			out.close(); 
			br.close(); 
			writer.close(); 
			fis.close(); 
		} catch (Exception e) { 
			e.printStackTrace(); 
		} 
	}  
}


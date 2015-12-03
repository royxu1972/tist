package com.util;

public class MimeUtil {
	
	public static String getMimeContentType(String file_name){
		String content_type = "multipart/form-data";
		if(file_name.indexOf(".")>0){
			String type = file_name.substring(file_name.indexOf(".")+1,file_name.length());
			if(type.equalsIgnoreCase("doc")||type.equalsIgnoreCase("docx")){//Microsoft Word
				content_type = "application/msword";
			}
			if(type.equalsIgnoreCase("xls")||type.equalsIgnoreCase("xlsx")){//Microsoft Excel
				content_type = "application/msexcel";
			}
			if(type.equalsIgnoreCase("ppt")||type.equalsIgnoreCase("pptx")){//PPT
				content_type = "application/ms-powerpoint";
			}
			if(type.equalsIgnoreCase("txt")){//txt
				content_type = "text/plain";
			}
			if(type.equalsIgnoreCase("pdf")){//Adobe Acrobat
				content_type = "application/pdf";
			}
			if(type.equalsIgnoreCase("dms")||type.equalsIgnoreCase("lha")
					||type.equalsIgnoreCase("lzh")||type.equalsIgnoreCase("exe")
					||type.equalsIgnoreCase("class")){//可执行程序
				content_type = "application/octet-stream";
			}
			if(type.equalsIgnoreCase("ai")||type.equalsIgnoreCase("eps")||type.equalsIgnoreCase("ps")){//PostScript
				content_type = "application/postscript";
			}
			if(type.equalsIgnoreCase("rtf")){
				content_type = "appication/rtf";
			}
			if(type.equalsIgnoreCase("zip")||type.equalsIgnoreCase("7z")||type.equalsIgnoreCase("rar")){
				content_type = "application/zip";
			}
			if(type.equalsIgnoreCase("swf")){
				content_type = "application/x-shockwave-flash";
			}
			if(type.equalsIgnoreCase("gz")){
				content_type = "application/x-gzip";
			}
			if(type.equalsIgnoreCase("z")){
				content_type = "appication/x-compress";
			}
			if(type.equalsIgnoreCase("gtar")){
				content_type = "application/x-gtar";
			}
			if(type.equalsIgnoreCase("tar")){
				content_type = "application/x-tar";
			}
			if(type.equalsIgnoreCase("au")||type.equalsIgnoreCase("snd")){
				content_type = "audio/basic";
			}
			if(type.equalsIgnoreCase("mpeg")||type.equalsIgnoreCase("mp2")){
				content_type = "audio/mpeg";
			}
			if(type.equalsIgnoreCase("mid")||type.equalsIgnoreCase("midi")||type.equalsIgnoreCase("rmf")){
				content_type = "rmf";
			}
			if(type.equalsIgnoreCase("ram")||type.equalsIgnoreCase("ra")){
				content_type = "audio/x-pn-realaudio";
			}
			if(type.equalsIgnoreCase("rpm")){
				content_type = "audio/x-pn-realaudio-plugin";
			}
			if(type.equalsIgnoreCase("gif")){
				content_type = "image/gif";
			}
			if(type.equalsIgnoreCase("jpeg")||type.equalsIgnoreCase("jpg")||type.equalsIgnoreCase("jpe")){
				content_type = "image/jpeg";
			}
			if(type.equalsIgnoreCase("png")){
				content_type = "image/png";
			}
			if(type.equalsIgnoreCase("cgm")){
				content_type = "image/cgm";
			}
			if(type.equalsIgnoreCase("wav")){
				content_type = "audio/x-wav";
			}
			System.out.println(type);
		}
		return content_type;
	}
	
}

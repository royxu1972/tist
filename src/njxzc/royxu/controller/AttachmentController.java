package njxzc.royxu.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.core.Page;
import com.util.MimeUtil;
import com.util.StringUtil;
import com.util.generate.FileUtils;

import njxzc.royxu.searchmodel.DataGridModel;
import njxzc.royxu.domain.Attachment;
import njxzc.royxu.service.AttachmentServiceImpl;

/**
 * 附件Controller
 * @author LiangHong
 * @version 2015-10-02
 */
@Controller
public class AttachmentController {
	private static final Logger LOG = LoggerFactory.getLogger(AttachmentController.class);
	
	@Autowired
	private AttachmentServiceImpl attachmentService;
	
	//文件下载
	@RequestMapping(value="/download") 
    public void downloadFile(String file_name,String old_name,String file_type,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{  
		old_name = java.net.URLDecoder.decode(old_name,"UTF8");
		response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");  
        System.err.println("old_name:"+old_name);
        response.setHeader("Content-Disposition", "attachment;fileName="+new String(old_name.getBytes("GB2312"), "ISO_8859_1"));  
        String realPath = request.getSession().getServletContext().getRealPath("/attachment");
        realPath = realPath.replace("\\", "/");
        try {  
            File file=new File(realPath+"/"+file_name);
            file_type = MimeUtil.getMimeContentType(file_name);
            if(!StringUtil.isEmpty(file_type)){
            	System.err.println("文件类型是："+file_type);
            	 response.setContentType(file_type);
            }
            System.out.println(file.getAbsolutePath());  
            InputStream inputStream=new FileInputStream(file);  
            OutputStream os=response.getOutputStream();  
            byte[] b=new byte[1024];  
            int length;  
            while((length=inputStream.read(b))>0){  
                os.write(b,0,length);  
            }  
            inputStream.close();  
        } catch (FileNotFoundException e) {  
        	LOG.error(e.getMessage(), e);
            e.printStackTrace();  
        } catch (IOException e) {  
        	LOG.error(e.getMessage(), e);
            e.printStackTrace();  
        }  
    }
	
//	增加attachment
	@RequestMapping(value="/saveattachment",method=RequestMethod.POST)
	public ModelAndView saveAttachment(Attachment attachment, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			attachmentService.saveAttachment(attachment);
			mav.addObject("success",true);
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}

//	easyui分页查询attachments	
	@RequestMapping(value="/listattachments",method = RequestMethod.POST)
	public ModelAndView listAttachments(DataGridModel dmg, HttpSession session){
		int page = dmg.getPage();
		int rows = dmg.getRows();
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			Page pageData = attachmentService.getSysParams(page, rows);
			mav.addObject("total", pageData.getTotalCount());
			mav.addObject("rows", pageData.getData());
			mav.addObject("success",true);
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
	@RequestMapping(value="/listpagedattachments")
	public ModelAndView listPagedAttachments(int offset,int limit,String order){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			Page pageData = attachmentService.getPagedAttachments(offset, limit);
			mav.addObject("total", pageData.getTotalCount());
			mav.addObject("rows", pageData.getData());
			mav.addObject("success",true);
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
//	查询全部attachments	
	@RequestMapping(value="/listallattachments",method = RequestMethod.POST)
	public ModelAndView listAllAttachments(HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			List<Attachment> attachments = attachmentService.loadAllAttachments();
			mav.addObject("total", attachments.size());
			mav.addObject("rows", attachments);
			mav.addObject("success",true);
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}

//	删除所有的attachment，其中ids为主键的数组，需自定义，如需此方法解开注释修改
	@RequestMapping(value="/deleteattachments", method=RequestMethod.DELETE)
	public ModelAndView deleteAttachments(String[] ids, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			List<Attachment> attachments = new ArrayList<Attachment>();
			for(String id : ids){
				if(id!=""&&!id.equals("")){
					Attachment attachment = new Attachment();
					attachment.setAttachment_id(Integer.parseInt(id));
					attachments.add(attachment);
				}
			}
			attachmentService.deleteAttachments(attachments);
			mav.addObject("success",true);
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
//	删除一个attachment	
	@RequestMapping(value="/deleteattachment",method = RequestMethod.POST)
	public ModelAndView deleteAttachment(Attachment attachment, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			attachmentService.deleteAttachment(attachment);
			mav.addObject("success",true);
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
//	删除一个attachment	
	@RequestMapping(value="/deleteattachmentbyrelatedid",method = RequestMethod.POST)
	public ModelAndView deleteAttachmentByRelatedId(Attachment attachment, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			attachment.setDel_flag("1");
			attachmentService.deleteAttachment(attachment);
			mav.addObject("success",true);
			FileUtils.deleteFile(attachment.getFile_path());
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
//	更新attachment	
	@RequestMapping(value="/updateattachment",method = RequestMethod.POST)
	public ModelAndView updateAttachment(Attachment attachment, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			attachmentService.updateAttachment(attachment);
			mav.addObject("success",true);
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
}

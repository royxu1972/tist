package njxzc.royxu.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import njxzc.royxu.domain.Attachment;
import njxzc.royxu.domain.Homework;
import njxzc.royxu.searchmodel.DataGridModel;
import njxzc.royxu.searchmodel.SearchHomework;
import njxzc.royxu.service.AttachmentServiceImpl;
import njxzc.royxu.service.HomeworkServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.core.Page;
import com.util.DateUtil;
import com.util.StringUtil;

/**
 * 学生作业Controller
 * @author LiangHong
 * @version 2015-10-03
 */
@Controller
public class HomeworkController {
	
	@Autowired
	private HomeworkServiceImpl homeworkService;
	@Autowired
	private AttachmentServiceImpl attachmentService;
	
//	增加homework
	@RequestMapping(value="/savehomework",method=RequestMethod.POST)
	public ModelAndView saveHomework(Homework homework,MultipartHttpServletRequest multipartRequest,
			HttpServletRequest request, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			homework.setCreate_time(DateUtil.format2(new Date()));
			homework.setEdit_time(DateUtil.format2(new Date()));
			homework.setUser_no(session.getAttribute("user_no").toString());
			homeworkService.saveHomework(homework);
			String realPath = request.getSession().getServletContext().getRealPath("/attachment");
			realPath = realPath.replace("\\", "/");
			File file = new File(realPath);
			// 如果文件夹不存在则创建
			if (!file.exists() && !file.isDirectory()) {
				System.out.println("//不存在");
				file.mkdir();
			} else {
				System.out.println("//目录存在");
			}
			for (Iterator it = multipartRequest.getFileNames(); it.hasNext();) {
				String key = (String) it.next();
				MultipartFile mfile = multipartRequest.getFile(key);
				if (!mfile.isEmpty()) {
					String originalFilename = mfile.getOriginalFilename();
					String new_name = "homework_"+StringUtil.generateFileName();
					// 获得文件的后缀名
					String file_end_name = originalFilename.substring(originalFilename.indexOf("."),originalFilename.length());
					// 新文件名后加上后缀名
					new_name += file_end_name;
					String file_size = "" + mfile.getSize();
					String file_type = mfile.getContentType();
					mfile.transferTo(new File(realPath, new_name));
					Attachment attachment = new Attachment();
					attachment.setDel_flag("0");
					attachment.setFile_path(realPath + "/" + new_name);
					attachment.setFile_type(file_type);
					attachment.setFile_size(file_size);
					attachment.setNew_name(new_name);
					attachment.setOriginal_name(originalFilename);
					attachment.setRelated_id(homework.getHomework_id());
					attachment.setTable_of_attachment("roy_homework");
					attachmentService.saveAttachment(attachment);
					// System.err.println(n_file.toString());
				}
			}
			mav.addObject("success",true);
		}catch(Exception e){
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}

//	easyui分页查询homeworks	
	@RequestMapping(value="/listhomeworks",method = RequestMethod.POST)
	public ModelAndView listHomeworks(DataGridModel dmg,SearchHomework searchHomework, HttpSession session){
		int page = dmg.getPage();
		int rows = dmg.getRows();
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			Page pageData = homeworkService.getSysParams(page, rows,searchHomework);
			mav.addObject("total", pageData.getTotalCount());
			mav.addObject("rows", pageData.getData());
			mav.addObject("success",true);
		}catch(Exception e){
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
	@RequestMapping(value="/listpagedhomeworks")
	public ModelAndView listPagedHomeworks(int offset,int limit,
			SearchHomework searchHomework,String order, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			if(session.getAttribute("user_no") != null){
				searchHomework.setS_user_no(session.getAttribute("user_no").toString());
				Page pageData = homeworkService.getPagedHomeworks(offset, limit,searchHomework);
				mav.addObject("total", pageData.getTotalCount());
				mav.addObject("rows", pageData.getData());
				mav.addObject("success",true);
			}else{
				@SuppressWarnings("rawtypes")
				List list = new ArrayList();
				mav.addObject("total", 0);
				mav.addObject("rows", list);
				mav.addObject("msg", "获取user_no失败，无法查询到您的数据");
				mav.addObject("success",false);
			}
			
		}catch(Exception e){
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
	@RequestMapping(value="/listpagedhomeworks2")
	public ModelAndView listPagedHomeworks2(int offset,int limit,
			SearchHomework searchHomework,String order, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			Page pageData = homeworkService.getPagedHomeworks(offset, limit,searchHomework);
			mav.addObject("total", pageData.getTotalCount());
			mav.addObject("rows", pageData.getData());
			mav.addObject("success",true);
			
		}catch(Exception e){
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
//	查询全部homeworks	
	@RequestMapping(value="/listallhomeworks",method = RequestMethod.POST)
	public ModelAndView listAllHomeworks(HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			List<Homework> homeworks = homeworkService.loadAllHomeworks();
			mav.addObject("total", homeworks.size());
			mav.addObject("rows", homeworks);
			mav.addObject("success",true);
		}catch(Exception e){
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
//	查询全部homeworks	
	@RequestMapping(value="/listmyhomeworks",method = RequestMethod.POST)
	public ModelAndView listMyHomeworks(HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			if(session.getAttribute("user_no") != null){
				SearchHomework searchHomework = new SearchHomework();
				searchHomework.setS_user_no(session.getAttribute("user_no").toString());
				List<Homework> homeworks = homeworkService.findHomeworks(searchHomework);
				mav.addObject("total", homeworks.size());
				mav.addObject("rows", homeworks);
				mav.addObject("success",true);
			}else{
				@SuppressWarnings("rawtypes")
				List list = new ArrayList();
				mav.addObject("total", 0);
				mav.addObject("rows", list);
				mav.addObject("msg", "获取user_no失败，无法查询到您的数据");
				mav.addObject("success",false);
			}
		}catch(Exception e){
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
//	按条件查询
	@RequestMapping(value="/findhomeworks",method = RequestMethod.POST)
	public ModelAndView findHomeworks(SearchHomework searchHomework,HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			List<Homework> homeworks = homeworkService.findHomeworks(searchHomework);
			mav.addObject("total", homeworks.size());
			mav.addObject("rows", homeworks);
			mav.addObject("success",true);
		}catch(Exception e){
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
//	查询全部homeworks	
	@RequestMapping(value="/listhomeworksbycondtions",method = RequestMethod.POST)
	public ModelAndView listHomeworksByConditions(SearchHomework searchHomework ,HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			List<Homework> homeworks = homeworkService.searchHomework(searchHomework);
			mav.addObject("total", homeworks.size());
			mav.addObject("rows", homeworks);
			mav.addObject("success",true);
		}catch(Exception e){
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}

//	删除所有的homework，其中ids为主键的数组，需自定义，如需此方法解开注释修改
	@RequestMapping(value="/deletehomeworks")
	public ModelAndView deleteHomeworks(String[] ids, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			List<Homework> homeworks = new ArrayList<Homework>();
			for(String id : ids){
				if(id!=""&&!id.equals("")){
					//删除本地文件
					attachmentService.deleteAttachmentsByRelatedIdAndTname(id, "roy_homework");
					Homework homework = new Homework();
					homework.setHomework_id(id);
					homeworks.add(homework);
				}
			}
			homeworkService.deleteHomeworks(homeworks);
			mav.addObject("success",true);
		}catch(Exception e){
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
//	删除一个homework	
	@RequestMapping(value="/deletehomework",method = RequestMethod.POST)
	public ModelAndView deleteHomework(Homework homework, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			homeworkService.deleteHomework(homework);
			mav.addObject("success",true);
		}catch(Exception e){
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
//	更新homework	
	@RequestMapping(value="/updatehomework",method = RequestMethod.POST)
	public ModelAndView updateHomework(Homework homework,MultipartHttpServletRequest multipartRequest,
			HttpServletRequest request, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			homework.setEdit_time(DateUtil.format2(new Date()));
			homeworkService.updateHomework(homework);
			String realPath = request.getSession().getServletContext().getRealPath("/attachment");
			realPath = realPath.replace("\\", "/");
			File file = new File(realPath);
			// 如果文件夹不存在则创建
			if (!file.exists() && !file.isDirectory()) {
				System.out.println("//不存在");
				file.mkdir();
			} else {
				System.out.println("//目录存在");
			}
			for (Iterator it = multipartRequest.getFileNames(); it.hasNext();) {
				String key = (String) it.next();
				MultipartFile mfile = multipartRequest.getFile(key);
				if (!mfile.isEmpty()) {
					String originalFilename = mfile.getOriginalFilename();
					String new_name = "homework_"+StringUtil.generateFileName();
					// 获得文件的后缀名
					String file_end_name = originalFilename.substring(originalFilename.indexOf("."),originalFilename.length());
					// 新文件名后加上后缀名
					new_name += file_end_name;
					String file_size = "" + mfile.getSize();
					String file_type = mfile.getContentType();
					mfile.transferTo(new File(realPath, new_name));
					Attachment attachment = new Attachment();
					attachment.setDel_flag("0");
					attachment.setFile_path(realPath + "/" + new_name);
					attachment.setFile_type(file_type);
					attachment.setFile_size(file_size);
					attachment.setNew_name(new_name);
					attachment.setOriginal_name(originalFilename);
					attachment.setRelated_id(homework.getHomework_id());
					attachment.setTable_of_attachment("roy_homework");
					attachmentService.saveAttachment(attachment);
					// System.err.println(n_file.toString());
				}
			}
			mav.addObject("success",true);
		}catch(Exception e){
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
}

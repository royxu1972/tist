package njxzc.royxu.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import njxzc.royxu.domain.Attachment;
import njxzc.royxu.domain.Course;
import njxzc.royxu.searchmodel.DataGridModel;
import njxzc.royxu.searchmodel.SearchCourse;
import njxzc.royxu.service.AttachmentServiceImpl;
import njxzc.royxu.service.CourseServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.core.Page;
import com.util.StringUtil;

/**
 * 教学课程Controller
 * @author LiangHong
 * @version 2015-10-03
 */
@Controller
public class CourseController {
	
	@Autowired
	private CourseServiceImpl courseService;
	@Autowired
	private AttachmentServiceImpl attachmentService;
	
//	增加course
	@RequestMapping(value="/savecourse",method=RequestMethod.POST)
	public ModelAndView saveCourse(Course course,MultipartHttpServletRequest multipartRequest,
			HttpServletRequest request, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
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
					String new_name = "course_"+StringUtil.generateFileName();
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
					attachment.setRelated_id(""+course.getCourse_id());
					attachment.setTable_of_attachment("roy_course");
					attachmentService.saveAttachment(attachment);
					// System.err.println(n_file.toString());
				}
			}
			course.setUser_no(session.getAttribute("user_no").toString());
			courseService.saveCourse(course);
			mav.addObject("success",true);
		}catch(Exception e){
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}

//	easyui分页查询courses	
	@RequestMapping(value="/listcourses",method = RequestMethod.POST)
	public ModelAndView listCourses(DataGridModel dmg,SearchCourse searchCourse, HttpSession session){
		int page = dmg.getPage();
		int rows = dmg.getRows();
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			Page pageData = courseService.getSysParams(page, rows,searchCourse);
			mav.addObject("total", pageData.getTotalCount());
			mav.addObject("rows", pageData.getData());
			mav.addObject("success",true);
		}catch(Exception e){
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
	@RequestMapping(value="/listpagedcourses")
	public ModelAndView listPagedCourses(int offset,int limit,
			SearchCourse searchCourse,String order, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			if(session.getAttribute("user_no") != null){
				searchCourse.setS_user_no(session.getAttribute("user_no").toString());
				Page pageData = courseService.getPagedCourses(offset, limit,searchCourse);
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
	
//	查询全部courses	
	@RequestMapping(value="/listallcourses",method = RequestMethod.POST)
	public ModelAndView listAllCourses(HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			List<Course> courses = courseService.loadAllCourses();
			mav.addObject("total", courses.size());
			mav.addObject("rows", courses);
			mav.addObject("success",true);
		}catch(Exception e){
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
//	查询全部courses	
	@RequestMapping(value="/listmycourses",method = RequestMethod.POST)
	public ModelAndView listMyCourses(HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			if(session.getAttribute("user_no") != null){
				SearchCourse searchCourse = new SearchCourse();
				searchCourse.setS_user_no(session.getAttribute("user_no").toString());
				List<Course> courses = courseService.findCourses(searchCourse);
				mav.addObject("total", courses.size());
				mav.addObject("rows", courses);
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
	@RequestMapping(value="/findcourses",method = RequestMethod.POST)
	public ModelAndView findCourses(SearchCourse searchCourse,HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			List<Course> courses = courseService.findCourses(searchCourse);
			mav.addObject("total", courses.size());
			mav.addObject("rows", courses);
			mav.addObject("success",true);
		}catch(Exception e){
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}

//	删除所有的course，其中ids为主键的数组，需自定义，如需此方法解开注释修改
	@RequestMapping(value="/deletecourses", method=RequestMethod.POST)
	public ModelAndView deleteCourses(String[] ids, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			List<Course> courses = new ArrayList<Course>();
			for(String id : ids){
				if(id!=""&&!id.equals("")){
					attachmentService.deleteAttachmentsByRelatedIdAndTname(id, "roy_course");
					Course course = new Course();
					course.setCourse_id(id);
					courses.add(course);
				}
			}
			courseService.deleteCourses(courses);
			mav.addObject("success",true);
		}catch(Exception e){
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
//	删除一个course	
	@RequestMapping(value="/deletecourse",method = RequestMethod.POST)
	public ModelAndView deleteCourse(Course course, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			courseService.deleteCourse(course);
			mav.addObject("success",true);
		}catch(Exception e){
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
//	更新course	
	@RequestMapping(value="/updatecourse",method = RequestMethod.POST)
	public ModelAndView updateCourse(Course course,MultipartHttpServletRequest multipartRequest,
			HttpServletRequest request, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
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
					String new_name = "course_"+StringUtil.generateFileName();
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
					attachment.setRelated_id(""+course.getCourse_id());
					attachment.setTable_of_attachment("roy_course");
					attachmentService.saveAttachment(attachment);
					// System.err.println(n_file.toString());
				}
			}
			courseService.updateCourse(course);
			mav.addObject("success",true);
		}catch(Exception e){
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
}

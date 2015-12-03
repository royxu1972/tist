package njxzc.royxu.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import njxzc.royxu.domain.Attachment;
import njxzc.royxu.domain.StudentProject;
import njxzc.royxu.searchmodel.DataGridModel;
import njxzc.royxu.searchmodel.SearchStudentProject;
import njxzc.royxu.service.AttachmentServiceImpl;
import njxzc.royxu.service.StudentProjectServiceImpl;

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
 * 学生项目Controller
 * @author LiangHong
 * @version 2015-10-03
 */
@Controller
public class StudentProjectController {
	
	@Autowired
	private StudentProjectServiceImpl studentProjectService;
	@Autowired
	private AttachmentServiceImpl attachmentService;
	
//	增加studentProject
	@RequestMapping(value="/savestudentproject",method=RequestMethod.POST)
	public ModelAndView saveStudentProject(StudentProject studentProject,MultipartHttpServletRequest multipartRequest,
			HttpServletRequest request, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			studentProject.setUser_no(session.getAttribute("user_no").toString());
			studentProjectService.saveStudentProject(studentProject);
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
					String new_name = "stuproj_"+StringUtil.generateFileName();
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
					attachment.setRelated_id(studentProject.getStu_proj_id());
					attachment.setTable_of_attachment("roy_student_project");
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

//	easyui分页查询studentProjects	
	@RequestMapping(value="/liststudentprojects",method = RequestMethod.POST)
	public ModelAndView listStudentProjects(DataGridModel dmg,SearchStudentProject searchStudentProject, HttpSession session){
		int page = dmg.getPage();
		int rows = dmg.getRows();
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			Page pageData = studentProjectService.getSysParams(page, rows,searchStudentProject);
			mav.addObject("total", pageData.getTotalCount());
			mav.addObject("rows", pageData.getData());
			mav.addObject("success",true);
		}catch(Exception e){
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
	@RequestMapping(value="/listpagedstudentprojects")
	public ModelAndView listPagedStudentProjects(int offset,int limit,
			SearchStudentProject searchStudentProject,String order, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			if(session.getAttribute("user_no") != null){
				searchStudentProject.setS_user_no(session.getAttribute("user_no").toString());
				Page pageData = studentProjectService.getPagedStudentProjects(offset, limit,searchStudentProject);
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
	
//	查询全部studentProjects	
	@RequestMapping(value="/listallstudentprojects",method = RequestMethod.POST)
	public ModelAndView listAllStudentProjects(HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			List<StudentProject> studentProjects = studentProjectService.loadAllStudentProjects();
			mav.addObject("total", studentProjects.size());
			mav.addObject("rows", studentProjects);
			mav.addObject("success",true);
		}catch(Exception e){
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
//	按条件查询
	@RequestMapping(value="/findstudentprojects",method = RequestMethod.POST)
	public ModelAndView findStudentProjects(SearchStudentProject searchStudentProject,HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			List<StudentProject> studentProjects = studentProjectService.findStudentProjects(searchStudentProject);
			mav.addObject("total", studentProjects.size());
			mav.addObject("rows", studentProjects);
			mav.addObject("success",true);
		}catch(Exception e){
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
//	查询全部studentProjects	
	@RequestMapping(value="/liststudentprojectsbyconditions",method = RequestMethod.POST)
	public ModelAndView listStudentProjectsByConditions(SearchStudentProject searchStudentProject,HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			List<StudentProject> studentProjects = studentProjectService.searchStudentProject(searchStudentProject);
			mav.addObject("total", studentProjects.size());
			mav.addObject("rows", studentProjects);
			mav.addObject("success",true);
		}catch(Exception e){
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}

//	删除所有的studentProject，其中ids为主键的数组，需自定义，如需此方法解开注释修改
	@RequestMapping(value="/deletestudentprojects")
	public ModelAndView deleteStudentProjects(String[] ids, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			List<StudentProject> studentProjects = new ArrayList<StudentProject>();
			for(String id : ids){
				if(id!=""&&!id.equals("")){
					//删除本地文件
					attachmentService.deleteAttachmentsByRelatedIdAndTname(id, "roy_student_project");
					StudentProject studentProject = new StudentProject();
					studentProject.setStu_proj_id(id);
					studentProjects.add(studentProject);
				}
			}
			studentProjectService.deleteStudentProjects(studentProjects);
			mav.addObject("success",true);
		}catch(Exception e){
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
//	删除一个studentProject	
	@RequestMapping(value="/deletestudentproject",method = RequestMethod.POST)
	public ModelAndView deleteStudentProject(StudentProject studentProject, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			studentProjectService.deleteStudentProject(studentProject);
			mav.addObject("success",true);
		}catch(Exception e){
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
//	更新studentProject	
	@RequestMapping(value="/updatestudentproject",method = RequestMethod.POST)
	public ModelAndView updateStudentProject(StudentProject studentProject,MultipartHttpServletRequest multipartRequest,
			HttpServletRequest request, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			studentProjectService.updateStudentProject(studentProject);
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
					String new_name = "stuproj_"+StringUtil.generateFileName();
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
					attachment.setRelated_id(studentProject.getStu_proj_id());
					attachment.setTable_of_attachment("roy_student_project");
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

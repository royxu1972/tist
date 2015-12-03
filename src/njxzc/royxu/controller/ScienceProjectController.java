package njxzc.royxu.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import njxzc.royxu.domain.Attachment;
import njxzc.royxu.domain.ScienceProject;
import njxzc.royxu.searchmodel.DataGridModel;
import njxzc.royxu.searchmodel.SearchScienceProject;
import njxzc.royxu.service.AttachmentServiceImpl;
import njxzc.royxu.service.ScienceProjectServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
 * 科研项目Controller
 * @author LiangHong
 * @version 2015-10-03
 */
@Controller
public class ScienceProjectController {
	private static final Logger LOG = LoggerFactory.getLogger(ScienceProjectController.class);
	
	@Autowired
	private ScienceProjectServiceImpl scienceProjectService;
	@Autowired
	private AttachmentServiceImpl attachmentService;
	
//	增加scienceProject
	@RequestMapping(value="/savescienceproject",method=RequestMethod.POST)
	public ModelAndView saveScienceProject(ScienceProject scienceProject,MultipartHttpServletRequest multipartRequest,
			HttpServletRequest request, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			scienceProject.setUser_no(session.getAttribute("user_no").toString());
			scienceProjectService.saveScienceProject(scienceProject);
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
					String new_name = "scienceproj_"+StringUtil.generateFileName();
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
					attachment.setRelated_id(scienceProject.getProj_id());
					attachment.setTable_of_attachment("roy_science_project");
					attachmentService.saveAttachment(attachment);
					// System.err.println(n_file.toString());
				}
			}
			mav.addObject("success",true);
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}

//	easyui分页查询scienceProjects	
	@RequestMapping(value="/listscienceprojects",method = RequestMethod.POST)
	public ModelAndView listScienceProjects(DataGridModel dmg,SearchScienceProject searchScienceProject, HttpSession session){
		int page = dmg.getPage();
		int rows = dmg.getRows();
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			Page pageData = scienceProjectService.getSysParams(page, rows,searchScienceProject);
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
	
	@RequestMapping(value="/listpagedscienceprojects")
	public ModelAndView listPagedScienceProjects(int offset,int limit,
			SearchScienceProject searchScienceProject,String order, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			if(session.getAttribute("user_no") != null){
				searchScienceProject.setS_user_no(session.getAttribute("user_no").toString());
				Page pageData = scienceProjectService.getPagedScienceProjects(offset, limit,searchScienceProject);
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
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
//	查询全部scienceProjects	
	@RequestMapping(value="/listallscienceprojects",method = RequestMethod.POST)
	public ModelAndView listAllScienceProjects(HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			List<ScienceProject> scienceProjects = scienceProjectService.loadAllScienceProjects();
			mav.addObject("total", scienceProjects.size());
			mav.addObject("rows", scienceProjects);
			mav.addObject("success",true);
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
//	按条件查询
	@RequestMapping(value="/findscienceprojects",method = RequestMethod.POST)
	public ModelAndView findScienceProjects(SearchScienceProject searchScienceProject,HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			List<ScienceProject> scienceProjects = scienceProjectService.findScienceProjects(searchScienceProject);
			mav.addObject("total", scienceProjects.size());
			mav.addObject("rows", scienceProjects);
			mav.addObject("success",true);
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
//	查询全部scienceProjects	
	@RequestMapping(value="/listscienceprojectsbyconditions",method = RequestMethod.POST)
	public ModelAndView listScienceProjectsByConditions(SearchScienceProject searchScienceProject ,HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			List<ScienceProject> scienceProjects = scienceProjectService.searchScienceProject(searchScienceProject);
			mav.addObject("total", scienceProjects.size());
			mav.addObject("rows", scienceProjects);
			mav.addObject("success",true);
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}

//	删除所有的scienceProject，其中ids为主键的数组，需自定义，如需此方法解开注释修改
	@RequestMapping(value="/deletescienceprojects")
	public ModelAndView deleteScienceProjects(String[] ids, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			List<ScienceProject> scienceProjects = new ArrayList<ScienceProject>();
			for(String id : ids){
				if(id!=""&&!id.equals("")){
					//删除本地文件
					attachmentService.deleteAttachmentsByRelatedIdAndTname(id, "roy_science_project");
					ScienceProject scienceProject = new ScienceProject();
					scienceProject.setProj_id(id);
					scienceProjects.add(scienceProject);
				}
			}
			scienceProjectService.deleteScienceProjects(scienceProjects);
			mav.addObject("success",true);
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
//	删除一个scienceProject	
	@RequestMapping(value="/deletescienceproject",method = RequestMethod.POST)
	public ModelAndView deleteScienceProject(ScienceProject scienceProject, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			scienceProjectService.deleteScienceProject(scienceProject);
			mav.addObject("success",true);
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
//	更新scienceProject	
	@RequestMapping(value="/updatescienceproject",method = RequestMethod.POST)
	public ModelAndView updateScienceProject(ScienceProject scienceProject,MultipartHttpServletRequest multipartRequest,
			HttpServletRequest request, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			scienceProjectService.updateScienceProject(scienceProject);
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
					String new_name = "scienceproj_"+StringUtil.generateFileName();
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
					attachment.setRelated_id(scienceProject.getProj_id());
					attachment.setTable_of_attachment("roy_science_project");
					attachmentService.saveAttachment(attachment);
					// System.err.println(n_file.toString());
				}
			}
			mav.addObject("success",true);
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
}

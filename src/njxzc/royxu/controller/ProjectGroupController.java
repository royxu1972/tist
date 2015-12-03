package njxzc.royxu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.core.Page;

import njxzc.royxu.searchmodel.DataGridModel;
import njxzc.royxu.domain.ProjectGroup;
import njxzc.royxu.service.ProjectGroupServiceImpl;

/**
 * 项目组Controller
 * @author LiangHong
 * @version 2015-10-24
 */
@Controller
public class ProjectGroupController {
	private static final Logger LOG = LoggerFactory.getLogger(ProjectGroupController.class);
	
	@Autowired
	private ProjectGroupServiceImpl projectGroupService;
	
//	增加projectGroup
	@RequestMapping(value="/saveprojectgroup",method=RequestMethod.POST)
	public ModelAndView saveProjectGroup(ProjectGroup projectGroup, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			projectGroupService.saveProjectGroup(projectGroup);
			mav.addObject("success",true);
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}

//	easyui分页查询projectGroups	
	@RequestMapping(value="/listprojectgroups",method = RequestMethod.POST)
	public ModelAndView listProjectGroups(DataGridModel dmg, HttpSession session){
		int page = dmg.getPage();
		int rows = dmg.getRows();
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			Page pageData = projectGroupService.getSysParams(page, rows);
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
	
	@RequestMapping(value="/listpagedprojectgroups")
	public ModelAndView listPagedProjectGroups(int offset,int limit,String order){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			Page pageData = projectGroupService.getPagedProjectGroups(offset, limit);
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
	
//	查询全部projectGroups	
	@RequestMapping(value="/listallprojectgroups",method = RequestMethod.POST)
	public ModelAndView listAllProjectGroups(HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			List<ProjectGroup> projectGroups = projectGroupService.loadAllProjectGroups();
			mav.addObject("total", projectGroups.size());
			mav.addObject("rows", projectGroups);
			mav.addObject("success",true);
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}

//	删除所有的projectGroup，其中ids为主键的数组，需自定义，如需此方法解开注释修改
//	@RequestMapping(value="/deleteprojectgroups", method=RequestMethod.DELETE)
//	public ModelAndView deleteProjectGroups(String[] ids, HttpSession session){
//		ModelAndView mav = new ModelAndView("jsonView");
//		try{
//			List<ProjectGroup> projectGroups = new ArrayList<ProjectGroup>();
//			for(String id : ids){
//				if(id!=""&&!id.equals("")){
//					ProjectGroup projectGroup = new ProjectGroup();
//					projectGroup.setProjectGroup_id(Integer.parseInt(id));
//					projectGroups.add(projectGroup);
//				}
//			}
//			projectGroupService.deleteProjectGroups(projectGroups);
//			mav.addObject("success",true);
//		}catch(Exception e){
//			LOG.error(e.getMessage(), e);
//			mav.addObject("success", false);
//			mav.addObject("msg", e.getMessage());
//		}
//		return mav;
//	}
	
//	删除一个projectGroup	
	@RequestMapping(value="/deleteprojectgroup",method = RequestMethod.POST)
	public ModelAndView deleteProjectGroup(ProjectGroup projectGroup, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			projectGroupService.deleteProjectGroup(projectGroup);
			mav.addObject("success",true);
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
//	更新projectGroup	
	@RequestMapping(value="/updateprojectgroup",method = RequestMethod.POST)
	public ModelAndView updateProjectGroup(ProjectGroup projectGroup, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			projectGroupService.updateProjectGroup(projectGroup);
			mav.addObject("success",true);
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
}

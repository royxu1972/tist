package njxzc.royxu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import njxzc.royxu.domain.Experience;
import njxzc.royxu.searchmodel.DataGridModel;
import njxzc.royxu.searchmodel.SearchExperience;
import njxzc.royxu.service.ExperienceServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.core.Page;

/**
 * 个人经历Controller
 * @author LiangHong
 * @version 2015-10-03
 */
@Controller
public class ExperienceController {
	
	@Autowired
	private ExperienceServiceImpl experienceService;
	
//	增加experience
	@RequestMapping(value="/saveexperience",method=RequestMethod.POST)
	public ModelAndView saveExperience(Experience experience, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			experience.setUser_no(session.getAttribute("user_no").toString());
			experienceService.saveExperience(experience);
			mav.addObject("success",true);
		}catch(Exception e){
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}

//	easyui分页查询experiences	
	@RequestMapping(value="/listexperiences",method = RequestMethod.POST)
	public ModelAndView listExperiences(DataGridModel dmg,SearchExperience searchExperience, HttpSession session){
		int page = dmg.getPage();
		int rows = dmg.getRows();
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			Page pageData = experienceService.getSysParams(page, rows,searchExperience);
			mav.addObject("total", pageData.getTotalCount());
			mav.addObject("rows", pageData.getData());
			mav.addObject("success",true);
		}catch(Exception e){
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
	@RequestMapping(value="/listpagedexperiences")
	public ModelAndView listPagedExperiences(int offset,int limit,
			SearchExperience searchExperience,String order, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			if(session.getAttribute("user_no") != null){
				searchExperience.setS_user_no(session.getAttribute("user_no").toString());
				Page pageData = experienceService.getPagedExperiences(offset, limit,searchExperience);
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
	
//	查询全部experiences	
	@RequestMapping(value="/listallexperiences",method = RequestMethod.POST)
	public ModelAndView listAllExperiences(HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			List<Experience> experiences = experienceService.loadAllExperiences();
			mav.addObject("total", experiences.size());
			mav.addObject("rows", experiences);
			mav.addObject("success",true);
		}catch(Exception e){
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
//	按条件查询
	@RequestMapping(value="/findexperiences",method = RequestMethod.POST)
	public ModelAndView findExperiences(SearchExperience searchExperience,HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			List<Experience> experiences = experienceService.findExperiences(searchExperience);
			mav.addObject("total", experiences.size());
			mav.addObject("rows", experiences);
			mav.addObject("success",true);
		}catch(Exception e){
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}

//	删除所有的experience，其中ids为主键的数组，需自定义，如需此方法解开注释修改
	@RequestMapping(value="/deleteexperiences", method=RequestMethod.DELETE)
	public ModelAndView deleteExperiences(String[] ids, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			List<Experience> experiences = new ArrayList<Experience>();
			for(String id : ids){
				if(id!=""&&!id.equals("")){
					Experience experience = new Experience();
					experience.setExperience_id(Integer.parseInt(id));
					experiences.add(experience);
				}
			}
			experienceService.deleteExperiences(experiences);
			mav.addObject("success",true);
		}catch(Exception e){
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
//	删除一个experience	
	@RequestMapping(value="/deleteexperience",method = RequestMethod.POST)
	public ModelAndView deleteExperience(Experience experience, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			experienceService.deleteExperience(experience);
			mav.addObject("success",true);
		}catch(Exception e){
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
//	更新experience	
	@RequestMapping(value="/updateexperience",method = RequestMethod.POST)
	public ModelAndView updateExperience(Experience experience, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			experienceService.updateExperience(experience);
			mav.addObject("success",true);
		}catch(Exception e){
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
}

package njxzc.royxu.controller;

import javax.servlet.http.HttpSession;

import njxzc.royxu.domain.UserRole;
import njxzc.royxu.searchmodel.DataGridModel;
import njxzc.royxu.service.UserRoleServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.core.Page;

@Controller
public class UserRoleController {
	@Autowired
	UserRoleServiceImpl userRoleService;
	
	@RequestMapping(value="/saveuserrole",method=RequestMethod.POST)
	public ModelAndView regin(UserRole user_role, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			userRoleService.saveUserRole(user_role);
			mav.addObject("success",true);
		}catch(Exception e){
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
	@RequestMapping(value="/listuserroles",method = RequestMethod.POST)
	public ModelAndView listUserRoles(DataGridModel dmg){
		int page = dmg.getPage();
		int rows = dmg.getRows();
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			Page pageData = userRoleService.getSysParams(page, rows);
			mav.addObject("total", pageData.getTotalCount());
			mav.addObject("rows", pageData.getData());
			mav.addObject("success",true);
		}catch(Exception e){
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
	@RequestMapping(value="/deleteuserrole", method=RequestMethod.DELETE)
	public ModelAndView deleteUserRoles(UserRole user_role, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			userRoleService.deleteUserRole(user_role);
			mav.addObject("success",true);
		}catch(Exception e){
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
	@RequestMapping(value="/updateuserrole",method = RequestMethod.POST)
	public ModelAndView listUserRoles(UserRole user_role, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			userRoleService.updateUserRole(user_role);
			mav.addObject("success",true);
		}catch(Exception e){
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
}

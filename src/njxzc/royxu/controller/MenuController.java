package njxzc.royxu.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import njxzc.royxu.domain.Menu;
import njxzc.royxu.service.MenuServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.util.DateUtil;
import com.util.TreeNode;

@Controller
public class MenuController {
	private static final Logger LOG = LoggerFactory.getLogger(MenuController.class);
	
	@Autowired
	private MenuServiceImpl menuService;
	
	@RequestMapping("/menutree")
	@ResponseBody
	public List<TreeNode> getMenuCombotree(Integer id) {
		return this.menuService.getTree(id);
	}
	
	@RequestMapping(value="/savemenu",method=RequestMethod.POST)
	public ModelAndView saveMenu(Menu menu,HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			menu.setDel_flag("0");
			menu.setCreate_by(""+session.getAttribute("user_name"));
			String create_time = DateUtil.format2(new Date());
			menu.setCreate_time(create_time);
			menu.setUpdate_by(""+session.getAttribute("user_name"));
			menu.setUpdate_time(create_time);
			menuService.saveMenu(menu);
			mav.addObject("success",true);
		}catch(Exception e){
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
	@RequestMapping(value="/updatemenu",method=RequestMethod.POST)
	public ModelAndView updateMenu(Menu menu,HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			menu.setUpdate_by(""+session.getAttribute("user_name"));
			String update_time = DateUtil.format2(new Date());
			menu.setUpdate_time(update_time);
			menuService.updateMenu(menu);
			mav.addObject("success",true);
		}catch(Exception e){
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
	@RequestMapping(value="/deletemenu",method=RequestMethod.POST)
	public ModelAndView deleteMenu(Menu menu,HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			menu.setDel_flag("1");
			menuService.updateMenu(menu);
			mav.addObject("success",true);
		}catch(Exception e){
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
	//载入一级菜单
	@RequestMapping(value="/listlevelonemenu",method=RequestMethod.POST)
	public ModelAndView listLevelOneMenu(HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			List<Menu> menus = menuService.loadLevelOneMenus();
			mav.addObject("rows",menus);
			mav.addObject("success",true);
		}catch(Exception e){
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getmenusbysession", method = RequestMethod.POST)
	public ModelAndView getmenusbysession(HttpSession session) {
		ModelAndView mav = new ModelAndView("jsonView");
		try {
			if (session != null) {
				List<Menu> parentMenus = (List<Menu>) session.getAttribute("parentMenus");
				List<Menu> childMenus = (List<Menu>) session.getAttribute("childMenus");
				mav.addObject("success", true);
				mav.addObject("parentMenus", parentMenus);
				mav.addObject("childMenus", childMenus);
			} else {
				mav.addObject("success", false);
				mav.addObject("msg", "用户未登录或登录超时");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
}

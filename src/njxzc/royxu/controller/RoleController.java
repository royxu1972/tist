package njxzc.royxu.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import njxzc.royxu.domain.Menu;
import njxzc.royxu.domain.Role;
import njxzc.royxu.domain.RoleMenu;
import njxzc.royxu.searchmodel.DataGridModel;
import njxzc.royxu.service.MenuServiceImpl;
import njxzc.royxu.service.RoleMenuServiceImpl;
import njxzc.royxu.service.RoleServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.core.Page;
import com.util.DateUtil;
import com.util.StringUtil;

@Controller
public class RoleController {
	private static final Logger LOG = LoggerFactory.getLogger(RoleController.class);
	
	@Autowired
	RoleServiceImpl roleService;
	@Autowired
	RoleMenuServiceImpl roleMenuService;
	@Autowired
	MenuServiceImpl menuService;

	// 管理员增加用户
	@RequestMapping(value = "/saverole", method = RequestMethod.POST)
	public ModelAndView saveRole(Role role, HttpSession session) {
		ModelAndView mav = new ModelAndView("jsonView");
		try {
			role.setCreate_by("" + session.getAttribute("user_name"));
			String create_time = DateUtil.format2(new Date());
			role.setCreate_time(create_time);
			role.setUpdate_by("" + session.getAttribute("user_name"));
			role.setUpdate_time(create_time);
			roleService.saveRole(role);
			mav.addObject("success", true);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
	// 管理员增加用户
	@RequestMapping(value = "/saverole2", method = RequestMethod.POST)
	public ModelAndView saveRole2(Role role, HttpSession session) {
		ModelAndView mav = new ModelAndView("jsonView");
		try {
			role.setCreate_by("" + session.getAttribute("user_name"));
			String create_time = DateUtil.format2(new Date());
			role.setCreate_time(create_time);
			role.setUpdate_by("" + session.getAttribute("user_name"));
			role.setUpdate_time(create_time);
//					roleService.saveRole(role);
			role = roleService.saveRoleReturnId(role);
			if(role.getRole_id() != 0){
				List<Menu> menus = menuService.getMenuByMenuIds(role.getMenu_ids());
				List<RoleMenu> roleMenus = new ArrayList<RoleMenu>();
				for(Menu menu:menus){
					RoleMenu roleMenu = new RoleMenu();
					roleMenu.setRole_id(role.getRole_id());
					roleMenu.setMenu_id(""+menu.getMenu_id());
					roleMenu.setMenu_father_id(""+menu.getFather_id());
					roleMenus.add(roleMenu);
				}
				roleMenuService.saveAllRoleMenus(roleMenus);
				mav.addObject("success", true);
			}else{
				mav.addObject("success", false);
				mav.addObject("msg", "获取role_id失败");
			}
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}

	@RequestMapping(value = "/listroles", method = RequestMethod.POST)
	public ModelAndView listRoles(DataGridModel dmg) {
		int page = dmg.getPage();
		int rows = dmg.getRows();
		ModelAndView mav = new ModelAndView("jsonView");
		try {
			Page pageData = roleService.getSysParams(page, rows);
			mav.addObject("total", pageData.getTotalCount());
			mav.addObject("rows", pageData.getData());
			mav.addObject("success", true);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
	@RequestMapping(value = "/listallroles", method = RequestMethod.POST)
	public ModelAndView listAllRoles() {
		ModelAndView mav = new ModelAndView("jsonView");
		try {
			mav.addObject("rows", roleService.loadAllRoles());
			mav.addObject("success", true);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}

	@RequestMapping(value = "/deleteroles", method = RequestMethod.DELETE)
	public ModelAndView deleteRoles(Role role, HttpSession session) {
		ModelAndView mav = new ModelAndView("jsonView");
		try {
			roleService.deleteRole(role);
			mav.addObject("success", true);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}

	@RequestMapping(value = "/updaterole", method = RequestMethod.POST)
	public ModelAndView listRoles(Role role, HttpSession session) {
		ModelAndView mav = new ModelAndView("jsonView");
		try {
			role.setUpdate_by("" + session.getAttribute("user_name"));
			String update_time = DateUtil.format2(new Date());
			role.setUpdate_time(update_time);
			roleService.updateRole(role);
			mav.addObject("success", true);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
	@RequestMapping(value = "/updaterole2", method = RequestMethod.POST)
	public ModelAndView updaRole2(Role role, HttpSession session) {
		ModelAndView mav = new ModelAndView("jsonView");
		try {
			role.setUpdate_by("" + session.getAttribute("user_name"));
			String update_time = DateUtil.format2(new Date());
			role.setUpdate_time(update_time);
			roleService.updateRole(role);
			roleMenuService.deleteRoleMenuByRoleId(role.getRole_id());//删除RoleMenu
			if(role.getRole_id() != 0&&!StringUtil.isEmpty(role.getMenu_ids())){//删除时没有role_ids需要插入
				List<Menu> menus = menuService.getMenuByMenuIds(role.getMenu_ids());
				List<RoleMenu> roleMenus = new ArrayList<RoleMenu>();
				for(Menu menu:menus){
					RoleMenu roleMenu = new RoleMenu();
					roleMenu.setRole_id(role.getRole_id());
					roleMenu.setMenu_id(""+menu.getMenu_id());
					roleMenu.setMenu_father_id(""+menu.getFather_id());
					roleMenus.add(roleMenu);
				}
				roleMenuService.saveAllRoleMenus(roleMenus);
			}
			mav.addObject("success", true);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
}

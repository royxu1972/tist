package njxzc.royxu.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import njxzc.royxu.domain.Menu;
import njxzc.royxu.domain.RoleMenu;
import njxzc.royxu.searchmodel.DataGridModel;
import njxzc.royxu.service.MenuServiceImpl;
import njxzc.royxu.service.RoleMenuServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.core.Page;

/**
 * 角色菜单管理Controller
 * @author Author
 * @version 2015-07-24
 */
@Controller
public class RoleMenuController {
	private static final Logger LOG = LoggerFactory.getLogger(RoleMenuController.class);
	
	@Autowired
	private RoleMenuServiceImpl roleMenuService;
	@Autowired
	private MenuServiceImpl menuService;
	
//	增加roleMenu
	@RequestMapping(value="/saverolemenu",method=RequestMethod.POST)
	public ModelAndView saveRoleMenu(RoleMenu roleMenu, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			roleMenuService.saveRoleMenu(roleMenu);
			mav.addObject("success",true);
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}

//	easyui分页查询roleMenus	
	@RequestMapping(value="/listrolemenus",method = RequestMethod.POST)
	public ModelAndView listRoleMenus(DataGridModel dmg, HttpSession session){
		int page = dmg.getPage();
		int rows = dmg.getRows();
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			Page pageData = roleMenuService.getSysParams(page, rows);
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
	
//	查询全部roleMenus	
	@RequestMapping(value="/listallrolemenus",method = RequestMethod.POST)
	public ModelAndView listAllRoleMenus(HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			List<RoleMenu> roleMenus = roleMenuService.loadAllRoleMenus();
			mav.addObject("total", roleMenus.size());
			mav.addObject("rows", roleMenus);
			mav.addObject("success",true);
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
//	查询全部roleMenus	
	@RequestMapping(value="/findrolemenusbyid",method = RequestMethod.POST)
	public ModelAndView findRoleMenusById(Integer mentu_father_id,HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			String role_ids = session.getAttribute("role_ids").toString();
			List<Menu> menus = menuService.findMenuByFatherIdRoleId(role_ids, mentu_father_id);
//			List<RoleMenu> roleMenus = roleMenuService.loadAllRoleMenus();
			mav.addObject("total", menus.size());
			mav.addObject("rows", menus);
			mav.addObject("success",true);
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
//	删除所有的roleMenu，其中ids为主键的数组，需自定义，如需此方法解开注释修改
//	@RequestMapping(value="/deleterolemenus", method=RequestMethod.POST)
//	public ModelAndView deleteRoleMenus(String[] ids, HttpSession session){
//		ModelAndView mav = new ModelAndView("jsonView");
//		try{
//			List<RoleMenu> roleMenus = new ArrayList<RoleMenu>();
//			for(String id : ids){
//				if(id!=""&&!id.equals("")){
//					RoleMenu roleMenu = new RoleMenu();
//					roleMenu.setRoleMenu_id(Integer.parseInt(id));
//					roleMenus.add(roleMenu);
//				}
//			}
//			roleMenuService.deleteRoleMenus(roleMenus);
//			mav.addObject("success",true);
//		}catch(Exception e){
//			LOG.error(e.getMessage(), e);
//			mav.addObject("success", false);
//			mav.addObject("msg", e.getMessage());
//		}
//		return mav;
//	}
	
//	删除一个roleMenu	
	@RequestMapping(value="/deleterolemenu",method = RequestMethod.POST)
	public ModelAndView deleteRoleMenu(RoleMenu roleMenu, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			roleMenuService.deleteRoleMenu(roleMenu);
			mav.addObject("success",true);
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
//	更新roleMenu	
	@RequestMapping(value="/updaterolemenu",method = RequestMethod.POST)
	public ModelAndView updateRoleMenu(RoleMenu roleMenu, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			roleMenuService.updateRoleMenu(roleMenu);
			mav.addObject("success",true);
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
}

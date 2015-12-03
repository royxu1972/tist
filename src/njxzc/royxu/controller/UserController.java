package njxzc.royxu.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import njxzc.royxu.domain.Menu;
import njxzc.royxu.domain.Role;
import njxzc.royxu.domain.User;
import njxzc.royxu.searchmodel.DataGridModel;
import njxzc.royxu.searchmodel.SearchUser;
import njxzc.royxu.service.MenuServiceImpl;
import njxzc.royxu.service.RoleServiceImpl;
import njxzc.royxu.service.UserRoleServiceImpl;
import njxzc.royxu.service.UserServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.core.Page;
import com.util.DateUtil;

@Controller
public class UserController {
	private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserServiceImpl userService;
	@Autowired
	private UserRoleServiceImpl userRoleService;
	@Autowired
	private MenuServiceImpl menuService;
	@Autowired
	private RoleServiceImpl roleService;
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView login(User user, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			if((user = userService.login(user))!=null){//登陆成功
				session.setAttribute("user_id", user.getUser_id());
				session.setAttribute("user_no", user.getUser_no());
				session.setAttribute("user_name", user.getUser_name());
				session.setAttribute("login_name", user.getLogin_name());
				System.err.println("+++++++++++++++++++++++++++++\n"+user.toString());
				List<Menu> menus = menuService.findMenusByUserId(user.getUser_id());
				System.err.println("menu size="+menus.size());
				mav.addObject("success",true);
				if(menus != null && menus.size()>0){
					List<Menu> parent_menus = new ArrayList<Menu>();
					List<Menu> child_menus = new ArrayList<Menu>();
					for(Menu m : menus){
						if("1".equals(m.getMenu_level())){
							parent_menus.add(m);
						}
						if("2".equals(m.getMenu_level())){
							child_menus.add(m);
						}
					}
					session.removeAttribute("parentMenus");
					session.removeAttribute("childMenus");
					session.setAttribute("parentMenus", parent_menus);
					session.setAttribute("childMenus", child_menus);
//					mav.setViewName("redirect:/jsp/index/index.jsp");
				}
//				UserRole user_role;
//				if((user_role = userRoleService.findUserRoleByUserId(user.getUser_id()))!=null){//查询角色id
//					session.setAttribute("role_ids", user_role.getRole_ids());
//				}else{
//					session.setAttribute("role_ids", "null");
//				}
			}else{//登陆失败
				mav.addObject("msg","用户名密码错误");
				mav.addObject("success",false);
			}
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
	@RequestMapping(value="/afterroleselect",method=RequestMethod.GET)
	public ModelAndView afterRoleSelect(HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			if(session.getAttribute("role_ids")!=null){
				if("null".equals(session.getAttribute("role_ids").toString())){
					mav.addObject("success", false);
					mav.addObject("msg", "role_ids为空");
				}else{
					List<Role> roles = roleService.findRoleByRoleIds(session.getAttribute("role_ids").toString());
					String menu_ids = "";
					for(Role r : roles){
						if(!("".equals(menu_ids))) menu_ids += ",";
						menu_ids += r.getMenu_ids();
					}
					System.err.println(menu_ids);
					List<Menu> menus = menuService.getMenuByMenuIds(menu_ids);
					List<Menu> parent_menus = new ArrayList<Menu>();
					List<Menu> child_menus = new ArrayList<Menu>();
					for(Menu m : menus){
						if("1".equals(m.getMenu_level())){
							parent_menus.add(m);
						}
						if("2".equals(m.getMenu_level())){
							child_menus.add(m);
						}
					}
					session.removeAttribute("parentMenus");
					session.removeAttribute("childMenus");
					session.setAttribute("parentMenus", parent_menus);
					session.setAttribute("childMenus", child_menus);
					mav.addObject("menus", menus);
					mav.addObject("success",true);
					mav.setViewName("redirect:/jsp/index/index.jsp");
				}
			}else{
				mav.addObject("success", false);
				mav.addObject("msg", "role_ids为空");
			}
			
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
	//管理员增加用户
	@RequestMapping(value="/saveuser",method=RequestMethod.POST)
	public ModelAndView regin(User user, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			user.setCreate_by(""+session.getAttribute("user_name"));
			String create_time = DateUtil.format2(new Date());
			user.setCreate_time(create_time);
			userService.saveUser(user);
			mav.addObject("success",true);
		}catch(Exception e){
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
	//个人注册
	@RequestMapping(value="/saveuser2",method=RequestMethod.POST)
	public ModelAndView regin2(User user, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			user.setCreate_by(user.getUser_name());
			String create_time = DateUtil.format2(new Date());
			user.setCreate_time(create_time);
			userService.saveUser(user);
			mav.addObject("success",true);
		}catch(Exception e){
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
	@RequestMapping(value="/listusers",method = RequestMethod.POST)
	public ModelAndView listUsers(DataGridModel dmg){
		int page = dmg.getPage();
		int rows = dmg.getRows();
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			Page pageData = userService.getSysParams(page, rows);
			mav.addObject("total", pageData.getTotalCount());
			mav.addObject("rows", pageData.getData());
			mav.addObject("success",true);
		}catch(Exception e){
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
	@RequestMapping(value="/listusers2")
	public ModelAndView listUsers2(int offset,int limit,String order,SearchUser searchUser){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			Page pageData = userService.getPagedUsers(offset, limit,searchUser);
			mav.addObject("total", pageData.getTotalCount());
			mav.addObject("rows", pageData.getData());
			mav.addObject("success",true);
		}catch(Exception e){
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
	//根据session查找账号
	@RequestMapping(value="/finduserbysession",method = RequestMethod.POST)
	public ModelAndView findUserBySession(HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			if(session.getAttribute("user_no") != null){
				SearchUser searchUser = new SearchUser();
				searchUser.setS_user_no(session.getAttribute("user_no").toString());
				List<User> users = userService.findUsers(searchUser);
				if(users.size()>0){
					mav.addObject("user",users.get(0));
				}else{
					mav.addObject("user",null);
				}
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
	
	@RequestMapping(value="/deleteusers", method=RequestMethod.DELETE)
	public ModelAndView deleteUsers(String[] ids){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			List<User> users = new ArrayList<User>();
			for(String id : ids){
				if(id!=""&&!id.equals("")){
					User user = new User();
					user.setUser_id(Integer.parseInt(id));
					users.add(user);
				}
			}
			userService.delteUsers(users);
			mav.addObject("success",true);
		}catch(Exception e){
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
	@RequestMapping(value="/updateuser",method = RequestMethod.POST)
	public ModelAndView updateUser(User user, HttpSession session){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
			user.setUpdate_by(""+session.getAttribute("user_name"));
			String update_time = DateUtil.format2(new Date());
			user.setUpdate_time(update_time);
			userService.updateUser(user);
			mav.addObject("success",true);
		}catch(Exception e){
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(User user, HttpSession session,
			HttpServletRequest request) {
		System.out.println("用户登出");
		ModelAndView mav = new ModelAndView();
		if (session != null) { // 如果存在session 则清空session对象 来实现用户登出
			session.invalidate();
		}
//		mav.addObject("success", true);
//		mav.addObject("msg", "logout success");
		mav.setViewName("redirect:/bjsp/index/groupindex.jsp");
		return mav;
	}
	
	/**
	 * 修改人：梁轰
	 * 修改2015年11月1日01:16:41
	 * 修改内容：增加判断原密码是否正确的方法
	 * @param user_id
	 * @param old_password
	 * @return
	 */
	@RequestMapping(value="/rightoldpassword", method=RequestMethod.POST)
	@ResponseBody  //该注解表示方法返回值直接送到客户端
	public String rightOldPassword(int user_id,String old_password) {
		try {
			if(userService.rightPassword(user_id, old_password)){
				System.err.println("true");
				return "true";
			}else{
				System.err.println("false");
				return "false";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return "false";
		}
	}
	
	/**
	 * 修改人：梁轰
	 * 修改2015年11月1日01:16:45
	 * 修改内容：增加判断原密码是否正确的方法
	 * @param user_id
	 * @return
	 */
	@RequestMapping(value="/existloginname", method=RequestMethod.POST)
	@ResponseBody  //该注解表示方法返回值直接送到客户端
	public String existLoginName(int user_id, String login_name) {
		try {
			if(userService.existLoginName(user_id, login_name)){
				System.err.println("true");
				return "false";
			}else{
				System.err.println("false");
				return "true";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return "false";
		}
	}
	
	@RequestMapping(value="/updatepassword", method=RequestMethod.POST)
//	@ResponseBody  //该注解表示方法返回值直接送到客户端
	public ModelAndView updateUserPassword(User user,String new_pswd){
		ModelAndView mav = new ModelAndView("jsonView");
		try {
			user.setUser_password(new_pswd);
			userService.updateUser(user);
			System.out.println("------------------------\n"+user.getUser_id()+"\t"+user.getUser_password());
			mav.addObject("success",true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mav.addObject("msg",e.getMessage());
			mav.addObject("success",false);
		}
		return mav;
	}
	
}

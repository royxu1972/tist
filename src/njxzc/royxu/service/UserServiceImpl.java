package njxzc.royxu.service;

import java.util.List;

import njxzc.royxu.dao.UserDao;
import njxzc.royxu.domain.User;
import njxzc.royxu.searchmodel.SearchUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.core.Page;
import com.util.StringUtil;

@Service
@Transactional
public class UserServiceImpl {
	@Autowired
	private UserDao userDao;
	
	public void saveUser(User user){
		userDao.save(user);
	}
	
	public List<User> loadAllUsers(){
		return userDao.loadAll();
	}
	
	public Page getSysParams(int pageNo, int pageSize, Object... conditions) {
		Page page = userDao.pagedQuery("from User u where u.del_flag=0", pageNo,pageSize, conditions);
		return page;
	}
	
	public Page getPagedUsers(int offset, int pageSize,SearchUser searchUser, Object... conditions) {
		String hql = "from User where 1=1 ";
		if(!StringUtil.isEmpty(searchUser.getS_user_id())){
			hql += " and user_id = '"+searchUser.getS_user_id()+"' ";
		}
		if(!StringUtil.isEmpty(searchUser.getS_user_name())){
			hql += " and user_name = '"+searchUser.getS_user_name()+"' ";
		}
		if(!StringUtil.isEmpty(searchUser.getS_sex())){
			hql += " and sex = '"+searchUser.getS_sex()+"' ";
		}
		if(!StringUtil.isEmpty(searchUser.getS_user_no())){
			hql += " and user_no = '"+searchUser.getS_user_no()+"' ";
		}
		if(!StringUtil.isEmpty(searchUser.getS_user_password())){
			hql += " and user_password = '"+searchUser.getS_user_password()+"' ";
		}
		if(!StringUtil.isEmpty(searchUser.getS_login_name())){
			hql += " and login_name = '"+searchUser.getS_login_name()+"' ";
		}
		if(!StringUtil.isEmpty(searchUser.getS_department_id())){
			hql += " and department_id = '"+searchUser.getS_department_id()+"' ";
		}
		if(!StringUtil.isEmpty(searchUser.getS_email())){
			hql += " and email = '"+searchUser.getS_email()+"' ";
		}
		if(!StringUtil.isEmpty(searchUser.getS_mobilephone())){
			hql += " and mobilephone = '"+searchUser.getS_mobilephone()+"' ";
		}
		if(!StringUtil.isEmpty(searchUser.getS_phone())){
			hql += " and phone = '"+searchUser.getS_phone()+"' ";
		}
		if(!StringUtil.isEmpty(searchUser.getS_bank_card())){
			hql += " and bank_card = '"+searchUser.getS_bank_card()+"' ";
		}
		if(!StringUtil.isEmpty(searchUser.getS_login_ip())){
			hql += " and login_ip = '"+searchUser.getS_login_ip()+"' ";
		}
		if(!StringUtil.isEmpty(searchUser.getS_login_time())){
			hql += " and login_time = '"+searchUser.getS_login_time()+"' ";
		}
		if(!StringUtil.isEmpty(searchUser.getS_create_by())){
			hql += " and create_by = '"+searchUser.getS_create_by()+"' ";
		}
		if(!StringUtil.isEmpty(searchUser.getS_create_time())){
			hql += " and create_time = '"+searchUser.getS_create_time()+"' ";
		}
		if(!StringUtil.isEmpty(searchUser.getS_update_by())){
			hql += " and update_by = '"+searchUser.getS_update_by()+"' ";
		}
		if(!StringUtil.isEmpty(searchUser.getS_update_time())){
			hql += " and update_time = '"+searchUser.getS_update_time()+"' ";
		}
		if(!StringUtil.isEmpty(searchUser.getS_enter_time())){
			hql += " and enter_time = '"+searchUser.getS_enter_time()+"' ";
		}
		if(!StringUtil.isEmpty(searchUser.getS_leave_time())){
			hql += " and leave_time = '"+searchUser.getS_leave_time()+"' ";
		}
		if(!StringUtil.isEmpty(searchUser.getS_note())){
			hql += " and note = '"+searchUser.getS_note()+"' ";
		}
		if(!StringUtil.isEmpty(searchUser.getS_del_flag())){
			hql += " and del_flag = '"+searchUser.getS_del_flag()+"' ";
		}
		
		Page page = userDao.pagedQuery(hql, offset,pageSize, conditions);
		return page;
	}
	
	public void delteUsers(List<User> users){
		userDao.deleteAll(users);
	}
	
	public void updateUser(User user){
		userDao.update(user);
	}
	
	public User login(User user) {
		user = userDao.login(user);
		if (user != null) {
			user.setUser_password("******"); // 设置返回的用户密码为*******(防止用户密码暴露到前台)
		}
		return user;
	}
	
	public List<User> findUsers(SearchUser searchUser){
		return userDao.findUsers(searchUser);
	}
	
	//验证密码
	public boolean rightPassword(int user_id,String password){
		return userDao.rightPassword(user_id, password);
	}
	
	//登录名是否重复
	public boolean existLoginName(int user_id, String login_name){
		return userDao.existLoginName(user_id, login_name);
	}
}

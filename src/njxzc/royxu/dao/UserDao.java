package njxzc.royxu.dao;

import java.util.List;

import javax.annotation.Resource;

import njxzc.royxu.domain.User;
import njxzc.royxu.searchmodel.SearchUser;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.core.BaseDao;
import com.util.StringUtil;

@Repository
public class UserDao extends BaseDao<User>{
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	//登陆，登录名/编号/自增主键 and 密码
	public User login(User u) {
		List<?> list = hibernateTemplate.find(
				"from User u "
				+ "where (u.login_name=? or u.user_no='"+u.getLogin_name()+"' or u.user_id='"+u.getLogin_name()+"') "
						+ "and u.user_password=?", 
				u.getLogin_name(),u.getUser_password());
//				u.getUpassword());
		if (list.size() > 0) {
			return (User)list.get(0);
		}
		return null;
	}
	
	//根据条件查询
	@SuppressWarnings("unchecked")
	public List<User> findUsers(SearchUser searchUser){
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
		
		List<User> users = (List<User>) find(hql);
		return users;
	}
	
	//验证密码
	public boolean rightPassword(int user_id,String password){
		try {
			List<?> list = hibernateTemplate.find("from User u where u.user_id=? and u.user_password=?",user_id,password);
			int total = list.size();
			if(total == 1){
				return true;
			}else{
				return false;
			}
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	//登录名是否重复
	public boolean existLoginName(int user_id, String login_name){
		try {
			List<?> list = hibernateTemplate.find("from User u where u.login_name=? and u.user_id <> ?",login_name,user_id);
			int total = list.size();
			if(total > 0){
				return true;
			}else{
				return false;
			}
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}

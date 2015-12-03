package njxzc.royxu.service;

import java.util.List;

import njxzc.royxu.dao.UserRoleDao;
import njxzc.royxu.domain.UserRole;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.core.Page;

@Service
@Transactional
public class UserRoleServiceImpl {
	@Autowired
	private UserRoleDao userRoleDao;
	
	public void saveUserRole(UserRole userRole){
		userRoleDao.save(userRole);
	}
	
	public List<UserRole> loadAllUserRoles(){
		return userRoleDao.loadAll();
	}
	
	public Page getSysParams(int pageNo, int pageSize, Object... conditions) {
		Page page = userRoleDao.pagedQuery("from UserRole u", pageNo,pageSize, conditions);
		return page;
	}
	
	public void delteUserRoles(List<UserRole> userRoles){
		userRoleDao.deleteAll(userRoles);
	}
	
	public void deleteUserRole(UserRole userRole){
		userRoleDao.delete(userRole);
	}
	
	public void updateUserRole(UserRole userRole){
		userRoleDao.update(userRole);
	}
	
	public UserRole findUserRoleByUserId(int user_id){
		return userRoleDao.findUserRoleByUserId(user_id);
	}
}

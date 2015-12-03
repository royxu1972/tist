package njxzc.royxu.service;

import java.util.List;

import njxzc.royxu.dao.RoleDao;
import njxzc.royxu.domain.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.core.Page;

@Service
@Transactional
public class RoleServiceImpl {
	@Autowired
	private RoleDao roleDao;
	
	public void saveRole(Role role){
		System.err.println(role.toString());
		roleDao.save(role);
	}
	
	public Role saveRoleReturnId(Role role){
		role = roleDao.saveRoleReturnId(role);
		return role;
	}
	
	public List<Role> loadAllRoles(){
		return roleDao.loadAll();
	}
	
	public Page getSysParams(int pageNo, int pageSize, Object... conditions) {
		Page page = roleDao.pagedQuery("from Role r", pageNo,pageSize, conditions);
		return page;
	}
	
	public void delteRoles(List<Role> roles){
		roleDao.deleteAll(roles);
	}
	
	public void deleteRole(Role role){
		roleDao.delete(role);
	}
	
	public void updateRole(Role role){
		roleDao.update(role);
	}
	
	public List<Role> findRoleByRoleIds(String role_ids){
		return roleDao.findRoleByRoleIds(role_ids);
	}
}

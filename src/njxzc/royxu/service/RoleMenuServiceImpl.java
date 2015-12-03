package njxzc.royxu.service;

import java.sql.SQLException;
import java.util.List;

import njxzc.royxu.dao.RoleMenuDao;
import njxzc.royxu.domain.RoleMenu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.core.Page;

/**
 * 角色菜单管理Service
 * @author Author
 * @version 2015-07-24
 */
@Service
@Transactional
public class RoleMenuServiceImpl {

	@Autowired
	private RoleMenuDao roleMenuDao;
	
	public void saveRoleMenu(RoleMenu roleMenu){
		roleMenuDao.save(roleMenu);
	}
	
	public List<RoleMenu> loadAllRoleMenus(){
		return roleMenuDao.loadAll();
	}
	
	public void saveAllRoleMenus(List<RoleMenu> roleMenus){
		roleMenuDao.saveAll(roleMenus);
	}
	
	public Page getSysParams(int pageNo, int pageSize, Object... conditions) {
		Page page = roleMenuDao.pagedQuery("from RoleMenu", pageNo,pageSize, conditions);
		return page;
	}
	
	public void deleteRoleMenus(List<RoleMenu> roleMenus){
		roleMenuDao.deleteAll(roleMenus);
	}
	
	public void updateRoleMenu(RoleMenu roleMenu){
		roleMenuDao.update(roleMenu);
	}
	
	public void deleteRoleMenu(RoleMenu roleMenu){
		roleMenuDao.delete(roleMenu);
	}
	
//	根据del_flag批量修改（等于删除）
	public void deleteRoleMenusBySqls(String[] ids) throws SQLException{
		roleMenuDao.deleteRoleMenusBySqls(ids);
	}
	
	public void deleteRoleMenuByRoleId(int role_id) throws SQLException{
		roleMenuDao.deleteRoleMenuByRoleId(role_id);
	}
	
}

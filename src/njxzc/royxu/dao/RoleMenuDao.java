package njxzc.royxu.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import njxzc.royxu.domain.RoleMenu;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.core.BaseDao;

/**
 * 角色菜单管理DAO接口
 * @author Author
 * @version 2015-07-24
 */
@Repository
public class RoleMenuDao extends BaseDao<RoleMenu> {
	@Resource
	private HibernateTemplate hibernateTemplate;
	
//	根据del_flag批量修改（等于删除）
	public void deleteRoleMenusBySqls(String[] ids) throws SQLException{
		List<String> sqls = new ArrayList<String>();
		for(String id : ids){
			String sql = "update RoleMenu set del_flag = '1'  where ? = "+id;
			sqls.add(sql);
		}
		updateSqls(sqls);
	}
	
//	根据role_id删除角色菜单
	public void deleteRoleMenuByRoleId(int role_id) throws SQLException{
		String sql = "delete from RoleMenu rm where rm.role_id="+role_id;
		updateSql(sql);
	}
	
}

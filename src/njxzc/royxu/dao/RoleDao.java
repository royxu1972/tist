package njxzc.royxu.dao;

import java.util.List;

import javax.annotation.Resource;

import njxzc.royxu.domain.Role;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.core.BaseDao;

@Repository
public class RoleDao extends BaseDao<Role>{
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	@SuppressWarnings("unchecked")
	public List<Role> findRoleByRoleIds(String role_ids){
		List<Role> roles = (List<Role>) find("from Role r where r.role_id in ("+role_ids+")");
		return roles;
	}
	
	public Role saveRoleReturnId(Role role){
		hibernateTemplate.save(role);
		return role;
	}
	
}

package njxzc.royxu.dao;

import java.util.List;

import javax.annotation.Resource;

import njxzc.royxu.domain.UserRole;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.core.BaseDao;

@Repository
public class UserRoleDao extends BaseDao<UserRole>{
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	@SuppressWarnings("unchecked")
	public UserRole findUserRoleByUserId(int user_id){
		List<UserRole> list = (List<UserRole>) find("from UserRole ur where ur.user_id=?",user_id);
		if(list!=null && list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}
	
}

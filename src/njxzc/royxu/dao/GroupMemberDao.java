package njxzc.royxu.dao;

import javax.annotation.Resource;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.core.BaseDao;

import njxzc.royxu.domain.GroupMember;

/**
 * 项目组成员DAO接口
 * @author LiangHong
 * @version 2015-10-24
 */
@Repository
public class GroupMemberDao extends BaseDao<GroupMember> {
	@Resource
	private HibernateTemplate hibernateTemplate;
	
//	根据del_flag批量修改（等于删除）
	public void deleteGroupMembersBySqls(String[] ids) throws SQLException{
		List<String> sqls = new ArrayList<String>();
		for(String id : ids){
			String sql = "update GroupMember set ? where = ?";
			sqls.add(sql);
		}
		updateSqls(sqls);
	}
	
	@SuppressWarnings("unchecked")
	public List<GroupMember> findGroupMembers(){
		String hql = "from GroupMember ";
		hql += " order by field(member_type,'老师','学生'),member_sort ";
		List<GroupMember> groupMembers = (List<GroupMember>) find(hql);
		return groupMembers;
		
	}
	
}

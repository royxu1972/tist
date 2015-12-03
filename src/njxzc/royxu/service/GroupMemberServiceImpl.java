package njxzc.royxu.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.core.Page;
import njxzc.royxu.domain.GroupMember;
import njxzc.royxu.dao.GroupMemberDao;

/**
 * 项目组成员Service
 * @author LiangHong
 * @version 2015-10-24
 */
@Service
@Transactional
public class GroupMemberServiceImpl {

	@Autowired
	private GroupMemberDao groupMemberDao;
	
	public void saveGroupMember(GroupMember groupMember){
		groupMemberDao.save(groupMember);
	}
	
	public List<GroupMember> loadAllGroupMembers(){
		return groupMemberDao.loadAll();
	}
	
	public Page getSysParams(int pageNo, int pageSize, Object... conditions) {
		Page page = groupMemberDao.pagedQuery("from GroupMember", pageNo,pageSize, conditions);
		return page;
	}
	
	public Page getPagedGroupMembers(int offset, int pageSize, Object... conditions) {
		Page page = groupMemberDao.pagedQuery2("from GroupMember order by member_sort,increment_id", offset,pageSize, conditions);
		return page;
	}
	
	public void deleteGroupMembers(List<GroupMember> groupMembers){
		groupMemberDao.deleteAll(groupMembers);
	}
	
	public void updateGroupMember(GroupMember groupMember){
		groupMemberDao.update(groupMember);
	}
	
	public void deleteGroupMember(GroupMember groupMember){
		groupMemberDao.delete(groupMember);
	}
	
//	根据del_flag批量修改（等于删除）
	public void deleteGroupMembersBySqls(String[] ids) throws SQLException{
		groupMemberDao.deleteGroupMembersBySqls(ids);
	}
	
	public List<GroupMember> findGroupMembers(){
		return groupMemberDao.findGroupMembers();
	}
	
}

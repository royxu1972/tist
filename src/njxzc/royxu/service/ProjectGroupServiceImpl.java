package njxzc.royxu.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.core.Page;
import njxzc.royxu.domain.ProjectGroup;
import njxzc.royxu.dao.ProjectGroupDao;

/**
 * 项目组Service
 * @author LiangHong
 * @version 2015-10-24
 */
@Service
@Transactional
public class ProjectGroupServiceImpl {

	@Autowired
	private ProjectGroupDao projectGroupDao;
	
	public void saveProjectGroup(ProjectGroup projectGroup){
		projectGroupDao.save(projectGroup);
	}
	
	public List<ProjectGroup> loadAllProjectGroups(){
		return projectGroupDao.loadAll();
	}
	
	public Page getSysParams(int pageNo, int pageSize, Object... conditions) {
		Page page = projectGroupDao.pagedQuery("from ProjectGroup", pageNo,pageSize, conditions);
		return page;
	}
	
	public Page getPagedProjectGroups(int offset, int pageSize, Object... conditions) {
		Page page = projectGroupDao.pagedQuery2("from ProjectGroup", offset,pageSize, conditions);
		return page;
	}
	
	public void deleteProjectGroups(List<ProjectGroup> projectGroups){
		projectGroupDao.deleteAll(projectGroups);
	}
	
	public void updateProjectGroup(ProjectGroup projectGroup){
		projectGroupDao.update(projectGroup);
	}
	
	public void deleteProjectGroup(ProjectGroup projectGroup){
		projectGroupDao.delete(projectGroup);
	}
	
//	根据del_flag批量修改（等于删除）
	public void deleteProjectGroupsBySqls(String[] ids) throws SQLException{
		projectGroupDao.deleteProjectGroupsBySqls(ids);
	}
	
}

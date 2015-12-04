package njxzc.royxu.service;

import java.sql.SQLException;
import java.util.List;

import njxzc.royxu.dao.ScienceProjectDao;
import njxzc.royxu.domain.ScienceProject;
import njxzc.royxu.searchmodel.SearchScienceProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.core.Page;
import com.util.StringUtil;

/**
 * 科研项目Service
 * @author LiangHong
 * @version 2015-10-03
 */
@Service
@Transactional
public class ScienceProjectServiceImpl {

	@Autowired
	private ScienceProjectDao scienceProjectDao;
	
	public void saveScienceProject(ScienceProject scienceProject){
		scienceProjectDao.save(scienceProject);
	}
	
	public List<ScienceProject> loadAllScienceProjects(){
		return scienceProjectDao.loadAll();
	}
	
	public Page getSysParams(int pageNo, int pageSize,SearchScienceProject searchScienceProject, Object... conditions) {
		String hql = "from ScienceProject where 1=1 ";
		if(!StringUtil.isEmpty(searchScienceProject.getS_proj_id())){
			hql += " and proj_id = '"+searchScienceProject.getS_proj_id()+"' ";
		}
		if(!StringUtil.isEmpty(searchScienceProject.getS_proj_name())){
			hql += " and proj_name = '"+searchScienceProject.getS_proj_name()+"' ";
		}
		if(!StringUtil.isEmpty(searchScienceProject.getS_proj_origin())){
			hql += " and proj_origin = '"+searchScienceProject.getS_proj_origin()+"' ";
		}
		if(!StringUtil.isEmpty(searchScienceProject.getS_start_date())){
			hql += " and start_date = '"+searchScienceProject.getS_start_date()+"' ";
		}
		if(!StringUtil.isEmpty(searchScienceProject.getS_end_date())){
			hql += " and end_date = '"+searchScienceProject.getS_end_date()+"' ";
		}
		if(!StringUtil.isEmpty(searchScienceProject.getS_proj_fund())){
			hql += " and proj_fund = '"+searchScienceProject.getS_proj_fund()+"' ";
		}
		if(!StringUtil.isEmpty(searchScienceProject.getS_my_work())){
			hql += " and my_work = '"+searchScienceProject.getS_my_work()+"' ";
		}
		if(!StringUtil.isEmpty(searchScienceProject.getS_proj_info())){
			hql += " and proj_info = '"+searchScienceProject.getS_proj_info()+"' ";
		}
		if(!StringUtil.isEmpty(searchScienceProject.getS_user_no())){
			hql += " and user_no = '"+searchScienceProject.getS_user_no()+"' ";
		}
		//根据开始日期倒序
		hql += " order by start_date desc,proj_status_sort asc ";
		
		Page page = scienceProjectDao.pagedQuery(hql, pageNo,pageSize, conditions);
		return page;
	}
	
	public Page getPagedScienceProjects(int offset, int pageSize,SearchScienceProject searchScienceProject, Object... conditions) {
		String hql = "from ScienceProject where 1=1 ";
		if(!StringUtil.isEmpty(searchScienceProject.getS_proj_id())){
			hql += " and proj_id = '"+searchScienceProject.getS_proj_id()+"' ";
		}
		if(!StringUtil.isEmpty(searchScienceProject.getS_proj_name())){
			hql += " and proj_name = '"+searchScienceProject.getS_proj_name()+"' ";
		}
		if(!StringUtil.isEmpty(searchScienceProject.getS_proj_origin())){
			hql += " and proj_origin = '"+searchScienceProject.getS_proj_origin()+"' ";
		}
		if(!StringUtil.isEmpty(searchScienceProject.getS_start_date())){
			hql += " and start_date = '"+searchScienceProject.getS_start_date()+"' ";
		}
		if(!StringUtil.isEmpty(searchScienceProject.getS_end_date())){
			hql += " and end_date = '"+searchScienceProject.getS_end_date()+"' ";
		}
		if(!StringUtil.isEmpty(searchScienceProject.getS_proj_fund())){
			hql += " and proj_fund = '"+searchScienceProject.getS_proj_fund()+"' ";
		}
		if(!StringUtil.isEmpty(searchScienceProject.getS_my_work())){
			hql += " and my_work = '"+searchScienceProject.getS_my_work()+"' ";
		}
		if(!StringUtil.isEmpty(searchScienceProject.getS_proj_info())){
			hql += " and proj_info = '"+searchScienceProject.getS_proj_info()+"' ";
		}
		if(!StringUtil.isEmpty(searchScienceProject.getS_user_no())){
			hql += " and user_no = '"+searchScienceProject.getS_user_no()+"' ";
		}
		
		Page page = scienceProjectDao.pagedQuery2(hql, offset,pageSize, conditions);
		return page;
	}
	
	public void deleteScienceProjects(List<ScienceProject> scienceProjects){
		scienceProjectDao.deleteAll(scienceProjects);
	}
	
	public void updateScienceProject(ScienceProject scienceProject){
		scienceProjectDao.update(scienceProject);
	}
	
	public void deleteScienceProject(ScienceProject scienceProject){
		scienceProjectDao.delete(scienceProject);
	}
	
//	根据del_flag批量修改（等于删除）
	public void deleteScienceProjectsBySqls(String[] ids) throws SQLException{
		scienceProjectDao.deleteScienceProjectsBySqls(ids);
	}
	
	public List<ScienceProject> searchScienceProject(SearchScienceProject searchScienceProject){
		return scienceProjectDao.searchScienceProject(searchScienceProject);
	}
	
//	按条件查询
	public List<ScienceProject> findScienceProjects(SearchScienceProject searchScienceProject){
		return scienceProjectDao.findScienceProjects(searchScienceProject);
	}
}

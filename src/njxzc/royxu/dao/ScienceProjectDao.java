package njxzc.royxu.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import njxzc.royxu.domain.ScienceProject;
import njxzc.royxu.searchmodel.SearchScienceProject;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.core.BaseDao;
import com.util.StringUtil;

/**
 * 科研项目DAO接口
 * @author LiangHong
 * @version 2015-10-03
 */
@Repository
public class ScienceProjectDao extends BaseDao<ScienceProject> {
	@Resource
	private HibernateTemplate hibernateTemplate;
	
//	根据del_flag批量修改（等于删除）
	public void deleteScienceProjectsBySqls(String[] ids) throws SQLException{
		List<String> sqls = new ArrayList<String>();
		for(String id : ids){
			String sql = "update ScienceProject set ? where = ?";
			sqls.add(sql);
		}
		updateSqls(sqls);
	}
	
	@SuppressWarnings("unchecked")
	public List<ScienceProject> searchScienceProject(SearchScienceProject searchScienceProject){
		String hql = "from ScienceProject h where 1=1 ";
//		if(!StringUtil.isEmpty(searchScienceProject.getProj_id())){
//			hql += " and h.proj_id='" + searchScienceProject.getProj_id() + "' ";
//		}
		List<ScienceProject> scienceProjects = (List<ScienceProject>) find(hql);
		return scienceProjects;
	}
	
	//根据条件查询
	@SuppressWarnings("unchecked")
	public List<ScienceProject> findScienceProjects(SearchScienceProject searchScienceProject){
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
		
		List<ScienceProject> scienceprojects = (List<ScienceProject>) find(hql);
		return scienceprojects;
	}
	
}

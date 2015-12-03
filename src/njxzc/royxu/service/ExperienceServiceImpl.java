package njxzc.royxu.service;

import java.sql.SQLException;
import java.util.List;

import njxzc.royxu.dao.ExperienceDao;
import njxzc.royxu.domain.Experience;
import njxzc.royxu.searchmodel.SearchExperience;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.core.Page;
import com.util.StringUtil;

/**
 * 个人经历Service
 * @author LiangHong
 * @version 2015-10-03
 */
@Service
@Transactional
public class ExperienceServiceImpl {

	@Autowired
	private ExperienceDao experienceDao;
	
	public void saveExperience(Experience experience){
		experienceDao.save(experience);
	}
	
	public List<Experience> loadAllExperiences(){
		return experienceDao.loadAll();
	}
	
	public Page getSysParams(int pageNo, int pageSize,SearchExperience searchExperience, Object... conditions) {
		String hql = "from Experience where 1=1 ";
		if(!StringUtil.isEmpty(searchExperience.getS_experience_id())){
			hql += " and experience_id = '"+searchExperience.getS_experience_id()+"' ";
		}
		if(!StringUtil.isEmpty(searchExperience.getS_time_period_start())){
			hql += " and time_period_start = '"+searchExperience.getS_time_period_start()+"' ";
		}
		if(!StringUtil.isEmpty(searchExperience.getS_time_period_end())){
			hql += " and time_period_end = '"+searchExperience.getS_time_period_end()+"' ";
		}
		if(!StringUtil.isEmpty(searchExperience.getS_experience_info())){
			hql += " and experience_info = '"+searchExperience.getS_experience_info()+"' ";
		}
		if(!StringUtil.isEmpty(searchExperience.getS_experience_role())){
			hql += " and experience_role = '"+searchExperience.getS_experience_role()+"' ";
		}
		if(!StringUtil.isEmpty(searchExperience.getS_user_no())){
			hql += " and user_no = '"+searchExperience.getS_user_no()+"' ";
		}
		
		Page page = experienceDao.pagedQuery(hql, pageNo,pageSize, conditions);
		return page;
	}
	
	public Page getPagedExperiences(int offset, int pageSize,SearchExperience searchExperience, Object... conditions) {
		String hql = "from Experience where 1=1 ";
		if(!StringUtil.isEmpty(searchExperience.getS_experience_id())){
			hql += " and experience_id = '"+searchExperience.getS_experience_id()+"' ";
		}
		if(!StringUtil.isEmpty(searchExperience.getS_time_period_start())){
			hql += " and time_period_start = '"+searchExperience.getS_time_period_start()+"' ";
		}
		if(!StringUtil.isEmpty(searchExperience.getS_time_period_end())){
			hql += " and time_period_end = '"+searchExperience.getS_time_period_end()+"' ";
		}
		if(!StringUtil.isEmpty(searchExperience.getS_experience_info())){
			hql += " and experience_info = '"+searchExperience.getS_experience_info()+"' ";
		}
		if(!StringUtil.isEmpty(searchExperience.getS_experience_role())){
			hql += " and experience_role = '"+searchExperience.getS_experience_role()+"' ";
		}
		if(!StringUtil.isEmpty(searchExperience.getS_user_no())){
			hql += " and user_no = '"+searchExperience.getS_user_no()+"' ";
		}
		
		Page page = experienceDao.pagedQuery2(hql, offset,pageSize, conditions);
		return page;
	}
	
	public void deleteExperiences(List<Experience> experiences){
		experienceDao.deleteAll(experiences);
	}
	
	public void updateExperience(Experience experience){
		experienceDao.update(experience);
	}
	
	public void deleteExperience(Experience experience){
		experienceDao.delete(experience);
	}
	
//	根据del_flag批量修改（等于删除）
	public void deleteExperiencesBySqls(String[] ids) throws SQLException{
		experienceDao.deleteExperiencesBySqls(ids);
	}
	
//	按条件查询
	public List<Experience> findExperiences(SearchExperience searchExperience){
		return experienceDao.findExperiences(searchExperience);
	}
}

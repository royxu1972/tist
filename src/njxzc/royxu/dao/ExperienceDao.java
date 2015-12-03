package njxzc.royxu.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import njxzc.royxu.domain.Experience;
import njxzc.royxu.searchmodel.SearchExperience;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.core.BaseDao;
import com.util.StringUtil;

/**
 * 个人经历DAO接口
 * @author LiangHong
 * @version 2015-10-03
 */
@Repository
public class ExperienceDao extends BaseDao<Experience> {
	@Resource
	private HibernateTemplate hibernateTemplate;
	
//	根据del_flag批量修改（等于删除）
	public void deleteExperiencesBySqls(String[] ids) throws SQLException{
		List<String> sqls = new ArrayList<String>();
		for(String id : ids){
			String sql = "update Experience set ? where = ?";
			sqls.add(sql);
		}
		updateSqls(sqls);
	}
	
	
	//根据条件查询
	@SuppressWarnings("unchecked")
	public List<Experience> findExperiences(SearchExperience searchExperience){
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
		hql += " order by time_period_start desc ";
		List<Experience> experiences = (List<Experience>) find(hql);
		return experiences;
	}
}

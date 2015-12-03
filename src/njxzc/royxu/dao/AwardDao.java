package njxzc.royxu.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import njxzc.royxu.domain.Award;
import njxzc.royxu.searchmodel.SearchAward;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.core.BaseDao;
import com.util.StringUtil;

/**
 * 个人荣誉DAO接口
 * @author LiangHong
 * @version 2015-10-03
 */
@Repository
public class AwardDao extends BaseDao<Award> {
	@Resource
	private HibernateTemplate hibernateTemplate;
	
//	根据del_flag批量修改（等于删除）
	public void deleteAwardsBySqls(String[] ids) throws SQLException{
		List<String> sqls = new ArrayList<String>();
		for(String id : ids){
			String sql = "update Award set ? where = ?";
			sqls.add(sql);
		}
		updateSqls(sqls);
	}
	
	//根据条件查询
	@SuppressWarnings("unchecked")
	public List<Award> findAwards(SearchAward searchAward){
		String hql = "from Award where 1=1 ";
		if(!StringUtil.isEmpty(searchAward.getS_award_id())){
			hql += " and award_id = '"+searchAward.getS_award_id()+"' ";
		}
		if(!StringUtil.isEmpty(searchAward.getS_award_name())){
			hql += " and award_name = '"+searchAward.getS_award_name()+"' ";
		}
		if(!StringUtil.isEmpty(searchAward.getS_award_unit())){
			hql += " and award_unit = '"+searchAward.getS_award_unit()+"' ";
		}
		if(!StringUtil.isEmpty(searchAward.getS_award_date())){
			hql += " and award_date = '"+searchAward.getS_award_date()+"' ";
		}
		if(!StringUtil.isEmpty(searchAward.getS_award_rank())){
			hql += " and award_rank = '"+searchAward.getS_award_rank()+"' ";
		}
		if(!StringUtil.isEmpty(searchAward.getS_user_no())){
			hql += " and user_no = '"+searchAward.getS_user_no()+"' ";
		}
		
		List<Award> awards = (List<Award>) find(hql);
		return awards;
	}
	
}

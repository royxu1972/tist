package njxzc.royxu.service;

import java.sql.SQLException;
import java.util.List;

import njxzc.royxu.dao.AwardDao;
import njxzc.royxu.domain.Award;
import njxzc.royxu.searchmodel.SearchAward;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.core.Page;
import com.util.StringUtil;

/**
 * 个人荣誉Service
 * @author LiangHong
 * @version 2015-10-03
 */
@Service
@Transactional
public class AwardServiceImpl {

	@Autowired
	private AwardDao awardDao;
	
	public void saveAward(Award award){
		awardDao.save(award);
	}
	
	public List<Award> loadAllAwards(){
		return awardDao.loadAll();
	}
	
	public Page getSysParams(int pageNo, int pageSize,SearchAward searchAward, Object... conditions) {
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
		
		Page page = awardDao.pagedQuery(hql, pageNo,pageSize, conditions);
		return page;
	}
	
	public Page getPagedAwards(int offset, int pageSize,SearchAward searchAward, Object... conditions) {
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
		
		Page page = awardDao.pagedQuery2(hql, offset,pageSize, conditions);
		return page;
	}
	
	public void deleteAwards(List<Award> awards){
		awardDao.deleteAll(awards);
	}
	
	public void updateAward(Award award){
		awardDao.update(award);
	}
	
	public void deleteAward(Award award){
		awardDao.delete(award);
	}
	
//	根据del_flag批量修改（等于删除）
	public void deleteAwardsBySqls(String[] ids) throws SQLException{
		awardDao.deleteAwardsBySqls(ids);
	}
	
//	按条件查询
	public List<Award> findAwards(SearchAward searchAward){
		return awardDao.findAwards(searchAward);
	}
	
}

package njxzc.royxu.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import njxzc.royxu.domain.Paper;
import njxzc.royxu.searchmodel.SearchPaper;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.core.BaseDao;
import com.util.StringUtil;

/**
 * 文献DAO接口
 * @author LiangHong
 * @version 2015-10-03
 */
@Repository
public class PaperDao extends BaseDao<Paper> {
	@Resource
	private HibernateTemplate hibernateTemplate;
	
//	根据del_flag批量修改（等于删除）
	public void deletePapersBySqls(String[] ids) throws SQLException{
		List<String> sqls = new ArrayList<String>();
		for(String id : ids){
			String sql = "update Paper set ? where = ?";
			sqls.add(sql);
		}
		updateSqls(sqls);
	}
	
	@SuppressWarnings("unchecked")
	public List<Paper> loadAllPaper(){
		List<Paper> papers = hibernateTemplate.find("from Paper order by publish_time desc");
		return papers;
	}
	
	//根据条件查询
	@SuppressWarnings("unchecked")
	public List<Paper> findPapers(SearchPaper searchPaper){
		String hql = "from Paper where 1=1 ";
		if(!StringUtil.isEmpty(searchPaper.getS_paper_id())){
			hql += " and paper_id = '"+searchPaper.getS_paper_id()+"' ";
		}
		if(!StringUtil.isEmpty(searchPaper.getS_title())){
			hql += " and title = '"+searchPaper.getS_title()+"' ";
		}
		if(!StringUtil.isEmpty(searchPaper.getS_author())){
			hql += " and author = '"+searchPaper.getS_author()+"' ";
		}
		if(!StringUtil.isEmpty(searchPaper.getS_paper_abstract())){
			hql += " and paper_abstract = '"+searchPaper.getS_paper_abstract()+"' ";
		}
		if(!StringUtil.isEmpty(searchPaper.getS_publish_time())){
			hql += " and publish_time = '"+searchPaper.getS_publish_time()+"' ";
		}
		if(!StringUtil.isEmpty(searchPaper.getS_journal())){
			hql += " and journal = '"+searchPaper.getS_journal()+"' ";
		}
		if(!StringUtil.isEmpty(searchPaper.getS_support_fund())){
			hql += " and support_fund = '"+searchPaper.getS_support_fund()+"' ";
		}
		if(!StringUtil.isEmpty(searchPaper.getS_user_no())){
			hql += " and user_no = '"+searchPaper.getS_user_no()+"' ";
		}
		hql += " order by publish_time desc ";
		List<Paper> papers = (List<Paper>) find(hql);
		return papers;
	}
	
}

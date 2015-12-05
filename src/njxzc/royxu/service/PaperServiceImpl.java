package njxzc.royxu.service;

import java.sql.SQLException;
import java.util.List;

import njxzc.royxu.dao.PaperDao;
import njxzc.royxu.domain.Paper;
import njxzc.royxu.searchmodel.SearchPaper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.core.Page;
import com.util.StringUtil;

/**
 * 文献Service
 * @author LiangHong
 * @version 2015-10-03
 */
@Service
@Transactional
public class PaperServiceImpl {

	@Autowired
	private PaperDao paperDao;
	
	public void savePaper(Paper paper){
		paperDao.save(paper);
	}
	
	public List<Paper> loadAllPapers(){
//		return paperDao.loadAll();
		return paperDao.loadAllPaper();
	}
	
	public Page getSysParams(int pageNo, int pageSize,SearchPaper searchPaper, Object... conditions) {
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
		
		Page page = paperDao.pagedQuery(hql, pageNo,pageSize, conditions);
		return page;
	}
	
	public Page getPagedPapers(int offset, int pageSize,SearchPaper searchPaper, Object... conditions) {
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
		
		Page page = paperDao.pagedQuery2(hql, offset,pageSize, conditions);
		return page;
	}
	
	public void deletePapers(List<Paper> papers){
		paperDao.deleteAll(papers);
	}
	
	public void updatePaper(Paper paper){
		paperDao.update(paper);
	}
	
	public void deletePaper(Paper paper){
		paperDao.delete(paper);
	}
	
//	根据del_flag批量修改（等于删除）
	public void deletePapersBySqls(String[] ids) throws SQLException{
		paperDao.deletePapersBySqls(ids);
	}
	
//	按条件查询
	public List<Paper> findPapers(SearchPaper searchPaper){
		return paperDao.findPapers(searchPaper);
	}
}

package njxzc.royxu.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import njxzc.royxu.domain.Homework;
import njxzc.royxu.searchmodel.SearchHomework;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.core.BaseDao;
import com.util.StringUtil;

/**
 * 学生作业DAO接口
 * @author LiangHong
 * @version 2015-10-03
 */
@Repository
public class HomeworkDao extends BaseDao<Homework> {
	@Resource
	private HibernateTemplate hibernateTemplate;
	
//	根据del_flag批量修改（等于删除）
	public void deleteHomeworksBySqls(String[] ids) throws SQLException{
		List<String> sqls = new ArrayList<String>();
		for(String id : ids){
			String sql = "update Homework set ? where = ?";
			sqls.add(sql);
		}
		updateSqls(sqls);
	}
	
	@SuppressWarnings("unchecked")
	public List<Homework> searchHomework(SearchHomework searchHomework){
		String hql = "from Homework h where 1=1 ";
		if(!StringUtil.isEmpty(searchHomework.getS_homework_id())){
			hql += " and h.homework_id='"+searchHomework.getS_homework_id()+"' ";
		}
		List<Homework> homeworks = (List<Homework>) find(hql);
		return homeworks;
	}
	
	//根据条件查询
	@SuppressWarnings("unchecked")
	public List<Homework> findHomeworks(SearchHomework searchHomework){
		String hql = "from Homework where 1=1 ";
		if(!StringUtil.isEmpty(searchHomework.getS_homework_id())){
			hql += " and homework_id = '"+searchHomework.getS_homework_id()+"' ";
		}
		if(!StringUtil.isEmpty(searchHomework.getS_homework_name())){
			hql += " and homework_name = '"+searchHomework.getS_homework_name()+"' ";
		}
		if(!StringUtil.isEmpty(searchHomework.getS_homework_course())){
			hql += " and homework_course = '"+searchHomework.getS_homework_course()+"' ";
		}
		if(!StringUtil.isEmpty(searchHomework.getS_homework_request())){
			hql += " and homework_request = '"+searchHomework.getS_homework_request()+"' ";
		}
		if(!StringUtil.isEmpty(searchHomework.getS_create_time())){
			hql += " and create_time = '"+searchHomework.getS_create_time()+"' ";
		}
		if(!StringUtil.isEmpty(searchHomework.getS_edit_time())){
			hql += " and edit_time = '"+searchHomework.getS_edit_time()+"' ";
		}
		if(!StringUtil.isEmpty(searchHomework.getS_del_flag())){
			hql += " and del_flag = '"+searchHomework.getS_del_flag()+"' ";
		}
		if(!StringUtil.isEmpty(searchHomework.getS_user_no())){
			hql += " and user_no = '"+searchHomework.getS_user_no()+"' ";
		}
		hql += " order by create_time desc ";
		List<Homework> homeworks = (List<Homework>) find(hql);
		return homeworks;
	}
	
}

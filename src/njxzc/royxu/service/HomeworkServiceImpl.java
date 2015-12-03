package njxzc.royxu.service;

import java.sql.SQLException;
import java.util.List;

import njxzc.royxu.dao.HomeworkDao;
import njxzc.royxu.domain.Homework;
import njxzc.royxu.searchmodel.SearchHomework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.core.Page;
import com.util.StringUtil;

/**
 * 学生作业Service
 * @author LiangHong
 * @version 2015-10-03
 */
@Service
@Transactional
public class HomeworkServiceImpl {

	@Autowired
	private HomeworkDao homeworkDao;
	
	public void saveHomework(Homework homework){
		homeworkDao.save(homework);
	}
	
	public List<Homework> loadAllHomeworks(){
		return homeworkDao.loadAll();
	}
	
	public Page getSysParams(int pageNo, int pageSize,SearchHomework searchHomework, Object... conditions) {
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
		
		Page page = homeworkDao.pagedQuery(hql, pageNo,pageSize, conditions);
		return page;
	}
	
	public Page getPagedHomeworks(int offset, int pageSize,SearchHomework searchHomework, Object... conditions) {
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
		
		Page page = homeworkDao.pagedQuery2(hql, offset,pageSize, conditions);
		return page;
	}
	
	public void deleteHomeworks(List<Homework> homeworks){
		homeworkDao.deleteAll(homeworks);
	}
	
	public void updateHomework(Homework homework){
		homeworkDao.update(homework);
	}
	
	public void deleteHomework(Homework homework){
		homeworkDao.delete(homework);
	}
	
//	根据del_flag批量修改（等于删除）
	public void deleteHomeworksBySqls(String[] ids) throws SQLException{
		homeworkDao.deleteHomeworksBySqls(ids);
	}
	
	public List<Homework> searchHomework(SearchHomework searchHomework){
		return homeworkDao.searchHomework(searchHomework);
	}
	
//	按条件查询
	public List<Homework> findHomeworks(SearchHomework searchHomework){
		return homeworkDao.findHomeworks(searchHomework);
	}
	
}

package njxzc.royxu.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import njxzc.royxu.domain.StudentProject;
import njxzc.royxu.searchmodel.SearchStudentProject;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.core.BaseDao;
import com.util.StringUtil;

/**
 * 学生项目DAO接口
 * @author LiangHong
 * @version 2015-10-03
 */
@Repository
public class StudentProjectDao extends BaseDao<StudentProject> {
	@Resource
	private HibernateTemplate hibernateTemplate;
	
//	根据del_flag批量修改（等于删除）
	public void deleteStudentProjectsBySqls(String[] ids) throws SQLException{
		List<String> sqls = new ArrayList<String>();
		for(String id : ids){
			String sql = "update StudentProject set ? where = ?";
			sqls.add(sql);
		}
		updateSqls(sqls);
	}
	
	@SuppressWarnings("unchecked")
	public List<StudentProject> searchStudentProject(SearchStudentProject searchStudentProject){
		String hql = "from StudentProject h where 1=1 ";
//		if(!StringUtil.isEmpty(searchStudentProject.getStu_proj_id())){
//			hql += " and h.stu_proj_id='"+searchStudentProject.getStu_proj_id()+"' ";
//		}
		List<StudentProject> studentProjects = (List<StudentProject>) find(hql);
		return studentProjects;
	}
	
	//根据条件查询
	@SuppressWarnings("unchecked")
	public List<StudentProject> findStudentProjects(SearchStudentProject searchStudentProject){
		String hql = "from StudentProject where 1=1 ";
		if(!StringUtil.isEmpty(searchStudentProject.getS_stu_proj_id())){
			hql += " and stu_proj_id = '"+searchStudentProject.getS_stu_proj_id()+"' ";
		}
		if(!StringUtil.isEmpty(searchStudentProject.getS_stu_proj_name())){
			hql += " and stu_proj_name = '"+searchStudentProject.getS_stu_proj_name()+"' ";
		}
		if(!StringUtil.isEmpty(searchStudentProject.getS_stu_proj_type())){
			hql += " and stu_proj_type = '"+searchStudentProject.getS_stu_proj_type()+"' ";
		}
		if(!StringUtil.isEmpty(searchStudentProject.getS_stu_proj_rank())){
			hql += " and stu_proj_rank = '"+searchStudentProject.getS_stu_proj_rank()+"' ";
		}
		if(!StringUtil.isEmpty(searchStudentProject.getS_main_students())){
			hql += " and main_students = '"+searchStudentProject.getS_main_students()+"' ";
		}
		if(!StringUtil.isEmpty(searchStudentProject.getS_proj_members())){
			hql += " and proj_members = '"+searchStudentProject.getS_proj_members()+"' ";
		}
		if(!StringUtil.isEmpty(searchStudentProject.getS_teachers())){
			hql += " and teachers = '"+searchStudentProject.getS_teachers()+"' ";
		}
		if(!StringUtil.isEmpty(searchStudentProject.getS_proj_results())){
			hql += " and proj_results = '"+searchStudentProject.getS_proj_results()+"' ";
		}
		if(!StringUtil.isEmpty(searchStudentProject.getS_user_no())){
			hql += " and user_no = '"+searchStudentProject.getS_user_no()+"' ";
		}
		
		List<StudentProject> studentprojects = (List<StudentProject>) find(hql);
		return studentprojects;
	}
	
}

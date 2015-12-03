package njxzc.royxu.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.core.Page;
import com.util.StringUtil;

import njxzc.royxu.domain.StudentProject;
import njxzc.royxu.dao.StudentProjectDao;
import njxzc.royxu.searchmodel.SearchStudentProject;

/**
 * 学生项目Service
 * @author LiangHong
 * @version 2015-10-03
 */
@Service
@Transactional
public class StudentProjectServiceImpl {

	@Autowired
	private StudentProjectDao studentProjectDao;
	
	public void saveStudentProject(StudentProject studentProject){
		studentProjectDao.save(studentProject);
	}
	
	public List<StudentProject> loadAllStudentProjects(){
		return studentProjectDao.loadAll();
	}
	
	public Page getSysParams(int pageNo, int pageSize,SearchStudentProject searchStudentProject, Object... conditions) {
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
		
		Page page = studentProjectDao.pagedQuery(hql, pageNo,pageSize, conditions);
		return page;
	}
	
	public Page getPagedStudentProjects(int offset, int pageSize,SearchStudentProject searchStudentProject, Object... conditions) {
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
		
		Page page = studentProjectDao.pagedQuery2(hql, offset,pageSize, conditions);
		return page;
	}
	
	public void deleteStudentProjects(List<StudentProject> studentProjects){
		studentProjectDao.deleteAll(studentProjects);
	}
	
	public void updateStudentProject(StudentProject studentProject){
		studentProjectDao.update(studentProject);
	}
	
	public void deleteStudentProject(StudentProject studentProject){
		studentProjectDao.delete(studentProject);
	}
	
//	根据del_flag批量修改（等于删除）
	public void deleteStudentProjectsBySqls(String[] ids) throws SQLException{
		studentProjectDao.deleteStudentProjectsBySqls(ids);
	}
	
	public List<StudentProject> searchStudentProject(SearchStudentProject searchStudentProject){
		return studentProjectDao.searchStudentProject(searchStudentProject);
	}
	
//	按条件查询
	public List<StudentProject> findStudentProjects(SearchStudentProject searchStudentProject){
		return studentProjectDao.findStudentProjects(searchStudentProject);
	}
}

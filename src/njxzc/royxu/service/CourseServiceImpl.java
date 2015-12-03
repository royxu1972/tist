package njxzc.royxu.service;

import java.sql.SQLException;
import java.util.List;

import njxzc.royxu.dao.CourseDao;
import njxzc.royxu.domain.Course;
import njxzc.royxu.searchmodel.SearchCourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.core.Page;
import com.util.StringUtil;

/**
 * 教学课程Service
 * @author LiangHong
 * @version 2015-10-03
 */
@Service
@Transactional
public class CourseServiceImpl {

	@Autowired
	private CourseDao courseDao;
	
	public void saveCourse(Course course){
		courseDao.save(course);
	}
	
	public List<Course> loadAllCourses(){
		return courseDao.loadAll();
	}
	
	public Page getSysParams(int pageNo, int pageSize,SearchCourse searchCourse, Object... conditions) {
		String hql = "from Course where 1=1 ";
		if(!StringUtil.isEmpty(searchCourse.getS_course_id())){
			hql += " and course_id = '"+searchCourse.getS_course_id()+"' ";
		}
		if(!StringUtil.isEmpty(searchCourse.getS_course_name())){
			hql += " and course_name = '"+searchCourse.getS_course_name()+"' ";
		}
		if(!StringUtil.isEmpty(searchCourse.getS_course_grades())){
			hql += " and course_grades = '"+searchCourse.getS_course_grades()+"' ";
		}
		if(!StringUtil.isEmpty(searchCourse.getS_course_length())){
			hql += " and course_length = '"+searchCourse.getS_course_length()+"' ";
		}
		if(!StringUtil.isEmpty(searchCourse.getS_course_intro())){
			hql += " and course_intro = '"+searchCourse.getS_course_intro()+"' ";
		}
		if(!StringUtil.isEmpty(searchCourse.getS_course_outline())){
			hql += " and course_outline = '"+searchCourse.getS_course_outline()+"' ";
		}
		if(!StringUtil.isEmpty(searchCourse.getS_user_no())){
			hql += " and user_no = '"+searchCourse.getS_user_no()+"' ";
		}
		
		Page page = courseDao.pagedQuery(hql, pageNo,pageSize, conditions);
		return page;
	}
	
	public Page getPagedCourses(int offset, int pageSize,SearchCourse searchCourse, Object... conditions) {
		String hql = "from Course where 1=1 ";
		if(!StringUtil.isEmpty(searchCourse.getS_course_id())){
			hql += " and course_id = '"+searchCourse.getS_course_id()+"' ";
		}
		if(!StringUtil.isEmpty(searchCourse.getS_course_name())){
			hql += " and course_name = '"+searchCourse.getS_course_name()+"' ";
		}
		if(!StringUtil.isEmpty(searchCourse.getS_course_grades())){
			hql += " and course_grades = '"+searchCourse.getS_course_grades()+"' ";
		}
		if(!StringUtil.isEmpty(searchCourse.getS_course_length())){
			hql += " and course_length = '"+searchCourse.getS_course_length()+"' ";
		}
		if(!StringUtil.isEmpty(searchCourse.getS_course_intro())){
			hql += " and course_intro = '"+searchCourse.getS_course_intro()+"' ";
		}
		if(!StringUtil.isEmpty(searchCourse.getS_course_outline())){
			hql += " and course_outline = '"+searchCourse.getS_course_outline()+"' ";
		}
		if(!StringUtil.isEmpty(searchCourse.getS_user_no())){
			hql += " and user_no = '"+searchCourse.getS_user_no()+"' ";
		}
		
		Page page = courseDao.pagedQuery2(hql, offset,pageSize, conditions);
		return page;
	}
	
	public void deleteCourses(List<Course> courses){
		courseDao.deleteAll(courses);
	}
	
	public void updateCourse(Course course){
		courseDao.update(course);
	}
	
	public void deleteCourse(Course course){
		courseDao.delete(course);
	}
	
//	根据del_flag批量修改（等于删除）
	public void deleteCoursesBySqls(String[] ids) throws SQLException{
		courseDao.deleteCoursesBySqls(ids);
	}
	
//	按条件查询
	public List<Course> findCourses(SearchCourse searchCourse){
		return courseDao.findCourses(searchCourse);
	}
}

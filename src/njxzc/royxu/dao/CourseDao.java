package njxzc.royxu.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import njxzc.royxu.domain.Course;
import njxzc.royxu.searchmodel.SearchCourse;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.core.BaseDao;
import com.util.StringUtil;

/**
 * 教学课程DAO接口
 * @author LiangHong
 * @version 2015-10-03
 */
@Repository
public class CourseDao extends BaseDao<Course> {
	@Resource
	private HibernateTemplate hibernateTemplate;
	
//	根据del_flag批量修改（等于删除）
	public void deleteCoursesBySqls(String[] ids) throws SQLException{
		List<String> sqls = new ArrayList<String>();
		for(String id : ids){
			String sql = "update Course set ? where = ?";
			sqls.add(sql);
		}
		updateSqls(sqls);
	}
	
	//根据条件查询
	@SuppressWarnings("unchecked")
	public List<Course> findCourses(SearchCourse searchCourse){
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
		
		List<Course> courses = (List<Course>) find(hql);
		return courses;
	}
	
}

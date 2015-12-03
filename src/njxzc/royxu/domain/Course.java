package njxzc.royxu.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Formula;

import com.core.BaseDomain;

/**
 * 教学课程Entity
 * @author LiangHong
 * @version 2015-10-03
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "roy_course")
public class Course extends BaseDomain {
	private static final long serialVersionUID = 1L;
	private String course_id;// 项目主键id
	private String course_name;// 课程名称
	private String course_grades;// 授课年级
	private String course_length;// 课时
	private String course_intro;// 课程介绍
	private String course_outline;// 课程大纲
	private String user_no;// 所属人员编号
	//@Formula
	private String old_names;//文件名字
	private String file_paths;//文件路径
	private String file_ids;//文件主键id
	private String file_types;//文件类型
	
	@Id
	@Column(columnDefinition="varchar(30) comment '课程主键id'")
	public String getCourse_id() {
		return this.course_id;
	}
	
	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}
	
	@Column(columnDefinition="varchar(1024) comment '课程名称'")
	public String getCourse_name() {
		return this.course_name;
	}
	
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	
	@Column(columnDefinition="varchar(1024) comment '授课年级'")
	public String getCourse_grades() {
		return this.course_grades;
	}
	
	public void setCourse_grades(String course_grades) {
		this.course_grades = course_grades;
	}
	
	@Column(columnDefinition="varchar(30) comment '课时'")
	public String getCourse_length() {
		return this.course_length;
	}
	
	public void setCourse_length(String course_length) {
		this.course_length = course_length;
	}
	
	@Column(columnDefinition="longtext comment '课程介绍'")
	public String getCourse_intro() {
		return course_intro;
	}

	public void setCourse_intro(String course_intro) {
		this.course_intro = course_intro;
	}

	@Column(columnDefinition="longtext comment '课程大纲'")
	public String getCourse_outline() {
		return course_outline;
	}

	public void setCourse_outline(String course_outline) {
		this.course_outline = course_outline;
	}
	
	@Column(columnDefinition="varchar(50) comment '所属人员编号'")
	public String getUser_no() {
		return user_no;
	}

	public void setUser_no(String user_no) {
		this.user_no = user_no;
	}

	@Formula("(select group_concat(att.original_name) from roy_attachment att "
			+ "where att.related_id=course_id and att.del_flag=0 and att.table_of_attachment='roy_course' "
			+ "order by att.attachment_id)")
	public String getOld_names() {
		return old_names;
	}

	public void setOld_names(String old_names) {
		this.old_names = old_names;
	}

	@Formula("(select group_concat(att.file_path) from roy_attachment att "
			+ "where att.related_id=course_id and att.del_flag=0 and att.table_of_attachment='roy_course' "
			+ "order by att.attachment_id)")
	public String getFile_paths() {
		return file_paths;
	}

	public void setFile_paths(String file_paths) {
		this.file_paths = file_paths;
	}

	@Formula("(select group_concat(att.attachment_id) from roy_attachment att "
			+ "where att.related_id=course_id and att.del_flag=0 and att.table_of_attachment='roy_course' "
			+ "order by att.attachment_id)")
	public String getFile_ids() {
		return file_ids;
	}

	public void setFile_ids(String file_ids) {
		this.file_ids = file_ids;
	}
	
	@Formula("(select group_concat(att.file_type) from roy_attachment att "
			+ "where att.related_id=course_id and att.del_flag=0 and att.table_of_attachment='roy_course' "
			+ "order by att.attachment_id)")
	public String getFile_types() {
		return file_types;
	}

	public void setFile_types(String file_types) {
		this.file_types = file_types;
	}
	
	@Override
	public String toString() {
		return "{" +
			"course_id : " + course_id + "," +
			"course_name : " + course_name + "," +
			"course_grades : " + course_grades + "," +
			"course_length : " + course_length + 
		"}";
	}
}



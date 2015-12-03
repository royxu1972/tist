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
 * 学生项目Entity
 * @author LiangHong
 * @version 2015-10-03
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "roy_student_project")
public class StudentProject extends BaseDomain {
	private static final long serialVersionUID = 1L;
	private String stu_proj_id;// 项目主键id
	private String stu_proj_name;// 项目名称
	private String stu_proj_type;// 项目类型
	private String stu_proj_rank;// 项目级别
	private String main_students;// 项目负责人
	private String proj_members;// 项目成员
	private String teachers;// 指导老师
	private String proj_results;// 项目成果
	private String user_no;// 所属人员编号
	//@Formula
	private String old_names;//文件名字
	private String file_paths;//文件路径
	private String file_ids;//文件主键id
	private String file_types;//文件类型
	
	@Id
	@Column(columnDefinition="varchar(30) comment '项目主键id'")
	public String getStu_proj_id() {
		return this.stu_proj_id;
	}
	
	public void setStu_proj_id(String stu_proj_id) {
		this.stu_proj_id = stu_proj_id;
	}
	
	@Column(columnDefinition="varchar(1024) comment '项目名称'")
	public String getStu_proj_name() {
		return this.stu_proj_name;
	}
	
	public void setStu_proj_name(String stu_proj_name) {
		this.stu_proj_name = stu_proj_name;
	}
	
	@Column(columnDefinition="varchar(50) comment '项目类型'")
	public String getStu_proj_type() {
		return this.stu_proj_type;
	}
	
	public void setStu_proj_type(String stu_proj_type) {
		this.stu_proj_type = stu_proj_type;
	}
	
	@Column(columnDefinition="varchar(30) comment '项目级别'")
	public String getStu_proj_rank() {
		return this.stu_proj_rank;
	}
	
	public void setStu_proj_rank(String stu_proj_rank) {
		this.stu_proj_rank = stu_proj_rank;
	}
	
	@Column(columnDefinition="varchar(1024) comment '项目负责人'")
	public String getMain_students() {
		return this.main_students;
	}
	
	public void setMain_students(String main_students) {
		this.main_students = main_students;
	}
	
	@Column(columnDefinition="varchar(1024) comment '项目成员'")
	public String getProj_members() {
		return this.proj_members;
	}
	
	public void setProj_members(String proj_members) {
		this.proj_members = proj_members;
	}
	
	@Column(columnDefinition="varchar(1024) comment '指导老师'")
	public String getTeachers() {
		return this.teachers;
	}
	
	public void setTeachers(String teachers) {
		this.teachers = teachers;
	}
	
	@Column(columnDefinition="text comment '项目成果'")
	public String getProj_results() {
		return this.proj_results;
	}
	
	public void setProj_results(String proj_results) {
		this.proj_results = proj_results;
	}
	
	@Column(columnDefinition="varchar(50) comment '所属人员编号'")
	public String getUser_no() {
		return user_no;
	}

	public void setUser_no(String user_no) {
		this.user_no = user_no;
	}
	
	@Formula("(select group_concat(att.original_name) from roy_attachment att "
			+ "where att.related_id=stu_proj_id and att.del_flag=0 and att.table_of_attachment='roy_student_project' "
			+ "order by att.attachment_id)")
	public String getOld_names() {
		return old_names;
	}

	public void setOld_names(String old_names) {
		this.old_names = old_names;
	}

	@Formula("(select group_concat(att.file_path) from roy_attachment att "
			+ "where att.related_id=stu_proj_id and att.del_flag=0 and att.table_of_attachment='roy_student_project' "
			+ "order by att.attachment_id)")
	public String getFile_paths() {
		return file_paths;
	}

	public void setFile_paths(String file_paths) {
		this.file_paths = file_paths;
	}

	@Formula("(select group_concat(att.attachment_id) from roy_attachment att "
			+ "where att.related_id=stu_proj_id and att.del_flag=0 and att.table_of_attachment='roy_student_project' "
			+ "order by att.attachment_id)")
	public String getFile_ids() {
		return file_ids;
	}

	public void setFile_ids(String file_ids) {
		this.file_ids = file_ids;
	}
	
	@Formula("(select group_concat(att.file_type) from roy_attachment att "
			+ "where att.related_id=stu_proj_id and att.del_flag=0 and att.table_of_attachment='roy_student_project' "
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
			"stu_proj_id : " + stu_proj_id + "," +
			"stu_proj_name : " + stu_proj_name + "," +
			"stu_proj_type : " + stu_proj_type + "," +
			"stu_proj_rank : " + stu_proj_rank + "," +
			"main_students : " + main_students + "," +
			"proj_members : " + proj_members + "," +
			"teachers : " + teachers + "," +
			"proj_results : " + proj_results + 
		"}";
	}
}



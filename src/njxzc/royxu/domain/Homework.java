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
 * 学生作业Entity
 * @author LiangHong
 * @version 2015-10-03
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "roy_homework")
public class Homework extends BaseDomain {
	private static final long serialVersionUID = 1L;
	private String homework_id;// 作业主键id
	private String homework_name;// 作业名称
	private String homework_course;// 所属课程
	private String homework_request;// 作业要求
	private String create_time;// 创建时间
	private String edit_time;// 修改时间
	private String del_flag;// 删除标志位
	private String user_no;// 所属人员编号
	//@Formula
	private String old_names;//文件名字
	private String file_paths;//文件路径
	private String file_ids;//文件主键id
	private String file_types;//文件类型
	
	@Id
	@Column(columnDefinition="varchar(30) comment '作业主键id'")
	public String getHomework_id() {
		return this.homework_id;
	}
	
	public void setHomework_id(String homework_id) {
		this.homework_id = homework_id;
	}
	
	@Column(columnDefinition="varchar(1024) comment '作业名称'")
	public String getHomework_name() {
		return this.homework_name;
	}
	
	public void setHomework_name(String homework_name) {
		this.homework_name = homework_name;
	}
	
	@Column(columnDefinition="varchar(1024) comment '所属课程'")
	public String getHomework_course() {
		return homework_course;
	}

	public void setHomework_course(String homework_course) {
		this.homework_course = homework_course;
	}

	@Column(columnDefinition="varchar(1024) comment '作业要求'")
	public String getHomework_request() {
		return this.homework_request;
	}
	
	public void setHomework_request(String homework_request) {
		this.homework_request = homework_request;
	}
	
	@Column(columnDefinition="varchar(30) comment '创建时间'")
	public String getCreate_time() {
		return this.create_time;
	}
	
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	
	@Column(columnDefinition="varchar(30) comment '修改时间'")
	public String getEdit_time() {
		return this.edit_time;
	}
	
	public void setEdit_time(String edit_time) {
		this.edit_time = edit_time;
	}
	
	@Column(columnDefinition="varchar(1) comment '删除标志位'")
	public String getDel_flag() {
		return this.del_flag;
	}
	
	public void setDel_flag(String del_flag) {
		this.del_flag = del_flag;
	}
	
	@Column(columnDefinition="varchar(50) comment '所属人员编号'")
	public String getUser_no() {
		return user_no;
	}

	public void setUser_no(String user_no) {
		this.user_no = user_no;
	}
	
	@Formula("(select group_concat(att.original_name) from roy_attachment att "
			+ "where att.related_id=homework_id and att.del_flag=0 and att.table_of_attachment='roy_homework' "
			+ "order by att.attachment_id)")
	public String getOld_names() {
		return old_names;
	}

	public void setOld_names(String old_names) {
		this.old_names = old_names;
	}

	@Formula("(select group_concat(att.file_path) from roy_attachment att "
			+ "where att.related_id=homework_id and att.del_flag=0 and att.table_of_attachment='roy_homework' "
			+ "order by att.attachment_id)")
	public String getFile_paths() {
		return file_paths;
	}

	public void setFile_paths(String file_paths) {
		this.file_paths = file_paths;
	}

	@Formula("(select group_concat(att.attachment_id) from roy_attachment att "
			+ "where att.related_id=homework_id and att.del_flag=0 and att.table_of_attachment='roy_homework' "
			+ "order by att.attachment_id)")
	public String getFile_ids() {
		return file_ids;
	}

	public void setFile_ids(String file_ids) {
		this.file_ids = file_ids;
	}
	
	@Formula("(select group_concat(att.file_type) from roy_attachment att "
			+ "where att.related_id=homework_id and att.del_flag=0 and att.table_of_attachment='roy_homework' "
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
			"homework_id : " + homework_id + "," +
			"homework_name : " + homework_name + "," +
			"homework_request : " + homework_request + "," +
			"create_time : " + create_time + "," +
			"edit_time : " + edit_time + "," +
			"del_flag : " + del_flag + 
		"}";
	}
}



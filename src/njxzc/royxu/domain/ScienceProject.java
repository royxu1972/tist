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
 * 科研项目Entity
 * @author LiangHong
 * @version 2015-10-03
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "roy_science_project")
public class ScienceProject extends BaseDomain {
	private static final long serialVersionUID = 1L;
	private String proj_id;// 项目主键id
	private String proj_name;// 项目名称
	private String proj_origin;// 项目来源
	private String start_date;// 开始日期
	private String end_date;// 结束日期
	private String proj_fund;// 项目经费
	private String my_work;// 我承担的工作
	private String proj_info;// 项目介绍
	private String user_no;// 所属人员编号
	//@Formula
	private String old_names;//文件名字
	private String file_paths;//文件路径
	private String file_ids;//文件主键id
	private String file_types;//文件类型
	
	@Id
	@Column(columnDefinition="varchar(30) comment '项目主键id'")
	public String getProj_id() {
		return this.proj_id;
	}
	
	public void setProj_id(String proj_id) {
		this.proj_id = proj_id;
	}
	
	@Column(columnDefinition="varchar(1024) comment '项目名称'")
	public String getProj_name() {
		return this.proj_name;
	}
	
	public void setProj_name(String proj_name) {
		this.proj_name = proj_name;
	}
	
	@Column(columnDefinition="varchar(1024) comment '项目来源'")
	public String getProj_origin() {
		return this.proj_origin;
	}
	
	public void setProj_origin(String proj_origin) {
		this.proj_origin = proj_origin;
	}
	
	@Column(columnDefinition="varchar(30) comment '开始日期'")
	public String getStart_date() {
		return this.start_date;
	}
	
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	
	@Column(columnDefinition="varchar(30) comment '结束日期'")
	public String getEnd_date() {
		return this.end_date;
	}
	
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	
	@Column(columnDefinition="varchar(30) comment '项目经费'")
	public String getProj_fund() {
		return this.proj_fund;
	}
	
	public void setProj_fund(String proj_fund) {
		this.proj_fund = proj_fund;
	}
	
	@Column(columnDefinition="varchar(1024) comment '我承担的工作'")
	public String getMy_work() {
		return this.my_work;
	}
	
	public void setMy_work(String my_work) {
		this.my_work = my_work;
	}
	
	@Column(columnDefinition="text comment '项目介绍'")
	public String getProj_info() {
		return this.proj_info;
	}
	
	public void setProj_info(String proj_info) {
		this.proj_info = proj_info;
	}
	
	@Column(columnDefinition="varchar(50) comment '所属人员编号'")
	public String getUser_no() {
		return user_no;
	}

	public void setUser_no(String user_no) {
		this.user_no = user_no;
	}
	
	@Formula("(select group_concat(att.original_name) from roy_attachment att "
			+ "where att.related_id=proj_id and att.del_flag=0 and att.table_of_attachment='roy_science_project' "
			+ "order by att.attachment_id)")
	public String getOld_names() {
		return old_names;
	}

	public void setOld_names(String old_names) {
		this.old_names = old_names;
	}

	@Formula("(select group_concat(att.file_path) from roy_attachment att "
			+ "where att.related_id=proj_id and att.del_flag=0 and att.table_of_attachment='roy_science_project' "
			+ "order by att.attachment_id)")
	public String getFile_paths() {
		return file_paths;
	}

	public void setFile_paths(String file_paths) {
		this.file_paths = file_paths;
	}

	@Formula("(select group_concat(att.attachment_id) from roy_attachment att "
			+ "where att.related_id=proj_id and att.del_flag=0 and att.table_of_attachment='roy_science_project' "
			+ "order by att.attachment_id)")
	public String getFile_ids() {
		return file_ids;
	}

	public void setFile_ids(String file_ids) {
		this.file_ids = file_ids;
	}
	
	@Formula("(select group_concat(att.file_type) from roy_attachment att "
			+ "where att.related_id=proj_id and att.del_flag=0 and att.table_of_attachment='roy_science_project' "
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
			"proj_id : " + proj_id + "," +
			"proj_name : " + proj_name + "," +
			"proj_origin : " + proj_origin + "," +
			"start_date : " + start_date + "," +
			"end_date : " + end_date + "," +
			"proj_fund : " + proj_fund + "," +
			"my_work : " + my_work + "," +
			"proj_info : " + proj_info + 
		"}";
	}
}



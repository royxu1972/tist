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
 * 基本信息Entity
 * @author LiangHong
 * @version 2015-10-02
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "roy_basic_info")
public class BasicInfo extends BaseDomain {
	private static final long serialVersionUID = 1L;
	private String increment_id;//主键自增id
	private String name;// 姓名
	private String en_name;// 英文名
	private String gender;// 性别
	private String birthday;// 出生年月
	private String academic;// 学历
	private String pro_title;// 职称
	private String email;// 邮箱
	private String address;// 联系地址
	private String zh_introduction;// 中文简介
	private String en_introduction;// 英文简介
	private String detail_introduction;// 详细介绍
	private String member_type;// 成员类型
	private String member_site;// 成员个人主页
	private String member_role;// 项目组承担角色
	private Integer member_sort;// 成员顺序
	private String research_area;// 研究方向
	private String email_validated;// 邮箱是否验证
	//@Formula
	private String old_names;//文件名字
	private String file_paths;//文件路径
	private String file_ids;//文件主键id
	private String file_types;//文件类型
	private String teach_courses;//教学课程
	
	@Id
	@Column(columnDefinition="varchar(30) comment '自增id'")
	public String getIncrement_id() {
		return increment_id;
	}

	public void setIncrement_id(String increment_id) {
		this.increment_id = increment_id;
	}
	
	@Column(columnDefinition="varchar(50) comment '姓名'")
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(columnDefinition="varchar(50) comment '英文名'")
	public String getEn_name() {
		return en_name;
	}

	public void setEn_name(String en_name) {
		this.en_name = en_name;
	}

	@Column(columnDefinition="varchar(10) comment '性别'")
	public String getGender() {
		return this.gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Column(columnDefinition="varchar(30) comment '出生年月'")
	public String getBirthday() {
		return this.birthday;
	}
	
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	@Column(columnDefinition="varchar(100) comment '学历'")
	public String getAcademic() {
		return this.academic;
	}
	
	public void setAcademic(String academic) {
		this.academic = academic;
	}
	
	@Column(columnDefinition="varchar(255) comment '职称'")
	public String getPro_title() {
		return this.pro_title;
	}
	
	public void setPro_title(String pro_title) {
		this.pro_title = pro_title;
	}
	
	@Column(columnDefinition="varchar(255) comment '邮箱'")
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(columnDefinition="varchar(1024) comment '联系地址'")
	public String getAddress() {
		return this.address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Column(columnDefinition="text comment '中文简介'")
	public String getZh_introduction() {
		return this.zh_introduction;
	}
	
	public void setZh_introduction(String zh_introduction) {
		this.zh_introduction = zh_introduction;
	}
	
	@Column(columnDefinition="text comment '英文简介'")
	public String getEn_introduction() {
		return this.en_introduction;
	}
	
	public void setEn_introduction(String en_introduction) {
		this.en_introduction = en_introduction;
	}
	
	@Column(columnDefinition="text comment '详细介绍'")
	public String getDetail_introduction() {
		return this.detail_introduction;
	}
	
	public void setDetail_introduction(String detail_introduction) {
		this.detail_introduction = detail_introduction;
	}
	
	@Column(columnDefinition="varchar(30) comment '成员类型'")
	public String getMember_type() {
		return this.member_type;
	}
	
	public void setMember_type(String member_type) {
		this.member_type = member_type;
	}
	
	@Column(columnDefinition="varchar(1024) comment '成员个人主页'")
	public String getMember_site() {
		return this.member_site;
	}
	
	public void setMember_site(String member_site) {
		this.member_site = member_site;
	}
	
	@Column(columnDefinition="varchar(1024) comment '项目组承担角色'")
	public String getMember_role() {
		return member_role;
	}

	public void setMember_role(String member_role) {
		this.member_role = member_role;
	}

	@Column(columnDefinition="int(11) comment '成员顺序'")
	public Integer getMember_sort() {
		return member_sort;
	}

	public void setMember_sort(Integer member_sort) {
		this.member_sort = member_sort;
	}
	
	@Column(columnDefinition="varchar(255) comment '研究方向'")
	public String getResearch_area() {
		return research_area;
	}

	public void setResearch_area(String research_area) {
		this.research_area = research_area;
	}

	@Column(columnDefinition="varchar(255) delfault '未验证' comment '邮箱是否验证'")
	public String getEmail_validated() {
		return email_validated;
	}

	public void setEmail_validated(String email_validated) {
		this.email_validated = email_validated;
	}

	@Formula("(select group_concat(att.original_name) from roy_attachment att "
			+ "where att.related_id=increment_id and att.del_flag=0 and att.table_of_attachment='roy_basic_info' "
			+ "order by att.attachment_id)")
	public String getOld_names() {
		return old_names;
	}

	public void setOld_names(String old_names) {
		this.old_names = old_names;
	}

	@Formula("(select group_concat(att.file_path) from roy_attachment att "
			+ "where att.related_id=increment_id and att.del_flag=0 and att.table_of_attachment='roy_basic_info' "
			+ "order by att.attachment_id)")
	public String getFile_paths() {
		return file_paths;
	}

	public void setFile_paths(String file_paths) {
		this.file_paths = file_paths;
	}

	@Formula("(select group_concat(att.attachment_id) from roy_attachment att "
			+ "where att.related_id=increment_id and att.del_flag=0 and att.table_of_attachment='roy_basic_info' "
			+ "order by att.attachment_id)")
	public String getFile_ids() {
		return file_ids;
	}

	public void setFile_ids(String file_ids) {
		this.file_ids = file_ids;
	}
	
	@Formula("(select group_concat(att.file_type) from roy_attachment att "
			+ "where att.related_id=increment_id and att.del_flag=0 and att.table_of_attachment='roy_basic_info' "
			+ "order by att.attachment_id)")
	public String getFile_types() {
		return file_types;
	}

	public void setFile_types(String file_types) {
		this.file_types = file_types;
	}
	
	@Formula("(select group_concat(c.course_name) from roy_course c where c.user_no=increment_id)")
	public String getTeach_courses() {
		return teach_courses;
	}

	public void setTeach_courses(String teach_courses) {
		this.teach_courses = teach_courses;
	}

	@Override
	public String toString() {
		return "{" +
			"name : " + name + "," +
			"gender : " + gender + "," +
			"birthday : " + birthday + "," +
			"academic : " + academic + "," +
			"pro_title : " + pro_title + "," +
			"email : " + email + "," +
			"address : " + address + "," +
			"zh_introduction : " + zh_introduction + "," +
			"en_introduction : " + en_introduction + "," +
			"detail_introduction : " + detail_introduction + 
		"}";
	}
}



package njxzc.royxu.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.core.BaseDomain;

/**
 * 项目组成员Entity
 * @author LiangHong
 * @version 2015-10-24
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "roy_group_member")
public class GroupMember extends BaseDomain {
	private static final long serialVersionUID = 1L;
	private int increment_id;//主键自增id
	private String member_name;// 成员姓名
	private String member_gender;// 成员性别
	private String member_password;// 登陆密码
	private String member_type;// 成员类型
	private String member_site;// 成员个人主页
	private int member_sort;// 成员顺序
	private String del_flag;// 删除标志位
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//自增长
	@Column(columnDefinition="int(11) comment '自增id'")
	public int getIncrement_id() {
		return increment_id;
	}

	public void setIncrement_id(int increment_id) {
		this.increment_id = increment_id;
	}
	
	@Column(columnDefinition="varchar(35) comment '成员姓名'")
	public String getMember_name() {
		return this.member_name;
	}
	
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	
	@Column(columnDefinition="varchar(5) comment '成员性别'")
	public String getMember_gender() {
		return this.member_gender;
	}
	
	public void setMember_gender(String member_gender) {
		this.member_gender = member_gender;
	}
	
	@Column(columnDefinition="varchar(255) comment '登陆密码'")
	public String getMember_password() {
		return this.member_password;
	}
	
	public void setMember_password(String member_password) {
		this.member_password = member_password;
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
	
	@Column(columnDefinition="int(11) comment '成员顺序'")
	public int getMember_sort() {
		return member_sort;
	}

	public void setMember_sort(int member_sort) {
		this.member_sort = member_sort;
	}

	@Column(columnDefinition="varchar(1) comment '删除标志位'")
	public String getDel_flag() {
		return this.del_flag;
	}
	
	public void setDel_flag(String del_flag) {
		this.del_flag = del_flag;
	}
	
	
	@Override
	public String toString() {
		return "{" +
			"member_name : " + member_name + "," +
			"member_gender : " + member_gender + "," +
			"member_password : " + member_password + "," +
			"member_type : " + member_type + "," +
			"member_site : " + member_site + "," +
			"del_flag : " + del_flag + 
		"}";
	}
}



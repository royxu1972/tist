package njxzc.royxu.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Formula;

import com.core.BaseDomain;

@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "sys_user")
public class User extends BaseDomain {
	private static final long serialVersionUID = 1L;
	private int user_id;//自增的用户id
	private String user_name;//姓名
	private String sex;//性别
	private String user_no;//员工编号
	private String user_password;//登陆密码
	private String login_name;//登陆用户名
	private String department_id;//部门编号
	private String email;//邮箱
	private String mobilephone;//手机号码
	private String phone;//家庭电话
	private String bank_card;//银行卡号
	private String login_ip;//登陆时的ip地址
	private String login_time;//登陆时间
	private String create_by;//创建者
	private String create_time;//创建时间
	private String update_by;//修改者
	private String update_time;//修改时间
	private String enter_time;//入职时间
	private String leave_time;//离职时间
	private String note;//备注
	private String del_flag = "0";//删除标志位
	//@Formula
	private String role_ids;//用户角色
	private String increment_id;//sys_user_role的主键

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//自增长
	@Column(columnDefinition="int(11) comment '用户编号'")
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	@Column(columnDefinition="varchar(100) comment '员工编号'")
	public String getUser_no() {
		return user_no;
	}

	public void setUser_no(String user_no) {
		this.user_no = user_no;
	}

	@Column(columnDefinition="varchar(30) comment '用户姓名'")
	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	@Column(columnDefinition="varchar(5) comment '性别'")
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(columnDefinition="varchar(24) comment '登陆密码'")
	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	@Column(columnDefinition="varchar(100) comment '登录名'")
	public String getLogin_name() {
		return login_name;
	}

	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}

	@Column(columnDefinition="varchar(64) comment '部门编号'")
	public String getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(String department_id) {
		this.department_id = department_id;
	}

	@Column(columnDefinition="varchar(100) comment '邮箱'")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(columnDefinition="varchar(20) comment '手机号码'")
	public String getMobilephone() {
		return mobilephone;
	}

	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}

	@Column(columnDefinition="varchar(20) comment '家庭电话'")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(columnDefinition="varchar(100) comment '银行卡号'")
	public String getBank_card() {
		return bank_card;
	}

	public void setBank_card(String bank_card) {
		this.bank_card = bank_card;
	}

	@Column(columnDefinition="varchar(100) comment '登陆ip'")
	public String getLogin_ip() {
		return login_ip;
	}

	public void setLogin_ip(String login_ip) {
		this.login_ip = login_ip;
	}

	@Column(columnDefinition="varchar(30) comment '登陆时间'")
	public String getLogin_time() {
		return login_time;
	}

	public void setLogin_time(String login_time) {
		this.login_time = login_time;
	}

	@Column(columnDefinition="varchar(20) comment '创建者'")
	public String getCreate_by() {
		return create_by;
	}

	public void setCreate_by(String create_by) {
		this.create_by = create_by;
	}
	
	@Column(columnDefinition="varchar(30) comment '创建时间'")
	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	@Column(columnDefinition="varchar(20) comment '修改者'")
	public String getUpdate_by() {
		return update_by;
	}

	public void setUpdate_by(String update_by) {
		this.update_by = update_by;
	}

	@Column(columnDefinition="varchar(30) comment '修改时间'")
	public String getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}

	@Column(columnDefinition="varchar(30) comment '入职时间'")
	public String getEnter_time() {
		return enter_time;
	}

	public void setEnter_time(String enter_time) {
		this.enter_time = enter_time;
	}

	@Column(columnDefinition="varchar(30) comment '离职时间'")
	public String getLeave_time() {
		return leave_time;
	}

	public void setLeave_time(String leave_time) {
		this.leave_time = leave_time;
	}

	@Column(columnDefinition="varchar(255) comment '备注'")
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Formula("(select ur.role_ids from sys_user_role ur where ur.user_id=user_id)")
	public String getRole_ids() {
		return role_ids;
	}

	public void setRole_ids(String role_ids) {
		this.role_ids = role_ids;
	}

	@Formula("(select ur.increment_id from sys_user_role ur where ur.user_id=user_id)")
	public String getIncrement_id() {
		return increment_id;
	}

	public void setIncrement_id(String increment_id) {
		this.increment_id = increment_id;
	}

	@Column(columnDefinition="char(1) default 0 comment '删除标志位'", nullable = false)
	public String getDel_flag() {
		return del_flag;
	}

	public void setDel_flag(String del_flag) {
		this.del_flag = del_flag;
	}

	@Override
	public String toString() {
		return "User{\"user_id\":\"" + user_id + "\",\"user_name\":\""
				+ user_name + "\",\"sex\":\"" + sex + "\",\"user_no\":\""
				+ user_no + "\",\"user_password\":\"" + user_password
				+ "\",\"login_name\":\"" + login_name
				+ "\",\"department_id\":\"" + department_id + "\",\"email\":\""
				+ email + "\",\"mobilephone\":\"" + mobilephone
				+ "\",\"phone\":\"" + phone + "\",\"bank_card\":\"" + bank_card
				+ "\",\"login_ip\":\"" + login_ip + "\",\"login_time\":\""
				+ login_time + "\",\"create_by\":\"" + create_by
				+ "\",\"create_time\":\"" + create_time + "\",\"update_by\":\""
				+ update_by + "\",\"update_time\":\"" + update_time
				+ "\",\"enter_time\":\"" + enter_time + "\",\"leave_time\":\""
				+ leave_time + "\",\"note\":\"" + note + "\",\"del_flag\":\""
				+ del_flag + "\",\"role_ids\":\"" + role_ids
				+ "\",\"increment_id\":\"" + increment_id + "\"}  ";
	}

}

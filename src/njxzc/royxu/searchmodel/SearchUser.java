package njxzc.royxu.searchmodel;

public class SearchUser {
	private String s_user_id;// 自增的用户id
	private String s_user_name;// 姓名
	private String s_sex;// 性别
	private String s_user_no;// 员工编号
	private String s_user_password;// 登陆密码
	private String s_login_name;// 登陆用户名
	private String s_department_id;// 部门编号
	private String s_email;// 邮箱
	private String s_mobilephone;// 手机号码
	private String s_phone;// 家庭电话
	private String s_bank_card;// 银行卡号
	private String s_login_ip;// 登陆时的ip地址
	private String s_login_time;// 登陆时间
	private String s_create_by;// 创建者
	private String s_create_time;// 创建时间
	private String s_update_by;// 修改者
	private String s_update_time;// 修改时间
	private String s_enter_time;// 入职时间
	private String s_leave_time;// 离职时间
	private String s_note;// 备注
	private String s_del_flag;// 删除标志位
	
	public String getS_user_id() {
		return this.s_user_id;
	}
	
	public void setS_user_id(String s_user_id) {
		this.s_user_id = s_user_id;
	}
	
	public String getS_user_name() {
		return this.s_user_name;
	}
	
	public void setS_user_name(String s_user_name) {
		this.s_user_name = s_user_name;
	}
	
	public String getS_sex() {
		return this.s_sex;
	}
	
	public void setS_sex(String s_sex) {
		this.s_sex = s_sex;
	}
	
	public String getS_user_no() {
		return this.s_user_no;
	}
	
	public void setS_user_no(String s_user_no) {
		this.s_user_no = s_user_no;
	}
	
	public String getS_user_password() {
		return this.s_user_password;
	}
	
	public void setS_user_password(String s_user_password) {
		this.s_user_password = s_user_password;
	}
	
	public String getS_login_name() {
		return this.s_login_name;
	}
	
	public void setS_login_name(String s_login_name) {
		this.s_login_name = s_login_name;
	}
	
	public String getS_department_id() {
		return this.s_department_id;
	}
	
	public void setS_department_id(String s_department_id) {
		this.s_department_id = s_department_id;
	}
	
	public String getS_email() {
		return this.s_email;
	}
	
	public void setS_email(String s_email) {
		this.s_email = s_email;
	}
	
	public String getS_mobilephone() {
		return this.s_mobilephone;
	}
	
	public void setS_mobilephone(String s_mobilephone) {
		this.s_mobilephone = s_mobilephone;
	}
	
	public String getS_phone() {
		return this.s_phone;
	}
	
	public void setS_phone(String s_phone) {
		this.s_phone = s_phone;
	}
	
	public String getS_bank_card() {
		return this.s_bank_card;
	}
	
	public void setS_bank_card(String s_bank_card) {
		this.s_bank_card = s_bank_card;
	}
	
	public String getS_login_ip() {
		return this.s_login_ip;
	}
	
	public void setS_login_ip(String s_login_ip) {
		this.s_login_ip = s_login_ip;
	}
	
	public String getS_login_time() {
		return this.s_login_time;
	}
	
	public void setS_login_time(String s_login_time) {
		this.s_login_time = s_login_time;
	}
	
	public String getS_create_by() {
		return this.s_create_by;
	}
	
	public void setS_create_by(String s_create_by) {
		this.s_create_by = s_create_by;
	}
	
	public String getS_create_time() {
		return this.s_create_time;
	}
	
	public void setS_create_time(String s_create_time) {
		this.s_create_time = s_create_time;
	}
	
	public String getS_update_by() {
		return this.s_update_by;
	}
	
	public void setS_update_by(String s_update_by) {
		this.s_update_by = s_update_by;
	}
	
	public String getS_update_time() {
		return this.s_update_time;
	}
	
	public void setS_update_time(String s_update_time) {
		this.s_update_time = s_update_time;
	}
	
	public String getS_enter_time() {
		return this.s_enter_time;
	}
	
	public void setS_enter_time(String s_enter_time) {
		this.s_enter_time = s_enter_time;
	}
	
	public String getS_leave_time() {
		return this.s_leave_time;
	}
	
	public void setS_leave_time(String s_leave_time) {
		this.s_leave_time = s_leave_time;
	}
	
	public String getS_note() {
		return this.s_note;
	}
	
	public void setS_note(String s_note) {
		this.s_note = s_note;
	}
	
	public String getS_del_flag() {
		return this.s_del_flag;
	}
	
	public void setS_del_flag(String s_del_flag) {
		this.s_del_flag = s_del_flag;
	}
	
	
	@Override
	public String toString() {
		return "{" +
			"user_id : " + s_user_id + "," +
			"user_name : " + s_user_name + "," +
			"sex : " + s_sex + "," +
			"user_no : " + s_user_no + "," +
			"user_password : " + s_user_password + "," +
			"login_name : " + s_login_name + "," +
			"department_id : " + s_department_id + "," +
			"email : " + s_email + "," +
			"mobilephone : " + s_mobilephone + "," +
			"phone : " + s_phone + "," +
			"bank_card : " + s_bank_card + "," +
			"login_ip : " + s_login_ip + "," +
			"login_time : " + s_login_time + "," +
			"create_by : " + s_create_by + "," +
			"create_time : " + s_create_time + "," +
			"update_by : " + s_update_by + "," +
			"update_time : " + s_update_time + "," +
			"enter_time : " + s_enter_time + "," +
			"leave_time : " + s_leave_time + "," +
			"note : " + s_note + "," +
			"del_flag : " + s_del_flag + 
		"}";
	}
}

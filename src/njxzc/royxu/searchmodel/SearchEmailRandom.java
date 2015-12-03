package njxzc.royxu.searchmodel;

//查询EmailRandom类
public class SearchEmailRandom {
	private String s_email;// 邮箱
	private String s_random_code;// 发给邮箱的验证码
	private String s_send_time;// 发送时间
	private String s_validate_time;// 验证时间
	private String s_is_validated;// 是否验证通过
	private String s_user_no;// 用户编号
	
	public String getS_email() {
		return this.s_email;
	}
	
	public void setS_email(String s_email) {
		this.s_email = s_email;
	}
	
	public String getS_random_code() {
		return this.s_random_code;
	}
	
	public void setS_random_code(String s_random_code) {
		this.s_random_code = s_random_code;
	}
	
	public String getS_send_time() {
		return this.s_send_time;
	}
	
	public void setS_send_time(String s_send_time) {
		this.s_send_time = s_send_time;
	}
	
	public String getS_validate_time() {
		return this.s_validate_time;
	}
	
	public void setS_validate_time(String s_validate_time) {
		this.s_validate_time = s_validate_time;
	}
	
	public String getS_is_validated() {
		return this.s_is_validated;
	}
	
	public void setS_is_validated(String s_is_validated) {
		this.s_is_validated = s_is_validated;
	}
	
	public String getS_user_no() {
		return this.s_user_no;
	}
	
	public void setS_user_no(String s_user_no) {
		this.s_user_no = s_user_no;
	}
	
	
	@Override
	public String toString() {
		return "{" +
			"email : " + s_email + "," +
			"random_code : " + s_random_code + "," +
			"send_time : " + s_send_time + "," +
			"validate_time : " + s_validate_time + "," +
			"is_validated : " + s_is_validated + "," +
			"user_no : " + s_user_no + 
		"}";
	}
}



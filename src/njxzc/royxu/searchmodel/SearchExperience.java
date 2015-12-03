package njxzc.royxu.searchmodel;

//查询Experience类
public class SearchExperience {
	private String s_experience_id;// 经历主键id
	private String s_time_period_start;// 开始日期
	private String s_time_period_end;// 结束日期
	private String s_experience_info;// 经历简介
	private String s_experience_role;// 角色
	private String s_user_no;// 所属人员编号
	
	public String getS_experience_id() {
		return this.s_experience_id;
	}
	
	public void setS_experience_id(String s_experience_id) {
		this.s_experience_id = s_experience_id;
	}
	
	public String getS_time_period_start() {
		return this.s_time_period_start;
	}
	
	public void setS_time_period_start(String s_time_period_start) {
		this.s_time_period_start = s_time_period_start;
	}
	
	public String getS_time_period_end() {
		return this.s_time_period_end;
	}
	
	public void setS_time_period_end(String s_time_period_end) {
		this.s_time_period_end = s_time_period_end;
	}
	
	public String getS_experience_info() {
		return this.s_experience_info;
	}
	
	public void setS_experience_info(String s_experience_info) {
		this.s_experience_info = s_experience_info;
	}
	
	public String getS_experience_role() {
		return this.s_experience_role;
	}
	
	public void setS_experience_role(String s_experience_role) {
		this.s_experience_role = s_experience_role;
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
			"experience_id : " + s_experience_id + "," +
			"time_period_start : " + s_time_period_start + "," +
			"time_period_end : " + s_time_period_end + "," +
			"experience_info : " + s_experience_info + "," +
			"experience_role : " + s_experience_role + "," +
			"user_no : " + s_user_no + 
		"}";
	}
}



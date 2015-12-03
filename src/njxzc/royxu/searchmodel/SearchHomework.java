package njxzc.royxu.searchmodel;

//查询Homework类
public class SearchHomework {
	private String s_homework_id;// 作业主键id
	private String s_homework_name;// 作业名称
	private String s_homework_course;// 所属课程
	private String s_homework_request;// 作业要求
	private String s_create_time;// 创建时间
	private String s_edit_time;// 修改时间
	private String s_del_flag;// 删除标志位
	private String s_user_no;// 所属人员编号
	
	public String getS_homework_id() {
		return this.s_homework_id;
	}
	
	public void setS_homework_id(String s_homework_id) {
		this.s_homework_id = s_homework_id;
	}
	
	public String getS_homework_name() {
		return this.s_homework_name;
	}
	
	public void setS_homework_name(String s_homework_name) {
		this.s_homework_name = s_homework_name;
	}
	
	public String getS_homework_course() {
		return this.s_homework_course;
	}
	
	public void setS_homework_course(String s_homework_course) {
		this.s_homework_course = s_homework_course;
	}
	
	public String getS_homework_request() {
		return this.s_homework_request;
	}
	
	public void setS_homework_request(String s_homework_request) {
		this.s_homework_request = s_homework_request;
	}
	
	public String getS_create_time() {
		return this.s_create_time;
	}
	
	public void setS_create_time(String s_create_time) {
		this.s_create_time = s_create_time;
	}
	
	public String getS_edit_time() {
		return this.s_edit_time;
	}
	
	public void setS_edit_time(String s_edit_time) {
		this.s_edit_time = s_edit_time;
	}
	
	public String getS_del_flag() {
		return this.s_del_flag;
	}
	
	public void setS_del_flag(String s_del_flag) {
		this.s_del_flag = s_del_flag;
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
			"homework_id : " + s_homework_id + "," +
			"homework_name : " + s_homework_name + "," +
			"homework_course : " + s_homework_course + "," +
			"homework_request : " + s_homework_request + "," +
			"create_time : " + s_create_time + "," +
			"edit_time : " + s_edit_time + "," +
			"del_flag : " + s_del_flag + "," +
			"user_no : " + s_user_no + 
		"}";
	}
}



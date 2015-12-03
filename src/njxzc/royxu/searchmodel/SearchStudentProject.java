package njxzc.royxu.searchmodel;

//查询StudentProject类
public class SearchStudentProject {
	private String s_stu_proj_id;// 项目主键id
	private String s_stu_proj_name;// 项目名称
	private String s_stu_proj_type;// 项目类型
	private String s_stu_proj_rank;// 项目级别
	private String s_main_students;// 项目负责人
	private String s_proj_members;// 项目成员
	private String s_teachers;// 指导老师
	private String s_proj_results;// 项目成果
	private String s_user_no;// 所属人员编号
	
	public String getS_stu_proj_id() {
		return this.s_stu_proj_id;
	}
	
	public void setS_stu_proj_id(String s_stu_proj_id) {
		this.s_stu_proj_id = s_stu_proj_id;
	}
	
	public String getS_stu_proj_name() {
		return this.s_stu_proj_name;
	}
	
	public void setS_stu_proj_name(String s_stu_proj_name) {
		this.s_stu_proj_name = s_stu_proj_name;
	}
	
	public String getS_stu_proj_type() {
		return this.s_stu_proj_type;
	}
	
	public void setS_stu_proj_type(String s_stu_proj_type) {
		this.s_stu_proj_type = s_stu_proj_type;
	}
	
	public String getS_stu_proj_rank() {
		return this.s_stu_proj_rank;
	}
	
	public void setS_stu_proj_rank(String s_stu_proj_rank) {
		this.s_stu_proj_rank = s_stu_proj_rank;
	}
	
	public String getS_main_students() {
		return this.s_main_students;
	}
	
	public void setS_main_students(String s_main_students) {
		this.s_main_students = s_main_students;
	}
	
	public String getS_proj_members() {
		return this.s_proj_members;
	}
	
	public void setS_proj_members(String s_proj_members) {
		this.s_proj_members = s_proj_members;
	}
	
	public String getS_teachers() {
		return this.s_teachers;
	}
	
	public void setS_teachers(String s_teachers) {
		this.s_teachers = s_teachers;
	}
	
	public String getS_proj_results() {
		return this.s_proj_results;
	}
	
	public void setS_proj_results(String s_proj_results) {
		this.s_proj_results = s_proj_results;
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
			"stu_proj_id : " + s_stu_proj_id + "," +
			"stu_proj_name : " + s_stu_proj_name + "," +
			"stu_proj_type : " + s_stu_proj_type + "," +
			"stu_proj_rank : " + s_stu_proj_rank + "," +
			"main_students : " + s_main_students + "," +
			"proj_members : " + s_proj_members + "," +
			"teachers : " + s_teachers + "," +
			"proj_results : " + s_proj_results + "," +
			"user_no : " + s_user_no + 
		"}";
	}
}



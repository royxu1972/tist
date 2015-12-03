package njxzc.royxu.searchmodel;

//查询Course类
public class SearchCourse {
	private String s_course_id;// 项目主键id
	private String s_course_name;// 课程名称
	private String s_course_grades;// 授课年级
	private String s_course_length;// 课时
	private String s_course_intro;// 课程介绍
	private String s_course_outline;// 课程大纲
	private String s_user_no;// 所属人员编号
	
	public String getS_course_id() {
		return this.s_course_id;
	}
	
	public void setS_course_id(String s_course_id) {
		this.s_course_id = s_course_id;
	}
	
	public String getS_course_name() {
		return this.s_course_name;
	}
	
	public void setS_course_name(String s_course_name) {
		this.s_course_name = s_course_name;
	}
	
	public String getS_course_grades() {
		return this.s_course_grades;
	}
	
	public void setS_course_grades(String s_course_grades) {
		this.s_course_grades = s_course_grades;
	}
	
	public String getS_course_length() {
		return this.s_course_length;
	}
	
	public void setS_course_length(String s_course_length) {
		this.s_course_length = s_course_length;
	}
	
	public String getS_course_intro() {
		return this.s_course_intro;
	}
	
	public void setS_course_intro(String s_course_intro) {
		this.s_course_intro = s_course_intro;
	}
	
	public String getS_course_outline() {
		return this.s_course_outline;
	}
	
	public void setS_course_outline(String s_course_outline) {
		this.s_course_outline = s_course_outline;
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
			"course_id : " + s_course_id + "," +
			"course_name : " + s_course_name + "," +
			"course_grades : " + s_course_grades + "," +
			"course_length : " + s_course_length + "," +
			"course_intro : " + s_course_intro + "," +
			"course_outline : " + s_course_outline + "," +
			"user_no : " + s_user_no + 
		"}";
	}
}



package njxzc.royxu.searchmodel;

//查询ScienceProject类
public class SearchScienceProject {
	private String s_proj_id;// 项目主键id
	private String s_proj_name;// 项目名称
	private String s_proj_origin;// 项目来源
	private String s_start_date;// 开始日期
	private String s_end_date;// 结束日期
	private String s_proj_fund;// 项目经费
	private String s_my_work;// 我承担的工作
	private String s_proj_info;// 项目介绍
	private String s_user_no;// 所属人员编号
	
	public String getS_proj_id() {
		return this.s_proj_id;
	}
	
	public void setS_proj_id(String s_proj_id) {
		this.s_proj_id = s_proj_id;
	}
	
	public String getS_proj_name() {
		return this.s_proj_name;
	}
	
	public void setS_proj_name(String s_proj_name) {
		this.s_proj_name = s_proj_name;
	}
	
	public String getS_proj_origin() {
		return this.s_proj_origin;
	}
	
	public void setS_proj_origin(String s_proj_origin) {
		this.s_proj_origin = s_proj_origin;
	}
	
	public String getS_start_date() {
		return this.s_start_date;
	}
	
	public void setS_start_date(String s_start_date) {
		this.s_start_date = s_start_date;
	}
	
	public String getS_end_date() {
		return this.s_end_date;
	}
	
	public void setS_end_date(String s_end_date) {
		this.s_end_date = s_end_date;
	}
	
	public String getS_proj_fund() {
		return this.s_proj_fund;
	}
	
	public void setS_proj_fund(String s_proj_fund) {
		this.s_proj_fund = s_proj_fund;
	}
	
	public String getS_my_work() {
		return this.s_my_work;
	}
	
	public void setS_my_work(String s_my_work) {
		this.s_my_work = s_my_work;
	}
	
	public String getS_proj_info() {
		return this.s_proj_info;
	}
	
	public void setS_proj_info(String s_proj_info) {
		this.s_proj_info = s_proj_info;
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
			"proj_id : " + s_proj_id + "," +
			"proj_name : " + s_proj_name + "," +
			"proj_origin : " + s_proj_origin + "," +
			"start_date : " + s_start_date + "," +
			"end_date : " + s_end_date + "," +
			"proj_fund : " + s_proj_fund + "," +
			"my_work : " + s_my_work + "," +
			"proj_info : " + s_proj_info + "," +
			"user_no : " + s_user_no + 
		"}";
	}
}



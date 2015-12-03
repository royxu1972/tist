package njxzc.royxu.searchmodel;

//查询Award类
public class SearchAward {
	private String s_award_id;// 荣誉主键id
	private String s_award_name;// 荣誉名称
	private String s_award_unit;// 颁发单位
	private String s_award_date;// 颁发日期
	private String s_award_rank;// 荣誉级别
	private String s_user_no;// 所属人员编号
	
	public String getS_award_id() {
		return this.s_award_id;
	}
	
	public void setS_award_id(String s_award_id) {
		this.s_award_id = s_award_id;
	}
	
	public String getS_award_name() {
		return this.s_award_name;
	}
	
	public void setS_award_name(String s_award_name) {
		this.s_award_name = s_award_name;
	}
	
	public String getS_award_unit() {
		return this.s_award_unit;
	}
	
	public void setS_award_unit(String s_award_unit) {
		this.s_award_unit = s_award_unit;
	}
	
	public String getS_award_date() {
		return this.s_award_date;
	}
	
	public void setS_award_date(String s_award_date) {
		this.s_award_date = s_award_date;
	}
	
	public String getS_award_rank() {
		return this.s_award_rank;
	}
	
	public void setS_award_rank(String s_award_rank) {
		this.s_award_rank = s_award_rank;
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
			"award_id : " + s_award_id + "," +
			"award_name : " + s_award_name + "," +
			"award_unit : " + s_award_unit + "," +
			"award_date : " + s_award_date + "," +
			"award_rank : " + s_award_rank + "," +
			"user_no : " + s_user_no + 
		"}";
	}
}


